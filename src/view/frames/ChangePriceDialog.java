/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.WindowConstants;

import controller.Controller;
import model.PriceObserver;

/**
 *
 * @author conde
 */
public class ChangePriceDialog extends javax.swing.JDialog implements PriceObserver, ActionListener, KeyListener {


	private static final long serialVersionUID = 1L;
	
	private static ChangePriceDialog changePriceDialog;
	private Controller controller;
	private String priceValueChange;

	private ChangePriceDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setTitle("Cambiar Tarifa");
		initComponents();
		close();
	}

	public static ChangePriceDialog getInstance(java.awt.Frame parent, boolean modal) {

		if (changePriceDialog == null) {
			changePriceDialog = new ChangePriceDialog(parent, modal);
		}

		return changePriceDialog;

	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	/* Method to close the program when the JDialog Close button is clicked */
	public void close() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				priceTextField.setText(priceValueChange);
				dispose();
			}
		});
	}

	private void initComponents() {

		changePriceLbl = new javax.swing.JLabel();
		priceTextField = new javax.swing.JTextField();
		btnAccept = new javax.swing.JButton();
		btnCancel = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		changePriceLbl.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
		changePriceLbl.setText("Cambiar Tarifa:    $");

		priceTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		priceTextField.addKeyListener(this);

		btnAccept.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/check_icon.png"))); // NOI18N
		btnAccept.setText("Aceptar");
		btnAccept.addActionListener(this);

		btnCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cancel_icon.png"))); // NOI18N
		btnCancel.setText("Cancelar");
		btnCancel.addActionListener(this);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(74, 74, 74)
										.addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 135,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnCancel))
								.addGroup(layout.createSequentialGroup().addGap(53, 53, 53)
										.addComponent(changePriceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 158,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 188,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(21, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(26, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(changePriceLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCancel))
						.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAccept;
	private javax.swing.JButton btnCancel;
	private javax.swing.JLabel changePriceLbl;
	private javax.swing.JTextField priceTextField;
	// End of variables declaration//GEN-END:variables

	@Override
	public void priceValueChange(String priceValueChange) {
		if (!priceValueChange.contains(".")) {
			priceValueChange += ".00";
		}
		this.priceValueChange = priceValueChange;

		priceTextField.setText(priceValueChange);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btnAccept) {
			String priceText = priceTextField.getText();
			boolean response = controller.validateChangePriceTextField(priceText);
			if (response) {
				if (controller.confirmChangePrice()) {
					controller.updatePrice(priceText);
				}
			} else {
				controller.showErrorMessage("Los valores que intenta ingresar no son correctos.");
			}
			
		} else if (evt.getSource() == btnCancel) {
			priceTextField.setText(priceValueChange);
			this.setVisible(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent evt) {
		char c = evt.getKeyChar();
		if (!Character.isDigit(c) && c != '.') {
			evt.consume();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		

	}
}
