package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import Excepciones.ElJugadorNoTieneCartasException;
import Logica.DataCarta;
import Logica.IFacadeLogica;

@SuppressWarnings("serial")
public class ControladorVisualizarCartas extends UnicastRemoteObject implements IControladorVisualizarCartas {

	private IFacadeLogica fac;
		
	public ControladorVisualizarCartas(IFacadeLogica f) throws RemoteException {
		this.fac = f;
	}

	public DataCarta[] VisualizarCartas(int codigoJugador) throws RemoteException {
		DataCarta arregloDataCarta[] = null;
		try 
		{
			arregloDataCarta = this.fac.VisualizarCartasCompletas(codigoJugador);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, "RemoteException", "ERROR!", JOptionPane.ERROR_MESSAGE);
		} catch (ElJugadorNoTieneCartasException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Exception", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}	
		
		return arregloDataCarta;
	}
}
