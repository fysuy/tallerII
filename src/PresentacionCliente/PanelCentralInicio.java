package PresentacionCliente;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.jdesktop.layout.*;
import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

@SuppressWarnings("serial")
public class PanelCentralInicio extends JPanel{

	
	public PanelCentralInicio() {
		
		this.setLayout(new BorderLayout());
		
		FormLayout layout = new FormLayout(
				"right:10dlu, pref, 20dlu, center:pref, pref:grow, left:4dlu",		// Columnas
				"4dlu, pref:grow, bottom:240dlu, top:240dlu, pref:grow, 4dlu");		// Filas
		
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();
		
		JButton cabecera = new JButton("xxxx", Utilidades.getIcon("Portada"));	
		cabecera.setContentAreaFilled(false);
		cabecera.setFocusPainted(false);
		cabecera.setBorderPainted(false);
		cabecera.setHorizontalAlignment(SwingConstants.LEFT);
		cabecera.setIconTextGap(5);
		
		builder.add(Utilidades.cabecera("BlackJack", "FondoAzul"), cc.xywh(2, 3, 4, 4));
		
		JLabel jLabel2 = new JLabel("BlackJack ©");
		jLabel2.setBounds(20, 20, 20, 46);
		jLabel2.setFont(new java.awt.Font("Calibri",3,20));
		builder.add(jLabel2, cc.xy(2, 2));
		
		this.add(builder.getPanel(), BorderLayout.CENTER);
	}
}
