/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;

import helpers.Observable;
import helpers.SelectParkingLotObserver;
import model.dto.ImageIcons;

public class ParkingLotLabel extends JLabel implements MouseListener, Observable<SelectParkingLotObserver> {

	private static final long serialVersionUID = 1L;

	private int parkingLotNumber;
	private ArrayList<SelectParkingLotObserver> selectParkingLotsObservers = new ArrayList();
	ImageIcons imageIcons = new ImageIcons();

	public ParkingLotLabel() {
		addMouseListener(this);
	}

	public int getParkingLotNumber() {
		return parkingLotNumber;
	}

	public void setParkingLotNumber(int parkingLotNumber) {
		this.parkingLotNumber = parkingLotNumber;
	}

	@Override
	public void mouseClicked(MouseEvent evt) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		notifyObservers();

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if (getIconName().equals(imageIcons.getEmptySpotIcon().toString())) {
			this.setIcon(imageIcons.getEmptySpotMouseOverIcon());
		} else if (getIconName().equals(imageIcons.getCarIcon().toString())) {
			this.setIcon(imageIcons.getCarMouseOverIcon());
		} else if (getIconName().equals(imageIcons.getMotorcycleIcon().toString())) {
			this.setIcon(imageIcons.getMotorcycleMouseOverIcon());
		}

	}

	private String getIconName() {
		return getIcon().toString();
	}

	@Override
	public void mouseExited(MouseEvent e) {

		if (getIconName().equals(imageIcons.getEmptySpotMouseOverIcon().toString())) {
			setIcon(imageIcons.getEmptySpotIcon());
		} else if (getIconName().equals(imageIcons.getCarMouseOverIcon().toString())) {
			setIcon(imageIcons.getCarIcon());
		} else if (getIconName().equals(imageIcons.getMotorcycleMouseOverIcon().toString())) {
			setIcon(imageIcons.getMotorcycleIcon());
		}

	}

	public void selectIcon() {

		if (getIconName().equals(imageIcons.getEmptySpotMouseOverIcon().toString())
				|| getIconName().equals(imageIcons.getEmptySpotIcon().toString())) {
			setIcon(imageIcons.getEmptySpotClickedIcon());
		} else if (getIconName().equals(imageIcons.getCarMouseOverIcon().toString())
				|| getIconName().equals(imageIcons.getCarIcon().toString())) {
			setIcon(imageIcons.getCarClickedIcon());
		} else if (getIconName().equals(imageIcons.getMotorcycleMouseOverIcon().toString())
				|| getIconName().equals(imageIcons.getMotorcycleIcon().toString())) {
			setIcon(imageIcons.getMotorcycleClickedIcon());
		}

	}

	public void deselectIcon() {

		if (getIconName().equals(imageIcons.getEmptySpotClickedIcon().toString())) {
			setIcon(imageIcons.getEmptySpotIcon());
		} else if (getIconName().equals(imageIcons.getCarClickedIcon().toString())) {
			setIcon(imageIcons.getCarIcon());
		} else if (getIconName().equals(imageIcons.getMotorcycleClickedIcon().toString())) {
			setIcon(imageIcons.getMotorcycleIcon());
		}
	}

	@Override
	public void addObserver(SelectParkingLotObserver t) {
		selectParkingLotsObservers.add(t);
	}

	@Override
	public void removeObserver(SelectParkingLotObserver t) {
		// TODO Auto-generated method stub

	}

	private void notifyObservers() {

		for (SelectParkingLotObserver o : selectParkingLotsObservers) {
			o.changeValueSelected(parkingLotNumber);
		}

	}

}
