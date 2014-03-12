package PresentacionCliente;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import Logica.IFacadeLogica;
import PresentacionCliente.Vistas.FrmIniciarPartida;
import PresentacionCliente.Vistas.FrmIniciarTurnoDeUnJugador;
import PresentacionCliente.Vistas.FrmListarJugadores;
import PresentacionCliente.Vistas.FrmListarTodoCartasDeUnJugadores;
import PresentacionCliente.Vistas.FrmListarTodoJugadores;
import PresentacionCliente.Vistas.FrmNuevaPartida;
import PresentacionCliente.Vistas.FrmPartidasRegistradas;
import PresentacionCliente.Vistas.FrmRealizarJugada;

public class PanelCentral extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanel pan;
	
	public PanelCentral() {
		PanelCentralInicio panelCentralInicio = new PanelCentralInicio();
		this.setLayout(new BorderLayout());
		this.add(panelCentralInicio, BorderLayout.CENTER);
	}
	
	public void setPanel(int i) {
		pan=null;
		this.removeAll();
		switch (i){
			case 1:
				FrmNuevaPartida nuevaPartida = new FrmNuevaPartida();
				pan = nuevaPartida.getPanel();
				break;
			case 2:
				FrmIniciarPartida iniciarPartida = new FrmIniciarPartida();
				pan = iniciarPartida.getPanel();
				break;	
			case 3:
				FrmIniciarTurnoDeUnJugador iniciarTurnoDeUnJugador = new FrmIniciarTurnoDeUnJugador();
				pan = iniciarTurnoDeUnJugador.getPanel();
				break;
			case 4:
				FrmPartidasRegistradas partidasRegistradas = new FrmPartidasRegistradas();
				pan = partidasRegistradas.getPanel();
				break;	
			case 5:
				FrmListarJugadores listarJugadores = new FrmListarJugadores();
				pan = listarJugadores.getPanel();
				break;
			case 6:
				FrmListarTodoJugadores listarTodoJugadores = new FrmListarTodoJugadores();
				pan = listarTodoJugadores.getPanel();				
				break;	
			case 7:
				//NuevaPartida nuevaPartida = new NuevaPartida();Configuracion
				//pan = nuevaPartida.getPanel();
				break;	
			case 8:
				FrmListarTodoCartasDeUnJugadores listarTodoCartasDeUnJugadores = new FrmListarTodoCartasDeUnJugadores();
				pan = listarTodoCartasDeUnJugadores.getPanel();
				break;
			case 10:
				FrmRealizarJugada realizarJugada = new FrmRealizarJugada();
				pan = realizarJugada.getPanel();
				break;		
		} 
		
		this.add(pan, BorderLayout.CENTER);
		this.revalidate();
	}
	
}
