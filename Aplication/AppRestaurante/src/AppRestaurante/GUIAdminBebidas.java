/**
 * Universidad de Costa Rica
 * Programaci�n I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase encargada de mostrar el la Interfaz Gr�fica de Administrar Bebidas
 * @author: Bryan Mar�n Quesada (B23907)
            Kevin Berm�dez Alvarado (B30957)
            Aharon Darcia Ram�rez (B22170)
 * @version: v.1		
 * @since: 28/10/2014
 */
package AppRestaurante;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class GUIAdminBebidas extends JFrame{
    
    private RegistroA registroA;
    private PanelAdminBebidas panelAdminBebidas;
	
    public GUIAdminBebidas(RegistroA registroA){
        super("Administrar Bebidas");
        this.registroA = registroA;
        this.panelAdminBebidas = panelAdminBebidas;
        panelAdminBebidas=new PanelAdminBebidas(this.registroA, this);
		getContentPane().add(this.panelAdminBebidas);
        setIconImage(new ImageIcon(getClass().getResource("Images/drink.png")).getImage());//ICONO PARA LA APLICACION
		setSize(540,580);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}//Fin del metodo constructor
}//Fin de la clase GUIAdminBebidas
