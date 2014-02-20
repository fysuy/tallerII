package Logica;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Vector;

import Excepciones.CodigoPartidaRepetidoException;
import Excepciones.PartidaNoExisteException;
import Excepciones.HayPartidasIniciadasException;

public class Facade implements IFacadeLogica {
	
	private static Facade instance = null;
	public Partidas partidas;
	public Cartas cartas;
	public Jugadores jugadores;
	
	private Facade()throws RemoteException{

		partidas= new Partidas();
		cartas= new Cartas();
		jugadores= new Jugadores();
	}
	//se aplica el patron singleton
	public static Facade getInstance()throws Exception{
		if(instance == null){
			instance = new Facade();
		
		}return instance;
	}
	

	public void CrearNuevaPartida(DataCrearNuevaPartida dataCrearNuevaPartida) throws HayPartidasIniciadasException, CodigoPartidaRepetidoException {
		
		boolean hayPartidaIniciada = partidas.HayAlgunaPartidaIniciada();

		if(hayPartidaIniciada)
		{
			throw new HayPartidasIniciadasException("La partida ya esta iniciada");
		}
		else
		{
			boolean yaExisteElCodigo = partidas.HayAlgunaPartidaIniciada();
			if(yaExisteElCodigo)
			{
				throw new CodigoPartidaRepetidoException("Ya existe una partida con ese código");
			}
			else
			{
				partidas.insert(dataCrearNuevaPartida.getCodigo(), dataCrearNuevaPartida);
			}			
		}		
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
	public boolean MazoCreado() {

		
		return cartas.MazoCreado();
	}

	public boolean quedanCartas(){
		return cartas.hayCartas(cartas);
	}

	public Jugador darCarta(Jugador jugador){
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
}
