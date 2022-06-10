package es.iesclaradelrey.dm1e2122.repaso.listas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import es.iesclaradelrey.dm1e2122.repaso.listas.clases.Animal;
import es.iesclaradelrey.dm1e2122.repaso.listas.clases.ByEspecieAnimalComparator;
import es.iesclaradelrey.dm1e2122.repaso.listas.clases.ByNombreAnimalComparator;

public class Programa {

	/*
	 * Iterable<T> -> Foreach, Iterator Collection<T> -> Añade métodos comunes a
	 * todas las colecciones añadir, eliminar y tamaño List<T> -> Añade acceso por
	 * índice, búsqueda de elementos Set<T> -> No se pueden repetir elementos. Usa
	 * equals para comparar elementos. 1 2 3 4 A B D E List<double> List<Double>
	 */

	public static void main(String[] args) {

		List<Animal> animales = new ArrayList<>();
		Animal[] animales2 = new Animal[5];
		animales2[0] = new Animal(2, "Hamster", "Juan");
		animales2[1] = new Animal(1, "Perro", "Carlos");
		animales2[2] = new Animal(4, "Paloma", "Lassie");
		animales2[3] = new Animal(3, "Tortuga", "Laika");
		animales2[4] = new Animal(6, "Canguro", "Tom");

		animales.add(new Animal(2, "Hamster", "Tom"));
		animales.add(new Animal(1, "Perro", "Juan"));
		animales.add(new Animal(4, "Paloma", "Ana"));
		animales.add(new Animal(3, "Perro", "María"));
		animales.add(new Animal(6, "Canguro", "Carlos"));
		animales.add(new Animal(7, "Hamster", "Carlos"));
		animales.add(new Animal(5, "Perro", "Antonio"));
		Animal a = new Animal(100, "Iguana", "Marisa");
		// animales.add(a);
		animales.add(4, a);

		mostrarAnimales(animales);
//		Collections.reverse(animales);
//		mostrarAnimales(animales);
//		
//		
//		//eliminarNombresLargos(animales, 5);
//		
//		System.out.println("-----------------");
//		
//		mostrarAnimales(animales);
//		
//		Collections.sort(animales);
//
//		System.out.println("-----------------");
//		
//		mostrarAnimales(animales);
//		
//		Collections.sort(animales, Comparator.reverseOrder());
//
//		System.out.println("-----------------");
//		
//		mostrarAnimales(animales);
//		
//		mostrarArrayAnimales(animales2);
//		Arrays.sort(animales2, Comparator.reverseOrder());
//		mostrarArrayAnimales(animales2);
//		
//		Collections.reverse(animales);
//		mostrarAnimales(animales);

//		// Ordenando por nombre
//		Collections.sort(animales, new ByNombreAnimalComparator());
//		mostrarAnimales(animales);
//		// Ordenando por nombre, orden inverso
//		Collections.sort(animales, new ByNombreAnimalComparator().reversed());
//		mostrarAnimales(animales);
//		// Ordenando por especie
//		Collections.sort(animales, new ByEspecieAnimalComparator());
//		mostrarAnimales(animales);
//		// Ordenando por especie, orden inverso
//		Collections.sort(animales, new ByEspecieAnimalComparator().reversed());
//		mostrarAnimales(animales);
//		// Ordenando por especie y luego por nombre
//		Collections.sort(animales, new ByEspecieAnimalComparator().thenComparing(new ByNombreAnimalComparator()));
//		mostrarAnimales(animales);

		int idAnimal = 3;
		Animal x = buscarAnimal(animales, idAnimal);
		if (x != null) {
			System.out.println("Animal encontrado:");
			System.out.println(x);
			animales.remove(x);
		} else {
			System.out.printf("No se ha encontrado el animal %d\n", idAnimal);
		}

		mostrarAnimales(animales);

		Animal aEliminar = new Animal(2);
		animales.remove(aEliminar);
		mostrarAnimales(animales);

	}

	private static Animal buscarAnimal(List<Animal> animales, int id) {
		for (Animal animal : animales) {
			if (animal.getId() == id)
				return animal;
		}
		return null;
	}

	private static void mostrarArrayAnimales(Animal[] animales2) {
		System.out.println("Array de animales:");
		for (Animal animal : animales2) {
			System.out.println(animal);
		}
	}

	private static void mostrarAnimales(Iterable<Animal> animales) {
		System.out.println("Iterable de animales:");
		for (Animal animal : animales) {
			System.out.println(animal);
		}

	}

	private static void eliminarNombresLargos(List<Animal> listaAnimales, int longitud) {
		Iterator<Animal> iterator = listaAnimales.iterator();
		while (iterator.hasNext()) {
			Animal animal = iterator.next();
			if (animal.getNombre().length() > longitud)
				iterator.remove();
		}
	}
}
