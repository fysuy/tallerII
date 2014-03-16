package Excepciones;
import java.io.Serializable;

public class ElJugadorNoTieneCartasException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public ElJugadorNoTieneCartasException(String message) {
	        super(message);
	    }
}
