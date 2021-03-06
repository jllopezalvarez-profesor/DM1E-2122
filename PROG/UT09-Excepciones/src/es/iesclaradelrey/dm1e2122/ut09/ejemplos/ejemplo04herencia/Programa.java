package es.iesclaradelrey.dm1e2122.ut09.ejemplos.ejemplo04herencia;

import java.util.Scanner;

public class Programa {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//relanzarEncapsulando();

		try {
			String dni = getDni();	
		} catch (BadFormatDniException e) {
			
		}
		
		
		
	}

	private static void lanzarA() throws ExcepcionPersonalizadaA {
		throw new ExcepcionPersonalizadaA();
	}

	private static void lanzarB() {

		throw new ExcepcionPersonalizadaB();

	}

	private static void lanzarC() {

		throw new ExcepcionPersonalizadaC("Mensaje de la excepción");

	}

	private static void relanzarEncapsulando() {

		try {
			int i = Integer.parseInt("Número");
		} catch (Exception e) {
			System.err.println("Error al convertir. Relanzamos con otro tipo de excepción.");
			throw new ExcepcionPersonalizadaC(e);
		}

	}

	private static String getDni() throws BadFormatDniException {
		String dni = sc.nextLine();
		if (dni.length() < 9) {
			throw new BadFormatDniException("Error al validar la cadena introducida");
		}

		return dni;

	}

}
