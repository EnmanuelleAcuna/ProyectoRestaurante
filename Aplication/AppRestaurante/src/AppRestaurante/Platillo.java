/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Platillo encargada de almacenar los atributos de las distintas porciones
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 20/11/2014
 */

package AppRestaurante;

public class Platillo extends Comida implements Cloneable{
    private Porcion porciones[];
    
    public Platillo(String identificacion, String nombre, double precio, String tipo, Porcion [] porciones){
        super(identificacion, nombre, precio);
        setPorcion(porciones);
        actualizarPrecio();
    }//Fin metodo constructor
    
    public Platillo(){
        super("","",0.0);
    }//fin metodo constructor
    
    public void setPorcion(Porcion porciones[]){
        this.porciones = porciones;
    }//fin metodo
    
    public String getPlatillo(){
        String lista="";
        for(int i=0; i<porciones.length; i++){
            if(porciones[i]!=null)
                lista+=(i+1)+". "+porciones[i].getNombre()+"\n";
        }//fin for
    return lista;
    }//fin metodo
    
//21//11/2014
    public double calcPrecioPlatillo(){
        double lista=0.0;
        for(int i=0; i<porciones.length; i++){
            if(porciones[i]!=null)
                lista+=porciones[i].getPrecio();
        }//fin for
    return lista;
    }//fin metodo
    
    public void agregarPorcion(Porcion porcion){
        for(int i=0; i<porciones.length; i++){
            if(porciones[i]==null){
                porciones[i]=porcion;
                actualizarPrecio();
            break;
            }//fin if
        }//fin for
    }//fin metodo
    
    public void actualizarPrecio(){
        super.setPrecio(calcPrecioPlatillo());
    }//fin metodo
    
    public void eliminar(String nombre){
        for(int i=0; i<porciones.length; i++){
            if(porciones[i]!=null){
                if(porciones[i].getNombre().equals(nombre)){
                    porciones[i]=null;
                    actualizarPrecio();
                    break;
                }//fin if
            }//fin if
        }//Fin for
    }//fin metodo
    
    public String getInformacion(){
        return "N\u00famero de Identificaci\u00f3n: "+super.getIdentificacion()+"\nNombre: "+super.getNombre()+"\nPrecio: \u20A1"+super.getPrecio()+"\nPlatillo: \n"+getPlatillo();
    }//fin metodo
    
    public Object clone() {
        Platillo obj = new Platillo();
            try {
                obj = (Platillo)super.clone();
            }//Fin try
            
            catch (CloneNotSupportedException ex) {
                System.out.println("No se puede clonar");
            }//fin catch
    return (Platillo)obj;
    }//Fin del metodo
}//fin clase
