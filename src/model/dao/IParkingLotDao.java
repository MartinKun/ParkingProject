package model.dao;

import java.util.ArrayList;

import model.domain.ParkingLot;

public interface IParkingLotDao {
	
	ArrayList<ParkingLot> listParkingLots();
	
	boolean insertParkingLot(ParkingLot parkingLot);
	
	boolean deleteParkingLot(ParkingLot parkingLot);

}
