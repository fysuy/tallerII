package PresentacionCliente;

import java.rmi.RemoteException;

import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorIniciarPartida {

	private IFacadeLogica fac;
		
	public ControladorIniciarPartida(){
		super();
	}

	public void IniciarNuevaPartida(String codigoPartida) {

		try {
			fac = Facade.getInstance();
			fac.IniciarNuevaPartida(codigoPartida);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public boolean PartidaYaIniciada(String codigo){
		try {
			fac = Facade.getInstance();
			return(fac.estaIniciada(codigo));
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean HayPartidaIniciada(){
		try {
			fac = Facade.getInstance();
			if(fac.HayAlgunaPartidaIniciada())
				return true;
			else
				return false;
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
}