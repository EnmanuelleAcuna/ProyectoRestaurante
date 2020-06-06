/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Main encargada de arranque o ejecución del programa
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 28/10/2014
 */

package AppRestaurante;

public class Main{
    
    private static GUIPrincipal guiPrincipal;
    
/**
 * Proposito: Metodo principal encargado de la ejecucion o del arranque del programa
 * Nomre del metodo: main
 * @since: 28/10/2014
 * @param: args Array de Strings.
 * @return: No devuelve ningun valor
*/
    public static void main(String args[]){
        guiPrincipal = new GUIPrincipal();
    }//Fin del metodo main
}//Fin de la clase Main
