package Beta;



import java.io.File;
import java.util.Scanner;

/**
* Cas_6 M03 
* Clase ConversorPC: Clase para convertir un archivo de texto en un objeto tipo PC.
* Desde la clase Principal cargamos el directorio. 
* Iteramos todos los ficheros tipo lshw/dmidecode añadiendolos al arraylist.
* Y aquella arraylist es la se exportará/escribirá en un fichero de texto.
* Contiene métodos que convierten String en objetos tipo PC.
* @author Daniela Gallardo Reyes 
* @version 1.2 (entrega express)
* @since 17-05-2021
*/

public class ConversorPC {

	/**
	 * Método convertirArchivoLS().
    * Convierte el texto de una descripción devuelta por comando ls en un objeto tipo PC.
    * @param File source (archivo .txt del Directorio lshw).
    * @return Objeto PC.
    */
		
   public static PC convertirArchivoLS(File source){
       PC tmpPC = new PC();
       String nomFitxer=source.getName();
       String contenidoArchivoLS = extraerContenido(source);
       
       //lo suyo sería poner todo esto con setters y que los campos estuvieran privados pero por ir más rápido...
       tmpPC.PC = nomPCLS(nomFitxer);
       tmpPC.aula=nomAulaLS(nomFitxer);
       tmpPC.marca=obtenirFabricantLS(contenidoArchivoLS);
       tmpPC.model=obtenirModelLS(contenidoArchivoLS);
       tmpPC.numSerie=obtenirNumSerieLS(contenidoArchivoLS);
       tmpPC.macEth=obtenerMacEthernetLS(contenidoArchivoLS);
       tmpPC.macWiFi=obtenerMacWifiLS(contenidoArchivoLS);
       return tmpPC;
   }

           /**
            * Método nomPCLS() 
            * Devuelve el nombre de un PC en función de un nombre de archivo (ls)
            * @param String nomfitxer
            * @return String utilizando para filtrar método query
            **/
           private static String nomPCLS(String nomfitxer){
           	String firstCapture;
           	int convertedInt;
           	
               firstCapture=RegEx.query("ls_.*?(.*)_(.*?(\\d*)) -", nomfitxer, 3);
               convertedInt=Integer.parseInt(firstCapture);
               return String.format("%02d", convertedInt);
               
           }
   
           /** 
            * Método String nomAulaLS().
            * Devuelve el nombre del aula basado en el nombre estandarizado del archivo ls 
            * @param String nomfitxer
            * @return String con el aula obtenido con el método query
            **/
           private static String nomAulaLS(String nomfitxer){
              return RegEx.query("ls_.*?(.+)_", nomfitxer, 1).toUpperCase();
              /*Si quisiéramos COGER solo el número del aula comentaríamos lo de arriba y descomentaríamos lo siguiente 
              (por ahora no lo pongo ya que hay un aula E1 y puede ser importante la letra):*/
              //return RegEx.query("ls_.*?(\\d+)_", nomfitxer, 1);
           }
           
           /** 
            * Método String obtenirFabricantLS().
            * Extrae fabricante desde la descripción del archivo ls. 
            * @param String descripción
            * @return String con el fabricante obtenido con método query 
            **/
           private static String obtenirFabricantLS(String descripcion){
               return RegEx.query("(fabricante|vendor): (.*)([\\w\\W].*){4,6}\\n\\W*(anchura: | width: ){1}", descripcion, 2);
           }
           
           
           /** 
            * Método String obtenirModelLS().
            * Extrae modelo desde la descripción devuelta por ls. 
            * @param String descripción
            * @return String con la información del producto obtenido con método query. 
            **/
               private static String obtenirModelLS(String descripcion){
               return RegEx.query("(product)o?: (.*)([\\w\\W].*){4,6}\\n\\W*(anchura: | width: ){1}",descripcion,2);
           }
           
           /**
            * Método String obtenirNumSerieLS().
            * Extrae número de serie desde descripción de lshw
            * @param String descripción
            * @return String con el nro de serie del producto obtenido con método query. 
            **/
           private static String obtenirNumSerieLS(String descripcion){
               return RegEx.query("alumne[\\s\\S]*?([^:](serial|serie)+):\\s*(.*)", descripcion, 3);
           }
           
