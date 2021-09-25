package model.dao;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import controller.Controller;
import model.entity.User;
import model.entity.Users;

public class UserDao implements IUserDao {

	Controller controller;

	@Override
	public ArrayList<User> listUsers() {

		Users users = null;
		ArrayList<User> usersList = null;

		try {
			JAXBContext context = JAXBContext.newInstance(Users.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("C:\\Users\\conde\\Documents\\NetBeansProjects\\LoginProject\\src\\xmlsrc\\users.xml");
			users = (Users) unmarshaller.unmarshal(file);

			if (users != null) {
				usersList = users.getUsers();
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return usersList;
	}

	public void setController(Controller controller) {
		this.controller = controller;

	}

}
