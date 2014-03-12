package PresentacionCliente.Controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IControladorNuevaPartida extends Remote {	
	public boolean ExistePartida(String codigo) throws RemoteException;
	public boolean HayPartidaIniciada() throws RemoteException;
	public void NuevaPartida(String codigoPartida, String[] arregloNombres) throws RemoteException;
}
