package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Excepciones.PartidaNoHayEnCursoException;
import Logica.IFacadeLogica;

@SuppressWarnings("serial")
public class ControladorIniciarTurnoJugador extends UnicastRemoteObject implements IControladorIniciarTurnoJugador {

	private IFacadeLogica fac;
		
	public ControladorIniciarTurnoJugador(IFacadeLogica f) throws RemoteException {
		this.fac = f;
	}
	
	public void IniciarTurnoJugador() throws PartidaNoHayEnCursoException, RemoteException {
		try 
		{
			this.fac.IniciarTurnoJugador();
		}
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }			
	}
}
