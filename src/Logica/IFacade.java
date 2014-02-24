package Logica;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Excepciones.CodigoPartidaRepetidoException;
import Excepciones.Exceptiones;
import Excepciones.HayPartidasIniciadasException;
import Excepciones.LoginNombreException;
import Excepciones.PartidaInsuficientesJugadoresException;
import Excepciones.PartidaNoExisteException;
import Excepciones.PartidaNoHayEnCursoException;


public interface IFacade extends Remote {
	
	public void CrearNuevaPartida(DataCrearNuevaPartida dataCrearNuevaPartida) 
			throws HayPartidasIniciadasException, 
			CodigoPartidaRepetidoException,
			PartidaInsuficientesJugadoresException,
			RemoteException;
	
	public String[] listarCodigosPartidas() throws RemoteException;
	public void IniciarNuevaPartida(String codigo) throws RemoteException, PartidaNoExisteException, HayPartidasIniciadasException;
	public void RespaldarDatos() throws RemoteException;
	public void IniciarTurnoJugador() throws PartidaNoHayEnCursoException, RemoteException;
	public boolean Login(String nombreJugador) throws RemoteException, PartidaNoHayEnCursoException, LoginNombreException;
	public DataVisualizarCartas[] VisualizarCartas() throws RemoteException;
	//Req 8 Realizar jugada
	public DataPartida[] listarPartidas() throws RemoteException;
	public DataListarJugadoresPartidas[] listarJugadores() throws RemoteException;
	
//	public Partida ObtenerPartida(String clave) throws PartidaNoExisteException;
//	public boolean NoHayPartidas();
//	public boolean ExistePartida(String clave);
//	public void BarajarCartas();
//	public boolean HayAlgunaPartidaIniciada();
//	public void BajarCartasAlMazo();
//	public boolean MazoCreado(); 
//	public boolean quedanCartas();
//	public Jugador darCarta(Jugador jugador);
}