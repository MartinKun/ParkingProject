package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import helpers.DateHelper;
import model.LoginLogic;
import model.ParkingLogic;
import model.dao.ParkingLotDao;
import model.entity.ParkingLot;
import model.entity.User;
import view.components.DetailPanel;
import view.frames.LoginDialog;
import view.frames.MainFrame;
import view.frames.ReportsDialog;
import view.table.view.TablePanel;

public class Controller {

	private LoginDialog loginDialog;
	private MainFrame mainFrame;
	private LoginLogic loginLogic;
	private ParkingLogic parkingLogic;
	private DetailPanel detailPanel;
	private TablePanel tablePanel;
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

	public void setParkingLogic(ParkingLogic parkingLogic) {
		this.parkingLogic = parkingLogic;

	}

	public void setDetailPanel(DetailPanel detailPanel) {
		this.detailPanel = detailPanel;

	}

	public void setTablePanel(TablePanel tablePanel) {
		this.tablePanel = tablePanel;

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

	public boolean enterVehicle(String plateNumber, String vehicle, String spot) {

		boolean response = false;

		if (plateNumber.equals("")) {

			JOptionPane.showMessageDialog(mainFrame, "Debe ingresar el numero de patente del vehiculo,", "Error",
					JOptionPane.WARNING_MESSAGE);

		} else {

			if (vehicle.equals("Tipo de Vehiculo")) {

				JOptionPane.showMessageDialog(mainFrame, "Debe especificar el tipo de vehiculo que va a ingresar.",
						"Error", JOptionPane.WARNING_MESSAGE);

			} else {

				if (parkingLogic.validateVehiclePlateNumber(plateNumber)) {

					Date actualDate = new Date();

					ParkingLot parkingLot = new ParkingLot(Integer.valueOf(spot), vehicle, plateNumber,
							DateHelper.getActualDay(actualDate), DateHelper.getActualHour(actualDate));

					response = true;

					if (parkingLogic.enterVehicle(parkingLot)) {
						JOptionPane.showMessageDialog(mainFrame, "El vehiculo ha sido ingresado con exito.", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} else {

					JOptionPane.showMessageDialog(mainFrame, "La patente que has ingresado no es valida." + "\n"
							+ "\nPara que la patente ingresada sea valida debe cumplir con el siguiente formato:" + "\n"
							+ "\n- AB 123 CD (Argentina, Venezuela)" + "\n- ABC 1234 (Uruguay)"
							+ "\n- 123 ABCD (Paraguay)" + "\n- ABC 1D23 (Brasil)" + "\n- AB CD 12 (Chile)", "Error",
							JOptionPane.WARNING_MESSAGE);

				}

			}
		}

		return response;
	}

	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(mainFrame, message, "Error", JOptionPane.ERROR_MESSAGE);

	}

	public void buildVehicleTable() {
		tablePanel.buildTable();

	}

	ArrayList<ParkingLot> parkingLots;
	public ArrayList<ParkingLot> getParkingLots() {

		if(parkingLots == null) {
		parkingLots = parkingLogic.getParkingLots();
		}
		
		return parkingLots;
	}
	
	public void setParkingLots(ArrayList<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}

	public void buildParkingLotComboBox() {
		
		mainFrame.buildParkingLotComboBox(getParkingLots());

	}

	public void buildSketch() {
		
		mainFrame.buildSketch(getParkingLots());
		
	}

}
