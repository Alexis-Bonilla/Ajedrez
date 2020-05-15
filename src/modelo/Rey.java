package modelo;

public class Rey extends Ficha{
	
public Rey(char elColor, char elTipo) {
	super(elColor,elTipo);
	
}


public boolean sePuedeMover(int[]coordenadas) {
	boolean sePuede=false;
	int xEntrada=coordenadas[0];
	int yEntrada= coordenadas[1];
	int xSalida= coordenadas[2];
	int ySalida=coordenadas[3];
	if(xSalida-xEntrada==1) {
		if(ySalida-yEntrada==0) {
			sePuede=true;
		}
		else if(ySalida-yEntrada==-1) {
			sePuede=true;
		}
		else if(ySalida-yEntrada==1) {
			sePuede=true;
		}
		
	}
	else if(xSalida-xEntrada==-1) {
		if(ySalida-yEntrada==-1) {
			sePuede=true;
		}
		else if(ySalida-yEntrada==0) {
			sePuede=true;
		}
		else if(ySalida-yEntrada==1) {
			sePuede=true;
		}
	}
	else if(xSalida-xEntrada==0) {
		if(ySalida-yEntrada==-1) {
			sePuede=true;
		}
		else if(ySalida-yEntrada==1) {
			sePuede=true;
		}
	}
	
	
	
	
	
	
	
	
	
	
	return sePuede;
}
}
