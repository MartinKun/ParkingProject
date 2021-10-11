package model.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParkedVehicleData {
	
	private ParkingLot parkingLot;
	private String timeParked;
	private double partialAmountPayable;
	private double totalAmountPayable;
	private double discount;
	
	public ParkedVehicleData(ParkingLot parkingLot, String timeParked, double partialAmountPayable, double discount) {
		this.parkingLot = parkingLot;
		this.timeParked = timeParked;
		this.partialAmountPayable = partialAmountPayable;
		setTotalAmountPayable();
		this.discount = discount;
		
	}


	public ParkingLot getParkingLot() {
		return parkingLot;
	}


	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}


	public String getTimeParked() {
		return timeParked;
	}


	public void setTimeParked(String timeParked) {
		this.timeParked = timeParked;
	}


	public double getPartialAmountPayable() {
		return partialAmountPayable;
	}


	public void setPartialAmountPayable(double partialAmountPayable) {
		this.partialAmountPayable = partialAmountPayable;
	}


	public double getTotalAmountPayable() {
		return totalAmountPayable;
	}


	public void setTotalAmountPayable() {
		double result = this.partialAmountPayable - ((this.discount * this.partialAmountPayable)/100);
		BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
		totalAmountPayable = bd.doubleValue();
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
}
