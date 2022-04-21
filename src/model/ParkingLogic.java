package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import helpers.DateHelper;
import helpers.LanguageManager;
import helpers.Observable;
import helpers.ParkingLotsObserver;
import helpers.PriceObservable;
import helpers.PriceObserver;
import model.dao.DetailDao;
import model.dao.ParkingLotDao;
import model.dao.PriceByHourDao;
import model.dao.VehicleDao;
import model.dao.VehicleMovementsDao;
import model.dto.Detail;
import model.dto.TimeParked;
import model.dto.ParkingLot;
import model.dto.Vehicle;
import txt.TxtFilesManagement;

public class ParkingLogic implements Observable<ParkingLotsObserver>, PriceObservable<PriceObserver> {

	private VehicleDao vehicleDao;
	private DetailDao detailDao;
	private ParkingLotDao parkingLotDao;
	private PriceByHourDao priceByHourDao;
	private VehicleMovementsDao vehicleMovementsDao;
	private List<ParkingLot> parkingLots;
	private ArrayList<ParkingLotsObserver> parkingLotsObservers = new ArrayList();
	private ArrayList<PriceObserver> priceObservers = new ArrayList();
	private String priceValueChange;
	LanguageManager languageManager = LanguageManager.getInstance();

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	public void setDetailDao(DetailDao detailDao) {
		this.detailDao = detailDao;
	}

	public void setParkingLotDao(ParkingLotDao parkingLotDao) {
		this.parkingLotDao = parkingLotDao;
	}

	public void setPriceByHourDao(PriceByHourDao priceByHourDao) {
		this.priceByHourDao = priceByHourDao;
	}

	public void setVehicleMovementsDao(VehicleMovementsDao vehicleMovementsDao) {
		this.vehicleMovementsDao = vehicleMovementsDao;

	}

	public boolean validateVehiclePlate(String plate) {

		String regularExpression = "(([A-Z]{2}\\s[0-9]{3}\\s[A-Z]{2}|[A-Z]{3}\\s[0-9]{4}|[0-9]{3}\\s[A-Z]{4}|[A-Z]{2}\\s[A-Z]{2}\\s[0-9]{2}|[A-Z]{3}\\s[0-9][A-Z][0-9]{2}))";

		Pattern pattern = Pattern.compile(regularExpression);

		Matcher m = pattern.matcher(plate);

		return m.matches();
	}

	public Detail insertDetail(Detail detail) {
		return detailDao.insertDetail(detail);
	}

	public boolean updateDetail(Detail detail) {
		return detailDao.updateDetail(detail);
	}

	public Vehicle insertVehicle(Vehicle vehicle) {
		Vehicle response = null;
		response = vehicleDao.insertVehicle(vehicle);
		return response;
	}

	public boolean updateParkingSlot(ParkingLot parkingLot) {
		return parkingLotDao.updateParkingLot(parkingLot);
	}

	public List<ParkingLot> getParkingLots() {
		return parkingLots;
	}

