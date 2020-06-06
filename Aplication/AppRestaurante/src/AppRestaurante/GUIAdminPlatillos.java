/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase encargada de mostrar el la Interfaz Gráfica de Administrar Platillos
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 28/10/2014
 */
 
package AppRestaurante; 
 
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class GUIAdminPlatillos extends JFrame{
	
    private PanelAdminPlatillos panelAdminPlatillos;
    private RegistroA registroA;
    
    public GUIAdminPlatillos(RegistroA registroA){
        super("Administrar Platillos");
        this.panelAdminPlatillos = panelAdminPlatillos;
        this.registroA = registroA;
        panelAdminPlatillos = new PanelAdminPlatillos(this, registroA);
        getContentPane().add(this.panelAdminPlatillos);
        setIconImage(new ImageIcon(getClass().getResource("Images/platillo.png")).getImage());//ICONO PARA LA APLICACION
		setSize(700,600);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}//Fin del metodo constructor
}//Fin de la clase GUIAdminPostres
