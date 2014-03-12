package PresentacionCliente.Controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Logica.DataPartida;
import Logica.DataRealizarJugada;
import Logica.IFacadeLogica;
import Logica.Partida;

@SuppressWarnings("serial")
public class ControladorRealizarJugada extends UnicastRemoteObject implements IControladorRealizarJugada {
	private IFacadeLogica fac;
	
	public ControladorRealizarJugada(IFacadeLogica f) throws RemoteException {
		this.fac = f;
	}
	
	public void RealizarJugada(DataRealizarJugada dataRealizarJugada) throws RemoteException {
		try 
		{
			this.fac.RealizarJugada(dataRealizarJugada);
		}
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }	
	}

	public DataPartida Partida() throws RemoteException {
		try 
		{
			//TODO: Debe devolver una datapartida ya desde facade
			Partida par = this.fac.PartidaEnCurso();
			DataPartida data = new DataPartida(
					par.getCodigo(),
					par.getProximoJugador(),
					par.getEventualGanador(),
					par.isEnCurso(),
					par.isFinalizada(),
					par.getJugadores()
					);
			return data;
		} 
		catch (RemoteException e) { e.printStackTrace(); throw e; } 
		catch (Exception e) { e.printStackTrace(); }	
		
		return null;
	}
	
	//TODO: para que esta esto?????
	public void QuiereCarta(DataRealizarJugada data){
		data.setPideCarta(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
