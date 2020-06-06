/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito:  Clase encargada de mostrar el la Interfaz Gráfica de Agregar Orden a Mesa
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 26/11/2014
 */

package AppRestaurante;

import AppRestaurante.PanelAgregarOrdenMesa;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GUIAgregarOrdenMesa extends JFrame{
    
    private PanelAgregarOrdenMesa panelAgregarOrdenMesa;
    private RegistroA registroA;
	
    public GUIAgregarOrdenMesa(RegistroA registroA){
        super("Agregar \u00d3rden a Mesa");
        this.registroA = registroA;
        panelAgregarOrdenMesa = new PanelAgregarOrdenMesa(this, this.registroA);
		getContentPane().add(panelAgregarOrdenMesa);
        setIconImage(new ImageIcon(getClass().getResource("Images/table.png")).getImage());
		setSize(1300,550);
		setVisible(true);
        setLocationRelativeTo(null);
		setResizable(false);
	}//Fin del metodo constructor
}//Fin de la clase GUIAgregarOrdenMesa
