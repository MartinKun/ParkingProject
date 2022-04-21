package model.dto;

public class Vehicle {

	private int id;
	private String type;
	private String plate;
	private Detail detail;

	public Vehicle(int id, String type, String plate, Detail detail) {
		this.id = id;
		this.type = type;
		this.plate = plate;
		this.detail = detail;
	}

	public Vehicle(String type, String plate, Detail detail) {
		this.type = type;
		this.plate = plate;
		this.detail = detail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}
	
}
