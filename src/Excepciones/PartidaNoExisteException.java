package Excepciones;
import java.io.Serializable;

public class PartidaNoExisteException extends Exception implements Serializable {
	 public PartidaNoExisteException(String message) {
	        super(message);
	    }
}
