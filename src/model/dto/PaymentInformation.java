package model.dto;

public class PaymentInformation {

	private int id;
	private double partial;
	private double discount;
	private double total;

	public PaymentInformation(int id, double partial, double discount, double total) {
		this.id = id;
		this.partial = partial;
		this.discount = discount;
		this.total = total;
	}

	public PaymentInformation(double partial, double discount, double total) {
		this.partial = partial;
		this.discount = discount;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPartial() {
		return partial;
	}

	public void setPartial(double partial) {
		this.partial = partial;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
