package es.iesclaradelrey.dm1e2122.ut14.ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ejercicio06 {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";
	private static final String SQL_INSERT_PRUEBA_TRANSACCION = "insert into prueba_transaccion (contenido, fecha_creacion) values (?, ?)";
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Abrimos conexión y preparamos la sentencia SQL
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				PreparedStatement pst = conn.prepareStatement(SQL_INSERT_PRUEBA_TRANSACCION)) {

			// Cambiamos el modo de la conexión para que no haga autocommit
			conn.setAutoCommit(false);
			
			// Vamos pidiendo datos al usuario hasta que introduzca "FIN".
			System.out.println("Introduce contenido. Una línea por registro. 'FIN' para terminar.\n");
			String contenido =  sc.nextLine();
			while (!contenido.equals("FIN")) {
				pst.setString(1, contenido);
				pst.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));
				pst.executeUpdate();
				contenido =  sc.nextLine();
			}
			
			// Hacemos commit de los registros insertados.
			conn.commit();

		} catch (SQLException e) { // Ponemos una excepción genérica para capturar cualquier tipo de error.
			e.printStackTrace();
		}
	}
}
