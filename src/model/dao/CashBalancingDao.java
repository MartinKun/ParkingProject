package model.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import controller.Controller;
import model.domain.CashBalancing;
import model.domain.CashRegister;
import xmlsrc.XMLFilesGenerator;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CashBalancingDao implements ICashBalancingDao{
	
	Controller controller;
	private String cashBalancingFilePath = XMLFilesGenerator.getCashBalancingFilePath();

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public boolean insertCashRegister(CashRegister register) {
		boolean response = false;
		
		try {
			//classes required to read a XML file.
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(cashBalancingFilePath));
			
			
			//prepare the xml file to get the data.
			doc.getDocumentElement().normalize();
			//get the root node. ("cash_balancing")
			Node rootNode = doc.getDocumentElement();
			//add a new tag to the document
			//first creating the tag ("cash_register")
			Element registerElement = doc.createElement("cash_register");
			//then creating its child tags 
			//("date", "hour", "vehicle", "admission", "partial", "discount", "total")
			////and add data from object register.
			Element dateOfIssueElement = doc.createElement("date_of_issue");
			dateOfIssueElement.setTextContent(register.getDateOfIssue());
			Element vehicleElement = doc.createElement("vehicle");
			vehicleElement.setTextContent(register.getVehicle());
			Element admissionElement = doc.createElement("admission");
			admissionElement.setTextContent(register.getAdmission());
			Element parkedTimeElement = doc.createElement("parked_time");
			parkedTimeElement.setTextContent(register.getParkedTime());
			Element partialElement = doc.createElement("partial");
			partialElement.setTextContent(register.getPartial());
			Element discountElement = doc.createElement("discount");
			discountElement.setTextContent(register.getDiscount());
			Element totalElement = doc.createElement("total");
			totalElement.setTextContent(register.getTotal());
			
			//now relate the tags to their respectives parents.
			registerElement.appendChild(dateOfIssueElement);
			registerElement.appendChild(vehicleElement);
			registerElement.appendChild(admissionElement);
			registerElement.appendChild(parkedTimeElement);
			registerElement.appendChild(partialElement);
			registerElement.appendChild(discountElement);
			registerElement.appendChild(totalElement);
			rootNode.appendChild(registerElement);
			
			//transforming this data structure to the xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(XMLFilesGenerator.getCashBalancingFilePath()));
			transformer.transform(source, result);
			
			response = true;
			
		} catch (ParserConfigurationException e) {
			controller.showErrorMessage(
					"Se encontraron problemas en la conversion al archivo xml");
			e.printStackTrace();
		} catch (SAXException e) {
			controller.showErrorMessage(
					"Se encontraron problemas en la conversion al archivo xml");
			e.printStackTrace();
		} catch (IOException e) {
			controller.showErrorMessage(
					"Se encontraron problemas para leer y escribir el archivo " + cashBalancingFilePath);
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			controller.showErrorMessage(
					"Se encontraron problemas en la conversion al archivo xml");
			e.printStackTrace();
		} catch (TransformerException e) {
			controller.showErrorMessage(
					"Se encontraron problemas en la conversion al archivo xml");
			e.printStackTrace();
		}
		
		
		return response;
	}

	@Override
	public ArrayList<CashRegister> listCashRegisters() {
		
		ArrayList<CashRegister> registers = null;
		CashBalancing cashBalancing = null;
		
		try {
			JAXBContext context = JAXBContext.newInstance(CashBalancing.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File(cashBalancingFilePath);
			cashBalancing = (CashBalancing) unmarshaller.unmarshal(file);

			if (cashBalancing != null) {
				registers = cashBalancing.getRegisters();
			}

		} catch (JAXBException e) {
			controller.showErrorMessage("Se encontraron problemas para leer el archivo " + cashBalancingFilePath);
		}
		
		return registers;
	}

	
	

}
