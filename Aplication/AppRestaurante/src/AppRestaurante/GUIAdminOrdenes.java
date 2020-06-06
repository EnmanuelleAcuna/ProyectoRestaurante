/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase GUIAdminPorciones encargada de mostrar el la Interfaz Gráfica de Administrar Porciones
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 11/11/2014
 */

package AppRestaurante;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Container;

public class GUIAdminOrdenes extends JFrame{
    
    private PanelAdminOrdenes panelAdminOrdenes;
    private RegistroA registroA;
    private Container contenedor;
    
    public GUIAdminOrdenes(RegistroA registroA){
        super("Administrar \u00d3rdenes");
        this.panelAdminOrdenes = panelAdminOrdenes;
        this.registroA = registroA;
        panelAdminOrdenes = new PanelAdminOrdenes(this, this.registroA);
        contenedor = getContentPane();
        contenedor.add(panelAdminOrdenes);
        setIconImage(new ImageIcon(getClass().getResource("Images/slice.png")).getImage());//ICONO PARA LA APLICACION
        panelAdminOrdenes.setBackground(new java.awt.Color(255,255,255));
		setSize(600,520);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
    
    }//Fin del constructor GUIAdminOrdenes
}//Fin de la clase GUIAdminOrdenes
