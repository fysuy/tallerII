package PresentacionCliente;

import java.rmi.RemoteException;

import Logica.DataListarJugadoresPartidas;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorListarJugadores {
	private IFacadeLogica fac;
	
	public ControladorListarJugadores(){
		super();
	}
	
	public DataListarJugadoresPartidas[] ListarJugadores(){
		DataListarJugadoresPartidas[] data = null;
		try {
			fac = Facade.getInstance();
			data = fac.listarJugadores();
			return data;
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
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
