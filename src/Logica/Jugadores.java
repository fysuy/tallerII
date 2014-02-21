package Logica;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class Jugadores implements Serializable {
	
		protected Hashtable<Integer, Jugador> ht; 
		
		public Jugadores()
		{ 			
			ht = new Hashtable<Integer, Jugador>(); 
		}
		
		public boolean member (int clave)
		{ 
			return ht.containsKey(clave); 
		}
		
		public Jugador find (int clave)
		{ 
			return ht.get(clave); 
		}
		
		public void insert (int clave, Jugador jugador)
		{ 
			ht.put(clave, jugador); 
		}
		
		public void delete (int clave)
		{ 
			ht.remove(clave);
		}
		
		public DataVisualizarCartas[] VisualizarCartas() {
			
			DataVisualizarCartas arregloDataVisualizarCartas[] = new DataVisualizarCartas[20]; 
			
			List<DataVisualizarCartas> arrAsList = Arrays.asList(arregloDataVisualizarCartas);
			Iterator<DataVisualizarCartas> iteradorCartas = arrAsList.iterator();
		
			int i = 0;
			while (iteradorCartas.hasNext())
			{ 
				DataVisualizarCartas dataVisualizarCartas = iteradorCartas.next();
				arregloDataVisualizarCartas[i] = new DataVisualizarCartas(dataVisualizarCartas.getNumero(), dataVisualizarCartas.getNombre(), dataVisualizarCartas.getPuntos(), dataVisualizarCartas.getCartas());
				i++;
			}
						
			return arregloDataVisualizarCartas;
		}
		
		public DataListarJugadoresPartidas[] listarJugadores()
		{
			DataListarJugadoresPartidas arregloJugadores[] = new DataListarJugadoresPartidas[ht.size()]; 
			Iterator <Jugador> iteradorJugadores = ht.values().iterator();
			
			int i = 0;
			while (iteradorJugadores.hasNext())
			{ 
				Jugador jugador = iteradorJugadores.next();
				arregloJugadores[i] = new DataListarJugadoresPartidas(jugador.getNumero(),jugador.getNombre(), jugador.getPuntos());
				i++;
			}
			
			return arregloJugadores;
		}


}
