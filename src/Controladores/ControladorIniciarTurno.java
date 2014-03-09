package Controladores;

import java.rmi.RemoteException;

import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorIniciarTurno {
	private IFacadeLogica fac;
	
	public ControladorIniciarTurno(){
		super();
	}
	
	public void IniciarTurno(){
		try {
			fac = Facade.getInstance();
			fac.IniciarTurnoJugador();
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
	
	
}
