package PresentacionCliente.Vistas;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import Logica.DataPartida;
import Logica.DataRealizarJugada;
import PresentacionCliente.FacadeDispatcher;
import PresentacionCliente.Controladores.ControladorRealizarJugada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

@SuppressWarnings("serial")
public class FrmRealizarJugada extends JPanel {
	
	private JPanel contentPane;	
	private JButton btnMostrar;
	private JButton pedirCarta;
	private ControladorRealizarJugada controladorRealizarJugada;
	private static boolean quiereCarta = false;
	private FacadeDispatcher facadeDispatcher = new FacadeDispatcher();
		
	public FrmRealizarJugada() {
		
		try {
			controladorRealizarJugada = new ControladorRealizarJugada(facadeDispatcher.getFacade());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		setBounds(100, 500, 853, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "eeee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setBorder(BorderFactory.createTitledBorder(""));
		contentPane.setLayout(null);
		setLayout(null);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DataPartida actual = PartidaActual();
				DataRealizarJugada dataRealizarJugada = new DataRealizarJugada(quiereCarta, actual);
				try {
					controladorRealizarJugada.RealizarJugada(dataRealizarJugada);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnMostrar.setBounds(41, 87, 160, 23);
		contentPane.add(btnMostrar);
		
		
		pedirCarta = new JButton("Pedir carta");
		pedirCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quiereCarta = true;
			}
		});
		pedirCarta.setBounds(41, 42, 160, 23);
		contentPane.add(pedirCarta);

	}
	
	public DataPartida PartidaActual() {
		DataPartida data = null;
		try {
			data = controladorRealizarJugada.Partida();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public void QuiereCarta(DataRealizarJugada data){
		controladorRealizarJugada.QuiereCarta(data); //TODO: para que esta esto?????
	}

	public JPanel getPanel(){			
		return contentPane;
	}
}
