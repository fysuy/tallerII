package Controladores;

import Logica.DataCrearNuevaPartida;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorNuevaPartida {

	private IFacadeLogica fac;
	private DataCrearNuevaPartida dataCrearNuevaPartida;
	
	public ControladorNuevaPartida(){
		super();
	}
	
	public void NuevaPartida(String codigoPartida, String[] arregloNombres){
		
		try 
		{			
			dataCrearNuevaPartida = new DataCrearNuevaPartida(codigoPartida, arregloNombres);
			fac = Facade.getInstance();
			fac.CrearNuevaPartida(dataCrearNuevaPartida);
		}
		catch (Exception e) { e.printStackTrace(); }		
	}
}
