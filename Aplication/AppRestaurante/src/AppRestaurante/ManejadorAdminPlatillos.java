/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Manejadora de los eventos provenientes del PanelAdminPlatillos
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 01/11/2014
 */

package AppRestaurante;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon; 
import javax.swing.Icon; 

public class ManejadorAdminPlatillos extends ManejadorAbstracto{
    
    private GUIAdminPlatillos guiAdminPlatillos;
    private PanelAdminPlatillos panelAdminPlatillos;
    private Icon icnSafe;
    private Platillo platillo;
    private RegistroA registroA;
    private Porcion porciones[];
    private Porcion porcionSearch;
    private Platillo platilloSearch;
    private int confirm;
    
    public ManejadorAdminPlatillos(GUIAdminPlatillos guiAdminPlatillos, PanelAdminPlatillos panelAdminPlatillos, RegistroA registroA){
        this.guiAdminPlatillos = guiAdminPlatillos;
        this.panelAdminPlatillos = panelAdminPlatillos;
        this.registroA = registroA;
        icnSafe = new ImageIcon("Images/lock.png");
    }//Fin del constructor ManejadorAdminPlatillos

/**
 * Proposito: Agregar el eventos a los Componentes del PanelAdminPlatillos
 * Nombre del metodo: actionPerformed
 * @since 21/11/2014
 * @param ActionEvent e: ingresa el parametro del evento proveniente del PanelAdminPlatillos al accionar los componentes
*/
    public void actionPerformed(ActionEvent e){
        
        if(e.getActionCommand().equalsIgnoreCase("Enter")){
            if(registroA.consultarPlatillo(panelAdminPlatillos.getTxtID())!=null){
                platilloSearch = registroA.consultarPlatillo(panelAdminPlatillos.getTxtID());
                    panelAdminPlatillos.setTxtID(platilloSearch.getIdentificacion());
                    panelAdminPlatillos.setTxtNombre(platilloSearch.getNombre());
                    panelAdminPlatillos.setTxtPrecio(Double.toString(platilloSearch.getPrecio()));
                    panelAdminPlatillos.setTextJTextField(platilloSearch.getPlatillo());
                    panelAdminPlatillos.stateOfJButtons(2);
            }else{
                JOptionPane.showMessageDialog(this.guiAdminPlatillos,"No existe registrado un \"platillo\" con el n\u00famero de identificaci\u00f3n: "+panelAdminPlatillos.getTxtID(),"Aviso", JOptionPane.WARNING_MESSAGE);
                refresh();
                }//fin else
        }//fin if
        
        if(e.getActionCommand().equals(panelAdminPlatillos.refresh)){
            refresh();
        }//fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminPlatillos.incluir)){
            if(!panelAdminPlatillos.getTxtID().equals("")){
                if(!panelAdminPlatillos.getTxtNombre().equals("")){
                    if(panelAdminPlatillos.getTxtPrecio()!=0.0){
                        if(registroA.verifPlatillo(panelAdminPlatillos.getTxtID())!=true){
                            porciones=panelAdminPlatillos.porcionesSeleccionadas();
                            platillo = new Platillo(
                                                    panelAdminPlatillos.getTxtID(), 
                                                    panelAdminPlatillos.getTxtNombre(), 
                                                    panelAdminPlatillos.getTxtPrecio(), 
                                                    null, porciones
                                                    );
                            registroA.agregarPlatillo(platillo);
                            refresh();
                            JOptionPane.showMessageDialog(this.guiAdminPlatillos, "¡Información agregada exitosamente!\n\n |         Informaci\u00f3n del \"Platillo\"        |\n"+platillo.getInformacion(),"Registro Almacenado", JOptionPane.PLAIN_MESSAGE, icnSafe);
                        }else
                            JOptionPane.showMessageDialog(this.guiAdminPlatillos,"Existe registrado un \"platillo\" con el n\u00famero de identificaci\u00f3n: "+panelAdminPlatillos.getTxtID(),"Aviso", JOptionPane.WARNING_MESSAGE);
                    }else
                        JOptionPane.showMessageDialog(this.guiAdminPlatillos,"Debe seleccionar al menos una opci\u00f3n de  las \"\u00f3rdenes\" anteriores para incluir el platillo","Aviso", JOptionPane.WARNING_MESSAGE);
                }else
                    JOptionPane.showMessageDialog(this.guiAdminPlatillos,"El espacio \"nombre\" se encuentra vac\u00edo","Aviso", JOptionPane.WARNING_MESSAGE);
            }else
                JOptionPane.showMessageDialog(this.guiAdminPlatillos,"El espacio \"identificaci\u00f3n\" se encuentra vac\u00edo","Aviso", JOptionPane.WARNING_MESSAGE);
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminPlatillos.modificar)){
            if(!panelAdminPlatillos.getTxtNombre().equals("")){
                registroA.modificarNombrePlatillo(panelAdminPlatillos.getTxtID(), panelAdminPlatillos.getTxtNombre());
                JOptionPane.showMessageDialog(this.guiAdminPlatillos,"El platillo fue modificado exitosamente","Platillo modificado", JOptionPane.INFORMATION_MESSAGE);
                refresh();
            }else{
                JOptionPane.showMessageDialog(this.guiAdminPlatillos,"El campo nombre se encuentra vac\u00edo, si desea modificarlo debe ingresar obligatorioamente este campo","Aviso", JOptionPane.WARNING_MESSAGE);
                }//fin else
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminPlatillos.eliminar)){
            confirm=JOptionPane.showConfirmDialog(null,"\u00BFEsta seguro de eliminar el platillo: \""+panelAdminPlatillos.getTxtNombre()+"\"?" , "AVISO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                switch(confirm){
                    case JOptionPane.YES_OPTION:
                        refresh();
                        registroA.eliminarPlatillo(panelAdminPlatillos.getTxtID());
                        JOptionPane.showMessageDialog(null, "La entrada fue eliminada con éxito", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE );
                        panelAdminPlatillos.stateOfJButtons(1);
                    break;
                        
                    case JOptionPane.NO_OPTION:
                        refresh();
                    break;
                }//fin switch
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminPlatillos.eliminarPorcion)){
            if(panelAdminPlatillos.stateOfSearch()==false){
                panelAdminPlatillos.eliminarPorcion();
            }else{
                registroA.modificarPorcionesPlatillo(panelAdminPlatillos.getTxtID(), panelAdminPlatillos.getSelectedValue());
                platilloSearch=registroA.consultarPlatillo(panelAdminPlatillos.getTxtID());
                panelAdminPlatillos.setTxtPrecio(Double.toString(platilloSearch.getPrecio()));
                panelAdminPlatillos.setTextJTextField(platilloSearch.getPlatillo());
                }//fin else
        }//fin if   
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminPlatillos.agregarPorcion)){
            if(panelAdminPlatillos.stateOfSearch()==false){
                panelAdminPlatillos.agregarPorcion();
            }else{
                registroA.modificarPorcionesPlatilloII(panelAdminPlatillos.getTxtID(), panelAdminPlatillos.getSelectedValue());
                platilloSearch=registroA.consultarPlatillo(panelAdminPlatillos.getTxtID());
                panelAdminPlatillos.setTxtPrecio(Double.toString(platilloSearch.getPrecio()));
                panelAdminPlatillos.setTextJTextField(platilloSearch.getPlatillo());
                }//fin else
        }//fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminPlatillos.salir)){
            guiAdminPlatillos.dispose();
            JOptionPane.showMessageDialog(null, "¡Los cambios fueron guardados exitosamente!", "Información General", JOptionPane.PLAIN_MESSAGE, icnSafe );
        }//Fin if
        
    }//Fin del metodo actionPerformed
    
    public void refresh(){
        guiAdminPlatillos.dispose();
        guiAdminPlatillos = new GUIAdminPlatillos(this.registroA);
    }//fin if

}//Fin de la clase ManejadorAdminPlatillos
