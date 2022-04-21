package model.dao;

import model.dto.User;

public interface IUserDao {
	
	User findUser(String username, String password);
	
}
