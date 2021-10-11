/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.table.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.JTableHeader;

import controller.Controller;
import model.domain.ParkingLot;
import view.table.model.GestionTableHeader;
import view.table.model.TableModel;
import view.table.model.CellsGestion;

/**
 *
 * @author conde
 */
public class TablePanel extends javax.swing.JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller controller;
	private static TablePanel tablePanel;

	private TablePanel() {
		initComponents();

	}

	public static TablePanel getInstance() {

		if (tablePanel == null) {
			tablePanel = new TablePanel();
		}

		return tablePanel;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		parkedVehiclesTable = new javax.swing.JTable();

		setBackground(new java.awt.Color(240, 240, 240));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup().addGap(62, 62, 62).addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(68, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup().addGap(52, 52, 52).addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(72, Short.MAX_VALUE)));

		parkedVehiclesTable.addMouseListener(this);

	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable parkedVehiclesTable;
	// End of variables declaration//GEN-END:variables

	public void buildTable(ArrayList<ParkingLot> parkingLots) {
		String titles[] = { "Lugar", "Vehiculo", "Patente", "Fecha de Admision", "Hora de Ingreso" };
		String data[][] = getMatriz(parkingLots);
		TableModel tableModel = new TableModel(data, titles);
		parkedVehiclesTable.setModel(tableModel);

		// personaliza el encabezado
		JTableHeader jtableHeader = parkedVehiclesTable.getTableHeader();
		jtableHeader.setDefaultRenderer(new GestionTableHeader());
		parkedVehiclesTable.setTableHeader(jtableHeader);

		parkedVehiclesTable.setRowHeight(30);
		parkedVehiclesTable.getColumnModel().getColumn(0).setMaxWidth(62);
		parkedVehiclesTable.getColumnModel().getColumn(1).setPreferredWidth(92);
		parkedVehiclesTable.getColumnModel().getColumn(2).setPreferredWidth(92);
		parkedVehiclesTable.getColumnModel().getColumn(3).setPreferredWidth(92);
		parkedVehiclesTable.getColumnModel().getColumn(4).setPreferredWidth(92);

		parkedVehiclesTable.getColumnModel().getColumn(0).setCellRenderer(new CellsGestion("spot"));
		parkedVehiclesTable.getColumnModel().getColumn(1).setCellRenderer(new CellsGestion("vehicle"));
		parkedVehiclesTable.getColumnModel().getColumn(2).setCellRenderer(new CellsGestion("spot"));
		parkedVehiclesTable.getColumnModel().getColumn(3).setCellRenderer(new CellsGestion("plain"));
		parkedVehiclesTable.getColumnModel().getColumn(4).setCellRenderer(new CellsGestion("plain"));

		parkedVehiclesTable.setGridColor(new java.awt.Color(0, 0, 0));
		parkedVehiclesTable.setShowHorizontalLines(true);
		parkedVehiclesTable.setShowVerticalLines(true);

		jScrollPane1.setViewportView(parkedVehiclesTable);
	}

	private String[][] getMatriz(ArrayList<ParkingLot> parkingLots) {

		String matrizData[][] = new String[parkingLots.size()][5];
		for (int i = 0; i < parkingLots.size(); i++) {
			matrizData[i][0] = parkingLots.get(i).getSpot() + "";
			matrizData[i][1] = parkingLots.get(i).getVehicle();
			matrizData[i][2] = parkingLots.get(i).getPlate();
			matrizData[i][3] = parkingLots.get(i).getAdmissionDate();
			matrizData[i][4] = parkingLots.get(i).getAdmissionHour();
		}

		return matrizData;
	}

	public void selectRow(int parkingLotSelected) {
		parkedVehiclesTable.setRowSelectionInterval(parkingLotSelected - 1, parkingLotSelected - 1);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent evt) {
		if(evt.getSource() == parkedVehiclesTable) {
			int parkingLotSelected = parkedVehiclesTable.getSelectedRow();
			controller.makeSameSelection(parkingLotSelected + 1);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
