package PresentacionCliente;

import Fisica.Client;
import Logica.IFacadeLogica;

public class FacadeDispatcher {
	private Client cliente;
	
	public FacadeDispatcher()
	{
		if(cliente == null)
			cliente = new Client();
	}
	
	public IFacadeLogica getFacade()
	{
		return cliente.getFacade();
	}
}
