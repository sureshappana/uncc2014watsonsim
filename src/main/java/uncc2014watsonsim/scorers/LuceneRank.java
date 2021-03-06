package uncc2014watsonsim.scorers;

import uncc2014watsonsim.Answer;
import uncc2014watsonsim.Passage;
import uncc2014watsonsim.Question;

/**
 * This scorer is an echo. It is here to take advantage of the dimensionality
 * reduction that comes implicitly as part of scorers.
 * @author Sean
 */
public class LuceneRank extends PassageScorer {
	public double scorePassage(Question q, Answer a, Passage p) {
		return p.score("LUCENE_RANK");
	}
}
