package org.lopezalvarezjl.sesionpoo;

public class JefeProyecto extends Trabajador implements MandoIntermedio {
	private int numMiembrosEquipo;

	public JefeProyecto(String nombre, String apellidos, Sexo sexo, String fechaNacimiento, int numMiembrosEquipo) {
		super(nombre, apellidos, sexo, fechaNacimiento);
		this.numMiembrosEquipo = numMiembrosEquipo;
	}

	@Override
	public void trabaja() {
		System.out.println("Soy jefe de proyecto. Estoy trabajando");
	}

	@Override
	public int getNumMiembrosEquipo() {
		return numMiembrosEquipo;
	}

}
