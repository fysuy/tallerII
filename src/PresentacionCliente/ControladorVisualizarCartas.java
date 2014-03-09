package PresentacionCliente;

import java.rmi.RemoteException;
import Logica.DataVisualizarCartas;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorVisualizarCartas {

	private IFacadeLogica fac;
		
	public ControladorVisualizarCartas(){
		super();
	}

	public DataVisualizarCartas[] VisualizarCartas(){
		
		DataVisualizarCartas arregloDataVisualizarCartas[] = {};
			try {
				fac = Facade.getInstance();
				System.out.println("controlador 1");
				arregloDataVisualizarCartas = fac.VisualizarCartas();
				System.out.println("controlador 2");
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		
		return arregloDataVisualizarCartas;
	}
}
