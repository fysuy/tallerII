package Fisica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Properties;

import Excepciones.PartidaNoExisteException;
import Logica.DataCrearNuevaPartida;
import Logica.Facade;
import Logica.IFacadeLogica;
import Logica.Partida;

public class Cliente2 {

	public static void main(String[] args) {
		
		try 
		{
			Properties p = new Properties();
			String nomArch = "config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/obj";
			IFacadeLogica fac = (IFacadeLogica) Naming.lookup(ruta);
			//llamamos los procedimientos que queramos, por ejemplo:

			DataCrearNuevaPartida dataCrearNuevaPartida;			
			String codigoPartida = "A13";		
			ArrayList<String> listaNombres = new ArrayList<String>();
			listaNombres.add("Luis");
			listaNombres.add("Tony");
			listaNombres.add("Dario");
			listaNombres.add("Japo");
			String[] arregloNombres = new String[listaNombres.size()];
			arregloNombres = listaNombres.toArray(arregloNombres);
		    
			dataCrearNuevaPartida = new DataCrearNuevaPartida(codigoPartida, arregloNombres);
			try 
			{
				fac = Facade.getInstance();
				fac.CrearNuevaPartida(dataCrearNuevaPartida);
			} 
			catch (Exception e) { e.printStackTrace(); }
			try {
				Partida par = fac.ObtenerPartida("A13");
				System.out.println("Codigo: "+par.getCodigo());
			} 
			catch (PartidaNoExisteException e) {
				e.printStackTrace();
			}	
			
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		catch (NotBoundException e) 
		{
			e.printStackTrace();
		}

	}

}
