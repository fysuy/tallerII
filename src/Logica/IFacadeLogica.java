package Logica;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Excepciones.CodigoPartidaRepetidoException;
import Excepciones.HayPartidasIniciadasException;
import Excepciones.PartidaInsuficientesJugadoresException;
import Excepciones.PartidaNoExisteException;


public interface IFacadeLogica extends Remote{
	
	public void CrearNuevaPartida(DataCrearNuevaPartida dataCrearNuevaPartida) 
			throws HayPartidasIniciadasException, 
			CodigoPartidaRepetidoException,
			PartidaInsuficientesJugadoresException, RemoteException;
	public Partida ObtenerPartida(String clave) throws PartidaNoExisteException, RemoteException;
	public boolean NoHayPartidas() throws RemoteException;
	public boolean ExistePartida(String clave) throws RemoteException;
	public void IniciarNuevaPartida(String codigo) throws RemoteException, PartidaNoExisteException, HayPartidasIniciadasException;
	public void BarajarCartas() throws RemoteException;
	public boolean HayAlgunaPartidaIniciada() throws RemoteException;
	public void BajarCartasAlMazo() throws RemoteException;
	public DataVisualizarCartas[] VisualizarCartas() throws RemoteException;
	public boolean MazoCreado() throws RemoteException; 
	public boolean quedanCartas()throws RemoteException;
	public void DarCarta(Jugador jugador) throws RemoteException;
}