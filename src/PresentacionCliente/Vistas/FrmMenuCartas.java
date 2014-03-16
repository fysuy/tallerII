package PresentacionCliente.Vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

import Logica.DataListarJugadoresPartidas;
import PresentacionCliente.FacadeDispatcher;
import PresentacionCliente.PanelCartas;
import PresentacionCliente.Controladores.ControladorListarJugadores;
import PresentacionCliente.Controladores.ControladorVisualizarCartas;

@SuppressWarnings("serial")
public class FrmMenuCartas extends JScrollPane {
	private JXTaskPaneContainer contenedorPaneles;
	private JXTaskPane panelCartas;
	private JXTaskPane panelCartas2;
	private JXTaskPane panelCartas3;
	private ControladorVisualizarCartas controladorVisualizarCartas;
	private ControladorListarJugadores controladorListarJugadores;
	private JButton btnMostrar;
	private FrmPrincipalJugadores ventana;
	private FacadeDispatcher facadeDispatcher = new FacadeDispatcher();
	
	public FrmMenuCartas(FrmPrincipalJugadores ventana2) {
		
		ventana = ventana2;
		contenedorPaneles = new JXTaskPaneContainer();		
		setViewportView(contenedorPaneles);
		
		
		
		btnMostrar = new JButton("Mostrar cartas");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				panelCartas = new PanelCartas(ventana, "Gerard");
				contenedorPaneles.add(panelCartas);
				
				panelCartas2 = new PanelCartas(ventana, "Sebastian");
				contenedorPaneles.add(panelCartas2);
				
				panelCartas3 = new PanelCartas(ventana, "Pablo");
				contenedorPaneles.add(panelCartas3);*/
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
				contenedorPaneles.removeAll();
				contenedorPaneles.updateUI();
				
				btnMostrar.setBounds(757, 157, 89, 23);
				contenedorPaneles.add(btnMostrar);
				
				JXTaskPane panelCartas;
				
				List<DataListarJugadoresPartidas> dataListarJugadoresPartidas = new ArrayList<DataListarJugadoresPartidas>();
				
				try {
					controladorListarJugadores = new ControladorListarJugadores(facadeDispatcher.getFacade());
					dataListarJugadoresPartidas = Arrays.asList(controladorListarJugadores.ListarJugadores());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
				for (int i=0; i<dataListarJugadoresPartidas.size(); i++)
				{					
					panelCartas = new PanelCartas(ventana, dataListarJugadoresPartidas.get(i).getNombre(), dataListarJugadoresPartidas.get(i).getNumero());
					contenedorPaneles.add(panelCartas);
				}				
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
