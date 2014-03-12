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

import Excepciones.PartidaNoHayEnCursoException;
import Logica.DataCarta;
import Logica.DataJugador;
import Logica.DataListarJugadoresPartidas;
import Logica.DataVisualizarCartas;
import PresentacionCliente.FacadeDispatcher;
import PresentacionCliente.TablasColor;
import PresentacionCliente.Controladores.ControladorVisualizarCartas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class FrmListarTodoCartasDeUnJugadores extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JScrollPane scrollPane;
	private JTable tablaPartidasRegistradas;
	private JButton btnMostrar;
	private JButton btnCancelar;
	private DefaultTableModel modelo;
	private ControladorVisualizarCartas controladorVisualizarCartas;
	private JTextField txtCodigoJugador;
	private FacadeDispatcher facadeDispatcher = new FacadeDispatcher();
	
	public FrmListarTodoCartasDeUnJugadores() {
		
		setBounds(100, 500, 853, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "eeee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setBorder(BorderFactory.createTitledBorder(""));
		contentPane.setLayout(null);
		setLayout(null);		
		
		
		tablaPartidasRegistradas = new JTable();
		String []columnas = {"Palo", "Calor", "Valor en juego"};
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
				int codigoJugador = Integer.parseInt(txtCodigoJugador.getText());
				try {
					ListarCartas(codigoJugador);
				} catch (PartidaNoHayEnCursoException e1) {
					e1.printStackTrace();
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
		
		JLabel lblCdigoJugador = new JLabel("C\u00F3digo jugador");
		lblCdigoJugador.setBounds(761, 64, 108, 23);
		contentPane.add(lblCdigoJugador);
		
		txtCodigoJugador = new JTextField();
		txtCodigoJugador.setBounds(757, 98, 101, 20);
		contentPane.add(txtCodigoJugador);
		txtCodigoJugador.setColumns(10);

	}
	
	public void ListarCartas(int codigoJugador) throws PartidaNoHayEnCursoException{
		controladorVisualizarCartas = new ControladorVisualizarCartas(facadeDispatcher.getFacade());
		DataCarta arregloDataCarta[] = {};
		arregloDataCarta = controladorVisualizarCartas.VisualizarCartas(codigoJugador);
		
		for(int i=0; i<arregloDataCarta.length; i++){
						
			Object[] nuevaFila = {arregloDataCarta[i].getPalo(), arregloDataCarta[i].getValor(), Integer.toString(arregloDataCarta[i].getValorEnJuego())};
			modelo.addRow(nuevaFila);
		}
	}
	
	public JPanel getPanel(){			
		return contentPane;
	}
}
