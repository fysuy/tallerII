package Logica;

public class DataListarTodoJugadoresPartidas {
	private static final long serialVersionUID = 1L;
	private int numero;
	private String nombre;
	private int puntos;
	private boolean enturno;
	private boolean eliminado;
	private Cartas cartas;
	
	
	public DataListarTodoJugadoresPartidas(int numero, String nombre, int puntos) {
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
		
	public int getNumero() {
		return numero;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public boolean isEnturno() {
		return enturno;
	}
	
	public boolean isEliminado() {
		return eliminado;
	}
	

}
