package Controladores;

import java.rmi.RemoteException;

import Logica.DataPartida;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorListarPartidas {
	private IFacadeLogica fac;
	private DataPartida[] data;
	
	public ControladorListarPartidas(){
		super();
	}
	
	public DataPartida[] ListarPartidas(){
		try {
			fac = Facade.getInstance();
			data = fac.listarPartidas();
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
}
