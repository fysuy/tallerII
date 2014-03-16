package PresentacionCliente;

import javax.swing.table.DefaultTableModel;


class MyTableModel extends DefaultTableModel {
 
    public MyTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
 
	 @Override
	 public Class<?> getColumnClass(int columnIndex) {
	               Class<?> clazz = Object.class;
	               Object aux = getValueAt(0, columnIndex);
	               if (aux != null) {
	            	   clazz = aux.getClass();
	               }
	   
	  return clazz;
	 }
  
}
