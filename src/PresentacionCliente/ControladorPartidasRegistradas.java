package PresentacionCliente;

import java.rmi.RemoteException;
import java.util.Calendar;

import Logica.DataCrearNuevaPartida;
import Logica.DataPartida;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorPartidasRegistradas {

	private IFacadeLogica fac;
		
	public ControladorPartidasRegistradas(){
		super();
	}

	public DataPartida[] ListarPartidasRegistradas(){
		
		DataPartida arregloPartidas[] = null;
			try {
				fac = Facade.getInstance();
				arregloPartidas = fac.listarPartidas();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		
		return arregloPartidas;
	}
}
