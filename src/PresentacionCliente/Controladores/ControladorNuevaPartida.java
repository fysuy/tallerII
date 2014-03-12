package PresentacionCliente.Controladores;

import java.rmi.RemoteException;

import Logica.DataCrearNuevaPartida;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorNuevaPartida {

	private IFacadeLogica fac;
	private DataCrearNuevaPartida dataCrearNuevaPartida;
	
	public ControladorNuevaPartida(IFacadeLogica f){
		this.fac = f;
	}
	
	public void NuevaPartida(String codigoPartida, String[] arregloNombres){
		try 
		{			
			dataCrearNuevaPartida = new DataCrearNuevaPartida(codigoPartida, arregloNombres);
			this.fac.CrearNuevaPartida(dataCrearNuevaPartida);
		}
		catch (Exception e) { e.printStackTrace(); }		
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
	
	
	public boolean ExistePartida(String codigo){ // HACERRRRRRRRRRRRRRRRRRR
		try {
			fac = Facade.getInstance();
			if(fac.ExistePartida(codigo))
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
