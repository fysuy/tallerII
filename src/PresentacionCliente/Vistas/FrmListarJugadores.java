package PresentacionCliente.Vistas;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Logica.DataListarJugadoresPartidas;
import PresentacionCliente.FacadeDispatcher;
import PresentacionCliente.TablasColor;
import PresentacionCliente.Controladores.ControladorListarJugadores;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class FrmListarJugadores extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JScrollPane scrollPane;
	private JTable tablaPartidasRegistradas;
	private JButton btnMostrar;
	private JButton btnCancelar;
	private DefaultTableModel modelo;
	private ControladorListarJugadores listarJugadores;
	private FacadeDispatcher facadeDispatcher = new FacadeDispatcher();
		
	public FrmListarJugadores() {
		
		try {  listarJugadores = new ControladorListarJugadores(facadeDispatcher.getFacade()); }
		catch (RemoteException e1) { e1.printStackTrace(); }
		
		setBounds(100, 500, 853, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "eeee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setBorder(BorderFactory.createTitledBorder(""));
		contentPane.setLayout(null);
		setLayout(null);		
		
		
		tablaPartidasRegistradas = new JTable();
		String []columnas = {"Número de jugador", "Nombre", "Puntaje"};
		String [][]matrizDatos = {};
		modelo = new DefaultTableModel(matrizDatos, columnas);
		tablaPartidasRegistradas.setModel(modelo);
		
		TablasColor tablasColor = new TablasColor();
		tablaPartidasRegistradas.setDefaultRenderer(Object.class, tablasColor);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)tablaPartidasRegistradas.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);	
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 30, 632, 456);
		contentPane.add(scrollPane);
		scrollPane.add(tablaPartidasRegistradas);
		scrollPane.setViewportView(tablaPartidasRegistradas);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(HayPartidaIniciada())
					ListarPartidas();
				else{
					JOptionPane.showMessageDialog (null, "No hay ninguna partida iniciada", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnMostrar.setBounds(757, 157, 89, 23);
		contentPane.add(btnMostrar);
		
		btnCancelar = new JButton("Salir");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.updateUI();
			}
		});
		btnCancelar.setBounds(757, 252, 89, 23);
		contentPane.add(btnCancelar);

	}
	
	public void ListarPartidas(){
		
		try 
		{
			DataListarJugadoresPartidas data[] = listarJugadores.ListarJugadores();
			for(int i=data.length-1; i>=0; i=i-1)
			{
				Object[] nuevaFila = {Integer.toString(data[i].getNumero()), data[i].getNombre(), Integer.toString(data[i].getPuntos())};
				modelo.addRow(nuevaFila);
			}
		} 
		catch (RemoteException e) { e.printStackTrace(); }
	}
	
	public boolean HayPartidaIniciada() {
		boolean result = false;
		
		try { result = listarJugadores.HayPartidaIniciada(); }
		catch (RemoteException e) { e.printStackTrace(); }
		
		return result;
	}
	
	public JPanel getPanel(){			
		return contentPane;
	}
}
