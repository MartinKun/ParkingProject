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
import java.util.Date;

import javax.swing.WindowConstants;

import controller.Controller;
import helpers.LanguageManager;
import model.dto.ParkingLot;
import model.dto.PaymentInformation;

public class GetPaidDialog extends javax.swing.JDialog implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private javax.swing.JButton btnAddDiscount;
	private javax.swing.JLabel discountLbl;
	private javax.swing.JTextField discountTextField;
	private javax.swing.JButton btnGetPaid;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel percentLbl;
	private javax.swing.JTextArea ticketTextArea;
	private javax.swing.JLabel totalAmountPayableLbl;
	private javax.swing.JLabel totalLbl;

	private Controller controller;
	private LanguageManager languageManager = LanguageManager.getInstance();

	private ParkingLot parkingLotSelected;
	private PaymentInformation paymentInformation;
	private static GetPaidDialog getPaidDialog;

	private GetPaidDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setTitle("Cobrar");
		initComponents();
		close();
	}

	public static GetPaidDialog getInstance(java.awt.Frame parent, boolean modal) {

		if (getPaidDialog == null) {
			getPaidDialog = new GetPaidDialog(parent, modal);
		}

		return getPaidDialog;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public void setParkingLot(ParkingLot parkingLotSelected) {
		if (parkingLotSelected != null) {
			parkingLotSelected.getVehicle().getDetail().setDepartureDate(new Date());
		}
		this.parkingLotSelected = parkingLotSelected;

	}

	public void setPaymentInformation(PaymentInformation paymentInformation) {
		if (paymentInformation != null) {
			discountTextField.setText(paymentInformation.getDiscount() + "");
			totalAmountPayableLbl.setText(paymentInformation.getPartial()
					- (paymentInformation.getDiscount() * paymentInformation.getPartial() / 100) + "");
		}

		this.paymentInformation = paymentInformation;

	}

	public void updateValues() {
		discountTextField.setText(paymentInformation.getDiscount() + "");
		totalAmountPayableLbl.setText(paymentInformation.getTotal() + "");
	}

	/* Method to close the program when the JDialog Close button is clicked */
	public void close() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				cleanUpResources();
			}
		});
	}

	private void initComponents() {

		jLabel5 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		ticketTextArea = new javax.swing.JTextArea();
		discountLbl = new javax.swing.JLabel();
		discountTextField = new javax.swing.JTextField();
		btnAddDiscount = new javax.swing.JButton();
		totalLbl = new javax.swing.JLabel();
		totalAmountPayableLbl = new javax.swing.JLabel();
		percentLbl = new javax.swing.JLabel();
		btnGetPaid = new javax.swing.JButton();

		jLabel5.setText("jLabel5");

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		ticketTextArea.setColumns(20);
		ticketTextArea.setRows(5);
		ticketTextArea.setEditable(false);
		jScrollPane1.setViewportView(ticketTextArea);

		discountLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		discountLbl.setText(languageManager.getProperty("discount") + ":");

		discountTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		discountTextField.setText("0.00");
		discountTextField.addKeyListener(this);
		discountTextField.addActionListener(this);

		btnAddDiscount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btnAddDiscount.setText(languageManager.getProperty("add") + " ->");
		btnAddDiscount.addActionListener(this);

		totalLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		totalLbl.setText("TOTAL:   $");

		totalAmountPayableLbl.setBackground(new java.awt.Color(102, 102, 255));
		totalAmountPayableLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		totalAmountPayableLbl.setForeground(new java.awt.Color(102, 102, 255));
		totalAmountPayableLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		totalAmountPayableLbl.setText("0.00");

		percentLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		percentLbl.setText("%");

		btnGetPaid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		btnGetPaid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/cashier_icon.png")));
		btnGetPaid.setText(languageManager.getProperty("get_paid"));
		btnGetPaid.addActionListener(this);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
												.createSequentialGroup().addComponent(discountLbl)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(discountTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
														64, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(percentLbl).addGap(18, 18, 18)
												.addComponent(btnAddDiscount, javax.swing.GroupLayout.PREFERRED_SIZE,
														109, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 79,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(totalAmountPayableLbl,
														javax.swing.GroupLayout.PREFERRED_SIZE, 99,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(btnGetPaid, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 157,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(discountLbl, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAddDiscount, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(totalLbl, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(totalAmountPayableLbl, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(discountTextField).addComponent(percentLbl, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(18, 18, 18).addComponent(btnGetPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(20, 20, 20)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public void displayTicket() {

		String ticket = controller.generateTicket(parkingLotSelected.getVehicle().getType(),
				parkingLotSelected.getVehicle().getPlate(), parkingLotSelected.getVehicle().getDetail().getEntryDate(),
				parkingLotSelected.getVehicle().getDetail().getDepartureDate(), paymentInformation.getPartial());

		ticketTextArea.setText(ticket);

	}

	public void showTotalAmountPayable(double totalAmountPayable) {
		this.totalAmountPayableLbl.setText(totalAmountPayable + "");

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btnAddDiscount) {
			boolean response = controller.validateDiscountTextField(discountTextField.getText());
			if (response) {
				double discount = Double.parseDouble(discountTextField.getText());
				paymentInformation.setDiscount(discount);
				paymentInformation.setTotal(paymentInformation.getPartial()
						- (paymentInformation.getDiscount() * paymentInformation.getPartial() / 100));
				updateValues();
			} else {
				controller.showErrorMessage(languageManager.getProperty("alert.wrong_discount"));
				restartValues();
			}

		} else if (evt.getSource() == btnGetPaid) {
			 boolean response = controller.createCashRegister(parkingLotSelected, paymentInformation);
			if (response) {
				controller.removeVehicle(parkingLotSelected.getVehicle(), parkingLotSelected.getSpot());
				controller.successCreateCashRegister();
			} else {
				controller.showErrorMessage(languageManager.getProperty("alert.error_insert_register"));
			}
		}

	}

	public void restartValues() {
		paymentInformation.setDiscount(0.0);
		paymentInformation.setTotal(paymentInformation.getPartial());
		updateValues();
	}
	
	public void cleanUpResources() {
		setParkingLot(null);
		setPaymentInformation(null);
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		char c = evt.getKeyChar();
		if (!Character.isDigit(c) && c != '.') {
			evt.consume();
		}
		if (evt.getSource() == discountTextField) {
			if (discountTextField.getText().length() > 5) {
				evt.consume();
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
