package xmlsrc;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class XMLFilesGenerator {

	// HERE YOU CAN CONFIGURE THE NAME OF THE FILES
	public static final String USERS_FILE_NAME = "users.xml";
	public static final String PARKED_VEHICLES_FILE_NAME = "parked_vehicles.xml";
	public static final String PRICES_FILE_NAME = "prices.xml";
	public static final String CASH_BALANCING = "cash_balancing.xml";

	private static String getActualDirectory() {
		File file = new File("./src/xmlsrc");
		String actualDirectory = "";
		try {
			actualDirectory = file.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return actualDirectory;
	}

	public static String getUsersFilePath() {

		return getActualDirectory() + "\\" + USERS_FILE_NAME;
	}

	public static String getParkedVehiclesFilePath() {

		return getActualDirectory() + "\\" + PARKED_VEHICLES_FILE_NAME;
	}

	public static String getPricesFilePath() {
		return getActualDirectory() + "\\" + PRICES_FILE_NAME;
	}
	
	public static String getCashBalancingFilePath() {
		return getActualDirectory() + "\\" + CASH_BALANCING;
	}

	// If the file does not exist in 'xmlsrc' directory, this method creates it.
	public File createFile(String nameFile) {
		File file = new File(getActualDirectory() + "/" + nameFile);
		try {
			if (!file.exists()) {
				file.createNewFile();
			} else {
				String message = "The file '" + file.getName() + "' already exists in: '" + getActualDirectory() + "\\"
						+ "'";
				JOptionPane.showMessageDialog(null, message, "Create File Error", JOptionPane.WARNING_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return file;
	}
	
	public static boolean cleanFile(String nameFile) {
		boolean response = false;
		File file = new File(getActualDirectory() + "/" + nameFile);
		try {
			file.createNewFile();
			response = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
