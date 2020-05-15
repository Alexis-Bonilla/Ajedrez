package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMovimientos extends JPanel implements ActionListener{
	//Atributos, constantes y elementos gráficos del panel
	public final static String MOVER_FICHA = "mover";
	private InterfazTablero principal;
	private JButton elBoton;
	private JTextField txtMovimiento;
	private JLabel labMovimiento;
	//constructos del panel, se encarga de inicializar la relacion con la ventana principal 
	// y configurar el panel, tambien de añadir los elementos graficos
	public PanelMovimientos(InterfazTablero laVentana) {
		principal = laVentana;
		setLayout(new GridLayout(1,3)); 
		setPreferredSize(new Dimension(0,50));
		labMovimiento = new JLabel("Introduzca su movimiento");
		labMovimiento.setHorizontalAlignment(JTextField.CENTER);
		elBoton = new JButton("Presione para mover");
		elBoton.setBackground(new Color(197,203,205));
		elBoton.setActionCommand(MOVER_FICHA);
		elBoton.addActionListener(this);
		txtMovimiento = new JTextField("");
		txtMovimiento.setHorizontalAlignment(JTextField.LEFT);
		this.add(labMovimiento);
		this.add(txtMovimiento);
		this.add(elBoton);
	}
	//Metodo de despliegue de eventos, manda la señal de que el usuario
	// solicitó algo en el programa por medio de un evento a la ventana principal
	// para que esta se encargue de atenderlo
	public void actionPerformed(ActionEvent evento) {
		String comando= evento.getActionCommand();
		if(comando.equals(MOVER_FICHA)) {
			principal.moverFicha();
		}
	}
	//metodo que retorna lo que el usuario tecleo en el JTextField txtMovimiento
	public String darMovimiento() {
		return txtMovimiento.getText();
	}
	

}
