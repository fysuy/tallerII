package PresentacionCliente;

import java.rmi.RemoteException;
import java.util.Calendar;

import Logica.DataCrearNuevaPartida;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorIniciarTurnoJugador {

	private IFacadeLogica fac;
		
	public ControladorIniciarTurnoJugador(){
		super();
	}
	
	public void IniciarTurnoJugador(){
		
		String arregloCodigosPartidas[] = null;
		
			try {
				fac = Facade.getInstance();
				fac.IniciarTurnoJugador();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		
	}
}
