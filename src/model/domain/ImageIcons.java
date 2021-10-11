package model.domain;


import javax.swing.ImageIcon;

public class ImageIcons {
	private ImageIcon emptySpotIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/parkinglot.png"));
	private ImageIcon carIcon = new javax.swing.ImageIcon(getClass().getResource("../../resources/images/car.png"));
	private ImageIcon motorcycleIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/motorcycle.png"));
	private ImageIcon carMouseOverIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/car-mouseover.png"));
	private ImageIcon motorcycleMouseOverIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/motorcycle-mouseover.png"));
	private ImageIcon emptySpotMouseOverIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/parkinglot-mouseover.png"));
	private ImageIcon carClickedIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/car-clicked.png"));
	private ImageIcon motorcycleClickedIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/motorcycle-clicked.png"));
	private ImageIcon emptySpotClickedIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/parkinglot-clicked.png"));
	
	public ImageIcon getEmptySpotIcon() {
		return emptySpotIcon;
	}
	public ImageIcon getCarIcon() {
		return carIcon;
	}
	public ImageIcon getMotorcycleIcon() {
		return motorcycleIcon;
	}
	public ImageIcon getCarMouseOverIcon() {
		return carMouseOverIcon;
	}
	public ImageIcon getMotorcycleMouseOverIcon() {
		return motorcycleMouseOverIcon;
	}
	public ImageIcon getEmptySpotMouseOverIcon() {
		return emptySpotMouseOverIcon;
	}
	public ImageIcon getCarClickedIcon() {
		return carClickedIcon;
	}
	public ImageIcon getMotorcycleClickedIcon() {
		return motorcycleClickedIcon;
	}
	public ImageIcon getEmptySpotClickedIcon() {
		return emptySpotClickedIcon;
	}
	
}
