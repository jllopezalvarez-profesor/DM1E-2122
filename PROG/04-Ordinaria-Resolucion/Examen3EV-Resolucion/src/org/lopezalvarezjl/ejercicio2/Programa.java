package org.lopezalvarezjl.ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Programa {
	public static void main(String[] args) {
		List<Vehiculo> vehiculos = generarVehiculos();

		mostrarVehiculos(vehiculos);

		Collections.sort(vehiculos);

		mostrarVehiculos(vehiculos);

		Collections.sort(vehiculos, new ByPriceComparator());

		mostrarVehiculos(vehiculos);

		eliminarPrecioSuperior(vehiculos, 30000);
		//eliminarPrecioSuperior3(vehiculos, 25000);

		mostrarVehiculos(vehiculos);

	}

	private static void eliminarPrecioSuperior(List<Vehiculo> vehiculos, int precioMaximo) {
		Iterator<Vehiculo> iterator = vehiculos.iterator();
		while (iterator.hasNext()) {
			Vehiculo vehiculo = iterator.next();
			if (vehiculo.getPrecioEuros() > precioMaximo)
				iterator.remove();
		}
	}

	private static void eliminarPrecioSuperior2(List<Vehiculo> vehiculos, int precioMaximo) {
		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo.getPrecioEuros() > precioMaximo)
				vehiculos.remove(vehiculo);
		}
	}

	private static void eliminarPrecioSuperior3(List<Vehiculo> vehiculos, int precioMaximo) {
		for (int i = 0; i < vehiculos.size(); i++) {
			Vehiculo vehiculo = vehiculos.get(i);
			if (vehiculo.getPrecioEuros() > precioMaximo)
				vehiculos.remove(vehiculo);
		}
	}

	private static void mostrarVehiculos(List<Vehiculo> vehiculos) {
		System.out.println("-".repeat(100));
		for (Vehiculo vehiculo : vehiculos) {
			System.out.println(vehiculo);
		}
		System.out.println("-".repeat(100));
	}

	private static List<Vehiculo> generarVehiculos() {
		List<Vehiculo> vehiculos = new ArrayList<>();

		vehiculos.add(new Vehiculo("Peugeot", "308 GT", 205, 25900));
		vehiculos.add(new Vehiculo("Hyundai", "i30 N", 250, 30400));
		vehiculos.add(new Vehiculo("DS", "3 Performance", 208, 27950));
		vehiculos.add(new Vehiculo("Nissan", "Juke Nismo RS", 200, 37900));
		vehiculos.add(new Vehiculo("Ford", "Focus ST", 250, 28750));
		vehiculos.add(new Vehiculo("Kia", "Stinger", 200, 37900));
		vehiculos.add(new Vehiculo("Opel", "Corsa OPC", 210, 19803));

		return vehiculos;
	}
}
