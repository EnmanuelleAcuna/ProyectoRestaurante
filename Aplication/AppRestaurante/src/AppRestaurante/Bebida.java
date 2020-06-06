/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Alimento encargada de almacenar los atributos delos distintos alimentos
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 10/11/2014
 */

package AppRestaurante;

public class Bebida extends Comida{
    
    public Bebida(String identificacion, String nombre, double precio){
        super(identificacion, nombre, precio);
    }
    
    public String getInformacion(){
        return "N\u00famero de Identificaci\u00f3n: "+super.getIdentificacion()+"\nNombre: "+super.getNombre()+"\nPrecio: \u20A1"+super.getPrecio();
    }

}
