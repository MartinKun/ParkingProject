package controller;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.io.File;

import helpers.DateHelper;
import helpers.DisplayManager;
import model.CashRegistersLogic;
import model.LoginLogic;
import model.ParkingLogic;
import model.domain.CashRegister;
import model.domain.ParkedVehicleData;
import model.domain.ParkingLot;
import model.domain.TimeParked;
import model.domain.User;
import view.components.DetailPanel;
import view.frames.AboutDialog;
import view.frames.ChangePriceDialog;
import view.frames.GetPaidDialog;
import view.frames.LoginDialog;
import view.frames.MainFrame;
import view.frames.ReportsDialog;
import view.table.view.TablePanel;

public class Controller {

	private LoginDialog loginDialog;
	private MainFrame mainFrame;
	private LoginLogic loginLogic;
	private ParkingLogic parkingLogic;
	private CashRegistersLogic cashRegistersLogic;
	private DetailPanel detailPanel;
	private TablePanel tablePanel;
	private ReportsDialog reportsDialog;
	private ChangePriceDialog changePriceDialog;
	private DisplayManager displayManager;
	private GetPaidDialog getPaidDialog;
	private AboutDialog aboutDialog;

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

	public void setCashRegistersLogic(CashRegistersLogic cashRegistersLogic) {
		this.cashRegistersLogic = cashRegistersLogic;

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

	public void setChangePriceDialog(ChangePriceDialog changePriceDialog) {
		this.changePriceDialog = changePriceDialog;
	}
	
	public void setAboutDialog(AboutDialog aboutDialog) {
		this.aboutDialog = aboutDialog;
		
	}

	public void setDisplayManager(DisplayManager displayManager) {
		this.displayManager = displayManager;

	}

	public void setGetPaidDialog(GetPaidDialog getPaidDialog) {
		this.getPaidDialog = getPaidDialog;
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
		String cashBalancingData = cashRegistersLogic.getCashBalancingData();
		String vehicleMovementsData = parkingLogic.getVehicleMovementsData();
		reportsDialog.displayCashBalancingData(cashBalancingData);
		reportsDialog.displayVehicleMovementsData(vehicleMovementsData);
		reportsDialog.setVisible(true);

	}

	public void openChangePriceDialog() {
		changePriceDialog.setVisible(true);
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
						parkingLogic.insertEnterVehicleRegister(parkingLot);
						JOptionPane.showMessageDialog(mainFrame, "El vehiculo ha sido ingresado con exito.", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} else {

					JOptionPane.showMessageDialog(mainFrame, "La patente que has ingresado no es valida." + "\n"
							+ "\nPara que la patente ingresada sea valida debe cumplir con uno de los siguientes formatos:"
							+ "\n" + "\n- AB 123 CD (Argentina, Venezuela)" + "\n- ABC 1234 (Uruguay)"
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

	public void initData() {
		parkingLogic.initData();
		parkingLogic.getPriceByHour();

	}

	public void buildVehicleTable(ArrayList<ParkingLot> parkingLots) {
		tablePanel.buildTable(parkingLots);

	}

	public void buildAvailableSpotsMessage(int availableSpotsNumber) {

		String message = "";

		if (availableSpotsNumber == 0) {
			mainFrame.setAvailableSpotsMessage("NO HAY MAS LUGAR", new Color(178, 34, 34));
			mainFrame.setEnableEnterVehicleButton(false);
		} else if (availableSpotsNumber > 0 && availableSpotsNumber <= 3) {
			message = "Lugares disponibles: " + availableSpotsNumber;
			mainFrame.setAvailableSpotsMessage(message, new Color(178, 34, 34));
			mainFrame.setEnableEnterVehicleButton(true);
		} else {
			message = "Lugares disponibles: " + availableSpotsNumber;
			mainFrame.setAvailableSpotsMessage(message, new Color(0, 204, 0));
			mainFrame.setEnableEnterVehicleButton(true);
		}
	}

	public void makeSameSelection(int itemSelected) {
		mainFrame.selectParkingLotLabel(itemSelected);
		tablePanel.selectRow(itemSelected);

		ParkingLot parkingLotSelected = parkingLogic.getParkingLots().get(itemSelected - 1);
		detailPanel.setData(parkingLotSelected);
	}

	public boolean confirmRemoveVehicle() {
		boolean response = false;
		int resp = JOptionPane.showConfirmDialog(null, "Estas seguro que quieres quitar el vehiculo de la planilla?");
		if (JOptionPane.OK_OPTION == resp) {
			response = true;
		}
		return response;
	}

	public void successVehicleRemovedMessage() {
		JOptionPane.showMessageDialog(mainFrame, "El vehiculo ha sido quitado con exito.", "Aviso",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public boolean confirmGetPaid() {
		boolean response = false;
		int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea llevar adelante esta accion?");
		if (JOptionPane.OK_OPTION == resp) {
			response = true;
		}
		return response;
	}

	public boolean removeParkingLot(ParkingLot parkingLotSelected) {
		parkingLogic.insertExitVehicleRegister(parkingLotSelected);

		return parkingLogic.removeParkingLot(parkingLotSelected);

	}

	public void displayTimeParkedAndTotalAmountPayable(JLabel timeParkedLbl, JLabel totalAmountPayableLbl,
			ParkingLot parkingLotSelected) {

		displayManager.setTimeParkedLbl(timeParkedLbl);
		displayManager.setTotalAmountPayableLbl(totalAmountPayableLbl);

		if (!parkingLotSelected.getAdmissionDate().equals("-")) {
			timeParkedLbl.setText("Loading...");

			if (displayManager.isTimerInit) {
				displayManager.stopTimer();
			}
			TimeParked timeParked = DateHelper.getTimeParked(parkingLotSelected.getAdmissionDate(),
					parkingLotSelected.getAdmissionHour());
			displayManager.setDays(timeParked.getDay());
			displayManager.setHours(timeParked.getHour());
			displayManager.setMinutes(timeParked.getMinutes());
			displayManager.setSeconds(timeParked.getSeconds());

			displayManager.calculateAmountPayable();
			displayManager.displayAmountPayable();

			displayManager.initTimer();

		} else {
			if (displayManager.isTimerInit) {
				displayManager.stopTimer();
			}
			timeParkedLbl.setText("-");
			totalAmountPayableLbl.setText("");
		}

	}

	public boolean validateChangePriceTextField(String priceText) {
		return parkingLogic.validateChangePriceTextField(priceText);
	}

	public boolean confirmChangePrice() {
		boolean response = false;

		int resp = JOptionPane.showConfirmDialog(null, "Tenga en cuenta que tambien se actualizaran los montos totales "
				+ "\nde los vehiculos estacionados en este mismo momento." + "\n¿Desea llevar adelante esta accion?");

		if (JOptionPane.OK_OPTION == resp) {
			response = true;
		}

		return response;
	}

	public void successUpdatePriceMessage() {
		JOptionPane.showMessageDialog(mainFrame, "Valores Ingresados correctamente", "Aviso",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void updatePrice(String priceText) {

		boolean isPriceUpdate = parkingLogic.updatePriceByHour(priceText);
		if (isPriceUpdate) {
			changePriceDialog.dispose();
			successUpdatePriceMessage();
			restartDetailPanelValues();

		}

	}

	public void openGetPaidDialog(ParkingLot parkingLotSelected) {
		if (parkingLotSelected == null || parkingLotSelected.getVehicle().equals("-")) {
			showErrorMessage("Debe seleccionar un vehiculo.");
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			if (displayManager.getDays() != 0) {
				stringBuilder.append(displayManager.getDays());
				stringBuilder.append("dias");
			}
			stringBuilder.append(" ");
			stringBuilder.append(displayManager.getHours());
			stringBuilder.append("horas");
			stringBuilder.append(" ");
			stringBuilder.append(displayManager.getMinutes());
			stringBuilder.append("min");
			stringBuilder.append(" ");
			stringBuilder.append(displayManager.getSeconds());
			stringBuilder.append("seg");

			ParkedVehicleData ticket = new ParkedVehicleData(parkingLotSelected, stringBuilder.toString(),
					displayManager.getAmountPayable(), 0);

			parkingLogic.setParkedVehicleData(ticket);
			displayTicketInfo();
			showTotalAmountPayable();
			getPaidDialog.setVisible(true);
		}

	}

	public void displayTicketInfo() {
		String message = parkingLogic.generateMessageTicketInfo();
		getPaidDialog.displayTicketInfo(message);
	}

	public void showTotalAmountPayable() {
		ParkedVehicleData parkedVehicleData = parkingLogic.getParkedVehicleData();
		getPaidDialog.showTotalAmountPayable(parkedVehicleData.getTotalAmountPayable());
	}

	public void setDiscount(double discount) {
		parkingLogic.setDiscount(discount);
		showTotalAmountPayable();
	}

	public boolean validateDiscountTextField(String discountText) {
		boolean response = parkingLogic.validateDiscountTextField(discountText);
		return response;
	}

	public boolean createCashRegister() {

		boolean response = false;

		if (confirmGetPaid()) {
			ParkedVehicleData parkedVehicleData = parkingLogic.getParkedVehicleData();

			CashRegister register = cashRegistersLogic.createRegister(parkedVehicleData);
			response = cashRegistersLogic.addRegister(register);

			if (response) {
				removeParkingLot(parkedVehicleData.getParkingLot());
				getPaidDialog.dispose();
				getPaidDialog.restartValues();
				restartDetailPanelValues();
			}

		}

		return response;

	}

	public void restartDetailPanelValues() {
		displayManager.stopTimer();
		detailPanel.setRestartValues();
		mainFrame.deselectAllParkingLotLabels();
	}

	public void successCreateCashRegister() {
		JOptionPane.showMessageDialog(mainFrame,
				"El registro ha sido guardado exitosamente.\n"
						+ "Podra ver los registros guardados en la pantalla de \"Reportes\"  ",
				"Aviso", JOptionPane.INFORMATION_MESSAGE);

	}

	public boolean saveFile(File file, String document) {
		
		return parkingLogic.saveFile(file, document);
	}

	public void successSaveFile() {
		JOptionPane.showMessageDialog(mainFrame,
				"El archivo ha sido guardado.","Aviso", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public boolean cleanVehicleMovementsFile() {
		return parkingLogic.cleanVehicleMovementsFile();
		
	}

	public boolean cleanCashBalancingFile() {
		return parkingLogic.cleanCashBalancingFile();
		
	}

	public void openAboutDialog() {
		aboutDialog.setVisible(true);
		
	}
}
