package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class Cartas implements Serializable {
	
	static final int cantidadCartas = 52;
	Carta arregloCartas[];
	int tope;
	
	static final String[] valor = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static final String[] palo = {"Picas", "Corazones", "Diamantes", "Treboles"};
		
	public Cartas()
	{ 
		arregloCartas = new Carta[cantidadCartas];
	}
	
	boolean hayCartas(Cartas cartas){
		return (cartas.tope != 0);
	}
	
	void InicializarTope (Cartas cartas)
	{
		cartas.tope = 0;
	}

	int darTopeDelArreglo(Cartas cartas)
	{
	    return cartas.tope;
	}

	void InsertarCarta (Cartas cartas, Carta carta)
	{
	    int topeArre = darTopeDelArreglo(cartas);
	    cartas.arregloCartas[topeArre] = carta;	    
	    cartas.tope = topeArre + 1;
	}


	void MostrarArreglo (Cartas cartas)
	{

	    for (int i=0; i<cartas.tope; i++)
	    {
	       // MostrarLinea(cartas.arre[i]);

	    }
	}

	public void BajarCartasAlMazo() {
		
	        for (int i = 0; i < palo.length; i++) {
	            for (int j = 0; j < valor.length; j++) {
	            	this.arregloCartas[tope] = new Carta(palo[i], valor[j], j+1);
	            	this.tope++;
	           
	            }
	        }	
	}

	
	public boolean MazoCreado() {
		
		System.out.println("El tope del mazo es: " + this.tope);
		if(this.tope == 0)
			return false;
		else
			return true;
	}
	
	public void BarajarCartas() {

		Random random = new Random(System.currentTimeMillis());
		int index;
		Carta carta;
        for(int i = arregloCartas.length - 1; i > 0; i--){
            index = random.nextInt(i + 1);
            carta = arregloCartas[i];
            arregloCartas[i] = arregloCartas[index];
            arregloCartas[index] = carta;
        }
		
	}
	
	public void borrarCarta(){
		this.tope--;
	}
	
	public Jugador darCarta(Jugador jugador){
		//obtengo la carta de arriba y la borro del mazo
		Carta carta = arregloCartas[this.tope];
		this.borrarCarta();
		Cartas cartas = jugador.getCartas();
		//asigno la carta al jugador
		cartas.tope++;
		cartas.arregloCartas[cartas.tope] = carta;
		jugador.setCartas(cartas);
		return jugador;
	}
	

}

