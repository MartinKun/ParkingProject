package model;

import java.util.List;

import helpers.DateHelper;
import helpers.LanguageManager;
import model.dao.CashRegisterDao;
import model.dao.PaymentInformationDao;
import model.dto.CashRegister;
import model.dto.TimeParked;
import model.dto.PaymentInformation;

public class CashRegistersLogic {
	private PaymentInformationDao paymentInformationDao;
	private CashRegisterDao cashRegisterDao;

	public void setCashRegisterDao(CashRegisterDao cashRegisterDao) {
		this.cashRegisterDao = cashRegisterDao;
	}

	public void setPaymentInformationDao(PaymentInformationDao paymentInformationDao) {
		this.paymentInformationDao = paymentInformationDao;
	}

	public PaymentInformation insertPayInformation(PaymentInformation paymentInformation) {
		return paymentInformationDao.insertPaymentInformation(paymentInformation);
	}

	public List<CashRegister> listCashRegisters() {

		return cashRegisterDao.listCashRegisters();
	}

	public CashRegister insertCashRegister(CashRegister register) {
		return cashRegisterDao.insertCashRegister(register);
	}

	public String getCashBalancingData(List<CashRegister> registers) {
		LanguageManager languageManager = LanguageManager.getInstance();
		StringBuilder stringBuilder = new StringBuilder();
		double total = 0;

		for (CashRegister register : registers) {
			StringBuilder timeParkedStringBuilder = new StringBuilder();

			TimeParked timeParked = DateHelper.getTimeParked(register.getVehicle().getDetail().getEntryDate(),
					register.getVehicle().getDetail().getDepartureDate());

			if (timeParked.getDay() != 0) {
				timeParkedStringBuilder.append(timeParked.getDay()).append(languageManager.getProperty("days"))
						.append(",");
			}
			timeParkedStringBuilder.append(timeParked.getHour()).append("Hrs");
			timeParkedStringBuilder.append(timeParked.getMinutes()).append("min");
			timeParkedStringBuilder.append(timeParked.getSeconds()).append(languageManager.getProperty("sec"));

			stringBuilder.append("\n");
			stringBuilder.append("\n");
			stringBuilder.append(DateHelper.formatDateToDay(register.getCreateDate())).append("   ")
					.append(DateHelper.formatDateToHour(register.getCreateDate()));
			stringBuilder.append("\n");
			stringBuilder.append(languageManager.getProperty("vehicle").toUpperCase()).append(":   ");
			stringBuilder.append(register.getVehicle().getType());
			stringBuilder.append("\n");
			stringBuilder.append(languageManager.getProperty("entry").toUpperCase()).append(":   ");
			stringBuilder.append(DateHelper.formatDateToHour(register.getVehicle().getDetail().getEntryDate()))
					.append("   ")
					.append(DateHelper.formatDateToDay(register.getVehicle().getDetail().getDepartureDate()));
			stringBuilder.append("\n");
			stringBuilder.append(languageManager.getProperty("time_parked").toUpperCase()).append(":   ");
			stringBuilder.append(timeParkedStringBuilder.toString());
			stringBuilder.append("\n");
			stringBuilder.append(languageManager.getProperty("partial").toUpperCase()).append(":   $ ");
			stringBuilder.append(register.getPaymentInformation().getPartial());
			stringBuilder.append("\n");
			stringBuilder.append(languageManager.getProperty("discount").toUpperCase()).append(":   % ");
			stringBuilder.append(register.getPaymentInformation().getDiscount());
			stringBuilder.append("\n");
			stringBuilder.append(languageManager.getProperty("final").toUpperCase()).append(":   $ ");
			stringBuilder.append(register.getPaymentInformation().getTotal());
			stringBuilder.append("\n");
			stringBuilder.append("\n");
			stringBuilder.append("- - - - - - - - - - - - - - - - - - - - - - - - ");

			total += register.getPaymentInformation().getTotal();

		}
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append(languageManager.getProperty("total_recaudation").toUpperCase()).append(":       $ ");
		stringBuilder.append(total + "");

		return stringBuilder.toString();
	}

}
