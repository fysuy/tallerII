package PresentacionCliente.Controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IControladorRespaldarDatos extends Remote {	
	public void RespaldarDatos() throws RemoteException;
}
