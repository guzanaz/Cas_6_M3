package vDades;
import java.util.Scanner;
import java.io.*;

public class Vdades {
	
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
