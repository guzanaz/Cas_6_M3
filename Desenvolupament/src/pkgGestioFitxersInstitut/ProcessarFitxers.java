/**
 * 
 */
package pkgGestioFitxersInstitut;

import java.io.File;
import java.util.Scanner;

/**
 * @author Daniela
 *
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
