/**
 * 
 */
package pkgGestioFitxersInstitut;

/**
 * Clase Menus. Clase para desplegar el menú.
 * Se llama desde la clase principal. 
 * Hecha para reparar la ejecución fallida desde el último commit del 30 de mayo. 
 * @author Daniela
 * @version 1.0 (entrega express)
 * @since 31-05-2021
 */
public class Menus {
	
	/**
	 * Método showMenus().
	 * Imprime el menú
	 * @param 
	 * @return void
	 */
	public static void showMenus() {
		print("[p] Processar Fitxers");
		print("[i] Introduir Informació");
		print("[m] Modificar Informació d'un PC");
		print("[e] Esborrar Informació d'un PC");
		print("[c] Consultar PCs per Aula");
		print("[x] Sortir");

	}
	
	/**
	 * Método print.
	 * Imprime cadena de texto entregada.
	 * Para este caso serán las opciones del menú.
	 * @param arg
	 */
	private static void print(String arg) {
		System.out.println(arg);
	}
	
	/**
	 * Método printTitle().
	 * Para automatizar el título de la opción seleccionada del menú
	 * @param t String -> cadena de texto con la opción del menú seleccionada
	 */
	public static void printTitle(String t) {
		String barra = "----------------------------------";
		int ancho = barra.length();

		print(barra);
		print(String.format("%-" + ancho + "s", String.format("%" + (t.length() + (ancho - t.length()) / 2) + "s", t)));
		print(barra);
	}
}
