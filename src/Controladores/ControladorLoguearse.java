package Controladores;

import java.rmi.RemoteException;

import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorLoguearse {
	private IFacadeLogica fac;
	
	public ControladorLoguearse(){
		super();
	}
	
	//nombreJugador se obtiene de la capa grafica
	public void Loguearse(String nombreJugador){
		try {
			fac = Facade.getInstance();
			fac.Login(nombreJugador);
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	

}
