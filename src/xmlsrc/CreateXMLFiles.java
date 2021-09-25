package xmlsrc;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class CreateXMLFiles {

    public static void main(String[] args) {

       

            //Creating files
            XMLFilesGenerator xmlFiles = new XMLFilesGenerator();
            File usersFile = xmlFiles.createFile(XMLFilesGenerator.USERS_FILE_NAME);
            File parkedVehiclesFile = xmlFiles.createFile(XMLFilesGenerator.PARKED_VEHICLES_FILE_NAME);

            XMLUserElementsGenerator xmlDataUser;
            XMLSpotElementsGenerator xmlDataSpots;
        try {
            xmlDataUser = new XMLUserElementsGenerator();
            xmlDataUser.generateDocument();
            xmlDataUser.generateXML(usersFile);
            
            xmlDataSpots = new XMLSpotElementsGenerator();
            xmlDataSpots.generateDocument();
            xmlDataSpots.generateXML(parkedVehiclesFile);
            
        } catch (ParserConfigurationException | IOException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
