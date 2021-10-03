package model.dao;

import java.util.ArrayList;

import model.entity.ParkingLot;

public interface IParkingLotDao {
	
	ArrayList<ParkingLot> listParkingLots();
	
	boolean insertParkingLot(ParkingLot parkingLot);

}
