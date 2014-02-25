package Logica;
import java.io.Serializable;


public class DataVisualizarCartas implements Serializable {
	private static final long serialVersionUID = 1L;
	private int numero;
	private String nombre;
	private int puntos;
	private Cartas cartas;
	
	public DataVisualizarCartas(int numero, String nombre, int puntos, Cartas cartas) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.puntos = puntos;
		this.cartas = cartas;
	}
	
	public Cartas getCartas() {
		return cartas;
	}

	public int getNumero() {
		return numero;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getPuntos() {
		return puntos;
	}

}
