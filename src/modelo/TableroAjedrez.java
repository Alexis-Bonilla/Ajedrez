package modelo;

public class TableroAjedrez {
	//atributos de la clase
	
	private char turno;
	private Ficha[][] elTablero;
	//Metodo constructor de la clase, se encarga de inicializar los atributos
	// e invocar los metodos para inicializar la matriz de fichas
	public TableroAjedrez() {
		turno=Ficha.COLOR_BLANCO;
		elTablero= new Ficha[9][9];
		inicializarFichasBlancas();
		inicializarFichasNegras();
		inicializarLetrasYNumeros();
	}
	
	//metodo encargado de retornar el valor del atributo turno
	public char getTurno() {
		return turno;
	}
	//metodo encargado de retornar la matriz de fichas
	public Ficha[][] getElTablero() {
		return elTablero;
	}
	// metodo para modificar el atributo turno
	public void setTurno(char turno) {
		this.turno = turno;
	}
	//Metodo encargado de inicializar las fichas de coor blanco en la matriz de fichas
	public void inicializarFichasBlancas() {
		
		elTablero[1][1]= new Peon(Ficha.COLOR_NEGRO,Ficha.PEON);
		elTablero[1][2]= new Peon(Ficha.COLOR_NEGRO,Ficha.PEON);
		elTablero[1][3]= new Peon(Ficha.COLOR_NEGRO,Ficha.PEON);
		elTablero[1][4]= new Peon(Ficha.COLOR_NEGRO,Ficha.PEON);
		elTablero[1][5]= new Peon(Ficha.COLOR_NEGRO,Ficha.PEON);
		elTablero[1][6]= new Peon(Ficha.COLOR_NEGRO,Ficha.PEON);
		elTablero[1][7]= new Peon(Ficha.COLOR_NEGRO,Ficha.PEON);
		elTablero[1][8]= new Peon(Ficha.COLOR_NEGRO,Ficha.PEON);
		
		elTablero[0][1]= new Torre(Ficha.COLOR_NEGRO,Ficha.TORRE);
		elTablero[0][2]= new Caballo(Ficha.COLOR_NEGRO,Ficha.CABALLO);
		elTablero[0][3]= new Alfil(Ficha.COLOR_NEGRO,Ficha.ALFIL);
		elTablero[0][4]= new Rey(Ficha.COLOR_NEGRO,Ficha.REY);
		elTablero[0][5]= new Dama(Ficha.COLOR_NEGRO,Ficha.DAMA);
		elTablero[0][6]= new Alfil(Ficha.COLOR_NEGRO,Ficha.ALFIL);
		elTablero[0][7]= new Caballo(Ficha.COLOR_NEGRO,Ficha.CABALLO);
		elTablero[0][8]= new Torre(Ficha.COLOR_NEGRO,Ficha.TORRE);
	}
	//Metodo encargado de inicializar las fichas de coor negro en la matriz de fichas
	public void inicializarFichasNegras() {
		
		elTablero[6][1]= new Peon(Ficha.COLOR_BLANCO,Ficha.PEON);
		elTablero[6][2]= new Peon(Ficha.COLOR_BLANCO,Ficha.PEON);
		elTablero[6][3]= new Peon(Ficha.COLOR_BLANCO,Ficha.PEON);
		elTablero[6][4]= new Peon(Ficha.COLOR_BLANCO,Ficha.PEON);
		elTablero[6][5]= new Peon(Ficha.COLOR_BLANCO,Ficha.PEON);
		elTablero[6][6]= new Peon(Ficha.COLOR_BLANCO,Ficha.PEON);
		elTablero[6][7]= new Peon(Ficha.COLOR_BLANCO,Ficha.PEON);
		elTablero[6][8]= new Peon(Ficha.COLOR_BLANCO,Ficha.PEON);
		
		elTablero[7][1]= new Torre(Ficha.COLOR_BLANCO,Ficha.TORRE);
		elTablero[7][2]= new Caballo(Ficha.COLOR_BLANCO,Ficha.CABALLO);
		elTablero[7][3]= new Alfil(Ficha.COLOR_BLANCO,Ficha.ALFIL);
		elTablero[7][4]= new Dama(Ficha.COLOR_BLANCO,Ficha.DAMA);
		elTablero[7][5]= new Rey(Ficha.COLOR_BLANCO,Ficha.REY);
		elTablero[7][6]= new Alfil(Ficha.COLOR_BLANCO,Ficha.ALFIL);
		elTablero[7][7]= new Caballo(Ficha.COLOR_BLANCO,Ficha.CABALLO);
		elTablero[7][8]= new Torre(Ficha.COLOR_BLANCO,Ficha.TORRE);
	}
	//Metodo encargado de inicializar las letras y los numeros de las coordenadas en la matriz de fichas
	public void inicializarLetrasYNumeros() {
		elTablero[0][0]= new Ficha('L','a');
		elTablero[1][0]= new Ficha('L','b');
		elTablero[2][0]= new Ficha('L','c');
		elTablero[3][0]= new Ficha('L','d');
		elTablero[4][0]= new Ficha('L','e');
		elTablero[5][0]= new Ficha('L','f');
		elTablero[6][0]= new Ficha('L','g');
		elTablero[7][0]= new Ficha('L','h');


		elTablero[8][1]= new Ficha('n','1');
		elTablero[8][2]= new Ficha('n','2');
		elTablero[8][3]= new Ficha('n','3');
		elTablero[8][4]= new Ficha('n','4');
		elTablero[8][5]= new Ficha('n','5');
		elTablero[8][6]= new Ficha('n','6');
		elTablero[8][7]= new Ficha('n','7');
		elTablero[8][8]= new Ficha('n','8');

	}
	// Metodo encargado de rotar 90 grados a la derecha la matriz de fichas
	public void rotar90Grados() {
		int c=elTablero.length;
		Ficha[][] matrizRotada=new Ficha[9][9];
		for (int i = 0; i < c; i++) 
		{
		for(int j = 0; j < c; j++)
		{
		matrizRotada [i][j] = elTablero [c-1-j][i]; 
		} 
	}
		 elTablero=matrizRotada;
	}
	//Metodo encargado de mover una ficha de la matriz de acuerdo a un String que
	// representa las coordenadas del movimiento
	public void moverFicha(String coordenadas) {
		Ficha aMover=null;
	if(turno==Ficha.COLOR_BLANCO) {
		int coordenadaXEntrada=cambiarCoordenadaBlanco(coordenadas.charAt(0));
		int coordenadaYEntrada=cambiarCoordenadaBlanco(coordenadas.charAt(1));
		int coordenadaXSalida=cambiarCoordenadaBlanco(coordenadas.charAt(2));
		int coordenadaYSalida=cambiarCoordenadaBlanco(coordenadas.charAt(3));

		
		 aMover= elTablero[coordenadaXEntrada][coordenadaYEntrada];
		elTablero[coordenadaXEntrada][coordenadaYEntrada]=null;
		elTablero[coordenadaXSalida][coordenadaYSalida]=null;
		elTablero[coordenadaXSalida][coordenadaYSalida]=aMover;
	}
	else {
		int coordenadaXEntrada=cambiarCoordenadaNegro(coordenadas.charAt(0));
		int coordenadaYEntrada=cambiarCoordenadaNegro(coordenadas.charAt(1));
		int coordenadaXSalida=cambiarCoordenadaNegro(coordenadas.charAt(2));
		int coordenadaYSalida=cambiarCoordenadaNegro(coordenadas.charAt(3));

		
		 aMover= elTablero[coordenadaXEntrada][coordenadaYEntrada];
		elTablero[coordenadaXEntrada][coordenadaYEntrada]=null;
		elTablero[coordenadaXSalida][coordenadaYSalida]=null;
		elTablero[coordenadaXSalida][coordenadaYSalida]=aMover;
	}

		
		
	}
	//metodo que rota la matriz 180 grados y cambia el turno dependiendo de su estado
	// actual
	public void cambiarTurno() {
		if(turno==Ficha.COLOR_BLANCO) {
			turno=Ficha.COLOR_NEGRO;
		}
		else {
			turno=Ficha.COLOR_BLANCO;
		}
		rotar90Grados();
		rotar90Grados();
	}
	//Metodo que recibe un char y lo asigna a un int correspondiente con la coordenada
	// que se muestra en el tablero segun el jugador blanco, para que pueda mover correctammente
	// su ficha
	public int cambiarCoordenadaBlanco(char laCoordenada) {
		int c=0;
		switch (laCoordenada) {
		case 'A':
			c=0;
		break;
		case 'a':
			c=0;
			break;
		case 'B':
			c=1;
			break;
		case 'b':
			c=1;
			break;
		case 'C':
			c=2;
		break;
		case 'c':
			c=2;
			break;
		case 'D':
			c=3;
		break;
		case 'd':
			c=3;
			break;
		case 'E':
			c=4;
		break;
		case 'e':
			c=4;
			break;
		case 'F':
			c=5;
		break;
		case 'f':
			c=5;
			break;
		case 'G':
			c=6;
		break;
		case 'g':
			c=6;
			break;
		case 'H':
			c=7;
		break;
		case 'h':
			c=7;
			break;
		case '1':
			c=1;
		break;
		case '2':
			c=2;
		break;
		case '3':
			c=3;
		break;
		case '4':
			c=4;
		break;
		case '5':
			c=5;
		break;
		case '6':
			c=6;
		break;
		case '7':
			c=7;
		break;
		case '8':
			c=8;
		break;

		}
	
		return c;
		
		
	}
	//Metodo que recibe un char y lo asigna a un int correspondiente con la coordenada
	// que se muestra en el tablero segun el jugador negro, para que pueda mover correctammente
	// su ficha
	public int cambiarCoordenadaNegro(char laCoordenada) {
		int c=0;
		switch (laCoordenada) {
		case 'A':
			c=8;
		break;
		case 'a':
			c=8;
		break;
		case 'B':
			c=7;
		break;
		case 'b':
			c=7;
		break;
		case 'C':
			c=6;
		break;
		case 'c':
			c=6;
		break;
		case 'D':
			c=5;
		break;
		case 'd':
			c=5;
		break;
		case 'E':
			c=4;
		break;
		case 'e':
			c=4;
		break;
		case 'F':
			c=3;
		break;
		case 'f':
			c=3;
		break;
		case 'G':
			c=2;
		break;
		case 'g':
			c=2;
		break;
		case 'H':
			c=1;
		break;
		case 'h':
			c=1;
		break;
		case '1':
			c=7;
		break;
		case '2':
			c=6;
		break;
		case '3':
			c=5;
		break;
		case '4':
			c=4;
		break;
		case '5':
			c=3;
		break;
		case '6':
			c=2;
		break;
		case '7':
			c=1;
		break;
		case '8':
			c=0;
		break;

		}
	
		return c;
		
		
	}
	//Metodo que retorna true si se murio el rey de algún equipo o false de lo contrario
	public boolean termino() {
		boolean termino=false;
		for (int i = 0; i < elTablero.length; i++) {
			for (int j = 0; j < elTablero.length; j++) {
				if(elTablero[i][j].getTipo()==Ficha.REY) {
					termino = false;
					
				}
				else {
					termino = true;
				}
			}
		}
		return termino;
	}
	
	public char darTurno() {
		return turno;
	}
	
	
	public char darColorFicha(String coordenadas) {
		char color;
		int coordenadaX;
		int coordenadaY;
		if(turno==Ficha.COLOR_BLANCO) {
			coordenadaX=cambiarCoordenadaBlanco(coordenadas.charAt(0));
			coordenadaY=cambiarCoordenadaBlanco(coordenadas.charAt(1));
			color=elTablero[coordenadaX][coordenadaY].getColor();
		}
		else {
			coordenadaX=cambiarCoordenadaNegro(coordenadas.charAt(0));
			coordenadaY=cambiarCoordenadaNegro(coordenadas.charAt(1));
			color=elTablero[coordenadaX][coordenadaY].getColor();
		}

		return color;
	}

}
