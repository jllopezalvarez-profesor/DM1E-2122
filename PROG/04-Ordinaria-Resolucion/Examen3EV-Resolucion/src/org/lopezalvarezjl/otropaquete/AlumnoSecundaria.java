package org.lopezalvarezjl.otropaquete;

import org.lopezalvarezjl.sesionpoo.Alumno;

public class AlumnoSecundaria  extends Alumno {
	@Override
	public String toString() {
		String cadena = super.toString();
		cadena += " - " + notaMedia;
		return cadena;
	}
	


	private double notaMedia;
	
	public AlumnoSecundaria(int id, String nombre, String apellidos, int edad, double notaMedia) {
		super(id, nombre, apellidos, edad);
		this.notaMedia = notaMedia;
	}
	
	
	public AlumnoSecundaria(int id, String nombre, String apellidos, int edad, String notaMedia) {
		super(id, nombre, apellidos, edad);
		
		try {
			this.notaMedia = Double.parseDouble(notaMedia);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("El valor de la nota media no es un doble.", e);
		}
	}

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}
	
	
	
}
