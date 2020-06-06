/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase Manejadora de los eventos provenientes del PanelAdminBebidas
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 15/11/2014
 */

package AppRestaurante;
 
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon; 
import javax.swing.Icon; 

public class ManejadorAdminMesas extends ManejadorAbstracto{
	private GUIAdminMesas guiAdminMesas;
	private RegistroA registroA;
	private PanelAdminMesas panelAdminMesas;
	private Mesa mesa;
	private Mesa buscarMesa;
	private Mesa eliminarMesa;
	private Icon icnSafe;
	private boolean selec;
	private int confirm;
	
	public ManejadorAdminMesas(RegistroA registroA, GUIAdminMesas guiAdminMesas, PanelAdminMesas panelAdminMesas){
		this.guiAdminMesas = guiAdminMesas;
		this.registroA = registroA;
		this.panelAdminMesas = panelAdminMesas;
		icnSafe = new ImageIcon("Images/lock.png");
	}//fin del metodo constructor
    

/**
 * Proposito: Agregar el eventos a los Componentes del PanelAdminMesas
 * Nombre del metodo: actionPerformed
 * @since 15/11/2014
 * @param ActionEvent e: ingresa el parametro del evento proveniente del PanelAdminMesas al accionar los componentes
*/
    public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Disponible") || e.getActionCommand().equals("Ocupado")){
			if(e.getActionCommand().equals("Disponible"))
				selec=true;
			else
				selec=false;
		}//fin if
		
		if(e.getActionCommand().equals(panelAdminMesas.incluir)){
			if(!panelAdminMesas.getNumMesa().equals("")){
				if(registroA.verifMesa(panelAdminMesas.getNumMesa())!=true){
					if(panelAdminMesas.stateOfJRadioButton()==true){
						mesa= new Mesa(panelAdminMesas.getNumMesa(), selec);
						registroA.agregarMesa(mesa);
						panelAdminMesas.cleanJTextField();
						JOptionPane.showMessageDialog(this.guiAdminMesas, "La mesa se guardo correctamente");
						panelAdminMesas.setEnabled(2);
					}else
                        JOptionPane.showMessageDialog(this.guiAdminMesas, "Debe seleccionar una opci\u00f3n de disponibilidad");
                }else
					JOptionPane.showMessageDialog(this.guiAdminMesas, "Esta mesa ya se encuentra registrada");
			}else
                JOptionPane.showMessageDialog(this.guiAdminMesas, "Debe digitar un \"n\u00famero de identificaci\u00f3n\" para incluir la mesa, el campo se encuentra vac\u00edo","Aviso", JOptionPane.WARNING_MESSAGE);			
		}//Fin if
		
		if(e.getActionCommand().equals(panelAdminMesas.salir)){
			guiAdminMesas.dispose();
			JOptionPane.showMessageDialog(this.guiAdminMesas, "\u00A1Los cambios fueron guardados exitosamente!", "Informaci\u00f3n General", JOptionPane.PLAIN_MESSAGE, icnSafe );
		}//Fin if
		
		if(e.getActionCommand().equals(panelAdminMesas.buscar)){
			if(!panelAdminMesas.getNumMesa().equals("")){
				if(registroA.buscarMesaPorNum(panelAdminMesas.getNumMesa())!=null){
					buscarMesa= registroA.buscarMesaPorNum(panelAdminMesas.getNumMesa());
					panelAdminMesas.setNumMesa(buscarMesa.getNumMesa());
                        if(buscarMesa.getDisponibilidad()==true){
                            panelAdminMesas.setEnabled(1);
                            panelAdminMesas.setSelectedRadioButton(1);
                        }else{
                            panelAdminMesas.setEnabled(1);
                            panelAdminMesas.setSelectedRadioButton(2);
                            }//Fin else
				}else
                    JOptionPane.showMessageDialog(this.guiAdminMesas, "El n\u00famero de mesa no existe");
			}else
				JOptionPane.showMessageDialog(this.guiAdminMesas, "Debe digitar un \"n\u00famero de identificaci\u00f3n\" para buscar la informaci\u00f3n, el campo se encuentra vac\u00edo","Aviso", JOptionPane.WARNING_MESSAGE);						
		}//Fin if
		
		if(e.getActionCommand().equals(panelAdminMesas.refresh)){
			panelAdminMesas.cleanJTextField();
			panelAdminMesas.setEnabled(2);
		}//Fin if
		
		if(e.getActionCommand().equals(panelAdminMesas.eliminar)){
			confirm=JOptionPane.showConfirmDialog(this.guiAdminMesas, "\u00BFEsta seguro de eliminar la mesa: \""+panelAdminMesas.getNumMesa()+"\"\u003F" , "AVISO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch(confirm){
				case JOptionPane.YES_OPTION:
					registroA.eliminarMesa(panelAdminMesas.getNumMesa());
					panelAdminMesas.cleanJTextField();
                    JOptionPane.showMessageDialog(this.guiAdminMesas, "La bebida fue eliminada con \u00e9xito", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE );
                    panelAdminMesas.setEnabled(2);
                    panelAdminMesas.cleanJTextField();
				
				case JOptionPane.NO_OPTION:
					panelAdminMesas.setEnabled(2);
                    panelAdminMesas.cleanJTextField();
				break;
			}//fin switch	
		}//fin if
        
	}//fin del action performed
    
}//fin de la clase
