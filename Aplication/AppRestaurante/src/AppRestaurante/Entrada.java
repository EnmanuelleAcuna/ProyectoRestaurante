/**
 * Universidad de Costa Rica
 * Programaci�n I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Alimento encargada de almacenar los atributos delos distintos alimentos
 * @author: Bryan Mar�n Quesada (B23907)
            Kevin Berm�dez Alvarado (B30957)
            Aharon Darcia Ram�rez (B22170)
 * @version: v.1		
 * @since: 06/11/2014
 */

package AppRestaurante;

public class Entrada extends Comida{
    
    public Entrada(String identificacion, String nombre, double precio){
        super(identificacion, nombre, precio);
    }
    
    public String getInformacion(){
        return "N\u00famero de identificaci\u00f3n: "+super.getIdentificacion()+"\nNombre: "+super.getNombre()+"\nPrecio: \u20A1"+super.getPrecio();
    }

}
