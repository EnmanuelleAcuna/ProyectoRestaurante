/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Manejadora de los eventos provenientes del PanelAdminOrdenes
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 11/11/2014
 */

package AppRestaurante;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon; 
import javax.swing.Icon; 

public class ManejadorAdminOrdenes extends ManejadorAbstracto{
	
	private GUIAdminOrdenes guiAdminOrdenes;
	private PanelAdminOrdenes panelAdminOrdenes;
    private RegistroA registroA;
    private Porcion porcion;
    private Porcion porcionSearch;
    private Porcion porcionModificar;
    private Icon icnSafe;
    private String nombre="", id="";
    private double precio=0;
    private String strPrecio;
    private int confirm;
    private String selec="";
    
    public ManejadorAdminOrdenes(GUIAdminOrdenes guiAdminOrdenes, RegistroA registroA, PanelAdminOrdenes panelAdminOrdenes) {
		this.guiAdminOrdenes = guiAdminOrdenes;
        this.panelAdminOrdenes = panelAdminOrdenes;
        this.registroA = registroA;
        icnSafe = new ImageIcon("Images/lock.png");
    }//Fin del constructor ManejadorAdminOrdenes
    
/**
 * Proposito: Agregar el eventos a los Componentes del PanelAdminOrdenes
 * Nombre del metodo: actionPerformed
 * @since 11/11/2014
 * @param ActionEvent e: ingresa el parametro del evento proveniente del PanelAdminOrdenes al accionar los componentes
*/
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("1") || e.getActionCommand().equals("2")){
            if(e.getActionCommand().equals("1"))
                selec="Fuerte";
            else
                selec="Acompa\u00f1amiento";
        }//fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminOrdenes.buscar)){
            if(!panelAdminOrdenes.getTxtID().equals("")){
                if(this.registroA.buscarPorcionPorID(panelAdminOrdenes.getTxtID())!=null){
                    porcionSearch = registroA.buscarPorcionPorID(panelAdminOrdenes.getTxtID());
                        if(porcionSearch.getTipo().equals("Fuerte")){
                            panelAdminOrdenes.setStateOfJRadioButton(1);
                            panelAdminOrdenes.setTxtID(porcionSearch.getIdentificacion());
                            panelAdminOrdenes.setTxtNombre(porcionSearch.getNombre());
                            panelAdminOrdenes.setTxtPrecio(porcionSearch.getPrecio());
                            panelAdminOrdenes.enabledOfSearch(1);
                        }else{
                            panelAdminOrdenes.setStateOfJRadioButton(2);
                            panelAdminOrdenes.setTxtID(porcionSearch.getIdentificacion());
                            panelAdminOrdenes.setTxtNombre(porcionSearch.getNombre());
                            panelAdminOrdenes.setTxtPrecio(porcionSearch.getPrecio());
                            panelAdminOrdenes.enabledOfSearch(1);
                            }//fin else
                }else{
                    JOptionPane.showMessageDialog(this.guiAdminOrdenes, "No existe una \"\u00f3rden\" registrada con con el n\u00famero de indentificaci\u00f3n: \""+panelAdminOrdenes.getTxtID()+"\"","Aviso", JOptionPane.WARNING_MESSAGE);
                    panelAdminOrdenes.enabledOfSearch(2);
                    panelAdminOrdenes.cleanComponets();
                    }//fin else
            }else
                JOptionPane.showMessageDialog(this.guiAdminOrdenes, "Debe digitar un \"n\u00famero de \u00f3\" para buscar la \u00f3rden","Aviso", JOptionPane.WARNING_MESSAGE);
        }//Fin if buscar
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminOrdenes.incluir)){
            if(!panelAdminOrdenes.getTxtID().equals("")){
                if(!panelAdminOrdenes.getTxtNombre().equals("")){
                    if(panelAdminOrdenes.getTxtPrecio()!=null){                            
                        if(panelAdminOrdenes.getStateOfJRadioButtons()!=false){
                            if(!registroA.verifPorcion(panelAdminOrdenes.getTxtID())==true){
                                porcion=new Porcion(
                                                    panelAdminOrdenes.getTxtID(),
                                                    panelAdminOrdenes.getTxtNombre(),
                                                    Double.parseDouble(panelAdminOrdenes.getTxtPrecio()),
                                                    selec
                                                    );
                                        registroA.addPorcion(porcion);
                                        JOptionPane.showMessageDialog(null, "\u00A1Informaci\u00f3n agregada exitosamente!\n\n |         Informaci\u00f3n General:        |\n"+porcion.getInformacion(),"Registro Almacenado", JOptionPane.PLAIN_MESSAGE, icnSafe);        
                                        panelAdminOrdenes.cleanComponets();
                            }else{
                                    JOptionPane.showMessageDialog(this.guiAdminOrdenes, "Existe una \"\u00f3rden\" registrada con con el n\u00famero de indentificaci\u00f3n: \""+panelAdminOrdenes.getTxtID()+"\"","Aviso", JOptionPane.WARNING_MESSAGE);
                                    panelAdminOrdenes.cleanComponets();
                                }//Fin else
                        }else
                            JOptionPane.showMessageDialog(this.guiAdminOrdenes, "Debe digitar el tipo de \"\u00f3rden\"","Aviso", JOptionPane.WARNING_MESSAGE);
                    }else
                        JOptionPane.showMessageDialog(this.guiAdminOrdenes, "El campo \"precio\" se encuentra en blanco","Aviso", JOptionPane.WARNING_MESSAGE);
                }else
                    JOptionPane.showMessageDialog(this.guiAdminOrdenes, "El campo \"nombre\" se encuentra en blanco","Aviso", JOptionPane.WARNING_MESSAGE);
            }else
                JOptionPane.showMessageDialog(this.guiAdminOrdenes, "El campo \"identificaci\u00f3n\" se encuentra en blanco","Aviso", JOptionPane.WARNING_MESSAGE);
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminOrdenes.modificar)){
                if(!panelAdminOrdenes.getTxtNombre().equals("") && panelAdminOrdenes.getTxtPrecio()!=null){
                    registroA.modificarPorcion(panelAdminOrdenes.getTxtID(), panelAdminOrdenes.getTxtNombre(), Double.parseDouble(panelAdminOrdenes.getTxtPrecio()));
                    JOptionPane.showMessageDialog(this.guiAdminOrdenes, "La \u00f3rden fue modificada exitosamente","Registro modificado", JOptionPane.INFORMATION_MESSAGE );
                    panelAdminOrdenes.cleanComponets();
                    panelAdminOrdenes.enabledOfSearch(2);
                }else{
                    JOptionPane.showMessageDialog(this.guiAdminOrdenes, "Existen campos en blanco, para modificar una \"\u00f3rden\" debe llenar todos los campos","Aviso", JOptionPane.INFORMATION_MESSAGE );
                    panelAdminOrdenes.enabledOfSearch(2);
                    panelAdminOrdenes.cleanComponets();
                    }//fin else
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminOrdenes.refresh)){
            panelAdminOrdenes.cleanComponets();
            panelAdminOrdenes.enabledOfSearch(2);
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminOrdenes.eliminar)){
            confirm=JOptionPane.showConfirmDialog(null,"\u00BFEsta seguro de eliminar la \u00f3rden: \""+panelAdminOrdenes.getTxtNombre()+"\"?" , "AVISO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                switch(confirm){
                    case JOptionPane.YES_OPTION:
                        registroA.eliminarPorcion(panelAdminOrdenes.getTxtID());
                        JOptionPane.showMessageDialog(null, "\u00A1La porcion fue eliminada con \u00e9xito!", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE );
                        panelAdminOrdenes.cleanComponets();
                        panelAdminOrdenes.enabledOfSearch(2);
                    break;
                    
                    case JOptionPane.NO_OPTION:
                        panelAdminOrdenes.cleanComponets();
                        panelAdminOrdenes.enabledOfSearch(2);
                    break;
                }//Fin switch
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminOrdenes.salir)){
            guiAdminOrdenes.dispose();
            JOptionPane.showMessageDialog(null, "\u00A1Los cambios fueron guardados exitosamente!", "Informaci\u00f3n General", JOptionPane.PLAIN_MESSAGE, icnSafe );
        }//Fin if
        
    }//Fin del metodo actionPerformed
    
}//fin de la clase ManejadorAdminBebidas
