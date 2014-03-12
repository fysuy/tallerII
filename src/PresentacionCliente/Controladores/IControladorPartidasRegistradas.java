package PresentacionCliente.Controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Logica.DataPartida;

public interface IControladorPartidasRegistradas extends Remote {	
	public DataPartida[] ListarPartidasRegistradas() throws RemoteException;
}
