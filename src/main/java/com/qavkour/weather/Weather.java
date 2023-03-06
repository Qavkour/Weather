package com.qavkour.weather;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class Weather {
	private final String urlAddress;
	private String temperature = "";
	private String feels_like = "";
	private String max_temp = "";
	private String min_temp = "";
	private String speed_wind = "";
	private String pressure = "";

	public Weather(String city) {
		String api = "563bf0a0c62dfc3e2931bbd6dc2e6808";
		urlAddress = "https://api.openweathermap.org/data" +
				"/2.5/weather?q=" + city + "&APPID=" + api;   // формируем ссылку, подставляя город, погодна которого нам нужна,
		setValues();																				// и наш API
	}

	private String getJson(){
		StringBuffer json = new StringBuffer();
		try {
			URL url = new URL(urlAddress);
			URLConnection urlConn = url.openConnection();  // Делаем запрос по ссылке, сформированной в конструкторе

			BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));  // Читаем ответ сервера в формате json
			String line;

			while((line = br.readLine()) != null)
				json.append(line).append("\n");
			br.close();

			return json.toString();
		} catch (SocketException | UnknownHostException e){
			return "Ошибка, нет подключения";
		} catch (IOException e) {
			return "Ошибка, город не найден";
		}

	}

	private void setValues(){
		String str = getJson();
		if(str.contains("Ошибка")){
			temperature = str;
		} else {
			JSONObject jsonobj = new JSONObject(str);   // Далее инициализируем наши переменные нужными значениями из json
			temperature = "" + (int) (jsonobj.getJSONObject("main").getDouble("temp") - 273) + " C";
			feels_like = "" + (int) (jsonobj.getJSONObject("main").getDouble("feels_like") - 273) + " C";
			max_temp = "" + (int) (jsonobj.getJSONObject("main").getDouble("temp_max") - 273) + " C";
			min_temp = "" + (int) (jsonobj.getJSONObject("main").getDouble("temp_min") - 273) + " C";
			speed_wind = "" + jsonobj.getJSONObject("wind").getDouble("speed") + " м/с";
			pressure = "" + jsonobj.getJSONObject("main").getDouble("pressure") + " мм";
		}
	}

	public String getTemperature() {
		return temperature;
	}

	public String getFeels_like() {
		return feels_like;
	}

	public String getMax_temp() {
		return max_temp;
	}

	public String getMin_temp() {
		return min_temp;
	}

	public String getSpeed_wind() {
		return speed_wind;
	}

	public String getPressure() {
		return pressure;
	}
}
