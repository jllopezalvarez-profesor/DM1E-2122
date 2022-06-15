package org.lopezalvarezjl.ejercicio3;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Programa {

	private static final String PATH_FICHERO = "datosactores.dat";

	public static void main(String[] args) throws ClassNotFoundException {
		List<Actor> actores = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(PATH_FICHERO); ObjectInputStream dis = new ObjectInputStream(fis)) {
			while (true) {
				Actor nuevo = (Actor)dis.readObject();
				
				
//				int id = dis.readInt();
//				String nombre = dis.readUTF();
//				String apellidos = dis.readUTF();
//				Actor nuevo = new Actor(id, nombre, apellidos);
				actores.add(nuevo);
			}

		} catch (EOFException e) {
			// No hago nada porque es normal que salte cuando se llega al final del fichero.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		try (FileInputStream fis = new FileInputStream(PATH_FICHERO); DataInputStream dis = new DataInputStream(fis)) {
			while (true) {
				int id = dis.readInt();
				String nombre = dis.readUTF();
				String apellidos = dis.readUTF();
				Actor nuevo = new Actor(id, nombre, apellidos);
				actores.add(nuevo);
			}

		} catch (EOFException e) {
			// No hago nada porque es normal que salte cuando se llega al final del fichero.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Actor actor : actores) {
			System.out.println(actor);
		}
	}

}
