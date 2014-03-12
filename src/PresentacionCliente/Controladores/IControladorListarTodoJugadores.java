package PresentacionCliente.Controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Excepciones.PartidaNoHayEnCursoException;
import Logica.DataJugador;

public interface IControladorListarTodoJugadores extends Remote {	
	public DataJugador[] ListarTodoJugadores() throws PartidaNoHayEnCursoException, RemoteException;
	public boolean HayPartidaIniciada() throws RemoteException;
}
