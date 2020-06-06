/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase abstracta encargada de implementar lo Eventos del mause para su uso e implementación en otras clases que extiendan de la misma
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 27/10/2014
 */

package AppRestaurante;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ManejadorAbstracto implements ActionListener{
	public abstract void actionPerformed(ActionEvent e);
}//Fin de la clase ManejadorAbstracto
