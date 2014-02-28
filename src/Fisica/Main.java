package Fisica;

import java.util.ArrayList;

import Logica.DataCrearNuevaPartida;
import Logica.DataListarJugadoresPartidas;
import Logica.DataPartida;
import Logica.DataRealizarJugada;
import Logica.DataVisualizarCartas;
import Logica.Facade;
import Logica.Jugador;
import Logica.Partida;

public class Main {

	public static void main(String[] args){
		
		DataCrearNuevaPartida dataCrearNuevaPartida;
		Facade fac;
				
		System.out.println("Requerimiento 1 Crear una nueva partida");
		System.out.println("=======================================");
		
		String codigoPartida = "A13";		
		ArrayList<String> listaNombres = new ArrayList<String>();
		listaNombres.add("Luis");
		listaNombres.add("Tony");
		listaNombres.add("Dario");
		listaNombres.add("Japo");
		String[] arregloNombres = new String[listaNombres.size()];
		arregloNombres = listaNombres.toArray(arregloNombres);
	    
		dataCrearNuevaPartida = new DataCrearNuevaPartida(codigoPartida, arregloNombres);
		try 
		{
			fac = Facade.getInstance();
			fac.CrearNuevaPartida(dataCrearNuevaPartida);
		} 
		catch (Exception e) { e.printStackTrace(); }
		
		codigoPartida = "A12";	
		listaNombres = new ArrayList<String>();
		listaNombres.add("Valdez");
		listaNombres.add("Orteman");
		listaNombres.add("Zala");
		listaNombres.add("Lolo");
	    
		arregloNombres = new String[listaNombres.size()];
		arregloNombres = listaNombres.toArray(arregloNombres);
		
    	dataCrearNuevaPartida = new DataCrearNuevaPartida(codigoPartida, arregloNombres);
		
		try 
		{
			fac = Facade.getInstance();
			fac.CrearNuevaPartida(dataCrearNuevaPartida);
		} 
		catch (Exception e) { e.printStackTrace(); }
		
		
		
	    System.out.println("Requerimiento 2 Listar codigos de partidas");
		System.out.println("==========================================");
		
		try 
		{
			fac = Facade.getInstance();
			String arregloCodigosPartidas[] = fac.listarCodigosPartidas();
						
			for( int i=0; i<arregloCodigosPartidas.length ; i ++ )
				System.out.println("Codigo partida: " + arregloCodigosPartidas[i]);
			
		} catch (Exception e) { e.printStackTrace(); }
		
		System.out.println("Requerimiento 3 Iniciar una nueva partida");
		System.out.println("=========================================");
		
	    String codigo = "A12";
	
		try 
		{			
			fac = Facade.getInstance();			
			fac.IniciarNuevaPartida(codigo);
		} 
		catch (Exception e) { e.printStackTrace(); }
        	
		codigo = "A13";
		try 
		{			
			fac = Facade.getInstance();
			fac.IniciarNuevaPartida(codigo);
		} 
		catch (Exception e) { e.printStackTrace(); }
		
		System.out.println("Listo nuevamente las partidas");
		System.out.println("=============================");
				
		try 
		{
			fac = Facade.getInstance();
			String arregloCodigosPartidas[] = fac.listarCodigosPartidas();
						
			for( int i=0; i<arregloCodigosPartidas.length ; i ++ )
				System.out.println("Codigo partida: " + arregloCodigosPartidas[i]);
		} 
		catch (Exception e) { e.printStackTrace(); }
		
		System.out.println("Requerimiento 4 Respaldar datos");
		System.out.println("===============================");
		
		try {
			fac = Facade.getInstance();
			fac.RespaldarDatos();
		} catch (Exception e) { e.printStackTrace(); }
		
		System.out.println("Requerimiento 5 Iniciar turno de jugador");
		System.out.println("===============================");
		
		try {
			fac = Facade.getInstance();
			fac.IniciarTurnoJugador();
		} catch (Exception e) { e.printStackTrace(); }
		
		System.out.println("Requerimiento 6 Loguearse");
		System.out.println("===============================");
		
		try {
			fac = Facade.getInstance();
			fac.Login("Pepe");
		} catch (Exception e) { e.printStackTrace(); }

		
		System.out.println("Requerimiento 7 Visualizar cartas");
		System.out.println("=================================");
		try 
		{
			fac = Facade.getInstance();
			DataVisualizarCartas arregloDataVisualizarCartas[] = fac.VisualizarCartas();
			
			for( int i=0; i<arregloDataVisualizarCartas.length ; i ++ )
			{ 
				System.out.println("");
				System.out.println("Numero: " + arregloDataVisualizarCartas[i].getNumero());
				System.out.println("Nombre: " + arregloDataVisualizarCartas[i].getNombre());
				System.out.println("Puntos: " + arregloDataVisualizarCartas[i].getPuntos());
				System.out.println("Cartas: " + arregloDataVisualizarCartas[i].getCartas());
			} 
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		

		System.out.println("Requerimiento 8 Realizar jugada");
		System.out.println("=================================");
		
		try {
			fac = Facade.getInstance();
			
			DataPartida dataPartidaActual = fac.ObtenerDataPartidaEnCurso();
			boolean pideCarta = true;
			
			//int cantidad = fac.CantidadJugadoresNoEliminados(dataPartidaActual);
			if(fac.CantidadJugadoresNoEliminados(dataPartidaActual) > 1)
			{
				DataRealizarJugada dataRealizarJugada = new DataRealizarJugada(pideCarta, dataPartidaActual);
				fac.RealizarJugada(dataRealizarJugada);
			}		
			
		}catch (Exception e1) {e1.printStackTrace();}
		
		

		/**************************** REQUERIMIENTO 9 **************************/
			try {
				fac = Facade.getInstance();
				boolean vacio = fac.NoHayPartidas();
				if(vacio == true)
					System.out.println("No hay ninguna partida");
				else
				{
					DataPartida arregloPartidas[] = fac.listarPartidas();
					for( int i=0; i<arregloPartidas.length ; i ++ ){ 
						System.out.println("");
						System.out.println("Codigo partida: " + arregloPartidas[i].getCodigo());
						System.out.println("Partida en curso: " + arregloPartidas[i].isEnCurso());
						System.out.println("Partida finalizada: " + arregloPartidas[i].isFinalizada());
						System.out.println("\n");
						System.out.println("Próximo jugador");
						System.out.println("==============");
						System.out.println("Nombre: " + arregloPartidas[i].getProximoJugador().getNombre());
						System.out.println("Puntos: " + arregloPartidas[i].getProximoJugador().getPuntos());
						System.out.println("\n");
						System.out.println("Eventual ganador");
						System.out.println("==============");
						System.out.println("Nombre: " + arregloPartidas[i].getEventualGanador().getNombre());
						System.out.println("Puntos: " + arregloPartidas[i].getEventualGanador().getPuntos());
					}
					
				} 
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
			

			/**************************** REQUERIMIENTO 10 **************************/
			codigo = "A12";
			try {
				fac = Facade.getInstance();
				if(!fac.ExistePartida(codigo))
					System.out.println("No existe ninguna partida con dicho codigo");
				else
				{
					DataListarJugadoresPartidas arregloJugadores[] = fac.listarJugadores();
					for( int i=0; i<arregloJugadores.length; i++){ 
						System.out.println("Jugadores de la partida: "+codigo);
						System.out.println("\n\nJugador numero"+i);
						System.out.println("Nombre: " + arregloJugadores[i].getNombre());
						System.out.println("Numero: " + arregloJugadores[i].getNumero());
						System.out.println("Puntaje: " + arregloJugadores[i].getPuntos());
					}
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
		
