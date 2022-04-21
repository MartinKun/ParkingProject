
package model;

import helpers.Encoder;
import model.dao.UserDao;
import model.dto.User;

public class LoginLogic {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User validateUser(User user) {

		User response = null;
		
		response = userDao.findUser(user.getUsername(), passwordEncoded(user.getPassword()));

		return response;
	}
	
	private String passwordEncoded(String password) {
		return Encoder.encodePass(password);
	}

}
