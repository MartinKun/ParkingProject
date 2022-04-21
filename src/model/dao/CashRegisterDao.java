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
import model.dto.CashRegister;
import model.dto.Detail;
import model.dto.ParkingLot;
import model.dto.PaymentInformation;
import model.dto.Vehicle;
import sqlite.Connect;

public class CashRegisterDao implements ICashRegisterDao{
	
	Controller controller;
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	private String SQL_LIST_CASH_REGISTER = "SELECT c.ID, c.create_date, v.ID, v.type, v.plate, d.ID, d.entry_date, d.departure_date, p.ID, p.partial, p.discount, p.total "
			+ "FROM cash_register c "
			+ "LEFT OUTER JOIN vehicle v ON c.id_vehicle = v.ID "
			+ "LEFT OUTER JOIN payment_information p ON c.id_payment_information = p.ID "
			+ "LEFT OUTER JOIN detail d ON v.id_detail = d.ID";
	
	private String SQL_INSERT_CASH_REGISTER = "INSERT INTO cash_register (create_date, id_vehicle, id_payment_information) VALUES ( ?, ?, ? )";
	
	private String SQL_DELETE_CASH_REGISTER = "DELETE FROM cash_register WHERE ID = ?";
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public List<CashRegister> listCashRegisters() {
		List<CashRegister> registers = new ArrayList<>();

		try {
			conn = Connect.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(SQL_LIST_CASH_REGISTER);

			while (rs.next()) {
				int idCashRegister = rs.getInt(1);
				Date createDate = rs.getDate(2);
				int idVehicle = rs.getInt(3);
				String type = rs.getString(4);
				String plate = rs.getString(5);
				int idDetail = rs.getInt(6);
				Date entryDate = rs.getDate(7);
				Date departureDate = rs.getDate(8);
				int idPaymentInfo = rs.getInt(9);
				double partial = rs.getDouble(10);
				double discount = rs.getDouble(11);
				double total = rs.getDouble(12);

				registers.add(new CashRegister(idCashRegister, createDate, new Vehicle(idVehicle, type, plate, new Detail(idDetail, entryDate, departureDate)),
						new PaymentInformation(idPaymentInfo, partial, discount, total)));

			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		return registers;
	}

	@Override
	public CashRegister insertCashRegister(CashRegister cashRegister) {
		int rowsModified;
		CashRegister response = null;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_INSERT_CASH_REGISTER, Statement.RETURN_GENERATED_KEYS);
			ps.setDate(1, new java.sql.Date(cashRegister.getCreateDate().getTime()));
			ps.setInt(2, cashRegister.getVehicle().getId());
			ps.setInt(3, cashRegister.getPaymentInformation().getId());
			

			rowsModified = ps.executeUpdate();

			if (rowsModified > 0) {

				rs = ps.getGeneratedKeys();

				response = cashRegister;

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
	public boolean deleteCashRegister(CashRegister cashRegister) {
		boolean response = false;
		int rowsModified;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_DELETE_CASH_REGISTER);
			ps.setInt(1, cashRegister.getId());

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
