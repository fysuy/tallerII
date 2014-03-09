package Logica;

import java.io.Serializable;

public class DataRealizarJugada implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private boolean pideCarta;
	private DataPartida dataPartida;
	
	
	public DataRealizarJugada(boolean pideCarta, DataPartida dataPartida) {
		super();
		this.pideCarta = pideCarta;
		this.dataPartida = dataPartida;
	}
	public boolean isPideCarta() {
		return pideCarta;
	}
	public void setPideCarta(boolean pideCarta) {
		this.pideCarta = pideCarta;
	}
	public DataPartida getDataPartida() {
		return dataPartida;
	}
	public void setDataPartida(DataPartida dataPartida) {
		this.dataPartida = dataPartida;
	}
		
		
}
