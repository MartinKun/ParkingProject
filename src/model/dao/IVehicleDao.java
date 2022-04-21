package model.dao;

import model.dto.Vehicle;

public interface IVehicleDao {

	Vehicle insertVehicle(Vehicle vehicle);

	//Vehicle findVehicleById(int idVehicle);
	
	boolean updateVehicle(Vehicle vehicle);
	
	boolean deleteVehicle(Vehicle vehicle);
}
