package controller;

import javax.swing.JOptionPane;

import jdk.nashorn.internal.scripts.JO;
import model.LoginLogic;
import model.entity.User;
import view.frames.LoginDialog;
import view.frames.MainFrame;

public class Controller {

	private LoginDialog loginDialog;
	private MainFrame mainFrame;
	private LoginLogic loginLogic;

	public void setLoginDialog(LoginDialog loginDialog) {
		this.loginDialog = loginDialog;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void setLoginLogic(LoginLogic loginLogic) {
		this.loginLogic = loginLogic;
	}

	public String validateLogin(String userName, String password) {
		String response = "";

		if (userName.equals("username") || password.equals("password")) {
			JOptionPane.showMessageDialog(loginDialog, "Debe completar los campos primero.", "Error",
					JOptionPane.WARNING_MESSAGE);
		} else {
			User user = loginLogic.validateLogin(userName, password);
			if (user != null) {
				response = user.getPrivilege();
			} else {
				JOptionPane.showMessageDialog(loginDialog, "Los datos ingresados son incorrectos.", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		return response;
	}

	public void setPrivileges(String userName) {

		loginDialog.setVisible(false);

		mainFrame.setPrivileges(userName);

	}

	public void logout() {
		System.out.println("desloguearse");
		loginDialog.setVisible(true);

	}

}
