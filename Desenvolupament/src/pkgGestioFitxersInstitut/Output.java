package pkgGestioFitxersInstitut;
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Cas_6 M03 
 * Clase Output: Clase para crear, escribir y guardar un archivo de texto. 
 * Desde la clase Principal cargamos un arraylist de objetos PC. 
 * Crea un fichero txt y escribimos los datos del arraylist.
 * @author Daniela Gallardo Reyes 
 * @version 1.2 (entrega express)
 * @since 17-05-2021
 */

public class Output {
	public static void guardarArraylist(ArrayList<PC> listaLS, ArrayList<PC> listaDM) {
		try {
			FileWriter myWriter = new FileWriter("Output.txt");
			myWriter.write("----- Información de archivos lshw ------\n");
				for (PC p : listaLS) {
				myWriter.write(p.toString() + "\n");
				}

			myWriter.write("\n_______________________________________________________\n\n");

			myWriter.write("----- Información de archivos dmidecode ------\n");
				for (PC p : listaDM) {
				myWriter.write(p.toStringBreu() + "\n");
				}

			myWriter.close();
			System.out.println("L'arxiu s'ha desat correctament");
		} catch (IOException e) {
			System.out.println("Mecachis en la mar...L'arxiu no s'ha desat correctament");
			e.printStackTrace();
		}
	}
}
