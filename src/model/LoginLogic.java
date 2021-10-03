
package model;

import java.util.ArrayList;

import controller.Controller;
import helpers.Encoder;
import model.dao.UserDao;
import model.entity.User;

public class LoginLogic {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;

	}

	public User validateLogin(String username, String password) {

		User response = null;

		ArrayList<User> users = userDao.listUsers();

		for (User user : users) {
			if (username.equals(user.getUsername()) && passwordEncoded(password).equals(user.getPassword())) {
				response = user;
			}
		}

		return response;
	}
	
	public String passwordEncoded(String password) {
		return Encoder.encodePass(password);
	}

}
