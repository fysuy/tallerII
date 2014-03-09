package PresentacionCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class BarraHerramientasCrupier extends JToolBar{
	
	private FrmPrincipalCrupier ventana;
	JButton button1, button2, button3, button4, button5, button6, button7, button8;
	
	
	public BarraHerramientasCrupier(String label, int size, boolean hasStrings, FrmPrincipalCrupier ventana) throws RemoteException {
		super();
		this.ventana = ventana;
		this.setRollover( true );
		this.setFloatable( false );
		
		button1 = new JButton(hasStrings ? "Crear una nueva partida" : null, Utilidades.getIcon("Rojo"));
		button1.addActionListener(new ManejadorEventos());
		button1.setToolTipText("Crear una nueva partida");
		button1.setVerticalTextPosition( SwingConstants.BOTTOM );
		button1.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button1);		
		this.addSeparator();
		
		button2 = new JButton(hasStrings ? "Iniciar una nueva partida" : null, Utilidades.getIcon("Gris"));
		button2.addActionListener(new ManejadorEventos());
		button2.setToolTipText("Iniciar una nueva partida");
		button2.setVerticalTextPosition( SwingConstants.BOTTOM );
		button2.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button2);		
		this.addSeparator();
		
		button3 = new JButton(hasStrings ? "Iniciar turno de un jugador" : null, Utilidades.getIcon("Celeste"));
		button3.addActionListener(new ManejadorEventos());
		button3.setToolTipText("Iniciar turno de un jugador");
		button3.setVerticalTextPosition( SwingConstants.BOTTOM );
		button3.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button3);		
		this.addSeparator();
		
		button4 = new JButton(hasStrings ? "Listar partidas registradas" : null, Utilidades.getIcon("Corazon"));
		button4.addActionListener(new ManejadorEventos());
		button4.setToolTipText("Listar partidas registradas");
		button4.setVerticalTextPosition( SwingConstants.BOTTOM );
		button4.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button4);		
		this.addSeparator();
		
		button5 = new JButton(hasStrings ? "Listar jugadores" : null, Utilidades.getIcon("Celeste"));
		button5.addActionListener(new ManejadorEventos());
		button5.setToolTipText("Listar jugadores de una partida");
		button5.setVerticalTextPosition( SwingConstants.BOTTOM );
		button5.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button5);		
		this.addSeparator();
		
		button6 = new JButton(hasStrings ? "     Guardar    " : null, Utilidades.getIcon("Guardar"));
		button6.addActionListener(new ManejadorEventos());
		button6.setToolTipText("Guardar");
		button6.setVerticalTextPosition( SwingConstants.BOTTOM );
		button6.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button6);		
		this.addSeparator();
		
		button7 = new JButton(hasStrings ? "  Configuración  " : null, Utilidades.getIcon("Config"));
		button7.addActionListener(new ManejadorEventos());
		button7.setToolTipText("Configuración");
		button7.setVerticalTextPosition( SwingConstants.BOTTOM );
		button7.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button7);		
		this.addSeparator();
		
		button8 = new JButton(hasStrings ? "      Salir      " : null, Utilidades.getIcon("salir"));
		button8.addActionListener(new ManejadorEventos());
		button8.setToolTipText("Salir");
		button8.setVerticalTextPosition( SwingConstants.BOTTOM );
		button8.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button8);		
		this.addSeparator();

		
		this.add(Box.createGlue());
	}
	
	// Clase interna para manejar los eventos de los botones
	public class ManejadorEventos implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			    if (e.getSource() == button1){
					ventana.getPan().setPanel(1);	
				}
				if (e.getSource() == button2){
					ventana.getPan().setPanel(2);
				}
				if (e.getSource() == button3){
					ventana.getPan().setPanel(3);
				}				
				if (e.getSource() == button4){
					ventana.getPan().setPanel(4);					 
				}
				if (e.getSource() == button5){
					ventana.getPan().setPanel(5);
				}
				if (e.getSource() == button6){
					ventana.getPan().setPanel(6);
				}	
				if (e.getSource() == button7){
					ventana.getPan().setPanel(7);					 
				}
				if (e.getSource() == button8){
					ventana.dispose();					 
				}
			
		};
	};
	
}
