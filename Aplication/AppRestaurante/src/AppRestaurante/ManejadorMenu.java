/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: ...
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1  
 * @since: 27/10/2014
 */

package AppRestaurante;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;

public class ManejadorMenu extends ManejadorAbstracto{
    private RegistroA registroA;
    private GUIAgregarOrdenMesa guiAgregarOrdenMesa;
    private GUIPagarMesa guiPagarMesa;
    private GUIAdminEntradas guiAdminEntradas;
    private GUIAdminBebidas guiAdminBebidas;
    private GUIAdminPostres guiAdminPostres;
    private GUIAdminMesas guiAdminMesas;
    private GUIAdminOrdenes guiAdminOrdenes;
    private GUIAdminPlatillos guiAdminPlatillos;
    private int opcion;
    
    public ManejadorMenu(RegistroA registroA){
        this.registroA = registroA;
        int opcion=0;
    }//Fin del metodo constructor
    
    /**
 * Proposito: Agregar el eventos a los Componentes del PanelPagarMesa
 * Nombre del metodo: actionPerformed
 * @since 28/11/2014
*/
    public void actionPerformed(ActionEvent e){
        
        if(e.getActionCommand().equals(GUIPrincipal.txI)){
            if(registroA.stateOfArrays(1)!=false){
                if(registroA.stateOfArrays(2)!=false){
                    if(registroA.stateOfArrays(3)!=false){
                        if(registroA.stateOfArrays(4)!=false){
                            if(registroA.stateOfArrays(5)!=false){
                                guiAgregarOrdenMesa = new GUIAgregarOrdenMesa(registroA);
                            }else
                                JOptionPane.showMessageDialog(null,"Debe ingresar a la opcion del men\u00fa \"administrar mesas\" e ingresar un mesa como m\u00ednimo para habilitar esta opci\u00f3n","Aviso", JOptionPane.WARNING_MESSAGE);
                        }else
                            JOptionPane.showMessageDialog(null,"Debe ingresar a la opcion del men\u00fa \"administrar entradas\" e ingresar una entrada como m\u00ednimo para habilitar esta opci\u00f3n","Aviso", JOptionPane.WARNING_MESSAGE);
                    }else
                        JOptionPane.showMessageDialog(null,"Debe ingresar a la opcion del men\u00fa \"administrar bebidas\" e ingresar un platillo como m\u00ednimo para habilitar esta opci\u00f3n","Aviso", JOptionPane.WARNING_MESSAGE);
                }else
                    JOptionPane.showMessageDialog(null,"Debe ingresar a la opcion del men\u00fa \"administrar postres\" e ingresar un postre como m\u00ednimo para habilitar esta opci\u00f3n","Aviso", JOptionPane.WARNING_MESSAGE);
            }else
                JOptionPane.showMessageDialog(null,"Debe ingresar a la opcion del men\u00fa \"administrar platillos\" e ingresar un platillo como m\u00ednimo para habilitar esta opci\u00f3n","Aviso", JOptionPane.WARNING_MESSAGE);
        }//Fin if
        
    if(e.getActionCommand().equals(GUIPrincipal.txII)){
        guiPagarMesa = new GUIPagarMesa(registroA);
    }//Fin if

    if(e.getActionCommand().equals(GUIPrincipal.txIII)){
        guiAdminEntradas = new GUIAdminEntradas(registroA);
    }//Fin if

    if(e.getActionCommand().equals(GUIPrincipal.txV)){
        guiAdminBebidas = new GUIAdminBebidas(registroA);
    }//Fin if

    if(e.getActionCommand().equals(GUIPrincipal.txVI)){
       guiAdminPostres = new GUIAdminPostres(registroA);
    }//Fin if

    if(e.getActionCommand().equals(GUIPrincipal.txVII)){
        guiAdminMesas = new GUIAdminMesas(registroA);
    }//Fin if

    if(e.getActionCommand().equals(GUIPrincipal.txVIII)){
        guiAdminOrdenes = new GUIAdminOrdenes(registroA);
    }//Fin if

    if(e.getActionCommand().equals(GUIPrincipal.txIX)){
        if(registroA.stateOfArrayPorciones()!=false){
            guiAdminPlatillos = new GUIAdminPlatillos(registroA);
        }else
            JOptionPane.showMessageDialog(null,"Debe ingresar a la opcion del men\u00fa \"administrar \u00f3rdenes\" e ingresar una \u00f3rden como m\u00ednimo","Aviso", JOptionPane.WARNING_MESSAGE);
            
    }//Fin if

    if(e.getActionCommand().equals(GUIPrincipal.txX)){
        opcion=JOptionPane.showConfirmDialog(null, "\u00BFEst\u00e1 seguro de salir de la aplicaci\u00f3n: \"Restaurante El Rey\"? ","Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            switch(opcion){
                case JOptionPane.YES_OPTION:
                    JOptionPane.showMessageDialog(null, "               \u00A1Gracias por Preferirnos!","RESTAURANTE \"EL REY", JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                break;
                
                case JOptionPane.NO_OPTION:
                break;
            }//Fin switch
    }//Fin if

    }//Fin del metodo actionPerformed
    
}//Fin de la clase ManejadorMenu
