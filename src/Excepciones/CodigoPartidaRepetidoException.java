package Excepciones;
import java.io.Serializable;

public class CodigoPartidaRepetidoException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public CodigoPartidaRepetidoException(String message) {
	        super(message);
	    }
}
