package Controladores;

import java.rmi.RemoteException;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorIniciarPartida {

	private IFacadeLogica fac;
		
	public ControladorIniciarPartida(){
		super();
	}

	public void IniciarNuevaPartida(String codigoPartida) {

		System.out.println("cont 0");
		try {
			System.out.println("cont 1");
			fac = Facade.getInstance();
			System.out.println("cont 2");
			fac.IniciarNuevaPartida(codigoPartida);
			System.out.println("cont 3");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
