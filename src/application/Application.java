/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import controller.Controller;
import model.LoginLogic;
import model.dao.UserDao;
import view.frames.LoginDialog;
import view.frames.MainFrame;

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
        UserDao userDao = new UserDao();
        
        //Connecting the classes with the Controller
        mainFrame.setController(controller);
        loginDialog.setController(controller);
        loginLogic.setController(controller);
        userDao.setController(controller);
        
        //Connecting the Controller with the classes
        controller.setMainFrame(mainFrame);
        controller.setLoginDialog(loginDialog);
        controller.setLoginLogic(loginLogic);
        
        //Connecting the LoginLogic with the userDao
        loginLogic.setUserDao(userDao);
        
        mainFrame.setVisible(true);
        loginDialog.setVisible(true);
    }
}