package PresentacionCliente.Controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IControladorListarPartida extends Remote {	
	public String[] ListarPartidas() throws RemoteException;
}
