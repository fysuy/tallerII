package Logica;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class Jugadores implements Serializable {
	private static final long serialVersionUID = 1L;
	
		protected Hashtable<Integer, Jugador> ht; 
		
		public Jugadores()
		{ 			
			ht = new Hashtable<Integer, Jugador>(); 
		}
		
		public boolean member (Integer clave)
		{ 
			return ht.containsKey(clave); 
		}
		
		public Jugador find (Integer clave)
		{ 
			return ht.get(clave); 
		}
		
		public Jugador findByName (String nombre)
		{ 
			Iterator<Jugador> iter = ht.values().iterator();
			Jugador jugador = null;
			boolean found = false;
			
			while(iter.hasNext() && !found)
			{
				jugador = iter.next();
				if(jugador.getNombre() == nombre)
					found = true;
			}
			
			return jugador;
		}
		
		public void insert (Jugador jugador)
		{ 
			ht.put(jugador.getNumero(), jugador); 
		}
		
		public void delete (String clave)
		{ 
			ht.remove(clave);
		}
		
		public DataVisualizarCartas[] VisualizarCartas() {
			DataVisualizarCartas arregloDataVisualizarCartas[] = new DataVisualizarCartas[20]; 
			List<DataVisualizarCartas> arrAsList = Arrays.asList(arregloDataVisualizarCartas);
			Iterator<DataVisualizarCartas> iteradorCartas = arrAsList.iterator();
			DataVisualizarCartas dataVisualizarCartas;
			int i = 0;

			while (iteradorCartas.hasNext())
			{ 
				dataVisualizarCartas = iteradorCartas.next();
				//arregloDataVisualizarCartas[i] = new DataVisualizarCartas(dataVisualizarCartas.getNumero(), dataVisualizarCartas.getNombre(), dataVisualizarCartas.getPuntos(), dataVisualizarCartas.getCartas());
				arregloDataVisualizarCartas[i] = dataVisualizarCartas;
				i++;
			}	
			return arregloDataVisualizarCartas;
		}
		
		public DataListarJugadoresPartidas[] listarJugadores()
		{
			Facade fac;
			try {
				fac = Facade.getInstance();
				Partida par = fac.PartidaEnCurso();
				Jugadores jug = par.getJugadores();
				DataListarJugadoresPartidas data[] = jug.obtenerJugadoresPartida();
				return data;
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
		public DataJugador[] obtenerJugadores()
		{
			DataJugador arregloJugadores[] = new DataJugador[ht.size()]; 
			Iterator <Jugador> iteradorJugadores = ht.values().iterator();
			int i = 0;
			while (iteradorJugadores.hasNext())
			{ 
				Jugador jugador = iteradorJugadores.next();
				arregloJugadores[i] = new DataJugador(jugador.getNumero(), jugador.getNombre(), jugador.getPuntos(), jugador.isEnturno(), jugador.isEliminado(), jugador.getCartas());
				i++;
			}
			return arregloJugadores;
		}
		
		public DataListarJugadoresPartidas[] obtenerJugadoresPartida()
		{
			DataListarJugadoresPartidas arregloJugadores[] = new DataListarJugadoresPartidas[ht.size()]; 
			Iterator <Jugador> iteradorJugadores = ht.values().iterator();
			int i = 0;
			while (iteradorJugadores.hasNext())
			{ 
				Jugador jugador = iteradorJugadores.next();
				arregloJugadores[i] = new DataListarJugadoresPartidas(jugador.getNumero(), jugador.getNombre(), jugador.getPuntos());
				i++;
			}
			return arregloJugadores;
		}


}
