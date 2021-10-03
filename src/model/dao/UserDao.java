package model.dao;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import controller.Controller;
import model.entity.User;
import model.entity.Users;
import xmlsrc.XMLFilesGenerator;

public class UserDao implements IUserDao {

	Controller controller;
	private String usersFilePath = XMLFilesGenerator.getUsersFilePath();

	@Override
	public ArrayList<User> listUsers() {

		Users users = null;
		ArrayList<User> usersList = null;

		try {
			JAXBContext context = JAXBContext.newInstance(Users.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File(usersFilePath);
			users = (Users) unmarshaller.unmarshal(file);

			if (users != null) {
				usersList = users.getUsers();
			}

		} catch (JAXBException e) {
			controller.showErrorMessage("Se encontraron problemas para leer el archivo " + usersFilePath);
			e.printStackTrace();
		}

		return usersList;
	}

	public void setController(Controller controller) {
		this.controller = controller;

	}

}
