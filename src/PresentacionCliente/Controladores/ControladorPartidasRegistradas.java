package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Logica.DataPartida;
import Logica.IFacadeLogica;

@SuppressWarnings("serial")
public class ControladorPartidasRegistradas extends UnicastRemoteObject implements IControladorPartidasRegistradas {

	private IFacadeLogica fac;
		
	public ControladorPartidasRegistradas(IFacadeLogica f) throws RemoteException {
		this.fac = f;
	}

	public DataPartida[] ListarPartidasRegistradas() throws RemoteException {
		DataPartida arregloPartidas[] = null;
		
		try 
		{
			arregloPartidas = this.fac.listarPartidas();
		} 
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }		
		
		return arregloPartidas;
	}
}
