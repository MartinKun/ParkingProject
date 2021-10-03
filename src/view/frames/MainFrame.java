/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.Controller;
import model.entity.ParkingLot;
import model.privileges.Privileges;
import view.components.CustomPaintedPanel;
import view.components.DetailPanel;
import view.components.EnterVehiclePlateTextField;
import view.components.ParkingLotLabel;
import view.table.view.TablePanel;

/**
 *
 * @author conde
 */
public class MainFrame extends javax.swing.JFrame implements ActionListener, MouseListener {

	private Dimension sizeWindow;
	private Rectangle window;
	private Controller controller;

	private String availableSpotsNumber;

	private javax.swing.JMenuItem aboutMenuItem;
	private javax.swing.JPanel borderTopRightPanel;
	private javax.swing.JPanel bottomPanel;
	private javax.swing.JButton btnChangePrice;
	private javax.swing.JButton btnEnterVehicle;
	private javax.swing.JButton btnSeeReports;
	private javax.swing.JComboBox<String> choiceParkingLotComboBox;
	private javax.swing.JComboBox<String> choiceVehicleComboBox;
	public static javax.swing.JPanel detailContainer;
	private javax.swing.JPanel enterVPlatePanel;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JMenu helpMenu;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JMenuItem logoutMenuItem;
	private javax.swing.JPanel mainContainerPanel;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JPanel middlePanel;
	private javax.swing.JLabel pLot1;
	private javax.swing.JLabel pLot10;
	private javax.swing.JLabel pLot11;
	private javax.swing.JLabel pLot12;
	private javax.swing.JLabel pLot13;
	private javax.swing.JLabel pLot14;
	private javax.swing.JLabel pLot15;
	private javax.swing.JLabel pLot16;
	private javax.swing.JLabel pLot2;
	private javax.swing.JLabel pLot3;
	private javax.swing.JLabel pLot4;
	private javax.swing.JLabel pLot5;
	private javax.swing.JLabel pLot6;
	private javax.swing.JLabel pLot7;
	private javax.swing.JLabel pLot8;
	private javax.swing.JLabel pLot9;
	private javax.swing.JLabel parkingLotLbl;
	private javax.swing.JLabel parkingLotStatusInfoLbl;
	private javax.swing.JLabel priceInfoLbl;
	private javax.swing.JPanel rightPanel;
	private javax.swing.JPanel sideBarPanel;
	private javax.swing.JPanel sketchPanel;
	private javax.swing.JTabbedPane tabbedPaneContainer;
	private javax.swing.JPanel tablePanelContainer;
	private javax.swing.JTextField vPlateNumberTextField;

	ImageIcon emptySpotIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/parkinglot.png"));
	ImageIcon carIcon = new javax.swing.ImageIcon(getClass().getResource("../../resources/images/car.png"));
	ImageIcon motorcycleIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/motorcycle.png"));
	ImageIcon carMouseOverIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/car-mouseover.png"));
	ImageIcon motorcycleMouseOverIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/motorcycle-mouseover.png"));
	ImageIcon parkingLotMouseOverIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/parkinglot-mouseover.png"));
	ImageIcon carClickedIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/car-clicked.png"));
	ImageIcon motorcycleClickedIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/motorcycle-clicked.png"));
	ImageIcon parkingLotClickedIcon = new javax.swing.ImageIcon(
			getClass().getResource("../../resources/images/parkinglot-clicked.png"));
	// End of variables declaration//GEN-END:variables

