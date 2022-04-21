package model.dao;

import java.util.List;

import model.dto.CashRegister;

public interface ICashRegisterDao {

	List<CashRegister> listCashRegisters();
	
	CashRegister insertCashRegister(CashRegister cashRegister);
	
	boolean deleteCashRegister(CashRegister cashRegister);
	
}
