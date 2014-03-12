package PresentacionCliente.Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

import PresentacionCliente.PanelCartas;
import PresentacionCliente.Controladores.ControladorVisualizarCartas;

@SuppressWarnings("serial")
public class FrmMenuCartas extends JScrollPane {
	private JXTaskPaneContainer contenedorPaneles;
	private JXTaskPane panelCartas;
	private JXTaskPane panelCartas2;
	private JXTaskPane panelCartas3;
	private ControladorVisualizarCartas controladorVisualizarCartas;
	private JButton btnMostrar;
	FrmPrincipalJugadores ventana;
	
	public FrmMenuCartas(FrmPrincipalJugadores ventana2) {
		
		ventana = ventana2;
		contenedorPaneles = new JXTaskPaneContainer();		
		setViewportView(contenedorPaneles);
		
		
		
		btnMostrar = new JButton("Mostrar cartas");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				panelCartas = new PanelCartas(ventana, "Gerard");
				contenedorPaneles.add(panelCartas);
				
				panelCartas2 = new PanelCartas(ventana, "Sebastian");
				contenedorPaneles.add(panelCartas2);
				
				panelCartas3 = new PanelCartas(ventana, "Pablo");
				contenedorPaneles.add(panelCartas3);
				/*String nombre;
				Cartas cartas;
				controladorVisualizarCartas = new ControladorVisualizarCartas();		
				DataVisualizarCartas arregloDataVisualizarCartas[] = controladorVisualizarCartas.VisualizarCartas();
				
				for (int i=0;i<arregloDataVisualizarCartas.length;i++)
				{
					nombre = arregloDataVisualizarCartas[i].getNombre();
					cartas = arregloDataVisualizarCartas[i].getCartas();
					JXTaskPane panelCartas = new PanelCartas(ventana, "panelCartas" + nombre, cartas);
					contenedorPaneles.add(panelCartas);
				}*/
				
			}
		});
		btnMostrar.setBounds(757, 157, 89, 23);
		contenedorPaneles.add(btnMostrar);
		
		
		/*
		controladorVisualizarCartas = new ControladorVisualizarCartas();		
		DataVisualizarCartas arregloDataVisualizarCartas[] = controladorVisualizarCartas.VisualizarCartas();
		String nombre;
		Cartas cartas;
		for (int i=0;i<arregloDataVisualizarCartas.length;i++)
		{
			nombre = arregloDataVisualizarCartas[i].getNombre();
			cartas = arregloDataVisualizarCartas[i].getCartas();
			//contenedorPaneles.add(new PanelCartas(ventana, nombre));
			
			//JXTaskPane panelCartas;
			//panelCartas.setName(panelCartas + nombre);
			
			JXTaskPane panelCartas = new PanelCartas(ventana, "panelCartas" + nombre, cartas);
			contenedorPaneles.add(panelCartas);
			
			//panel.add(new JLabel("hola"));
			
		}
		
		*/
		
		
			

		

	}

}
