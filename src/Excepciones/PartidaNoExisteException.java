package Excepciones;
import java.io.Serializable;

public class PartidaNoExisteException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	 public PartidaNoExisteException(String message) {
	        super(message);
	    }
}
