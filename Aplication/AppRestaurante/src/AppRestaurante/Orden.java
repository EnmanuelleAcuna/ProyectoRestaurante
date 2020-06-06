/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Orden encargada de almacenar los atributos de las distintas ordenes
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 28/11/2014
 */

package AppRestaurante;

public class Orden{
    
    private String numeroMesa;
    private double precio;
    private Platillo platillos [];
    private Bebida bebidas [];
    private Postre postres [];
    private Entrada entradas [];
    
    public Orden(Platillo platillos[], Bebida bebidas[], Postre postres[], Entrada entradas[], String numeroMesa){
        setPlatillo(platillos);
        setBebida(bebidas);
        setPostre(postres);
        setEntrada(entradas);
        setNumMesa(numeroMesa);
        setPrecio();
    }
    
    public void setPlatillo(Platillo platillos[]){
        this.platillos=platillos;
    }
    
    public void setBebida(Bebida bebidas[]){
        this.bebidas=bebidas;
    }
    
    public void setPostre(Postre postres[]){
        this.postres=postres;
    }
    
    public void setEntrada(Entrada entradas[]){
        this.entradas=entradas;
    }
    
    public String getPlatillos(){
        String lista="";
            for(int i=0; i<platillos.length; i++){
                if(platillos[i]!=null)
                    lista+=" - "+platillos[i].getNombre()+" \u20A1 "+platillos[i].getPrecio()+"\n";
            }
        return lista;
    }
    
    public String getBebidas(){
        String lista="";
            for(int i=0; i<bebidas.length; i++){
                if(bebidas[i]!=null)
                    lista+=" - "+bebidas[i].getNombre()+" \u20A1 "+bebidas[i].getPrecio()+"\n";
            }
        return lista;
    }
    
    public String getPostres(){
        String lista="";
            for(int i=0; i<postres.length; i++){
                if(postres[i]!=null)
                    lista+=" - "+postres[i].getNombre()+" \u20A1 "+postres[i].getPrecio()+"\n";
            }
        return lista;
    }
    
    public String getEntradas(){
        String lista="";
            for(int i=0; i<entradas.length; i++){
                if(entradas[i]!=null)
                    lista+=" - "+entradas[i].getNombre()+" \u20A1 "+entradas[i].getPrecio()+"\n";
            }
        return lista;
    }
    
    public double calcPrecioOrden(){
        double precio=0.0;
        
            for(int i=0; i<platillos.length; i++){
                if(platillos[i]!=null)
                    precio+=platillos[i].getPrecio();
            }
            
            for(int i=0; i<bebidas.length; i++){
                if(bebidas[i]!=null)
                    precio+=bebidas[i].getPrecio();
            }
            
            
            for(int i=0; i<postres.length; i++){
                if(postres[i]!=null)
                    precio+=postres[i].getPrecio();
            }
            
            for(int i=0; i<entradas.length; i++){
                if(entradas[i]!=null)
                    precio+=entradas[i].getPrecio();
            }
        
        return
            precio;
    }
    
    public void setPrecio(){
        precio=calcPrecioOrden();
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public void setNumMesa(String numeroMesa){
        this.numeroMesa=numeroMesa;
    }
    
    public String getNumMesa(){
        return numeroMesa;
    }
    
}
