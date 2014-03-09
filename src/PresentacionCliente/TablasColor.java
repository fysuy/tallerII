package PresentacionCliente;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TablasColor extends JLabel implements TableCellRenderer {

private static Color LIGHT_YELLOW = new Color(255, 250, 190);

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	
			String textValue = (String) value;
			this.setText(textValue);		
			this.setOpaque(true);
			
			this.setFont(table.getFont());
			this.setForeground(table.getForeground());
			this.setBackground(table.getBackground());
			
			if (0 == row % 2) {
				this.setBackground(SystemColor.inactiveCaption);
			} else {
				this.setBackground(LIGHT_YELLOW);
			}
			
			if (isSelected) {
				this.setForeground(table.getSelectionForeground());
				this.setBackground(table.getSelectionBackground());
			}
			
			
			
			return this;
	}
}