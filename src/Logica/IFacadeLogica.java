package Logica;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Excepciones.CodigoPartidaRepetidoException;
import Excepciones.HayPartidasIniciadasException;
import Excepciones.LoginNombreException;
import Excepciones.PartidaInsuficientesJugadoresException;
import Excepciones.PartidaNoExisteException;
import Excepciones.PartidaNoHayEnCursoException;


public interface IFacadeLogica extends Remote{
	
	public void CrearNuevaPartida(DataCrearNuevaPartida dataCrearNuevaPartida) throws RemoteException, HayPartidasIniciadasException, CodigoPartidaRepetidoException, PartidaInsuficientesJugadoresException; 
	public Partida ObtenerPartida(String clave) throws RemoteException, PartidaNoExisteException;
	public boolean NoHayPartidas() throws RemoteException;
	public boolean ExistePartida(String clave) throws RemoteException;
	public String[] listarCodigosPartidas() throws RemoteException; 
	public void IniciarNuevaPartida(String codigo) throws RemoteException, PartidaNoExisteException, HayPartidasIniciadasException;
	public void BarajarCartas() throws RemoteException;
	public boolean HayAlgunaPartidaIniciada() throws RemoteException;
	public void BajarCartasAlMazo() throws RemoteException; 
	public DataVisualizarCartas[] VisualizarCartas() throws RemoteException;
	public void RespaldarDatos() throws RemoteException;
	public boolean MazoCreado() throws RemoteException;
	public boolean quedanCartas() throws RemoteException;
	public DataPartida[] listarPartidas() throws RemoteException;
	public DataListarJugadoresPartidas[] listarJugadores() throws RemoteException;
	public DataJugador[] obtenerJugadores() throws RemoteException;
	public void DarCarta(Jugador jugador) throws RemoteException;
	public void IniciarTurnoJugador() throws RemoteException, PartidaNoHayEnCursoException;
	public boolean Login(String nombreJugador) throws RemoteException, PartidaNoHayEnCursoException, LoginNombreException;
	public void RealizarJugada(DataRealizarJugada dataRealizarJugada) throws RemoteException;
	public DataPartida ObtenerDataPartidaEnCurso()  throws RemoteException;
	public int CantidadJugadoresNoEliminados(DataPartida dataPartidaActual) throws RemoteException;
	

}