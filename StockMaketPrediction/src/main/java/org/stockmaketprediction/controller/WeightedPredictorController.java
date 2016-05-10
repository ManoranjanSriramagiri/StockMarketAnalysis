package org.stockmaketprediction.controller;

import java.awt.List;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.stockmaketprediction.model.StockObject;
import org.stockmaketprediction.util.InputCSVFileRead;
import org.stockmaketprediction.util.InputCSVFileWatcher;

import scala.collection.immutable.HashMap;

public class WeightedPredictorController {

	// public void weightedPrediction(){
	// public static void main(String[] args) throws Exception{
	public static ArrayList<StockObject> stockList = new ArrayList<>();

	static ArrayList<Double> biggestGainer = new ArrayList<>();
	static ArrayList<Double> biggestLoserStock = new ArrayList<>();

	static ArrayList<Double> avgModelAuuracy = new ArrayList<>();

	public void weightedPrediction() throws Exception {
		// ArrayList<StockObject> stockList = new ArrayList<>();

		DecisionTreeRegressorController xy = new DecisionTreeRegressorController();
		xy.decisionTRCGetData();

		RandomForestPredictorController rf = new RandomForestPredictorController();
		rf.randomForestCalculation();

		System.out.println("\n \n @@@@@ DECISION TREE HM " + DecisionTreeRegressorController.decisionTreeHM);
		System.out.println("\n \n @@@@@ RandomForestPredictor HM " + RandomForestPredictorController.randomForestHM);

		InputCSVFileWatcher icsvFW = new InputCSVFileWatcher();

		String[] compNameDT = new String[icsvFW.getCompNameDTR().length];
		String[] compValueDT = new String[icsvFW.getCompNameDTR().length];

		int i = 0;
		Iterator<String> itrDTR = DecisionTreeRegressorController.decisionTreeHM.keySet().iterator();
		while (itrDTR.hasNext()) {
			String key = (String) itrDTR.next();
			String value = DecisionTreeRegressorController.decisionTreeHM.get(key);
			System.out.println(key + " " + value);

			compNameDT[i] = key;
			compValueDT[i] = value;
			i++;
		}

		String[] compNameRF = new String[icsvFW.getCompNameRF().length];
		String[] valueRF = new String[icsvFW.getFileNameRF().length];

		int j = 0;
		Iterator<String> itrRF = RandomForestPredictorController.randomForestHM.keySet().iterator();
		while (itrRF.hasNext()) {
			String key = (String) itrRF.next();
			String value = RandomForestPredictorController.randomForestHM.get(key);
			System.out.println(key + " " + value);

			compNameRF[j] = key;
			valueRF[j] = value;
			j++;
		}

		for (int k = 0; k < valueRF.length; k++) {
			System.out.println("\n @@@@ compName[i] " + compNameDT[k] + "  DTcompValue[i] " + compValueDT[k]);
			System.out.println("\n @@@@ compNameRF[j] " + compNameRF[k] + "  valueRF[j] " + valueRF[k]);
			String[] splitData = valueRF[k].split(" ");

			double pa = Double.parseDouble(compValueDT[k]);
			DecimalFormat df = new DecimalFormat("#.#####");
			String predictAmount = df.format(pa);

			double modelaccurecy = Double.parseDouble(splitData[2]);

			avgModelAuuracy.add(modelaccurecy);

			DecimalFormat dfmodelaccu = new DecimalFormat("#.#########");
			// String modelAccu = splitData[2].substring(0);
			String modelAccu = dfmodelaccu.format(modelaccurecy);

			StockObject so = new StockObject();
			so.setCompName(compNameDT[k]);
			so.setPrediction(splitData[0]);
			so.setPredictAmount(predictAmount);
			so.setAccuracy(modelAccu);

			if (splitData[0].equalsIgnoreCase("UP"))
				biggestGainer.add(pa);

			if (splitData[0].equalsIgnoreCase("DOWN"))
				biggestLoserStock.add(pa);

			String filePath = "";

			String[] compN = icsvFW.getFileNameRF();
			for (int l = 0; l < compN.length; l++) {
				System.out.println("/n/n/n ***** ----> compN : " + compN[l]);
				if (compNameDT[k].equalsIgnoreCase("CISCO"))
					filePath = "data//EOD-CSCO.csv";
				else if (compNameDT[k].equalsIgnoreCase("MICROSOFT"))
					filePath = "data//EOD-MSFT.csv";
				else if (compNameDT[k].equalsIgnoreCase("GOOGLE"))
					filePath = "data//EOD-GOOGL.csv";
				else if (compNameDT[k].equalsIgnoreCase("APPLE"))
					filePath = "data//EOD-AAPL.csv";
				else if (compNameDT[k].equalsIgnoreCase("IBM"))
					filePath = "data//EOD-IBM.csv";
				else if (compNameDT[k].equalsIgnoreCase("FACEBOOK"))
					filePath = "data//EOD-FB.csv";
				else if (compNameDT[k].equalsIgnoreCase("VARIAN"))
					filePath = "data//EOD-VAR.csv";
				else if (compNameDT[k].equalsIgnoreCase("INTUIT"))
					filePath = "data//EOD-INTU.csv";
			}

			
			
			InputCSVFileRead icsv = new InputCSVFileRead();
			System.out.println("/n/n/n ***** @@@@@@@ FILE SENDING compN[k] -->>" + compN[k]);

			double closePrice = icsv.getPrevDayClosePrice(filePath);
			so.setPrevDayPrice("" + closePrice);

			double rise = (Double.parseDouble(predictAmount));
			if (splitData[0].equalsIgnoreCase("DOWN"))
				rise = ((100.0 - rise) / 100);
			else
				rise = ((100.0 + rise) / 100);
			
			double newForecastPrice = closePrice * (rise);

			DecimalFormat dfore = new DecimalFormat("#.##");
			String pFore = dfore.format(newForecastPrice);
			so.setNextDayForecasrPrice("" + pFore);

			double deviate = newForecastPrice - closePrice;

			DecimalFormat deviateDfore = new DecimalFormat("#.####");
			String deviateDforeRES = deviateDfore.format(deviate);
			String symbol = "";
			if (splitData[0].equalsIgnoreCase("UP"))
				symbol = "+";
			else
				symbol = "-";
			so.setDeviation("" + symbol + " " + deviateDforeRES + " $");

			stockList.add(so);
		}

	}
}
