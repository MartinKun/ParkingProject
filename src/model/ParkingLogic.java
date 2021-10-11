package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import helpers.DateHelper;
import model.dao.ParkingLotDao;
import model.dao.PriceByHourDao;
import model.dao.VehicleMovementsDao;
import model.domain.ParkedVehicleData;
import model.domain.ParkingLot;
import txtsrc.TxtFilesManagement;
import xmlsrc.XMLFilesManagement;

public class ParkingLogic implements Observable<ParkingLotsObserver>, PriceObservable<PriceObserver> {

	private ParkingLotDao parkingLotDao;
	private PriceByHourDao priceByHourDao;
	private VehicleMovementsDao vehicleMovementsDao;
	private ArrayList<ParkingLot> parkingLots;
	private ArrayList<ParkingLotsObserver> parkingLotsObservers = new ArrayList<>();
	private ArrayList<PriceObserver> priceObservers = new ArrayList<>();
	private String priceValueChange;
	private ParkedVehicleData parkedVehicleData;

	public void setParkingLotDao(ParkingLotDao parkingLotDao) {
		this.parkingLotDao = parkingLotDao;
	}

	public void setPriceByHourDao(PriceByHourDao priceByHourDao) {
		this.priceByHourDao = priceByHourDao;
	}

	public void setVehicleMovementsDao(VehicleMovementsDao vehicleMovementsDao) {
		this.vehicleMovementsDao = vehicleMovementsDao;

	}

	public boolean validateVehiclePlateNumber(String plateNumber) {

		String regularExpression = "(([A-Z]{2}\\s[0-9]{3}\\s[A-Z]{2}|[A-Z]{3}\\s[0-9]{4}|[0-9]{3}\\s[A-Z]{4}|[A-Z]{2}\\s[A-Z]{2}\\s[0-9]{2}|[A-Z]{3}\\s[0-9][A-Z][0-9]{2}))";

		Pattern pattern = Pattern.compile(regularExpression);

		Matcher m = pattern.matcher(plateNumber);

		return m.matches();
	}

	public boolean enterVehicle(ParkingLot parkingLot) {

		boolean response = parkingLotDao.insertParkingLot(parkingLot);

		if (response) {
			initData();
		}

		return response;

	}

	public ArrayList<ParkingLot> getParkingLots() {
		return parkingLots;
	}

	public String[] getAvailableSpots() {
		ArrayList<String> availableSpotsArrayList = new ArrayList<>();

		for (ParkingLot parkingLot : parkingLots) {

			if (parkingLot.getPlate().equals("-")) {

				availableSpotsArrayList.add(parkingLot.getSpot() + "");
			}

		}

		String[] availableSpots = new String[availableSpotsArrayList.size()];

		for (int i = 0; i < availableSpotsArrayList.size(); i++) {
			availableSpots[i] = availableSpotsArrayList.get(i);
		}

		return availableSpots;
	}

	public void initData() {
		parkingLots = parkingLotDao.listParkingLots();

		notifyObservers();
	}

	public void getPriceByHour() {
		priceValueChange = priceByHourDao.getPriceByHour();
		notifyPriceObservers();
	}

	@Override
	public void addObserver(ParkingLotsObserver t) {
		parkingLotsObservers.add(t);

	}

	@Override
	public void removeObserver(ParkingLotsObserver t) {
		// TODO Auto-generated method stub

	}

	private void notifyObservers() {

		for (ParkingLotsObserver o : parkingLotsObservers) {
			o.parkingLotsValueChange(parkingLots);
			o.availableSpotsValueChange(getAvailableSpots());
		}

	}

	private void notifyPriceObservers() {

		for (PriceObserver po : priceObservers) {
			po.priceValueChange(priceValueChange);
		}

	}

	public boolean removeParkingLot(ParkingLot parkingLotSelected) {

		boolean response = parkingLotDao.deleteParkingLot(parkingLotSelected);

		if (response) {
			initData();
		}

		return response;
	}

	@Override
	public void addPriceObserver(PriceObserver t) {
		priceObservers.add(t);

	}

	@Override
	public void removePriceObserver(PriceObserver t) {
		// TODO Auto-generated method stub

	}

	public boolean validateChangePriceTextField(String priceText) {

		String regularExpression = "(([0-9]+\\.([0-9]{2}|[0-9]{1})|([0-9]+))$)";

		Pattern pattern = Pattern.compile(regularExpression);

		Matcher m = pattern.matcher(priceText);

		return m.matches();
	}

