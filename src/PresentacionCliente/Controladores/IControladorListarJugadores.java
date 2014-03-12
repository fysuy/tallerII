package PresentacionCliente.Controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Logica.DataListarJugadoresPartidas;

public interface IControladorListarJugadores extends Remote {	
	public DataListarJugadoresPartidas[] ListarJugadores() throws RemoteException;
	public boolean HayPartidaIniciada() throws RemoteException;
}
