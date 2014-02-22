package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import Logica.*;

public class Respaldo {
	private Datos _datos;
	
	public Datos getDatos() {
		return _datos;
	}

	public void setDatos(Datos datos) {
		this._datos = datos;
	}

	public String getRuta() throws IOException
	{
		try
		{
			Properties p = new Properties();
			String f = "config/app.properties";
			p.load (new FileInputStream (f));
			return p.getProperty("rutaRespaldo");
		}
		catch (IOException e){ throw e; }
	}
	
	public Respaldo()
	{
		this._datos = new Datos();
	}
	
	public void Respaldar(Partidas partidas, Cartas mazo) throws IOException
	{
		_datos.setPartidas(partidas);
		_datos.setMazo(mazo);
		
		try
		{
			FileOutputStream f = new FileOutputStream(getRuta());
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(_datos);
			o.close();
			f.close();
		}
		catch(IOException e){ throw e; }
	}
	
	public Datos Recuperar() throws IOException, ClassNotFoundException
	{
		try
		{
			FileInputStream f = new FileInputStream(getRuta());
			ObjectInputStream o = new ObjectInputStream(f);
			_datos = (Datos) o.readObject();
			o.close();
			f.close();
			
			return _datos;
		}
		catch(IOException e){ throw e; }
		catch(ClassNotFoundException e){ throw e; }
	}
}
