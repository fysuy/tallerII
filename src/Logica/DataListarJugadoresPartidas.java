package Logica;

public class DataListarJugadoresPartidas {
	private int numero;
	private String nombre;
	private int puntos;
	
	
	public DataListarJugadoresPartidas(int numero, String nombre, int puntos) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.puntos = puntos;
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
