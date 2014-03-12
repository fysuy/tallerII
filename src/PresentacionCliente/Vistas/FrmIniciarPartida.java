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

import PresentacionCliente.FacadeDispatcher;
import PresentacionCliente.TablasColor;
import PresentacionCliente.Utilidades;
import PresentacionCliente.Controladores.ControladorIniciarPartida;
import PresentacionCliente.Controladores.ControladorListarPartida;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmIniciarPartida extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JScrollPane scrollPane;
	private JTable tablaIniciarPartida;
	private JButton btnIniciar;
	private JButton btnCancelar;
	private JButton button;
	private DefaultTableModel modeloIniciarPartida;
	private ControladorListarPartida controladorListarPartida;
	private ControladorIniciarPartida controladorIniciarPartida;
	private FacadeDispatcher facadeDispatcher = new FacadeDispatcher();
	
	public FrmIniciarPartida() {
		
		setBounds(100, 500, 853, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "eeee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setBorder(BorderFactory.createTitledBorder(""));
		contentPane.setLayout(null);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(129, 103, 290, 229);
		contentPane.add(scrollPane);
		
		tablaIniciarPartida = new JTable();
		tablaIniciarPartida.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				if (tablaIniciarPartida.getSelectedRows().length > 0)
				{
					button.setVisible(false);
					contentPane.updateUI();
				}					
				else
				{
					button.setVisible(true);
					contentPane.updateUI();
				}
			}
		});
	
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//IniciarNuevaPartida();
				int row_selected = tablaIniciarPartida.getSelectedRow();
				
				
				if (row_selected >= 0)
				{				
					String codigoPartida = (String) tablaIniciarPartida.getValueAt(row_selected, 0);
					if(PartidaYaIniciada(codigoPartida))
						JOptionPane.showMessageDialog (null, "La partida ya se encuentra iniciada", "Error", JOptionPane.ERROR_MESSAGE);
					else if(HayPartidaIniciada())
						JOptionPane.showMessageDialog (null, "Ya hay una partida iniciada", "Error", JOptionPane.ERROR_MESSAGE);
					else{
					controladorIniciarPartida = new ControladorIniciarPartida(facadeDispatcher.getFacade());
					controladorIniciarPartida.IniciarNuevaPartida(codigoPartida);
					contentPane.removeAll();
					contentPane.updateUI();
					}
				}
				else
				{
					//JOptionPane.showMessageDialog(null, "Debe seleccionar una partida", "ERROR!", JOptionPane.ERROR_MESSAGE);
					button.setVisible(true);
					contentPane.updateUI();
				}
					
			}


		});
		btnIniciar.setBounds(429, 157, 89, 23);
		contentPane.add(btnIniciar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.updateUI();
			}
		});
		btnCancelar.setBounds(429, 309, 89, 23);
		contentPane.add(btnCancelar);
		
		button = new JButton("", Utilidades.getIcon("error"));
		button.setBounds(429, 123, 33, 23);
		button.setOpaque(false);
		button.setVisible(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		contentPane.add(button);
		
		

	}
	
	private void IniciarNuevaPartida() {

		int row_selected = tablaIniciarPartida.getSelectedRow();
		//String d = tablaIniciarPartida.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String codigoPartida = (String) tablaIniciarPartida.getValueAt(row_selected, 0);
		System.out.println("codigoPartida: " + codigoPartida);
		controladorIniciarPartida = new ControladorIniciarPartida(facadeDispatcher.getFacade());
		if (row_selected >= 0)
		{
			System.out.println("row_selected_1");
			controladorIniciarPartida.IniciarNuevaPartida(codigoPartida);
			System.out.println("row_selected_2");
		}
	}
	
	
	public boolean PartidaYaIniciada(String codigo){
		controladorIniciarPartida = new ControladorIniciarPartida(facadeDispatcher.getFacade());
		return controladorIniciarPartida.PartidaYaIniciada(codigo);
	}
	
	public boolean HayPartidaIniciada(){
		controladorIniciarPartida = new ControladorIniciarPartida(facadeDispatcher.getFacade());
		return controladorIniciarPartida.HayPartidaIniciada();
	}	
	
	public JPanel getPanel(){		
		
		controladorListarPartida = new ControladorListarPartida(facadeDispatcher.getFacade());		
		String arregloCodigosPartidas[] = controladorListarPartida.ListarPartidas();
		
		String []columnas = {"CÓDIGO"};
		String [][]matrizDatos = {};
		modeloIniciarPartida = new DefaultTableModel(matrizDatos, columnas);
		
		for (int i=0;i<arregloCodigosPartidas.length;i++){
			
	        Object nuevaFila[]= {arregloCodigosPartidas[i]};
	        modeloIniciarPartida.addRow(nuevaFila);
		    }
		
		tablaIniciarPartida.setModel(modeloIniciarPartida);
		scrollPane.setViewportView(tablaIniciarPartida);
		
		TablasColor tablasColor = new TablasColor();
		tablaIniciarPartida.setDefaultRenderer(Object.class, tablasColor);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)tablaIniciarPartida.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);		
		
		return contentPane;
	}
}
