package Controladores;

import java.rmi.RemoteException;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorListarCodigosPartida {

	private IFacadeLogica fac;
		
	public ControladorListarCodigosPartida(){
		super();
	}
	
	public String[] ListarPartidas(){
		
		String arregloCodigosPartidas[] = null;
		
			System.out.println("11");
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
