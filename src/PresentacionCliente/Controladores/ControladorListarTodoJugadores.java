package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Excepciones.PartidaNoHayEnCursoException;
import Logica.DataJugador;
import Logica.IFacadeLogica;

@SuppressWarnings("serial")
public class ControladorListarTodoJugadores extends UnicastRemoteObject implements IControladorListarTodoJugadores {
	private IFacadeLogica fac;
	
	public ControladorListarTodoJugadores(IFacadeLogica f) throws RemoteException {
		this.fac = f;
	}
	
	public DataJugador[] ListarTodoJugadores() throws PartidaNoHayEnCursoException, RemoteException {
		DataJugador[] jugadores = null;
		try 
		{
			jugadores = this.fac.listarTodoJugadores();
		}
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }
		
		return jugadores;
	}
	
	public boolean HayPartidaIniciada() throws RemoteException {
		try 
		{
			return fac.HayAlgunaPartidaIniciada();
		} 
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }
		
		return false;
	}
}
