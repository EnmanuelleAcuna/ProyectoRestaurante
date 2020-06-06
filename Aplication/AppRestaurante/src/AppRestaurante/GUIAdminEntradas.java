/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase encargada de mostrar el la Interfaz Gráfica de Administrar Entradas
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 28/10/2014
 */

package AppRestaurante;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GUIAdminEntradas extends JFrame{
    
    private RegistroA registroA;
    private PanelAdminEntradas panelAdminEntradas;
	
    public GUIAdminEntradas(RegistroA registroA){
       
        super("Administrar Entradas");
        this.registroA = registroA;
        this.panelAdminEntradas = panelAdminEntradas;
        panelAdminEntradas=new PanelAdminEntradas(this.registroA, this);
		getContentPane().add(this.panelAdminEntradas);
        setIconImage(new ImageIcon(getClass().getResource("Images/hot.png")).getImage());//ICONO PARA LA APLICACION
		setSize(550,470);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}//Fin del metodo constructor
}//Fin de la clase GUIAdminEntradas
