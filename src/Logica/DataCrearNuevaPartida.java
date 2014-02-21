package Logica;
import java.io.Serializable;


public class DataCrearNuevaPartida implements Serializable {
	private String codigo;
	private String arregloNombres[];
		
	public DataCrearNuevaPartida(String codigo, String[] arregloNombres) {
		super();
		this.codigo = codigo;
		this.arregloNombres = arregloNombres;
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String[] getArregloNombres() {
		return arregloNombres;
	}
	public void setArregloNombres(String[] arregloNombres) {
		this.arregloNombres = arregloNombres;
	}
	
	
}
