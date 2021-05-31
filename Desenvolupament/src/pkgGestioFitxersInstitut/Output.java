package pkgGestioFitxersInstitut;

import java.util.Collections;
import java.util.Comparator;
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Cas_6 M03 Clase Output: Clase para crear, escribir y guardar un archivo de
 * texto. Desde la clase Principal cargamos un arraylist de objetos PC. Crea un
 * fichero txt y escribimos los datos del arraylist.
 * 
 * @author Daniela Gallardo Reyes
 * @version 1.2 (entrega express)
 * @since 17-05-2021
 */
public class Output {

	/**
	 * Método guardarArraylist()
	 * Guarda un archivo con los datos del programa en directorio predeterminado.
	 * @param listaLS
	 * @param listaDM
	 * @param fileName
	 * @return void
	 */
	public static void guardarArraylist(ArrayList<PC> listaLS, ArrayList<PC> listaDM, String fileName) {
		try {
			FileWriter myWriter = new FileWriter(fileName);
			myWriter.write(stringify(listaLS, listaDM));
			myWriter.close();

			System.out.println("Arxiu suposadament desat");
		} catch (IOException e) {
			System.out.println("Mecachis en la mar...L'arxiu no s'ha desat correctament");
			e.printStackTrace();
		}
	}

	/**
	 * Método guardaPerAula() 
	 * Guardar archivo con directorio personalizado.
	 * @param listaLS
	 * @param listaDM
	 * @return void
	 */
	public static void guardaPerAula(ArrayList<PC> listaLS, ArrayList<PC> listaDM) {
		String nom;
		Scanner leer = new Scanner(System.in);

		System.out.println("Escriu el nom del ficher per a guardar la informació");
		nom = leer.nextLine() + ".txt";
		guardarArraylist(listaLS, listaDM, nom);
	}

	/**
	 * Método screenOutput().
	 * Muestra la lista de PCs ordenada por pantalla.
	 * llama al método stringify().
	 * @param listaLS
	 * @param listaDM
	 * @return void
	 */
	public static void screenOutput(ArrayList<PC> listaLS, ArrayList<PC> listaDM) {
		System.out.println(stringify(listaLS, listaDM));
	}

	/**
	 * Método stringify()
	 * Convierte en string ya preformateado la información en los arraylist.
	 * Pensado para desacoplar código.
	 * @param listaLS
	 * @param listaDM
	 */
	private static String stringify(ArrayList<PC> listaLS, ArrayList<PC> listaDM) {

		Collections.sort(listaLS, Comparator.comparing(PC::getAula).thenComparing(PC::getPC));
		Collections.sort(listaDM, Comparator.comparing(PC::getAula).thenComparing(PC::getPC));

		String tempString;
		tempString = "---------------------------------------------------------------------------------------\n";
		tempString += "|                             Información de archivos lshw                            |\n";
		tempString += "---------------------------------------------------------------------------------------\n";
		for (PC p : listaLS) {
			tempString += p.toString() + "\n";
		}

		tempString += "---------------------------------------------------------------------------------------\n";
		tempString += "|                          Información de archivos dmidecode                          |\n";
		tempString += "---------------------------------------------------------------------------------------\n";
		for (PC p : listaDM) {
			tempString += p.toStringBreu() + "\n";
		}

		return tempString;
	}
}