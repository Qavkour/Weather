package com.qavkour.weather;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

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
	private Label max_temp;

	@FXML
	private Label min_temp;

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
		Weather weather = new Weather(city_field.getText().trim());

		temperature.setText(weather.getTemperature());
		feels_like.setText(weather.getFeels_like());
		max_temp.setText(weather.getMax_temp());
		min_temp.setText(weather.getMin_temp());
		speed_wind.setText(weather.getSpeed_wind());
		pressure.setText(weather.getPressure());
	}
}
