package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import Logica.DataPartida;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorPartidasRegistradas {

	private IFacadeLogica fac;
		
	public ControladorPartidasRegistradas(IFacadeLogica f){
		this.fac = f;
	}

	public DataPartida[] ListarPartidasRegistradas(){
		
		DataPartida arregloPartidas[] = null;
			try {
				arregloPartidas = this.fac.listarPartidas();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		
		return arregloPartidas;
	}
}
