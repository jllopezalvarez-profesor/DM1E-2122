package es.iesclaradelrey.dm1e2122.repaso.listas.clases;

import java.util.Comparator;

public class ByNombreAnimalComparator implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

}
