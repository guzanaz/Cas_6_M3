/**
 * 
 */
package pkgGestioFitxersInstitut;

public class PC
{
    
    public String aula;
    public String PC;
    public String marca;
    public String model;
    public String numSerie;
    public String macWiFi;
    public String macEth;
	
    public PC(String aula, String PC, String marca, String numSerie, String macWiFi, String macEth){
        this.aula=aula;
        this.PC=PC;
        this.marca=marca;
        this.numSerie=numSerie;
        this.macWiFi=macWiFi;
        this.macEth=macEth;
    }
    
    public PC(){}
    //para lshw
	public String toString() {
		return "Aula:" + aula + 
				"\nNroPC:" + PC + 
				"\nMarca:" + marca + 
				"\nModel:" + model + 
				"\nNroSerie:" + numSerie + 
				"\nMacWifi:" + macWiFi + 
				"\nMacEthernet:" + macEth+" \n" ;
	}
    
    //para dmidecode    
    public String toStringBreu(){
		return "Aula:" + aula + 
				"\nNroPC:" + PC + 
				"\nMarca:" + marca + 
				"\nModel:" + model + 
				"\nNroSerie:" + numSerie +" \n";
    }
        
    
   
    
    
}



