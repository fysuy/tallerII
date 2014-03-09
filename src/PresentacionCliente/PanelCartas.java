package PresentacionCliente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXTaskPane;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

@SuppressWarnings("serial")
public class PanelCartas extends JXTaskPane{
	
	private FrmPrincipalJugadores ventana;
	private JTable tablaCartas;
	private DefaultTableModel modeloCartas;
	
	public PanelCartas(FrmPrincipalJugadores ventana, String titulo) {
		
		this.ventana = ventana;
		this.setTitle(titulo);
		this.setIcon(Utilidades.getIcon("reportes32"));
		this.setCollapsed(true);
		
		FormLayout layout = new FormLayout(
				"left:pref," +
				"fill:pref:grow", "");
		
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		
		tablaCartas = new JTable();
		String []columnas = {"", "", "", ""};
		String [][]matrizDatos = {{"1", "2", "3", "4"},{"1", "2", "3", "4"}};
		modeloCartas = new DefaultTableModel(matrizDatos, columnas);
		tablaCartas.setModel(modeloCartas);
		
		
		builder.append(tablaCartas);
		
		JPanel panelContenedor = builder.getPanel();
		this.add(panelContenedor, BorderLayout.CENTER);
	}

}
