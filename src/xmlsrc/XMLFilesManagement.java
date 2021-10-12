package xmlsrc;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

public class XMLFilesManagement {

	public static void main(String[] args) {

		// Creating files
		XMLFilesGenerator xmlFiles = new XMLFilesGenerator();
		File usersFile = xmlFiles.createFile(XMLFilesGenerator.USERS_FILE_NAME);
		File parkedVehiclesFile = xmlFiles.createFile(XMLFilesGenerator.PARKED_VEHICLES_FILE_NAME);
		File pricesFile = xmlFiles.createFile(XMLFilesGenerator.PRICES_FILE_NAME);
		File cashBalancingFile = xmlFiles.createFile(XMLFilesGenerator.CASH_BALANCING);

		XMLUserElementsGenerator xmlDataUser;
		XMLParkingLotsElementsGenerator xmlDataSpots;
		XMLPricesElementsGenerator xmlDataPrices;
		XMLCashBalancingElementsGenerator xmlDataCashBalancing;
		try {
			xmlDataUser = new XMLUserElementsGenerator();
			xmlDataUser.generateDocument();
			xmlDataUser.generateXML(usersFile);

			xmlDataSpots = new XMLParkingLotsElementsGenerator();
			xmlDataSpots.generateDocument();
			xmlDataSpots.generateXML(parkedVehiclesFile);

			xmlDataPrices = new XMLPricesElementsGenerator();
			xmlDataPrices.generateDocument();
			xmlDataPrices.generateXML(pricesFile);

			xmlDataCashBalancing = new XMLCashBalancingElementsGenerator();
			xmlDataCashBalancing.generateDocument();
			xmlDataCashBalancing.generateXML(cashBalancingFile);

		} catch (ParserConfigurationException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
                Logger.getLogger(XMLFilesManagement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(XMLFilesManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

	}

	public static boolean cleanCashBalancingFile() {
		boolean response = false;
		try {
			XMLCashBalancingElementsGenerator xmlDataCashBalancing;
			xmlDataCashBalancing = new XMLCashBalancingElementsGenerator();
			xmlDataCashBalancing.generateDocument();
			xmlDataCashBalancing.generateXML(new File(XMLFilesGenerator.getCashBalancingFilePath()));
			response = true;
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
