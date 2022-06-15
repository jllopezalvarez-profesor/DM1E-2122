package org.lopezalvarezjl.ejercicio1;

public class Maquetador extends Tecnico {
	private String herramientaPreferida;
	
	public Maquetador(String nombre, String apellidos, Sexo sexo, String fechaNacimiento, Nivel nivel,
			String herramientaPreferida) {
		super(nombre, apellidos, sexo, fechaNacimiento, nivel);
		this.herramientaPreferida = herramientaPreferida;
	}

	public String getHerramientaPreferida() {
		return herramientaPreferida;
	}

	@Override
	public void trabaja() {
		System.out.println("Soy maquetador. Estoy trabajando");
	}
}
