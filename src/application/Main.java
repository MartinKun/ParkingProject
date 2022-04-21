package application;

import java.io.File;
import java.sql.SQLException;

import sqlite.CreateData;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author conde
 */
public class Main {

	public static void main(String[] args) {
		
		//Create database if it doesn't exist.
    	try {
    		
    		File dbFile = new File("./database.db");
    		
    		if(!dbFile.exists()) {
    			CreateData createData = new CreateData();
        		createData.createTables();
        		createData.insertData();
        		
    		} else {
    			System.out.println("Database already exists.");
    		}
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
    	
    	//Initialize the application.
		Application application = new Application();
		application.initSystem();

	}

}
