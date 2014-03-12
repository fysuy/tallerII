package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Logica.DataListarJugadoresPartidas;
import Logica.IFacadeLogica;

@SuppressWarnings("serial")
public class ControladorListarJugadores extends UnicastRemoteObject implements IControladorListarJugadores {
	private IFacadeLogica fac;
	
	public ControladorListarJugadores(IFacadeLogica f) throws RemoteException{
		this.fac = f;
	}
	
	public DataListarJugadoresPartidas[] ListarJugadores() throws RemoteException {
		DataListarJugadoresPartidas[] data = null;
		
		try 
		{
			data = this.fac.listarJugadores();
		} 
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }		
		
		return data;
	}
	
	public boolean HayPartidaIniciada() throws RemoteException {
		try 
		{
			return fac.HayAlgunaPartidaIniciada();
		} 
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }	
		
		return false;
	}
	
	
	
	
	
	
	

}
