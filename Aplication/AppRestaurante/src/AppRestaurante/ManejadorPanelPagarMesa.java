/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase ManejadorPanelPagarMesa encargada de manejar los distintos eventos del panel
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 28/11/2014
 */
 
package AppRestaurante; 
 
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon; 
import javax.swing.Icon; 

public class ManejadorPanelPagarMesa extends ManejadorAbstracto{
	
    private Icon icnSafe;
    private RegistroA registroA;
    private GUIPagarMesa guiPagarMesa;
    private PanelPagarMesa panelPagarMesa;
    private Orden buscarMesa;
    
    public ManejadorPanelPagarMesa(RegistroA registroA, GUIPagarMesa guiPagarMesa, PanelPagarMesa panelPagarMesa) {
        icnSafe = new ImageIcon("Images/lock.png");
        this.registroA = registroA;
        this.guiPagarMesa = guiPagarMesa;
        this.panelPagarMesa = panelPagarMesa;
    }//Fin del constructor ManejadorAdminPostres
    
/**
 * Proposito: Agregar el eventos a los Componentes del PanelPagarMesa
 * Nombre del metodo: actionPerformed
 * @since 28/11/2014
 * @param ActionEvent e: ingresa el parametro del evento proveniente del PanelPagarMesa al accionar los componentes
*/
	
    public void actionPerformed(ActionEvent e)
    {
		if(e.getActionCommand().equalsIgnoreCase(panelPagarMesa.buscarMesa))
		{
			if(!panelPagarMesa.getTextBuscar().equals(""))
			{
				if(registroA.buscarMesaPorNum(panelPagarMesa.getTextBuscar())!=null)
				{
					panelPagarMesa.setTextPagar(Double.toString(registroA.pagarMesa(panelPagarMesa.getTextBuscar())));
					panelPagarMesa.setTextArea(registroA.infoMesaPagar(panelPagarMesa.getTextBuscar()));
				}
				else
					JOptionPane.showMessageDialog(this.guiPagarMesa, "Esta mesa no existe");
			}
			else
				JOptionPane.showMessageDialog(this.guiPagarMesa, "Debe digitar un n\u00famero de mesa");
		}
				
		if(e.getActionCommand().equalsIgnoreCase(panelPagarMesa.limpiar))
		{
			panelPagarMesa.cleanJTextField();
		}//fin del if limpiar
		
		if(e.getActionCommand().equalsIgnoreCase(panelPagarMesa.salir))
		{
			guiPagarMesa.dispose();
            JOptionPane.showMessageDialog(this.guiPagarMesa, "\u00A1Los cambios fueron guardados exitosamente\u0021", "Informaci\u00f3n General", JOptionPane.PLAIN_MESSAGE, icnSafe );
        }//Fin del if salir
			
		
        
    }//Fin del metodo actionPerformed
	
}//fin de la clase ManejadorPagarMese
