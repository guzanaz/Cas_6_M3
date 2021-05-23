/**
 * 
 */
package pkgGestioFitxersInstitut;

import java.io.File;
import java.io.IOException;
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
		String Parent="";
		try {
			nomfitxer = f2.getName();
			// función para obtener número de Aula y número de PC
			nomAulaPC(nomfitxer);
			// procesar texto
			Scanner sc = new Scanner(f2);
			// si el nombre del fichero contiene ls
			if (nomfitxer.contains("ls")) {
				while (sc.hasNext()) {
					String lector = sc.nextLine();
					// condiciones para rescatar modelo, marca y nro. de serie
					if ((lector.contains("producto")) || (lector.contains("product"))) {
						String[] lineaen2partes = lector.split(":");
						String parametro = lineaen2partes[1];
						// imprimir modelo del ordenador
						System.out.println("Modelo: " + parametro);

					} else if ((lector.contains("vendor")) || (lector.contains("fabricante"))) {
						String[] lineaen2partes = lector.split(":");
						String parametro = lineaen2partes[1];
						// imprimir marca del ordenador
						System.out.println("Marca: " + parametro);
					} else if ((lector.contains("serie")) || (lector.contains("serial"))) {
						String[] lineaen2partes = lector.split(":");
						String parametro = lineaen2partes[1];
						// imprimir nro. serie del ordenador
						System.out.println("Nro. de Serie: " + parametro);
					}
					else if ((lector.contains("width")) || (lector.contains("anchura"))) {
						break;
					}
					
					//condiciones para sacar dirección mac y wifi cuando sea la carpeta lshw
					
					//imprimir la dirección mac y wifi cuando sea la carpeta lshw
				}
					
			} else if((f2.getParent()).contains("dmidecode")){
				while (sc.hasNext()) {
					String lector = sc.nextLine();
					// condiciones para rescatar modelo, marca y nro. de serie
					if (lector.contains("Manufacturer")) {
						String[] lineaen2partes = lector.split(":");
						String marca = lineaen2partes[1];
						// imprimir marca del ordenador
						System.out.println("Marca: " + marca);

					} else if(lector.contains("Product Name")) {
						String[] lineaen2partes = lector.split(":");
						String modelo = lineaen2partes[1];
						// imprimir marca del ordenador
						System.out.println("Modelo: " + modelo);
					} else if (lector.contains("Serial Number")){
						String[] lineaen2partes = lector.split(":");
						String nroSerie = lineaen2partes[1];
						// imprimir nro. serie del ordenador
						System.out.println("Nro. de Serie: " + nroSerie);
					}
					else if (lector.contains("UUID")){
						break;
					}
		
					//condiciones para sacar dirección mac y wifi cuando sea la carpeta dmidecode
					//imprimir la dirección mac y wifi cuando sea la carpeta dmidecode
				}
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Method nomAulaPC. Para obtener e imprimir número de aula y de ordenador.
	 * 
	 * @param String nomfitxer2.
	 * @return res.
	 */
	private static void nomAulaPC(String nomfitxer2) {
		System.out.print("AULA ");
		// si está en la carpeta de la consulta lshw...
		if ((nomfitxer2.charAt(0) == 'l') && (nomfitxer.charAt(1) == 's')) {
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

}
