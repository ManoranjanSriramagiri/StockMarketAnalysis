package org.stockmaketprediction.util;

public class InputCSVFileWatcher {

	String[] datapathDTR = { "data//EOD-AAPL-labled.csv", "data//EOD-CSCO-labled.csv", "data//EOD-FB-labled.csv",
			"data//EOD-GOOGL-labled.csv", "data//EOD-IBM-labled.csv", "data//EOD-INTU-labled.csv",
			"data//EOD-MSFT-labled.csv", "data//EOD-VAR-labled.csv" };

	String[] compNameDTR = { "APPLE", "CISCO", "FACEBOOK", "GOOGLE", "IBM", "INTUIT", "MICROSOFT", "VARIAN" };

	public String[] fileNameRF = { "data//EOD-AAPL.csv", "data//EOD-CSCO.csv", "data//EOD-FB.csv",
			"data//EOD-GOOGL.csv", "data//EOD-IBM.csv", "data//EOD-INTU.csv", "data//EOD-MSFT.csv",
			"data//EOD-VAR.csv" };

	public String[] compNameRF = { "APPLE", "CISCO", "FACEBOOK", "GOOGLE", "IBM", "INTUIT", "MICROSOFT", "VARIAN" };

	public String[] fileNameNeural = { "data/input/EOD-AAPL-training.csv", "data/input/EOD-CSCO-training.csv",
			"data/input/EOD-FB-training.csv", "data/input/EOD-GOOGL-training.csv", "data/input/EOD-INTU-training.csv",
			"data/input/EOD-MSFT-training.csv", "data/input/EOD-VAR-training.csv" };

	public String[] compNameNeural = { "APPLE", "CISCO", "FACEBOOK", "GOOGLE", "IBM", "INTUIT", "MICROSOFT", "VARIAN" };

	public String[] compNameTwitter = { "APPLE", "CISCO", "FACEBOOK", "GOOGLE", "IBM", "INTUIT", "MICROSOFT",
			"VARIAN" };

	public String[] twitterHandleCompany = { "$Apple", "$CSCO", "$FB", "$Google", "$IBM", "$INTU", "$MSFT",
			"Varian Medical" };

	public String[] getDatapathDTR() {
		return datapathDTR;
	}

	public void setDatapathDTR(String[] datapathDTR) {
		this.datapathDTR = datapathDTR;
	}

	public String[] getCompNameDTR() {
		return compNameDTR;
	}

	public void setCompNameDTR(String[] compNameDTR) {
		this.compNameDTR = compNameDTR;
	}

	public String[] getFileNameRF() {
		return fileNameRF;
	}

	public void setFileNameRF(String[] fileNameRF) {
		this.fileNameRF = fileNameRF;
	}

	public String[] getCompNameRF() {
		return compNameRF;
	}

	public void setCompNameRF(String[] compNameRF) {
		this.compNameRF = compNameRF;
	}

	public String[] getFileNameNeural() {
		return fileNameNeural;
	}

	public void setFileNameNeural(String[] fileNameNeural) {
		this.fileNameNeural = fileNameNeural;
	}

	public String[] getCompNameNeural() {
		return compNameNeural;
	}

	public void setCompNameNeural(String[] compNameNeural) {
		this.compNameNeural = compNameNeural;
	}

	// twitter specific
	public String[] getCompNameTwitter() {
		return compNameTwitter;
	}

	public void setCompNameTwitter(String[] compNameTwitter) {
		this.compNameTwitter = compNameTwitter;
	}

	public String[] getTwitterHandleCompany() {
		return twitterHandleCompany;
	}

	public void setTwitterHandleCompany(String[] twitterHandleCompany) {
		this.twitterHandleCompany = twitterHandleCompany;
	}
}
