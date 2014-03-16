package Logica;

import java.io.Serializable;
import java.util.Random;

public class Cartas implements Serializable {

	private static final long serialVersionUID = 1L;
	static final int cantidadCartas = 48;
	Carta arregloCartas[];
	int tope;
	
	static final String[] valor = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};
    static final String[] palo = {"Picas", "Corazones", "Diamante", "Trebol"};
		
	public Cartas()
	{ 
		arregloCartas = new Carta[cantidadCartas];
	}
	
	boolean hayCartas(Cartas cartas){
		return (cartas.tope != 0);
	}
	
	void InicializarTope ()//Cartas cartas
	{
		//cartas.tope = 0;
		this.tope = 0;
	}

	int darTopeDelArreglo()
	{
	    return this.tope;
	}

	void InsertarCarta (Carta carta)//(Cartas cartas, Carta carta)
	{
	    //int topeArre = darTopeDelArreglo(cartas);
	    this.arregloCartas[tope] = carta;	    
	    this.tope++;// = tope++;
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
	
	public int darCarta(Jugador jugador){
		
		Carta carta = arregloCartas[this.tope - 1];
		borrarCarta();
		Cartas cartas = jugador.getCartas();
		cartas.InsertarCarta(carta);
		return carta.getValorEnJuego();
	}
	
	
	

}

