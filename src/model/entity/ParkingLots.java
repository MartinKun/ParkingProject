package model.entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "parking_lots")
public class ParkingLots {

	ArrayList<ParkingLot> parkingLots;

	@XmlElement(name = "parking_lot")
	public ArrayList<ParkingLot> getParkingLots() {
		return parkingLots;
	}

	public void setParkingLots(ArrayList<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}

}
