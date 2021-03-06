package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplo01File;

import java.io.File;
import java.io.IOException;

public class Ejemplo01 {

	private static final String USER_HOME_PATH = System.getProperty("user.home");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("/esta/ruta/no/existe/fichero.txt");
		System.out.println(f.exists());

		File homeUsuario = new File(USER_HOME_PATH);
		System.out.println(homeUsuario.exists());

		File ficheroPruebaHome = new File(homeUsuario, "prueba.txt");
		if (ficheroPruebaHome.exists()) {
			System.out.printf("El fichero %s ya existe.\n", ficheroPruebaHome.getAbsolutePath());
		} else {
			System.out.printf("El fichero %s no existe.\nCreando fichero...", ficheroPruebaHome.getAbsolutePath());
			try {
				ficheroPruebaHome.createNewFile();
			} catch (IOException e) {
				System.err.printf("Error al crear el fichero: $s", e.getMessage());
				e.printStackTrace();
			}
		}

		
	}

}
