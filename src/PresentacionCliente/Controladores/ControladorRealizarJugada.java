package PresentacionCliente.Controladores;

import java.rmi.RemoteException;

import Logica.DataPartida;
import Logica.DataRealizarJugada;
import Logica.Facade;
import Logica.IFacadeLogica;
import Logica.Partida;

public class ControladorRealizarJugada {
	private IFacadeLogica fac;
	
	public ControladorRealizarJugada(IFacadeLogica f){
		this.fac = f;
	}
	
	public void RealizarJugada(DataRealizarJugada dataRealizarJugada){
		try {
			this.fac.RealizarJugada(dataRealizarJugada);
		}
		catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public DataPartida Partida(){
		try {
			fac = Facade.getInstance();
			Partida par = fac.PartidaEnCurso();
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
		catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void QuiereCarta(DataRealizarJugada data){
		data.setPideCarta(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
