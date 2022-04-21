package model.dao;

import model.dto.PaymentInformation;

public interface IPaymentInformationDao {
	
	PaymentInformation insertPaymentInformation(PaymentInformation paymentInformation);
	
	PaymentInformation findPaymentInformationById(int id);
	
	boolean deletePaymentInformation(PaymentInformation paymentInformation);

}
