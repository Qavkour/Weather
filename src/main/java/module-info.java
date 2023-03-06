module com.qavkour.weather {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.json;


	opens com.qavkour.weather to javafx.fxml;
	exports com.qavkour.weather;
}