	public MainFrame() {

		setTitle("Principal");
		sizeWindow = Toolkit.getDefaultToolkit().getScreenSize();
		window = new Rectangle(sizeWindow);
		setBounds(window);
		setResizable(false);

		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		mainContainerPanel = new javax.swing.JPanel();
		sideBarPanel = new javax.swing.JPanel();
		btnChangePrice = new javax.swing.JButton();
		btnSeeReports = new javax.swing.JButton();
		priceInfoLbl = new javax.swing.JLabel();
		mainPanel = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		enterVPlatePanel = new CustomPaintedPanel("../../resources/images/plate.png");
		vPlateNumberTextField = new EnterVehiclePlateTextField();
		choiceVehicleComboBox = new javax.swing.JComboBox<>();
		choiceParkingLotComboBox = new javax.swing.JComboBox<>();
		parkingLotLbl = new javax.swing.JLabel();
		btnEnterVehicle = new javax.swing.JButton();
		middlePanel = new javax.swing.JPanel();
		tabbedPaneContainer = new javax.swing.JTabbedPane();
		sketchPanel = new CustomPaintedPanel("../../resources/images/sketch.png");
		pLot12 = new JLabel();
		pLot9 = new JLabel();
		pLot14 = new JLabel();
		pLot15 = new JLabel();
		pLot13 = new JLabel();
		pLot10 = new JLabel();
		pLot11 = new JLabel();
		pLot16 = new JLabel();
		pLot7 = new JLabel();
		pLot8 = new JLabel();
		pLot1 = new JLabel();
		pLot5 = new JLabel();
		pLot4 = new JLabel();
		pLot3 = new JLabel();
		pLot2 = new JLabel();
		pLot6 = new JLabel();
		pLot1.addMouseListener(this);
		pLot2.addMouseListener(this);
		pLot3.addMouseListener(this);
		pLot4.addMouseListener(this);
		pLot5.addMouseListener(this);
		pLot6.addMouseListener(this);
		pLot7.addMouseListener(this);
		pLot8.addMouseListener(this);
		pLot9.addMouseListener(this);
		pLot10.addMouseListener(this);
		pLot11.addMouseListener(this);
		pLot12.addMouseListener(this);
		pLot13.addMouseListener(this);
		pLot14.addMouseListener(this);
		pLot15.addMouseListener(this);
		pLot16.addMouseListener(this);
		tablePanelContainer = new javax.swing.JPanel();
		rightPanel = new javax.swing.JPanel();
		borderTopRightPanel = new javax.swing.JPanel();
		detailContainer = DetailPanel.getInstance();
		bottomPanel = new javax.swing.JPanel();
		parkingLotStatusInfoLbl = new javax.swing.JLabel();
		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		logoutMenuItem = new javax.swing.JMenuItem();
		helpMenu = new javax.swing.JMenu();
		aboutMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		mainContainerPanel.setLayout(new java.awt.BorderLayout());

		sideBarPanel.setBackground(new java.awt.Color(0, 204, 255));
		sideBarPanel.setMinimumSize(new java.awt.Dimension(300, 100));
		sideBarPanel.setPreferredSize(new java.awt.Dimension(300, 797));

		btnEnterVehicle.addActionListener(this);

		btnChangePrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		btnChangePrice
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/change_price_icon.png"))); // NOI18N
		btnChangePrice.setText("Cambiar Tarifa");
		btnChangePrice.setEnabled(false);

		btnSeeReports.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		btnSeeReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/reports_icon.png"))); // NOI18N
		btnSeeReports.setText(" Ver Reportes   ");
		btnSeeReports.addActionListener(this);
		btnSeeReports.setEnabled(false);

		priceInfoLbl.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		priceInfoLbl.setForeground(new java.awt.Color(255, 255, 255));
		priceInfoLbl.setText("Tarifa por hora:        $ 0.00");

		javax.swing.GroupLayout sideBarPanelLayout = new javax.swing.GroupLayout(sideBarPanel);
		sideBarPanel.setLayout(sideBarPanelLayout);
		sideBarPanelLayout
				.setHorizontalGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(btnChangePrice, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSeeReports, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								sideBarPanelLayout.createSequentialGroup().addGap(20, 20, 20)
										.addComponent(priceInfoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 259,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(21, Short.MAX_VALUE)));
		sideBarPanelLayout
				.setVerticalGroup(
						sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(sideBarPanelLayout.createSequentialGroup().addGap(31, 31, 31)
										.addComponent(btnChangePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnSeeReports, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(priceInfoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(980, Short.MAX_VALUE)));

		mainContainerPanel.add(sideBarPanel, java.awt.BorderLayout.LINE_START);

		mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));

		jPanel1.setBackground(new java.awt.Color(0, 153, 153));
		jPanel1.setMinimumSize(new java.awt.Dimension(1551, 100));
		jPanel1.setPreferredSize(new java.awt.Dimension(1551, 250));

		vPlateNumberTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		vPlateNumberTextField.setBorder(null);

		javax.swing.GroupLayout enterVPlatePanelLayout = new javax.swing.GroupLayout(enterVPlatePanel);
		enterVPlatePanel.setLayout(enterVPlatePanelLayout);
		enterVPlatePanelLayout
				.setHorizontalGroup(
						enterVPlatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(enterVPlatePanelLayout.createSequentialGroup().addGap(51, 51, 51)
										.addComponent(vPlateNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
												323, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(42, Short.MAX_VALUE)));
		enterVPlatePanelLayout
				.setVerticalGroup(enterVPlatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(enterVPlatePanelLayout.createSequentialGroup().addGap(41, 41, 41)
								.addComponent(vPlateNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		choiceVehicleComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		choiceVehicleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Tipo de Vehiculo", "Automovil", "Motocicleta" }));

		choiceParkingLotComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		parkingLotLbl.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		parkingLotLbl.setForeground(new java.awt.Color(255, 255, 255));
		parkingLotLbl.setText("Lugar:");

		btnEnterVehicle.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		btnEnterVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/car_in_icon.png"))); // NOI18N
		btnEnterVehicle.setText("INGRESAR VEHICULO");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(enterVPlatePanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(61, 61, 61).addComponent(
										parkingLotLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(choiceVehicleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
												173, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(choiceParkingLotComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
												49, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnEnterVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 383,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(563, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(31, 31, 31).addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(btnEnterVehicle, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
								.addComponent(choiceVehicleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(36, 36, 36)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(choiceParkingLotComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
												40, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(parkingLotLbl, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(enterVPlatePanel, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(153, 153, 153)));

		mainPanel.add(jPanel1);

		middlePanel.setBackground(new java.awt.Color(0, 153, 153));
		middlePanel.setMaximumSize(new java.awt.Dimension(32767, 650));
		middlePanel.setMinimumSize(new java.awt.Dimension(806, 650));
		middlePanel.setPreferredSize(new java.awt.Dimension(806, 650));
		middlePanel.setLayout(new javax.swing.BoxLayout(middlePanel, javax.swing.BoxLayout.X_AXIS));

		tabbedPaneContainer.setBackground(new java.awt.Color(0, 153, 153));
		tabbedPaneContainer.setFont(new java.awt.Font("Rockwell", Font.BOLD, 20)); // NOI18N
		tabbedPaneContainer.setMaximumSize(new java.awt.Dimension(1100, 681));
		tabbedPaneContainer.setMinimumSize(new java.awt.Dimension(1100, 681));
		tabbedPaneContainer.setPreferredSize(new java.awt.Dimension(1200, 681));

		sketchPanel.setMaximumSize(new java.awt.Dimension(1100, 650));
		sketchPanel.setMinimumSize(new java.awt.Dimension(1100, 650));
		sketchPanel.setPreferredSize(new java.awt.Dimension(1100, 650));

		javax.swing.GroupLayout sketchPanelLayout = new javax.swing.GroupLayout(sketchPanel);
		sketchPanel.setLayout(sketchPanelLayout);
		sketchPanelLayout.setHorizontalGroup(sketchPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(sketchPanelLayout.createSequentialGroup().addGap(143, 143, 143)
						.addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pLot9, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pLot8, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(60, 60, 60)
						.addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pLot10, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pLot7, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(70, 70, 70)
						.addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pLot11, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pLot6, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(63, 63, 63)
						.addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pLot12, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pLot5, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
						.addGroup(
								sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(sketchPanelLayout.createSequentialGroup()
												.addComponent(pLot13, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(67, 67, 67).addComponent(pLot14,
														javax.swing.GroupLayout.PREFERRED_SIZE, 73,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(sketchPanelLayout.createSequentialGroup()
												.addComponent(pLot4, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(pLot3, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(67, 67, 67)
						.addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(pLot15, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pLot2, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(63, 63, 63)
						.addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pLot16, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pLot1, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)));
		sketchPanelLayout.setVerticalGroup(sketchPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sketchPanelLayout.createSequentialGroup()
						.addGap(43, 43, 43)
						.addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(sketchPanelLayout.createSequentialGroup()
										.addGroup(sketchPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(pLot2, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pLot1, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283,
												Short.MAX_VALUE)
										.addGroup(sketchPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(pLot16, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pLot15, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(sketchPanelLayout.createSequentialGroup()
										.addGroup(sketchPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(pLot3, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pLot4, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pLot5, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pLot8, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pLot7, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pLot6, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(sketchPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(pLot14, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pLot9, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pLot11, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pLot10, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pLot12, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(pLot13, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(38, 38, 38)));

		tabbedPaneContainer.addTab("Croquis", sketchPanel);

		javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanelContainer);
		tablePanelContainer.setLayout(tablePanelLayout);
		tablePanelLayout.setHorizontalGroup(tablePanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1195, Short.MAX_VALUE));
		tablePanelLayout.setVerticalGroup(tablePanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 614, Short.MAX_VALUE));

		TablePanel tablePanel = TablePanel.getInstance();
		tablePanel.setSize(1200, 650);
		tablePanel.setLocation(0, 0);
		// tablePanelContainer.removeAll();
		tablePanelContainer.add(tablePanel, BorderLayout.CENTER);
		// tablePanelContainer.revalidate();
		// tablePanelContainer.repaint();

		tabbedPaneContainer.addTab("Planilla", tablePanelContainer);

		middlePanel.add(tabbedPaneContainer);

		rightPanel.setBackground(new java.awt.Color(204, 204, 204));
		rightPanel.setLayout(new javax.swing.BoxLayout(rightPanel, javax.swing.BoxLayout.Y_AXIS));

		borderTopRightPanel.setBackground(new java.awt.Color(0, 153, 153));
		borderTopRightPanel.setMaximumSize(new java.awt.Dimension(32767, 32));
		borderTopRightPanel.setMinimumSize(new java.awt.Dimension(100, 32));
		borderTopRightPanel.setPreferredSize(new java.awt.Dimension(199, 32));

		javax.swing.GroupLayout borderTopRightPanelLayout = new javax.swing.GroupLayout(borderTopRightPanel);
		borderTopRightPanel.setLayout(borderTopRightPanelLayout);
		borderTopRightPanelLayout.setHorizontalGroup(borderTopRightPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 351, Short.MAX_VALUE));
		borderTopRightPanelLayout.setVerticalGroup(borderTopRightPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 32, Short.MAX_VALUE));

		rightPanel.add(borderTopRightPanel);

		javax.swing.GroupLayout detailContainerLayout = new javax.swing.GroupLayout(detailContainer);
		detailContainer.setLayout(detailContainerLayout);
		detailContainerLayout.setHorizontalGroup(detailContainerLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
		detailContainerLayout.setVerticalGroup(detailContainerLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));

		rightPanel.add(detailContainer);

		middlePanel.add(rightPanel);

		mainPanel.add(middlePanel);

		bottomPanel.setBackground(new java.awt.Color(0, 102, 102));

		parkingLotStatusInfoLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		parkingLotStatusInfoLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
		bottomPanel.setLayout(bottomPanelLayout);
		bottomPanelLayout
				.setHorizontalGroup(
						bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(bottomPanelLayout.createSequentialGroup()
										.addComponent(parkingLotStatusInfoLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
												160, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 1391, Short.MAX_VALUE)));
		bottomPanelLayout
				.setVerticalGroup(
						bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(bottomPanelLayout.createSequentialGroup()
										.addComponent(parkingLotStatusInfoLbl, javax.swing.GroupLayout.PREFERRED_SIZE,
												26, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 283, Short.MAX_VALUE)));

		mainPanel.add(bottomPanel);

		mainContainerPanel.add(mainPanel, java.awt.BorderLayout.CENTER);

		fileMenu.setText("Archivo");
		fileMenu.setRolloverEnabled(false);

		logoutMenuItem.setText("Desloguearse");
		fileMenu.add(logoutMenuItem);
		logoutMenuItem.addActionListener(this);

		menuBar.add(fileMenu);

		helpMenu.setText("Ayuda");

		aboutMenuItem.setText("Acerca de");
		helpMenu.add(aboutMenuItem);

		menuBar.add(helpMenu);

		setJMenuBar(menuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(mainContainerPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(mainContainerPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void setPrivileges(String userName) {

		this.setEnabled(true);

		if (userName.equals(Privileges.ADMINISTRATOR.toString().toLowerCase())) {

			btnChangePrice.setEnabled(true);
			btnSeeReports.setEnabled(true);

		} else if (userName.equals(Privileges.USER.toString().toLowerCase())) {

			System.out.println("Privilegios usuario");
			btnSeeReports.setEnabled(true);

		}

	}

	public void restartValues() {
		btnChangePrice.setEnabled(false);
		btnSeeReports.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource() == logoutMenuItem.getComponent()) {
			controller.logout();
		} else if (evt.getSource() == btnSeeReports) {
			controller.openReportsDialog();
		} else if (evt.getSource() == btnEnterVehicle) {

			String plateNumber = vPlateNumberTextField.getText().toUpperCase();
			String vehicle = choiceVehicleComboBox.getSelectedItem().toString();
			String parkingLot = choiceParkingLotComboBox.getSelectedItem().toString();

			boolean response = controller.enterVehicle(plateNumber, vehicle, parkingLot);
			controller.buildVehicleTable();
			controller.buildParkingLotComboBox();
			controller.buildSketch();

			if (response) {
				vPlateNumberTextField.setText("");
			}

		}

	}

	public void buildParkingLotComboBox(ArrayList<ParkingLot> parkingLots) {
		ArrayList<String> spotsArrayList = new ArrayList<>();
		String[] availableSpots;

		for (ParkingLot parkingLot : parkingLots) {

			if (parkingLot.getVehicle().equals("-")) {
				spotsArrayList.add(parkingLot.getSpot() + "");
			}
		}

		availableSpots = new String[spotsArrayList.size()];
		setAvailableSpotsMessage(spotsArrayList.size());
		if (spotsArrayList.size() == 0) {
			btnEnterVehicle.setEnabled(false);
		} else {
			btnEnterVehicle.setEnabled(true);
		}

		for (int i = 0; i < spotsArrayList.size(); i++) {
			availableSpots[i] = spotsArrayList.get(i);
		}

		choiceParkingLotComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(availableSpots));

	}

	private void setAvailableSpotsMessage(int availableSpotsNumber) {
		parkingLotStatusInfoLbl.setText("Lugares disponibles:  " + availableSpotsNumber + "");
		parkingLotStatusInfoLbl.setForeground(new java.awt.Color(102, 204, 0));

		if (availableSpotsNumber <= 3) {
			parkingLotStatusInfoLbl.setForeground(new java.awt.Color(255, 51, 51));
			if (availableSpotsNumber == 0) {
				parkingLotStatusInfoLbl.setText("NO HAY MAS LUGAR");
			}
		}

	}

	public void buildSketch(ArrayList<ParkingLot> parkingLots) {

		Map<ParkingLot, JLabel> mapSketchSpots = new HashMap<ParkingLot, JLabel>();

		mapSketchSpots.put(parkingLots.get(0), pLot1);
		mapSketchSpots.put(parkingLots.get(1), pLot2);
		mapSketchSpots.put(parkingLots.get(2), pLot3);
		mapSketchSpots.put(parkingLots.get(3), pLot4);
		mapSketchSpots.put(parkingLots.get(4), pLot5);
		mapSketchSpots.put(parkingLots.get(5), pLot6);
		mapSketchSpots.put(parkingLots.get(6), pLot7);
		mapSketchSpots.put(parkingLots.get(7), pLot8);
		mapSketchSpots.put(parkingLots.get(8), pLot9);
		mapSketchSpots.put(parkingLots.get(9), pLot10);
		mapSketchSpots.put(parkingLots.get(10), pLot11);
		mapSketchSpots.put(parkingLots.get(11), pLot12);
		mapSketchSpots.put(parkingLots.get(12), pLot13);
		mapSketchSpots.put(parkingLots.get(13), pLot14);
		mapSketchSpots.put(parkingLots.get(14), pLot15);
		mapSketchSpots.put(parkingLots.get(15), pLot16);

		for (ParkingLot parkingLot : parkingLots) {
			switch (parkingLot.getVehicle()) {
			case "Automovil":
				mapSketchSpots.get(parkingLot).setIcon(carIcon);
				break;
			case "Motocicleta":
				mapSketchSpots.get(parkingLot).setIcon(motorcycleIcon);
				break;
			default:
				mapSketchSpots.get(parkingLot).setIcon(emptySpotIcon);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent evt) {

		if (evt.getSource() == pLot1) {

			deselectItems();
			if (pLot1.getIcon().equals(carMouseOverIcon)) {
				pLot1.setIcon(carClickedIcon);
			} else if (pLot1.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot1.setIcon(motorcycleClickedIcon);
			} else if (pLot1.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot1.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot2) {

			deselectItems();
			if (pLot2.getIcon().equals(carMouseOverIcon)) {
				pLot2.setIcon(carClickedIcon);
			} else if (pLot2.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot2.setIcon(motorcycleClickedIcon);
			} else if (pLot2.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot2.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot3) {

			deselectItems();
			if (pLot3.getIcon().equals(carMouseOverIcon)) {
				pLot3.setIcon(carClickedIcon);
			} else if (pLot3.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot3.setIcon(motorcycleClickedIcon);
			} else if (pLot3.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot3.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot4) {

			deselectItems();
			if (pLot4.getIcon().equals(carMouseOverIcon)) {
				pLot4.setIcon(carClickedIcon);
			} else if (pLot4.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot4.setIcon(motorcycleClickedIcon);
			} else if (pLot4.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot4.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot5) {

			deselectItems();
			if (pLot5.getIcon().equals(carMouseOverIcon)) {
				pLot5.setIcon(carClickedIcon);
			} else if (pLot5.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot5.setIcon(motorcycleClickedIcon);
			} else if (pLot5.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot5.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot6) {

			deselectItems();
			if (pLot6.getIcon().equals(carMouseOverIcon)) {
				pLot6.setIcon(carClickedIcon);
			} else if (pLot6.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot6.setIcon(motorcycleClickedIcon);
			} else if (pLot6.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot6.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot7) {

			deselectItems();
			if (pLot7.getIcon().equals(carMouseOverIcon)) {
				pLot7.setIcon(carClickedIcon);
			} else if (pLot7.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot7.setIcon(motorcycleClickedIcon);
			} else if (pLot7.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot7.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot8) {

			deselectItems();
			if (pLot8.getIcon().equals(carMouseOverIcon)) {
				pLot8.setIcon(carClickedIcon);
			} else if (pLot8.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot8.setIcon(motorcycleClickedIcon);
			} else if (pLot8.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot8.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot9) {

			deselectItems();
			if (pLot9.getIcon().equals(carMouseOverIcon)) {
				pLot9.setIcon(carClickedIcon);
			} else if (pLot9.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot9.setIcon(motorcycleClickedIcon);
			} else if (pLot9.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot9.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot10) {

			deselectItems();
			if (pLot10.getIcon().equals(carMouseOverIcon)) {
				pLot10.setIcon(carClickedIcon);
			} else if (pLot10.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot10.setIcon(motorcycleClickedIcon);
			} else if (pLot10.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot10.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot11) {

			deselectItems();
			if (pLot11.getIcon().equals(carMouseOverIcon)) {
				pLot11.setIcon(carClickedIcon);
			} else if (pLot11.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot11.setIcon(motorcycleClickedIcon);
			} else if (pLot11.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot11.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot12) {

			deselectItems();
			if (pLot12.getIcon().equals(carMouseOverIcon)) {
				pLot12.setIcon(carClickedIcon);
			} else if (pLot12.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot1.setIcon(motorcycleClickedIcon);
			} else if (pLot12.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot12.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot13) {

			deselectItems();
			if (pLot13.getIcon().equals(carMouseOverIcon)) {
				pLot13.setIcon(carClickedIcon);
			} else if (pLot13.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot13.setIcon(motorcycleClickedIcon);
			} else if (pLot13.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot13.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot14) {

			deselectItems();
			if (pLot14.getIcon().equals(carMouseOverIcon)) {
				pLot14.setIcon(carClickedIcon);
			} else if (pLot14.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot14.setIcon(motorcycleClickedIcon);
			} else if (pLot14.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot14.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot15) {

			deselectItems();
			if (pLot15.getIcon().equals(carMouseOverIcon)) {
				pLot15.setIcon(carClickedIcon);
			} else if (pLot15.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot15.setIcon(motorcycleClickedIcon);
			} else if (pLot15.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot15.setIcon(parkingLotClickedIcon);
			}

		} else if (evt.getSource() == pLot16) {

			deselectItems();
			if (pLot16.getIcon().equals(carMouseOverIcon)) {
				pLot16.setIcon(carClickedIcon);
			} else if (pLot16.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot16.setIcon(motorcycleClickedIcon);
			} else if (pLot16.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot16.setIcon(parkingLotClickedIcon);
			}

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent evt) {

		if (evt.getSource() == pLot1) {

			if (pLot1.getIcon().equals(carIcon)) {
				pLot1.setIcon(carMouseOverIcon);
			} else if (pLot1.getIcon().equals(motorcycleIcon)) {
				pLot1.setIcon(motorcycleMouseOverIcon);
			} else if (pLot1.getIcon().equals(emptySpotIcon)) {
				pLot1.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot2) {

			if (pLot2.getIcon().equals(carIcon)) {
				pLot2.setIcon(carMouseOverIcon);
			} else if (pLot2.getIcon().equals(motorcycleIcon)) {
				pLot2.setIcon(motorcycleMouseOverIcon);
			} else if (pLot2.getIcon().equals(emptySpotIcon)) {
				pLot2.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot3) {

			if (pLot3.getIcon().equals(carIcon)) {
				pLot3.setIcon(carMouseOverIcon);
			} else if (pLot3.getIcon().equals(motorcycleIcon)) {
				pLot3.setIcon(motorcycleMouseOverIcon);
			} else if (pLot3.getIcon().equals(emptySpotIcon)) {
				pLot3.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot4) {

			if (pLot4.getIcon().equals(carIcon)) {
				pLot4.setIcon(carMouseOverIcon);
			} else if (pLot4.getIcon().equals(motorcycleIcon)) {
				pLot4.setIcon(motorcycleMouseOverIcon);
			} else if (pLot4.getIcon().equals(emptySpotIcon)) {
				pLot4.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot5) {

			if (pLot5.getIcon().equals(carIcon)) {
				pLot5.setIcon(carMouseOverIcon);
			} else if (pLot5.getIcon().equals(motorcycleIcon)) {
				pLot5.setIcon(motorcycleMouseOverIcon);
			} else if (pLot5.getIcon().equals(emptySpotIcon)) {
				pLot5.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot6) {

			if (pLot6.getIcon().equals(carIcon)) {
				pLot6.setIcon(carMouseOverIcon);
			} else if (pLot6.getIcon().equals(motorcycleIcon)) {
				pLot6.setIcon(motorcycleMouseOverIcon);
			} else if (pLot6.getIcon().equals(emptySpotIcon)) {
				pLot6.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot7) {

			if (pLot7.getIcon().equals(carIcon)) {
				pLot7.setIcon(carMouseOverIcon);
			} else if (pLot7.getIcon().equals(motorcycleIcon)) {
				pLot7.setIcon(motorcycleMouseOverIcon);
			} else if (pLot7.getIcon().equals(emptySpotIcon)) {
				pLot7.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot8) {

			if (pLot8.getIcon().equals(carIcon)) {
				pLot8.setIcon(carMouseOverIcon);
			} else if (pLot8.getIcon().equals(motorcycleIcon)) {
				pLot8.setIcon(motorcycleMouseOverIcon);
			} else if (pLot8.getIcon().equals(emptySpotIcon)) {
				pLot8.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot9) {

			if (pLot9.getIcon().equals(carIcon)) {
				pLot9.setIcon(carMouseOverIcon);
			} else if (pLot9.getIcon().equals(motorcycleIcon)) {
				pLot9.setIcon(motorcycleMouseOverIcon);
			} else if (pLot9.getIcon().equals(emptySpotIcon)) {
				pLot9.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot10) {

			if (pLot10.getIcon().equals(carIcon)) {
				pLot10.setIcon(carMouseOverIcon);
			} else if (pLot10.getIcon().equals(motorcycleIcon)) {
				pLot10.setIcon(motorcycleMouseOverIcon);
			} else if (pLot10.getIcon().equals(emptySpotIcon)) {
				pLot10.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot11) {

			if (pLot11.getIcon().equals(carIcon)) {
				pLot11.setIcon(carMouseOverIcon);
			} else if (pLot11.getIcon().equals(motorcycleIcon)) {
				pLot11.setIcon(motorcycleMouseOverIcon);
			} else if (pLot11.getIcon().equals(emptySpotIcon)) {
				pLot11.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot12) {

			if (pLot12.getIcon().equals(carIcon)) {
				pLot12.setIcon(carMouseOverIcon);
			} else if (pLot12.getIcon().equals(motorcycleIcon)) {
				pLot12.setIcon(motorcycleMouseOverIcon);
			} else if (pLot12.getIcon().equals(emptySpotIcon)) {
				pLot12.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot13) {

			if (pLot13.getIcon().equals(carIcon)) {
				pLot13.setIcon(carMouseOverIcon);
			} else if (pLot13.getIcon().equals(motorcycleIcon)) {
				pLot13.setIcon(motorcycleMouseOverIcon);
			} else if (pLot13.getIcon().equals(emptySpotIcon)) {
				pLot13.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot14) {

			if (pLot14.getIcon().equals(carIcon)) {
				pLot14.setIcon(carMouseOverIcon);
			} else if (pLot14.getIcon().equals(motorcycleIcon)) {
				pLot14.setIcon(motorcycleMouseOverIcon);
			} else if (pLot14.getIcon().equals(emptySpotIcon)) {
				pLot14.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot15) {

			if (pLot15.getIcon().equals(carIcon)) {
				pLot15.setIcon(carMouseOverIcon);
			} else if (pLot15.getIcon().equals(motorcycleIcon)) {
				pLot15.setIcon(motorcycleMouseOverIcon);
			} else if (pLot15.getIcon().equals(emptySpotIcon)) {
				pLot15.setIcon(parkingLotMouseOverIcon);
			}

		} else if (evt.getSource() == pLot16) {

			if (pLot16.getIcon().equals(carIcon)) {
				pLot16.setIcon(carMouseOverIcon);
			} else if (pLot16.getIcon().equals(motorcycleIcon)) {
				pLot16.setIcon(motorcycleMouseOverIcon);
			} else if (pLot16.getIcon().equals(emptySpotIcon)) {
				pLot16.setIcon(parkingLotMouseOverIcon);
			}

		}

	}

	@Override
	public void mouseExited(MouseEvent evt) {

		if (evt.getSource() == pLot1) {

			if (pLot1.getIcon().equals(carMouseOverIcon)) {
				pLot1.setIcon(carIcon);
			} else if(pLot1.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot1.setIcon(motorcycleIcon);
			} else if(pLot1.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot1.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot2) {

			if (pLot2.getIcon().equals(carMouseOverIcon)) {
				pLot2.setIcon(carIcon);
			} else if(pLot2.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot2.setIcon(motorcycleIcon);
			} else if(pLot2.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot2.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot3) {

			if (pLot3.getIcon().equals(carMouseOverIcon)) {
				pLot3.setIcon(carIcon);
			} else if(pLot3.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot3.setIcon(motorcycleIcon);
			} else if(pLot3.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot3.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot4) {

			if (pLot4.getIcon().equals(carMouseOverIcon)) {
				pLot4.setIcon(carIcon);
			} else if(pLot4.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot4.setIcon(motorcycleIcon);
			} else if(pLot4.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot4.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot5) {

			if (pLot5.getIcon().equals(carMouseOverIcon)) {
				pLot5.setIcon(carIcon);
			} else if(pLot5.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot5.setIcon(motorcycleIcon);
			} else if(pLot5.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot5.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot6) {

			if (pLot6.getIcon().equals(carMouseOverIcon)) {
				pLot6.setIcon(carIcon);
			} else if(pLot6.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot6.setIcon(motorcycleIcon);
			} else if(pLot6.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot6.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot7) {

			if (pLot7.getIcon().equals(carMouseOverIcon)) {
				pLot7.setIcon(carIcon);
			} else if(pLot7.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot7.setIcon(motorcycleIcon);
			} else if(pLot7.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot7.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot8) {

			if (pLot8.getIcon().equals(carMouseOverIcon)) {
				pLot8.setIcon(carIcon);
			} else if(pLot8.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot8.setIcon(motorcycleIcon);
			} else if(pLot8.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot8.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot9) {

			if (pLot9.getIcon().equals(carMouseOverIcon)) {
				pLot9.setIcon(carIcon);
			} else if(pLot9.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot9.setIcon(motorcycleIcon);
			} else if(pLot9.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot9.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot10) {

			if (pLot10.getIcon().equals(carMouseOverIcon)) {
				pLot10.setIcon(carIcon);
			} else if(pLot10.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot10.setIcon(motorcycleIcon);
			} else if(pLot10.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot10.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot11) {

			if (pLot11.getIcon().equals(carMouseOverIcon)) {
				pLot11.setIcon(carIcon);
			} else if(pLot11.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot11.setIcon(motorcycleIcon);
			} else if(pLot11.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot11.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot12) {

			if (pLot12.getIcon().equals(carMouseOverIcon)) {
				pLot12.setIcon(carIcon);
			} else if(pLot12.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot12.setIcon(motorcycleIcon);
			} else if(pLot12.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot12.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot13) {

			if (pLot13.getIcon().equals(carMouseOverIcon)) {
				pLot13.setIcon(carIcon);
			} else if(pLot13.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot13.setIcon(motorcycleIcon);
			} else if(pLot13.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot13.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot14) {

			if (pLot14.getIcon().equals(carMouseOverIcon)) {
				pLot14.setIcon(carIcon);
			} else if(pLot14.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot14.setIcon(motorcycleIcon);
			} else if(pLot14.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot14.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot15) {

			if (pLot15.getIcon().equals(carMouseOverIcon)) {
				pLot15.setIcon(carIcon);
			} else if(pLot15.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot15.setIcon(motorcycleIcon);
			} else if(pLot15.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot15.setIcon(emptySpotIcon);}

		} else if (evt.getSource() == pLot16) {

			if (pLot16.getIcon().equals(carMouseOverIcon)) {
				pLot16.setIcon(carIcon);
			} else if(pLot16.getIcon().equals(motorcycleMouseOverIcon)) {
				pLot16.setIcon(motorcycleIcon);
			} else if(pLot16.getIcon().equals(parkingLotMouseOverIcon)) {
				pLot16.setIcon(emptySpotIcon);}

		}

	}

	public void deselectItems() {
		ArrayList<JLabel> parkingLots = new ArrayList<>();
		parkingLots.add(pLot1);
		parkingLots.add(pLot2);
		parkingLots.add(pLot3);
		parkingLots.add(pLot4);
		parkingLots.add(pLot5);
		parkingLots.add(pLot6);
		parkingLots.add(pLot7);
		parkingLots.add(pLot8);
		parkingLots.add(pLot9);
		parkingLots.add(pLot10);
		parkingLots.add(pLot11);
		parkingLots.add(pLot12);
		parkingLots.add(pLot13);
		parkingLots.add(pLot14);
		parkingLots.add(pLot15);
		parkingLots.add(pLot16);
		
		for(JLabel parkingLot : parkingLots) {
			
			if(parkingLot.getIcon() == carClickedIcon) {
				parkingLot.setIcon(carIcon);
			} else if(parkingLot.getIcon() == motorcycleClickedIcon) {
				parkingLot.setIcon(motorcycleIcon);
			} else if(parkingLot.getIcon() == parkingLotClickedIcon) {
				parkingLot.setIcon(emptySpotIcon);
			}
			
		}
	}

}
