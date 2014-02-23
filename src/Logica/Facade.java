package Logica;

import java.io.IOException;
import java.rmi.RemoteException;

import Excepciones.*;
import Persistencia.*;

public class Facade implements IFacadeLogica {
	
	private static Facade instance = null;
	private Partidas partidas;
	private Cartas cartas;
	private Jugadores jugadores;
	
	private Facade() throws RemoteException {
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
	public static Facade getInstance() throws Exception {
		if(instance == null)
			instance = new Facade();
		
		return instance;
	}

	public void CrearNuevaPartida(DataCrearNuevaPartida dataCrearNuevaPartida) 
			throws HayPartidasIniciadasException, 
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
	
	public Partida ObtenerPartida(String clave) throws PartidaNoExisteException{
		return partidas.find(clave);
	}
	
	public boolean NoHayPartidas(){
		return partidas.esVacio();
	}

	public boolean ExistePartida(String clave){
		return partidas.member(clave);
	}

	public String[] listarCodigosPartidas() {
		
		String arregloCodigosPartidas[] = partidas.listarCodigosPartidas();
    	return arregloCodigosPartidas;
	}

	
	public void IniciarNuevaPartida(String codigo) throws PartidaNoExisteException, HayPartidasIniciadasException {

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
	public void BarajarCartas() {
		
		cartas.BarajarCartas();
		
	}
	public boolean HayAlgunaPartidaIniciada() {
				
		return partidas.HayAlgunaPartidaIniciada();
	}
	public void BajarCartasAlMazo() {
		cartas.BajarCartasAlMazo();
	}
	
	public DataVisualizarCartas[] VisualizarCartas() {
		DataVisualizarCartas arregloDataVisualizarCartas[] = jugadores.VisualizarCartas();
    	return arregloDataVisualizarCartas;
	}
	
	public void RespaldarDatos()
	{
		try 
		{
			Respaldo respaldo = new Respaldo();
			respaldo.Respaldar(partidas, cartas);
		}
		catch (IOException e) { e.printStackTrace(); }
	}
	
	public boolean MazoCreado() {
		return cartas.MazoCreado();
	}

	public boolean quedanCartas(){
		return cartas.hayCartas(cartas);
	}

	public DataJugador darCarta(DataJugador jugador){
		return cartas.darCarta(jugador);
	}
	
	 public DataPartida[] listarPartidas() {     
         DataPartida arregloPartidas[] = partidas.listarPartidas();
         return arregloPartidas;
	 }
	 
	 public DataListarJugadoresPartidas[] listarJugadores(){
         DataListarJugadoresPartidas arregloJugadores[] = jugadores.listarJugadores();
         return arregloJugadores;
	 }
	 public DataJugador[] obtenerJugadores(){
         DataJugador arregloJugadores[] = jugadores.obtenerJugadores();
         return arregloJugadores;
	 }
	@Override
	public Jugador darCarta(Jugador jugador) {
		return null;
	}
	
	//Req 5 - Iniciar turno de un jugador
	public void IniciarTurnoJugador() throws PartidaNoHayEnCursoException
	{
		Partida partida = partidas.getPartidaEnCurso();
		
		if(partida == null)
			throw new PartidaNoHayEnCursoException("No hay ninguna partida actualmente en curso");
		
		//Notificar a los jugadores de la partida que actualizen la visualizacion de las cartas.
	}
	
	//Req 6 - Loguearse para jugar
	public boolean Login(String nombreJugador) throws 
		PartidaNoHayEnCursoException,
		LoginNombreException
	{
		Partida partida = partidas.getPartidaEnCurso();
		if(partida == null)
			throw new PartidaNoHayEnCursoException("No hay ninguna partida actualmente en curso");
		
		Jugador jugador = partida.getJugadores().findByName(nombreJugador);
		if(jugador == null)
			throw new LoginNombreException("No existe ningun jugador con el nombre " + nombreJugador + " en la partida actual");
			
		return true;
	}
	
}
