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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import controller.Controller;
import model.ParkingLotsObserver;
import model.PriceObserver;
import model.SelectParkingLotObserver;
import model.domain.ImageIcons;
import model.domain.ParkingLot;
import model.privileges.Privileges;
import view.components.CustomPaintedPanel;
import view.components.DetailPanel;
import view.components.EnterVehiclePlateTextField;
import view.components.ParkingLotLabel;
import view.table.view.TablePanel;

public class MainFrame extends javax.swing.JFrame
		implements ActionListener, ParkingLotsObserver, SelectParkingLotObserver, PriceObserver {


	private static final long serialVersionUID = 1L;
	
	private Dimension sizeWindow;
	private Rectangle window;
	private Controller controller;

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
	private ParkingLotLabel pLot1;
	private ParkingLotLabel pLot10;
	private ParkingLotLabel pLot11;
	private ParkingLotLabel pLot12;
	private ParkingLotLabel pLot13;
	private ParkingLotLabel pLot14;
	private ParkingLotLabel pLot15;
	private ParkingLotLabel pLot16;
	private ParkingLotLabel pLot2;
	private ParkingLotLabel pLot3;
	private ParkingLotLabel pLot4;
	private ParkingLotLabel pLot5;
	private ParkingLotLabel pLot6;
	private ParkingLotLabel pLot7;
	private ParkingLotLabel pLot8;
	private ParkingLotLabel pLot9;
	private ArrayList<ParkingLotLabel> arrayParkingLotLabels;
	private javax.swing.JLabel parkingLotLbl;
	private javax.swing.JLabel parkingLotStatusInfoLbl;
	private javax.swing.JLabel priceInfoLbl;
	private javax.swing.JPanel rightPanel;
	private javax.swing.JPanel sideBarPanel;
	private javax.swing.JPanel sketchPanel;
	private javax.swing.JTabbedPane tabbedPaneContainer;
	private javax.swing.JPanel tablePanelContainer;
	private javax.swing.JTextField vPlateNumberTextField;

	ImageIcons imageIcons = new ImageIcons();

	// End of variables declaration//GEN-END:variables

	public MainFrame() {

		setTitle("Principal");
		sizeWindow = Toolkit.getDefaultToolkit().getScreenSize();
		window = new Rectangle(sizeWindow);
		setBounds(window);
		setResizable(false);

		initComponents();
		close();
	}
	
	/* Method to close the program when the Frame Close button is clicked */
	public void close() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas salir del programa?");
				if (JOptionPane.OK_OPTION == resp) {
					System.exit(0);
				}
			}
		});
	}
	
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
		choiceVehicleComboBox = new javax.swing.JComboBox();
		choiceParkingLotComboBox = new javax.swing.JComboBox();
		parkingLotLbl = new javax.swing.JLabel();
		btnEnterVehicle = new javax.swing.JButton();
		middlePanel = new javax.swing.JPanel();
		tabbedPaneContainer = new javax.swing.JTabbedPane();
		sketchPanel = new CustomPaintedPanel("../../resources/images/sketch.png");
		pLot12 = new ParkingLotLabel();
		pLot9 = new ParkingLotLabel();
		pLot14 = new ParkingLotLabel();
		pLot15 = new ParkingLotLabel();
		pLot13 = new ParkingLotLabel();
		pLot10 = new ParkingLotLabel();
		pLot11 = new ParkingLotLabel();
		pLot16 = new ParkingLotLabel();
		pLot7 = new ParkingLotLabel();
		pLot8 = new ParkingLotLabel();
		pLot1 = new ParkingLotLabel();
		pLot5 = new ParkingLotLabel();
		pLot4 = new ParkingLotLabel();
		pLot3 = new ParkingLotLabel();
		pLot2 = new ParkingLotLabel();
		pLot6 = new ParkingLotLabel();

		pLot1.addObserver(this);
		pLot2.addObserver(this);
		pLot3.addObserver(this);
		pLot4.addObserver(this);
		pLot5.addObserver(this);
		pLot6.addObserver(this);
		pLot7.addObserver(this);
		pLot8.addObserver(this);
		pLot9.addObserver(this);
		pLot10.addObserver(this);
		pLot11.addObserver(this);
		pLot12.addObserver(this);
		pLot13.addObserver(this);
		pLot14.addObserver(this);
		pLot15.addObserver(this);
		pLot16.addObserver(this);

		pLot1.setParkingLotNumber(1);
		pLot2.setParkingLotNumber(2);
		pLot3.setParkingLotNumber(3);
		pLot4.setParkingLotNumber(4);
		pLot5.setParkingLotNumber(5);
		pLot6.setParkingLotNumber(6);
		pLot7.setParkingLotNumber(7);
		pLot8.setParkingLotNumber(8);
		pLot9.setParkingLotNumber(9);
		pLot10.setParkingLotNumber(10);
		pLot11.setParkingLotNumber(11);
		pLot12.setParkingLotNumber(12);
		pLot13.setParkingLotNumber(13);
		pLot14.setParkingLotNumber(14);
		pLot15.setParkingLotNumber(15);
		pLot16.setParkingLotNumber(16);

		arrayParkingLotLabels = new ArrayList();
		arrayParkingLotLabels.add(pLot1);
		arrayParkingLotLabels.add(pLot2);
		arrayParkingLotLabels.add(pLot3);
		arrayParkingLotLabels.add(pLot4);
		arrayParkingLotLabels.add(pLot5);
		arrayParkingLotLabels.add(pLot6);
		arrayParkingLotLabels.add(pLot7);
		arrayParkingLotLabels.add(pLot8);
		arrayParkingLotLabels.add(pLot9);
		arrayParkingLotLabels.add(pLot10);
		arrayParkingLotLabels.add(pLot11);
		arrayParkingLotLabels.add(pLot12);
		arrayParkingLotLabels.add(pLot13);
		arrayParkingLotLabels.add(pLot14);
		arrayParkingLotLabels.add(pLot15);
		arrayParkingLotLabels.add(pLot16);

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
		btnChangePrice.addActionListener(this);

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

		vPlateNumberTextField.setHorizontalAlignment(SwingConstants.CENTER);
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
		choiceVehicleComboBox.setModel(new javax.swing.DefaultComboBoxModel(
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
		aboutMenuItem.addActionListener(this);
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

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void setPrivileges(String userName) {

		this.setEnabled(true);

		if (userName.equals(Privileges.ADMINISTRATOR.toString().toLowerCase())) {

			btnChangePrice.setEnabled(true);
			btnSeeReports.setEnabled(true);

		} else if (userName.equals(Privileges.USER.toString().toLowerCase())) {
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
		} else if (evt.getSource() == btnChangePrice) {
			controller.openChangePriceDialog();
		} else if (evt.getSource() == btnEnterVehicle) {

			String plateNumber = vPlateNumberTextField.getText().toUpperCase();
			String vehicle = choiceVehicleComboBox.getSelectedItem().toString();
			String parkingLot = choiceParkingLotComboBox.getSelectedItem().toString();

			boolean response = controller.enterVehicle(plateNumber, vehicle, parkingLot);

			if (response) {
				vPlateNumberTextField.setText("");
			}

		} else if (evt.getSource() == aboutMenuItem) {
			controller.openAboutDialog();
		}

	}

	private void buildSketch(ArrayList<ParkingLot> parkingLots) {

		for (int i = 0; i < parkingLots.size(); i++) {

			if (parkingLots.get(i).getVehicle().equals("-")) {
				arrayParkingLotLabels.get(i).setIcon(imageIcons.getEmptySpotIcon());
			} else if (parkingLots.get(i).getVehicle().equals("Automovil")) {
				arrayParkingLotLabels.get(i).setIcon(imageIcons.getCarIcon());
			} else if (parkingLots.get(i).getVehicle().equals("Motocicleta")) {
				arrayParkingLotLabels.get(i).setIcon(imageIcons.getMotorcycleIcon());
			}

		}

	}

	@Override
	public void parkingLotsValueChange(ArrayList<ParkingLot> parkingLots) {

		controller.buildVehicleTable(parkingLots);
		buildSketch(parkingLots);

	}

	@Override
	public void availableSpotsValueChange(String[] availableSpots) {
		controller.buildAvailableSpotsMessage(availableSpots.length);
		buildParkingLotComboBox(availableSpots);

	}

	public void buildParkingLotComboBox(String[] availableSpots) {

		choiceParkingLotComboBox.setModel(new javax.swing.DefaultComboBoxModel(availableSpots));

	}

	public void setAvailableSpotsMessage(String availableSpotsMessage, Color color) {
		parkingLotStatusInfoLbl.setText(availableSpotsMessage);
		parkingLotStatusInfoLbl.setForeground(color);
	}

	public void setEnableEnterVehicleButton(boolean isEnable) {

		btnEnterVehicle.setEnabled(isEnable);

	}

	@Override
	public void changeValueSelected(int parkingLotSelected) {

		controller.makeSameSelection(parkingLotSelected);

	}

	public void selectParkingLotLabel(int itemSelected) {

		for (ParkingLotLabel label : arrayParkingLotLabels) {
			if (label.getParkingLotNumber() != itemSelected) {
				label.deselectIcon();
			} else {
				label.selectIcon();
			}
		}

	}

	public void deselectAllParkingLotLabels() {
		for (ParkingLotLabel label : arrayParkingLotLabels) {
			label.deselectIcon();
		}

	}

	@Override
	public void priceValueChange(String priceValueChange) {
		priceInfoLbl.setText("Tarifa por hora:        $ " + priceValueChange);

	}

}
