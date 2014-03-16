package PresentacionCliente.Vistas;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.rmi.RemoteException;

import javax.swing.UIManager;

import Excepciones.PartidaNoHayEnCursoException;
import PresentacionCliente.FacadeDispatcher;
import PresentacionCliente.Utilidades;
import PresentacionCliente.Controladores.ControladorIniciarTurnoJugador;

public class FrmIniciarTurnoDeUnJugador extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JButton btnIniciar;
	private JButton btnCancelar;
	private JButton button;
	private ControladorIniciarTurnoJugador controladorIniciarTurnoJugador;
	private FacadeDispatcher facadeDispatcher = new FacadeDispatcher();
	
	public FrmIniciarTurnoDeUnJugador() {
		
		setBounds(100, 500, 853, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "eeee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setBorder(BorderFactory.createTitledBorder(""));
		contentPane.setLayout(null);
		contentPane.setOpaque(false);
		setLayout(null);
		
	
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controladorIniciarTurnoJugador = new ControladorIniciarTurnoJugador(facadeDispatcher.getFacade());
					controladorIniciarTurnoJugador.IniciarTurnoJugador();
				} catch (PartidaNoHayEnCursoException e1) {
					JOptionPane.showMessageDialog(null, "--> " + e1.toString(), "ERROR!", JOptionPane.ERROR_MESSAGE);
				} catch (RemoteException e2) {
					e2.printStackTrace();
				}
				
				contentPane.removeAll();
				contentPane.updateUI();	
					
			}


		});
		btnIniciar.setBounds(198, 330, 89, 23);
		contentPane.add(btnIniciar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.updateUI();
			}
		});
		btnCancelar.setBounds(390, 330, 89, 23);
		contentPane.add(btnCancelar);
		
		button = new JButton("", Utilidades.getIcon("Pregunta1"));
		button.setBackground(UIManager.getColor("Panel.background"));
		button.setBounds(258, 139, 138, 129);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		contentPane.add(button);

		
		JLabel lblDeceaIniciarEl = new JLabel("Decea iniciar el turno del pr\u00F3ximo jugador ?");
		lblDeceaIniciarEl.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDeceaIniciarEl.setBounds(184, 279, 325, 39);
		contentPane.add(lblDeceaIniciarEl);
		
		

	}
	
	public JPanel getPanel(){		
		return contentPane;
	}
}
