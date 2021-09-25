/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frames;

import controller.Controller;
import sun.rmi.runtime.Log;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import application.Main;
import view.components.InsertPasswordTextField;
import view.components.InsertUserTextField;

/**
 *
 * @author conde
 */
public class LoginDialog extends javax.swing.JDialog implements ActionListener {

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLogin;
	private javax.swing.JLabel logoParkingLabel;
	private javax.swing.JPanel loginPane;
	private javax.swing.JPasswordField passwordField;
	private javax.swing.JPanel passwordPanel;
	private javax.swing.JTextField userJField;
	private javax.swing.JPanel userPanel;
	private Controller controller;

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public LoginDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		setTitle("Login");
		setLocationRelativeTo(null);
		setResizable(false);
		close();
	}

	/* Method to close the program when the JDialog Close button is clicked */
	public void close() {
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void initComponents() {

		loginPane = new javax.swing.JPanel();
		userPanel = new view.components.CustomPaintedPanel("../../resources/images/user_plate.png");
		userJField = new InsertUserTextField();
		passwordPanel = new view.components.CustomPaintedPanel("../../resources/images/password_plate.png");
		passwordField = new InsertPasswordTextField();
		btnLogin = new javax.swing.JButton();
		logoParkingLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		loginPane.setBackground(new java.awt.Color(204, 204, 204));

		userJField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		userJField.setForeground(new java.awt.Color(153, 153, 153));
		userJField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		userJField.setText("username");
		userJField.setToolTipText("");
		userJField.setBorder(null);
		userJField.setOpaque(false);

		javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
		userPanel.setLayout(userPanelLayout);
		userPanelLayout.setHorizontalGroup(userPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(userJField,
								javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(47, 47, 47)));
		userPanelLayout.setVerticalGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
						.addContainerGap(26, Short.MAX_VALUE).addComponent(userJField,
								javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		passwordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		passwordField.setForeground(new java.awt.Color(153, 153, 153));
		passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		passwordField.setText("password");
		passwordField.setBorder(null);
		passwordField.setOpaque(false);

		javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
		passwordPanel.setLayout(passwordPanelLayout);
		passwordPanelLayout
				.setHorizontalGroup(
						passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(passwordPanelLayout.createSequentialGroup().addGap(45, 45, 45)
										.addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 177,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(47, Short.MAX_VALUE)));
		passwordPanelLayout.setVerticalGroup(passwordPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanelLayout.createSequentialGroup()
						.addContainerGap(26, Short.MAX_VALUE).addComponent(passwordField,
								javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		btnLogin.setBackground(new java.awt.Color(0, 84, 140));
		btnLogin.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
		btnLogin.setForeground(new java.awt.Color(255, 255, 255));
		btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/login_icon.png"))); // NOI18N
		btnLogin.setText("  I N G R E S A R");
		btnLogin.setActionCommand("I N G R E S A R");
		btnLogin.setIconTextGap(2);
		btnLogin.addActionListener(this);

		logoParkingLabel
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/logoparking.png"))); // NOI18N

		javax.swing.GroupLayout loginPaneLayout = new javax.swing.GroupLayout(loginPane);
		loginPane.setLayout(loginPaneLayout);
		loginPaneLayout.setHorizontalGroup(loginPaneLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPaneLayout.createSequentialGroup()
						.addContainerGap(81, Short.MAX_VALUE)
						.addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPaneLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												loginPaneLayout.createSequentialGroup().addGroup(loginPaneLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(passwordPanel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(15, 15, 15))
										.addComponent(logoParkingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 302,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPaneLayout
										.createSequentialGroup().addComponent(btnLogin).addGap(62, 62, 62)))
						.addGap(72, 72, 72)));
		loginPaneLayout.setVerticalGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(loginPaneLayout.createSequentialGroup().addContainerGap()
						.addComponent(logoParkingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 297,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(24, 24, 24)
						.addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(10, 10, 10)
						.addComponent(passwordPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(loginPane,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(loginPane,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btnLogin) {

			String response = controller.validateLogin(userJField.getText(),
					String.valueOf(passwordField.getPassword()));

			if (!response.equals("")) {
				resetFields();
				controller.setPrivileges(response);
			}

		}
	}

	public void resetFields() {
		userJField.setText("username");
		passwordField.setText("password");

		userJField.setForeground(new java.awt.Color(153, 153, 153));
		passwordField.setForeground(new java.awt.Color(153, 153, 153));
	}

}
