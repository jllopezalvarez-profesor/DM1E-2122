package es.iesclaradelrey.dm1e2122.ut09.ejemplos.ejemplo02finally;

import java.util.Scanner;

/**
 * Ejemplo básico de finally.
 */
public class Ejemplo03 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int i = 0;
		do {
			try {
				System.out.println("Introduce un número entero mayor o igual a cero. Negativo para terminar.");
				i = Integer.parseInt(sc.nextLine());
				System.out.println("Número introducido: " + i);
			} catch (Exception e) {
				System.out.println("Error. No es un número.");
			} finally {
				System.out.println("En finally.");
			}
		} while (i >= 0);

		System.out.println("Fin del programa");
	}
}
