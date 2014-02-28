package Logica;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeMap;

import Excepciones.PartidaNoExisteException;

public class Partidas implements Serializable {

	private static final long serialVersionUID = 1L;
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
				jugadores.insert(jugador);
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
			Iterator <Partida> iteradorPartidas = tm.values().iterator();
			boolean hay = false;

			while (iteradorPartidas.hasNext() && !hay)
			{ 
				hay = iteradorPartidas.next().isEnCurso();
			}

			return hay;
		}
		
		public boolean ExisteCodigo(String codigo) 
		{
			Iterator <Partida> iteradorPartidas = tm.values().iterator();
			boolean existe = false;
			String codigoPartida = "";
			
			while (iteradorPartidas.hasNext() && !existe)
			{ 
				codigoPartida = iteradorPartidas.next().getCodigo();
				if(codigoPartida == codigo)
				{
					existe = true;
				}
			}

			return existe;
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

		public Partida getPartidaEnCurso()
		{
			Iterator <Partida> iteradorPartidas = tm.values().iterator();
			Partida result = null;
			boolean found = false;
			
			while(iteradorPartidas.hasNext() && !found)
			{
				result = iteradorPartidas.next();
				if(result.isEnCurso())
					found = true;
			}
			
			return result;
		}
		
		public void MarcarProximoEnTurno(Partida partidaEnCusrso) {

			Jugadores jugadores = partidaEnCusrso.getJugadores();
			DataJugador arregloDataJugadores[] = jugadores.obtenerJugadores();
			Jugador jugador;
			
			boolean encontre = false, salir = false;
			int numeroJugador = partidaEnCusrso.getProximoJugador().getNumero();
			int i = numeroJugador;
			
			while(!encontre)
			{
				if(arregloDataJugadores.length == numeroJugador)
					i = 0;
				else
					i++;
				
				if(!arregloDataJugadores[i].isEliminado())
				{
					if(arregloDataJugadores[i].getNumero() == numeroJugador)
						salir = true;
					else
					{
						jugador = new Jugador(
								arregloDataJugadores[i].getNumero(), 
								arregloDataJugadores[i].getNombre(), 
								arregloDataJugadores[i].getPuntos(), 
								arregloDataJugadores[i].isEnturno(), 
								arregloDataJugadores[i].isEliminado(), 
								arregloDataJugadores[i].getCartas());
						jugador.setEnturno(true);
						encontre = true;
					}					
			    }
			
		    }
	   }
	   public int CantidadJugadoresNoEliminados(DataPartida dataPartidaActual){
		   
		   Jugadores jugadores = dataPartidaActual.getJugadores();		   
		   DataJugador dataJugador[] = jugadores.obtenerJugadores();
		   
		   int cantidad = 0;
		   for( int i=0; i<dataJugador.length ; i ++ )
			{ 
				if(!dataJugador[i].isEliminado())
				{
					cantidad++;
				}
			} 		   
		   return cantidad;
	   }

	public boolean TieneMayorPuntaje(DataPartida dataPartidaActual, int puntos) {
		  
		Jugadores jugadores = dataPartidaActual.getJugadores();		   
		DataJugador dataJugador[] = jugadores.obtenerJugadores();
		
		boolean esMayorPuntaje = true;
		for( int i=0; i<dataJugador.length ; i ++ )
		{ 
			if(dataJugador[i].getPuntos() < 21 && dataJugador[i].getPuntos() > puntos)
			{
				esMayorPuntaje = false;
			}
		} 		   
		return esMayorPuntaje;
	}
}
