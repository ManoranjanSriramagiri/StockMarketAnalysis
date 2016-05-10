package org.stockmaketprediction.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.stockmaketprediction.model.BiggestGainerStock;
import org.stockmaketprediction.neuralnetwork.NeuralNetworkStockPredictor;
import org.stockmaketprediction.util.InputCSVFileWatcher;

public class NeuralNetworkStockPredictorController {

	public static HashMap<String, String> neuralNetworkStockDetails = new HashMap<>();

	// public static void main(String[] args) throws Exception {
	public void neuralNetworkStockPredict() throws Exception {
		HashMap<String, Double> neuralNetworkHM = new HashMap<>();
		double resNeu = 0.0;

		InputCSVFileWatcher icsFileWatcherNeural = new InputCSVFileWatcher();
		String[] compNameNeural = icsFileWatcherNeural.getCompNameNeural();
		String[] fileNameNeural = icsFileWatcherNeural.getFileNameNeural();

		for (int i = 0; i < fileNameNeural.length; i++) {
			NeuralNetworkStockPredictor nnStockPredict = new NeuralNetworkStockPredictor();

			resNeu = nnStockPredict.neuralNetworkStockMarketPredictor(5, fileNameNeural[i]);

			neuralNetworkHM.put(compNameNeural[i], resNeu);
			// System.out.println(" @@ compname "+ comName+" NEURAL VAL
			// "+resNeu);
		}

		Iterator it = neuralNetworkHM.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			neuralNetworkStockDetails.put((String) pair.getKey(), "" + pair.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}

	}
}
