package PresentacionCliente;

import java.rmi.RemoteException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Fisica.Client;
import PresentacionCliente.Vistas.FrmPrincipal;


public class MainCliente {

	public static void main(String[] args) {

		try
		{
		    UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "No se actualizo el look and feel");
		}
		
		FrmPrincipal frame;
		Client cliente = new Client();
		try {
			frame = new FrmPrincipal(cliente.getFacade());
			frame.setVisible(true);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
