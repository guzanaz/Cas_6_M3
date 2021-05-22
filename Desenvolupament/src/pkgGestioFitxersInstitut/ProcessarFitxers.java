/**
 * 
 */
package pkgGestioFitxersInstitut;

import java.io.File;
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
		leer(f);
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
	 * Method leer. Lee un archivo y filtra información específica.
	 * 
	 * @param empty.
	 * @return
	 */
	public static void leer(File f2) {
		try {
			nomfitxer = f2.getName();
			// función para obtener nombre Aula
			// imprimir línea de aula
			nomAula(nomfitxer);

			Scanner sc = new Scanner(f2);
			while (sc.hasNext()) {
				String s = sc.nextLine();
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

	/**
	 * Method nomAula. 
	 * Para obtener nombre Aula 
	 * Imprime el nro. del aula del ordenador.
	 * @param String nomfitxer2.
	 * @return res.
	 */
	private static void nomAula(String nomfitxer2) {
		System.out.print("AULA ");
			// si está en la carpeta de la consulta lshw...
			if ((nomfitxer2.charAt(0) == 'l') && (nomfitxer.charAt(1) == 's')) {
				if ((nomfitxer2.charAt(3) == 'A') || (nomfitxer2.charAt(3) == 'a')) {
					// imprime el nro de aula así:
					System.out.print(nomfitxer2.charAt(4));
					System.out.print(nomfitxer2.charAt(5));
					System.out.print(" | ");
					System.out.print(nomfitxer2.charAt(7));
					System.out.print(nomfitxer2.charAt(8));
					System.out.print(nomfitxer2.charAt(9));
					System.out.print(nomfitxer2.charAt(10));
				}
			//si está en la carpeta de la consulta dmidecode...
			}else if((nomfitxer2.charAt(0) == 'A')||(nomfitxer.charAt(0)=='a')) {
				// imprime el nro de aula así:
				System.out.print(nomfitxer2.charAt(1));
				System.out.print(nomfitxer2.charAt(2));
				System.out.print(" | ");
				System.out.print(nomfitxer2.charAt(4));
				System.out.print(nomfitxer2.charAt(5));
				System.out.print(nomfitxer2.charAt(6));
				System.out.print(nomfitxer2.charAt(7));
			}

		System.out.println(" ");// Salto de línea
		return;
	}
	
	
	
	
}
