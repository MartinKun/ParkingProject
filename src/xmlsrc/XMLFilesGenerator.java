package xmlsrc;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class XMLFilesGenerator {
	
	// HERE YOU CAN CONFIGURE THE NAME OF THE FILES
	public static final String USERS_FILE_NAME = "users.xml";
        public static final String PARKED_VEHICLES_FILE_NAME = "parked_vehicles.xml";
	
	private String getActualDirectory() {
		File file = new File("./src/xmlsrc");
		String actualDirectory = "";
		try {
			actualDirectory = file.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return actualDirectory;
	}

	// If the file does not exist in 'db' directory, this method creates it.
	public File createFile(String nameFile) {
		File file = new File(getActualDirectory() + "/" + nameFile);
		try {
			if (!file.exists()) {
				file.createNewFile();
			} else {
				String message = "The file '" + file.getName() + "' already exists in: '" + getActualDirectory() +"\\" + "'";
				System.out.println(message);
				JOptionPane.showMessageDialog(null, message, "Create File Error", JOptionPane.WARNING_MESSAGE);
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return file;
	}        

}
