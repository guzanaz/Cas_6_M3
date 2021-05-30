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
	
    /**
	 * @return the aula
	 */
	public String getAula() {
		return aula;
	}

	/**
	 * @param aula the aula to set
	 */
	public void setAula(String aula) {
		this.aula = aula;
	}

	/**
	 * @return the pC
	 */
	public String getPC() {
		return PC;
	}

	/**
	 * @param pC the pC to set
	 */
	public void setPC(String pC) {
		PC = pC;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the numSerie
	 */
	public String getNumSerie() {
		return numSerie;
	}

	/**
	 * @param numSerie the numSerie to set
	 */
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	/**
	 * @return the macWiFi
	 */
	public String getMacWiFi() {
		return macWiFi;
	}

	/**
	 * @param macWiFi the macWiFi to set
	 */
	public void setMacWiFi(String macWiFi) {
		this.macWiFi = macWiFi;
	}

	/**
	 * @return the macEth
	 */
	public String getMacEth() {
		return macEth;
	}

	/**
	 * @param macEth the macEth to set
	 */
	public void setMacEth(String macEth) {
		this.macEth = macEth;
	}
	//constructor vacío
	public  PC(){}
	
	
	//Constructor para lshw
    public PC(String aula, String PC, String marca, String model, String numSerie, String macWiFi, String macEth){
        this.aula=aula;
        this.PC=PC;
        this.marca=marca;
        this.model=model;
        this.numSerie=numSerie;
        this.macWiFi=macWiFi;
        this.macEth=macEth;
    }
    
    //constructor a mano
    public PC(int i){
    	aula=capturar("Introdueix l'aula");
    	PC=capturar("Introdueix el nom del PC");
    	marca=capturar("Introdueix la marca");
    	model=capturar("Introdueix el model del PC");
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



