package pkgGestioFitxersInstitut;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Cas_6 M03 Principal: Programa inicial del pkgGestioFitxersInstitut.
 * Implementa una aplicación para la gestión de la información de los PCs del
 * Institut Montsia a través de los módulos: ProcessarFitxers.java PC.java
 * ConversorPC.java Output.java IntroduirManualmentInfo.java
 * ModificarInfoPC.java EsborrarInfoPC.java ConsultarPCsPerAula.java
 * 
 * @author Daniela Gallardo Reyes
 * @version 1.2 (entrega express)
 * @since 17-05-2021
 */

public class Principal {
	private static ArrayList<PC> listaPCsLS = new ArrayList<>();
	private static ArrayList<PC> listaPCsDM = new ArrayList<>();

	/**
	 * @return the listaPCsLS
	 */
	public static ArrayList<PC> getListaPCsLS() {
		return listaPCsLS;
	}

	/**
	 * @param listaPCsLS the listaPCsLS to set
	 */
	public static void setListaPCsLS(ArrayList<PC> listaPCsLS) {
		Principal.listaPCsLS = listaPCsLS;
	}

	/**
	 * @return the listaPCsDM
	 */
	public static ArrayList<PC> getListaPCsDM() {
		return listaPCsDM;
	}

	/**
	 * @param listaPCsDM the listaPCsDM to set
	 */
	public static void setListaPCsDM(ArrayList<PC> listaPCsDM) {
		Principal.listaPCsDM = listaPCsDM;
	}

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
				// llamar método que pide ruta del directorio a procesar
				procesarDirectoriosLsDm();
				break;

			case 'i':
				System.out.println("----------------------------------");
				System.out.println("     [i] Introduir Informació     ");
				System.out.println("----------------------------------");
				listaPCsLS.add(new PC(0));
				break;
			case 'm':
				System.out.println("----------------------------------");
				System.out.println(" [m] Modificar Informació d'un PC ");
				System.out.println("----------------------------------");

				break;

			case 'e':
				System.out.println("-----------------------------------");
				System.out.println("  [e] Esborrar Informació d'un PC  ");
				System.out.println("-----------------------------------");

				break;

			case 'c':
				System.out.println("----------------------------------");
				System.out.println("    [c] Consultar PCs per Aula    ");
				System.out.println("----------------------------------");
				filtrarPorAula();
				break;
			case 'x':
				System.out.println("---------------------------------");
				System.out.println("            [x]Sortir!           ");
				System.out.println("---------------------------------");
				System.out.println("      Fi del programa. Adeu!     ");
				System.out.println("---------------------------------");
				sortir = true;
				break;

			default:
				System.out.println("\n-------------------------------------------");
				System.out.println("|COMPTE! has d'ingressar una opció vàlida!|");
				System.out.println("-------------------------------------------\n");
				sortir = false;
			}
		} while (sortir == false);

		sc.close();
	}// fin del main

	/**
	 * Función Menú. Muestra el menú de opciones por pantalla y pide ingresar una
	 * opción del menú por teclado.
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
		System.out.println("----------------------------------");
		System.out.println("|          QUÉ VOLS FER?         |");
		System.out.println("----------------------------------");
		System.out.println("       [ingressa una opció]       ");

			// entrada por teclado
			Scanner sc = new Scanner(System.in);
			// guardamos la entrada en opcio
			try {
			char opcio1 = sc.next().charAt(0);
			return opcio1;

			// retornamos opcio al main
			}catch(Exception e) {				

			}
			return ' ' ;

	}

	/**
	 * Método procesarDirectoriosLsDm. Lee los subdirectorios del directorio
	 * indicado. Pide ingresar la ruta del directorio padre y lo procesa con el
	 * método crearDirectorio(). Procesa los subdirectorios llamando al método
	 * procesaDirectorio(). Guarda información extraída con el método
	 * guardarArraylist().
	 * 
	 * @param empty
	 * @return void
	 */
	public static void procesarDirectoriosLsDm() {
		String path;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introdueix el directori que conté les carpetes lshw i dmidecode");
		path = sc.nextLine();

		File parent = crearDirectorio(path);

		File fileLS = new File(parent, "lshw");
		File fileDm = new File(parent, "dmidecode");

		procesaDirectorio(fileLS);
		procesaDirectorio(fileDm);

		Output.guardarArraylist(listaPCsLS, listaPCsDM);
	}

	/**
	 * Método crearDirectorio(). Crea un atributo de tipo File que es un Directorio.
	 * Revisa si la ruta es un directorio o fichero. Si es un directorio lo retorna
	 * como un atributo tipo File.
	 * 
	 * @param dirPath string con la ruta del directorio.
	 * @return nouDir atributo objeto de File con la ruta del directorio a procesar.
	 */
	public static File crearDirectorio(String dirPath) {
		File nouDir = new File(dirPath);
		System.out.println("comprovant que la ruta sigui un directori ...\n ");
		if (nouDir.isFile()) {
			System.out.println("Ruta no vàlida. Ha de ser la ruta d'un directori");
		} else if (nouDir.isDirectory()) {
			System.out.println(nouDir.toString() + " és un directori." + "\n");
		}
		return nouDir;
	}

	/**
	 * Método procesaDirectorio(). Al pasarle un directorio como argumento añade al
	 * ArrayList correspondiente (según criterio) los objetos PC descritos en los
	 * archivos.
	 * 
	 * @param File directori
	 * @return void
	 */
	public static void procesaDirectorio(File directori) {
		// guaradamos en un array los ficheros del directorio a procesar
		File[] fitxers = directori.listFiles();
		// recorre el arrayList idea bucle for each
		for (File f : fitxers) {
			// para lshw
			if (f.getName().startsWith("ls_")) {
				listaPCsLS.add(ConversorPC.convertirArchivoLS(f));
				// para dmidecode
			} else {
				listaPCsDM.add(ConversorPC.convertirArchivoDM(f));
			}
		}
	}

	/**
	 * Método filtrarPorAula(). Pide ingresar el nro. de aula para filtrar los PCs
	 * en el aula específicada. Ordena por PC y guarda el archivo según los datos
	 * del ArrayList que tenemos en memoria.
	 * 
	 * @param
	 * @return void
	 */
	public static void filtrarPorAula() {
		// Probando filtrado
		String aula;
		ArrayList<PC> listaLSf, listaDmf;
		listaLSf = new ArrayList<>();
		listaDmf = new ArrayList<>();

		// Pedimos el aula que queremos filtrar
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix l'aula que vulguis filtrar: \n");
		aula = sc.nextLine();

		listaPCsLS.stream().filter(p -> p.aula.contains(aula)).forEach(p -> listaLSf.add(p));

		listaPCsDM.stream().filter(p -> p.aula.contains(aula)).forEach(p -> listaDmf.add(p));

		// Ordenamos la lista por aula
		listaLSf.sort(new AulaPCSorter());
		listaLSf.sort(new NumPCSorter());
		listaDmf.sort(new AulaPCSorter());
		listaDmf.sort(new NumPCSorter());

		Output.guardaPerAula(listaLSf, listaDmf);
	}

	public static class AulaPCSorter implements Comparator<PC> {
		@Override
		public int compare(PC o1, PC o2) {
			return o2.aula.compareTo(o1.aula);
		}
	}

	public static class NumPCSorter implements Comparator<PC> {
		@Override
		public int compare(PC o1, PC o2) {
			return ((o1.PC).compareTo(o2.PC));
		}
	}

}
