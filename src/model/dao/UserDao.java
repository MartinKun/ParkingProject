package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.Controller;
import model.dto.User;
import sqlite.Connect;

public class UserDao implements IUserDao {

	Controller controller;

	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;

	public void setController(Controller controller) {
		this.controller = controller;

	}

	public User findUser(String username, String password) {

		User response = null;
		int idUser;
		String privilege;

		conn = Connect.getConnection();
		try {
			st = conn.createStatement();

			rs = st.executeQuery("SELECT ID, username, privilege FROM user WHERE username='" + username
					+ "' AND password='" + password + "';");
			while (rs.next()) {
				idUser = rs.getInt("ID");
				privilege = rs.getString("privilege");
				response = new User(idUser, privilege, username, null);
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

		return response;

	}

}
