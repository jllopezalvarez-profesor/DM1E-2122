package org.lopezalvarezjl.sesionpoo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Trabajador {
	
	public static final int EDAD_MAXIMA_TRABAJADOR = 67;
	
	private static int numObjetos = 0;
	
	public void incrementarNumObjectos() {
		numObjetos++;
	};
	
	
	
	
	public static int getNumObjetos() {
		return numObjetos;
	}

	public static void diHola() {
		System.out.println("Hola");
	}


	private String atributo1;
	
	String getAtributo1() {
		return atributo1;
	};
	
	private String nombre;
	private String apellidos;
	private Sexo sexo;
	private LocalDate fechaNacimiento;

	public Trabajador(String nombre, String apellidos, Sexo sexo, String fechaNacimiento) {
		super();

		if (nombre == null || nombre.isEmpty()) {
			throw new ParametroIncorrectoException("El nombre no puede estar vacío.");
		}

		if (apellidos == null || apellidos.isEmpty()) {
			throw new ParametroIncorrectoException("Los apellidos no pueden estar vacíos.");
		}

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyy"));
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public int getEdad() {
		LocalDate hoy = LocalDate.now();
		Period diferencia = Period.between(this.fechaNacimiento, hoy);
		return diferencia.getYears();
	}

	public abstract void trabaja();

}
