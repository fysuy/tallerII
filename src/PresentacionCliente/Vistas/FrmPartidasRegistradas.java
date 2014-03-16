package PresentacionCliente.Vistas;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Logica.DataPartida;
import PresentacionCliente.FacadeDispatcher;
import PresentacionCliente.TablasColor;
import PresentacionCliente.Controladores.ControladorPartidasRegistradas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrmPartidasRegistradas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JScrollPane scrollPane;
	private JTable tablaPartidasRegistradas;
	private JButton btnMostrar;
	private JButton btnCancelar;
	private DefaultTableModel modeloPartidasRegistradas;
	private ControladorPartidasRegistradas controladorPartidasRegistradas;
	private JLabel lblPartidasRegistradas;
	private FacadeDispatcher facadeDispatcher = new FacadeDispatcher();
		
	public FrmPartidasRegistradas() {
		try {
			controladorPartidasRegistradas = new ControladorPartidasRegistradas(facadeDispatcher.getFacade());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}			
		setBounds(100, 500, 853, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "eeee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setBorder(BorderFactory.createTitledBorder(""));
		contentPane.setLayout(null);
		setLayout(null);		
		
		tablaPartidasRegistradas = new JTable();
		String []columnas = {"Código", "Jugador en turno", "Eventual ganador", "Iniciada", "Finalizada"};
		String [][]matrizDatos = {};
		modeloPartidasRegistradas = new DefaultTableModel(matrizDatos, columnas);
		tablaPartidasRegistradas.setModel(modeloPartidasRegistradas);
		
		TablasColor tablasColor = new TablasColor();
		tablaPartidasRegistradas.setDefaultRenderer(Object.class, tablasColor);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)tablaPartidasRegistradas.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);	
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 62, 632, 456);
		contentPane.add(scrollPane);
		scrollPane.add(tablaPartidasRegistradas);
		scrollPane.setViewportView(tablaPartidasRegistradas);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarInforme();
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
		
		lblPartidasRegistradas = new JLabel("Partidas registradas");
		lblPartidasRegistradas.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblPartidasRegistradas.setBounds(307, 11, 327, 40);
		contentPane.add(lblPartidasRegistradas);

	}
	
	public void MostrarInforme()
	{
		List<DataPartida> partidas = new ArrayList<DataPartida>();
		
		DataPartida arregloPartidas[];
		try {
			partidas = Arrays.asList(controladorPartidasRegistradas.ListarPartidasRegistradas());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		String enCurso, finalizada;
		DataPartida data;
		for (int i=0; i<partidas.size(); i++){
				data = partidas.get(i);
			if(data.isEnCurso())
				enCurso = "SI";
			else
				enCurso = "NO";
			if(data.isFinalizada())
				finalizada = "SI";
			else
				finalizada = "NO";
			
			Object[] nuevaFila = {data.getCodigo(), data.getProximoJugador().getNombre(), data.getEventualGanador().getNombre().toString(), enCurso, finalizada};
			modeloPartidasRegistradas.addRow(nuevaFila);
		}
		
	
	}
	public JPanel getPanel(){			
		
		return contentPane;
	}
}
