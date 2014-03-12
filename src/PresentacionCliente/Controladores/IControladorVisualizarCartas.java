package PresentacionCliente.Controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Logica.DataCarta;

public interface IControladorVisualizarCartas extends Remote {	
	public DataCarta[] VisualizarCartas(int codigoJugador) throws RemoteException;
}
