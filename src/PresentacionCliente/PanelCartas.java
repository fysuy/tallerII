package PresentacionCliente;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
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
	
	public PanelCartas(FrmPrincipalJugadores ventana, String titulo){//, Cartas cartas) {
		
		this.ventana = ventana;
		this.setTitle(titulo);
		this.setIcon(Utilidades.getIcon("reportes32"));
		this.setCollapsed(true);
		
		FormLayout layout = new FormLayout(
				"left:pref," +
				"fill:pref:grow", "");
		
		DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		
		
		ImageIcon aboutIcon = new ImageIcon("Iconos/blackjack5.gif");
		tablaCartas = new JTable();
		String []columnas = {"", "", ""};
		Object [][]matrizDatos = {{aboutIcon},{Utilidades.getIcon("Gris")}};
		modeloCartas = new DefaultTableModel(matrizDatos, columnas);
		tablaCartas.setModel(modeloCartas);
		
		
		builder.append(tablaCartas);
		
		JPanel panelContenedor = builder.getPanel();
		this.add(panelContenedor, BorderLayout.CENTER);
	}

}
