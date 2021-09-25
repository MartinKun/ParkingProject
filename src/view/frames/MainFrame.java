/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frames;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;
import model.privileges.Privileges;
import view.components.CustomPaintedPanel;
import view.components.DetailPanel;
import view.components.EnterVehiclePlateTextField;
import view.components.ParkingLotLabel;

/**
 *
 * @author conde
 */
public class MainFrame extends javax.swing.JFrame implements ActionListener{

    private Dimension sizeWindow;
    private Rectangle window;
	private Controller controller;

    public MainFrame() {
    	
        setTitle("Principal");
        sizeWindow = Toolkit.getDefaultToolkit().getScreenSize();
        window = new Rectangle(sizeWindow);
        setBounds(window);
        setResizable(false);
    	
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        tablePanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        borderTopRightPanel = new javax.swing.JPanel();
        detailContainer = new DetailPanel();
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

        btnChangePrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnChangePrice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/change_price_icon.png"))); // NOI18N
        btnChangePrice.setText("Cambiar Tarifa");

        btnSeeReports.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSeeReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/reports_icon.png"))); // NOI18N
        btnSeeReports.setText(" Ver Reportes   ");

        priceInfoLbl.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        priceInfoLbl.setForeground(new java.awt.Color(255, 255, 255));
        priceInfoLbl.setText("Tarifa por hora:        $ 0.00");

        javax.swing.GroupLayout sideBarPanelLayout = new javax.swing.GroupLayout(sideBarPanel);
        sideBarPanel.setLayout(sideBarPanelLayout);
        sideBarPanelLayout.setHorizontalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnChangePrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSeeReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(priceInfoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        sideBarPanelLayout.setVerticalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnChangePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeeReports, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceInfoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(980, Short.MAX_VALUE))
        );

        mainContainerPanel.add(sideBarPanel, java.awt.BorderLayout.LINE_START);

        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(1551, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(1551, 250));

        vPlateNumberTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vPlateNumberTextField.setBorder(null);

