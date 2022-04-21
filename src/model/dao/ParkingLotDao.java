package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.Controller;
import model.dto.Detail;
import model.dto.ParkingLot;
import model.dto.Vehicle;
import sqlite.Connect;

public class ParkingLotDao implements IParkingLotDao {

	Controller controller;
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	private String SQL_LIST_PARKING_LOTS = "SELECT p.ID, p.spot, v.ID, v.type, v.plate, d.ID, d.entry_date, d.departure_date FROM parking_lot p "
			+ "LEFT OUTER JOIN vehicle v ON p.id_vehicle = v.ID " + "LEFT OUTER JOIN detail d ON v.id_detail = d.ID";

	private String SQL_FIND_PARKING_LOT_BY_ID = "SELECT p.ID, p.spot, v.ID, v.type, v.plate, d.ID, d.entry_date, d.departure_date FROM parking_lot p "
			+ "LEFT OUTER JOIN vehicle v ON p.id_vehicle = v.ID "
			+ "LEFT OUTER JOIN detail d ON v.id_detail = d.ID WHERE p.ID = ?";

	private String SQL_INSERT_PARKING_LOT = "INSERT INTO parking_lot (spot, id_vehicle) VALUES(?, ?)";
	private String SQL_UPDATE_PARKING_LOT = "UPDATE parking_lot SET spot = ?, id_vehicle = ? WHERE ID = ?";

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public List<ParkingLot> listParkingLots() {

		List<ParkingLot> parkingLots = new ArrayList<>();

		try {
			conn = Connect.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(SQL_LIST_PARKING_LOTS);

			while (rs.next()) {
				int idParkingLot = rs.getInt(1);
				int spot = rs.getInt(2);
				int idVehicle = rs.getInt(3);
				String type = rs.getString(4);
				String plate = rs.getString(5);
				int idDetail = rs.getInt(6);
				Date entryDate = rs.getDate(7);
				Date departureDate = rs.getDate(8);

				if (idVehicle != 0) {

					if (idDetail != 0) {
						parkingLots.add(new ParkingLot(idParkingLot, spot,
								new Vehicle(idVehicle, type, plate, new Detail(idDetail, entryDate, departureDate))));
					} else {
						parkingLots.add(new ParkingLot(idParkingLot, spot, new Vehicle(idVehicle, type, plate, null)));
					}

				} else {
					parkingLots.add(new ParkingLot(idParkingLot, spot, null));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		return parkingLots;
	}

	@Override
	public ParkingLot findParkingLotById(int id) {
		ParkingLot response = null;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_FIND_PARKING_LOT_BY_ID);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				int idParkingLot = rs.getInt(1);
				int spot = rs.getInt(2);
				int idVehicle = rs.getInt(3);
				String type = rs.getString(4);
				String plate = rs.getString(5);
				int idDetail = rs.getInt(6);
				Date entryDate = rs.getDate(7);
				Date departureDate = rs.getDate(8);

				if (idVehicle != 0) {

					if (idDetail != 0) {
						response = new ParkingLot(idParkingLot, spot,
								new Vehicle(idVehicle, type, plate, new Detail(idDetail, entryDate, departureDate)));
					} else {
						response = new ParkingLot(idParkingLot, spot, new Vehicle(idVehicle, type, plate, null));
					}

				} else {
					response = new ParkingLot(idParkingLot, spot, null);
				}

			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		return response;
	}

	@Override
	public ParkingLot insertParkingLot(ParkingLot parkingLot) {

		int rowsModified;
		ParkingLot response = null;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_INSERT_PARKING_LOT, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, parkingLot.getSpot());

			if (parkingLot.getVehicle() != null) {
				ps.setInt(2, parkingLot.getVehicle().getId());
			} else {
				ps.setNull(2, java.sql.Types.NULL);
			}

			rowsModified = ps.executeUpdate();

			if (rowsModified > 0) {

				rs = ps.getGeneratedKeys();

				response = parkingLot;

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
	public boolean updateParkingLot(ParkingLot parkingLot) {

		int rowsModified;
		boolean response = false;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_UPDATE_PARKING_LOT);
			ps.setInt(1, parkingLot.getSpot());

			if (parkingLot.getVehicle() != null) {
				ps.setInt(2, parkingLot.getVehicle().getId());
			} else {
				ps.setNull(2, java.sql.Types.NULL);
			}

			ps.setInt(3, parkingLot.getId());
			
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
