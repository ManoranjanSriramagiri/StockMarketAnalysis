package org.stockmaketprediction.model;

public class AnalysisStock {

	String companyName;
	String avgStockSold;
	String percentOfUpDays;
	String percentOfDownDays;

	String firstQuarterUp;
	String secondQuarterUp;
	String thirdQuarterUp;
	String fourthQuarterUp;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAvgStockSold() {
		return avgStockSold;
	}

	public void setAvgStockSold(String avgStockSold) {
		this.avgStockSold = avgStockSold;
	}

	public String getNoOfUpDays() {
		return percentOfUpDays.substring(0,percentOfUpDays.length()-2);
	}

	public void setNoOfUpDays(String noOfUpDays) {
		this.percentOfUpDays = noOfUpDays;
	}

	public String getNoOfDownDays() {
		return percentOfDownDays;
	}

	public void setNoOfDownDays(String noOfDownDays) {
		this.percentOfDownDays = noOfDownDays;
	}

	public String getFirstQuarterUp() {
		return firstQuarterUp.substring(0,firstQuarterUp.length()-2);
	}

	public void setFirstQuarterUp(String firstQuarterUp) {
		this.firstQuarterUp = firstQuarterUp;
	}

	public String getSecondQuarterUp() {
		return secondQuarterUp.substring(0,secondQuarterUp.length()-2);
	}

	public void setSecondQuarterUp(String secondQuarterUp) {
		this.secondQuarterUp = secondQuarterUp;
	}

	public String getThirdQuarterUp() {
		return thirdQuarterUp.substring(0,thirdQuarterUp.length()-2);
	}

	public void setThirdQuarterUp(String thirdQuarterUp) {
		this.thirdQuarterUp = thirdQuarterUp;
	}

	public String getFourthQuarterUp() {
		return fourthQuarterUp.substring(0,fourthQuarterUp.length()-2);
	}

	public void setFourthQuarterUp(String fourthQuarterUp) {
		this.fourthQuarterUp = fourthQuarterUp;
	}
}
