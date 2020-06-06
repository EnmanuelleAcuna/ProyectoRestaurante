/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: ...
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 28/10/2014
 */

package AppRestaurante;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class GUIAdminMesas extends JFrame{
    
    private PanelAdminMesas panelAdminMesas;
	private RegistroA registroA;
    public GUIAdminMesas(RegistroA registroA){
        super("Administrar Mesas");
        this.panelAdminMesas = panelAdminMesas;
        this.registroA = registroA;
        panelAdminMesas=new PanelAdminMesas(this, registroA);
		getContentPane().add(this.panelAdminMesas);
        setIconImage(new ImageIcon(getClass().getResource("Images/two.png")).getImage());//ICONO PARA LA APLICACION
		setSize(550,650);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}//Fin del metodo constructor
}//Fin de la clase GUIAdminMesas
