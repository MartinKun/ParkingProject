package controller;

import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.io.File;

import helpers.DateHelper;
import helpers.DisplayManager;
import helpers.LanguageManager;
import model.CashRegistersLogic;
import model.LoginLogic;
import model.ParkingLogic;
import model.dto.CashRegister;
import model.dto.Detail;
import model.dto.ParkingLot;
import model.dto.PaymentInformation;
import model.dto.TimeParked;
import model.dto.User;
import model.dto.Vehicle;
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
	private LanguageManager languageManager = LanguageManager.getInstance();
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

	public void setLanguageManager(LanguageManager languageManager) {
		this.languageManager = languageManager;

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

	public String validateUser(User user) {
		String response = "";

		if (user.getUsername().equals("username") || user.getPassword().equals("password")) {
			JOptionPane.showMessageDialog(loginDialog, languageManager.getProperty("alert.empty_fields"), "Error",
					JOptionPane.WARNING_MESSAGE);
		} else {
			user = loginLogic.validateUser(user);
			if (user != null) {
				response = user.getPrivilege();
			} else {
				JOptionPane.showMessageDialog(loginDialog, languageManager.getProperty("alert.wrong_values"), "Error",
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
		mainFrame.resetPrivileges();
		detailPanel.resetPrivileges();
		reportsDialog.setVisible(false);
		loginDialog.setVisible(true);

	}

	public void openReportsDialog() {
		
		List<CashRegister> registers = cashRegistersLogic.listCashRegisters();
		String cashBalancingData = cashRegistersLogic.getCashBalancingData(registers);
		
		String vehicleMovementsData = parkingLogic.getVehicleMovementsData();
		reportsDialog.displayCashBalancingData(cashBalancingData);
		reportsDialog.displayVehicleMovementsData(vehicleMovementsData);
		reportsDialog.setVisible(true);

	}

	public void openChangePriceDialog() {
		changePriceDialog.setVisible(true);
	}

	public boolean enterVehicle(Vehicle vehicle, int spot) {

		boolean response = false;

		if (vehicle.getPlate().equals("")) {

			JOptionPane.showMessageDialog(mainFrame, languageManager.getProperty("alert.empty_plate"), "Error",
					JOptionPane.WARNING_MESSAGE);

		} else {

			if (vehicle.getType().equals(languageManager.getProperty("main.vehicle_type"))) {

				JOptionPane.showMessageDialog(mainFrame, languageManager.getProperty("alert.empty_vehicle_type"),
						"Error", JOptionPane.WARNING_MESSAGE);

			} else {

				if (vehicle.getType().equals("Motocicleta")) {
					vehicle.setType("Motorcycle");
				} else if (vehicle.getType().equals("Automovil")) {
					vehicle.setType("Car");
				}

				if (parkingLogic.validateVehiclePlate(vehicle.getPlate())) {

					// Insert the detail with the entry date of the vehicle in the database
					Detail detail = parkingLogic.insertDetail(new Detail(new Date(), null));

					// Insert the vehicle data in the database
					if (detail.getId() != 0) {
						vehicle.setDetail(detail);
						vehicle = parkingLogic.insertVehicle(vehicle);

						if (vehicle.getId() != 0) {
							// Update the data of the parking slot in which the vehicle has been parked
							response = parkingLogic.updateParkingSlot(new ParkingLot(spot, spot, vehicle));

							if (response) {
								parkingLogic.saveVehicleEntryRecord(vehicle, spot);
								initData();
								JOptionPane.showMessageDialog(mainFrame,
										languageManager.getProperty("info.vehicle_enter_success"),
										languageManager.getProperty("notice"), JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}

				} else {

					JOptionPane.showMessageDialog(mainFrame, languageManager.getProperty("alert.wrong_plate"), "Error",
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
		parkingLogic.getPriceByHour();
		parkingLogic.initData();

	}

	public void buildVehicleTable(List<ParkingLot> parkingLots) {
		tablePanel.buildTable(parkingLots);

	}

	public void buildAvailableSpotsMessage(int availableSpotsNumber) {

		String message = "";

		if (availableSpotsNumber == 0) {
			mainFrame.setAvailableSpotsMessage(languageManager.getProperty("no_more_spots"), new Color(178, 34, 34));
			mainFrame.setEnableEnterVehicleButton(false);
		} else if (availableSpotsNumber > 0 && availableSpotsNumber <= 3) {
			message = languageManager.getProperty("available_spots") + availableSpotsNumber;
			mainFrame.setAvailableSpotsMessage(message, new Color(178, 34, 34));
			mainFrame.setEnableEnterVehicleButton(true);
		} else {
			message = languageManager.getProperty("available_spots") + availableSpotsNumber;
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
		int resp = JOptionPane.showConfirmDialog(null, languageManager.getProperty("confirm.remove_vehicle"));
		if (JOptionPane.OK_OPTION == resp) {
			response = true;
		}
		return response;
	}

	public void successVehicleRemovedMessage() {
		JOptionPane.showMessageDialog(mainFrame, languageManager.getProperty("info.remove_vehicle"),
				languageManager.getProperty("notice"), JOptionPane.INFORMATION_MESSAGE);
	}

	public boolean confirmGetPaid() {
		boolean response = false;
		int resp = JOptionPane.showConfirmDialog(null, languageManager.getProperty("confirm.generic_question"));
		if (JOptionPane.OK_OPTION == resp) {
			response = true;
		}
		return response;
	}

	public boolean removeVehicle(Vehicle vehicle, int spot) {

		boolean response = false;

		// Update the detail with the departure date of the vehicle in the database
		vehicle.getDetail().setDepartureDate(new Date());
		if (parkingLogic.updateDetail(vehicle.getDetail())) {

			// Set the parking slot to null
			if (parkingLogic.updateParkingSlot(new ParkingLot(spot, spot, null))) {

				response = parkingLogic.saveVehicleExitRecord(vehicle, spot);

				if (response) {
					initData();
				}
			}
		}

		return response;
	}

	public void displayTimeParkedAndTotalAmountPayable(JLabel timeParkedLbl, JLabel totalAmountPayableLbl,
			ParkingLot parkingLotSelected) {

		displayManager.setTimeParkedLbl(timeParkedLbl);
		displayManager.setTotalAmountPayableLbl(totalAmountPayableLbl);

		if (parkingLotSelected.getVehicle() != null) {
			timeParkedLbl.setText("Loading...");

			if (displayManager.isTimerInit) {
				displayManager.stopTimer();
			}

			TimeParked timeParked = DateHelper.getTimeParked(parkingLotSelected.getVehicle().getDetail().getEntryDate(),
					new Date());
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

		int resp = JOptionPane.showConfirmDialog(null, languageManager.getProperty("confirm.change_price"));

		if (JOptionPane.OK_OPTION == resp) {
			response = true;
		}

		return response;
	}

	public void successUpdatePriceMessage() {
		JOptionPane.showMessageDialog(mainFrame, languageManager.getProperty("info.change_price_success"),
				languageManager.getProperty("notice"), JOptionPane.INFORMATION_MESSAGE);
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
		if (parkingLotSelected == null || parkingLotSelected.getVehicle() == null) {
			showErrorMessage(languageManager.getProperty("alert.no_vehicle_selected"));
		} else {

			PaymentInformation paymentInformation = new PaymentInformation(displayManager.getAmountPayable(), 0,
					displayManager.getAmountPayable());

			getPaidDialog.setParkingLot(parkingLotSelected);
			getPaidDialog.setPaymentInformation(paymentInformation);
			displayTicket();

			getPaidDialog.setVisible(true);
		}

	}

	public void displayTicket() {
		getPaidDialog.displayTicket();
	}

	public String generateTicket(String type, String plate, Date entryDate, Date departureDate, double partial) {
		return parkingLogic.generateTicket(type, plate, entryDate, departureDate, partial);
	}

	public boolean validateDiscountTextField(String discountText) {
		boolean response = parkingLogic.validateDiscountTextField(discountText);
		return response;
	}

	public void restartDetailPanelValues() {
		displayManager.stopTimer();
		detailPanel.restartValues();
		mainFrame.deselectAllParkingLotLabels();
	}

	public boolean createCashRegister(ParkingLot parkingLotSelected, PaymentInformation paymentInformation) {

		boolean response = false;

		paymentInformation = cashRegistersLogic.insertPayInformation(paymentInformation);

		if (paymentInformation.getId() != 0) {
			CashRegister register = new CashRegister(new Date(), parkingLotSelected.getVehicle(), paymentInformation);
			register = cashRegistersLogic.insertCashRegister(register);

			if (register.getId() != 0) {
				response = true;
			}
		}

		return response;
	}

	public void successCreateCashRegister() {

		getPaidDialog.dispose();
		getPaidDialog.cleanUpResources();

		JOptionPane.showMessageDialog(mainFrame, languageManager.getProperty("info.cash_register_saved"),
				languageManager.getProperty("notice"), JOptionPane.INFORMATION_MESSAGE);
		restartDetailPanelValues();

	}

	public boolean saveFile(File file, String document) {

		return parkingLogic.saveFile(file, document);
	}

	public void successSaveFile() {
		JOptionPane.showMessageDialog(mainFrame, languageManager.getProperty("info.file_saved"),
				languageManager.getProperty("notice"), JOptionPane.INFORMATION_MESSAGE);

	}

	public boolean cleanVehicleMovementsFile() {
		return parkingLogic.cleanVehicleMovementsFile();

	}

	public void openAboutDialog() {
		aboutDialog.setVisible(true);

	}

}
