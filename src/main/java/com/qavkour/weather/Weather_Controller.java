package com.qavkour.weather;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Weather_Controller {
	@FXML
	private Label welcomeText;

	@FXML
	protected void onHelloButtonClick() {
		welcomeText.setText("Welcome to JavaFX Application!");
	}
}