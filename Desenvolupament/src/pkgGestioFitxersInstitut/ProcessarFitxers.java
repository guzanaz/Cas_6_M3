/**
 * 
 */
package pkgGestioFitxersInstitut;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Módulo ProcessarFitxers. Pide la ruta de los ficheros a procesar. Procesa
 * todos los ficheros de un directorio. Crea un archivo nuevo con la siguiente
 * información de los PCs: Aula, PC, Marca, Modelo, Número de serie, Mac Wifi,
 * Mac ethernet.
 * 
 * @author Daniela Gallardo Reyes
 * @version 1.0 (entrega express)
 * @since 17-05-2021
 */
public class ProcessarFitxers {
	private static File f;
	private static String nomfitxer;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f = obtenerArchivo();
		leerFiltrar(f);
	}

	/**
	 * Method obtenerArchivo. Para obtener el archivo. Pide ingresar por teclado la
	 * ruta del objeto File al que se desea acceder.
	 * 
	 * @param empty.
	 * @return a File object.
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
	 * Method leerFiltrar. Lee un archivo y filtra información específica.
	 * 
	 * @param empty.
	 * @return
	 */
	public static void leerFiltrar(File f2) {
		try {
			nomfitxer = f2.getName();
			// función para obtener número de Aula y número de PC
			nomAulaPC(nomfitxer);
			//procesar texto
			Scanner sc = new Scanner(f2);
			
			while (sc.hasNext()) {
				String s = sc.nextLine();
				//método para obtener marca
				getMarca(f2,s);
				// imprimir los campos de la marca y modelo
				if ((s.contains("Product Name")) || // dmidecode
						(s.contains("producto")) || // lshw
						(s.contains("vendor")) || // lshw
						(s.contains("Manufacturer")) || // dmidecode
						(s.contains("serial")) || // lshw
						(s.contains("Serial Number"))) { // dmidecode
					System.out.println(s);
					// evitar que imprima información de placa base y posteriores
				} else if (s.contentEquals("Base Board Information")) {
					System.exit(0);
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private static void getMarca(File f2,String s) {
		System.out.println(f2.getParent());			
		
		
	}

	/**
	 * Method nomAulaPC. 
	 * Para obtener e imprimir número de aula y de ordenador.
	 * @param String nomfitxer2.
	 * @return res.
	 */
	private static void nomAulaPC(String nomfitxer2) {
		System.out.print("AULA ");
			// si está en la carpeta de la consulta lshw...
			if ((nomfitxer2.charAt(0) == 'l') && (nomfitxer.charAt(1) == 's')) {
				for(int i=4;i<=5;i++) {
					// imprime el nro de aula así:
					System.out.print(nomfitxer2.charAt(i));
				}
					System.out.print(" | ");
				for(int i=7;i<=10;i++)	
					System.out.print(nomfitxer2.charAt(i));
				}//si está en la carpeta de la consulta dmidecode...
			else if((nomfitxer2.charAt(0) == 'A')||(nomfitxer.charAt(0)=='a')) {
				// imprime el nro de aula así:
				for (int i=1;i<=2;i++) {
					System.out.print(nomfitxer2.charAt(i));
				}
				System.out.print(" | ");
				for (int i=4; i<=7;i++) {
					System.out.print(nomfitxer2.charAt(i));
				}
			}
		System.out.println(" ");// Salto de línea
		return;
	}
	
	
	
	
}
