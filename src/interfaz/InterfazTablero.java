package interfaz;

import java.awt.*;
import javax.swing.*;
import modelo.Ficha;
import modelo.*;

public class InterfazTablero extends JFrame{
	//Atributos y elementos gráficos de la ventana principal
	private PanelTablero elPanelTablero;
	private PanelMovimientos elPanelMovimientos;
	private TableroAjedrez elTablero;
	private PanelRotar elPanelRotar;

	//constructor
	public InterfazTablero() {
		//Ajusta las características de la ventana
		setTitle( "Ajedrez de Alexis" );
	    setSize( 600, 600 );
	    setResizable( false );
	    setDefaultCloseOperation( EXIT_ON_CLOSE );
	    setLayout( new BorderLayout( ) );
	    
	    //Añade los complementos gráficos a la ventana
	    elPanelRotar = new PanelRotar(this);
	    add(elPanelRotar, BorderLayout.SOUTH);
	    elPanelTablero = new PanelTablero();
	    add( elPanelTablero, BorderLayout.CENTER );
	    elPanelMovimientos = new PanelMovimientos(this);
        add(elPanelMovimientos, BorderLayout.NORTH);
        elTablero= new TableroAjedrez();
        //Invoca método que pinta la matriz del panelTablero
	    pintarMatriz();
		
	}
	//Metodo que asigna su respectiva imagen, letra o número a cada boton
	// de la matriz del panel 
	public void  pintarMatriz() {
		Ficha[][] laMatrizDelMundo = elTablero.getElTablero();
		char color;
		char tipo;
		for (int i = 0; i < laMatrizDelMundo.length; i++) {
			for (int j = 0; j < laMatrizDelMundo[0].length; j++) {
				if(laMatrizDelMundo[i][j]!=null) {
					color = laMatrizDelMundo[i][j].getColor();
					tipo = laMatrizDelMundo[i][j].getTipo();
					ImageIcon elIcono= obtenerImagen(color,tipo);
					String laLetra= obtenerLetra(color,tipo);
					elPanelTablero.getLosBotones()[i][j].setText(laLetra);
					elPanelTablero.getLosBotones()[i][j].setIcon(elIcono);
				}
			}
		}
	}
	//Metodo auxiliar de pintar matriz, que obtiene la imagen de cada boton de la matriz del panel dependiendo
	// de su tipo y color 
	public ImageIcon obtenerImagen(char color, char tipo) {
		ImageIcon laImagen=null;
		switch (color) {
		case 'B':
			if(tipo=='P') {
				laImagen= new ImageIcon("./data/peon_blanco.png");
			}
			else if(tipo=='T') {
				laImagen= new ImageIcon("./data/torre_blanca.png");
			}
			else if(tipo=='C') {
				laImagen= new ImageIcon("./data/caballo_blanco.png");
			}
			else if(tipo=='A') {
				laImagen= new ImageIcon("./data/alfil_blanco.png");
			}
			else if(tipo=='D') {
				laImagen= new ImageIcon("./data/dama_blanca.png");
			}
			else if (tipo=='R') {
				laImagen= new ImageIcon("./data/rey_blanco.png");
			}
			
			break;

		case 'N':
			if(tipo=='P') {
				laImagen= new ImageIcon("./data/peon_negro.png");
			}
			else if(tipo=='T') {
				laImagen= new ImageIcon("./data/torre_negro.png");
			}
			else if(tipo=='C') {
				laImagen= new ImageIcon("./data/caballo_negro.png");
			}
			else if(tipo=='A') {
				laImagen= new ImageIcon("./data/alfil_negro.png");
			}
			else if(tipo=='D') {
				laImagen= new ImageIcon("./data/dama_negro.png");
			}
			else if (tipo=='R') {
				laImagen= new ImageIcon("./data/rey_negro.png");
			}
			break;
		case 'S':
		 if(tipo=='r') {
			 laImagen = new ImageIcon("./data/boton-girar-a-la-derecha.png");
		 }
		}
		return laImagen;
	}
	//Metodo auxiliar de pintar matriz, que obtiene la letra o el número de cada boton de la matriz del panel dependiendo
	// de su tipo y color 
	public String obtenerLetra(char tipo, char valor) {

		String laLetra="";
		switch (tipo) {
		case 'L':
			if(valor=='a') {
				laLetra="A";
			}
			else if(valor=='b') {
				laLetra="B";
			}
			else if(valor=='c') {
				laLetra = "C";
			}
			else if(valor=='d') {
				laLetra = "D";
			}
			else if(valor=='e') {
				laLetra= "E";
			}
			else if (valor=='f') {
				laLetra = "F";
			}
			else if (valor=='g') {
				laLetra = "G";
			}
			else if (valor=='h') {
				laLetra = "H";
			}
			break;

		case 'n':
			if(valor=='1') {
				laLetra="1";
			}
			else if(valor=='2') {
				laLetra="2";
			}
			else if(valor=='3') {
				laLetra = "3";
			}
			else if(valor=='4') {
				laLetra = "4";
			}
			else if(valor=='5') {
				laLetra= "5";
			}
			else if (valor=='6') {
				laLetra = "6";
			}
			else if (valor=='7') {
				laLetra = "7";
			}
			else if (valor=='8') {
				laLetra = "8";
			}
			break;
		}
		return laLetra;
		
	
	}
//	public void senalarMovimiento() {
//		elPanelTablero.
//		int[] coordenadas= new int[2];
//		coordenadas[0]=(int)coordenadasEnString.charAt(0);
//		coordenadas[1]=(int)coordenadasEnString.charAt(1);
//		elTablero.
		
//	}
	public void senalarPeon(int[] coordenadas) {}
	
	//Metodo que manda la orden de lo que tiene que cambiar en el mundo cuando se mueve una ficha
	// y a su vez actualiza lo necesario en el panel que muestra la matriz
	public void moverFicha() {
			String coordenadas= elPanelMovimientos.darMovimiento();
			char turno=elTablero.darColorFicha(coordenadas);
			
			if(turno==elTablero.darTurno()) {
				elTablero.moverFicha(coordenadas);
				pintarMatriz();
				elTablero.cambiarTurno();
				elPanelTablero.borrarTablero();
				pintarMatriz();
				
			}
			else {
				JOptionPane.showMessageDialog(this, "NO ES TU TURNO");
			}

	}

	
	//Metodo que manda la orden al mundo de girar el tablero 90 grados a la derecha
	// y a su vez actualiza lo necesario en panel que muestra la matriz
	public void girar90Grados() {
		elTablero.rotar90Grados();
		elPanelTablero.borrarTablero();
		pintarMatriz();
	}
	//Metodo main, encargado de inicializar la ventana principal y darle comienzo al programa
	public static void main(String[] args) {
	InterfazTablero elTablero = new InterfazTablero();
	elTablero.setVisible(true);
	

	}

}
