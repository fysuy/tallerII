package Excepciones;
import java.io.Serializable;

public class LoginNombreException extends Exception implements Serializable {
	 public LoginNombreException(String message) {
	        super(message);
	    }
}
