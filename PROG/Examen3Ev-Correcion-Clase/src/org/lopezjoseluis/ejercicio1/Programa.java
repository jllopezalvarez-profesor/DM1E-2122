package org.lopezjoseluis.ejercicio1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.lopezalvarezjoseluis.ejercicio1.Mascota;

public class Programa {

	public static void main(String[] args) {
		List<Mascota> mascotas = leerMascotas(Utilidades.PATH_FICHERO_MASCOTAS);

		System.out.println(mascotas);

		generarInformeMascotas(mascotas, Utilidades.PATH_FICHERO_INFORME_MASCOTAS);

	}

	private static void generarInformeMascotas(List<Mascota> mascotas, String pathFicheroInformeMascotas) {

		File f = new File(pathFicheroInformeMascotas);

		boolean escribirFichero = true;

		if (f.exists()) {
			escribirFichero = false;
			int respuesta = JOptionPane.showConfirmDialog(null,
					"¿Desea sobrescribir el fichero " + pathFicheroInformeMascotas + "?", "Conformar sobrescritura",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (respuesta == JOptionPane.YES_OPTION) {
				escribirFichero = true;
			}
		}
		if (escribirFichero) {

			try (PrintWriter pw = new PrintWriter(pathFicheroInformeMascotas)) {
				String formato = "%-20s | %-20s | %-40s | %4s\n";
				pw.printf(formato, "Nombre", "Especie", "Raza", "Edad");
				pw.println("-".repeat(93));
				
				for (Mascota mascota : mascotas) {
					pw.printf(formato, mascota.getNombre(), mascota.getEspecie(), mascota.getRaza(), mascota.getEdad());
				}
			} catch (FileNotFoundException e) {
				System.out.println("Error al generar el fichero de informe " + pathFicheroInformeMascotas);
				e.printStackTrace();
			}
		}
	}

	private static List<Mascota> leerMascotas(String pathFicheroMascotas) {
		List<Mascota> mascotas = new ArrayList<>();

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathFicheroMascotas))) {
			// Variacion 1 - Usando while(true)
//			try {
//				while (true) {
//					Mascota m = (Mascota) ois.readObject();
//					mascotas.add(m);
//				}
//			} catch (EOFException e) {
//			} catch (ClassNotFoundException e) {
//				System.out.println("El objeto leido del fichero no coincide con la clase Mascota.");
//				e.printStackTrace();
//			}

			// Variacion 2 - Usando while(variable)
			boolean isEof = false;
			try {
				while (!isEof) {

					try {
						Mascota m = (Mascota) ois.readObject();
						mascotas.add(m);
					} catch (EOFException e) {
						isEof = true;
					}
				}
			} catch (ClassNotFoundException e) {
				System.out.println("El objeto leido del fichero no coincide con la clase Mascota.");
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero " + pathFicheroMascotas);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al acceder al fichero " + pathFicheroMascotas);
			e.printStackTrace();
		}

		return mascotas;
	}

}
