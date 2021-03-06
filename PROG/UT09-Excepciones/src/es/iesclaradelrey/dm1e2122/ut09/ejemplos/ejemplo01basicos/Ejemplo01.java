package es.iesclaradelrey.dm1e2122.ut09.ejemplos.ejemplo01basicos;

import java.util.Scanner;

/**
 * Ejemplos básicos de excepciones
 */
public class Ejemplo01 {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Comentado porque si no está comentado "rompe" el programa.
		// Descomentar para probar.
		// ejemplo00();

		ejemplo01();

		ejemplo02();

		ejemplo03NoControlado();
		
		ejemplo03Controlado();
		
		multiples();
		
		multiplesFinally();
	}

	/**
	 * Sin control de excepciones.
	 */
	@SuppressWarnings("unused")
	private static void ejemplo00() {
		try {
			int numero = Integer.parseInt("cuatro");
			System.out.println(numero);
		} catch (Exception e) {
			System.out.println("No se puede convertir en número");
		}
	}

	/**
	 * Control de excepciones básico
	 */
	private static void ejemplo01() {
		try {
			int numero = Integer.parseInt("cuatro");
			System.out.println(numero);
		} catch (Exception e) {
			System.out.println("No se puede convertir en número");
		}
	}

	/**
	 * Control de excepciones básico, con mensajes para identificar por donde va
	 * pasando el programa.
	 */
	private static void ejemplo02() {
		System.out.println("Antes de try");
		try {
			System.out.println("Introduce un número: ");
			System.out.println("En try antes de posible error");
			var numero = Double.parseDouble(sc.nextLine());
			System.out.printf("El número introducido es: %f\n", numero);
			System.out.println("En try después de posible error");
		} catch (Exception e) {
			System.out.println("En catch. Excepción: " + e);
		}
		System.out.println("Después de catch");
	}

	/**
	 * Ejemplo de excepciones en un bucle. 
	 */
	private static void ejemplo03NoControlado() {
		int[] numeros = new int[5];

		int num = 0;
		int posicion = 0;
		do {
			System.out.print("Introduce un número (negativo para terminar): ");
			num = Integer.parseInt(sc.nextLine()); // Puede lanzar NumberFormatException
			if (num >= 0) {
				numeros[posicion] = num; // Puede lanzar ArrayIndexOutOfBoundsException
				posicion++;
			}
		} while (num > 0);

		printArray(numeros);
	}

	/**
	 * Ejemplo de control de excepciones en un bucle. 
	 */
	private static void ejemplo03Controlado() {
		int[] numeros = new int[5];

		int num = 0;
		int posicion = 0;
		do {
			try {
				System.out.print("Introduce un número positivo, o un número negativo para terminar: ");
				num = Integer.parseInt(sc.nextLine()); // Puede lanzar NumberFormatException
				if (num >= 0) {
					numeros[posicion] = num; // Puede lanzar ArrayIndexOutOfBoundsException
					posicion++;
				}
			} catch (NumberFormatException nfe) {
				System.out.println("La cadena introducida no es un número válido");
			} catch (ArrayIndexOutOfBoundsException aiobe) {
				System.out.println("El array ya está lleno. No se pueden cargar más números");
			} catch (Exception e) {
				System.out.println("Otra excepción. " + e.getMessage());
			}

		} while (num >= 0);

		printArray(numeros);
	}

	/** 	
	 * Ejemplo de control de múltiples excepciones
	 */
	private static void multiples() {

		try {
			// Código que puede lanzar una excepción
		} catch (NumberFormatException e) {
			System.out.println("Excepción: " + e);
		} catch (NullPointerException e) {
			System.out.println("Excepción: " + e);
		} catch (Exception e) {
			System.out.println("Excepción: " + e);
		}

	}

	/** 	
	 * Ejemplo de control de múltiples excepciones con finally
	 */
	private static void multiplesFinally() {

		try {
			// Código que puede lanzar una excepción
		} catch (NumberFormatException e) {
			System.out.println("Excepción: " + e);
		} catch (NullPointerException e) {
			System.out.println("Excepción: " + e);
		} catch (Exception e) {
			System.out.println("Excepción: " + e);
		} finally {
			System.out.println("Este código SIEMPRE se ejecuta, pase lo que pase.");
		}

	}

	/**
	 * Muestra un array por la consola como números separados por espacios.
	 * @param arrray Array que deseamos presentar en la consola.
	 */
	private static void printArray(int[] arrray) {
		for (int num : arrray) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
