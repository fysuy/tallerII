package Logica;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Excepciones.*;
import Persistencia.Respaldo;

public class Facade extends UnicastRemoteObject implements IFacadeLogica {
	
	private static final long serialVersionUID = 1L;
	private static Facade instance = null;
	private Partidas partidas;
	private Cartas cartas;
	private Jugadores jugadores;
	private Monitor monitor;
	
	public Facade() throws RemoteException {
		partidas = new Partidas();
		cartas = new Cartas();
		monitor = new Monitor();
		
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
		monitor.comienzoEscritura();
		if(partidas.HayAlgunaPartidaIniciada()){
			monitor.terminoEscritura();
			throw new HayPartidasIniciadasException("La partida ya esta iniciada");
		}
		if(partidas.ExisteCodigo(dataCrearNuevaPartida.getCodigo())){					
			monitor.terminoEscritura();
			throw new CodigoPartidaRepetidoException("Ya existe una partida con ese código");
		}
		if(dataCrearNuevaPartida.getArregloNombres().length < 2){
			monitor.terminoEscritura();
			throw new PartidaInsuficientesJugadoresException("Insuficientes jugadores");
		}
		partidas.insert(dataCrearNuevaPartida.getCodigo(), dataCrearNuevaPartida);
		monitor.terminoEscritura();
	}
	
	public Partida ObtenerPartida(String clave) throws RemoteException, PartidaNoExisteException{
		monitor.comienzoLectura();
		Partida aux = partidas.find(clave);
		monitor.terminoLectura();
		return aux;
	}
	
	public boolean NoHayPartidas() throws RemoteException{
		monitor.comienzoLectura();
		boolean aux = partidas.esVacio();
		monitor.terminoLectura();
		return aux;
	}

	public boolean ExistePartida(String clave) throws RemoteException{
		monitor.comienzoLectura();
		boolean aux = partidas.member(clave);
		monitor.terminoLectura();
		return aux;
	}

