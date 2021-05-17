/**
 * 
 */
package pkgGestioFitxersInstitut;
import java.io.File;
import java.util.Scanner;

/**
 * Módulo ProcessarFitxers.
 * Pide la ruta de los ficheros a procesar.
 * Procesa todos los ficheros de un directorio.
 * Crea un archivo nuevo con la siguiente información de los PCs: Aula, PC, Marca, Modelo, Número de serie, Mac Wifi, Mac ethernet.
 * @author Daniela Gallardo Reyes
 * @version 1.0 (entrega express)
 * @since 17-05-2021
 */
public class ProcessarFitxers{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hola ");
		File f = new File("/Users/Daniela/eclipse-workspace/comprova_portatils_feb2021/dmidecode/a22_pc03 - Maria Merino Sanjuán.txt");
		try {
			Scanner lector = new Scanner(f);

			while (lector.hasNext()) {
				String s = lector.nextLine();
				System.out.println(s);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
