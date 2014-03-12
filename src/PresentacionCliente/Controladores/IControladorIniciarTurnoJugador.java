package PresentacionCliente.Controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Excepciones.PartidaNoHayEnCursoException;

public interface IControladorIniciarTurnoJugador extends Remote {	
	public void IniciarTurnoJugador() throws PartidaNoHayEnCursoException, RemoteException;
}
