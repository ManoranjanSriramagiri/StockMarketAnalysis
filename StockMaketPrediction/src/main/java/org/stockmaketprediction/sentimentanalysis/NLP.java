package org.stockmaketprediction.sentimentanalysis;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class NLP {
	static StanfordCoreNLP pipeline;

	public static void init() {
		pipeline = new StanfordCoreNLP("MyPropFile.properties");
	}

	public static int findSentiment(String tweet) {

		String[] sentimentText = { "Very Negative", "Negative", "Neutral", "Positive", "Very Positive" };

		int mainSentiment = 0;

		if (tweet != null && tweet.length() > 0) {
			int longest = 0;
			Annotation annotation = pipeline.process(tweet);

			for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
				Tree tree = sentence.get(SentimentCoreAnnotations.AnnotatedTree.class);
				// Tree tree = sentence.get(SentimentAnnotatedTree.class);

				int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
				String partText = sentence.toString();
				// System.out.println("@@@@@@ partText "+partText);

				if (partText.length() > longest) {
					mainSentiment = sentiment;
					longest = partText.length();
				}
			}

			System.out.println(" mainSentiment " + mainSentiment);

		}
		return mainSentiment;
	}
}
