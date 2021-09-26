/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.Controller;
import model.privileges.Privileges;

/**
 *
 * @author conde
 */
public class DetailPanel extends JPanel {

    JLabel detailTitleLbl;
    JLabel pLotLabel;
    String pLotNumber = "1";
    JLabel vehicleLbl;
    JLabel plateLbl;
    JLabel timeParkedLbl;
    JLabel totalAmountPayableLbl;
    String totalAmountPayableNumber = "0.00";
    javax.swing.JSeparator separator;
    JButton btnGenerateTicket;
    JButton btnRemoveVehicle;
    
    Controller controller;
    
    private static DetailPanel detailPanel;
   

    private DetailPanel() {
        setLayout(null);
        this.setBounds(0, 0, 300, 536);
        this.setMaximumSize(new Dimension(300,620));
        setBackground(new Color(204,204,204));

        init();
    }
    
    public static DetailPanel getInstance() {
    	
    	if(detailPanel == null) {
    		detailPanel = new DetailPanel();
    	}
    	
    	return detailPanel;
    }
    
	public void setController(Controller controller) {
		this.controller = controller;
		
	}

    private void init() {

        detailTitleLbl = new JLabel();
        detailTitleLbl.setText("Detalle");
        detailTitleLbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        detailTitleLbl.setBounds(0, 80, this.getWidth(), 40);
        detailTitleLbl.setFont(new Font("Verdana", Font.BOLD, 18));
        this.add(detailTitleLbl);

        separator = new JSeparator();
        separator.setBounds(0 + 10, detailTitleLbl.getY() + detailTitleLbl.getHeight() + 10, this.getWidth() - 20, 10);
        this.add(separator);

        pLotLabel = new JLabel();
        pLotLabel.setText("Lugar: " + pLotNumber);
        pLotLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        pLotLabel.setBounds(0 + 10, separator.getY() + separator.getHeight() + 30, this.getWidth() - 20, 40);
        pLotLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        this.add(pLotLabel);
        
        vehicleLbl = new JLabel();
        vehicleLbl.setText("Vehiculo");
        vehicleLbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        vehicleLbl.setBounds(0 + 10, pLotLabel.getY() + pLotLabel.getHeight(), this.getWidth() - 20, 40);
        vehicleLbl.setFont(new Font("Verdana", Font.PLAIN, 16));
        this.add(vehicleLbl);

        plateLbl = new JLabel();
        plateLbl.setText("Patente");
        plateLbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        plateLbl.setBounds(0 + 10, vehicleLbl.getY() + vehicleLbl.getHeight(), this.getWidth() - 20, 40);
        plateLbl.setFont(new Font("Verdana", Font.PLAIN, 16));
        this.add(plateLbl);
        
        timeParkedLbl = new JLabel();
        timeParkedLbl.setText("00HRS 00min 00seg");
        timeParkedLbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        timeParkedLbl.setBounds(0 + 10, plateLbl.getY() + plateLbl.getHeight(), this.getWidth() - 20, 40);
        timeParkedLbl.setFont(new Font("Verdana", Font.PLAIN, 16));
        this.add(timeParkedLbl);
        
        totalAmountPayableLbl = new JLabel();
        totalAmountPayableLbl.setText("Total: $" + totalAmountPayableNumber);
        totalAmountPayableLbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        totalAmountPayableLbl.setBounds(0 + 10, timeParkedLbl.getY() + timeParkedLbl.getHeight() + 35, this.getWidth() - 20, 40);
        totalAmountPayableLbl.setFont(new Font("Verdana", Font.BOLD, 16));
        this.add(totalAmountPayableLbl);
        
        btnGenerateTicket = new JButton();
        btnGenerateTicket.setText("           Cobrar               ");
        btnGenerateTicket.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        btnGenerateTicket.setBounds(0 + 10, totalAmountPayableLbl.getY() + totalAmountPayableLbl.getHeight() + 35, this.getWidth() - 20, 48);
        btnGenerateTicket.setFont(new Font("Verdana", Font.BOLD, 16));
        btnGenerateTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../resources/images/generate_ticket_icon.png")));
        this.add(btnGenerateTicket);
        
        btnRemoveVehicle = new JButton();
        btnRemoveVehicle.setText("Remover de la Planilla");
        btnRemoveVehicle.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        btnRemoveVehicle.setBounds(0 + 10, btnGenerateTicket.getY() + btnGenerateTicket.getHeight() + 5, this.getWidth() - 20, 48);
        btnRemoveVehicle.setFont(new Font("Verdana", Font.BOLD, 16));
        btnRemoveVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../resources/images/delete_car.png")));
        btnRemoveVehicle.setVisible(false);
        
        this.add(btnRemoveVehicle);
    }
    
	public void setPrivileges(String userName) {
		
		if (userName.equals(Privileges.ADMINISTRATOR.toString().toLowerCase())) {

			btnRemoveVehicle.setVisible(true);;

		} else if (userName.equals(Privileges.USER.toString().toLowerCase())) {

			btnRemoveVehicle.setVisible(false);

		}
		
	}
	
	public void restartValues() {
		btnRemoveVehicle.setVisible(false);
	}

}
