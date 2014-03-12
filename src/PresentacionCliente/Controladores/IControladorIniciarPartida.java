package PresentacionCliente.Controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IControladorIniciarPartida extends Remote {
	public void IniciarNuevaPartida(String codigoPartida) throws RemoteException;
	public boolean PartidaYaIniciada(String codigo) throws RemoteException;
	public boolean HayPartidaIniciada() throws RemoteException;
}
