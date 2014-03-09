package Controladores;

import java.rmi.RemoteException;

import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorGuardarCambios {
	private IFacadeLogica fac;
	
	public ControladorGuardarCambios(){
		super();
	}

	
	public void GuardarCambios(){
		try {
			fac = Facade.getInstance();
			fac.RespaldarDatos();
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
