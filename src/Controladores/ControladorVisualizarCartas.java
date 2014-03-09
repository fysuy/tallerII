package Controladores;

import java.rmi.RemoteException;

import Logica.DataVisualizarCartas;
import Logica.Facade;
import Logica.IFacadeLogica;

public class ControladorVisualizarCartas {
	private IFacadeLogica fac;
	private DataVisualizarCartas[] dvc;
	
	public ControladorVisualizarCartas(){
		super();
	}
	
	public DataVisualizarCartas[] Visualizar(){
		try {
			fac = Facade.getInstance();
			dvc = fac.VisualizarCartas();
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dvc;
	}
	
	
	
	
	
	
	
	
	
	
	
}
