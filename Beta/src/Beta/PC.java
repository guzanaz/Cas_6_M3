package Beta;
/**
 * 
 */
 

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

    public PC(String aula, String PC, String marca, String model, String numSerie, String macWiFi, String macEth){
        this.aula=aula;
        this.PC=PC;
        this.marca=marca;
        this.model = model;
        this.numSerie=numSerie;
        this.macWiFi=macWiFi;
        this.macEth=macEth;
    }
    
    /**
     * Constructor desde consola, el parámetro es "dummy" solo para cambiar la signatura
     */
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
				" || MacEthernet:" + macEth ;
	}
    
    //para dmidecode    
    public String toStringBreu(){
		return "Aula:" + aula + 
				" || NroPC:" + PC + 
				" || Marca:" + marca + 
				" || Model:" + model + 
				" || NroSerie:" + numSerie;
    }
  
    private static String capturar(String enunciado){
    	String tmpStr;
    	Scanner sc = new Scanner(System.in);
    	System.out.println(enunciado);
    	tmpStr = sc.nextLine();
    	return tmpStr;
    	
    }
    
    //Getters
    public String getAula(){return aula;}
    public String getPC(){return PC;}
    public String getMarca(){return marca;}
    public String getModel(){return model;}
    public String getNumSerie(){return numSerie;}
    public String getMacWifi(){return macWiFi;}
    public String getMacEth(){return macEth;}
    
    //Setters
    public void setAula(String aula){this.aula=aula;}
    public void setPC(String pc){this.PC=pc;}
    public void setMarca(String marca){this.marca=marca;}
    public void setModel(String model){this.model=model;}
    public void setNumSerie(String numSerie){this.numSerie=numSerie;}
    public void setMacWifi(String macWiFi){this.macWiFi=macWiFi;}
    public void setMacEth(String macEth){this.macEth=macEth;}
}


