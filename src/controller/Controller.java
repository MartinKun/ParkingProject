package controller;

import javax.swing.JOptionPane;

import jdk.nashorn.internal.scripts.JO;
import model.LoginLogic;
import model.entity.User;
import view.components.DetailPanel;
import view.frames.LoginDialog;
import view.frames.MainFrame;
import view.frames.ReportsDialog;

public class Controller {

	private LoginDialog loginDialog;
	private MainFrame mainFrame;
	private LoginLogic loginLogic;
	private DetailPanel detailPanel;
	private ReportsDialog reportsDialog;

	public void setLoginDialog(LoginDialog loginDialog) {
		this.loginDialog = loginDialog;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void setLoginLogic(LoginLogic loginLogic) {
		this.loginLogic = loginLogic;
	}
	
	public void setDetailPanel(DetailPanel detailPanel) {
		this.detailPanel = detailPanel;
		
	}
	
	public void setReportsDialog(ReportsDialog reportsDialog) {
		this.reportsDialog = reportsDialog;
		
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
		detailPanel.setPrivileges(userName);
		reportsDialog.setPrivileges(userName);

	}

	public void logout() {
		mainFrame.restartValues();
		detailPanel.restartValues();
		reportsDialog.setVisible(false);
		loginDialog.setVisible(true);

	}

	public void openReportsDialog() {
		reportsDialog.setVisible(true);
		
	}

}
