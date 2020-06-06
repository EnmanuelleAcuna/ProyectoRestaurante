/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Manejadora de los eventos provenientes del ManejadorAgregarOrdenMesa
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 04/11/2014
 */

package AppRestaurante;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon; 
import javax.swing.Icon; 

public class ManejadorAgregarOrdenMesa extends ManejadorAbstracto{
    
	private GUIAgregarOrdenMesa guiAgregarOrdenMesa;
    private PanelAgregarOrdenMesa panelAgregarOrdenMesa;
    private RegistroA registroA;
    private Platillo platillos[];
    private Platillo platilloSearch;
    private Entrada entradas[];
    private Bebida bebidas[];
    private Postre postres[];
    private Orden orden;
    private Icon icnSafe;
    private double precio;
    private String strPrecio;
    private int confirm;
    
    public ManejadorAgregarOrdenMesa(RegistroA registroA, GUIAgregarOrdenMesa guiAgregarOrdenMesa, PanelAgregarOrdenMesa panelAgregarOrdenMesa) {
		this.guiAgregarOrdenMesa = guiAgregarOrdenMesa;
        this.panelAgregarOrdenMesa = panelAgregarOrdenMesa;
        this.registroA = registroA;
        icnSafe = new ImageIcon("Images/lock.png");
    }//Fin del constructor ManejadorAdminEntradas
    
/**
 * Proposito: Agregar el eventos a los Componentes del PanelAgregarOrdenMesa
 * Nombre del metodo: actionPerformed
 * @since 26/11/2014
 * @param ActionEvent e: ingresa el parametro del evento proveniente del PanelAgregarOrdenMesa al accionar los componentes
*/
	public void actionPerformed(ActionEvent e){
        
        if(e.getActionCommand().equalsIgnoreCase(panelAgregarOrdenMesa.salir)){
            guiAgregarOrdenMesa.dispose();
        }//fin if
        
        if(e.getActionCommand().equalsIgnoreCase("Agregar Orden a Mesa")){
            if(registroA.getStateOfMesa(panelAgregarOrdenMesa.getSelectedItem())!=false){
                platillos = panelAgregarOrdenMesa.platillosSeleccionados();
                bebidas = panelAgregarOrdenMesa.bebidasSeleccionadas();
                postres = panelAgregarOrdenMesa.postresSeleccionados();
                entradas = panelAgregarOrdenMesa.entradasSeleccionadas();
                orden = new Orden(platillos, bebidas, postres, entradas, panelAgregarOrdenMesa.getSelectedItem());
                registroA.agregarOrden(orden);
                JOptionPane.showMessageDialog(null, "Orden agregada exitosamente");
                guiAgregarOrdenMesa.dispose();
                guiAgregarOrdenMesa = new GUIAgregarOrdenMesa(registroA);
            }else
                JOptionPane.showMessageDialog(null, "La mesa no existe o no se encuentra disponible");
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase("P")){
            panelAgregarOrdenMesa.enabledPersonalizar(1);
            panelAgregarOrdenMesa.actionPersonalizar();
            registroA.agregarPlatilloTemp(panelAgregarOrdenMesa.getSelectedValueJListPlatillos());
        }//fin if
          
        if(e.getActionCommand().equalsIgnoreCase("Agregar Orden")){
            registroA.agregarPorcionesPlatilloTemp(panelAgregarOrdenMesa.getSelectedValueJListPlatillos(), panelAgregarOrdenMesa.getSelectedValueOfPorciones());
            platilloSearch=registroA.consultarPlatilloTemp(panelAgregarOrdenMesa.getSelectedValueJListPlatillos());
            panelAgregarOrdenMesa.setTxtPrecio(Double.toString(platilloSearch.getPrecio()));
            panelAgregarOrdenMesa.setTextJTextField(platilloSearch.getPlatillo());
        }//fin if
        
        if(e.getActionCommand().equalsIgnoreCase("Eliminar Orden")){
            registroA.eliminarPorcionesPlatilloTemp(panelAgregarOrdenMesa.getSelectedValueJListPlatillos(), panelAgregarOrdenMesa.getSelectedValueOfPorciones());
            platilloSearch=registroA.consultarPlatilloTemp(panelAgregarOrdenMesa.getSelectedValueJListPlatillos());
            panelAgregarOrdenMesa.setTxtPrecio(Double.toString(platilloSearch.getPrecio()));
            panelAgregarOrdenMesa.setTextJTextField(platilloSearch.getPlatillo());
        }//fin if
        
        if(e.getActionCommand().equalsIgnoreCase("Personalizar")){
            panelAgregarOrdenMesa.enabledPersonalizar(2);
            panelAgregarOrdenMesa.agregarPlatilloPersonalizado();
            registroA.cleanTemp();
        }//fin if
        
        if(e.getActionCommand().equalsIgnoreCase("Postres")){
            panelAgregarOrdenMesa.agregarPostre();
        }//fin if
        
        if(e.getActionCommand().equalsIgnoreCase("Platillos")){
            panelAgregarOrdenMesa.agregarPlatillo();
        }//fin if
        
        if(e.getActionCommand().equalsIgnoreCase("Entradas")){
            panelAgregarOrdenMesa.agregarEntrada();
        }//fin if
        
        if(e.getActionCommand().equalsIgnoreCase("Bebidas")){
            panelAgregarOrdenMesa.agregarBebida();
        }//fin if
    
    }//fin if
    
}//fin de la clase ManejadorAgregarOrdenMesa
