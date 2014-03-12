package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Logica.IFacadeLogica;

@SuppressWarnings("serial")
public class ControladorRespaldarDatos extends UnicastRemoteObject implements IControladorRespaldarDatos {

	private IFacadeLogica fac;
		
	public ControladorRespaldarDatos(IFacadeLogica facade) throws RemoteException {
		this.fac = facade;
	}
	
	public void RespaldarDatos() throws RemoteException {	
		try 
		{
			this.fac.RespaldarDatos();
		} 
		catch (RemoteException e) { e.printStackTrace(); } 
		catch (Exception e) { e.printStackTrace(); }			
	}
}
