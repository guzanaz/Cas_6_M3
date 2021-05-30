package pkgGestioFitxersInstitut;
import java.io.File;
import java.io.IOException; // Import the IOException class to handle errors
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
			myWriter.write("---------------------------------------------------------------------------------------\n");
			myWriter.write("|                             Información de archivos lshw                            |\n");
			myWriter.write("---------------------------------------------------------------------------------------\n");
				for (PC p : listaLS) {
				myWriter.write(p.toString() + "\n");
				}

			myWriter.write("---------------------------------------------------------------------------------------\n");
			myWriter.write("|                          Información de archivos dmidecode                          |\n");
			myWriter.write("---------------------------------------------------------------------------------------\n");
				for (PC p : listaDM) {
					myWriter.write(p.toStringBreu() + "\n");
				}

			myWriter.close();
			
			File output=new File("/Users/Daniela/eclipse-workspace/Cas_6_M3/Desenvolupament/Output.txt");
			System.out.println("L'arxiu s'ha desat correctament en: \n"+ output.getAbsolutePath()+"\n");
			
		} catch (IOException e) {
			System.out.println("Mecachis en la mar...L'arxiu no s'ha desat correctament");
			e.printStackTrace();
		}
	}
	
	
public static void guardaPerAula(ArrayList<PC> listaLS, ArrayList<PC> listaDM) {
		String nom;
		Scanner leer= new Scanner(System.in);
		System.out.println("Escriu el nom del ficher per a guardar la informació");
		nom= leer.nextLine();
		nom+=".txt";
		leer.close();
		try {
			FileWriter myWriter = new FileWriter(nom);
			myWriter.write("---------------------------------------------------------------------------------------\n");
			myWriter.write("|                             Información de archivos lshw                            |\n");
			myWriter.write("---------------------------------------------------------------------------------------\n");
				for (PC p : listaLS) {
				myWriter.write(p.toString() + "\n");
				}

			myWriter.write("---------------------------------------------------------------------------------------\n");
			myWriter.write("|                          Información de archivos dmidecode                          |\n");
			myWriter.write("---------------------------------------------------------------------------------------\n");
				for (PC p : listaDM) {
					myWriter.write(p.toStringBreu() + "\n");
				}

			myWriter.close();
			
			File output=new File("/Users/Daniela/eclipse-workspace/Cas_6_M3/Desenvolupament/"+nom);
			System.out.println("L'arxiu s'ha desat correctament en: \n"+ output.getAbsolutePath()+"\n");
			
		} catch (IOException e) {
			System.out.println("Mecachis en la mar...L'arxiu no s'ha desat correctament");
			e.printStackTrace();
		}
	}
	
	
	
}
