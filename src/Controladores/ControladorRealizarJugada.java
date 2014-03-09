package Controladores;

import java.rmi.RemoteException;

import Logica.DataRealizarJugada;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorRealizarJugada {
	private IFacadeLogica fac;
	
	public ControladorRealizarJugada(){
		super();
	}
	
	//data viene desde la capa grafica
	public void RealizarJugada(DataRealizarJugada data){
		try {
			fac = Facade.getInstance();
			fac.RealizarJugada(data);
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}
