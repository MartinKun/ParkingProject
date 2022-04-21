package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Controller;
import model.dto.Vehicle;
import sqlite.Connect;

public class VehicleDao implements IVehicleDao {

	Controller controller;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	private String SQL_INSERT_VEHICLE = "INSERT INTO vehicle (type, plate, id_detail) VALUES(?, ?, ?)";
	//private String SQL_FIND_VEHICLE_BY_ID = "SELECT ID, type, plate FROM vehicle WHERE ID=?";
	private String SQL_UPDATE_VEHICLE = "UPDATE vehicle SET type = ?, plate = ?, id_detail = ? WHERE ID = ?";
	private String SQL_DELETE_VEHICLE = "DELETE FROM vehicle WHERE ID = ?";

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public Vehicle insertVehicle(Vehicle vehicle) {
		Vehicle response = null;
		int rowsModified;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_INSERT_VEHICLE, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, vehicle.getType());
			ps.setString(2, vehicle.getPlate());
			ps.setInt(3, vehicle.getDetail().getId());

			rowsModified = ps.executeUpdate();

			if (rowsModified != 0) {

				response = vehicle;

				rs = ps.getGeneratedKeys();

				if (rs.next()) {
					response.setId(rs.getInt(1));
				}

			}

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		return response;
	}
	
	@Override
	public boolean updateVehicle(Vehicle vehicle) {
		
		int rowsModified;
		boolean response = false;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_UPDATE_VEHICLE);
			ps.setString(1, vehicle.getType());
			ps.setString(2, vehicle.getPlate());
			
			if(vehicle.getDetail() != null) {
				ps.setInt(3, vehicle.getDetail().getId());
			} else {
				ps.setNull(3, java.sql.Types.NULL);
			}
			ps.setInt(4, vehicle.getId());

			rowsModified = ps.executeUpdate();

			if (rowsModified > 0) {
				response = true;
			}

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		return response;
	}

	@Override
	public boolean deleteVehicle(Vehicle vehicle) {

		boolean response = false;
		int rowsModified;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_DELETE_VEHICLE);
			ps.setInt(1, vehicle.getId());

			rowsModified = ps.executeUpdate();

			if (rowsModified > 0) {
				response = true;
			}

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		return response;

	}

}
