package Logica;

import java.rmi.Remote;

import Excepciones.CodigoPartidaRepetidoException;
import Excepciones.Exceptiones;
import Excepciones.HayPartidasIniciadasException;
import Excepciones.PartidaInsuficientesJugadoresException;
import Excepciones.PartidaNoExisteException;


public interface IFacadeLogica extends Remote{
	
	public void CrearNuevaPartida(DataCrearNuevaPartida dataCrearNuevaPartida) 
			throws HayPartidasIniciadasException, 
			CodigoPartidaRepetidoException,
			PartidaInsuficientesJugadoresException;
	public Partida ObtenerPartida(String clave) throws PartidaNoExisteException;
	public boolean NoHayPartidas();
	public boolean ExistePartida(String clave);
	public void IniciarNuevaPartida(String codigo) throws PartidaNoExisteException, HayPartidasIniciadasException;
	public void BarajarCartas();
	public boolean HayAlgunaPartidaIniciada();
	public void BajarCartasAlMazo();
	public DataVisualizarCartas[] VisualizarCartas();
	public boolean MazoCreado(); 
	public boolean quedanCartas();
	public Jugador darCarta(Jugador jugador);
}