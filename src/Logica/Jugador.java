package Logica;
import java.io.Serializable;

public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;
	private int numero;
	private String nombre;
	private int puntos;
	private boolean enturno;
	private boolean eliminado;
	private Cartas cartas;
	
	public Jugador(int numero, String nombre, int puntos, boolean enturno,
	    boolean eliminado, Cartas cartas) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.puntos = puntos;
		this.enturno = enturno;
		this.eliminado = eliminado;
		this.cartas = cartas;
	}
	
	public Cartas getCartas() {
		return cartas;
	}
	
	public void setCartas(Cartas cartas){
		this.cartas = cartas;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public boolean isEnturno() {
		return enturno;
	}
	public void setEnturno(boolean enturno) {
		this.enturno = enturno;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
}
