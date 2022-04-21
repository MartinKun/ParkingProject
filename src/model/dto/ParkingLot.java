package model.dto;

public class ParkingLot {

	private int id;
	private int spot;
	private Vehicle vehicle;

	public ParkingLot(int id, int spot, Vehicle vehicle) {
		this.id = id;
		this.spot = spot;
		this.vehicle = vehicle;
	}

	public ParkingLot(int spot, Vehicle vehicle) {
		this.spot = spot;
		this.vehicle = vehicle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpot() {
		return spot;
	}

	public void setSpot(int spot) {
		this.spot = spot;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
