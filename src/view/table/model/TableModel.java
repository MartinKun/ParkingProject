package view.table.model;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

	String[] titles;
	Object[][] data;

	/**
	 * Determina el modelo con el que se va a construir la tabla
	 * 
	 * @param datos
	 * @param titulos
	 */
	public TableModel(Object[][] data, String[] titles) {
		super();
		this.titles = titles;
		this.data = data;
		setDataVector(data, titles);
	}

	public TableModel() {
		// TODO Auto-generated constructor stub
	}

	public boolean isCellEditable(int row, int column) {
		return false;

	}

}