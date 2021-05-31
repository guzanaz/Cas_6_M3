package Beta;
/**
 * Write a description of class Menus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menus
{
    public static void showMenus(){
        print("[p] Processar Fitxers");
        print("[i] Introduir Informació");
        print("[m] Modificar Informació d'un PC");
        print("[e] Esborrar Informació d'un PC");
        print("[c] Consultar PCs per Aula");
        print("[x] Sortir");

    }

    private static void print(String arg){System.out.println(arg);}

    public static void printTitle(String t){
        String barra="----------------------------------";
        int ancho = barra.length();
        
        print(barra);
        print(String.format("%-" + ancho  + "s", String.format("%" + (t.length() + (ancho - t.length()) / 2) + "s", t)));
        print(barra);
    }
}