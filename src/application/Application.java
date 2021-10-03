/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import controller.Controller;
import controller.VehiclesController;
import model.LoginLogic;
import model.ParkingLogic;
import model.dao.ParkingLotDao;
import model.dao.UserDao;
import view.components.DetailPanel;
import view.frames.LoginDialog;
import view.frames.MainFrame;
import view.frames.ReportsDialog;
import view.table.view.TablePanel;

/**
 *
 * @author conde
 */
public class Application {

    public void initSystem() {

        //Instantiating the classes
        MainFrame mainFrame = new MainFrame();
        LoginDialog loginDialog = new LoginDialog(mainFrame, true);
        
        Controller controller = new Controller();
        
        LoginLogic loginLogic = new LoginLogic();
        ParkingLogic parkingLogic = new ParkingLogic();
        
        UserDao userDao = new UserDao();
        ParkingLotDao parkingLotDao = new ParkingLotDao();
        
        TablePanel tablePanel = TablePanel.getInstance();
        DetailPanel detailPanel = DetailPanel.getInstance();
        ReportsDialog reportsDialog = ReportsDialog.getInstance(mainFrame, true);
        
        //Connecting the classes with the Controller
        mainFrame.setController(controller);
        loginDialog.setController(controller);
        userDao.setController(controller);
        parkingLotDao.setController(controller);
        detailPanel.setController(controller);
        tablePanel.setController(controller);
        reportsDialog.setController(controller);
        
        //Connecting the Controller with the classes
        controller.setMainFrame(mainFrame);
        controller.setLoginDialog(loginDialog);
        controller.setLoginLogic(loginLogic);
        controller.setParkingLogic(parkingLogic);
        controller.setDetailPanel(detailPanel);
        controller.setTablePanel(tablePanel);
        controller.setReportsDialog(reportsDialog);
        
        //Connecting the LoginLogic with the userDao
        loginLogic.setUserDao(userDao);
        parkingLogic.setParkingLotDao(parkingLotDao);
        
        mainFrame.setVisible(true);
        loginDialog.setVisible(true);
    }
    
}
