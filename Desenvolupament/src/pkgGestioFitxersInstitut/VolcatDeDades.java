package pkgGestioFitxersInstitut;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;



/**
 * Cas_6 M03 VolcatDeDades: Programa inicial del pkgGestioFitxersInstitut.
 * Implementa una aplicación para la gestión de la información de los PCs del
 * Institut Montsia a través de los módulos: ProcessarFitxers.java
 * IntroduirManualmentInfo.java ModificarInfoPC.java EsborrarInfoPC.java
 * ConsultarPCsPerAula.java También Utiliza la librería java.io
 * 
 * @author Daniela Gallardo Reyes
 * @version 1.0 (entrega express)
 * @since 17-05-2021
 */

public class VolcatDeDades {
	// main
	public static void main(String[] args) {
		// 1.creamos el menú de opciones
		String[] opcions = new String[6];
		Scanner sc = new Scanner(System.in);
		opcions[0] = "[p] Processar Fitxers";
		opcions[1] = "[i] Introduir Informació";
		opcions[2] = "[m] Modificar Informació d'un PC";
		opcions[3] = "[e] Esborrar Informació d'un PC";
		opcions[4] = "[c] Consultar PCs per Aula";
		opcions[5] = "[x] Sortir";

		// 2. variable para salir del programa
		boolean sortir = false;

		do {
			// var para guardarnos la opcion seleccionada
			char opcio;
			// llamamos al metodo para imprimir el menu
			opcio = menu(opcions);

			switch (opcio) {

			case 'p':
				System.out.println("----------------------------------");
				System.out.println("       [p] Processar Fitxers      ");
				System.out.println("----------------------------------");
				//llamar método que pide ruta del directorio a procesar


				//llamar método que crea un archivo nuevo.
				
				
				//mostrar path del nuevo archivo .txt

				break;
				
			case 'i':
				System.out.println("----------------------------------");
				System.out.println("     [i] Introduir Informació     ");
				System.out.println("----------------------------------");
				
				
				
				break;
			}
		} while (sortir == false);
	}// fin del main

	/**
	 * Función Menú. Muestra el menú de opciones por pantalla y pide ingresar una
	 * opción del menú por teclado
	 * 
	 * @param opcions
	 * @return variable tipo char (opción seleccionada)
	 */
	public static char menu(String[] opcions) {
		System.out.println("----------------------------------");
		System.out.println("|              MENÚ              |");
		System.out.println("----------------------------------");
		for (int i = 0; i < opcions.length; i++) {
			System.out.println(opcions[i]);
		}
		// Preguntamos qué opción seleccionarán
		System.out.println("-----------------------------");
		System.out.println("|       QUÉ VOLS FER?       |");
		System.out.println("-----------------------------");
		System.out.println("    [ingressa una opció]   ");

		// entrada por teclado
		Scanner sc = new Scanner(System.in);
		// guardamos la entrada en opcio
		char opcio1 = sc.next().charAt(0);
		// retornamos opcio al main
		return opcio1;

	}
}
