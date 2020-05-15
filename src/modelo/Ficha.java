package modelo;

public class Ficha {
	
	//Atributos y constantes
	public static final char COLOR_BLANCO = 'B';
	public static final char COLOR_NEGRO = 'N';
	public static final char ALFIL = 'A';
	public static final char DAMA = 'D';
	public static final char TORRE = 'T';
	public static final char REY = 'R';
	public static final char PEON = 'P';
	public static final char CABALLO = 'C';
	private char color;
	private char tipo;

	// Metodo constructor de la chase, de encarla de inicializar los atributos
	public Ficha( char elColor, char elTipo) {

		color = elColor;
		tipo= elTipo;
	}
public boolean sePuedeMover(int[] coordenadas) {
	return false;
}
// metodo encargado de retornar el atributo color
public char getColor() {
	return color;
}

// metodo encargado de retornar el atributo tipo
public char getTipo() {
	return tipo;
}


}

