/**
 * 
 */
package pkgGestioFitxersInstitut;

import java.util.Scanner;

public class PC
{
    
    public String aula;
    public String PC;
    public String marca;
    public String model;
    public String numSerie;
    public String macWiFi;
    public String macEth;
	
    public  PC(){}

    public PC(String aula, String PC, String marca, String numSerie, String macWiFi, String macEth){
        this.aula=aula;
        this.PC=PC;
        this.marca=marca;
        this.numSerie=numSerie;
        this.macWiFi=macWiFi;
        this.macEth=macEth;
    }
    
    public PC(int i){
    	aula=capturar("Introdueix l'aula");
    	PC=capturar("Introdueix el nom del PC");
    	marca=capturar("Introdueix la marca");
    	numSerie=capturar("Introdueix el número de serie");
    	macWiFi=capturar("Introdueix l'adreça MAC del WiFi");
    	macEth=capturar("Introdueix la MAC de Ethernet");
    	
    }
    
    
    //para lshw
	public String toString() {
		return "Aula:" + aula + 
				" || NroPC:" + PC + 
				" || Marca:" + marca + 
				" || Model:" + model + 
				" || NroSerie:" + numSerie + 
				" || MacWifi:" + macWiFi + 
				" || MacEthernet:" + macEth+" \n" ;
	}
    
    //para dmidecode    
    public String toStringBreu(){
		return "Aula:" + aula + 
				" || NroPC:" + PC + 
				" || Marca:" + marca + 
				" || Model:" + model + 
				" || NroSerie:" + numSerie +" \n";
    }
        
    //public static PC() {}
   
    private static String capturar(String enunciado){
    	Scanner sc = new Scanner(System.in);
    	System.out.println(enunciado);
    	return sc.nextLine();
    	
    }
    
}



