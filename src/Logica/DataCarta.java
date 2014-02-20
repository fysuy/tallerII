package Logica;

import java.io.Serializable;

public class DataCarta implements Serializable {
	private String palo;
	private String valor;
	private int valorEnJuego;
	
	public DataCarta(String palo, String valor, int valorEnJuego) {
		super();
		this.palo = palo;
		this.valor = valor;
		this.valorEnJuego = valorEnJuego;
	}
	public String getPalo() {
		return palo;
	}

	public String getValor() {
		return valor;
	}

	public int getValorEnJuego() {
		return valorEnJuego;
	}

	

}
