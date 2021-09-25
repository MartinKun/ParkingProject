package model.entity;

import javax.xml.bind.annotation.XmlAttribute;

public class User {
	
	String privilege;
	private String username;
	private String password;

	public User() {
		
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@XmlAttribute
	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
