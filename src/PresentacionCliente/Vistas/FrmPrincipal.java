package PresentacionCliente.Vistas;

import java.awt.BorderLayout;
import java.rmi.RemoteException;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXPanel;

import Logica.IFacadeLogica;
import PresentacionCliente.BarraHerramientas;
import PresentacionCliente.PanelCentral;
import PresentacionCliente.StatusBar;

import java.awt.Toolkit;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame {

	private JPanel mainPanel; 
	private PanelCentral panelCentral;
	private final BarraHerramientas barraHerramientas;
	private final JXPanel jxPanel;

	public FrmPrincipal(IFacadeLogica facade) throws RemoteException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setResizable(false);		

		barraHerramientas = new BarraHerramientas("", 22, true, this);
		jxPanel = new JXPanel(new BorderLayout());
		StatusBar statusBar = new StatusBar();
		panelCentral = new PanelCentral();
		
		mainPanel = new JPanel();
		mainPanel.add(panelCentral);
		mainPanel.setLayout(new LayoutManager() {
			public void addLayoutComponent(String name, Component comp) {
			}

			public Dimension minimumLayoutSize(Container parent) {
				Dimension min2 = panelCentral.getMinimumSize();
				return new Dimension(min2.width, min2.height);
			}

			public void layoutContainer(Container parent) {
				int width = parent.getWidth();
				int height = parent.getHeight();
				panelCentral.setBounds(250, 0, width-250, height);
			}

			public Dimension preferredLayoutSize(Container parent) {
				Dimension pref2 = panelCentral.getPreferredSize();
				return new Dimension(pref2.width, pref2.height);
			}

			public void removeLayoutComponent(Component comp) {
			}
		});
		
		jxPanel.add(barraHerramientas, BorderLayout.NORTH);
		jxPanel.add(mainPanel, BorderLayout.CENTER);
		jxPanel.add(statusBar, BorderLayout.SOUTH);
		getContentPane().add(jxPanel, BorderLayout.CENTER);
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/Iconos/FondoAzul.png")));
		this.setSize(950, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public PanelCentral getPan(){
		return panelCentral;
	}

}
