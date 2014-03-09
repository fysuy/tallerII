package PresentacionCliente;

import java.rmi.RemoteException;
import java.util.Calendar;

import Logica.DataCrearNuevaPartida;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
