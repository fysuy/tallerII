package PresentacionCliente;

import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;


public class Utilidades {

	public static JPanel cabecera(String texto, String icono){
		JPanel jPanel = new JPanel();
		
		FormLayout layout = new FormLayout(
				"right:pref, default:grow, 3dlu",	// Columnas 
				"pref");							// Filas 
		
		PanelBuilder builder = new PanelBuilder(layout);
		CellConstraints cc = new CellConstraints();

		JButton cabecera = new JButton(texto, getIcon(icono));	
		cabecera.setContentAreaFilled(false);
		cabecera.setFocusPainted(false);
		cabecera.setBorderPainted(false);
		cabecera.setHorizontalAlignment(SwingConstants.LEFT);
		cabecera.setIconTextGap(5);
		cabecera.setFont(new Font("Comic Sans MS",3,12));
		 
		builder.add(cabecera, cc.xy  (1, 1));
		builder.addSeparator("", cc.xywh(2, 1, 1, 1));
		jPanel = builder.getPanel();
		
		return jPanel;
	}
	
	public static Icon getIcon(String iconName) {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		URL url = cl.getResource("Iconos/" + iconName + ".png");
		if (url != null)
			return new ImageIcon(url);
		url = cl.getResource("Iconos/" + iconName + ".gif");
		if (url != null)
			return new ImageIcon(url);
		url = cl.getResource("Iconos/" + iconName + ".jpg");
		if (url != null)
			return new ImageIcon(url);
		return null;
	}
	
	public static JButton taskBbutton(String label, String icono){
		JButton jButton = new JButton(label, Utilidades.getIcon(icono));	
		jButton.setContentAreaFilled(false);
		jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jButton.setFocusPainted(false);
		jButton.setBorderPainted(false);
		jButton.setHorizontalAlignment(SwingConstants.LEFT);
		jButton.setIconTextGap(5);
		//jButton.addMouseListener(new JUnderlinedText(jButton));
		
		return jButton;
	};
	
	 public static ImageIcon createImage(String path) {
		 ClassLoader cl = Thread.currentThread().getContextClassLoader();
		 URL imgURL = cl.getResource("Iconos/" + path + ".png");
			if (imgURL != null)
				return new ImageIcon(imgURL);
			imgURL = cl.getResource("Iconos/" + path + ".gif");
			if (imgURL != null)
				return new ImageIcon(imgURL);
		    imgURL = cl.getResource("Iconos/" + path + ".jpg");
		    if (imgURL != null) { 
		         return new ImageIcon(imgURL);
	       } else {
	    	     System.err.println("Couldn't find file: " + path);
	    	     return null;
	       }
	 }
}
