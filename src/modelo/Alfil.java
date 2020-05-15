package modelo;

public class Alfil extends Ficha{
public Alfil(char elColor, char elTipo) {
	super(elColor,elTipo);
	
}
public boolean sePuedeMover(int[]coordenadas) {
	int xEntrada=coordenadas[0];
	int yEntrada= coordenadas[1];
	int xSalida= coordenadas[2];
	int ySalida= coordenadas[3];
	boolean sePuede=false;
	for (int i = 0; i <8 ; i++) {
		if(xSalida-xEntrada==xEntrada+i&&ySalida-yEntrada==yEntrada-i) {
			sePuede=true;
		}
		else if(xSalida-xEntrada==xEntrada+i&&ySalida-yEntrada==yEntrada+i) {
			sePuede=true;
		}
		else if(xSalida-xEntrada==xEntrada-1&&ySalida-yEntrada==yEntrada-i) {
			sePuede=true;
		}
		else if(xSalida-xEntrada==xEntrada-i&&ySalida-yEntrada==yEntrada+i) {
			sePuede=true;
		}
	}
	
	
	return false;
}
}
