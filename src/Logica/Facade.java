package Logica;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Excepciones.*;
import Persistencia.*;

public class Facade extends UnicastRemoteObject implements IFacadeLogica {
	
	private static Facade instance = null;
	private Partidas partidas;
	private Cartas cartas;
	private Jugadores jugadores;
	
	public Facade() throws RemoteException {
		partidas = new Partidas();
		cartas = new Cartas();

//     	PARA TESTEAR EL RECUPERAR DATOS
//		try {
//			Respaldo respaldo = new Respaldo();
//			Datos datos = respaldo.Recuperar();
//			
//			partidas = datos.getPartidas();
//			cartas = datos.getMazo();
//			
//		} catch (ClassNotFoundException | IOException e) {
//			e.printStackTrace();
//		}
	}
	
	//Se aplica el patron Singleton
	public static Facade getInstance() throws RemoteException, Exception {
		if(instance == null)
			instance = new Facade();
		
		return instance;
	}

	public void CrearNuevaPartida(DataCrearNuevaPartida dataCrearNuevaPartida) 
			throws RemoteException, HayPartidasIniciadasException, 
			CodigoPartidaRepetidoException,
			PartidaInsuficientesJugadoresException {
		
		if(partidas.HayAlgunaPartidaIniciada())
			throw new HayPartidasIniciadasException("La partida ya esta iniciada");
		if(partidas.ExisteCodigo(dataCrearNuevaPartida.getCodigo()))
			throw new CodigoPartidaRepetidoException("Ya existe una partida con ese código");
		if(dataCrearNuevaPartida.getArregloNombres().length < 2)
			throw new PartidaInsuficientesJugadoresException("Insuficientes jugadores");
			
		partidas.insert(dataCrearNuevaPartida.getCodigo(), dataCrearNuevaPartida);
	}
	
	public Partida ObtenerPartida(String clave) throws RemoteException, PartidaNoExisteException{
		return partidas.find(clave);
	}
	
	public boolean NoHayPartidas() throws RemoteException{
		return partidas.esVacio();
	}

	public boolean ExistePartida(String clave) throws RemoteException{
		return partidas.member(clave);
	}

	public String[] listarCodigosPartidas() throws RemoteException {
		
		String arregloCodigosPartidas[] = partidas.listarCodigosPartidas();
    	return arregloCodigosPartidas;
	}

	
	public void IniciarNuevaPartida(String codigo) throws RemoteException, PartidaNoExisteException, HayPartidasIniciadasException {

	    if(HayAlgunaPartidaIniciada())
	    {
	    	throw new HayPartidasIniciadasException("Ya existe una partida iniciada");		    	
	    }
	    else
	    {
	    	try {
				partidas.IniciarNuevaPartida(codigo);
				boolean mazoCreado = MazoCreado();
				if(mazoCreado)
				{
					BarajarCartas();
				}
				else
				{
					BajarCartasAlMazo();
					BarajarCartas();
				}
			} 	
			 catch (PartidaNoExisteException e) {
					
				throw new PartidaNoExisteException("El codigo de partida no existe");
			}	    	
	    }		 		
	}
	public void BarajarCartas() throws RemoteException{
		
		cartas.BarajarCartas();
		
	}
	public boolean HayAlgunaPartidaIniciada() throws RemoteException{
				
		return partidas.HayAlgunaPartidaIniciada();
	}
	public void BajarCartasAlMazo() {
		cartas.BajarCartasAlMazo();
	}
	
	public DataVisualizarCartas[] VisualizarCartas() throws RemoteException{
		DataVisualizarCartas arregloDataVisualizarCartas[] = jugadores.VisualizarCartas();
    	return arregloDataVisualizarCartas;
	}
	
	public void RespaldarDatos() throws RemoteException
	{
		try 
		{
			Respaldo respaldo = new Respaldo();
			respaldo.Respaldar(partidas, cartas);
		}
		catch (IOException e) { e.printStackTrace(); }
	}
	
	public boolean MazoCreado() throws RemoteException {
		return cartas.MazoCreado();
	}

	public boolean quedanCartas() throws RemoteException{
		return cartas.hayCartas(cartas);
	}

	public DataJugador darCarta(DataJugador jugador) throws RemoteException{
		return cartas.darCarta(jugador);
	}
	
	 public DataPartida[] listarPartidas() throws RemoteException{     
         DataPartida arregloPartidas[] = partidas.listarPartidas();
         return arregloPartidas;
	 }
	 
	 public DataListarJugadoresPartidas[] listarJugadores() throws RemoteException{
         DataListarJugadoresPartidas arregloJugadores[] = jugadores.listarJugadores();
         return arregloJugadores;
	 }
	 public DataJugador[] obtenerJugadores() throws RemoteException{
         DataJugador arregloJugadores[] = jugadores.obtenerJugadores();
         return arregloJugadores;
	 }
	@Override
	public Jugador darCarta(Jugador jugador) throws RemoteException{
		return null;
	}
	
	//Req 5 - Iniciar turno de un jugador
	public void IniciarTurnoJugador() throws RemoteException, PartidaNoHayEnCursoException
	{
		Partida partida = partidas.getPartidaEnCurso();
		
		if(partida == null)
			throw new PartidaNoHayEnCursoException("No hay ninguna partida actualmente en curso");
		
		//Notificar a los jugadores de la partida que actualizen la visualizacion de las cartas.
	}
	
	//Req 6 - Loguearse para jugar
	public boolean Login(String nombreJugador) throws RemoteException, PartidaNoHayEnCursoException, LoginNombreException
	{
		Partida partida = partidas.getPartidaEnCurso();
		if(partida == null)
			throw new PartidaNoHayEnCursoException("No hay ninguna partida actualmente en curso");
		
		Jugador jugador = partida.getJugadores().findByName(nombreJugador);
		if(jugador == null)
			throw new LoginNombreException("No existe ningun jugador con el nombre "+nombreJugador+" en la partida actual");
			
		return true;
	}
	
}
