package org.lopezalvarezjl.ejercicio4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;



public class Programa {
	private static final String URL = "jdbc:mysql://localhost/sakila";
	private static final String USR = "sakilauser";
	private static final String PWD = "pwdsakilauser";
	private static final String SQL = "select customer_id, first_name, last_name, email from customer where store_id = ? order by last_name, first_name";
	

	
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int idTienda = pideIdTienda();
		while (idTienda != 0) {
			mostrarClientesTienda(idTienda);
			idTienda = pideIdTienda();
		}

	}

	private static int pideIdTienda() {
		// System.out.println("¿Tienda de la que deseas saber los clientes (0 para
		// salir)?");
		int idTienda = -1;
		boolean fin = false;

		while (!fin) {
			try {
				String valor = JOptionPane
						.showInputDialog("¿Tienda de la que deseas saber los clientes (0 para salir)?");
				if (valor == null || valor.length() < 3) {
					JOptionPane.showMessageDialog(null, "La longitud del código debe ser de al menos tres cifras",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else {
					idTienda = Integer.parseInt(valor);
					fin = true;
				}
			} catch (NumberFormatException e) {
				// System.out.println("Debe introducir un número");
				JOptionPane.showMessageDialog(null, "Debe introducir un número", "Error al convertir",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		return idTienda;
	}

	private static void mostrarClientesTienda(int idTienda) {

		try (Connection con = DriverManager.getConnection(URL, USR, PWD);
				PreparedStatement ps = con.prepareStatement(SQL)) {
			
			ps.setInt(1, idTienda);

			try (ResultSet rs = ps.executeQuery()) {
				if (!rs.isBeforeFirst()) {
					rs.beforeFirst();
					System.out.printf("No se han encontrado clientes para la tienda %d\n", idTienda);
				} else {
					
					
					
					String formato = "| %10s | %-45s | %-45s | %-50s |\n";
					System.out.println("-".repeat(163));
					System.out.printf(formato, "ID", "Apellidos", "Nombre", "Email");
					System.out.println("-".repeat(163));
					while (rs.next()) {
						int id = rs.getInt("customer_id");
						String nombre = rs.getString("first_name");
						String apellidos = rs.getString("last_name");
						String email = rs.getString("email");
						System.out.printf(formato, id, apellidos, nombre, email);
					}
					System.out.println("-".repeat(163));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
