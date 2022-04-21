package model.dto;

import java.util.Date;

public class CashRegister {

	private int id;
	private Date createDate;
	private Vehicle vehicle;
	private PaymentInformation paymentInformation;
	
	public CashRegister() {
	}

	public CashRegister(int id, Date createDate, Vehicle vehicle, PaymentInformation paymentInformation) {
		this.id = id;
		this.createDate = createDate;
		this.vehicle = vehicle;
		this.paymentInformation = paymentInformation;
	}

	public CashRegister(Date createDate, Vehicle vehicle, PaymentInformation paymentInformation) {
		this.createDate = createDate;
		this.vehicle = vehicle;
		this.paymentInformation = paymentInformation;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public PaymentInformation getPaymentInformation() {
		return paymentInformation;
	}

	public void setPaymentInformation(PaymentInformation paymentInformation) {
		this.paymentInformation = paymentInformation;
	}

}
