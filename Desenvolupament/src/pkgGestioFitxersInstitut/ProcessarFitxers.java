/**
 * 
 */
package pkgGestioFitxersInstitut;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


/**
 * Módulo ProcessarFitxers. Pide la ruta de los ficheros a procesar. Procesa
 * todos los ficheros de un directorio. Crea un archivo nuevo con la siguiente
 * información de los PCs: Aula, PC, Marca, Modelo, Número de serie, Mac Wifi, Mac ethernet.
 * @author Daniela Gallardo Reyes
 * @version 1.0 (entrega express)
 * @since 17-05-2021
 */
public class ProcessarFitxers {
    // atributos para trabajar con un objeto File tipo Directorio
    private static String dirPath;// string con la ruta
    private static File dir;// cuando sea un directorio se crea un obj.
    private static ArrayList<PC> listaPCs=new ArrayList<>();
    
	private static ArrayList<PC> listaPCsLS = new ArrayList<>();
	private static ArrayList<PC> listaPCsDM = new ArrayList<>();
  
    /**
     * Devuelve el nombre del aula basado en el nombre estandarizado del archivo
     */
    private static String nomAula(String nomfitxer){
        String[] tempReturn= new String[4];
        try {
           tempReturn = nomfitxer.split("_");
       }catch (Exception e){}
       
       return tempReturn[1];
    }
    
    /**
     *
     * Devuelve el nombre de un PC en función de un nombre de archivo
     */
    private static String nomPC(String nomfitxer){
        String[] tempReturn = new String[4];
        try{
            tempReturn = nomfitxer.split("_");
            tempReturn = tempReturn[2].split("-");
        }catch(Exception e){}
        
        return tempReturn[0];
    }  
}

