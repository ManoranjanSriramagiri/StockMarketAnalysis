package org.stockmaketprediction.model;

import java.util.List;

public class TwitterAnalysisData {
	String compName;
	List<String> tweets;
	String totalSentiment;
	String hotnessPercent;
	String averageSentiment;
	String momentum;

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public List<String> getTweets() {
		return tweets;
	}

	public void setTweets(List<String> tweets) {
		this.tweets = tweets;
	}

	public String getTotalSentiment() {
		return totalSentiment;
	}

	public void setTotalSentiment(String totalSentiment) {
		this.totalSentiment = totalSentiment;
	}

	public String getHotnessPercent() {
		return hotnessPercent;
	}

	public void setHotnessPercent(String hotnessPercent) {
		this.hotnessPercent = hotnessPercent;
	}

	public String getAverageSentiment() {
		return averageSentiment;
	}

	public void setAverageSentiment(String averageSentiment) {
		this.averageSentiment = averageSentiment;
	}

	public String getMomentum() {
		return momentum;
	}

	public void setMomentum(String momentum) {
		this.momentum = momentum;
	}
}
