package helpers;

import java.util.List;

import model.dto.ParkingLot;

public interface ParkingLotsObserver {
	
	public void parkingLotsValueChange(List<ParkingLot> parkingLots);
	
	public void availableSpotsValueChange(String[] availableSpots);
}