	public String[] getAvailableSpots() {
		ArrayList<String> availableSpotsArrayList = new ArrayList();

		for (ParkingLot parkingLot : parkingLots) {

			if (parkingLot.getVehicle() == null) {

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

		parkingLots = filterParkingLotsByLanguage(parkingLots);

		notifyObservers();
	}

	public List<ParkingLot> filterParkingLotsByLanguage(List<ParkingLot> parkingLots) {

		String type = "";

		LanguageManager languageManager = LanguageManager.getInstance();

		for (ParkingLot item : parkingLots) {
			if (item.getVehicle() != null) {
				type = languageManager.getVehicleTypeByLanguage(item.getVehicle().getType());
				item.getVehicle().setType(type);
			}
		}

		return parkingLots;
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


	
	

	/*
	public String generateMessageTicketInfo() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("- - - - - - - - - - - - - - - - - - - - - - - - - - ");
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("vehicle_information"));
		stringBuilder.append("\n");
		stringBuilder.append("- - - - - - - - - - - - - - - - - - - - - - - - - - ");
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("vehicle"));
		stringBuilder.append(": ").append(ticketData.getParkingLot().getVehicle().getType());
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("plate"));
		stringBuilder.append(": ").append(ticketData.getParkingLot().getVehicle().getPlate());
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("entry_date"));
		stringBuilder.append(": ")
				.append(DateHelper.formatDateToDay(ticketData.getParkingLot().getVehicle().getDetail().getEntryDate()));
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("entry_hour"));
		stringBuilder.append(": ").append(
				String.valueOf(DateHelper.formatDateToHour(ticketData.getParkingLot().getVehicle().getDetail().getEntryDate())));
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("time_parked"));
		stringBuilder.append(": ").append(ticketData.getTimeParked());
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("partial_mount"));
		stringBuilder.append(": $ ").append(ticketData.getPartialAmountPayable());
		return stringBuilder.toString();
	}
*/

	public boolean validateDiscountTextField(String discountText) {

		String regularExpression = "((100|[0-9]{1,2}){1}(\\.[0-9]+)?)";

		Pattern pattern = Pattern.compile(regularExpression);

		Matcher m = pattern.matcher(discountText);

		return m.matches();
	}

	public boolean saveVehicleExitRecord(Vehicle vehicle, int spot) {
		boolean response = false;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("exit"));
		stringBuilder.append(" -> ");
		stringBuilder.append(vehicle.getPlate());
		stringBuilder.append(" (");
		stringBuilder.append(vehicle.getType());
		stringBuilder.append(")\n");
		stringBuilder.append(languageManager.getProperty("spot"));
		stringBuilder.append(": ");
		stringBuilder.append(spot);
		stringBuilder.append("\n");
		Date date = new Date();
		stringBuilder.append(DateHelper.formatDateToHour(date));
		stringBuilder.append("  ");
		stringBuilder.append(DateHelper.formatDateToDay(date));

		response = vehicleMovementsDao.insertRegister(stringBuilder.toString());

		return response;
	}

	public boolean saveVehicleEntryRecord(Vehicle vehicle, int spot) {
		boolean response = false;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("enters"));
		stringBuilder.append(" <- ");
		stringBuilder.append(vehicle.getPlate());
		stringBuilder.append(" (");
		stringBuilder.append(languageManager.getVehicleTypeByLanguage(vehicle.getType()));
		stringBuilder.append(")\n");
		stringBuilder.append(languageManager.getProperty("spot"));
		stringBuilder.append(": ");
		stringBuilder.append(spot);
		stringBuilder.append("\n");
		Date date = new Date();
		stringBuilder.append(DateHelper.formatDateToHour(date));
		stringBuilder.append("  ");
		stringBuilder.append(DateHelper.formatDateToDay(date));

		// response = vehicleMovementsDao.insertRegister(stringBuilder.toString());
		response = vehicleMovementsDao.insertRegister(stringBuilder.toString());

		return response;

	}

	public String getVehicleMovementsData() {
		String response = vehicleMovementsDao.getRegisters();
		if (response == null) {
			response = languageManager.getProperty("no_registers");
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

	public String generateTicket(String type, String plate, Date entryDate, Date departureDate, double partial) {
		
		TimeParked timeParked = DateHelper.getTimeParked(entryDate, departureDate);
		StringBuilder timeParkedStringBuilder = new StringBuilder();
		
		if(timeParked.getDay() != 0) {
			timeParkedStringBuilder.append(timeParked.getDay()).append(languageManager.getProperty("days")).append(",");
		}
		timeParkedStringBuilder.append(timeParked.getHour()).append("Hrs");
		timeParkedStringBuilder.append(timeParked.getMinutes()).append("min");
		timeParkedStringBuilder.append(timeParked.getSeconds()).append(languageManager.getProperty("sec"));
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("- - - - - - - - - - - - - - - - - - - - - - - - - - ");
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("vehicle_information"));
		stringBuilder.append("\n");
		stringBuilder.append("- - - - - - - - - - - - - - - - - - - - - - - - - - ");
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("vehicle"));
		stringBuilder.append(": ").append(type);
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("plate"));
		stringBuilder.append(": ").append(plate);
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("entry_date"));
		stringBuilder.append(": ")
				.append(DateHelper.formatDateToDay(entryDate));
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("entry_hour"));
		stringBuilder.append(": ").append(
				String.valueOf(DateHelper.formatDateToHour(entryDate)));
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("time_parked"));
		stringBuilder.append(": ").append(timeParkedStringBuilder.toString());
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("partial_mount"));
		stringBuilder.append(": $ ").append(partial);
		return stringBuilder.toString();
	}

}
