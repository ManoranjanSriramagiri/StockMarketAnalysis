package org.stockmaketprediction.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.stockmaketprediction.controller.WeightedPredictorController;

public class InputCSVFileRead {

	// public static void main(String[] args) throws Exception{

	public double getPrevDayClosePrice(String filePath) throws IOException {

		double closePrice = 0.0;

		// String line= Files.readAllLines(Paths.get("data//EOD-AAPL.csv"),
		// StandardCharsets.UTF_8).get(1);
		String line = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8).get(1);

		String[] parts = line.split(",");

		int length = parts.length;
		String[] result = new String[length];

		for (int i = 0; i < length; i++) {
			result[i] = (parts[i]);
			System.out.println(" Results - > " + result[i]);
		}

		closePrice = Double.parseDouble(result[4]);

		return closePrice;
	}

}
