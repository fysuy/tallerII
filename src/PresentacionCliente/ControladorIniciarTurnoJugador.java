package PresentacionCliente;

import java.rmi.RemoteException;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorIniciarTurnoJugador {

	private IFacadeLogica fac;
		
	public ControladorIniciarTurnoJugador(){
		super();
	}
	
	public void IniciarTurnoJugador(){

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
