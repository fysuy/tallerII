package Excepciones;
import java.io.Serializable;

public class PartidaNoHayEnCursoException extends Exception implements Serializable {
	 public PartidaNoHayEnCursoException(String message) {
	        super(message);
	    }
}
