package Logica;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

import Excepciones.HayPartidasIniciadasException;
import Excepciones.PartidaNoExisteException;

public class Partidas implements Serializable {
	
		private TreeMap<String, Partida> tm; 	
		public Partidas()
		{ 			
			tm = new TreeMap<String, Partida> ();
		}
		
		public boolean member (String clave)
		{ 
			return tm.containsKey(clave); 
		}
		
		public Partida find (String clave) throws PartidaNoExisteException
		{ 			
			return  tm.get(clave);
		}
		
		public void insert (String clave, DataCrearNuevaPartida dataCrearNuevaPartida)
		{ 
			Jugadores jugadores = new Jugadores();
			for(int i = 0; i < dataCrearNuevaPartida.getArregloNombres().length; i++)
			{
				Jugador jugador = new Jugador(i + 1, dataCrearNuevaPartida.getArregloNombres()[i], 0, false, false, null);
				jugadores.insert(i, jugador);
			}
			Partida partida = new Partida(clave, null, null, false, false, jugadores);
			tm.put(clave, partida); 
					
		}
		
		public String[] listarCodigosPartidas()
		{
			String arregloCodigosPartidas[] = new String[tm.size()]; 
			Iterator <Partida> iteradorPartidas = tm.values().iterator();
			
			int i = 0;
			while (iteradorPartidas.hasNext())
			{ 
				Partida partida = iteradorPartidas.next();
				arregloCodigosPartidas[i] = partida.getCodigo();
				i++;
			}
			
			return arregloCodigosPartidas;
		}

		public void IniciarNuevaPartida(String codigo) throws PartidaNoExisteException {
			
			Partida partida;
			try {
				partida = this.find(codigo);
				partida.setEnCurso(true);
				partida.getJugadores().find(0).setEnturno(true);
				
			} 
			catch (PartidaNoExisteException e) { throw e; } 


		}

		public boolean HayAlgunaPartidaIniciada() {

			DataPartida arregloPartidas[] = new DataPartida[tm.size()]; 
			Iterator <Partida> iteradorPartidas = tm.values().iterator();
			boolean hay = false;

			while (iteradorPartidas.hasNext() && !hay)
			{ 
				hay = iteradorPartidas.next().isEnCurso();
			}

			return hay;
		}
		
		
		public boolean esVacio(){
			return(tm.isEmpty());
		}
		
		 public DataPartida[] listarPartidas()
         {
                 DataPartida arregloPartidas[] = new DataPartida[tm.size()];
                 Iterator <Partida> iteradorPartidas = tm.values().iterator();
                 
                 int i = 0;
                 while (iteradorPartidas.hasNext())
                 {
                         Partida partida = iteradorPartidas.next();
                         arregloPartidas[i] = new DataPartida(partida.getCodigo(), partida.getProximoJugador(), partida.getEventualGanador(), partida.isEnCurso(), partida.isFinalizada(), partida.getJugadores());
                         i++;
                 }
                 
                 return arregloPartidas;
         }

}
