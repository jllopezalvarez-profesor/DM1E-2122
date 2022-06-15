package org.lopezalvarezjl.ejercicio2;

import java.util.Comparator;

public class ByPriceComparator implements Comparator<Vehiculo> {

	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
		if (o1.getPrecioEuros() < o2.getPrecioEuros())
			return -1;
		if (o1.getPrecioEuros() > o2.getPrecioEuros())
			return 1;
		return 0;
	}

}