	public boolean updatePriceByHour(String priceText) {
		boolean response = priceByHourDao.updatePriceByHour(priceText);
		getPriceByHour();
		return response;
	}

	public void setParkedVehicleData(ParkedVehicleData parkedVehicleData) {
		this.parkedVehicleData = parkedVehicleData;

	}

	public ParkedVehicleData getParkedVehicleData() {
		return this.parkedVehicleData;
	}

	public String generateMessageTicketInfo() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("- - - - - - - - - - - - - - - - - - - - - - - - - - ");
		stringBuilder.append("\n");
		stringBuilder.append("INFORMACION DEL VEHICULO:");
		stringBuilder.append("\n");
		stringBuilder.append("- - - - - - - - - - - - - - - - - - - - - - - - - - ");
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append("Vehiculo: ").append(parkedVehicleData.getParkingLot().getVehicle());
		stringBuilder.append("\n");
		stringBuilder.append("Patente: ").append(parkedVehicleData.getParkingLot().getPlate());
		stringBuilder.append("\n");
		stringBuilder.append("Fecha de Ingreso: ").append(parkedVehicleData.getParkingLot().getAdmissionDate());
		stringBuilder.append("\n");
		stringBuilder.append("Hora de Ingreso: ").append(parkedVehicleData.getParkingLot().getAdmissionHour());
		stringBuilder.append("\n");
		stringBuilder.append("Tiempo aparcado: ").append(parkedVehicleData.getTimeParked());
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		stringBuilder.append("\n");
		stringBuilder.append("Monto parcial: $ ").append(parkedVehicleData.getPartialAmountPayable());
		return stringBuilder.toString();
	}

	public void setDiscount(double discount) {
		parkedVehicleData.setDiscount(discount);
		parkedVehicleData.setTotalAmountPayable();

	}

	public boolean validateDiscountTextField(String discountText) {

		String regularExpression = "((100|[0-9]{1,2}){1}(\\.[0-9]+)?)";

		Pattern pattern = Pattern.compile(regularExpression);

		Matcher m = pattern.matcher(discountText);

		return m.matches();
	}

	public boolean insertExitVehicleRegister(ParkingLot parkingLot) {
		boolean response = false;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n");
		stringBuilder.append("SALIO -> ");
		stringBuilder.append(parkingLot.getPlate());
		stringBuilder.append(" (");
		stringBuilder.append(parkingLot.getVehicle());
		stringBuilder.append(")\n");
		stringBuilder.append("Lugar: ");
		stringBuilder.append(parkingLot.getSpot());
		stringBuilder.append("\n");
		Date date = new Date();
		stringBuilder.append(DateHelper.getActualHour(date));
		stringBuilder.append("  ");
		stringBuilder.append(DateHelper.getActualDay(date));

		// response = vehicleMovementsDao.insertRegister(stringBuilder.toString());
		response = vehicleMovementsDao.insertRegister(stringBuilder.toString());

		return response;
	}

	public boolean insertEnterVehicleRegister(ParkingLot parkingLot) {
		boolean response = false;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n");
		stringBuilder.append("ENTRO <- ");
		stringBuilder.append(parkingLot.getPlate());
		stringBuilder.append(" (");
		stringBuilder.append(parkingLot.getVehicle());
		stringBuilder.append(")\n");
		stringBuilder.append("Lugar: ");
		stringBuilder.append(parkingLot.getSpot());
		stringBuilder.append("\n");
		Date date = new Date();
		stringBuilder.append(DateHelper.getActualHour(date));
		stringBuilder.append("  ");
		stringBuilder.append(DateHelper.getActualDay(date));

		// response = vehicleMovementsDao.insertRegister(stringBuilder.toString());
		response = vehicleMovementsDao.insertRegister(stringBuilder.toString());

		return response;

	}

	public String getVehicleMovementsData() {
		 String response = vehicleMovementsDao.getRegisters();
		 if(response == null) {
			 response = "No hay registros.";
		 } 
		 
		 return response;
	}

	public boolean saveFile(File file, String document) {
		// TODO Auto-generated method stub
		return TxtFilesManagement.saveFile(file, document);
	}

	public boolean cleanVehicleMovementsFile() {
		
		return TxtFilesManagement.cleanFile();
	}

	public boolean cleanCashBalancingFile() {
		// TODO Auto-generated method stub
		return XMLFilesManagement.cleanCashBalancingFile();
	}

}
