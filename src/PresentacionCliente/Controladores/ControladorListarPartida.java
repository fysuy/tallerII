package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Logica.IFacadeLogica;

@SuppressWarnings("serial")
public class ControladorListarPartida extends UnicastRemoteObject implements IControladorListarPartida {

	private IFacadeLogica fac;
		
	public ControladorListarPartida(IFacadeLogica f) throws RemoteException {
		this.fac = f;
	}
	
	public String[] ListarPartidas() throws RemoteException {
		String arregloCodigosPartidas[] = null;
		
		try 
		{
			arregloCodigosPartidas = this.fac.listarCodigosPartidas();
		} 
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }	
		
		return arregloCodigosPartidas;		
	}
}
