package Fisica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import Logica.Facade;

public class Servidor {
	
	
	public static void main (String [] args)
	{
		try
		{
			Properties p = new Properties();
			Facade fac = new Facade();
			String nomArch = "config/config.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			int port = Integer.parseInt(puerto);
			LocateRegistry.createRegistry(port);
			String ruta = "//" + ip + ":" + puerto + "/obj";
			System.out.println("antes de publicar");
			Naming.rebind(ruta, fac);
			System.out.println("despues de publicar");
			
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	

}
