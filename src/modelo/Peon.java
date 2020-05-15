package modelo;

public class Peon extends Ficha{
public Peon(char elColor, char elTipo) {
	super(elColor,elTipo);
}
@Override
public boolean sePuedeMover(int[] coordenadas){
	int xEntrada= coordenadas[0];
	int yEntrada=coordenadas[1];
	int xSalida= coordenadas[2];
	int ySalida= coordenadas[3];
	boolean puede = false;
	if(xSalida-xEntrada==1) {
		puede=true;
	}
	
	
	
	
	return puede;
}
}
