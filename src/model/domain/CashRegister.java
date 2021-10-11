package model.domain;

import javax.xml.bind.annotation.XmlElement;

public class CashRegister {
	
	private String dateOfIssue;
	private String vehicle;
	private String admission;
	private String parkedTime;
	private String partial;
	private String discount;
	private String total;
	
	public CashRegister() {
		
	}

	public CashRegister(String dateOfIssue, String vehicle, String admission, String parkedTime, String partial,
			String discount, String total) {
		this.dateOfIssue = dateOfIssue;
		this.vehicle = vehicle;
		this.admission = admission;
		this.parkedTime = parkedTime;
		this.partial = partial;
		this.discount = discount;
		this.total = total;
	}

	@XmlElement(name = "date_of_issue")
	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getAdmission() {
		return admission;
	}

	public void setAdmission(String admission) {
		this.admission = admission;
	}

	@XmlElement(name = "parked_time")
	public String getParkedTime() {
		return parkedTime;
	}

	public void setParkedTime(String parkedTime) {
		this.parkedTime = parkedTime;
	}

	public String getPartial() {
		return partial;
	}

	public void setPartial(String partial) {
		this.partial = partial;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}	
	
	

}
