package view.table.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CellsGestion extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	private String type = "text";

	// se definen por defecto los tipos de datos a usar
	private Font normal = new Font("Verdana", Font.PLAIN, 12);
	private Font bold = new Font("Verdana", Font.BOLD, 12);

	public CellsGestion() {

	}

	public CellsGestion(String type) {
		this.type = type;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused,
			int row, int column) {

		Color violetColor = new Color(102, 0, 102);
		Color colorFondoPorDefecto = new Color(192, 192, 192);

		if (selected) {
			this.setBackground(colorFondoPorDefecto);
		} else {
			this.setBackground(Color.white);
		}

		if (type.equals("spot")) {

			this.setHorizontalAlignment(SwingConstants.CENTER);
			this.setText((String) value);
			this.setForeground(violetColor);
			this.setFont(bold);

			return this;

		} else if (type.equals("vehicle")) {

			this.setHorizontalAlignment(SwingConstants.CENTER);
			this.setText((String) value);
			this.setFont(bold);

		}
		if (type.equals("plain")) {

			this.setHorizontalAlignment(SwingConstants.CENTER);
			this.setText((String) value);
			this.setFont(normal);

			return this;

		}

		return this;

	}

}
