package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelRotar extends JPanel implements ActionListener{
	
	//Constantes, atributos y relaciones
	public final static String GIRAR_90_GRADOS = "girar_90";
	private JButton elBoton;
	private InterfazTablero principal;
	//constructor del panel, se encarga de inicializar la relacion
	// con la ventana principal y de configurar el panel
	// asi como añadir los elementos gráficos
	public PanelRotar(InterfazTablero laVentana) {
	principal = laVentana;
	setLayout(new BorderLayout());
	setPreferredSize(new Dimension(0,60));
	elBoton= new JButton();
	elBoton.setIcon(new ImageIcon("./data/boton-girar-a-la-derecha.png"));
	elBoton.setBackground(new Color(255,255,255));
	elBoton.setActionCommand(GIRAR_90_GRADOS);
	elBoton.addActionListener(this);
	this.add(elBoton);
	}
	//Metodo de despliegue de eventos, manda la señal de que el usuario
	// solicitó algo en el programa por medio de un evento a la ventana principal
	// para que esta se encargue de atenderlo
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(GIRAR_90_GRADOS)) {
			principal.girar90Grados();
		}
	}
}
