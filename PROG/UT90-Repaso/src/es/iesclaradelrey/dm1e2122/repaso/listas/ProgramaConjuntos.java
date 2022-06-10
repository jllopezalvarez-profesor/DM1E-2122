package es.iesclaradelrey.dm1e2122.repaso.listas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import es.iesclaradelrey.dm1e2122.repaso.listas.clases.Animal;

public class ProgramaConjuntos {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Set<Animal> animales = new HashSet<>();

		System.out.println(animales.add(new Animal(1, "A", "A")));
		System.out.println(animales.add(new Animal(2, "B", "B")));
		System.out.println(animales.add(new Animal(1, "A", "A")));
		System.out.println(animales.add(new Animal(2, "X", "Y")));
		System.out.println(animales.add(new Animal(1, "W", "C")));

		System.out.println(animales);

		
		// Contar cuantos caracteres DIFERENTES hay en el fichero
		
		Set <Character> caracteres = new HashSet<>();
		
		try(FileReader fr = new FileReader("texto.txt")){
			int leido = fr.read();
			while (leido != -1) {
				Character c = (char)leido;
				caracteres.add(c);
				leido = fr.read();
			}
		}
		
		System.out.println(caracteres);
		
		Set<Character> caracteresOrdenados = new TreeSet<>(caracteres);

		System.out.println(caracteresOrdenados);

		
		System.out.printf("El número de caracteres diferentes es %d", caracteres.size());
		
	}

}
