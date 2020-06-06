/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Manejadora de los eventos provenientes del PanelAdminPostres
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

public class ManejadorAdminPostres extends ManejadorAbstracto{
	
	private GUIAdminPostres guiAdminPostres;
	private PanelAdminPostres panelAdminPostres;
    private RegistroA registroA;
    private Icon icnSafe;
    private Postre postre;
    private double precio;
    private String strPrecio;
    private int confirm;
    
    public ManejadorAdminPostres(RegistroA registroA, GUIAdminPostres guiAdminPostres, PanelAdminPostres panelAdminPostres) {
		this.guiAdminPostres = guiAdminPostres;
        this.panelAdminPostres = panelAdminPostres;
        this.registroA = registroA;
        icnSafe = new ImageIcon("Images/lock.png");
    }//Fin del constructor ManejadorAdminPostres
    
/**
 * Proposito: Agregar el eventos a los Componentes del PanelAdminPostres
 * Nombre del metodo: actionPerformed
 * @since 10/11/2014
 * @param ActionEvent e: ingresa el parametro del evento proveniente del PanelAdminPostres al accionar los componentes
*/
    public void actionPerformed(ActionEvent e){
        
		if(e.getActionCommand().equalsIgnoreCase(panelAdminPostres.buscar)){
            if(!panelAdminPostres.getIDPostre().equals("")){
                if(panelAdminPostres.getNombrePostre().equals("")){
                    if(panelAdminPostres.getPrecioPostre().equals("")){
                        if(registroA.buscarPostrePorID(panelAdminPostres.getIDPostre())!=null){
                            panelAdminPostres.setIDPostre(registroA.buscarPostrePorID(panelAdminPostres.getIDPostre()).getIdentificacion());
                            panelAdminPostres.setNombre(registroA.buscarPostrePorID(panelAdminPostres.getIDPostre()).getNombre());
                            precio=registroA.buscarPostrePorID(panelAdminPostres.getIDPostre()).getPrecio();
                            strPrecio = Double.toString(precio);
                            panelAdminPostres.setPrecio(strPrecio);
                            panelAdminPostres.enabledJTextField(2);
                            panelAdminPostres.enabledBtnEliminar(1);
                            panelAdminPostres.enabledBtnIncluir(2);
                        }//Fin if
                            else
                                JOptionPane.showMessageDialog(null,"No existe postre registrado con el el n\u00famero de identificaci\u00f3n: \""+panelAdminPostres.getIDPostre()+"\"","Registro Inv\u00e1lido", JOptionPane.ERROR_MESSAGE);
                    }//Fin if
                        else
                            JOptionPane.showMessageDialog(null,"Para buscar un \"postre\" los campos nombre y precio deben estar sin ninguna informaci\u00f3n ingresada","Aviso", JOptionPane.WARNING_MESSAGE);
                }//Fin if
                    else
                        JOptionPane.showMessageDialog(null,"Para buscar un \"postre\" los campos nombre y precio deben estar sin ninguna informaci\u00f3n ingresada","Aviso", JOptionPane.WARNING_MESSAGE);
            }//Fin if
                else
                    JOptionPane.showMessageDialog(null,"Debe digitar un \"n\u00famero de identificaci\u00f3n\" para buscar la informaci\u00f3n, el campo se encuentra vac\u00edo","Aviso", JOptionPane.WARNING_MESSAGE);
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminPostres.incluir)){
            if(!panelAdminPostres.getIDPostre().equals("")){
                if(!panelAdminPostres.getNombrePostre().equals("")){
                    if(!panelAdminPostres.getPrecioPostre().equals("")){
                        postre = new Postre(panelAdminPostres.getIDPostre(), panelAdminPostres.getNombrePostre(), Double.parseDouble(panelAdminPostres.getPrecioPostre()));
                            registroA.agregarPostre(postre);
                            JOptionPane.showMessageDialog(null, "\u00A1Informaci\u00f3n agregada exitosamente!\n\n |         INFORMACI\u00d3N DEL REGISTRO         |\n"+postre.getInformacion(),"Registro Almacenado", JOptionPane.PLAIN_MESSAGE, icnSafe);
                            panelAdminPostres.cleanJTextField();
                    }//Fin if
                        else
                            JOptionPane.showMessageDialog(null,"Debe digitar el  \"precio\" del postre obligatoriamente para incluirlo","Aviso", JOptionPane.WARNING_MESSAGE);
                }//Fin if
                    else
                        JOptionPane.showMessageDialog(null,"Debe digitar el \"nombre\" del postre obligatoriamente para incluirlo","Aviso", JOptionPane.WARNING_MESSAGE);
			}//Fin if
                else
                    JOptionPane.showMessageDialog(null,"Debe digitar el  \"n\u00famero de identificaci\u00f3n\" del postre obligatoriamente para incluirlo","Aviso", JOptionPane.WARNING_MESSAGE);
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminPostres.eliminar)){
            confirm=JOptionPane.showConfirmDialog(null,"\u00BFEsta seguro de eliminar el postre: \""+panelAdminPostres.getNombrePostre()+"\"?" , "AVISO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                switch(confirm){
                    case JOptionPane.YES_OPTION:
                        registroA.eliminarPostre(panelAdminPostres.getIDPostre());
                        panelAdminPostres.cleanJTextField();
                        JOptionPane.showMessageDialog(null, "El postre fue eliminado con \u00e9xito", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE );
                        panelAdminPostres.enabledBtnEliminar(2);
                        panelAdminPostres.enabledJTextField(1);
                        panelAdminPostres.enabledBtnIncluir(1);
                    case JOptionPane.NO_OPTION:
                        panelAdminPostres.enabledBtnEliminar(2);
                        panelAdminPostres.enabledJTextField(1);
                        panelAdminPostres.enabledBtnIncluir(1);
                        panelAdminPostres.cleanJTextField();
                        break;
                }//Fin switch
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminPostres.refresh)){
			panelAdminPostres.cleanJTextField();
			panelAdminPostres.enabledJTextField(1);
			panelAdminPostres.enabledBtnIncluir(1);
			panelAdminPostres.enabledBtnEliminar(3);
		}//fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminPostres.salir)){
            guiAdminPostres.dispose();
            JOptionPane.showMessageDialog(null, "\u00A1Los cambios fueron guardados exitosamente!", "Informaci\u00f3n General", JOptionPane.PLAIN_MESSAGE, icnSafe );
        }//Fin if
        
    }//Fin del metodo actionPerformed
    
}//fin de la clase ManejadorAdminBebidas
