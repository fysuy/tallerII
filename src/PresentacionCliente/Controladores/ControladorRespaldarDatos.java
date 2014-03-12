package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import java.util.Calendar;

import Logica.DataCrearNuevaPartida;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorRespaldarDatos {

	private IFacadeLogica fac;
		
	public ControladorRespaldarDatos(){
		super();
	}
	
	public void RespaldarDatos()
	{	
		try 
		{
			this.fac.RespaldarDatos();
		} 
		catch (RemoteException e) { e.printStackTrace(); } 
		catch (Exception e) { e.printStackTrace(); }			
	}
}
