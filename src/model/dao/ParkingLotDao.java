package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import controller.Controller;
import model.entity.ParkingLot;
import model.entity.ParkingLots;
import view.components.DetailPanel;
import xmlsrc.XMLFilesGenerator;

public class ParkingLotDao implements IParkingLotDao {

	Controller controller;
	private String parkedVehiclesFilePath = XMLFilesGenerator.getParkedVehiclesFilePath();

	public void setController(Controller controller) {
		this.controller = controller;

	}

	@Override
	public ArrayList<ParkingLot> listParkingLots() {

		ParkingLots parkingLots = null;
		ArrayList<ParkingLot> parkingLotList = null;

		try {
			JAXBContext context = JAXBContext.newInstance(ParkingLots.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File(parkedVehiclesFilePath);
			parkingLots = (ParkingLots) unmarshaller.unmarshal(file);

			if (parkingLots != null) {
				parkingLotList = parkingLots.getParkingLots();
			}

		} catch (JAXBException e) {
			controller.showErrorMessage("Se encontraron problemas para leer el archivo " + parkedVehiclesFilePath);
		}

		return parkingLotList;
	}

	@Override
	public boolean insertParkingLot(ParkingLot parkingLot) {

		boolean response = false;

		ParkingLots parkingLots = null;
		ArrayList<ParkingLot> parkingLotList = null;

		try {
			// Read
			JAXBContext context = JAXBContext.newInstance(ParkingLots.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			InputStream inputStream = new FileInputStream(parkedVehiclesFilePath);
			parkingLots = (ParkingLots) unmarshaller.unmarshal(inputStream);
			inputStream.close();

			// Update
			if (parkingLots != null) {
				parkingLotList = parkingLots.getParkingLots();
			}
			for (ParkingLot plot : parkingLotList) {

				if (plot.getSpot() == parkingLot.getSpot()) {
					plot.setVehicle(parkingLot.getVehicle());
					plot.setPlate(parkingLot.getPlate());
					plot.setAdmissionDate(parkingLot.getAdmissionDate());
					plot.setAdmissionHour(parkingLot.getAdmissionHour());
					response = true;
				}

			}
			// Write
			Marshaller marshaller = context.createMarshaller();
			OutputStream outputStream = new FileOutputStream(parkedVehiclesFilePath);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(parkingLots, outputStream);
			outputStream.close();

		} catch (JAXBException e) {
			controller.showErrorMessage(
					"Se encontraron problemas para leer y escribir el archivo " + parkedVehiclesFilePath);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			controller.showErrorMessage("El archivo " + parkedVehiclesFilePath + " no ha sido encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			controller.showErrorMessage(
					"Se encontraron problemas para leer y escribir el archivo " + parkedVehiclesFilePath);
			e.printStackTrace();
		}
		return response;
	}

}
