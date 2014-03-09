package Logica;

import java.io.Serializable;

public class Monitor implements Serializable{

	private static final long serialVersionUID = 1L;
	private static int cantLectores;
	private static boolean escribiendo;
	
	public synchronized void comienzoLectura(){
		while(escribiendo)
			try {
				System.out.println("comienzoLectura Esta esperando");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		cantLectores++;
	}
	
	public synchronized void terminoLectura(){
		notify();
		cantLectores--;
	}
	
	public synchronized void comienzoEscritura(){
		while(escribiendo)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		escribiendo = true;
	}
	
	public synchronized void terminoEscritura(){
		notify();
		escribiendo = false;
	}
	
	public int getCantLectores(){
		return cantLectores;
	}
	
	public boolean getEscribiendo(){
		return escribiendo;
	}
	
	
	

}
