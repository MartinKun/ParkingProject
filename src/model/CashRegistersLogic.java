package model;

import java.util.ArrayList;
import java.util.Date;

import helpers.DateHelper;
import model.dao.CashBalancingDao;
import model.domain.CashRegister;
import model.domain.ParkedVehicleData;

public class CashRegistersLogic {
	private CashBalancingDao cashBalancingDao;

	public void setCashBalancingDao(CashBalancingDao cashBalancingDao) {
		this.cashBalancingDao = cashBalancingDao;
	}
	
	
	public boolean addRegister(CashRegister register) {
		return cashBalancingDao.insertCashRegister(register);
	}


	public CashRegister createRegister(ParkedVehicleData parkedVehicleData) {
		CashRegister cashRegister = new CashRegister();
		Date date = new Date();
		cashRegister.setDateOfIssue(DateHelper.getActualDay(date) + "   "
				+ DateHelper.getActualHour(date));
		String vehicle = "(" + parkedVehicleData.getParkingLot().getVehicle() + ")   " 
				+ parkedVehicleData.getParkingLot().getPlate();
		cashRegister.setVehicle(vehicle);
		String admission = parkedVehicleData.getParkingLot().getAdmissionDate() + "   "
				+ parkedVehicleData.getParkingLot().getAdmissionHour();
		cashRegister.setAdmission(admission);
		String parkedTime = parkedVehicleData.getTimeParked();
		cashRegister.setParkedTime(parkedTime);
		cashRegister.setPartial(parkedVehicleData.getPartialAmountPayable() + "");
		cashRegister.setDiscount(parkedVehicleData.getDiscount() + "");
		cashRegister.setTotal(parkedVehicleData.getTotalAmountPayable() + "");
		return cashRegister;
	}


	public String getCashBalancingData() {
		String response = "";
		ArrayList<CashRegister> registers = listCashRegisters();
		
		if(registers == null) {
			response = "No hay registros.";
		} else {
			response = generateCashBalancingMessage(registers);
		}
		
		return response;
	}
	
	private String generateCashBalancingMessage(ArrayList<CashRegister> registers) {
		StringBuilder stringBuilder = new StringBuilder();
		double total = 0;
		
		for(CashRegister register : registers) {
			stringBuilder.append("\n");
			stringBuilder.append("\n");
			stringBuilder.append(register.getDateOfIssue());
			stringBuilder.append("\n");
			stringBuilder.append("VEHICULO:   ");
			stringBuilder.append(register.getVehicle());
			stringBuilder.append("\n");
			stringBuilder.append("INGRESO:   ");
			stringBuilder.append(register.getAdmission());
			stringBuilder.append("\n");
			stringBuilder.append("TIEMPO APARCADO:   ");
			stringBuilder.append(register.getParkedTime());
			stringBuilder.append("\n");
			stringBuilder.append("PARCIAL:   $ ");
			stringBuilder.append(register.getPartial());
			stringBuilder.append("\n");
			stringBuilder.append("DESCUENTO:   % ");
			stringBuilder.append(register.getDiscount());
			stringBuilder.append("\n");
			stringBuilder.append("FINAL:   $ ");
			stringBuilder.append(register.getTotal());
			stringBuilder.append("\n");
			stringBuilder.append("\n");
			stringBuilder.append("- - - - - - - - - - - - - - - - - - - - - - - - ");
			
			total += Double.parseDouble(register.getTotal());
			
		}
		stringBuilder.append("\n");
		stringBuilder.append("\n");
		stringBuilder.append("RECAUDACION TOTAL:       $ ");
		stringBuilder.append(total + "");
		
		return stringBuilder.toString();
	}


	public ArrayList<CashRegister> listCashRegisters() {
		return cashBalancingDao.listCashRegisters();
	}

}
