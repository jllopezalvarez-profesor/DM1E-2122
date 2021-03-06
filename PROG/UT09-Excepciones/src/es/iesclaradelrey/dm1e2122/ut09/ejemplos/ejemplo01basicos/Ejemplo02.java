package es.iesclaradelrey.dm1e2122.ut09.ejemplos.ejemplo01basicos;

/**
 * Ejemplo de excepciones que se lanzan tras llamar a varios métodos, y cómo son
 * controladas en el método que tiene el try / catch
 */
public class Ejemplo02 {
	public static void main(String[] args) {
		try {
			metodoA();
		} catch (Exception e) {
			System.out.println("Excepción lanzada: " + e);
			System.out.println("Pila de llamadas cuando se produjo:");
			e.printStackTrace();
		}
		System.out.println("Final del programa.");
	}

	public static void metodoA() {
		System.out.println("Antes de llamar a B");
		metodoB();
		System.out.println("Después de llamar a B");
	}

	public static void metodoB() {
		metodoC();
	}

	public static void metodoC() {
		metodoD();
	}

	public static void metodoD() {
		int numero = Integer.parseInt("ocho");
		System.out.println(numero);
	}
}
