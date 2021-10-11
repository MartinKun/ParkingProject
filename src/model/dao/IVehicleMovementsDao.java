package model.dao;

public interface IVehicleMovementsDao {

	boolean insertRegister(String register);
	
	String getRegisters();
	
    void cleanFile();
}
