/**
 * 
 */
package pkgGestioFitxersInstitut;

/**
 * @author Daniela
 *
 */
public class PC {
	private String aula;
	private String nroPC;
	private String marca;
	private String model;
	private String nroSerie;
	private String macWifi;
	private String macEthernet;
	
	
	
	

	
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
	 * @return the nroPC
	 */
	public String getNroPC() {
		return nroPC;
	}






	/**
	 * @param nroPC the nroPC to set
	 */
	public void setNroPC(String nroPC) {
		this.nroPC = nroPC;
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
	 * @return the nroSerie
	 */
	public String getNroSerie() {
		return nroSerie;
	}






	/**
	 * @param nroSerie the nroSerie to set
	 */
	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}






	/**
	 * @return the macWifi
	 */
	public String getMacWifi() {
		return macWifi;
	}






	/**
	 * @param macWifi the macWifi to set
	 */
	public void setMacWifi(String macWifi) {
		this.macWifi = macWifi;
	}






	/**
	 * @return the macEthernet
	 */
	public String getMacEthernet() {
		return macEthernet;
	}






	/**
	 * @param macEthernet the macEthernet to set
	 */
	public void setMacEthernet(String macEthernet) {
		this.macEthernet = macEthernet;
	}






	PC(String aula, String numPc, String marca, String model, String numeroSerie, String macWifi, String macEthernet) {

       this.aula = aula;
       this.nroPC = numPc;
       this.marca= marca;
       this.model = model;
       this.nroSerie = numeroSerie;
       this.macWifi = macWifi;
       this.macEthernet = macEthernet;

    }






	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
