package model.dao;

import java.util.ArrayList;

import model.domain.CashRegister;

public interface ICashBalancingDao {

	//method that adds a CashRegister data object to an xml file.
	boolean insertCashRegister(CashRegister register);
	
	ArrayList<CashRegister> listCashRegisters();
	
}
