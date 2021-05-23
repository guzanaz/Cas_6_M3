/**
 * 
 */
package pkgGestioFitxersInstitut;

import java.io.File;
import java.util.Arrays;
import java.io.IOException;
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
	private static File[] fitxerTxt;// array de fitxers .txt

	//atributo para trabajar con objeto file
	private static String nomfitxer;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		dirPath = demanarRuta();// 1. método para ingresar path por teclado
		dir = crearDirectorio(dirPath);// 2. inicializar valor de objeto File cuando es un directorio
		fitxerTxt = dir.listFiles();//3. llenamos el array con la lista de ficheros en el directorio 
		
		//4. ordenamos alfabéticamente los archivos
		Arrays.sort(fitxerTxt);
		//5.informamos por pantalla que sucederá
		System.out.println("Directori "+dir.getName()+". Llistant fitxers...");
		System.out.println(" ");
		  
        //6. Imprimir la lista de los ficheros dentro del directorio dado
        for (int i = 0; i < fitxerTxt.length; i++) {
            System.out.println("["+(i+1)+"] "+fitxerTxt[i].getName());
        }
		System.out.println("...\nfin lista.\n");
		
		
		//7. llamar método processarDirectori()
		processarDirectori(fitxerTxt);
		//el método debería imprimir los campos específicos por cada fichero en el array 
		
		}catch(Exception e) {
            System.err.println(e.getMessage());
        }
	}
	
	
	/**
	 * Método processarDirectori. 
	 * Recorre el array de tipo File que contiene los ficheros .txt.
	 * Imprime en la posición del archivo dentro del array.
	 * Llama al método leerFiltrar() que extrae e imprime información específica.
	 * @param fitxerTxt2un array de tipo File que contiene los ficheros .txt de un directorio
	 * @return void
	 */
	private static void processarDirectori(File[] fitxerTxt2) {
		System.out.println("Extraient dades...");
		for (int j = 0; j < fitxerTxt2.length; j++)
		{
		       File nuevoArchivo=fitxerTxt2[j];
		       System.out.println("\n[Fitxer "+(j+1)+"]");
		       leerFiltrar(nuevoArchivo);
		       }
		}
		
	
	/**
	 * Método crearDirectorio().
	 * Crea un atributo de tipo File que es un Directorio. 
	 * Revisa si la ruta es un directorio o fichero.
	 * Si es un fichero peta.
	 * Si es un directorio retorna.
	 * @param dirPath2 string con la ruta del directorio.
	 * @return nouDir atributo tipo File con la ruta del directorio a procesar.
	 */
	private static File crearDirectorio(String dirPath2) {
		File nouDir = new File(dirPath2);
		if(nouDir.isFile()) {
			System.out.println("Ruta no vàlida. Ha de ser la ruta d'un directori");
		}else if (nouDir.isDirectory()) {
			System.out.println("procesando...\n ");
			System.out.println(nouDir.toString() + " es un directorio\n ");
		}
		return nouDir;
	}

	/**
	 * Método demanarRuta(). 
	 * Pide ingresar ruta de un directorio por teclado.
	 * @param empty.
	 * @return path que es un String con la ruta del directorio.
	 */
	private static String demanarRuta() {
		// scanner para ingresar la ruta del directorio a escanear
		Scanner sc = new Scanner(System.in);
		String path;
		System.out.println("Escriu la ruta del directori que vols processar");
		path = sc.nextLine();
		sc.close();
		return path;
	}

	/**
	 * Method obtenerArchivo. Para obtener el archivo. Pide ingresar por teclado la
	 * Ruta del objeto File al que se desea acceder.
	 * @param empty.
	 * @return nuevoArchivo File object.
	 */
	public static File obtenerArchivo() {
		File nuevoArchivo;
		String path;
		Scanner sc;
		System.out.println("Escriu la ruta de l'arxiu que vols processar");
		sc = new Scanner(System.in);
		path = sc.nextLine();
		nuevoArchivo = new File(path);
		sc.close();
		return nuevoArchivo;
	}

	/**
	 * Method leerFiltrar. Lee un archivo. Filtra Aula, nro. PC, Marca, Modelo, nro.
	 * de Serie. Imprime campos: Aula, nro. PC, Marca, Modelo, nro. de Serie.
	 * @param f2 input tipo file para ser procesado.
	 * @return void.
	 */
	public static void leerFiltrar(File f2) {
		try {
			nomfitxer = f2.getName();
			// función para obtener número de Aula y número de PC
			nomAulaPC(nomfitxer);
			// procesar texto
			Scanner sc = new Scanner(f2);
			// si el padre del archivo contiene lshw
			if ((f2.getParent()).contains("lshw")) {
				while (sc.hasNext()) {
					String lector = sc.nextLine();
					// condiciones para rescatar modelo, marca y nro. de serie
					if ((lector.contains("producto")) || (lector.contains("product"))) {
						String[] lineaen2partes = lector.split(":");
						String modelo = lineaen2partes[1];
						// imprimir modelo del ordenador
						System.out.println("Modelo: " + modelo);
					} else if ((lector.contains("vendor")) || (lector.contains("fabricante"))) {
						String[] lineaen2partes = lector.split(":");
						String marca = lineaen2partes[1];
						// imprimir marca del ordenador
						System.out.println("Marca: " + marca);
					} else if ((lector.contains("serie")) || (lector.contains("serial"))) {
						String[] lineaen2partes = lector.split(":");
						String nroSerie = lineaen2partes[1];
						// imprimir nro. serie del ordenador
						System.out.println("Nro. de Serie: " + nroSerie);
					} else if ((lector.contains("width")) || (lector.contains("anchura"))) {
						break;
					}

					// AQUÍ condiciones para sacar dirección mac y wifi cuando sea la carpeta lshw

					// AQUÍ imprimir la dirección mac y wifi cuando sea la carpeta lshw
				}
				// si la carpeta es dmidecode
			} else if ((f2.getParent()).contains("dmidecode")) {
				while (sc.hasNext()) {
					String lector = sc.nextLine();
					// condiciones para rescatar modelo, marca y nro. de serie
					if (lector.contains("Manufacturer")) {
						String[] lineaen2partes = lector.split(":");
						String marca = lineaen2partes[1];
						// imprimir marca del ordenador
						System.out.println("Marca: " + marca);

					} else if (lector.contains("Product Name")) {
						String[] lineaen2partes = lector.split(":");
						String modelo = lineaen2partes[1];
						// imprimir marca del ordenador
						System.out.println("Modelo: " + modelo);
					} else if (lector.contains("Serial Number")) {
						String[] lineaen2partes = lector.split(":");
						String nroSerie = lineaen2partes[1];
						// imprimir nro. serie del ordenador
						System.out.println("Nro. de Serie: " + nroSerie);
					} else if (lector.contains("UUID")) {
						break;
					}

					// condiciones para sacar dirección mac y wifi cuando sea la carpeta dmidecode
					// imprimir la dirección mac y wifi cuando sea la carpeta dmidecode
				}
			} // fin del bloque try
			sc.close();// cerramos scanner
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Method nomAulaPC. 
	 * Lee el nombre del fichero. 
	 * Filtra el nro de Aula y nro. de ordenador. 
	 * Imprime nro. de Aula y nro. de ordenador.
	 * @param String nomfitxer2.
	 * @return void
	 */
	private static void nomAulaPC(String nomfitxer2) {
		
		try {
			System.out.print("AULA ");

			// si está en la carpeta de la consulta lshw...
			if ((nomfitxer2.charAt(0) == 'l') && (nomfitxer.charAt(1) == 's')
				&& (nomfitxer2.charAt(3) == 'A') || (nomfitxer.charAt(3) == 'a')	
					) {
				for (int i = 4; i <= 5; i++) {
					// imprime el nro de aula así:
					System.out.print(nomfitxer2.charAt(i));
				}
				System.out.print(" | ");
				for (int i = 7; i <= 10; i++)
					System.out.print(nomfitxer2.charAt(i));
			} // si está en la carpeta de la consulta dmidecode...
			else if ((nomfitxer2.charAt(0) == 'A') || (nomfitxer.charAt(0) == 'a')) {
				// imprime el nro de aula así:
				for (int i = 1; i <= 2; i++) {
					System.out.print(nomfitxer2.charAt(i));
				}
				System.out.print(" | ");
				for (int i = 4; i <= 7; i++) {
					System.out.print(nomfitxer2.charAt(i));
				}
			}
			System.out.println(" ");// Salto de línea
			return;
		}  
		catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
