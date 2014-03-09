package Excepciones;
import java.io.Serializable;

public class HayPartidasIniciadasException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	 public HayPartidasIniciadasException(String message) {
	        super(message);
	    }
}
