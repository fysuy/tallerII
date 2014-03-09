package PresentacionCliente;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Logica.Facade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class FrmIniciarTurnoDeUnJugador extends JPanel {
	
	private JPanel contentPane;	
	private JButton btnIniciar;
	private JButton btnCancelar;
	private JButton button;
	private ControladorIniciarTurnoJugador controladorIniciarTurnoJugador;
	
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
				controladorIniciarTurnoJugador.IniciarTurnoJugador();
					
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
		
		button = new JButton("", Utilidades.getIcon("Pregunta"));
		button.setBounds(198, 46, 281, 222);
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