        javax.swing.GroupLayout enterVPlatePanelLayout = new javax.swing.GroupLayout(enterVPlatePanel);
        enterVPlatePanel.setLayout(enterVPlatePanelLayout);
        enterVPlatePanelLayout.setHorizontalGroup(
            enterVPlatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enterVPlatePanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(vPlateNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        enterVPlatePanelLayout.setVerticalGroup(
            enterVPlatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enterVPlatePanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(vPlateNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        choiceVehicleComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        choiceVehicleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Vehiculo", "Automovil", "Motocicleta" }));

        choiceParkingLotComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        choiceParkingLotComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" }));

        parkingLotLbl.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        parkingLotLbl.setForeground(new java.awt.Color(255, 255, 255));
        parkingLotLbl.setText("Lugar:");

        btnEnterVehicle.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnEnterVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/car_in_icon.png"))); // NOI18N
        btnEnterVehicle.setText("INGRESAR VEHICULO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enterVPlatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(parkingLotLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(choiceVehicleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(choiceParkingLotComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnterVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(563, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEnterVehicle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(choiceVehicleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(choiceParkingLotComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(parkingLotLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(enterVPlatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(153, 153, 153))
        );

        mainPanel.add(jPanel1);

        middlePanel.setBackground(new java.awt.Color(0, 153, 153));
        middlePanel.setMaximumSize(new java.awt.Dimension(32767, 650));
        middlePanel.setMinimumSize(new java.awt.Dimension(806, 650));
        middlePanel.setPreferredSize(new java.awt.Dimension(806, 650));
        middlePanel.setLayout(new javax.swing.BoxLayout(middlePanel, javax.swing.BoxLayout.X_AXIS));

        tabbedPaneContainer.setBackground(new java.awt.Color(0, 153, 153));
        tabbedPaneContainer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tabbedPaneContainer.setMaximumSize(new java.awt.Dimension(1100, 681));
        tabbedPaneContainer.setMinimumSize(new java.awt.Dimension(1100, 681));
        tabbedPaneContainer.setPreferredSize(new java.awt.Dimension(1200, 681));

        sketchPanel.setMaximumSize(new java.awt.Dimension(1100, 650));
        sketchPanel.setMinimumSize(new java.awt.Dimension(1100, 650));
        sketchPanel.setPreferredSize(new java.awt.Dimension(1100, 650));

        javax.swing.GroupLayout sketchPanelLayout = new javax.swing.GroupLayout(sketchPanel);
        sketchPanel.setLayout(sketchPanelLayout);
        sketchPanelLayout.setHorizontalGroup(
            sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sketchPanelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pLot9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pLot8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pLot10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pLot7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pLot11, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pLot6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pLot12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pLot5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(sketchPanelLayout.createSequentialGroup()
                        .addComponent(pLot13, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(pLot14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sketchPanelLayout.createSequentialGroup()
                        .addComponent(pLot4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pLot3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pLot15, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pLot2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pLot16, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pLot1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        sketchPanelLayout.setVerticalGroup(
            sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sketchPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sketchPanelLayout.createSequentialGroup()
                        .addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pLot2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLot1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                        .addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pLot16, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLot15, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(sketchPanelLayout.createSequentialGroup()
                        .addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pLot3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLot4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLot5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLot8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLot7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLot6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sketchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pLot14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLot9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLot11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLot10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLot12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLot13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
        );

        tabbedPaneContainer.addTab("Croquis", sketchPanel);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1195, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
        );

        tabbedPaneContainer.addTab("Planilla", tablePanel);

        middlePanel.add(tabbedPaneContainer);

        rightPanel.setBackground(new java.awt.Color(204, 204, 204));
        rightPanel.setLayout(new javax.swing.BoxLayout(rightPanel, javax.swing.BoxLayout.Y_AXIS));

        borderTopRightPanel.setBackground(new java.awt.Color(0, 153, 153));
        borderTopRightPanel.setMaximumSize(new java.awt.Dimension(32767, 32));
        borderTopRightPanel.setMinimumSize(new java.awt.Dimension(100, 32));
        borderTopRightPanel.setPreferredSize(new java.awt.Dimension(199, 32));

        javax.swing.GroupLayout borderTopRightPanelLayout = new javax.swing.GroupLayout(borderTopRightPanel);
        borderTopRightPanel.setLayout(borderTopRightPanelLayout);
        borderTopRightPanelLayout.setHorizontalGroup(
            borderTopRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );
        borderTopRightPanelLayout.setVerticalGroup(
            borderTopRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        rightPanel.add(borderTopRightPanel);

        javax.swing.GroupLayout detailContainerLayout = new javax.swing.GroupLayout(detailContainer);
        detailContainer.setLayout(detailContainerLayout);
        detailContainerLayout.setHorizontalGroup(
            detailContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        detailContainerLayout.setVerticalGroup(
            detailContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        rightPanel.add(detailContainer);

        middlePanel.add(rightPanel);

        mainPanel.add(middlePanel);

        bottomPanel.setBackground(new java.awt.Color(0, 102, 102));

        parkingLotStatusInfoLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        parkingLotStatusInfoLbl.setForeground(new java.awt.Color(102, 204, 0));
        parkingLotStatusInfoLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        parkingLotStatusInfoLbl.setText("Lugares disponibles:  16");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addComponent(parkingLotStatusInfoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1391, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addComponent(parkingLotStatusInfoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 283, Short.MAX_VALUE))
        );

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
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextField vPlateNumberTextField;
    // End of variables declaration//GEN-END:variables

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void setPrivileges(String userName) {

		this.setEnabled(true);

		if (userName.equals(Privileges.ADMINISTRATOR.toString().toLowerCase())) {

			System.out.println("Privilegios administrador");
			logoutMenuItem.setEnabled(true);

		} else if (userName.equals(Privileges.USER.toString().toLowerCase())) {

			System.out.println("Privilegios usuario");

		}

	}

	public void restartPrivileges() {
		logoutMenuItem.setEnabled(false);
	}
    
	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource() == logoutMenuItem.getComponent()) {
			restartPrivileges();
			controller.logout();
		}
		
	}
}
