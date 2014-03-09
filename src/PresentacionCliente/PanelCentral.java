package PresentacionCliente;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PanelCentral extends JPanel{

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
				//NuevaPartida nuevaPartida = new NuevaPartida();Listar jugadores de una partida
				//pan = nuevaPartida.getPanel();
				break;
			case 6:
				FrmRespaldarDatos guardarPartidas = new FrmRespaldarDatos();
				pan = guardarPartidas.getPanel();
				break;	
			case 7:
				//NuevaPartida nuevaPartida = new NuevaPartida();Configuracion
				//pan = nuevaPartida.getPanel();
				break;	
			case 8:
				//NuevaPartida nuevaPartida = new NuevaPartida();Salir
				//pan = nuevaPartida.getPanel();
				break;
			case 10:
				PanelCentralInicio panelCentralInicio = new PanelCentralInicio();
				pan = panelCentralInicio.getPanel();
				break;		
		} 
		
		this.add(pan, BorderLayout.CENTER);
		this.revalidate();
	}
	
}
