package PresentacionCliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;

import Logica.Facade;
import Logica.IFacadeLogica;

import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmNuevaPartida extends JPanel {

	private JScrollPane scrollPane;
	private JPanel contentPane;	
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JTextField textField;
	private JTable tablaNuevaPartida;
			
	private DefaultTableModel modeloNombres;
	private JPanel panel_1;
	private JButton btnCrear;
	private JButton btnCancelar;
	private FrmPrincipalCrupier ventana;
	
	private ControladorNuevaPartida controladorNuevaPartida;
	private JButton buttonError1;
	private JButton buttonError2;
	
	
	public FrmNuevaPartida() {

		setBounds(100, 500, 853, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "eeee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setBorder(BorderFactory.createTitledBorder(""));
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(textField.getText().trim().isEmpty())
				{
					buttonError1.setVisible(true);
					contentPane.updateUI();
				}					
				else
				{
					buttonError1.setVisible(false);
					contentPane.updateUI();
				}
					
			}
		});
		textField.setBounds(288, 113, 243, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(192, 116, 71, 14);
		contentPane.add(lblCdigo);
		
		tablaNuevaPartida = new JTable();
		//tablaNuevaPartida.setBounds(131, 123, 1, 1);
		String []columnas = {"NOMBRE"};
		String [][]matrizDatos = {};		
		modeloNombres = new DefaultTableModel(matrizDatos, columnas);
		tablaNuevaPartida.setModel(modeloNombres);
		
    	TablasColor tablasColor = new TablasColor();
		tablaNuevaPartida.setDefaultRenderer(Object.class, tablasColor);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)tablaNuevaPartida.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 182, 253, 132);
		contentPane.add(scrollPane);
		scrollPane.add(tablaNuevaPartida);
		scrollPane.setViewportView(tablaNuevaPartida);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Partida", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(166, 90, 387, 60);
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Jugadores", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_1.setBounds(166, 161, 387, 169);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(24, 44, 89, 23);
		panel_1.add(btnInsertar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(24, 113, 89, 23);
		panel_1.add(btnEliminar);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().isEmpty() && tablaNuevaPartida.getRowCount() < 2)
				{
					buttonError1.setVisible(true);
					buttonError2.setVisible(true);
					contentPane.updateUI();
				}
				else if(textField.getText().trim().isEmpty())
				{
					buttonError1.setVisible(true);
					contentPane.updateUI();
				}					
				else if(tablaNuevaPartida.getRowCount() < 2)
				{
					buttonError2.setVisible(true);
					contentPane.updateUI();
				}
				else
				{
					buttonError1.setVisible(false);	
					buttonError2.setVisible(false);
					NuevaPartida(tablaNuevaPartida);
					contentPane.removeAll();
					contentPane.updateUI();						
				}
			}
			
		});
		btnCrear.setBounds(244, 341, 89, 23);
		contentPane.add(btnCrear);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.updateUI();
			}
		});
		btnCancelar.setBounds(412, 341, 89, 23);
		contentPane.add(btnCancelar);
		
		buttonError1 = new JButton("", Utilidades.getIcon("error"));
		buttonError1.setBounds(550, 113, 29, 24);
		buttonError1.setVisible(false);
		contentPane.add(buttonError1);
		buttonError1.setContentAreaFilled(false);
		buttonError1.setFocusPainted(false);
		buttonError1.setBorderPainted(false);
		buttonError1.setHorizontalAlignment(SwingConstants.LEFT);
		
		buttonError2 = new JButton("", Utilidades.getIcon("error"));
		buttonError2.setBounds(550, 235, 29, 24);
		buttonError2.setVisible(false);
		contentPane.add(buttonError2);
		buttonError2.setFocusPainted(false);
		buttonError2.setBorderPainted(false);
		buttonError2.setHorizontalAlignment(SwingConstants.LEFT);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel miTableModel = (DefaultTableModel) tablaNuevaPartida.getModel();
		        int indFil = tablaNuevaPartida.getSelectedRow();
		        if (indFil >= 0)
		            miTableModel.removeRow(indFil);
			}
		});
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel miTableModel = (DefaultTableModel) tablaNuevaPartida.getModel();
		        Object nuevaFila[]= {""};
		        miTableModel.addRow(nuevaFila);
			}
		});
		
	
	}
	
	public void NuevaPartida (JTable table) {
		
        //DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    
		String codigoPartida = textField.getText();
		
		int nRow = modeloNombres.getRowCount();
	    String[] arrayNombres = new String[nRow];
	    for (int i = 0 ; i < nRow ; i++)
	    	arrayNombres[i] = (String)modeloNombres.getValueAt(i, 0);
	    
	    controladorNuevaPartida = new ControladorNuevaPartida();
	    controladorNuevaPartida.NuevaPartida(codigoPartida, arrayNombres);
	    
	   /* 
	    System.out.println("Listo nuevamente las partidas");
		System.out.println("=============================");
				
		try 
		{
			IFacadeLogica fac = Facade.getInstance();
			String arregloCodigosPartidas[] = fac.listarCodigosPartidas();
						
			for( int i=0; i<arregloCodigosPartidas.length ; i ++ )
			{
				System.out.println("Codigo partida: " + arregloCodigosPartidas[i]);
				System.out.println("nombre jugador: " + arregloCodigosPartidas[i].ge);
			}
		} 
		catch (Exception e) { e.printStackTrace(); }
		*/
	}
	
	public JPanel getPanel(){		
		return contentPane;
	}
}
