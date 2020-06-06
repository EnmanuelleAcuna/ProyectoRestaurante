/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Alimento encargada de almacenar los atributos delos distintos alimentos
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 06/11/2014
 */

package AppRestaurante;

public abstract class Comida{
    
	/**
	* Almacena el valor del dato identificacion ingresado por el usuario
	* @see #getIdentificacion()
	*/
    private String identificacion="";
    
    /**
	* Almacena el valor del dato identificacion ingresado por el usuario
	* @see #getNombre()
	*/
    private String nombre="";
    
    /**
	* Almacena el valor del dato precio ingresado por el usuario
	* @see #getPrecio()
	*/
    private double precio=0.0;
    
    /**
	* Proposito: Metodo constructor por defecto con parametros encargado de asignar los datos a los metodos setters y getters
	* Nomre del metodo: Alimento
	* @since: 06/11/2014
	*/
    public Comida(String identificacion, String nombre, double precio){
        setNombre(nombre);
        setIdentificacion(identificacion);
        setPrecio(precio);
    }//Fin del constructor Alimento
    
    /**
	* Proposito: Asigna el valor a variable identificacion
	* Nombre del metodo: setIdentificacion
	* @since 06/11/2014
	* @param String identificacion: String que contiene el dato de la variable identificacion
	*/
    public void setIdentificacion(String identificacion){
        this.identificacion = identificacion;
    }
    
    /**
	* Proposito: Retorna el valor de la variable identificaion
	* Nombre del metodo: getIdentificacion
	* @since 06/11/2014
	* @return identificacion
	*/
    public String getIdentificacion(){
        return identificacion;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setPrecio(double precio){
        this.precio= precio;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    /**
	* Proposito: Método abstracto para implementarse en las otras clases
	* Nombre del metodo: getInformacion
	* @since 06/11/2014
    */
    public abstract String getInformacion();
    
}//Fin de la clase Alimento
