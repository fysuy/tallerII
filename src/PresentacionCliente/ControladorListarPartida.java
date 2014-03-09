package PresentacionCliente;

import java.rmi.RemoteException;
import java.util.Calendar;

import Logica.DataCrearNuevaPartida;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorListarPartida {

	private IFacadeLogica fac;
		
	public ControladorListarPartida(){
		super();
	}
	
	public String[] ListarPartidas(){
		
		String arregloCodigosPartidas[] = null;
		
			try {
				fac = Facade.getInstance();
				arregloCodigosPartidas = fac.listarCodigosPartidas();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		
		return arregloCodigosPartidas;
	}
}
