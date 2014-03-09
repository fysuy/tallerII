package PresentacionCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class BarraHerramientasJugadores extends JToolBar{
	
	private FrmPrincipalJugadores ventana;
	JButton button1, button2, button3, button4, button5, button6, button7, button8;
	
	
	public BarraHerramientasJugadores(String label, int size, boolean hasStrings, FrmPrincipalJugadores ventana) throws RemoteException {
		super();
		this.ventana = ventana;
		this.setRollover( true );
		this.setFloatable( false );
		
		button1 = new JButton(hasStrings ? "Iniciar sesión" : null, Utilidades.getIcon("Rojo"));
		button1.addActionListener(new ManejadorEventos());
		button1.setToolTipText("Iniciar sesión");
		button1.setVerticalTextPosition( SwingConstants.BOTTOM );
		button1.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button1);		
		this.addSeparator();
		
		button2 = new JButton(hasStrings ? "Realizar jugada" : null, Utilidades.getIcon("Gris"));
		button2.addActionListener(new ManejadorEventos());
		button2.setToolTipText("Realizar jugada");
		button2.setVerticalTextPosition( SwingConstants.BOTTOM );
		button2.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button2);		
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
