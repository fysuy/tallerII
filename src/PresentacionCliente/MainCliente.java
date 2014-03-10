package PresentacionCliente;

import java.rmi.RemoteException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class MainCliente {

	public static void main(String[] args) {

		//SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenGraphiteGlassSkin");
		try{
			//System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		    UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "No se actualizo el look and feel");
		}
		
		FrmPrincipal frame;
		try {
			frame = new FrmPrincipal();
			frame.setVisible(true);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
