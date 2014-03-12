package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Logica.DataCrearNuevaPartida;
import Logica.IFacadeLogica;

@SuppressWarnings("serial")
public class ControladorNuevaPartida extends UnicastRemoteObject implements IControladorNuevaPartida {

	private IFacadeLogica fac;
	
	public ControladorNuevaPartida(IFacadeLogica f) throws RemoteException {
		this.fac = f;
	}
	
	public void NuevaPartida(String codigoPartida, String[] arregloNombres) throws RemoteException {
		try 
		{			
			this.fac.CrearNuevaPartida(new DataCrearNuevaPartida(codigoPartida, arregloNombres));
		}
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }	
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
	
	public boolean ExistePartida(String codigo) throws RemoteException { //TODO:  
		try 
		{
			return this.fac.ExistePartida(codigo);
		} 
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }
		
		return false;
	}
}
