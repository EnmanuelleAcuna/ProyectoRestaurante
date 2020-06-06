/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Manejadora de los eventos provenientes del PanelAdminBebidas
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

public class ManejadorAdminBebidas extends ManejadorAbstracto{
	private GUIAdminBebidas guiAdminBebidas;
    private PanelAdminBebidas panelAdminBebidas;
    private RegistroA registroA;
    private Icon icnSafe;
    private Bebida bebida;
    private double precio;
    private String strPrecio;
    private int confirm;
    
    public ManejadorAdminBebidas(RegistroA registroA, GUIAdminBebidas guiAdminBebidas, PanelAdminBebidas panelAdminBebidas) {
		this.guiAdminBebidas = guiAdminBebidas;
        this.panelAdminBebidas = panelAdminBebidas;
        this.registroA = registroA;
        icnSafe = new ImageIcon("Images/lock.png");
    }//Fin del constructor ManejadorAdminBebidas
    
/**
 * Proposito: Agregar el eventos a los Componentes del PanelAdminBebidas
 * Nombre del metodo: actionPerformed
 * @since 10/11/2014
 * @param ActionEvent e: ingresa el parametro del evento proveniente del PanelAdminBebidas al accionar los componentes
*/
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equalsIgnoreCase(panelAdminBebidas.buscar)){
			if(!panelAdminBebidas.getIDBebida().equals("")){
                if(panelAdminBebidas.getNombreBebida().equals("")){
                    if(panelAdminBebidas.getPrecioBebida().equals("")){
                        if(registroA.buscarBebidaPorID(panelAdminBebidas.getIDBebida())!=null){
                            panelAdminBebidas.setIDBebida(registroA.buscarBebidaPorID(panelAdminBebidas.getIDBebida()).getIdentificacion());
                            panelAdminBebidas.setNombre(registroA.buscarBebidaPorID(panelAdminBebidas.getIDBebida()).getNombre());
                            precio=registroA.buscarBebidaPorID(panelAdminBebidas.getIDBebida()).getPrecio();
                            strPrecio = Double.toString(precio);
                            panelAdminBebidas.setValor(strPrecio);
                            panelAdminBebidas.enabledJTextField(2);
                            panelAdminBebidas.enabledBtnEliminarBebida(1);
                            panelAdminBebidas.enabledBtnIncluirBebida(2);
                        }//Fin if
                            else
                                JOptionPane.showMessageDialog(this.guiAdminBebidas, "No existe bebida registrada con el el n\u00famero de identificaci\u00edn: \""+panelAdminBebidas.getIDBebida()+"\"","Registro Inv\u00e1lido", JOptionPane.ERROR_MESSAGE);
                    }//Fin if
                        else
                            JOptionPane.showMessageDialog(this.guiAdminBebidas, "Para buscar una \"bebida\" los campos nombre y precio deben estar sin ninguna informaci\u00f3n ingresada","Aviso", JOptionPane.WARNING_MESSAGE);
                }//Fin if
                    else
                        JOptionPane.showMessageDialog(this.guiAdminBebidas, "Para buscar una \"bebida\" los campos nombre y precio deben estar sin ninguna informaci\u00f3n ingresada","Aviso", JOptionPane.WARNING_MESSAGE);
            }//Fin if
                else
                    JOptionPane.showMessageDialog(this.guiAdminBebidas, "Debe digitar un \"n\u00famero de identificaci\u00f3n\" para buscar la informaci\u00f3n, el campo se encuentra vac\u00fao","Aviso", JOptionPane.WARNING_MESSAGE);
        }//Fin if

        if(e.getActionCommand().equalsIgnoreCase(panelAdminBebidas.incluir)){
			if(!panelAdminBebidas.getIDBebida().equals("")){
                if(!panelAdminBebidas.getNombreBebida().equals("")){
                    if(!panelAdminBebidas.getPrecioBebida().equals("")){
                        bebida = new Bebida(panelAdminBebidas.getIDBebida(), panelAdminBebidas.getNombreBebida(), Double.parseDouble(panelAdminBebidas.getPrecioBebida()));
                            registroA.agregarBebida(bebida);
                            JOptionPane.showMessageDialog(this.guiAdminBebidas, "\u00A1Informaci\u00f3n agregada exitosamente!\n\n |         INFORMACI\u00d3N DEL REGISTRO         |\n"+bebida.getInformacion(),"Registro Almacenado", JOptionPane.PLAIN_MESSAGE, icnSafe);
                            panelAdminBebidas.cleanJTextField();
                    }//Fin if
                        else
                            JOptionPane.showMessageDialog(this.guiAdminBebidas, "Debe digitar el  \"precio\" de la bebida obligatoriamente para incluirla","Aviso", JOptionPane.WARNING_MESSAGE);
                    
                }//Fin if
                    else
                        JOptionPane.showMessageDialog(this.guiAdminBebidas, "Debe digitar el \"nombre\" de la bebida obligatoriamente para incluirla","Aviso", JOptionPane.WARNING_MESSAGE);
			}//Fin if
                else
                    JOptionPane.showMessageDialog(this.guiAdminBebidas, "Debe digitar el  \"n\u00famero de identificaci\u00f3n\" de bebida obligatoriamente para incluirla","Aviso", JOptionPane.WARNING_MESSAGE);
        }//Fin if
			
        if(e.getActionCommand().equalsIgnoreCase(panelAdminBebidas.eliminar)){
            confirm=JOptionPane.showConfirmDialog(this.guiAdminBebidas, "\u00BFEsta seguro de eliminar la bebida: \""+panelAdminBebidas.getNombreBebida()+"\"\u003F" , "AVISO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                switch(confirm){
                    case JOptionPane.YES_OPTION:
                        registroA.eliminarBebida(panelAdminBebidas.getIDBebida());
                        panelAdminBebidas.cleanJTextField();
                        JOptionPane.showMessageDialog(this.guiAdminBebidas, "\u00A1La bebida fue eliminada con \u00e9xito!", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE );
                        panelAdminBebidas.enabledBtnEliminarBebida(2);
                        panelAdminBebidas.enabledJTextField(1);
                        panelAdminBebidas.enabledBtnIncluirBebida(1);
                    case JOptionPane.NO_OPTION:
                        panelAdminBebidas.enabledBtnEliminarBebida(2);
                        panelAdminBebidas.enabledJTextField(1);
                        panelAdminBebidas.enabledBtnIncluirBebida(1);
                        panelAdminBebidas.cleanJTextField();
                        break;
                }//Fin switch
        }//Fin if
           
        if(e.getActionCommand().equals(panelAdminBebidas.refresh)){
			panelAdminBebidas.cleanJTextField();
			panelAdminBebidas.enabledBtnEliminarBebida(2);
			panelAdminBebidas.enabledBtnIncluirBebida(1);
			panelAdminBebidas.enabledJTextField(1);
		}//Fin if
    
        if(e.getActionCommand().equalsIgnoreCase(panelAdminBebidas.salir)){
            guiAdminBebidas.dispose();
            JOptionPane.showMessageDialog(this.guiAdminBebidas, "\u00A1Los cambios fueron guardados exitosamente\u0021", "Informaci\u00f3n General", JOptionPane.PLAIN_MESSAGE, icnSafe );
        }//Fin if
                
    }//Fin del metodo actionPerformed

}//fin de la clase ManejadorAdminBebidas
