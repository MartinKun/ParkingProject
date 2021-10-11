package model.domain;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
public class Users {

	ArrayList<User> users;

	public Users() {

	}

	@XmlElement(name = "user")
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> user) {
		this.users = user;
	}

}
