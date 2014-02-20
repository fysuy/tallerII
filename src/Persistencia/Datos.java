package Persistencia;

import java.io.Serializable;

import Logica.*;

public class Datos implements Serializable {
	
	public Datos(Partidas partidas, Cartas mazo) {
		super();
		this._partidas = partidas;
		this._mazo = mazo;
	}
	
	public Datos() {
		super();
		this._partidas = new Partidas();
		this._mazo = new Cartas();
	}


	private Partidas _partidas;
	private Cartas _mazo;
	
	public Partidas getPartidas() {
		return _partidas;
	}

	public void setPartidas(Partidas partidas) {
		this._partidas = partidas;
	}

	public Cartas getMazo() {
		return _mazo;
	}

	public void setMazo(Cartas mazo) {
		this._mazo = mazo;
	}
}
