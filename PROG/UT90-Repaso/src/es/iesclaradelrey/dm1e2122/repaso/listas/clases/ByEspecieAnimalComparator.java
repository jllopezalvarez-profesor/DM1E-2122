package es.iesclaradelrey.dm1e2122.repaso.listas.clases;

import java.util.Comparator;

public class ByEspecieAnimalComparator implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.getEspecie().compareTo(o2.getEspecie());
	}

}
