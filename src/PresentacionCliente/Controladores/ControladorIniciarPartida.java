package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Logica.IFacadeLogica;

@SuppressWarnings("serial")
public class ControladorIniciarPartida extends UnicastRemoteObject implements IControladorIniciarPartida {

	private IFacadeLogica fac;
		
	public ControladorIniciarPartida(IFacadeLogica f) throws RemoteException {
		this.fac = f;
	}

	public void IniciarNuevaPartida(String codigoPartida) throws RemoteException {
		try 
		{
			this.fac.IniciarNuevaPartida(codigoPartida);
		}
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public boolean PartidaYaIniciada(String codigo) throws RemoteException {
		try 
		{
			return(this.fac.estaIniciada(codigo));
		} 
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }
		
		return false;
	}
	
	public boolean HayPartidaIniciada() throws RemoteException {
		try 
		{
			return this.fac.HayAlgunaPartidaIniciada();
		} 
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
}