           /**
            * Método String oobtenerMacEthernetLS().
            * Extrae la dirección mac de Ethernet desde una descripción devuelta por comando ls
            * @param String descripción
            * @return String con dirección mac de Ethernet del equipo obtenido con método query. 
            *   
            **/
           private static String obtenerMacEthernetLS(String descripcion){
               return (RegEx.query("\\*-network(([\\W\\w]*)Ethernet{1})([\\w\\W].*){4,6}\\n\\W*(serie|serial): (.*)", descripcion,5)).replaceAll(" ","");
           }
           
           
           /**
            * Método String obtenerMacWifiLS().
            * Extrae la dirección mac de wifi desde una descripción devuelta por comando ls
            * @param String descripción
            * @return String con dirección mac de Ethernet del equipo obtenido con método query. 
           **/
           private static String obtenerMacWifiLS(String descripcion){
               return RegEx.query("network[\\s\\S]*?(Wireless|inalámbrica)[\\s\\S]*?([^:](serial|serie)+):\\s*(.*)", descripcion, 4 );
           }
      
   
    
  /**
   * Método convertirArchivoDM()
   * Convierte el texto de una descripción devuelta por comando dmidecode.
   * @param File source (archivo .txt del Directorio dmidecode).
   * @return Objeto PC.
   **/ 
   public static PC convertirArchivoDM(File source){
       PC tmpPC = new PC();
       String nomFitxer=source.getName();
       String contenidoArchivoDM = extraerContenido(source);
       
       //lo suyo sería poner todo esto con setters y que los campos estuvieran privados pero por ir más rápido...
       tmpPC.PC = nomPCDM(nomFitxer);
       tmpPC.aula=nomAulaDM(nomFitxer);
       tmpPC.marca=obtenirFabricantDM(contenidoArchivoDM);
       tmpPC.model=obtenirModelDM(contenidoArchivoDM);
       tmpPC.numSerie=obtenirNumSerieDM(contenidoArchivoDM);
       tmpPC.macEth="No Trobat";
       tmpPC.macWiFi="No Trobat";
       
       return tmpPC;
   }
		    /**
		     * Método nomPCDM() 
		     * Devuelve el nombre de un PC en función de un nombre de archivo DM 
		     * @param String nomfitxer
		     * @return String utilizando para filtrar método query
		     **/
           private static String nomPCDM(String nomfitxer){
           	String firstCapture;
           	int convertedInt;
               firstCapture= RegEx.query("(.*)_(.*?(\\d*))\\s-", nomfitxer, 3).toUpperCase();
               convertedInt=Integer.parseInt(firstCapture);
               return String.format("%02d", convertedInt);
           }
   
           /** 
            * Método String nomAulaDM().
            * Devuelve el nombre del aula basado en el nombre estandarizado del archivo dmidecode. 
            * @param String nomfitxer
            * @return String con el aula obtenido con el método query
            **/
           private static String nomAulaDM(String nomfitxer){
              return RegEx.query("(.*)_", nomfitxer, 1).toUpperCase();
           }
   
           /** 
            * Método String obtenirFabricantDM().
            * Extrae fabricante desde la descripción del archivo dmidecode. 
            * @param String descripción
            * @return String con el fabricante obtenido con método query 
            **/
        
           private static String obtenirFabricantDM(String descripcion){
               return RegEx.query("System Information[\\w\\W]*?Manufacturer: (.*)", descripcion, 1);
           }
           
           /** 
            * Método String obtenirModelDM().
            * Extrae modelo desde la descripción del archivo dmidecode. 
            * @param String descripción
            * @return String con el fabricante obtenido con método query 
            **/
           private static String obtenirModelDM(String descripcion){
               return RegEx.query("System Information[\\w\\W]*?Product Name: (.*)",descripcion,1);
           }
           
           /** 
            * Método String obtenirModelDM().
            * Extrae el nro de serie desde la descripción del archivo dmidecode. 
            * @param String descripción
            * @return String con el nro de serie obtenido con método query 
            **/
           private static String obtenirNumSerieDM(String descripcion){
               return RegEx.query("System Information[\\w\\W]*?Serial(.*): (.*)", descripcion, 2);
           }
  
   
    /**Método extraerContenido().
     * Lee y guarda las líneas de un archivo .txt en un String
     * Extrae el contenido de un archivo dada su ruta completa.
     * @param File archivo (a leer y extraer contenido)
     * @return String tempStr
     */
   public static String extraerContenido(File archivo){
       String tempStr ="";
        try{
        Scanner sc = new Scanner(archivo); 
               //mientras haya líneas que leer
        		while (sc.hasNext()) {
               	//que se vaya sumando al valor string a la variable tempStr
                   tempStr += sc.nextLine() + "\n";
               }       
               sc.close();   
           }catch(Exception e){}//"handlear" en el futuro
          return tempStr;
       }
}