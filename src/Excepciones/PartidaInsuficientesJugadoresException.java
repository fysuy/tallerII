package Excepciones;
import java.io.Serializable;

public class PartidaInsuficientesJugadoresException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	 public PartidaInsuficientesJugadoresException(String message) {
	        super(message);
	    }
}
