
package uncc2014watsonsim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.json.simple.JSONObject;

/**
 * @author Phani Rahul
 * @author Sean Gallagher
 */
public class Answer implements Comparable<Answer> {
    public double[] scores = Score.empty();
    private double overall_score = Double.NaN;
    public List<Passage> passages = new ArrayList<>();
    public String candidate_text;

    /**
     * Create an Answer with one implicitly defined Passage
     */
    public Answer(Passage d) {
        this.passages.add(d);
        this.scores = d.scores;
        this.candidate_text = d.title;
    }
    
    public Answer(List<Passage> passages,
    		double[] scores,
    		String candidate_text) {
    	this.passages = passages;
    	this.scores = scores;
    	this.candidate_text = candidate_text;
    }
    
    /**
     * Create an Answer with one implicitly defined Passage
     */
    public Answer(String engine, String title, String full_text, String reference) {
    	this(new Passage(engine, title, full_text, reference));
    }
    
    /**
     * Create an Answer without any passages
     */
    public Answer(String candidate_text) {
    	this.candidate_text = candidate_text;
    }
    
    /** Create an Answer (with engine) from JSON */
	public Answer(String engine, JSONObject attr) {
		this(
			engine,
			(String) attr.get(engine+"_title"),
			"",
			"");
		passages.get(0).score(engine+"_RANK", (double) attr.get(engine+"_rank"));
		passages.get(0).score(engine+"_SCORE", (double) attr.get(engine+"_score"));
	}

    @Override
    /** How to handle inexact matches this way?? */
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.candidate_text);
        return hash;
    }

    /** 
     * Return a threshold on distance
     */
    public boolean matches(Answer other) {
        return distance(other) <= 2;
    }
    
    /** 
     * Return a Levenshtein distance between answers after stopword removal.
     */
    public double distance(Answer other) {
        if (other == null) {
            return 10;
        }
        int dist = StringUtils.getLevenshteinDistance(
        		StringUtils.filterRelevant(candidate_text),
        		StringUtils.filterRelevant(other.candidate_text),
        		10);
        
        return (dist == -1) ? 10 : dist;
    }

    @Override
    public String toString() {
    	// Make a short view of the engines as single-letter abbreviations
    	String engines = "";
    	for (Passage e: this.passages)
    		if (e.engine_name != null)
    			engines += e.engine_name.substring(0, 1);
    	
    	// ResultSet don't know if they are correct anymore..
    	//String correct = isCorrect() ? "✓" : "✗";
    	
    	// Should look like: [0.9998 gil] Flying Waterbuffalos ... 
    	return String.format("[%01f %-3s] %s", getOverallScore(), engines, candidate_text);
    }
    
    public String toJSON() {
    	return String.format("{\"score\": %01f, \"title\": \"%s\"}", getOverallScore(), candidate_text.replace("\"", "\\\""));
    }
    
    /**
     * Return the combined score for the answer, or null
     * */
    public double getOverallScore() {
        return overall_score;
    }
    
    /**
     * Set the combined score for the answer, or null
     * */
    public void setOverallScore(double s) {
        overall_score = s;
    }

    /**
     * Assign a score to this answer. If you want to automatically generate
     * models to go with this score, remember to call Score.registerAnswerScore
     * @param name		The name of the score 
     * @param score		Double value of score (or NaN)
     */
	public void score(String name, double score) {
		scores = Score.set(scores, name, score);
	}
    
    @Override
	public int compareTo(Answer other) {
    	return Double.compare(getOverallScore(), other.getOverallScore());
	}
    
    /** Change this Answer to include all the information of another
     * HACK: We average the scores but we should probably use a
     * pluggable binary operator*/
    public static Answer merge(List<Answer> others) {
        List<Passage> passages = new ArrayList<>();
        String candidate_text;
        
        // Merge all the passages
    	for (Answer other : others)
    		passages.addAll(other.passages);
    	
    	// Merge the scores

    	double[] scores = Score.empty();
    	for (Answer other : others)
    		scores = Score.merge(scores, other.scores);
    	
    	// Pick the first candidate answer
    	candidate_text = others.get(0).candidate_text;
    	
    	// Now make an answer from it
    	return new Answer(passages, scores, candidate_text);
    }
    

}
