/**
 * 
 */
package uncc2014watsonsim.uima.qAnalysis;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.StringArray;
import org.apache.uima.resource.ResourceInitializationException;

import uncc2014watsonsim.uima.UimaTools;
import uncc2014watsonsim.uima.UimaToolsException;
import uncc2014watsonsim.uima.types.UIMAQuestion;
/**
 * An annotator which searches for the LAT.
 * @author Jonathan Shuman (UIMA and modifications)
 * @author Dhaval Patel (Logic)
 *
 */
public class LATDetectionAnnotator extends  JCasAnnotator_ImplBase {
	/**
	 * Any initializations of data structures/engines (e.g., dictionary) would go into the initialize
	 * method. In this dummy class, we don't actually use an external resource.
	 */
	private POSTaggerME tagger;
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		POSModel model = new POSModelLoader().load(new File("data/en-pos-maxent.bin"));
		tagger = new POSTaggerME(model);
		super.initialize(aContext);
	}

	@Override
	public void process(JCas cas) throws AnalysisEngineProcessException {
		//Get the document text
		String text = cas.getDocumentText();
		UIMAQuestion uimaQuestion;

		try{
			uimaQuestion = UimaTools.getSingleton(cas, UIMAQuestion.type);
		}catch(UimaToolsException e){
			System.out.println("Creating UIMA Question CAS");
			uimaQuestion = new UIMAQuestion(cas);
			uimaQuestion.addToIndexes();
		}
		try{
			uimaQuestion = doLatDetection(uimaQuestion, text);
		}catch(AnalysisEngineProcessException e){
			throw e;
		}
	}

	//Do work
	private UIMAQuestion doLatDetection(UIMAQuestion uimaQuestion, String text) throws AnalysisEngineProcessException{
		// Load the training model for POSTagging


		// Query sentence
		//String sample = "It is what Daedalus used to hold the feathers together in the wings he made for himself & his son .";

		ObjectStream<String> lineStream = new PlainTextByLineStream(
				new StringReader(text));

		String line;
		ArrayList<Integer> thisPlaces = new ArrayList<Integer>();
		ArrayList<Integer> thePlaces = new ArrayList<Integer>();
		ArrayList<Integer> itPlaces = new ArrayList<Integer>();
		ArrayList<Integer> nounThisPlaces = new ArrayList<Integer>();
		ArrayList<Integer> nounThePlaces = new ArrayList<Integer>();
		ArrayList<Integer> nounItPlaces = new ArrayList<Integer>();
		boolean rule1Satisfied = false;
		boolean rule2Satisfied = false;
		String ansShouldBe = null;
		int sentenceLength = 0;
		String[] tags = {};

		int nounIndex = -1;
		try {
			while ((line = lineStream.read()) != null) {

				String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE
						.tokenize(line);
				tags = tagger.tag(whitespaceTokenizerLine);

				sentenceLength = whitespaceTokenizerLine.length;
				// Rule 1 : 'this' Rule
				for (int i = 0; i < sentenceLength; i++) // Loop
					// through
					// all
					// tokens
				{
					if (whitespaceTokenizerLine[i].toLowerCase().equals("this")
							|| whitespaceTokenizerLine[i].toLowerCase().equals("these")) 
						// Check if 'this' or 'these'
					{
						if (tags[i].equals("DT")) // confirm they are DT-determiner
						{
							// System.out.println("This/These + DT at ->"+i);

							thisPlaces.add(i);
							nounThisPlaces.add(-1);
						}
					}
				}

				if (thisPlaces.size() != 0) // check if 'this' detected
				{
					for (int i = 0; i < thisPlaces.size(); i++) // for each 'this'
					{

						if ((thisPlaces.get(i) + 2) != sentenceLength) // check
							// if
							// 'this'
							// is
							// at
							// end
						{

							for (int j = thisPlaces.get(i) + 1; j < sentenceLength; j++) // go
								// till
								// end
								// of
								// the
								// sentence
							{

								if (tags[j].equals("NN") || tags[j].equals("NNS")
										|| tags[j].equals("NNP")
										|| tags[j].equals("NNPS")) {

									nounIndex = j;
								} else if (tags[j].equals("VB")
										|| tags[j].equals("VBD")
										|| tags[j].equals("VBG")
										|| tags[j].equals("VBN")
										|| tags[j].equals("VBP")
										|| tags[j].equals("VBZ")
										|| tags[j].equals("IN")
										|| tags[j].equals("WDT")
										|| tags[j].equals("WP")
										|| tags[j].equals("WP$")
										|| tags[j].equals("WRB")
										|| tags[j].equals(".")
										|| tags[j].equals(",")) {

									nounThisPlaces.set(i, nounIndex);
									break;
								}
							}
						} else {

							if (tags[sentenceLength - 3].equals("VB")
									|| tags[sentenceLength - 3].equals("VBD")
									|| tags[sentenceLength - 3].equals("VBG")
									|| tags[sentenceLength - 3].equals("VBN")
									|| tags[sentenceLength - 3].equals("VBP")
									|| tags[sentenceLength - 3].equals("VBZ"))


								ansShouldBe = "Verb";
							rule1Satisfied = true;
						}
					}
				}

				//System.out.println(thisPlaces.size() + "'this' detected ");
				if (thisPlaces.size() >= 1) {
					for (int i = 0; i < thisPlaces.size(); i++) {
						if (nounThisPlaces.get(i) != -1) {

							ansShouldBe = whitespaceTokenizerLine[nounThisPlaces
							                                      .get(i)];
							rule1Satisfied = true;
						}
					}
				}

				// Rule 2 : 'The' ___________### 'of' -> ### is what we are looking
				// for
				if (!rule1Satisfied) {
					for (int i = 0; i < sentenceLength; i++) // Loop
						// through
						// all
						// tokens
					{
						if (whitespaceTokenizerLine[i].toLowerCase().equals("the"))
						{
							if (tags[i].equals("DT")) // confirm they are
								// DT-determiner
							{
								// System.out.println("This/These + DT at ->"+i);
								thePlaces.add(i);
								nounThePlaces.add(-1);
							}
						}
					}

					if (thePlaces.size() != 0) // check if 'this' detected
					{
						for (int i = 0; i < thePlaces.size(); i++) // for each
							// 'this'
						{
							//System.out.println("The place " + thePlaces.get(i));
							if (thePlaces.get(i) == 0
									|| tags[thePlaces.get(i) - 1] == ","
									|| tags[thePlaces.get(i) - 1] == ";"
									|| tags[thePlaces.get(i) - 1] == ".") {
								for (int j = thePlaces.get(i) + 1; j < sentenceLength; j++) // go
									// till
									// end
									// of
									// the
									// sentence
								{

									if (tags[j].equals("NN")
											|| tags[j].equals("NNS")
											|| tags[j].equals("NNP")
											|| tags[j].equals("NNPS")) {

										nounIndex = j;
									} else if (whitespaceTokenizerLine[j]
											.equals("of")
											|| whitespaceTokenizerLine[j]
													.equals("Of")
													|| whitespaceTokenizerLine[j]
															.equals("OF")

															|| tags[j].equals("WDT")
															|| tags[j].equals("WP")
															|| tags[j].equals("WP$")
															|| tags[j].equals("WRB")) {


										nounThePlaces.set(i, nounIndex);
										// System.out.println("Here");
										break;
									}
								}
							}
						}

						if (thePlaces.size() >= 1) {
							for (int i = 0; i < thePlaces.size(); i++) {

								if (nounThePlaces.get(i) != -1) {

									ansShouldBe = whitespaceTokenizerLine[nounThePlaces.get(i)];
									rule2Satisfied = true;
								}
							}
						}
					}
				}
				// System.out.println(tags[0]);

				// Rule 3 : it is where -> place, it is what-> Noun
				if (!rule2Satisfied) {
					for (int i = 0; i < sentenceLength; i++) // Loop
						// through
						// all
						// tokens
					{

						if (whitespaceTokenizerLine[i].toLowerCase().equals("it"))
						{

							if (tags[i].equals("PRP") || tags[i].equals("PRP$")) // confirm
								// they
								// are
								// DT-determiner
							{

								// System.out.println("This/These + DT at ->"+i);
								itPlaces.add(i);
								nounItPlaces.add(-1);
							}
						}
					}

					if (itPlaces.size() != 0) // check if 'this' detected
					{

						for (int i = 0; i < itPlaces.size() - 1; i++) // for each
							// 'this'
						{

							if (tags[itPlaces.get(i) + 1].equals("VB")
									|| tags[itPlaces.get(i) + 1].equals("VBD")
									|| tags[itPlaces.get(i) + 1].equals("VBG")
									|| tags[itPlaces.get(i) + 1].equals("VBN")
									|| tags[itPlaces.get(i) + 1].equals("VBP")
									|| tags[itPlaces.get(i) + 1].equals("VBZ")) {
								if(i == itPlaces.size() - 2){
									break;
								}
								if (whitespaceTokenizerLine[itPlaces.get(i) + 2]
										.toLowerCase().equals("where")) {
									//System.out.println("Answer should be a'Place'");
									ansShouldBe = "Place";
								} else if (whitespaceTokenizerLine[itPlaces.get(i) + 2]
										.toLowerCase().equals("what")) {

									//System.out.println("Answer should be a'Noun'");
									ansShouldBe = "Noun";
								}

							}
						}
					}
				}

				//POSSample samplepos = new POSSample(whitespaceTokenizerLine, tags);
				//System.out.println(samplepos.toString());
				//System.out.println("Answer should be a/an '"+ansShouldBe+"'");


			}
		} catch (Exception e) {
			throw new AnalysisEngineProcessException(e);
		}

		if(ansShouldBe == null){
			ansShouldBe = "null";
		}
		StringArray sArray;
		try {
			sArray = new StringArray(uimaQuestion.getCAS().getJCas(), tags.length);
			sArray.copyFromArray(tags, 0, 0, tags.length);
			uimaQuestion.setQueryParse(sArray);
		} catch (CASException e) {
			System.err.println("Cas Exception: The parse will not be saved.");
		}

		uimaQuestion.setLAT(ansShouldBe);
		return uimaQuestion;
	}

}
