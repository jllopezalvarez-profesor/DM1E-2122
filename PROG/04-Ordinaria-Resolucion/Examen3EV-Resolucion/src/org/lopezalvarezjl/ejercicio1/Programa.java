package org.lopezalvarezjl.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class Programa {
	
	public static void main(String[] args) {
		List<Trabajador> trabajadores = new LinkedList<>();
		
		Trabajador t = new Maquetador("Carlos", "Pérez", Sexo.HOMBRE , "03/05/1982", Nivel.C, "Photoshop");
		trabajadores.add(t);
		t = new Programador("Amalia", "Del Río", Sexo.MUJER, "23/12/1974", Nivel.C, "C#");
		trabajadores.add(t);
		t = new JefeProyecto("Ana", "Cano", Sexo.MUJER, "07/10/1978", 3);
		trabajadores.add(t);
		
		for (Trabajador trabajador : trabajadores) {
			trabajador.trabaja();
			if (trabajador instanceof MandoIntermedio)
				System.out.printf("Número de miembros en el equipo: %d\n", ((MandoIntermedio)trabajador).getNumMiembrosEquipo());
		}
		
	}


}
