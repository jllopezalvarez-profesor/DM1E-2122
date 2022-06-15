package org.lopezalvarezjl.sesionpoo;

import java.util.Objects;

public class Alumno extends Object implements Comparable<Alumno> {
	private int id;
	private String nombre;
	private String apellidos;
	
	private int edad;
	
	int getEdad() {
		return edad;
	}
	
	void setEdad(int edad) {
		this.edad = edad;
	}

//	public Alumno() {
//		this(0, "", "desconocido");
//	}

	public Alumno(int id, String nombre, String apellidos, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getId() {
		return id;
	}



	@Override
	public int hashCode() {
		return Objects.hash(apellidos, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Alumno))
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellidos, other.apellidos) && id == other.id && Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Alumno o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Alumno " + id + " - " + nombre + " - " + apellidos + " - " + edad;
	}
	
	

	
	
}
