package PresentacionCliente.Controladores;

import java.rmi.RemoteException;

import Logica.DataCarta;
import Logica.DataVisualizarCartas;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorVisualizarCartas {

	private IFacadeLogica fac;
		
	public ControladorVisualizarCartas(IFacadeLogica f){
		this.fac = f;
	}

	public DataCarta[] VisualizarCartas(int codigoJugador){
		
		DataCarta arregloDataCarta[] = {};
			try {
				arregloDataCarta = this.fac.VisualizarCartas2(codigoJugador);
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		
		return arregloDataCarta;
	}
}
