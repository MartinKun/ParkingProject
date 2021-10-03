package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.Controller;
import model.dao.ParkingLotDao;
import model.dao.UserDao;
import model.entity.ParkingLot;

public class ParkingLogic {
	

	private ParkingLotDao parkingLotDao;

	public void setParkingLotDao(ParkingLotDao parkingLotDao) {
		this.parkingLotDao = parkingLotDao;
	}

	public boolean validateVehiclePlateNumber(String plateNumber) {
		
		String regularExpression = "(([A-Z]{2}\\s[0-9]{3}\\s[A-Z]{2}|[A-Z]{3}\\s[0-9]{4}|[0-9]{3}\\s[A-Z]{4}|[A-Z]{2}\\s[A-Z]{2}\\s[0-9]{2}|[A-Z]{3}\\s[0-9][A-Z][0-9]{2}))";
		
		Pattern pattern = Pattern.compile(regularExpression);
		
		Matcher m = pattern.matcher(plateNumber);
		
		return m.matches();
	}

	public boolean enterVehicle(ParkingLot parkingLot) {
		
		return parkingLotDao.insertParkingLot(parkingLot);
		
	}

	public ArrayList<ParkingLot> getParkingLots() {
		return parkingLotDao.listParkingLots();
		
	}
	
}
