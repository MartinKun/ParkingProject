package helpers;

import java.util.ResourceBundle;

public class LanguageManager {

	private static LanguageManager LANGUAGE_MANAGER = null;
	private final static String ES = "ES";
	private final static String EN = "EN";
	private ResourceBundle boundle;
	private String actualLanguage;

	private LanguageManager() {
		boundle = ResourceBundle.getBundle("resources/boundles/en_EN");
		actualLanguage = "EN";
	}

	public static LanguageManager getInstance() {
		if (LANGUAGE_MANAGER == null) {
			LANGUAGE_MANAGER = new LanguageManager();
		}

		return LANGUAGE_MANAGER;
	}
	
	public String getActualLanguage() {
		return actualLanguage;
	}

	public String getProperty(String value) {
		return boundle.getString(value);
	}

	public void changeLenguage(String language) {

		switch (language) {
		case EN:
			boundle = ResourceBundle.getBundle("resources/boundles/en_EN");
			actualLanguage = "EN";
			break;
		case ES:
			boundle = ResourceBundle.getBundle("resources/boundles/es_ES");
			actualLanguage = "ES";
			break;
		default:
			System.out.println("No se pudo encontrar el lenguaje que ha solicitado.");
			break;
		}

	}

	public String getVehicleTypeByLanguage(String vehicleType) {
		String response = "";

		switch (vehicleType) {
		case "Motorcycle":
			if (actualLanguage.equals("EN")) {
				return vehicleType;
			} else if (actualLanguage.equals("ES")) {
				response = "Motocicleta";
				break;
			}
		case "Car":
			if (actualLanguage.equals("EN")) {
				return vehicleType;
			} else if (actualLanguage.equals("ES")) {
				response = "Automovil";
				break;
			}
		}

		return response;
	}

}
