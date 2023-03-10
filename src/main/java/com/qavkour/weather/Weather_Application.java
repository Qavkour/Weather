package com.qavkour.weather;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Weather_Application extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Weather_Application.class.getResource("fxml/weather-view.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 590, 575);
		stage.setTitle("Weather");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}