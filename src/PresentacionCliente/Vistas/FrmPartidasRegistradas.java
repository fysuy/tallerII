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
		controladorPartidasRegistradas = new ControladorPartidasRegistradas(facadeDispatcher.getFacade());		
		DataPartida arregloPartidas[] = controladorPartidasRegistradas.ListarPartidasRegistradas();
		
		String enCurso, finalizada;
		for (int i=0;i<arregloPartidas.length;i++){
				
			if(arregloPartidas[i].isEnCurso())
				enCurso = "SI";
			else
				enCurso = "NO";
			if(arregloPartidas[i].isFinalizada())
				finalizada = "SI";
			else
				finalizada = "NO";
			
			Object[] nuevaFila = {arregloPartidas[i].getCodigo(), arregloPartidas[i].getProximoJugador().getNombre(), arregloPartidas[i].getEventualGanador().getNombre().toString(), enCurso, finalizada};
			modeloPartidasRegistradas.addRow(nuevaFila);
		}
		
	
	}
	public JPanel getPanel(){			
		
		return contentPane;
	}
}
