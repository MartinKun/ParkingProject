/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;

import controller.Controller;
import helpers.LanguageManager;
import model.enums.Privileges;

/**
 *
 * @author conde
 */
public class ReportsDialog extends javax.swing.JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JFileChooser fileChooser;
	private javax.swing.JButton btnSaveFile;
	private javax.swing.JTextArea cashBalancingTxtArea;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTabbedPane tabbedPaneReports;
	private javax.swing.JTextArea vehicleMovementsTxtArea;
	boolean isFirstPanelShowed = true;
	boolean isSecondPanelShowed = false;

	private static ReportsDialog reportsDialog;
	private Controller controller;
	
	private LanguageManager languageManager = LanguageManager.getInstance();

	private ReportsDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setTitle(languageManager.getProperty("reports.title"));
		initComponents();
	}

	public static ReportsDialog getInstance(java.awt.Frame parent, boolean modal) {

		if (reportsDialog == null) {
			reportsDialog = new ReportsDialog(parent, modal);
		}

		return reportsDialog;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	private void initComponents() {

		fileChooser = new JFileChooser();

		tabbedPaneReports = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		vehicleMovementsTxtArea = new javax.swing.JTextArea();
		vehicleMovementsTxtArea.setEditable(false);
		jPanel2 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		cashBalancingTxtArea = new javax.swing.JTextArea();
		cashBalancingTxtArea.setEditable(false);
		btnSaveFile = new javax.swing.JButton();
		btnSaveFile.addActionListener(this);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		tabbedPaneReports.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		tabbedPaneReports.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				int index = tabbedPaneReports.getSelectedIndex();
				if (index == 0) {
					isFirstPanelShowed = true;
					isSecondPanelShowed = false;
				} else if (index == 1) {
					isFirstPanelShowed = false;
					isSecondPanelShowed = true;
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		vehicleMovementsTxtArea.setBackground(new java.awt.Color(44, 47, 51));
		vehicleMovementsTxtArea.setColumns(20);
		vehicleMovementsTxtArea.setForeground(new java.awt.Color(255, 255, 255));
		vehicleMovementsTxtArea.setRows(5);
		jScrollPane1.setViewportView(vehicleMovementsTxtArea);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
						javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)));

		tabbedPaneReports.addTab(languageManager.getProperty("vehicle_movements"), jPanel1);

		cashBalancingTxtArea.setBackground(new java.awt.Color(44, 47, 51));
		cashBalancingTxtArea.setColumns(20);
		cashBalancingTxtArea.setForeground(new java.awt.Color(255, 255, 255));
		cashBalancingTxtArea.setRows(5);

		jScrollPane3.setViewportView(cashBalancingTxtArea);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane3,
						javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)));

		tabbedPaneReports.addTab(languageManager.getProperty("cash_collection"), jPanel2);

		btnSaveFile.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		btnSaveFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/save_file_icon.png"))); // NOI18N
		btnSaveFile.setText(languageManager.getProperty("reports.file_saved"));
		btnSaveFile.setEnabled(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(11, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(btnSaveFile).addComponent(tabbedPaneReports,
										javax.swing.GroupLayout.PREFERRED_SIZE, 481,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(10, 10, 10)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(tabbedPaneReports, javax.swing.GroupLayout.PREFERRED_SIZE, 536,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnSaveFile)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public void displayCashBalancingData(String cashBalancingData) {
		cashBalancingTxtArea.setText(cashBalancingData);

	}

	public void displayVehicleMovementsData(String vehicleMovementsData) {
		vehicleMovementsTxtArea.setText(vehicleMovementsData);

	}

	public void setPrivileges(String userName) {
		if (userName.equals(Privileges.ADMINISTRATOR.toString().toLowerCase())) {

			btnSaveFile.setEnabled(true);

		} else if (userName.equals(Privileges.USER.toString().toLowerCase())) {

			btnSaveFile.setEnabled(false);

		}

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btnSaveFile) {
			if (isFirstPanelShowed == true && isSecondPanelShowed == false) {

				if (fileChooser.showDialog(null, languageManager.getProperty("save")) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					if (file.getName().endsWith("txt")) {
						String document = vehicleMovementsTxtArea.getText();
						boolean response = controller.saveFile(file, document);
						if (response) {
							controller.successSaveFile();
							controller.cleanVehicleMovementsFile();
							vehicleMovementsTxtArea.setText("");
						} else {
							controller.showErrorMessage(languageManager.getProperty("alert.file_cant_be_saved"));
						}
					} else {
						controller.showErrorMessage(languageManager.getProperty("alert.wrong_text_file"));
					}
				}
			} else if (fileChooser.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				if (file.getName().endsWith("txt")) {
					String document = cashBalancingTxtArea.getText();
					boolean response = controller.saveFile(file, document);
					if (response) {
						controller.successSaveFile();
						cashBalancingTxtArea.setText("");
					} else {
						controller.showErrorMessage(languageManager.getProperty("alert.file_cant_be_saved"));
					}
				} else {
					controller.showErrorMessage(languageManager.getProperty("alert.wrong_text_file"));
				}
			}
		}

	}

}
