package PresentacionCliente;

import java.awt.FlowLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXStatusBar;

@SuppressWarnings("serial")
public class StatusBar extends JXStatusBar{
	
	public StatusBar() throws RemoteException {
		
		InetAddress address;
		String sIPAddress = "";
		String sHostName = "";
		try 
		{
			address = InetAddress.getLocalHost();
			sHostName = address.getHostName();
			byte[] bIPAddress = address.getAddress();
			for (int x=0; x<bIPAddress.length; x++) {  if (x > 0) 
			{    
				sIPAddress += ".";  }  
		    	sIPAddress += bIPAddress[x] & 255;
			}
		} 
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

		JXStatusBar.Constraint c1 = new JXStatusBar.Constraint(
				JXStatusBar.Constraint.ResizeBehavior.FILL);
		JLabel tabLabel = new JLabel("Made in Uruguay.       "+ " Host: "+sHostName+"            IP: "+sIPAddress);
		this.add(tabLabel, c1);
		
		JPanel alphaPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
		JLabel tabLabe2 = new JLabel("Usuario:");
		
		tabLabe2.setText("Usuario: pablo");
		
		alphaPanel.add(tabLabe2);
		JXStatusBar.Constraint c2 = new JXStatusBar.Constraint(
				JXStatusBar.Constraint.ResizeBehavior.FILL);
		c2.setFixedWidth(50);
		this.add(alphaPanel, c2);
		
		JPanel alphaPanel1 = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
		JLabel tabLabe3 = new JLabel("Perfil: Administrador");
		alphaPanel1.add(tabLabe3);
		JXStatusBar.Constraint c3 = new JXStatusBar.Constraint(
				JXStatusBar.Constraint.ResizeBehavior.FILL);
		c3.setFixedWidth(40);
		this.add(alphaPanel1, c3);
		
		Calendar c = new GregorianCalendar(); 
		   
		String dia, mes, annio;
		   
		dia = Integer.toString(c.get(Calendar.DATE));
		mes = Integer.toString(c.get(Calendar.MONTH));
		annio = Integer.toString(c.get(Calendar.YEAR));
		
		JPanel alphaPanel2 = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
		JLabel tabLabe4 = new JLabel("Fecha: " + dia + "/" + mes +"/" + annio);
		
		alphaPanel2.add(tabLabe4);
		JXStatusBar.Constraint c4 = new JXStatusBar.Constraint(
				JXStatusBar.Constraint.ResizeBehavior.FILL);
		c4.setFixedWidth(5);
		this.add(alphaPanel2, c4);
	}
}
