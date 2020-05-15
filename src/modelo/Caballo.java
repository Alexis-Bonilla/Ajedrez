package modelo;

public class Caballo extends Ficha {
	public Caballo(char elColor, char elTipo) {
		super(elColor,elTipo);
	}
	public boolean sePuedeMover(int[]coordenadas) {
		int xEntrada=coordenadas[0];
		int yEntrada=coordenadas[1];
		int xSalida = coordenadas[2];
		int ySalida = coordenadas[3];
		boolean sePuede=false;
		if(xSalida-xEntrada==1) {
			if(ySalida-yEntrada==-2) {
				sePuede=true;
			}
			else if(ySalida-yEntrada==2) {
				sePuede=true;
			}
		}
		else if(xSalida-xEntrada==-1) {
			if(ySalida-yEntrada==-2) {
				sePuede=true;
			}
			else if(ySalida-yEntrada==2) {
				sePuede=true;
			}
		}
		else if(xSalida-xEntrada==-2) {
			if(ySalida-yEntrada==1) {
				sePuede=true;
			}
			else if(ySalida-yEntrada==-1) {
				sePuede=true;
			}
		}
		else if(xSalida-xEntrada==2) {
			if(ySalida-yEntrada==1) {
				sePuede=true;
			}
			else if(ySalida-yEntrada==-1) {
				sePuede=true;
			}
		}
		
		
		
		
		return sePuede;
	}
}
