package Grados;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener {

	JLabel labelC;
	JLabel labelF;
	JTextField textC;
	JTextField textF;
	JButton borrarBtn;
	JButton calcularBtn;
	JButton salirBtn;
	JPanel panelBtn;
	
	Container panel = getContentPane();
	
	public Ventana(String title) {
		super(title);
		
		setSize(500, 200);
		setLocationRelativeTo(null);
		setResizable(false); //Deshabilita opción de maximizar
		setLayout(null);
		
		panel.setBackground(Color.CYAN);
		
		panelBtn = new JPanel();
		panelBtn.setOpaque(false);
		panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 8));
		panelBtn.setBounds(80, 100, 320, 40);
		add(panelBtn);
		
		components();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void components() {
		
		/*----- Etiquetas -----*/
		
		labelC = new JLabel("Celsius (°C)");
		labelC.setOpaque(false);
		labelC.setBounds(80, 30, 100, 20);
		panel.add(labelC);
		
		labelF = new JLabel("Fahrenheit (°F)");
		labelF.setOpaque(false);
		labelF.setBounds(80, 60, 100, 20);
		panel.add(labelF);
		
		/*----- Texto -----*/
		
		textC = new JTextField();
		textC.setBounds(200, 30, 200, 20);
		panel.add(textC);
		
		textF = new JTextField();
		textF.setBounds(200, 60, 200, 20);
		panel.add(textF);
		
		/*----- Botones -----*/
		calcularBtn = new JButton("Calcular");
		calcularBtn.setPreferredSize(new Dimension(90, 20));
		panelBtn.add(calcularBtn);
		
		borrarBtn = new JButton("Borrar");
		borrarBtn.setPreferredSize(new Dimension(90, 20));
		panelBtn.add(borrarBtn);
		
		salirBtn = new JButton("Salir");
		salirBtn.setPreferredSize(new Dimension(90, 20));
		panelBtn.add(salirBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
