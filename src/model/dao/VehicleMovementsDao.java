package model.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import controller.Controller;
import helpers.LanguageManager;
import txt.TxtFilesManagement;

public class VehicleMovementsDao implements IVehicleMovementsDao{
	
	LanguageManager languageManager = LanguageManager.getInstance();
	
	private Controller controller;
	
	private String vehicleMovementsFilePath = TxtFilesManagement.getVehicleMovementsFilePath();
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

	
	@Override
	public boolean insertRegister(String register) {
		boolean response = false;
		
		FileWriter fw = null;
		PrintWriter output = null;
		
		try {
			fw = new FileWriter(vehicleMovementsFilePath,true);
			output = new PrintWriter(fw);
			output.println(register);
			output.flush();
			
			output.close();
			fw.close();
			
			response = true;
		} catch (IOException e) {
			controller.showErrorMessage(
					languageManager.getProperty("alert.cant_write_file") + "" + vehicleMovementsFilePath);
			e.printStackTrace();
		}
		
		return response;
		
	}

	@Override
	public void cleanFile() {
		
		
	}


	@Override
	public String getRegisters() {
		StringBuilder stringBuilder = new StringBuilder();
		String read = "";
		
		FileReader fr = null;
		BufferedReader input = null;
		try {
			fr = new FileReader(vehicleMovementsFilePath);
			input = new BufferedReader(fr);
			read = input.readLine();
			while(read != null) {
				stringBuilder.append(read);
				stringBuilder.append("\n");
				read = input.readLine();
			}
			
		} catch (FileNotFoundException e) {
			controller.showErrorMessage(
					languageManager.getProperty("file_not_found") + " " + vehicleMovementsFilePath + ".");
			e.printStackTrace();
		} catch (IOException e) {
			controller.showErrorMessage(
					languageManager.getProperty("alert.cant_read_file") + ""  + vehicleMovementsFilePath);
			e.printStackTrace();
		} finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					controller.showErrorMessage(
							languageManager.getProperty("alert.cant_read_file") + ""  + vehicleMovementsFilePath);
					e.printStackTrace();
				}
			}
		}
				
		
		return stringBuilder.toString();
	}

}
