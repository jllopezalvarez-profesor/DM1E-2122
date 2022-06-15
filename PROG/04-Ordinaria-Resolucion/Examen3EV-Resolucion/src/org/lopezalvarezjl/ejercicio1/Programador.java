package org.lopezalvarezjl.ejercicio1;

public class Programador extends Tecnico {
	private String lenguajePreferido;

	public Programador(String nombre, String apellidos, Sexo sexo, String fechaNacimiento, Nivel nivel,
			String lenguajePreferido) {
		super(nombre, apellidos, sexo, fechaNacimiento, nivel);
		this.lenguajePreferido = lenguajePreferido;
	}

	public String getLenguajePreferido() {
		return lenguajePreferido;
	}

	@Override
	public void trabaja() {
		System.out.println("Soy programador. Estoy trabajando");
	}
}
