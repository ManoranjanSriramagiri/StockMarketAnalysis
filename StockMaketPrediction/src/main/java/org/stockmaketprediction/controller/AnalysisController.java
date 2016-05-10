package org.stockmaketprediction.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.stockmaketprediction.model.AnalysisStock;
import org.stockmaketprediction.util.InputCSVFileWatcher;

public class AnalysisController {

	// public static void main(String[] args) throws IOException{
	static List<AnalysisStock> asList = new ArrayList<>();

	public List<AnalysisStock> getAnalysedDetails() throws IOException {
		InputCSVFileWatcher ics = new InputCSVFileWatcher();
		String[] comps = ics.getCompNameRF();
		String[] filePaths = ics.getFileNameRF();
		String[] filePathsLabled = ics.getDatapathDTR();

		for (int i = 0; i < comps.length; i++) {
			// System.out.println("COMPS " + comps[i] + " - " + filePaths[i]);
			AnalysisStock as = new AnalysisStock();
			as.setCompanyName(comps[i]);
			// System.out.println(" filePaths[i] "+filePaths[i]);

			as.setAvgStockSold(getAverageStockSoldResult(filePaths[i]));
			// System.out.println( " filePathsLabled[i] "+filePathsLabled[i]);

			as.setNoOfUpDays(noOfDaysUp(filePathsLabled[i]));
			// System.out.println(noOfDaysUp(filePathsLabled[i]));

			as.setNoOfDownDays(noOfDaysStocksDown(filePathsLabled[i]));
			// System.out.println(noOfDaysStocksDown(filePathsLabled[i]));

			as.setFirstQuarterUp(quarterUpPercent(filePathsLabled[i], 1, 6));
			// System.out.println(quarterUpPercent(filePathsLabled[i], 1, 6));

			as.setSecondQuarterUp(quarterUpPercent(filePathsLabled[i], 6, 11));
			// System.out.println(quarterUpPercent(filePathsLabled[i], 6, 11));

			as.setThirdQuarterUp(quarterUpPercent(filePathsLabled[i], 11, 16));
			// System.out.println(quarterUpPercent(filePathsLabled[i], 11, 16));

			as.setFourthQuarterUp(quarterUpPercent(filePathsLabled[i], 16, 21));
			// System.out.println(quarterUpPercent(filePathsLabled[i], 16, 21));

			// avgSumHM.put(comps[i], getAverageStockSoldResult(filePaths[i]));
			asList.add(as);
		}

		return asList;
	}

	private static String quarterUpPercent(String fPath, int start, int step) throws IOException {
		double sum = 0.0;
		List<String> lineList = Files.readAllLines(Paths.get(fPath), StandardCharsets.UTF_8);

		for (int i = start; i < 21; i++) {
			if (i < step) {
				String currentL = lineList.get(i);
				String[] currentLineParts = currentL.split(",");

				int res = (Integer.parseInt(currentLineParts[0]) > 0) ? 1 : 0;

				sum += res;
			}
		}

		double percentRes = sum / 5;
		percentRes = percentRes * 100;
		DecimalFormat format = new DecimalFormat("#00");
		String formattedNumberAvgSum = format.format(percentRes);
		return "" + formattedNumberAvgSum;

	}

	private static String noOfDaysUp(String filePathLabled) throws IOException {

		double sum = 0.0;
		List<String> lineList = Files.readAllLines(Paths.get(filePathLabled), StandardCharsets.UTF_8);

		for (int i = 1; i < lineList.size(); i++) {
			String currentL = lineList.get(i);
			String[] currentLineParts = currentL.split(",");

			int res = (Integer.parseInt(currentLineParts[0]) > 0) ? 1 : 0;

			sum += res;
		}

		double percentRes = sum / lineList.size();
		percentRes = percentRes * 100;
		DecimalFormat format = new DecimalFormat("#00.00");
		String formattedNumberAvgSum = format.format(percentRes);
		return "" + formattedNumberAvgSum ;

	}

	private static String noOfDaysStocksDown(String filePathLabled) throws IOException {

		double sum = 0.0;
		List<String> lineList = Files.readAllLines(Paths.get(filePathLabled), StandardCharsets.UTF_8);

		for (int i = 1; i < lineList.size(); i++) {
			String currentL = lineList.get(i);
			String[] currentLineParts = currentL.split(",");

			int res = (Integer.parseInt(currentLineParts[0]) < 1) ? 1 : 0;

			sum += res;
		}

		double percentRes = sum / lineList.size();
		percentRes = percentRes * 100;
		DecimalFormat format = new DecimalFormat("#00.00");
		String formattedNumberAvgSum = format.format(percentRes);
		return "" + formattedNumberAvgSum ;

	}

	// Helper functions
	private static String getAverageStockSoldResult(String filePath) throws IOException {

		double sum = 0.0;
		List<String> lineList = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);

		for (int i = 1; i < lineList.size(); i++) {
			String currentL = lineList.get(i);
			String[] currentLineParts = currentL.split(",");

			// System.out.println(" currentLineParts[5] "+currentLineParts[5]);
			sum += Double.parseDouble(currentLineParts[5]);

		}

		double res = sum / lineList.size();
		// System.out.println(" RES " + res);
		DecimalFormat format = new DecimalFormat("#000");
		String formattedNumberAvgSum = format.format(res);
		// System.out.println(" formattedNumber " + formattedNumberAvgSum);

		return formattedNumberAvgSum;
	}
}
