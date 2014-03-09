package PresentacionCliente;

import java.rmi.RemoteException;
import java.util.Calendar;

import Logica.DataCrearNuevaPartida;
import Logica.DataPartida;
import Logica.DataVisualizarCartas;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorVisualizarCartas {

	private IFacadeLogica fac;
		
	public ControladorVisualizarCartas(){
		super();
	}

	public DataVisualizarCartas[] VisualizarCartas(){
		
		DataVisualizarCartas arregloDataVisualizarCartas[] = null;
			try {
				fac = Facade.getInstance();
				arregloDataVisualizarCartas = fac.VisualizarCartas();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		
		return arregloDataVisualizarCartas;
	}
}
