package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Logica.DataCarta;
import Logica.IFacadeLogica;

@SuppressWarnings("serial")
public class ControladorVisualizarCartas extends UnicastRemoteObject implements IControladorVisualizarCartas {

	private IFacadeLogica fac;
		
	public ControladorVisualizarCartas(IFacadeLogica f) throws RemoteException {
		this.fac = f;
	}

	public DataCarta[] VisualizarCartas(int codigoJugador) throws RemoteException {
		DataCarta arregloDataCarta[] = null;
		try 
		{
			arregloDataCarta = this.fac.VisualizarCartas2(codigoJugador);
		}
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }			
		
		return arregloDataCarta;
	}
}
