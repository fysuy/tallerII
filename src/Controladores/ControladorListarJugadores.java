package Controladores;

import java.rmi.RemoteException;

import Logica.DataListarJugadoresPartidas;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorListarJugadores {
	private IFacadeLogica fac;
	private DataListarJugadoresPartidas[] data;
	
	public ControladorListarJugadores(){
		super();
	}
	
	public DataListarJugadoresPartidas[] ListarJugadores(){
		try {
			fac = Facade.getInstance();
			data = fac.listarJugadores();
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	
	
	
	
	

}
