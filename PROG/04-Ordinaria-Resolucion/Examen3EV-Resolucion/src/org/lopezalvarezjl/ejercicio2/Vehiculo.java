package org.lopezalvarezjl.ejercicio2;

public class Vehiculo implements Comparable<Vehiculo> {
	private String marca;
	private String modelo;
	private int potenciaCV;
	private int precioEuros;

	public Vehiculo(String marca, String modelo, int potenciaCV, int precioEuros) {
		this.marca = marca;
		this.modelo = modelo;
		this.potenciaCV = potenciaCV;
		this.precioEuros = precioEuros;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getPotenciaCV() {
		return potenciaCV;
	}

	public int getPrecioEuros() {
		return precioEuros;
	}

	@Override
	public String toString() {
		return String.format("%s %s - %d CV - %d euros", marca, modelo, potenciaCV, precioEuros);
	}

	@Override
	public int compareTo(Vehiculo o) {
		int resultado = this.marca.compareTo(o.marca);
		if (resultado == 0) {
			resultado = this.modelo.compareTo(o.modelo);
		}
		return resultado;
	}

}
