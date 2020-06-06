/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Mesa encargada de almacenar los atributos de las distintas mesas
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 15/11/2014
 */

package AppRestaurante;

public class Mesa
{
	private String numMesa="";
	private boolean disponibilidad=false;
    
//15//11/2014
	public Mesa(String numMesa, boolean disponibilidad){
		setNumMesa(numMesa);
		setDisponibilidad(disponibilidad);
	}
	
	public void setNumMesa(String numMesa){
		this.numMesa= numMesa;
	}
	public void setDisponibilidad(boolean disponibilidad){
		this.disponibilidad= disponibilidad;
	}	
	
	public String getNumMesa(){
		return numMesa;
	}
    
	public boolean getDisponibilidad(){
		return disponibilidad;
	}
	
}//fin de la clase
