/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;
import helpers.DisplayManager;
import helpers.LanguageManager;
import model.CashRegistersLogic;
import model.LoginLogic;
import model.ParkingLogic;
import model.dao.CashRegisterDao;
import model.dao.DetailDao;
import model.dao.ParkingLotDao;
import model.dao.PaymentInformationDao;
import model.dao.PriceByHourDao;
import model.dao.UserDao;
import model.dao.VehicleDao;
import model.dao.VehicleMovementsDao;
import view.components.DetailPanel;
import view.frames.AboutDialog;
import view.frames.ChangePriceDialog;
import view.frames.ChooseLanguageFrame;
import view.frames.GetPaidDialog;
import view.frames.LoginDialog;
import view.frames.MainFrame;
import view.frames.ReportsDialog;
import view.table.view.TablePanel;

/**
 *
 * @author conde
 */
public class Application {

	public void initMainApplication() {
		
		// Instantiating the classes
		MainFrame mainFrame = new MainFrame();
		LoginDialog loginDialog = new LoginDialog(mainFrame, true);

		Controller controller = new Controller();

		LoginLogic loginLogic = new LoginLogic();
		ParkingLogic parkingLogic = new ParkingLogic();
		CashRegistersLogic cashRegistersLogic = new CashRegistersLogic();

		UserDao userDao = new UserDao();
		VehicleDao vehicleDao = new VehicleDao();
		DetailDao detailDao = new DetailDao();
		ParkingLotDao parkingLotDao = new ParkingLotDao();
		PriceByHourDao priceByHourDao = new PriceByHourDao();
		CashRegisterDao cashRegisterDao = new CashRegisterDao();
		PaymentInformationDao paymentInformationDao = new PaymentInformationDao();
		VehicleMovementsDao vehicleMovementsDao = new VehicleMovementsDao();

		TablePanel tablePanel = TablePanel.getInstance();
		DetailPanel detailPanel = DetailPanel.getInstance();
		ReportsDialog reportsDialog = ReportsDialog.getInstance(mainFrame, true);
		reportsDialog.setLocationRelativeTo(null);
		ChangePriceDialog changePriceDialog = ChangePriceDialog.getInstance(mainFrame, true);
		changePriceDialog.setLocationRelativeTo(mainFrame);
		DisplayManager displayManager = DisplayManager.getInstance();
		GetPaidDialog getPaidDialog = GetPaidDialog.getInstance(mainFrame, true);
		getPaidDialog.setLocationRelativeTo(null);
		AboutDialog aboutDialog = new AboutDialog(mainFrame, true);
		aboutDialog.setLocationRelativeTo(null);

		// Connecting the classes with the Controller
		mainFrame.setController(controller);
		loginDialog.setController(controller);
		userDao.setController(controller);
		vehicleDao.setController(controller);
		detailDao.setController(controller);
		parkingLotDao.setController(controller);
		cashRegisterDao.setController(controller);
		paymentInformationDao.setController(controller);
		priceByHourDao.setController(controller);
		vehicleMovementsDao.setController(controller);
		detailPanel.setController(controller);
		tablePanel.setController(controller);
		reportsDialog.setController(controller);
		changePriceDialog.setController(controller);
		getPaidDialog.setController(controller);

		// Connecting the Controller with the classes
		controller.setMainFrame(mainFrame);
		controller.setLoginDialog(loginDialog);
		controller.setLoginLogic(loginLogic);
		controller.setParkingLogic(parkingLogic);
		controller.setCashRegistersLogic(cashRegistersLogic);
		controller.setDetailPanel(detailPanel);
		controller.setTablePanel(tablePanel);
		controller.setReportsDialog(reportsDialog);
		controller.setChangePriceDialog(changePriceDialog);
		controller.setDisplayManager(displayManager);
		controller.setGetPaidDialog(getPaidDialog);
		controller.setAboutDialog(aboutDialog);

		// Connecting the LoginLogic with the userDao
		loginLogic.setUserDao(userDao);
		parkingLogic.setVehicleDao(vehicleDao);
		parkingLogic.setDetailDao(detailDao);
		parkingLogic.setParkingLotDao(parkingLotDao);
		parkingLogic.setPriceByHourDao(priceByHourDao);
		parkingLogic.setVehicleMovementsDao(vehicleMovementsDao);
		cashRegistersLogic.setCashRegisterDao(cashRegisterDao);
		cashRegistersLogic.setPaymentInformationDao(paymentInformationDao);

		// Add observers
		parkingLogic.addObserver(mainFrame);
		parkingLogic.addPriceObserver(mainFrame);
		parkingLogic.addPriceObserver(changePriceDialog);
		parkingLogic.addPriceObserver(displayManager);

		mainFrame.setVisible(true);
		loginDialog.setVisible(true);

	}

	public void initSystem() {

		// Open choose language frame
		ChooseLanguageFrame chooseLanguageFrame = new ChooseLanguageFrame();
		chooseLanguageFrame.setVisible(true);
		ActionListener evt = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == chooseLanguageFrame.acceptButton) {
					LanguageManager languageManager = LanguageManager.getInstance();
					if(chooseLanguageFrame.spanishRadioBtn.isSelected()) {
						languageManager.changeLenguage("ES");
					} else if(chooseLanguageFrame.englishRadioBtn.isSelected()) {
						languageManager.changeLenguage("EN");
					}
					chooseLanguageFrame.dispose();
					initMainApplication();
				}

			}
		};
		chooseLanguageFrame.acceptButton.addActionListener(evt);
	}

}
