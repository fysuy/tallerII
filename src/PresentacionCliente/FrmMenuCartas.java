package PresentacionCliente;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

import Logica.Cartas;
import Logica.DataVisualizarCartas;

@SuppressWarnings("serial")
public class FrmMenuCartas extends JScrollPane {
	private JXTaskPaneContainer contenedorPaneles;
	private JXTaskPane panelCartas;
	private JXTaskPane panelCartas2;
	private JXTaskPane panelCartas3;
	private ControladorVisualizarCartas controladorVisualizarCartas;
	
	public FrmMenuCartas(FrmPrincipalJugadores ventana) {
		
		
		contenedorPaneles = new JXTaskPaneContainer();		
		setViewportView(contenedorPaneles);
		/*
		controladorVisualizarCartas = new ControladorVisualizarCartas();		
		DataVisualizarCartas arregloDataVisualizarCartas[] = controladorVisualizarCartas.VisualizarCartas();
		String nombre;
		Cartas cartas;
		for (int i=0;i<arregloDataVisualizarCartas.length;i++)
		{
			nombre = arregloDataVisualizarCartas[i].getNombre();
			cartas = arregloDataVisualizarCartas[i].getCartas();
			contenedorPaneles.add(new PanelCartas(ventana, nombre));
			
			//JXTaskPane panelCartas + "" + nombre;panel.add(new JLabel("hola"));
			
		}
		*/
		
		
		
				
		panelCartas = new PanelCartas(ventana, "Gerard");
		contenedorPaneles.add(panelCartas);
		
		panelCartas2 = new PanelCartas(ventana, "Sebastian");
		contenedorPaneles.add(panelCartas2);
		
		panelCartas3 = new PanelCartas(ventana, "Pablo");
		contenedorPaneles.add(panelCartas3);

	}

}
