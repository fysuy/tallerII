package Excepciones;
import java.io.Serializable;

public class PartidaNoHayEnCursoException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	 public PartidaNoHayEnCursoException(String message) {
	        super(message);
	    }
}
