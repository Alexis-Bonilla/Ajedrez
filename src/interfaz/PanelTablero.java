package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelTablero extends JPanel implements ActionListener{
	//relacion con la Clase JButton que representa una matriz de botones
	private JButton[][] losBotones;

	//metodo constructor del panel, se encarga de inicializar la matriz de botones y de 
	//configurar el panel, asi como de añadir los elementos graficos al panel
	public PanelTablero() {
		losBotones = new JButton[9][9];
		setLayout( new GridLayout(9,9) );
		setPreferredSize(new Dimension(0,400));
		pintarBotones();
		cargarMatriz(losBotones);
	}
	//metodo que retorna la matriz de botones
	public JButton[][] getLosBotones() {
		return losBotones;
	}
	//metodo que se encarga de dar color a los botones de la matriz
	public void pintarBotones() {
		for (int i = 0; i < losBotones.length; i++) {
			for (int j = 0; j < losBotones[0].length; j++) {
				JButton botonAux= new JButton("");
				botonAux.addActionListener(this);
				botonAux.setActionCommand(""+i+j);
				
				
				if(i%2==0) {
					if(j%2==0) {
						botonAux.setBackground(Color.GRAY);
						
					}
					else {
						botonAux.setBackground(Color.WHITE);
						
					}
				}
				else {
					if(j%2==0) {
						botonAux.setBackground(Color.WHITE);
					}
					else {
						botonAux.setBackground(Color.GRAY);
					}
				}
				losBotones[i][j]=botonAux;

			}
			
		}
		
	}
	//Metodo encargado de borrar las imagenes de los botones
	// de la matriz y sus textos y luego la carga
	public void borrarTablero() {
		for (int i = 0; i < losBotones.length; i++) {
			for (int j = 0; j < losBotones.length; j++) {
				losBotones[i][j].setIcon(null);
				losBotones[i][j].setText("");
				cargarMatriz(losBotones);
				
			}
		}
	}
	
	
	//metodo que se encarga de cargar la matriz de botones
	// en el layout 9x9 del panel
	public void cargarMatriz(JButton[][] laMatriz) {
		for (int i=0;i<laMatriz.length;i++) {
			for(int j=0;j<laMatriz[0].length;j++) {
				this.add(laMatriz[i][j]);
			}
		}
	}
	public void actionPerformed(ActionEvent evento) {
		String comando= evento.getActionCommand();

		
	}
	
	
	}