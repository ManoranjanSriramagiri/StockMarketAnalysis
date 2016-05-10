package org.stockmaketprediction;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.stockmaketprediction.controller.AnalysisController;
import org.stockmaketprediction.controller.DecisionTreeRegressorController;
import org.stockmaketprediction.controller.NeuralNetworkStockPredictorController;
import org.stockmaketprediction.controller.RandomForestPredictorController;
import org.stockmaketprediction.controller.SentimentAnalysisController;
import org.stockmaketprediction.controller.WeightedPredictorController;

@SpringBootApplication
public class StockMaketPredictionApplication {

	public static void main(String[] args) throws Exception {

		DecisionTreeRegressorController xy = new DecisionTreeRegressorController();
		xy.decisionTRCGetData();

		RandomForestPredictorController rf = new RandomForestPredictorController();
		rf.randomForestCalculation();

		WeightedPredictorController wpc = new WeightedPredictorController();
		wpc.weightedPrediction();

		NeuralNetworkStockPredictorController npc = new NeuralNetworkStockPredictorController();
		npc.neuralNetworkStockPredict();

		AnalysisController ac = new AnalysisController();
		ac.getAnalysedDetails();

		SentimentAnalysisController sac = new SentimentAnalysisController();
		sac.getCompanySpecificTwitterDetails();

		SpringApplication.run(StockMaketPredictionApplication.class, args);

	}
}
