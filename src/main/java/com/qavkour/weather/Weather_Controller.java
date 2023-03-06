package com.qavkour.weather;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Weather_Controller {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField city_field;

	@FXML
	private Label feels_like;

	@FXML
	private Label max;

	@FXML
	private Label min;

	@FXML
	private Label pressure;

	@FXML
	private Label speed_wind;

	@FXML
	private Label temperature;

	@FXML
	private Button weather_btn;

	@FXML
	void initialize() {
		weather_btn.setOnAction(event -> getWeather());
	}

	private void getWeather() {
	}

}
