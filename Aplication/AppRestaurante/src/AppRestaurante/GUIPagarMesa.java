/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase encargada de mostrar el la Interfaz Gráfica de Pagar Mesa
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 28/10/2014
 */

package AppRestaurante;
 
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class GUIPagarMesa extends JFrame{
	
   private PanelPagarMesa panelPagarMesa;
   private RegistroA registroA;
   
    public GUIPagarMesa(RegistroA registroA){
        super("Desgloce de cuenta");
        this.panelPagarMesa = panelPagarMesa;
        panelPagarMesa = new PanelPagarMesa(this, registroA);
        getContentPane().add(this.panelPagarMesa);
        setIconImage(new ImageIcon(getClass().getResource("Images/job.png")).getImage());//ICONO PARA LA APLICACION
		setSize(750,700);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}//Fin del metodo constructor
}//Fin de la clase GUIPagarMesa
