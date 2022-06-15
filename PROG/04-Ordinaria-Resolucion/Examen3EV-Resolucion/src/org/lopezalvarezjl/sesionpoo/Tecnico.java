package org.lopezalvarezjl.sesionpoo;

public abstract class Tecnico extends Trabajador {
	private Nivel nivel;

	public Tecnico(String nombre, String apellidos, Sexo sexo, String fechaNacimiento, Nivel nivel) {
		super(nombre, apellidos, sexo, fechaNacimiento);
		this.nivel = nivel;
	}



	
	
}
