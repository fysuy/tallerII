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
import Logica.DataJugador;
import PresentacionCliente.FacadeDispatcher;
import PresentacionCliente.TablasColor;
import PresentacionCliente.Controladores.ControladorListarTodoJugadores;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class FrmListarTodoJugadores extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private JScrollPane scrollPane;
	private JTable tablaPartidasRegistradas;
	private JButton btnMostrar;
	private JButton btnCancelar;
	private DefaultTableModel modelo;
	private ControladorListarTodoJugadores controladorListarTodoJugadores;
	private FacadeDispatcher facadeDispatcher = new FacadeDispatcher();
		
	public FrmListarTodoJugadores() {
		try {
			controladorListarTodoJugadores = new ControladorListarTodoJugadores(facadeDispatcher.getFacade());
		} catch (RemoteException e2) { e2.printStackTrace(); }
		
		setBounds(100, 500, 853, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "eeee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setBorder(BorderFactory.createTitledBorder(""));
		contentPane.setLayout(null);
		setLayout(null);		
		
		
		tablaPartidasRegistradas = new JTable();
		String []columnas = {"Número de jugador", "Nombre", "Puntaje", "En turno", "Eliminado"};
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
					try {
						ListarJugadores();
					} catch (PartidaNoHayEnCursoException e1) {
						JOptionPane.showMessageDialog(null, "--> " + e1.toString(), "ERROR!", JOptionPane.ERROR_MESSAGE);
						//e1.printStackTrace();
					}
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
	
	public void ListarJugadores() throws PartidaNoHayEnCursoException{
		
		try {
			DataJugador data[] = {};
			data = controladorListarTodoJugadores.ListarTodoJugadores();
			String enTurno = "No";
			String eliminado = "No";
			
			LimpiarTabla();

			for(int i=0; i<data.length; i++){
				
				if(data[i].isEliminado())
					eliminado = "Si";
				
				if(data[i].isEnturno())
					enTurno = "Si";
					
				Object[] nuevaFila = {Integer.toString(data[i].getNumero()), data[i].getNombre(), Integer.toString(data[i].getPuntos()), enTurno, eliminado};
				modelo.addRow(nuevaFila);
			}
		} catch (RemoteException e) { e.printStackTrace(); }
	}
	
	void LimpiarTabla(){
        int a = modelo.getRowCount()-1;  
        for(int i=a;i>=0;i--){  
        	modelo.removeRow(i);
        }
    }
	
	public boolean HayPartidaIniciada() {
		boolean result = false;
		
		try {
			result = controladorListarTodoJugadores.HayPartidaIniciada();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

	public JPanel getPanel(){			
		return contentPane;
	}
}
