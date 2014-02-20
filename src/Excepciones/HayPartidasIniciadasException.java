package Excepciones;
import java.io.Serializable;

public class HayPartidasIniciadasException extends Exception implements Serializable {
	 public HayPartidasIniciadasException(String message) {
	        super(message);
	    }
}
