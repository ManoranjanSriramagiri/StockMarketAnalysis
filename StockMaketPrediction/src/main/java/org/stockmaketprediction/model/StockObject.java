package org.stockmaketprediction.model;

public class StockObject {

	String compName;
	String prediction;
	String predictAmount;
	String accuracy;

	String prevDayPrice;
	String nextDayForecastedPrice;
	String deviation;

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getPrediction() {
		return prediction;
	}

	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}

	public String getPredictAmount() {
		return predictAmount;
	}

	public void setPredictAmount(String predictAmount) {
		this.predictAmount = predictAmount;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getPrevDayPrice() {
		return prevDayPrice;
	}

	public void setPrevDayPrice(String prevDayPrice) {
		this.prevDayPrice = prevDayPrice;
	}

	public String getNextDayForecasrPrice() {
		return nextDayForecastedPrice;
	}

	public void setNextDayForecasrPrice(String nextDayForecasrPrice) {
		this.nextDayForecastedPrice = nextDayForecasrPrice;
	}

	public String getDeviation() {
		return deviation;
	}

	public void setDeviation(String deviation) {
		this.deviation = deviation;
	}

}
