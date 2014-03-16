package PresentacionCliente;

import java.awt.BorderLayout;
import java.awt.Component;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jdesktop.swingx.JXTaskPane;

import Logica.Cartas;
import Logica.DataCarta;
import PresentacionCliente.Controladores.ControladorVisualizarCartas;
import PresentacionCliente.Vistas.FrmPrincipalJugadores;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@SuppressWarnings("serial")
public class PanelCartas extends JXTaskPane{
	
	private FrmPrincipalJugadores ventana;
	private JTable tablaCartas;
	private DefaultTableModel modeloCartas;
	private ControladorVisualizarCartas controladorVisualizarCartas;
	private FacadeDispatcher facadeDispatcher = new FacadeDispatcher();
	
	public PanelCartas(FrmPrincipalJugadores ventana, String titulo, int codigoJugador){//, DataCarta cartas[]) {
		
		
		this.ventana = ventana;
		this.setTitle(titulo);
		this.setIcon(Utilidades.getIcon("reportes32"));
		this.setCollapsed(true);
		
		FormLayout layout = new FormLayout(
				"left:pref," +
				"fill:pref:grow", "");
		
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		
		List<DataCarta> listDataCarta = new ArrayList<DataCarta>();
		
		try {
			controladorVisualizarCartas = new ControladorVisualizarCartas(facadeDispatcher.getFacade());		
			listDataCarta = Arrays.asList(controladorVisualizarCartas.VisualizarCartas(codigoJugador));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		//ImageIcon aboutIcon = new ImageIcon("Iconos/blackjack5.gif");
		tablaCartas = new JTable();
		
		String []columnas = {"", ""};
		Object [][]matrizDatos = {};
		
		//modeloCartas = new DefaultTableModel(matrizDatos, columnas);
		//tablaCartas.setModel(modeloCartas);
		
		modeloCartas = new MyTableModel(matrizDatos, columnas);
		tablaCartas.setRowHeight(60);
		
		tablaCartas.setModel(modeloCartas);
		tablaCartas.getColumnModel().getColumn(0).setPreferredWidth(150);
		tablaCartas.getColumnModel().getColumn(1).setPreferredWidth(50);

		LimpiarTabla();
		for(int i=0; i<listDataCarta.size(); i++){

			Object[] nuevaFila = { listDataCarta.get(i).getValor() +" de " + listDataCarta.get(i).getPalo(),  Utilidades.createImage("Cartas/" + listDataCarta.get(i).getValor() + listDataCarta.get(i).getPalo())};
			modeloCartas.addRow(nuevaFila);
			
		}
		
		builder.append(tablaCartas);
		
		JPanel panelContenedor = builder.getPanel();
		this.add(panelContenedor, BorderLayout.CENTER);
	}
	
	 public ImageIcon createImage(String path) {
		 ClassLoader cl = Thread.currentThread().getContextClassLoader();
		 URL imgURL = cl.getResource("Iconos/" + path + ".jpg");
		     if (imgURL != null) {
		         return new ImageIcon(imgURL);
		     } else {
		         System.err.println("Couldn't find file: " + path);
		         return null;
		     }
		 }
	 
	 private class MyTableModel extends DefaultTableModel {
		 
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
	void LimpiarTabla(){
        int a = modeloCartas.getRowCount()-1;  
        for(int i=a;i>=0;i--){  
        	modeloCartas.removeRow(i);
        }
    }

}
