package PresentacionCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class BarraHerramientas extends JToolBar{
	
	private FrmPrincipal ventana;
	JButton button1, button2, button3, button4;
	
	
	public BarraHerramientas(String label, int size, boolean hasStrings, FrmPrincipal ventana) throws RemoteException {
		super();
		this.ventana = ventana;
		this.setRollover( true );
		this.setFloatable( false );
		
		button1 = new JButton(hasStrings ? "  Crear nueva partida  " : null, Utilidades.getIcon("1Corazones"));
		button1.addActionListener(new ManejadorEventos());
		button1.setToolTipText("Crear nueva partida");
		button1.setVerticalTextPosition( SwingConstants.BOTTOM );
		button1.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button1);
		
		this.addSeparator();
		
		button2 = new JButton(hasStrings ? " Iniciar nueva partida  " : null, Utilidades.getIcon("1Corazones"));
		button2.addActionListener(new ManejadorEventos());
		button2.setToolTipText("Iniciar nueva partida");
		button2.setVerticalTextPosition( SwingConstants.BOTTOM );
		button2.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button2);
		
		this.addSeparator();
		button3 = new JButton(hasStrings ? " Iniciar turno de un jugador " : null, Utilidades.getIcon("1Corazones"));
		button3.addActionListener(new ManejadorEventos());
		button3.setToolTipText("Iniciar turno de un jugador");
		button3.setVerticalTextPosition( SwingConstants.BOTTOM );
		button3.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button3);
		
		this.addSeparator();
		
		
		button4 = new JButton(hasStrings ? "      Salir      " : null, Utilidades.getIcon("1Corazones"));
		button4.addActionListener(new ManejadorEventos());
		button4.setToolTipText("Gestión de Colegios");
		button4.setVerticalTextPosition( SwingConstants.BOTTOM );
		button4.setHorizontalTextPosition( SwingConstants.CENTER );
		this.add(button4);
		
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
					ventana.dispose();					 
				}
			
		};
	};
	
}