	public String[] listarCodigosPartidas() throws RemoteException {
		monitor.comienzoLectura();
		String arregloCodigosPartidas[] = partidas.listarCodigosPartidas();
		monitor.terminoLectura();
    	return arregloCodigosPartidas;
	}

	
	public void IniciarNuevaPartida(String codigo) throws RemoteException, PartidaNoExisteException, HayPartidasIniciadasException {
		monitor.comienzoEscritura();
	    if(HayAlgunaPartidaIniciada())
	    {
	    	monitor.terminoEscritura();
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
				monitor.terminoEscritura();
				throw new PartidaNoExisteException("El codigo de partida no existe");
			}	    	
	    }		
	    monitor.terminoEscritura();
	}
	public void BarajarCartas() throws RemoteException{
		monitor.comienzoEscritura();
		cartas.BarajarCartas();
		monitor.terminoEscritura();
	}
	public boolean HayAlgunaPartidaIniciada() throws RemoteException{
		monitor.comienzoLectura();
		boolean aux = partidas.HayAlgunaPartidaIniciada();
		monitor.terminoLectura();
		return aux;
	}
	public void BajarCartasAlMazo() {
		monitor.comienzoEscritura();
		cartas.BajarCartasAlMazo();
		monitor.terminoEscritura();
	}
	
	public DataVisualizarCartas[] VisualizarCartas() throws RemoteException{
		monitor.comienzoLectura();
		DataVisualizarCartas arregloDataVisualizarCartas[] = jugadores.VisualizarCartas();
		monitor.terminoLectura();
    	return arregloDataVisualizarCartas;
	}
	
	public void RespaldarDatos() throws RemoteException
	{
		monitor.comienzoEscritura();
		try 
		{
			Respaldo respaldo = new Respaldo();
			respaldo.Respaldar(partidas, cartas);
		}
		catch (IOException e) { e.printStackTrace(); }
		monitor.terminoEscritura();
	}
	
	public boolean MazoCreado() throws RemoteException {
		monitor.comienzoLectura();
		boolean aux = cartas.MazoCreado();
		monitor.terminoLectura();
		return aux;
	}

	public boolean quedanCartas() throws RemoteException{
		monitor.comienzoLectura();
		boolean aux = cartas.hayCartas(cartas);
		monitor.terminoLectura();
		return aux;
	}

	 public DataPartida[] listarPartidas() throws RemoteException{     
		 monitor.comienzoLectura();
         DataPartida arregloPartidas[] = partidas.listarPartidas();
         monitor.terminoLectura();
         return arregloPartidas;
	 }
	 
	 public DataListarJugadoresPartidas[] listarJugadores() throws RemoteException{
		 monitor.comienzoLectura();
         DataListarJugadoresPartidas arregloJugadores[] = jugadores.listarJugadores();
         monitor.terminoLectura();
         return arregloJugadores;
	 }
	 public DataJugador[] obtenerJugadores() throws RemoteException{
		 monitor.comienzoLectura();
         DataJugador arregloJugadores[] = jugadores.obtenerJugadores();
         monitor.terminoLectura();
         return arregloJugadores;
	 }

		public void DarCarta(Jugador jugador) throws RemoteException {	
			monitor.comienzoEscritura();
			int valor = cartas.darCarta(jugador);
			int totalCartas = jugador.getPuntos() + valor;
			jugador.setPuntos(totalCartas);
			monitor.terminoEscritura();
		}
	
	//Req 5 - Iniciar turno de un jugador
	public void IniciarTurnoJugador() throws RemoteException, PartidaNoHayEnCursoException
	{
		monitor.comienzoEscritura();
		Partida partida = partidas.getPartidaEnCurso();
		if(partida == null){
			monitor.terminoEscritura();
			throw new PartidaNoHayEnCursoException("No hay ninguna partida actualmente en curso");
		}
		monitor.terminoEscritura();
		//Notificar a los jugadores de la partida que actualizen la visualizacion de las cartas.
	}
	
	//Req 6 - Loguearse para jugar
	public boolean Login(String nombreJugador) throws RemoteException, PartidaNoHayEnCursoException, LoginNombreException
	{
		monitor.comienzoLectura();
		Partida partida = partidas.getPartidaEnCurso();
		if(partida == null){
			monitor.terminoLectura();
			throw new PartidaNoHayEnCursoException("No hay ninguna partida actualmente en curso");
		}
		Jugador jugador = partida.getJugadores().findByName(nombreJugador);
		if(jugador == null){
			monitor.terminoLectura();
			throw new LoginNombreException("No existe ningun jugador con el nombre "+nombreJugador+" en la partida actual");
		}
		monitor.terminoLectura();
		return true;
	}
	
	public void RealizarJugada(DataRealizarJugada dataRealizarJugada) throws RemoteException {
		monitor.comienzoEscritura();
		DataPartida dataPartidaEnCusrso = dataRealizarJugada.getDataPartida();
		Partida partidaEnCusrso = new Partida(
				dataPartidaEnCusrso.getCodigo(), 
				dataPartidaEnCusrso.getProximoJugador(), 
				dataPartidaEnCusrso.getEventualGanador(), 
				dataPartidaEnCusrso.isEnCurso(), 
				dataPartidaEnCusrso.isFinalizada(), 
				dataPartidaEnCusrso.getJugadores());
		Jugador jugadorEnTurno = dataPartidaEnCusrso.getProximoJugador();
		
		if(dataRealizarJugada.isPideCarta())
		{
			DarCarta(partidaEnCusrso.getProximoJugador());
			
			if(jugadorEnTurno.getPuntos() == 21)
			{
				partidaEnCusrso.setEventualGanador(jugadorEnTurno);
				partidaEnCusrso.setFinalizada(true);
			}
			else
			{
				if(jugadorEnTurno.getPuntos() > 21)
				{
					jugadorEnTurno.setEliminado(true);
					partidaEnCusrso.setFinalizada(true);
				}
				else
				{
					if(partidas.TieneMayorPuntaje(dataPartidaEnCusrso, jugadorEnTurno.getPuntos()))
						partidaEnCusrso.setEventualGanador(jugadorEnTurno);
					
					jugadorEnTurno.setEnturno(false);
					partidas.MarcarProximoEnTurno(partidaEnCusrso);			
						
				}
			}
		}
		monitor.terminoEscritura();
		
	}

	public DataPartida ObtenerDataPartidaEnCurso() {
		monitor.comienzoLectura();
		Partida partidaEnCurso = partidas.getPartidaEnCurso();
		DataPartida dataPartidaEnCurso = new DataPartida(
				partidaEnCurso.getCodigo(),
				partidaEnCurso.getProximoJugador(), 
				partidaEnCurso.getEventualGanador(), 
				partidaEnCurso.isEnCurso(), 
				partidaEnCurso.isEnCurso(), 
				partidaEnCurso.getJugadores());
		monitor.terminoLectura();
		return dataPartidaEnCurso;
	}

	public int CantidadJugadoresNoEliminados(DataPartida dataPartidaActual) {
		monitor.comienzoLectura();
		int aux = partidas.CantidadJugadoresNoEliminados(dataPartidaActual);
		monitor.terminoLectura();
		return aux;
	}

	
}
