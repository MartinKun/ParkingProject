package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import controller.Controller;
import model.dto.PaymentInformation;
import model.dto.Vehicle;
import sqlite.Connect;

public class PaymentInformationDao implements IPaymentInformationDao {

	Controller controller;
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	private String SQL_INSERT_PAYMENT_INFO = "INSERT INTO payment_information (partial, discount, total) VALUES(?, ?, ?)";
	private String SQL_FIND_PAYMENT_INFO_BY_ID = "SELECT partial, discount, total FROM vehicle WHERE ID = ?";
	private String SQL_DELETE_PAYMENT_INFO = "DELETE FROM payment_information WHERE ID = ?";

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public PaymentInformation insertPaymentInformation(PaymentInformation paymentInformation) {
		PaymentInformation response = null;
		int rowsModified;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_INSERT_PAYMENT_INFO, Statement.RETURN_GENERATED_KEYS);
			ps.setDouble(1, paymentInformation.getPartial());
			ps.setDouble(2, paymentInformation.getDiscount());
			ps.setDouble(3, paymentInformation.getTotal());

			rowsModified = ps.executeUpdate();

			if (rowsModified != 0) {

				response = paymentInformation;

				rs = ps.getGeneratedKeys();

				if (rs.next()) {
					paymentInformation.setId(rs.getInt(1));
				}

			}

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		return response;
	}

	@Override
	public PaymentInformation findPaymentInformationById(int id) {
		PaymentInformation response = null;
		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_FIND_PAYMENT_INFO_BY_ID);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				double partial = rs.getDouble("partial");
				double discount = rs.getDouble("discount");
				double total = rs.getDouble("total");

				response = new PaymentInformation(id, partial, discount, total);

			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		return response;
	}

	@Override
	public boolean deletePaymentInformation(PaymentInformation paymentInformation) {
		boolean response = false;
		int rowsModified;

		try {
			conn = Connect.getConnection();
			ps = conn.prepareStatement(SQL_DELETE_PAYMENT_INFO);
			ps.setInt(1, paymentInformation.getId());

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
