package Beta;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
* Cas_6 M03 
* Clase RegEx: Clase para convertir a String cada uno de los atributos que formarán un objeto PC.
* Desde la clase ConversorPC cargamos el String filtrado por los parámetros query que queremos convertir a String. 
* Esta clase devolverá una variable de tipo String
* Que servirá para asignar valores a los atributos de los Objetos de la clase PC. 
* @author Daniela Gallardo Reyes 
* @version 1.0 (entrega express)
* @since 17-05-2021
*/
public class RegEx {
   
	/**
	 * Método String query().
	 * Convierte en String lo que se ha filtrado utilizando parámetros RegEx. 
	 * @param pattern
	 * @param s
	 * @param grup
	 * @return matcher.group(grup) || mensaje no encontrado;
	 */
	public static  String query(String pattern, String s, int grup){
       Pattern patt = Pattern.compile(pattern);
       Matcher matcher = patt.matcher(s);
       if (matcher.find()) {
           return matcher.group(grup); 
       } else {
           return "No trobat";
       }
   }
   
}