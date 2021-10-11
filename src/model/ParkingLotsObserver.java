package model;

import java.util.ArrayList;

import model.domain.ParkingLot;

public interface ParkingLotsObserver {
	
	public void parkingLotsValueChange(ArrayList<ParkingLot> parkingLots);
	
	public void availableSpotsValueChange(String[] availableSpots);
}
