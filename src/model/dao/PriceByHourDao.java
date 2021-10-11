package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import controller.Controller;
import model.domain.Prices;
import xmlsrc.XMLFilesGenerator;

public class PriceByHourDao implements IPriceByHourDao {

	private Controller controller;
	private String pricesFilePath = XMLFilesGenerator.getPricesFilePath();

	public void setController(Controller controller) {
		this.controller = controller;

	}

	@Override
	public String getPriceByHour() {

		Prices prices = null;
		String priceByHour = null;

		try {
			JAXBContext context = JAXBContext.newInstance(Prices.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File(pricesFilePath);
			prices = (Prices) unmarshaller.unmarshal(file);

			if (prices != null) {
				priceByHour = prices.getPriceByHour();
			}

		} catch (JAXBException e) {
			// controller.showErrorMessage("Se encontraron problemas para leer el archivo "
			// + pricesFilePath);
		}

		return priceByHour;
	}

	@Override
	public boolean updatePriceByHour(String priceByHour) {

		boolean response = false;

		Prices prices = null;
		// String priceByHour = null;

		try {
			// Read
			JAXBContext context = JAXBContext.newInstance(Prices.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			InputStream inputStream = new FileInputStream(pricesFilePath);
			prices = (Prices) unmarshaller.unmarshal(inputStream);
			inputStream.close();

			// Update
			if (prices != null) {
				prices.setPriceByHour(priceByHour);
				response = true;
			}

			// Write
			Marshaller marshaller = context.createMarshaller();
			OutputStream outputStream = new FileOutputStream(pricesFilePath);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(prices, outputStream);
			outputStream.close();

		} catch (JAXBException e) {
			 controller.showErrorMessage(
			 "Se encontraron problemas para leer y escribir el archivo " +
			 pricesFilePath);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			 controller.showErrorMessage("El archivo " + pricesFilePath + " no ha sido encontrado.");
			 e.printStackTrace();
		} catch (IOException e) {
			 controller.showErrorMessage(
			 "Se encontraron problemas para leer y escribir el archivo " +
			 pricesFilePath);
			 e.printStackTrace();
		}
		return response;

	}

}
