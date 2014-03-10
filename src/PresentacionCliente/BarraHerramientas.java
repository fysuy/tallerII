package PresentacionCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class BarraHerramientas extends JToolBar{
	
	private FrmPrincipal ventana;
	private boolean hasStrings; 	
	
	public BarraHerramientas(String label, int size, boolean hasStrings, FrmPrincipal ventana) throws RemoteException {
		super();
		this.ventana = ventana;
		this.setRollover( true );
		this.setFloatable( false );
		this.hasStrings = hasStrings;
		
		AddButton("Crear una nueva partida", "Rojo", 1);
		AddButton("Iniciar una nueva partida", "Gris", 2);
		AddButton("Iniciar turno de un jugador", "Celeste", 3);
		AddButton("Listar partidas registradas", "Corazon", 4);
		AddButton("Listar jugadores", "Celeste", 5);
		AddButton("Guardar", "Guardar", 6);
		AddButton("Configuración", "Configuracion", 7);
		AddButton("Salir", "kTrebol", 0);
		
		this.add(Box.createGlue());
	}
	
	public void AddButton(String label, String iconName, int buttonNumber)
	{
		JButton button = new JButton();
		button = new JButton(this.hasStrings ? label : null, Utilidades.getIcon(iconName));
		button.addActionListener(new ManejadorEventos(buttonNumber));
		button.setToolTipText(label);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		this.add(button);		
		this.addSeparator();
	}
	
	//Clase interna para manejar los eventos de los botones
	public class ManejadorEventos implements ActionListener {
		private int panelNumber;
		
		public ManejadorEventos(int buttonNumber){ this.panelNumber = buttonNumber; };
		
		public void actionPerformed(ActionEvent e) {
			if(panelNumber == 0)
				ventana.dispose();
			else
				ventana.getPan().setPanel(panelNumber);
		};
	};
	
}
