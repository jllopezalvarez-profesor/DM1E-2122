package org.lopezalvarezjl.sesionpoo;

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
		trabaja(null, 0);
	}
	
	public void trabaja(String trabajo) {
		trabaja (trabajo, 0);
	} 
	
	public void trabaja(String trabajo, int horasTrabajadas) {
		System.out.print("Soy programador. Estoy trabajando");
		if (trabajo != null && trabajo.length() > 0) {
			System.out.print(" " + trabajo);	
		}
		if (horasTrabajadas != 0) {
			System.out.print(" y llevo ya con ello " + horasTrabajadas + " horas.");
		}
		System.out.println();
	} 
	
}
