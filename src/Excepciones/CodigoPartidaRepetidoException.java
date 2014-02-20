package Excepciones;
import java.io.Serializable;

public class CodigoPartidaRepetidoException extends Exception implements Serializable {
	 public CodigoPartidaRepetidoException(String message) {
	        super(message);
	    }
}
