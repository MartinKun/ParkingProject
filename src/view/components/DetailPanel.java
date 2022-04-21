/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.Controller;
import helpers.LanguageManager;
import model.dto.ParkingLot;
import model.enums.Privileges;


public class DetailPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private LanguageManager languageManager = LanguageManager.getInstance();
	
	private JLabel detailTitleLbl;
	private JLabel spotLbl;
	private JLabel vehicleLbl;
	private JLabel plateLbl;
	private JLabel timeParkedLbl;
	private JLabel totalAmountPayableLbl;
	private javax.swing.JSeparator separator;
	private JButton btnGenerateTicket;
	private JButton btnRemoveVehicle;
	private ParkingLot parkingLotSelected;

	private Controller controller;

	private static DetailPanel detailPanel;

	private DetailPanel() {
		setLayout(null);
		this.setBounds(0, 0, 300, 536);
		this.setMaximumSize(new Dimension(300, 620));
		setBackground(new Color(204, 204, 204));

		init();
	}

	public static DetailPanel getInstance() {

		if (detailPanel == null) {
			detailPanel = new DetailPanel();
		}

		return detailPanel;
	}

	public void setController(Controller controller) {
		this.controller = controller;

	}

	private void init() {

		detailTitleLbl = new JLabel();
		detailTitleLbl.setText(languageManager.getProperty("detail.title"));
		detailTitleLbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		detailTitleLbl.setBounds(0, 80, this.getWidth(), 40);
		detailTitleLbl.setFont(new Font("Verdana", Font.BOLD, 18));
		this.add(detailTitleLbl);
		
		separator = new JSeparator();
		separator.setBounds(0 + 10, detailTitleLbl.getY() + detailTitleLbl.getHeight() + 10, this.getWidth() - 20, 10);
		this.add(separator);

		spotLbl = new JLabel();
		spotLbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		spotLbl.setBounds(0 + 10, separator.getY() + separator.getHeight() + 30, this.getWidth() - 20, 40);
		spotLbl.setFont(new Font("Verdana", Font.PLAIN, 16));
		this.add(spotLbl);

		vehicleLbl = new JLabel();
		vehicleLbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		vehicleLbl.setBounds(0 + 10, spotLbl.getY() + spotLbl.getHeight(), this.getWidth() - 20, 40);
		vehicleLbl.setFont(new Font("Verdana", Font.PLAIN, 16));
		this.add(vehicleLbl);

		plateLbl = new JLabel();
		plateLbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		plateLbl.setBounds(0 + 10, vehicleLbl.getY() + vehicleLbl.getHeight(), this.getWidth() - 20, 40);
		plateLbl.setFont(new Font("Verdana", Font.PLAIN, 16));
		this.add(plateLbl);

		timeParkedLbl = new JLabel();
		timeParkedLbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		timeParkedLbl.setBounds(0 + 10, plateLbl.getY() + plateLbl.getHeight(), this.getWidth() - 20, 40);
		timeParkedLbl.setFont(new Font("Verdana", Font.BOLD, 16));
		timeParkedLbl.setForeground(new Color(48,22,84));
		this.add(timeParkedLbl);

		totalAmountPayableLbl = new JLabel();
		totalAmountPayableLbl.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		totalAmountPayableLbl.setBounds(0 + 10, timeParkedLbl.getY() + timeParkedLbl.getHeight() + 35,
				this.getWidth() - 20, 40);
		totalAmountPayableLbl.setFont(new Font("Verdana", Font.BOLD, 16));
		this.add(totalAmountPayableLbl);
		
		btnGenerateTicket = new JButton();
		btnGenerateTicket.setText(languageManager.getProperty("detail.get_paid"));
		btnGenerateTicket.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		btnGenerateTicket.setBounds(0 + 10, totalAmountPayableLbl.getY() + totalAmountPayableLbl.getHeight() + 35,
				this.getWidth() - 20, 48);
		btnGenerateTicket.setFont(new Font("Verdana", Font.BOLD, 16));
		btnGenerateTicket.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("../../resources/images/generate_ticket_icon.png")));
		this.add(btnGenerateTicket);
		btnGenerateTicket.addActionListener(this);

		btnRemoveVehicle = new JButton();
		btnRemoveVehicle.setText(languageManager.getProperty("detail.remove_vehicle"));
		btnRemoveVehicle.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		btnRemoveVehicle.setBounds(0 + 10, btnGenerateTicket.getY() + btnGenerateTicket.getHeight() + 5,
				this.getWidth() - 20, 48);
		btnRemoveVehicle.setFont(new Font("Verdana", Font.BOLD, 16));
		btnRemoveVehicle
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../resources/images/delete_car.png")));
		this.add(btnRemoveVehicle);
		btnRemoveVehicle.addActionListener(this);
	}

	public void setPrivileges(String userName) {

		if (userName.equals(Privileges.ADMINISTRATOR.toString().toLowerCase())) {

			btnRemoveVehicle.setVisible(true);
			;

		} else if (userName.equals(Privileges.USER.toString().toLowerCase())) {

			btnRemoveVehicle.setVisible(false);

		}

	}

	public void resetPrivileges() {
		btnRemoveVehicle.setVisible(false);
	}

	public void setData(ParkingLot parkingLotSelected) {

		this.parkingLotSelected = parkingLotSelected;

		spotLbl.setText(languageManager.getProperty("spot") + ": " + parkingLotSelected.getSpot() + "");
		if(parkingLotSelected.getVehicle() != null) {
			vehicleLbl.setText(parkingLotSelected.getVehicle().getType());
			plateLbl.setText(parkingLotSelected.getVehicle().getPlate());
		} else {
			vehicleLbl.setText("");
			plateLbl.setText("");
		}

		controller.displayTimeParkedAndTotalAmountPayable(timeParkedLbl, totalAmountPayableLbl, parkingLotSelected);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource() == btnRemoveVehicle) {

			if (parkingLotSelected == null) {
				controller.showErrorMessage(languageManager.getProperty("alert.no_vehicle_selected"));
			} else if(parkingLotSelected.getVehicle() == null){
				controller.showErrorMessage(languageManager.getProperty("alert.no_vehicle_in_spot"));
			} else {
				if(controller.confirmRemoveVehicle()) {
					boolean response = controller.removeVehicle(parkingLotSelected.getVehicle(), parkingLotSelected.getSpot());
					if(response) {
						controller.restartDetailPanelValues();
						controller.successVehicleRemovedMessage();
					}
				}
			}

		} if(evt.getSource() == btnGenerateTicket) {
			controller.openGetPaidDialog(parkingLotSelected);
		}

	}

	public void restartValues() {
		this.parkingLotSelected = null;
		totalAmountPayableLbl.setText("");
		timeParkedLbl.setText("");
		plateLbl.setText("");
		vehicleLbl.setText("");
		plateLbl.setText("");
		spotLbl.setText("");
		
	}
	
}
