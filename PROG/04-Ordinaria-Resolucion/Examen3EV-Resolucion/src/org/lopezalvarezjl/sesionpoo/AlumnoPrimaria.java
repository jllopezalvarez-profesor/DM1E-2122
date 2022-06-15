package org.lopezalvarezjl.sesionpoo;

public class AlumnoPrimaria extends Alumno {
	
	public AlumnoPrimaria(int id, String nombre, String apellidos, int edad) {
		super(id, nombre, apellidos, edad);
	}

	public void test() {
		this.getEdad();
		
	}

}
