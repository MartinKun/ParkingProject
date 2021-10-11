package model.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ParkingLot {
	
	private int spot;
	private String vehicle;
	private String plate;
	private String admissionDate;
	private String admissionHour;
	
	public ParkingLot() {
		
	}
	
	public ParkingLot(int spot, String vehicle, String plate, String admissionDate, String admissionHour) {
		this.spot = spot;
		this.vehicle = vehicle;
		this.plate = plate;
		this.admissionDate = admissionDate;
		this.admissionHour = admissionHour;
	}

	@XmlAttribute(name = "spot")
	public int getSpot() {
		return spot;
	}

	public void setSpot(int parkingLot) {
		this.spot = parkingLot;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	@XmlElement(name = "admission_date")
	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	@XmlElement(name = "admission_hour")
	public String getAdmissionHour() {
		return admissionHour;
	}

	public void setAdmissionHour(String admissionHour) {
		this.admissionHour = admissionHour;
	}
	
	
	
}
