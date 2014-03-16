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

import Logica.DataListarJugadoresPartidas;
import PresentacionCliente.FacadeDispatcher;
import PresentacionCliente.TablasColor;
import PresentacionCliente.Controladores.ControladorListarJugadores;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class FrmJugadoresPartidas extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JScrollPane scrollPane;
	private JTable tablaPartidasRegistradas;
	private JButton btnMostrar;
	private JButton btnCancelar;
	private DefaultTableModel modeloPartidasRegistradas;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private ControladorListarJugadores listarJugadores;
	private FacadeDispatcher facadeDispatcher = new FacadeDispatcher();
		
	public FrmJugadoresPartidas() {
		
		try {
			listarJugadores = new ControladorListarJugadores(facadeDispatcher.getFacade());
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
		String []columnas = {"Número de jugador", "Nombre", "Puntaje"};
		String [][]matrizDatos = {};
		modeloPartidasRegistradas = new DefaultTableModel(matrizDatos, columnas);
		tablaPartidasRegistradas.setModel(modeloPartidasRegistradas);
		
		TablasColor tablasColor = new TablasColor();
		tablaPartidasRegistradas.setDefaultRenderer(Object.class, tablasColor);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)tablaPartidasRegistradas.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);	
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 144, 632, 456);
		contentPane.add(scrollPane);
		scrollPane.add(tablaPartidasRegistradas);
		scrollPane.setViewportView(tablaPartidasRegistradas);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MostrarInforme();
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
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Codigo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(115, 11, 309, 54);
		panel.setLayout(null);
		contentPane.add(panel);
		
		
		lblNewLabel_1 = new JLabel("C\u00F3digos");
		lblNewLabel_1.setBounds(10, 14, 58, 29);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(78, 18, 221, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ver jugadores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigo = textField.getText();
				DataListarJugadoresPartidas[] data = ListarPartidas(codigo);
				for(int i=0; i<data.length; i++){
			        Object nuevaFila[]= {data[i]};
			        System.out.println(""+data[i].getNombre());
			        modeloPartidasRegistradas.addRow(nuevaFila);
				}
			}
		});
		btnNewButton.setBounds(178, 76, 174, 23);
		contentPane.add(btnNewButton);

	}
	
	public DataListarJugadoresPartidas[] ListarPartidas(String codigo) {
		DataListarJugadoresPartidas[] listaPartidas = null;
		
		try { listaPartidas = listarJugadores.ListarJugadores(); } 
		catch (RemoteException e) { e.printStackTrace(); }	
		
		return listaPartidas;
	}
	

	public JPanel getPanel(){			
		
		return contentPane;
	}
}
