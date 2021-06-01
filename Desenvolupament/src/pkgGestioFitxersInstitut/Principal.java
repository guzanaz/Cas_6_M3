package pkgGestioFitxersInstitut;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * Cas_6 M03 Principal: Programa inicial del pkgGestioFitxersInstitut.
 * Implementa una aplicación para la gestión de la información de los PCs del
 * Institut Montsia a través de los módulos:  
 * Menus.java
 * PC.java
 * ConversorPC.java 
 * Output.java 
 * RegEx.java
 * @author Daniela Gallardo Reyes
 * @version 1.2 (entrega express)
 * @since 17-05-2021
 */

public class Principal {
	private static ArrayList<PC> listaPCsLS = new ArrayList<>();
	private static ArrayList<PC> listaPCsDM = new ArrayList<>();
	private static String outputDefaultPath = "/Users/Daniela/eclipse-workspace/Cas_6_M3/Desenvolupament/Output.txt";

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

	public static void main(String[] args) {
		

		// Variable para salir del programa
		boolean sortir = false;
		Scanner sc = new Scanner(System.in);

		do {
			// var para guardarnos la opcion seleccionada
			char opcio;// =' ';

			Menus.printTitle("|              MENÚ              |");
			Menus.showMenus();

			System.out.println("----------------------------------");
			System.out.println("|          QUÉ VOLS FER?         |");
			System.out.println("----------------------------------");
			System.out.println("       [ingressa una opció]       ");

			opcio = sc.next().charAt(0);

			switch (opcio) {
			case 'p':
				Menus.printTitle("       [p] Processar Fitxers      ");
				procesarDirectoriosLsDm();
				break;
			case 'i':
				Menus.printTitle("     [i] Introduir Informació     ");
				listaPCsLS.add(new PC(0));
				Output.guardarArraylist(listaPCsLS, listaPCsDM, outputDefaultPath);
				break;
			case 'm':
				Menus.printTitle(" [m] Modificar Informació d'un PC ");
				modificarDatos("Indica el número de serie del PC que vulguis modificar:");
				break;
			case 'e':
				Menus.printTitle("  [e] Esborrar Informació d'un PC  ");
				eliminarPC("Indica el número de serie del PC que vulguis eliminar del sistema:");
				break;
			case 'c':
				Menus.printTitle("    [c] Consultar PCs per Aula    ");
				filtrarPorAula();
				break;
			case 'x':
				Menus.printTitle("            [x]Sortir!           ");
				System.out.println("      Fi del programa. Adeu!     ");
				System.out.println("---------------------------------");
				sortir = true;
				break;
			default:
				Menus.printTitle("|COMPTE! has d'ingressar una opció vàlida!|");
			}
		} while (sortir == false);
		sc.close();
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

		Output.guardarArraylist(listaPCsLS, listaPCsDM, outputDefaultPath);
	}

	/**
	 * Método crearDirectorio(). Crea un atributo de tipo File que es un Directorio.
	 * Revisa si la ruta es un directorio o fichero. Si es un directorio lo retorna
	 * como un atributo tipo File.
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
		try {
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
		} catch (Exception e) {
			System.out.println("No es un directori vàlid");
		}
	}

	/**
	 * Método filtrarPorAula(). Pide ingresar el nro. de aula para filtrar los PCs
	 * en el aula específicada. Ordena por PC y guarda el archivo según los datos
	 * del ArrayList que tenemos en memoria.
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

		Output.screenOutput(listaLSf, listaDmf);
		Output.guardaPerAula(listaLSf, listaDmf);
	}

	/**
	 * Método eliminarPC()
	 * Procedimiento de eliminación de PCs de las listas según opción de menú
	 * @param missatge que es la indicación que aparecerá por pantalla 
	 * @return ejecución del método eliminaInfo() para ambas listas de PCs
	 */
	public static boolean eliminarPC(String missatge) {
		Scanner sc = new Scanner(System.in);
		String numSerieElim;
		Output.screenOutput(listaPCsLS, listaPCsDM);
		System.out.println(missatge);
		numSerieElim = sc.nextLine();

		return  eliminaInfo(numSerieElim, listaPCsLS) && eliminaInfo(numSerieElim, listaPCsDM);
	}

	/**
	 * Método modificarDatos().
	 * Para modificar PCs, de paso elimina los objetos duplicados.
	 * @param missatge (String que recibe desde la llamada del método con indicaciones para desplegar por pantalla)
	 * @return void
	 */
	public static void modificarDatos(String missatge) {
		if (eliminarPC(missatge)) {

			PC tmpPC = new PC(0);
			listaPCsLS.add(tmpPC);
			listaPCsDM.add(tmpPC);
			outputs();
		}
	}

	/**
	 * Método eliminaInfo()
	 * Elimina información de un PC en un ArrayList determinado.
	 * Actualiza la información llamando al método outputs()
	 * @param numSerie
	 * @param listaPC
	 * @param tmpBool booleano que me indicará si se ha ejecutado bien o no
	 */
	private static boolean eliminaInfo(String numSerie, ArrayList<PC> listaPC) {
		ArrayList<PC> criteria = new ArrayList<>();
		boolean tmpBool = false;
		try {
			for (PC p : listaPC) {
				if (p.getNumSerie().equals(numSerie)) {
					criteria.add(p);
					tmpBool = tmpBool || true;
				}
			}

			listaPC.removeAll(criteria);
		} catch (Exception e) {
		}
		//guardar outputs
		outputs();
		return tmpBool;
	}
	/**
	 * Método outputs().
	 * Para resumir por default dos acciones constantes al momento de modificar información de PC.
	 * Actualiza información; llama a dos métodos de la clase Output:
	 * screenOutput()
	 * guardarArraylist()
	 * @param 
	 * @return void
	 */
	private static void outputs() {
		Output.screenOutput(listaPCsLS, listaPCsDM);
		Output.guardarArraylist(listaPCsLS, listaPCsDM, outputDefaultPath);
	}

}