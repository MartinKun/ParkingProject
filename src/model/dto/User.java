package model.dto;

public class User {

	private int id;
	private String privilege;
	private String username;
	private String password;

	public User(int id, String privilege, String username, String password) {
		this.id = id;
		this.privilege = privilege;
		this.username = username;
		this.password = password;
	}

	public User(String privilege, String username, String password) {
		this.privilege = privilege;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
