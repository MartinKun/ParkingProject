package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.Controller;
import model.dto.CashRegister;
import model.dto.Detail;
import model.dto.PaymentInformation;
import model.dto.Vehicle;
import sqlite.Connect;

public class DetailDao implements IDetailDao {

	Controller controller;
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	private String SQL_INSERT_DETAIL = "INSERT INTO detail (entry_date, departure_date) VALUES(?, ?)";

	private String SQL_FIND_DETAIL_BY_ID = "SELECT entry_date, departure_date FROM detail WHERE ID = ?";

	private String SQL_UPDATE_DETAIL = "UPDATE detail SET entry_date = ?, departure_date = ? WHERE ID = ?";

	private String SQL_DELETE_DETAIL = "DELETE FROM detail WHERE ID = ?";

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public Detail insertDetail(Detail detail) {
		Detail response = null;
		int rowsModified;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_INSERT_DETAIL, Statement.RETURN_GENERATED_KEYS);

			ps.setDate(1, new java.sql.Date(detail.getEntryDate().getTime()));

			if (detail.getDepartureDate() != null) {
				ps.setDate(2, new java.sql.Date(detail.getDepartureDate().getTime()));
			} else {
				ps.setNull(2, java.sql.Types.NULL);
			}

			rowsModified = ps.executeUpdate();

			if (rowsModified != 0) {

				response = detail;

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
	public Detail findDetailById(int id) {

		Detail response = null;

		try {
			conn = Connect.getConnection();

			ps = conn.prepareStatement(SQL_FIND_DETAIL_BY_ID);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				Date entryDate = rs.getDate(1);
				Date departureDate = rs.getDate(2);

				response = new Detail(id, entryDate, departureDate);

			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		return response;
	}

	@Override
	public boolean updateDetail(Detail detail) {
		boolean response = false;
		int rowsModified;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_UPDATE_DETAIL);

			ps.setDate(1, new java.sql.Date(detail.getEntryDate().getTime()));
			ps.setDate(2, new java.sql.Date(detail.getDepartureDate().getTime()));

			ps.setInt(3, detail.getId());

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
	public boolean deleteDetail(Detail detail) {
		boolean response = false;
		int rowsModified;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_DELETE_DETAIL);
			ps.setInt(1, detail.getId());

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
