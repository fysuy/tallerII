package Logica;

import java.io.Serializable;

public class Carta implements Serializable {
	private static final long serialVersionUID = 1L;
	public String palo;
	private String valor;
	private int valorEnJuego;
	
	public Carta(String palo, String valor, int valorEnJuego) {
		super();
		this.palo = palo;
		this.valor = valor;
		this.valorEnJuego = valorEnJuego;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		this.palo = palo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public int getValorEnJuego() {
		return valorEnJuego;
	}
	public void setValorEnJuego(int valorEnJuego) {
		this.valorEnJuego = valorEnJuego;
	}

}
