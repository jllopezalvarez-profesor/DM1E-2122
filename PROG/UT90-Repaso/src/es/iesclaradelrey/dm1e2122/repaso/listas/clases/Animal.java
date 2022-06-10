package es.iesclaradelrey.dm1e2122.repaso.listas.clases;

import java.util.Objects;

public class Animal implements Comparable<Animal> {
	private int id;
	private String especie;
	private String nombre;

	public Animal(int id) {
		this(id, "", "");
	}
	
	public Animal(int id, String especie, String nombre) {
		this.id = id;
		this.especie = especie;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public String getEspecie() {
		return especie;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Animal))
			return false;
		Animal other = (Animal) obj;
		return id == other.id;
	}



	@Override
	public String toString() {
		return "Animal [id=" + id + ", especie=" + especie + ", nombre=" + nombre + "]";
	}

	@Override
	public int compareTo(Animal o) {
		if (this.id < o.id) return -1;
		if (this.id > o.id) return 1;
		return this.getNombre().compareTo(o.getNombre());
	}

	
	
}
