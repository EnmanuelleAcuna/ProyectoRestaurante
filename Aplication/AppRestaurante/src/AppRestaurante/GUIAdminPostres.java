/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase encargada de mostrar el la Interfaz Gráfica de Administrar Postres
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 28/10/2014
 */

package AppRestaurante;
 
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class GUIAdminPostres extends JFrame{
	
    private PanelAdminPostres panelAdminPostres;
    private RegistroA registroA;
    
    public GUIAdminPostres(RegistroA registroA){
        super("Administrar Postres");
        this.panelAdminPostres = panelAdminPostres;
        this.registroA = registroA;
        panelAdminPostres = new PanelAdminPostres(this.registroA, this);
        getContentPane().add(this.panelAdminPostres);
        setIconImage(new ImageIcon(getClass().getResource("Images/sweet.png")).getImage());//ICONO PARA LA APLICACION
		setSize(550,500);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}//Fin del metodo constructor
}//Fin de la clase GUIAdminPostres
