package Logica;

import java.io.Serializable;

public class DataPartida implements Serializable {
	
	private String codigo;
	private Jugador proximoJugador;
	private Jugador eventualGanador;
	private boolean enCurso;
	private boolean finalizada;
	private Jugadores jugadores;
	
	public DataPartida(String codigo, Jugador proximoJugador,
			Jugador eventualGanador, boolean enCurso, boolean finalizada,
			Jugadores jugadores) {
		super();
		this.codigo = codigo;
		this.proximoJugador = proximoJugador;
		this.eventualGanador = eventualGanador;
		this.enCurso = enCurso;
		this.finalizada = finalizada;
		this.jugadores = jugadores;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Jugador getProximoJugador() {
		return proximoJugador;
	}
	public void setProximoJugador(Jugador proximoJugador) {
		this.proximoJugador = proximoJugador;
	}
	public Jugador getEventualGanador() {
		return eventualGanador;
	}
	public void setEventualGanador(Jugador eventualGanador) {
		this.eventualGanador = eventualGanador;
	}
	public boolean isEnCurso() {
		return enCurso;
	}
	public void setEnCurso(boolean enCurso) {
		this.enCurso = enCurso;
	}
	public boolean isFinalizada() {
		return finalizada;
	}
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	public Jugadores getJugadores() {
		return jugadores;
	}
	public void setJugadores(Jugadores jugadores) {
		this.jugadores = jugadores;
	}

	
	
	
}
