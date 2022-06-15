package org.lopezalvarezjl.sesionpoo;

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.lopezalvarezjl.otropaquete.AlumnoSecundaria;

public class Programa {

	public static void main(String[] args) {

//		Alumno a = new AlumnoPrimaria(1, "A", "A", 22);
//		Alumno b = new AlumnoSecundaria(2, "B", "B", 18, 7.9);
//
//		System.out.println(a.toString());
//		System.out.println(b.toString());

//	Trabajador.diHola();
//	
//	DateTimeFormatter formato = 	DateTimeFormatter.ofPattern("dd/MM/yyyy");

//		
//		
//		
		List<Trabajador> trabajadores = new LinkedList<>();

		Trabajador t = new Maquetador("Carlos", "Pérez", Sexo.HOMBRE, "03/05/1982", Nivel.C, "Photoshop");
		trabajadores.add(t);
		Trabajador q = new Programador("Amalia", "Del Río", Sexo.MUJER, "23/12/1974", Nivel.C, "C#");
		trabajadores.add(q);
		Trabajador r = new JefeProyecto("Ana", "Cano", Sexo.MUJER, "07/10/1978", 3);
		trabajadores.add(r);

		Maquetador m = new Maquetador("Juan", "Perez", Sexo.HOMBRE, "10/10/1995", Nivel.A, "Illustrator");

		//Trabajador ttttt = new Trabajador("", "", Sexo.HOMBRE, "10/10/2020");
		
		// UPCasting
		Tecnico tt = m;
		Trabajador ttt = m;
		Trabajador tttt = tt;

		// DOWNCasting

		Maquetador mm = (Maquetador) ttt;

		if (ttt instanceof Programador) {
			((Programador) ttt).trabaja("", 100);
		}

//		
//		System.out.println(r.getNumObjetos());
//		t.incrementarNumObjectos();
//		System.out.println(q.getNumObjetos());
//		r.incrementarNumObjectos();
//		System.out.println(t.getNumObjetos());
//		q.incrementarNumObjectos();

		for (Trabajador trabajador : trabajadores) {
			trabajador.trabaja();
			if (trabajador instanceof MandoIntermedio)
				System.out.printf("Número de miembros en el equipo: %d\n",
						((MandoIntermedio) trabajador).getNumMiembrosEquipo());
		}

	}

}
