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

public class Client {
	private IFacadeLogica fac;
	
	public Client()
	{
		try 
		{
			Properties p = new Properties();
			String nomArch = "config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/obj";
			this.fac = (IFacadeLogica)Naming.lookup(ruta);			
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

	public IFacadeLogica getFacade()
	{
		return this.fac;
	}

}
