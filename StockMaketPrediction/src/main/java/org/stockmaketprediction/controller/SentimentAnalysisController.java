package org.stockmaketprediction.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.stockmaketprediction.model.AnalysisStock;
import org.stockmaketprediction.model.StockObject;
import org.stockmaketprediction.model.TwitterAnalysisData;
import org.stockmaketprediction.sentimentanalysis.NLP;
import org.stockmaketprediction.sentimentanalysis.TweetManager;
import org.stockmaketprediction.util.InputCSVFileWatcher;

public class SentimentAnalysisController {

	public static ArrayList<TwitterAnalysisData> twitterDataList = new ArrayList<>();

	public List<TwitterAnalysisData> getCompanySpecificTwitterDetails() {
		InputCSVFileWatcher ics = new InputCSVFileWatcher();
		String[] compName = ics.getCompNameTwitter();
		String[] tweetHandle = ics.getTwitterHandleCompany();

		for (int i = 0; i < compName.length; i++) {

			TwitterAnalysisData tad = new TwitterAnalysisData();
	
			tad.setCompName(compName[i]);

			ArrayList<String> tweetsArrayList = TweetManager.getTweets(tweetHandle[i]);

			
			ArrayList<String> tweetsNew = tweetsArrayList;
			int[] tweetSentiNew = new int[tweetsNew.size()];
			NLP.init();
			int iN = 0;

			for (String tweet : tweetsNew) {
				tweetSentiNew[iN] = NLP.findSentiment(tweet);
				iN++;
			}
			
			
			
			List<String> tweets = getTweetsCompany(compName[i], tweetHandle[i], tweetsArrayList);
			tad.setTweets(tweets);

			String totalSentiment = getTotalSentiment(compName[i], tweetHandle[i], tweetsArrayList);
			tad.setTotalSentiment(totalSentiment);

			String hotnessPercent = getHotnessPercent(compName[i], tweetHandle[i], tweetsArrayList, tweetSentiNew);
			tad.setHotnessPercent(hotnessPercent);

			String avgSentiment = getAverageSentiment(compName[i], tweetHandle[i], tweetsArrayList, tweetSentiNew);
			tad.setAverageSentiment(avgSentiment);

			String momentum = getMomentum(compName[i], tweetHandle[i], tweetsArrayList);
			tad.setMomentum(momentum);

			twitterDataList.add(tad);
		}
		return twitterDataList;
	}

	private String getMomentum(String compName, String tweetHandle, ArrayList<String> tweetsArrayList) {
		// TODO Auto-generated method stub
		ArrayList<String> tweets = tweetsArrayList;

//		int[] tweetSenti = new int[tweets.size()];
//		NLP.init();
//		int i = 0;
//		int sum = 0;
//		double sumD = 0.0;
//
//		for (String tweet : tweets) {
//			tweetSenti[i] = NLP.findSentiment(tweet);
//			i++;
//		}
//		for (int j = 0; j < tweetSenti.length; j++) {
//			sum += tweetSenti[j];
//			sumD += tweetSenti[j];
//			// System.out.print(" " + tweetSenti[j]);
//		}

		String momentum = "" + tweets.size();
		return momentum;
	}

	private String getAverageSentiment(String compName, String tweetHandle, ArrayList<String> tweetsArrayList, int[] tweetSentiNew) {
		// TODO Auto-generated method stub
		ArrayList<String> tweets = tweetsArrayList;
		// System.out.println("Twitter Array Size " + tweets.size());

		int[] tweetSenti = new int[tweetSentiNew.length];
//		NLP.init();
//		int i = 0;
//		int sum = 0;
//		double sumD = 0.0;

		int i = 0;
		int sum = 0;
		double sumD = 0.0;

		int senti = 0;
		for (int j = 0; j < tweetSentiNew.length; j++) {
			tweetSenti[j] = tweetSentiNew[j];
		}
		
//		for (String tweet : tweets) {
//			tweetSenti[i] = NLP.findSentiment(tweet);
//			i++;
//		}
		for (int j = 0; j < tweetSenti.length; j++) {
			sum += tweetSenti[j];
			sumD += tweetSenti[j];
			// System.out.print(" " + tweetSenti[j]);
		}

		String avgSentiment = "" + 0;
		if (tweets.size() > 0)
			avgSentiment = "" + (sumD / tweets.size());

		return avgSentiment;
	}

	private String getHotnessPercent(String compName, String tweetHandle, ArrayList<String> tweetsArrayList, int[] tweetSentiNew) {
		ArrayList<String> tweets = tweetsArrayList;
		System.out.println("Twitter Array Size " + tweets.size());

		int[] tweetSenti = new int[tweetSentiNew.length];
		
		int i = 0;
		int sum = 0;
		double sumD = 0.0;

		int senti = 0;
		for (int j = 0; j < tweetSentiNew.length; j++) {
			tweetSenti[j] = tweetSentiNew[j];
		}
//		for (String tweet : tweets) {
//			senti = NLP.findSentiment(tweet);
//			// System.out.println(" -->> " + tweet + " -->> " + senti);
//			// sum = NLP.findSentiment(tweet);
//			tweetSenti[i] = senti;
//			i++;
//		}
		for (int j = 0; j < tweetSenti.length; j++) {
			sum += tweetSenti[j];
			sumD += tweetSenti[j];
			// System.out.print(" " + tweetSenti[j]);
		}

		// System.out.println();
		// System.out.println(" SUM " + sum + " Total Sentiment " +
		// (tweets.size() * 3) + " Hotness percent "
		// + ((sum * 100) / (tweets.size() * 3)));
		String hotnessPercent = "" + 0;

		if (tweets.size() > 0)
			hotnessPercent = "" + ((sum * 100) / (tweets.size() * 3));
		return hotnessPercent;
	}

	private String getTotalSentiment(String compName, String tweetHandle, ArrayList<String> tweetsArrayList) {
		// TODO Auto-generated method stub

		ArrayList<String> tweets = tweetsArrayList;
		System.out.println("Twitter Array Size " + tweets.size());

//		int[] tweetSenti = new int[tweets.size()];
//		NLP.init();
//		int i = 0;
//
//		int sum = 0;
//		double sumD = 0.0;
//
//		int senti = 0;
//		for (String tweet : tweets) {
//			senti = NLP.findSentiment(tweet);
//			// System.out.println(" -->> " + tweet + " -->> " + senti);
//			tweetSenti[i] = senti;
//			i++;
//		}
//
//		for (int j = 0; j < tweetSenti.length; j++) {
//			sum += tweetSenti[j];
//			sumD += tweetSenti[j];
//			// System.out.print(" " + tweetSenti[j]);
//		}

		// System.out.println();
		// System.out.println(" SUM " + sum + " Total Sentiment " +
		// (tweets.size() * 3) + " Hotness percent "
		// + ((sum * 100) / (tweets.size() * 3)));
		String sentiSize = "" + tweets.size() * 3;
		return sentiSize;
	}

	private List<String> getTweetsCompany(String compName, String tweetHandle, ArrayList<String> tweetsArrayList) {
		// TODO Auto-generated method stub
		String topic = tweetHandle;
		ArrayList<String> tweets = tweetsArrayList;

		List<String> tweetRet = new ArrayList<>();
		NLP.init();

		System.out.println("Twitter Array Size  tweets.size " + tweets.size());

		int senti = 0;
		for (String tweet : tweets) {
			senti = NLP.findSentiment(tweet);
			System.out.println(" -->> " + tweet + " -->> " + senti);
			// sum = NLP.findSentiment(tweet);
			tweetRet.add(tweet);
		}

		return tweetRet;
	}
}
