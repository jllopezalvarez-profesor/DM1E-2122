package org.lopezjoseluis.ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProgramaB {

	private JFrame frame;
	private JTextField textFieldNombreAnimales;
	private JTextField textFieldNumeroAnimales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramaB window = new ProgramaB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProgramaB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 764, 186);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnComponer = new JButton("Componer");
		btnComponer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("En el evento del botón");

				try {

					int numeroDeAnimales = Integer.parseInt(textFieldNumeroAnimales.getText());

					String nombreAnimales = textFieldNombreAnimales.getText();
					if (nombreAnimales.isEmpty()) {
						JOptionPane.showMessageDialog(btnComponer, "Tiene que indicar el nombre de los animales.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(
								btnComponer, String.format("%d %s se balanceaban sobre la tela de una araña...",
										numeroDeAnimales, nombreAnimales),
								"Cantando...", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnComponer, "El número de animales no es un número válido.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		frame.getContentPane().add(btnComponer, BorderLayout.EAST);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lblNombreAnimales = new JLabel("Nombre de los animales");
		lblNombreAnimales.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNombreAnimales);

		JLabel lblNumeroAnimales = new JLabel("Número de animales");
		lblNumeroAnimales.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNumeroAnimales);

		textFieldNombreAnimales = new JTextField();
		panel.add(textFieldNombreAnimales);
		textFieldNombreAnimales.setColumns(10);

		textFieldNumeroAnimales = new JTextField();
		panel.add(textFieldNumeroAnimales);
		textFieldNumeroAnimales.setColumns(10);
	}

}
