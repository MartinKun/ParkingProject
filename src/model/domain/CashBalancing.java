package model.domain;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cash_balancing")
public class CashBalancing {
	
	ArrayList<CashRegister> registers;

	@XmlElement(name = "cash_register")
	public ArrayList<CashRegister> getRegisters() {
		return registers;
	}

	public void setRegisters(ArrayList<CashRegister> registers) {
		this.registers = registers;
	}
	
	

}
