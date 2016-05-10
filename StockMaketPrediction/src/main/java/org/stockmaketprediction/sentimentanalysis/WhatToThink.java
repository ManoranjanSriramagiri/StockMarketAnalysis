package org.stockmaketprediction.sentimentanalysis;

import java.util.ArrayList;
import java.util.List;

import com.twitter.Extractor;

public class WhatToThink {

	public static void main(String[] args) {

		// public void calculateTweet(String topic) {
		String topic = "$Apple";
		int sum = 0;
		double sumD = 0.0;

		ArrayList<String> tweets = TweetManager.getTweets(topic);
		System.out.println("Twitter Array Size " + tweets.size());

		int[] tweetSenti = new int[tweets.size()];

		NLP.init();

		int i = 0;

		for (String tweet : tweets) {

			System.out.println(" -->> " + tweet + " -->> " + NLP.findSentiment(tweet));
			// sum = NLP.findSentiment(tweet);
			tweetSenti[i] = NLP.findSentiment(tweet);
			i++;
		}

		for (int j = 0; j < tweetSenti.length; j++) {
			sum += tweetSenti[j];
			sumD += tweetSenti[j];
			System.out.print(" " + tweetSenti[j]);
		}
		System.out.println();
		System.out.println(" SUM " + sum + "  Total Sentiment " + (tweets.size() * 3) + " Hotness percent "
				+ ((sum * 100) / (tweets.size() * 3)));

		System.out.println(" Sentiment " + (sumD / tweets.size()) + " Momentum " + tweets.size());
	}
}
