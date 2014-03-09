package Excepciones;
import java.io.Serializable;

public class Exceptiones extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public Exceptiones(String message) {
	        super(message);
	    }
}
