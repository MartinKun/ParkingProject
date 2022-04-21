package txt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class TxtFilesManagement {

	// HERE YOU CAN CONFIGURE THE NAME OF THE FILES
	public static final String VEHICLE_MOVEMENTS_FILE = "vehicle_movements.txt";

	// If the file does not exist in 'txtsrc' directory, this method creates it.
	public File createFile(String nameFile) {
		File file = new File(getActualDirectory() + "/" + nameFile);
		try {
			if (!file.exists()) {
				file.createNewFile();
			} else {
				String message = "The file '" + file.getName() + "' already exists in: '" + getActualDirectory() + "\\"
						+ "'";
				System.out.println(message);
				JOptionPane.showMessageDialog(null, message, "Create File Error", JOptionPane.WARNING_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return file;
	}

	private static String getActualDirectory() {
		File file = new File("./src/txtsrc");
		String actualDirectory = "";
		try {
			actualDirectory = file.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return actualDirectory;
	}

	public static String getVehicleMovementsFilePath() {

		return getActualDirectory() + "\\" + VEHICLE_MOVEMENTS_FILE;
	}

	public static boolean saveFile(File file, String document) {
		boolean response = false;
		FileOutputStream output = null;
		try {
			output = new FileOutputStream(file);
			byte[] bytxt = document.getBytes();
			output.write(bytxt);
			response = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return response;

	}

	public static boolean cleanFile() {
		boolean response = false;

		FileWriter fw = null;
		PrintWriter output = null;

		try {
			fw = new FileWriter(getVehicleMovementsFilePath());
			output = new PrintWriter(fw);
			output.println("");
			output.flush();

			output.close();
			fw.close();

			response = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	public static void main(String[] args) {
		TxtFilesManagement createTxtFiles = new TxtFilesManagement();
		createTxtFiles.createFile(VEHICLE_MOVEMENTS_FILE);
	}

}
