package pkgGestioFitxersInstitut;
import java.util.Scanner;
import java.io.*;

/**
 * Cas_6 M03 VolcatDeDades: Programa inicial del pkgGestioFitxersInstitut. 
 * Implementa una aplicación para la gestión de la información de los PCs del Institut Montsia a través de los módulos:
 * ProcessarFitxers.java
 * IntroduirManualmentInfo.java
 * ModificarInfoPC.java
 * EsborrarInfoPC.java
 * ConsultarPCsPerAula.java
 * También Utiliza la librería java.io
 * @author Daniela Gallardo Reyes
 * @version 1.0 (entrega express)
 * @since 17-05-2021
 */

public class VolcatDeDades {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("hola ");
				File f= new File("/Users/Daniela/eclipse-workspace/comprova_portatils_feb2021/dmidecode/a22_pc03 - Maria Merino Sanjuán.txt");
		try {
			Scanner lector= new Scanner(f);
			
			while (lector.hasNext()) {
				String s= lector.nextLine();
				System.out.println(s);
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
