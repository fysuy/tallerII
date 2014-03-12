package PresentacionCliente.Controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Logica.DataPartida;
import Logica.DataRealizarJugada;

public interface IControladorRealizarJugada extends Remote {	
	public void RealizarJugada(DataRealizarJugada dataRealizarJugada) throws RemoteException;
	public DataPartida Partida() throws RemoteException;
}
