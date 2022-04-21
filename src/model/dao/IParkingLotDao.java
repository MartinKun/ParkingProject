package model.dao;
import java.util.List;

import model.dto.ParkingLot;

public interface IParkingLotDao {
	
	List<ParkingLot> listParkingLots();
	
	ParkingLot findParkingLotById(int id);
	
	ParkingLot insertParkingLot(ParkingLot parkingLot);
	
	boolean updateParkingLot(ParkingLot parkingLot);

}
