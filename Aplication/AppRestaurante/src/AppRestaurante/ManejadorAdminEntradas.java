/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Manejadora de los eventos provenientes del PanelAdminEntradas
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

public class ManejadorAdminEntradas extends ManejadorAbstracto{
    
	private GUIAdminEntradas guiAdminEntradas;
    private PanelAdminEntradas panelAdminEntradas;
    private RegistroA registroA;
    private Icon icnSafe;
    private Entrada entrada;
    private double precio;
    private String strPrecio;
    private int confirm;
    
    public ManejadorAdminEntradas(RegistroA registroA, GUIAdminEntradas guiAdminEntradas, PanelAdminEntradas panelAdminEntradas) {
		this.guiAdminEntradas = guiAdminEntradas;
        this.panelAdminEntradas = panelAdminEntradas;
        this.registroA = registroA;
        icnSafe = new ImageIcon("Images/lock.png");
    }//Fin del constructor ManejadorAdminEntradas
    
/**
 * Proposito: Agregar el eventos a los Componentes del PanelAdminEntradas
 * Nombre del metodo: actionPerformed
 * @since 04/11/2014
 * @param ActionEvent e: ingresa el parametro del evento proveniente del PanelAdminEntradas al accionar los componentes
*/
	public void actionPerformed(ActionEvent e){
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminEntradas.buscar)){
            if(!panelAdminEntradas.getIDEntrada().equals("")){
                if(panelAdminEntradas.getNombreEntrada().equals("")){
                    if(panelAdminEntradas.getPrecioEntrada().equals("")){
                        if(registroA.buscarEntradaPorID(panelAdminEntradas.getIDEntrada())!=null){
                            panelAdminEntradas.setIDEntrada(registroA.buscarEntradaPorID(panelAdminEntradas.getIDEntrada()).getIdentificacion());
                            panelAdminEntradas.setNombre(registroA.buscarEntradaPorID(panelAdminEntradas.getIDEntrada()).getNombre());
                            precio=registroA.buscarEntradaPorID(panelAdminEntradas.getIDEntrada()).getPrecio();
                            strPrecio = Double.toString(precio);
                            panelAdminEntradas.setPrecio(strPrecio);
                            panelAdminEntradas.enabledJTextField(2);
                            panelAdminEntradas.enabledBtnEliminar(1);
                            panelAdminEntradas.enabledBtnIncluir(2);
                        }//Fin if
                            else
                                JOptionPane.showMessageDialog(null,"No existe entrada registrada con el el n\u00famero de identificaci\u00f3n: \""+panelAdminEntradas.getIDEntrada()+"\"","Registro Inv\u00e1lido", JOptionPane.ERROR_MESSAGE);
                    }//Fin if
                        else
                            JOptionPane.showMessageDialog(null,"Para buscar una \"entrada\" los campos nombre y precio deben estar sin ninguna informaci\u00f3n ingresada","Aviso", JOptionPane.WARNING_MESSAGE);
                }//Fin if
                    else
                        JOptionPane.showMessageDialog(null,"Para buscar una \"entrada\" los campos nombre y precio deben estar sin ninguna informaci\u00f3n ingresada","Aviso", JOptionPane.WARNING_MESSAGE);
            }//Fin if
                else
                    JOptionPane.showMessageDialog(null,"Debe digitar el \"n\u00famero de identificaci\u00f3n\" para buscar la informaci\u00f3n, el campo se encuentra vac\u00edo","Aviso", JOptionPane.WARNING_MESSAGE);
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminEntradas.incluir)){
            if(!panelAdminEntradas.getIDEntrada().equals("")){
                if(!panelAdminEntradas.getNombreEntrada().equals("")){
                    if(!panelAdminEntradas.getPrecioEntrada().equals("")){
                        entrada = new Entrada(panelAdminEntradas.getIDEntrada(), panelAdminEntradas.getNombreEntrada(), Double.parseDouble(panelAdminEntradas.getPrecioEntrada()));
                            registroA.agregarEntrada(entrada);
                            JOptionPane.showMessageDialog(null, "\u00A1Informaci\u00f3n agregada exitosamente!\n\n |         INFORMACI\u00d3N DEL REGISTRO         |\n"+entrada.getInformacion(),"Registro Almacenado", JOptionPane.PLAIN_MESSAGE, icnSafe);
                            panelAdminEntradas.cleanJTextField();
                    }//Fin if
                        else
                            JOptionPane.showMessageDialog(this.guiAdminEntradas,"Debe digitar el  \"precio\" de la entrada obligatoriamente para incluirla","Aviso", JOptionPane.WARNING_MESSAGE);
                    
                }//Fin if
                    else
                        JOptionPane.showMessageDialog(null,"Debe digitar el \"nombre\" de la entrada obligatoriamente para incluirla","Aviso", JOptionPane.WARNING_MESSAGE);
			}//Fin if
                else
                    JOptionPane.showMessageDialog(null,"Debe digitar el  \"n\u00famero de identificaci\u00f3n\" de la entrada obligatoriamente para incluirla","Aviso", JOptionPane.WARNING_MESSAGE);
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminEntradas.eliminar)){
            confirm=JOptionPane.showConfirmDialog(null,"\u00BFEsta seguro de eliminar la entrada: \""+panelAdminEntradas.getNombreEntrada()+"\"?" , "AVISO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                switch(confirm){
                    case JOptionPane.YES_OPTION:
                        registroA.eliminarEntrada(panelAdminEntradas.getIDEntrada());
                        panelAdminEntradas.cleanJTextField();
                        JOptionPane.showMessageDialog(null, "\u00A1La entrada fue eliminada con \u00e9xito\u0021", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE );
                        panelAdminEntradas.enabledBtnEliminar(2);
                        panelAdminEntradas.enabledJTextField(1);
                        panelAdminEntradas.enabledBtnIncluir(1);
                    break;
                    
                    case JOptionPane.NO_OPTION:
                        panelAdminEntradas.enabledBtnEliminar(2);
                        panelAdminEntradas.enabledJTextField(1);
                        panelAdminEntradas.enabledBtnIncluir(1);
                        panelAdminEntradas.cleanJTextField();
                    break;
                }//Fin switch
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminEntradas.refresh)){
            panelAdminEntradas.cleanJTextField();
            panelAdminEntradas.enabledJTextField(1);
            panelAdminEntradas.enabledBtnIncluir(1);
            panelAdminEntradas.enabledBtnEliminar(2);
        }//Fin if
        
        if(e.getActionCommand().equalsIgnoreCase(panelAdminEntradas.salir)){
            guiAdminEntradas.dispose();
            JOptionPane.showMessageDialog(null, "\u00A1Los cambios fueron guardados exitosamente!", "Informaci\u00f3n General", JOptionPane.PLAIN_MESSAGE, icnSafe );
        }//Fin if
        
    }//Fin del metodo actionPerformed
}//fin de la clase ManejadorAdminBebidas
