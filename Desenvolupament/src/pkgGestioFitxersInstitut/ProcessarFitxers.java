/**
 * 
 */
package pkgGestioFitxersInstitut;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * Módulo ProcessarFitxers. Pide la ruta de los ficheros a procesar. Procesa
 * todos los ficheros de un directorio. Crea un archivo nuevo con la siguiente
 * información de los PCs: Aula, PC, Marca, Modelo, Número de serie, Mac Wifi, Mac ethernet.
 * @author Daniela Gallardo Reyes
 * @version 1.0 (entrega express)
 * @since 17-05-2021
 */
public class ProcessarFitxers {
    // atributos para trabajar con un objeto File tipo Directorio
    private static String dirPath;// string con la ruta
    private static File dir;// cuando sea un directorio se crea un obj.
    private static ArrayList<PC> listaPCs=new ArrayList<>();
    
	private static ArrayList<PC> listaPCsLS = new ArrayList<>();
	private static ArrayList<PC> listaPCsDM = new ArrayList<>();
 
	/**
	 * Método procesarDirectoriosLsDm.
	 * Lee los subdirectorios del directorio indicado.
	 * Pide ingresar la ruta del directorio padre y lo procesa con el método crearDirectorio().
	 * Procesa los subdirectorios llamando al método procesaDirectorio().
	 * Guarda información extraída con el método guardarArraylist(). 
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
	 * Ordena por PC y guarda el archivo según los datos del ArrayList que tenemos
	 * en memoria
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
		sc.close();

		listaPCsLS.stream().filter(p -> p.aula.contains(aula)).forEach(p -> listaLSf.add(p));

		listaPCsDM.stream().filter(p -> p.aula.contains(aula)).forEach(p -> listaDmf.add(p));

		// Ordenamos la lista por aula
		listaLSf.sort(new NumPCSorter());
		listaDmf.sort(new NumPCSorter());

		Output.guardaPerAula(listaLSf, listaDmf);
	}

	/**
	 * Al pasarle un directorio como argumento añade al ArrayList correspondiente
	 * (según criterio) los objetos PC descritos en los archivos
	 */
	public static void procesaDirectorio(File directori) {
		File[] fitxers = directori.listFiles();
		for (File f : fitxers) {
			if (f.getName().startsWith("ls_")) {
				listaPCsLS.add(ConversorPC.convertirArchivoLS(f));
			} else {
				listaPCsDM.add(ConversorPC.convertirArchivoDM(f));
			}
		}
	}

	/**
	 * Método crearDirectorio(). Crea un atributo de tipo File que es un Directorio.
	 * Revisa si la ruta es un directorio o fichero.
	 * Si es un directorio lo retorna como un atributo tipo File.
	 * @param dirPath string con la ruta del directorio.
	 * @return nouDir atributo objeto de File con la ruta del directorio a procesar.
	 */
	private static File crearDirectorio(String dirPath) {
		File nouDir = new File(dirPath);
		System.out.println("comprovant que la ruta sigui un directori ...\n ");
		if (nouDir.isFile()) {
			System.out.println("Ruta no vàlida. Ha de ser la ruta d'un directori");
		} else if (nouDir.isDirectory()) {	
			System.out.println(nouDir.toString() +" és un directori.");
		}
		return nouDir;
	}
    
	private static class AulaPCSorter implements Comparator<PC> {
		@Override
		public int compare(PC o1, PC o2) {
			return o2.aula.compareTo(o1.aula);
		}
	}

	private static class NumPCSorter implements Comparator<PC> {
		@Override
		public int compare(PC o1, PC o2) {
			return ((o2.PC).compareTo(o1.PC));
		}
	}
    
    
    /**
     * Devuelve el nombre del aula basado en el nombre estandarizado del archivo
     */
    private static String nomAula(String nomfitxer){
        String[] tempReturn= new String[4];
        try {
           tempReturn = nomfitxer.split("_");
       }catch (Exception e){}
       
       return tempReturn[1];
    }
    
