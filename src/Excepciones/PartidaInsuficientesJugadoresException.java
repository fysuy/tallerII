package Excepciones;
import java.io.Serializable;

public class PartidaInsuficientesJugadoresException extends Exception implements Serializable {
	 public PartidaInsuficientesJugadoresException(String message) {
	        super(message);
	    }
}
