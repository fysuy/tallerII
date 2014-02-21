package Fisica;

import java.util.ArrayList;
import Logica.DataCrearNuevaPartida;
import Logica.DataJugador;
import Logica.DataListarJugadoresPartidas;
import Logica.DataPartida;
import Logica.DataVisualizarCartas;
import Logica.Facade;
import Logica.Partida;
import Logica.Jugador;

public class Main {

	public static void main(String[] args){
		
		DataCrearNuevaPartida dataCrearNuevaPartida;
		Facade fac;
				
		System.out.println("Requerimiento 1 Crear una nueva partida");
		System.out.println("==========================================");
		
		String codigoPartida;		
		//String[] arregloNombres;
		
		codigoPartida = "A13";	
		
		ArrayList<String> listaNombres = new ArrayList<String>();
		listaNombres.add("Luis");
		listaNombres.add("Tony");
		listaNombres.add("Dario");
		listaNombres.add("Japo");
	    
		String[] arregloNombres = new String[listaNombres.size()];
		arregloNombres = listaNombres.toArray(arregloNombres);
	    
		/*arregloNombres = new String[20];
		arregloNombres[0] = new String("Luis");
		arregloNombres[1] = new String("Tony");
		arregloNombres[2] = new String("Dario");
		arregloNombres[3] = new String("Japo");
		*/
		dataCrearNuevaPartida = new DataCrearNuevaPartida(codigoPartida, arregloNombres);
		try {
			
			fac = Facade.getInstance();
			fac.CrearNuevaPartida(dataCrearNuevaPartida);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		codigoPartida = "A14";	
		listaNombres = new ArrayList<String>();
		listaNombres.add("Valdez");
		listaNombres.add("Orteman");
		listaNombres.add("Zala");
		listaNombres.add("Lolo");
	    
		arregloNombres = new String[listaNombres.size()];
		arregloNombres = listaNombres.toArray(arregloNombres);
		
    	dataCrearNuevaPartida = new DataCrearNuevaPartida(codigoPartida, arregloNombres);
		
		try {
			
			fac = Facade.getInstance();
			fac.CrearNuevaPartida(dataCrearNuevaPartida);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	    System.out.println("Requerimiento 2 Listar codigos de partidas");
		System.out.println("==========================================");
		try {

			fac = Facade.getInstance();
			String arregloCodigosPartidas[] = fac.listarCodigosPartidas();
						
			for( int i=0; i<arregloCodigosPartidas.length ; i ++ ){ 
				
				System.out.println("Codigo partida: " + arregloCodigosPartidas[i]);
				System.out.println("\n");
				/*System.out.println("Próximo jugador");
				System.out.println("==============");
				System.out.println("Nombre: " + arregloPartidas[i].getProximoJugador().getNombre());
				System.out.println("Puntos: " + arregloPartidas[i].getProximoJugador().getPuntos());
				System.out.println("\n");
				System.out.println("Eventual ganador");
				System.out.println("==============");
				System.out.println("Nombre: " + arregloPartidas[i].getEventualGanador().getNombre());
				System.out.println("Puntos: " + arregloPartidas[i].getEventualGanador().getPuntos());*/
				
			} 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Requerimiento 3 Iniciar una nueva partida");
		System.out.println("==========================================");
		
			    String codigo = "A12";
			
				try {			
					fac = Facade.getInstance();			
					fac.IniciarNuevaPartida(codigo);

				} catch (Exception e) {
					
					e.printStackTrace();
				}
		        	
			
				codigo = "A13";
				try {			
					fac = Facade.getInstance();
					fac.IniciarNuevaPartida(codigo);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		   

		
				System.out.println("listo nuevamente las partidas");
				System.out.println("===========================");
				
		System.out.println("Partidas");
		System.out.println("==========");
		try {

			fac = Facade.getInstance();
			String arregloCodigosPartidas[] = fac.listarCodigosPartidas();
						
			for( int i=0; i<arregloCodigosPartidas.length ; i ++ ){ 

				System.out.println("Codigo partida: " + arregloCodigosPartidas[i]);
			} 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
				
		System.out.println("Requerimiento 7 Visualizar cartas");
		System.out.println("===========================");
		try {

			fac = Facade.getInstance();
			DataVisualizarCartas arregloDataVisualizarCartas[] = fac.VisualizarCartas();
			
			for( int i=0; i<arregloDataVisualizarCartas.length ; i ++ ){ 
				
				System.out.println("");
				System.out.println("Numero: " + arregloDataVisualizarCartas[i].getNumero());
				System.out.println("Nombre: " + arregloDataVisualizarCartas[i].getNombre());
				System.out.println("Puntos: " + arregloDataVisualizarCartas[i].getPuntos());
				System.out.println("Cartas: " + arregloDataVisualizarCartas[i].getCartas());
				
				
			} 
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		

		/**************************** REQUERIMIENTO 8 **************************/
		// lo hice que nos den el codigo de la partida para buscar mas rapido porque no se como recorrer todo el arbol en java...
		// cualquier cosa lo cambiamos
		System.out.println("------ Requerimiento 8 ---------");
		codigo = "A13";
		try {
			fac = Facade.getInstance();
			Partida actual = fac.ObtenerPartida(codigo);
			DataJugador jugadoresPartida[] = fac.obtenerJugadores();
			DataJugador enTurno;
			int j=0;
			int noEliminados = 0;
			while(j<jugadoresPartida.length){
				if(!jugadoresPartida[j].isEliminado())
					noEliminados++;
				if(jugadoresPartida[j].isEnturno())
					enTurno = jugadoresPartida[j];
				j++;
			}
			if(noEliminados > 1){
				if(fac.quedanCartas())
				{
					boolean quiereCarta = true;
					System.out.println("Desea recibir una carta?");
					//default: quiere carta
					if(quiereCarta == true){
						//enTurno = fac.darCarta(enTurno);
						int sumaCartas = 0;
						// HACER SUMAR CARTAS
						if(sumaCartas == 21){
							//actual.setEventualGanador(jugador);
							actual.setFinalizada(true);
						}
						else if(sumaCartas > 21){
							//jugador.setEliminado(true);
							actual.setFinalizada(true);
						}
					}
					else{
						Jugador aux = actual.getProximoJugador();
						boolean proximo = false;
						while(proximo == false){
							if(!aux.isEliminado()){
								//jugador = actual.getProximoJugador();
								//actual.setProximoJugador(jugador);
								proximo = true;
							}
							else
								aux = actual.getProximoJugador();
						}
					}
						
					
				}
			else{
				int puntaje = 0;
				int mayor = 0;
				Jugador jug = actual.getProximoJugador();
				Jugador ganador=null;
				//recorro todos los jugadores
				/*while(jugador != jug){
					if(!jug.isEliminado())
						//obtengo puntaje del jugador
						if(puntaje > mayor) //no hace falta controlar que sea menor que 21 porque se controla arriba al ser solo los NO eliminados
							ganador = jug;
						else
							jug = actual.getProximoJugador();
				}*/
				actual.setEventualGanador(ganador);
				actual.setFinalizada(true);
			}
				
			}else{
				//actual.setEventualGanador(jugador);
				actual.setFinalizada(true);
			}
				
				
		if(actual.isFinalizada())
			fac.BajarCartasAlMazo();
			
		
		} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		
		
		

		/**************************** REQUERIMIENTO 9 **************************/
		/*System.out.println("------ Requerimiento 9 ---------");
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
						DataJugador jugadoresPartida[] = fac.obtenerJugadores();
						int j=0;
						encontre = false;
						System.out.println("Jugador en turno");
						System.out.println("==============");
						while(j<jugadoresPartida.length && !encontre){
							if(jugadoresPartida[j].isEnturno()){
								System.out.println("Nombre: "+jugadoresPartida[j].getNombre());
								encontre = true;
							}
							else
								j++;
						}
						System.out.println("Eventual ganador");
						System.out.println("==============");
						System.out.println("Nombre: " + arregloPartidas[i].getEventualGanador().getNombre());
					}
					
				} 
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
			

			/**************************** REQUERIMIENTO 10 **************************/
			/*System.out.println("------ Requerimiento 10 ---------");
			codigo = "A13";
			try {
				fac = Facade.getInstance();
				if(!fac.ExistePartida(codigo))
					System.out.println("No existe ninguna partida con dicho codigo");
				else
				{
					DataListarJugadoresPartidas arregloJugadores[] = fac.listarJugadores();
					for(int i=0; i<arregloJugadores.length; i++){ 
						System.out.println("Jugadores de la partida: "+codigo);
						System.out.println("\n\nJugador numero"+i);
						System.out.println("Nombre: " + arregloJugadores[i].getNombre());
						System.out.println("Numero: " + arregloJugadores[i].getNumero());
						System.out.println("Puntaje: " + arregloJugadores[i].getPuntos());
					}
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		
		
		
		
		
		
		}//fin public void main
		
}
		
