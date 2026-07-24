package Grados;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridBagLayoutInfo;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ventana extends JFrame implements ActionListener {

	private JLabel labelC;
	private JLabel labelF;
	private JLabel labelError;
	private JTextField textC;
	private JTextField textF;
	private JButton borrarBtn;
	private JButton calcularBtn;
	private JButton salirBtn;
	private JPanel panelBtn;
	private JPanel panelError;

	private String gradosF;
	private String gradosC;
	private String textError;

	Container panel = getContentPane();

	public Ventana(String title) {
		super(title);

		setSize(500, 220);
		setLocationRelativeTo(null);
		setResizable(false); // Deshabilita opción de maximizar
		setLayout(null);

		panel.setBackground(new Color(230, 245, 255));

		panelError = new JPanel(new BorderLayout());
		panelError.setOpaque(true);
		panelError.setBounds(80, 90, 320, 20);
		panelError.setVisible(false);
		add(panelError);

		panelBtn = new JPanel();
		panelBtn.setOpaque(false);
		panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 12, 8));
		panelBtn.setBounds(80, 120, 320, 40);
		panelBtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		add(panelBtn);

		components();

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void components() {

		/*----- Fuente -----*/
		Font font = new Font("Segoe UI", Font.PLAIN, 14);

		/*----- Etiquetas -----*/

		labelC = new JLabel("Celsius (°C)");
		labelC.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		labelC.setOpaque(false);
		labelC.setBounds(80, 30, 100, 20);
		panel.add(labelC);

		labelF = new JLabel("Fahrenheit (°F)");
		labelF.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		labelF.setOpaque(false);
		labelF.setBounds(80, 60, 100, 20);
		panel.add(labelF);

		labelError = new JLabel("", SwingConstants.CENTER);
		labelError.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelError.setForeground(Color.RED);

		panelError.add(labelError, BorderLayout.CENTER);

		/*----- Texto -----*/

		textC = new JTextField();
		textC.setFont(font);
		textC.setBounds(200, 30, 200, 20);
		panel.add(textC);

		textF = new JTextField();
		textF.setFont(font);
		textF.setBounds(200, 60, 200, 20);
		panel.add(textF);

		/*----- Botones -----*/
		calcularBtn = new JButton("Calcular");
		calcularBtn.setBackground(new Color(76, 175, 80));
		calcularBtn.setForeground(Color.WHITE);
		calcularBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		calcularBtn.setPreferredSize(new Dimension(90, 23));
		panelBtn.add(calcularBtn);

		borrarBtn = new JButton("Borrar");
		borrarBtn.setBackground(new Color(255, 193, 7));
		borrarBtn.setForeground(Color.WHITE);
		borrarBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		borrarBtn.setPreferredSize(new Dimension(90, 23));
		panelBtn.add(borrarBtn);

		salirBtn = new JButton("Salir");
		salirBtn.setBackground(new Color(220, 53, 69));
		salirBtn.setForeground(Color.WHITE);
		salirBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		salirBtn.setPreferredSize(new Dimension(90, 23));
		panelBtn.add(salirBtn);

		calcularBtn.addActionListener(this);
		borrarBtn.addActionListener(this);
		salirBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == calcularBtn) {

			gradosC = textC.getText();
			gradosF = textF.getText();

			if (validarTextoGrados(gradosC, gradosF)) {
			}

			System.out.println("Btn Calcular");

		} else if (e.getSource() == borrarBtn) {

			System.out.println("Btn Borrar");

		} else if (e.getSource() == salirBtn) {

			System.out.println("Btn Salir");
			System.exit(0);

		}

	}

	public boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	public boolean validarTextoGrados(String gradosC, String gradosF) {

		if (gradosC.isBlank() || gradosF.isBlank()) {

			labelError.setText("Campos vacios");
			panelError.setVisible(true);
			return false;

		}

		if (!isNumeric(gradosF)) {

			labelError.setText("Grados Fahrenheit no valido");
			panelError.setVisible(true);
			return false;

		}

		if (!isNumeric(gradosC)) {

			labelError.setText("Grados Celsius no valido");
			panelError.setVisible(true);
			return false;

		}

		panelError.setVisible(false);

		return true;
	}

}
