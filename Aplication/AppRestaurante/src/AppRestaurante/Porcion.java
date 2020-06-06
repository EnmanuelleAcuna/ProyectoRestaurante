/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Porcion encargada de almacenar los atributos de las distintas porciones
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 11/11/2014
 */

package AppRestaurante;

public class Porcion extends Comida{
    private String tipo="";
    
    public Porcion(String identificacion, String nombre, double precio, String tipo){
        super(identificacion, nombre, precio);
        setTipo(tipo);
    }//fin metodo
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }//fin metodo
    
    public String getTipo(){
        return tipo;
    }//fin metodo
    
    public String getInformacion(){
        return "N\u00famero de Identificaci\u00f3n: "+super.getIdentificacion()+"\nNombre: "+super.getNombre()+"\nPrecio: \u20A1"+super.getPrecio()+"\nTipo: "+this.getTipo();
    }//Fin metodo

}//fin clase