    /**
     * Devuelve el nombre de un PC en función de un nombre de archivo
     */
    private static String nomPC(String nomfitxer){
        String[] tempReturn = new String[4];
        try{
            tempReturn = nomfitxer.split("_");
            tempReturn = tempReturn[2].split("-");
        }catch(Exception e){}
        
        return tempReturn[0];
    }  
}




















//
///**
// * Módulo ProcessarFitxers. Pide la ruta de los ficheros a procesar. Procesa
// * todos los ficheros de un directorio. Crea un archivo nuevo con la siguiente
// * información de los PCs: Aula, PC, Marca, Modelo, Número de serie, Mac Wifi, Mac ethernet.
// * @author Daniela Gallardo Reyes
// * @version 1.0 (entrega express)
// * @since 17-05-2021
// */
//public class ProcessarFitxers {
//	// atributos para trabajar con un objeto File tipo Directorio
//	private static String dirPath;// string con la ruta
//	private static File dir;// cuando sea un directorio se crea un obj.
//	private static File[] fitxerTxt;// array de fitxers .txt
//	
//	//atributo para trabajar con objeto file dentro del array de ficheros .txt
//	private static String nomfitxer;
//	
//	//atributos para trabajar con nuevo fichero .txt y pasarle info procesada
//	private static String ruta;
////	private static String nomVolcatTxt;
//	private static File archivo;// archivo de texto que se creará y manipulará
//	
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		try {
//		dirPath = demanarRuta();// 1. método para ingresar path por teclado
//		dir = crearDirectorio(dirPath);// 2. inicializar valor de objeto File cuando es un directorio
//		fitxerTxt = dir.listFiles();//3. llenamos el array con la lista de ficheros en el directorio 
//		
//		//4. ordenamos alfabéticamente los archivos
//		Arrays.sort(fitxerTxt);
//		//5.informamos por pantalla que sucederá
//		System.out.println("Directori "+dir.getName()+". Llistant fitxers...");
//		System.out.println(" ");
//		
//		  
//        //6. Imprimir la lista de los ficheros dentro del directorio dado
//        for (int i = 0; i < fitxerTxt.length; i++) {
//            System.out.println("["+(i+1)+"] "+fitxerTxt[i].getName());
//        }
//		System.out.println("...\nfin lista.\n");
//		
//		//7.aquí crearemos y daremos un valor al atributo VolcatTxt
//		
//		ruta = "/Users/Daniela/eclipse-workspace/comprova_portatils_feb2021/aqui_guardar/archivo.txt";
//		
//		archivo = new File(ruta);
//		BufferedWriter bw;
//		
//		if (archivo.exists()) {
//			//el fichero ya existe
//			bw= new BufferedWriter(new FileWriter(archivo));
//			bw.write("el fichero de texto ya estaba creado");
//		}else {
//			//crear fichero pq no existe
//			bw=new BufferedWriter(new FileWriter(archivo));
//			bw.write("Acabo de crear el fichero de texto");
//		}
//		bw.close();
//		
//		//8. llamar método processarDirectori()
//		processarDirectori(fitxerTxt);//el método debería imprimir los campos específicos por cada fichero en el array 
//		
//		//9. acá escribimos dentro de volcatTxt
//		
//		
//		}catch(Exception e) {
//            System.err.println(e.getMessage());
//        }
//	}
//	
//	
//	/**
//	 * Método processarDirectori. 
//	 * Recorre el array de tipo File que contiene los ficheros .txt.
//	 * Imprime en la posición del archivo dentro del array.
//	 * Llama al método leerFiltrar() que extrae e imprime información específica.
//	 * @param fitxerTxt2un array de tipo File que contiene los ficheros .txt de un directorio
//	 * @return void
//	 */
//	private static void processarDirectori(File[] fitxerTxt2) {
//		System.out.println("Extraient dades...");
//		for (int j = 0; j < fitxerTxt2.length; j++)
//		{
//		       File nuevoArchivo=fitxerTxt2[j];
//		       System.out.println("\n[Fitxer "+(j+1)+"]");
//		       leerFiltrar(nuevoArchivo);
//		       }
//		}
//	
//	/**
//	 * Método demanarNomFitxerTxt(). 
//	 * Pide ingresar el nombre de un fichero txt por teclado.
//	 * @param empty.
//	 * @return Nomfitxer que es un String el nombre del directorio.
//	 */
//	private static String demanarNomFitxerTxt() {
//		Scanner scanner= new Scanner(System.in); 
//		String nomFitxerTxt;
//		System.out.println("Creant un nou fitxer per guardar la informació ");
//		System.out.println("extreta des del directori "+dir.getName());
//		System.out.println("-----------------------------------------");
//		System.out.println("       Ingressa el nom de el fitxer      ");
//		System.out.println("-----------------------------------------");
//		// scanner para ingresar la ruta del directorio a escanear
//		nomFitxerTxt = scanner.nextLine();
//		scanner.close();
//		return nomFitxerTxt;
//
//	}
//	
//	
//	private static File crearFitxer(String volcatTxtarchivo) {
//		File volcatTxt=new File (volcatTxtarchivo);
//
//		System.out.println("-----------------------------------------");
//		System.out.println("            Creant nou fitxer...        ");
//		System.out.println("-----------------------------------------\n");
//		
//		
//		if(volcatTxt.isFile()) {
//			System.out.println("S'ha creat el fitxer .txt"+volcatTxt.getName());
//		}
//		return volcatTxt;
//	}
//	
////	private static void escribirFitxer(String line){
////		
////	}
//	
//	/**
//	 * Método crearDirectorio().
//	 * Crea un atributo de tipo File que es un Directorio. 
//	 * Revisa si la ruta es un directorio o fichero.
//	 * Si es un fichero peta.
//	 * Si es un directorio retorna.
//	 * @param dirPath2 string con la ruta del directorio.
//	 * @return nouDir atributo tipo File con la ruta del directorio a procesar.
//	 */
//	private static File crearDirectorio(String dirPath2) {
//		File nouDir = new File(dirPath2);
//		if(nouDir.isFile()) {
//			System.out.println("Ruta no vàlida. Ha de ser la ruta d'un directori");
//		}else if (nouDir.isDirectory()) {
//			System.out.println("procesando...\n ");
//			System.out.println(nouDir.toString() + " es un directorio\n ");
//		}
//		return nouDir;
//	}
//
//	/**
//	 * Método demanarRuta(). 
//	 * Pide ingresar ruta de un directorio por teclado.
//	 * @param empty.
//	 * @return path que es un String con la ruta del directorio.
//	 */
//	private static String demanarRuta() {
//		// scanner para ingresar la ruta del directorio a escanear
//		Scanner sc = new Scanner(System.in);
//		String path;
//		System.out.println("Escriu la ruta del directori que vols processar");
//		path = sc.nextLine();
//		sc.close();
//		return path;
//	}
//
//	/**
//	 * Method obtenerArchivo. Para obtener el archivo. Pide ingresar por teclado la
//	 * Ruta del objeto File al que se desea acceder.
//	 * @param empty.
//	 * @return nuevoArchivo File object.
//	 */
//	public static File obtenerArchivo() {
//		File nuevoArchivo;
//		String path;
//		Scanner sc;
//		System.out.println("Escriu la ruta de l'arxiu que vols processar");
//		sc = new Scanner(System.in);
//		path = sc.nextLine();
//		nuevoArchivo = new File(path);
//		sc.close();
//		return nuevoArchivo;
//	}
//
//	/**
//	 * Method leerFiltrar. Lee un archivo. Filtra Aula, nro. PC, Marca, Modelo, nro.
//	 * de Serie. Imprime campos: Aula, nro. PC, Marca, Modelo, nro. de Serie.
//	 * @param f2 input tipo file para ser procesado.
//	 * @return void.
//	 */
//	public static void leerFiltrar(File f2) {
//		try {
//			nomfitxer = f2.getName();
//			// función para obtener número de Aula y número de PC
//			nomAulaPC(nomfitxer);
//			// procesar texto
//			Scanner sc = new Scanner(f2);
//			// si el padre del archivo contiene lshw
//			if ((f2.getParent()).contains("lshw")) {
//				while (sc.hasNext()) {
//					String lector = sc.nextLine();
//					// condiciones para rescatar modelo, marca y nro. de serie
//					if ((lector.contains("producto")) || (lector.contains("product"))) {
//						String[] lineaen2partes = lector.split(":");
//						String modelo = lineaen2partes[1];
//						// imprimir modelo del ordenador
//						System.out.println("Modelo: " + modelo);
//					} else if ((lector.contains("vendor")) || (lector.contains("fabricante"))) {
//						String[] lineaen2partes = lector.split(":");
//						String marca = lineaen2partes[1];
//						// imprimir marca del ordenador
//						System.out.println("Marca: " + marca);
//					} else if ((lector.contains("serie")) || (lector.contains("serial"))) {
//						String[] lineaen2partes = lector.split(":");
//						String nroSerie = lineaen2partes[1];
//						// imprimir nro. serie del ordenador
//						System.out.println("Nro. de Serie: " + nroSerie);
//					} else if ((lector.contains("width")) || (lector.contains("anchura"))) {
//						break;
//					}
//
//					// AQUÍ condiciones para sacar dirección mac y wifi cuando sea la carpeta lshw
//
//					// AQUÍ imprimir la dirección mac y wifi cuando sea la carpeta lshw
//				}
//				// si la carpeta es dmidecode
//			} else if ((f2.getParent()).contains("dmidecode")) {
//				while (sc.hasNext()) {
//					String lector = sc.nextLine();
//					// condiciones para rescatar modelo, marca y nro. de serie
//					if (lector.contains("Manufacturer")) {
//						String[] lineaen2partes = lector.split(":");
//						String marca = lineaen2partes[1];
//						// imprimir marca del ordenador
//						System.out.println("Marca: " + marca);
//
//					} else if (lector.contains("Product Name")) {
//						String[] lineaen2partes = lector.split(":");
//						String modelo = lineaen2partes[1];
//						// imprimir marca del ordenador
//						System.out.println("Modelo: " + modelo);
//					} else if (lector.contains("Serial Number")) {
//						String[] lineaen2partes = lector.split(":");
//						String nroSerie = lineaen2partes[1];
//						// imprimir nro. serie del ordenador
//						System.out.println("Nro. de Serie: " + nroSerie);
//					} else if (lector.contains("UUID")) {
//						break;
//					}
//
//					// condiciones para sacar dirección mac y wifi cuando sea la carpeta dmidecode
//					// imprimir la dirección mac y wifi cuando sea la carpeta dmidecode
//				}
//			} // fin del bloque try
//			sc.close();// cerramos scanner
//		} catch (IOException e) {
//			System.out.println(e.toString());
//		}
//	}
//
//	/**
//	 * Method nomAulaPC. 
//	 * Lee el nombre del fichero. 
//	 * Filtra el nro de Aula y nro. de ordenador. 
//	 * Imprime nro. de Aula y nro. de ordenador.
//	 * @param String nomfitxer2.
//	 * @return void
//	 */
//	private static void nomAulaPC(String nomfitxer2) {
//		
//		try {
//			System.out.print("AULA ");
//
//			// si está en la carpeta de la consulta lshw...
//			if ((nomfitxer2.charAt(0) == 'l') && (nomfitxer.charAt(1) == 's')
//				&& (nomfitxer2.charAt(3) == 'A') || (nomfitxer.charAt(3) == 'a')	
//					) {
//				for (int i = 4; i <= 5; i++) {
//					// imprime el nro de aula así:
//					System.out.print(nomfitxer2.charAt(i));
//				}
//				System.out.print(" | ");
//				for (int i = 7; i <= 10; i++)
//					System.out.print(nomfitxer2.charAt(i));
//			} // si está en la carpeta de la consulta dmidecode...
//			else if ((nomfitxer2.charAt(0) == 'A') || (nomfitxer.charAt(0) == 'a')) {
//				// imprime el nro de aula así:
//				for (int i = 1; i <= 2; i++) {
//					System.out.print(nomfitxer2.charAt(i));
//				}
//				System.out.print(" | ");
//				for (int i = 4; i <= 7; i++) {
//					System.out.print(nomfitxer2.charAt(i));
//				}
//			}
//			System.out.println(" ");// Salto de línea
//			return;
//		}  
//		catch (Exception e) {
//			System.out.println(e.toString());
//		}
//
//	}
//
//}