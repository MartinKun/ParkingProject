package model.dto;

import java.util.Date;

public class Detail {

	private int id;
	private Date entryDate;
	private Date departureDate;

	public Detail(int id, Date entryDate, Date departureDate) {
		this.id = id;
		this.entryDate = entryDate;
		this.departureDate = departureDate;
	}

	public Detail(Date entryDate, Date departureDate) {
		this.entryDate = entryDate;
		this.departureDate = departureDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

}
