package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Controller;
import sqlite.Connect;

public class PriceByHourDao implements IPriceByHourDao {

	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	Double priceByHour = null;

	private Controller controller;

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public String getPriceByHour() {
		conn = Connect.getConnection();
		try {
			st = conn.createStatement();

			rs = st.executeQuery("SELECT ID, by_hour FROM price;");
			while (rs.next()) {
				priceByHour = rs.getDouble("by_hour");
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		return priceByHour.toString();
	}

	@Override
	public boolean updatePriceByHour(String priceByHourStr) {

		boolean response = false;
		priceByHour = Double.valueOf(priceByHourStr);

		conn = Connect.getConnection();
		try {
			st = conn.createStatement();

			rs = st.executeQuery("UPDATE price SET by_hour = " + priceByHour + ";");
			
			response = true;
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		
		
		return response;

	}

}
