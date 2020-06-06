/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito:  Clase PanelAdminBebidas encargada de diseño que contiene todos los componentes de la Interfaz Gráfica de usuario
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 30/10/2014
 */

package AppRestaurante;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel; 
import javax.swing.JButton;     
import javax.swing.JPanel;      
import javax.swing.ImageIcon; 
import javax.swing.Icon;             
import java.awt.GridLayout;     
import java.awt.FlowLayout; 
import javax.swing.JTextArea;
import javax.swing.JScrollPane; 

public class PanelPagarMesa extends JPanel{
    
    private GUIPagarMesa guiPagarMesa;
    private RegistroA registroA;
    private ManejadorPanelPagarMesa manejadorPanelPagarMesa;
    private JButton btnBuscar, btnLimpiar, btnSalir;
    private JLabel lblImagen, lblBuscar, lblPagar, lblVacio01, lblOrdenMesa, lblVacio02, lblVacio03, lblVacio04, lblVacio05, lblVacio06, lblVacio07;
    private Icon icnCancelar, icnBuscar, icnPagar, icnLimpiar, icnSalir;
    private Icon icnBuscar02, icnPagar02, icnLimpiar02, icnSalir02;
    private JTextField txtBuscar, txtPorPagar;
    private JPanel pnlPrimario, pnlSecundario, pnlBotones, pnlGeneral, pnlTitulos, pnlInfo, pnlJScroll;
    private JTextArea infoMesa;
    private JScrollPane barraInfo;
    public static final String buscarMesa= "Buscar Mesa", limpiar= "Actualizar", salir= "Salir";
   
/**
 * Proposito: Metodo constructor por defecto sin parametros para inicializar variables
 * Nomre del metodo: PanelPagarMesa
 * @since: 30/10/2014
 */
    public PanelPagarMesa(GUIPagarMesa guiPagarMesa, RegistroA registroA){
        this.guiPagarMesa = guiPagarMesa;
        this.registroA = registroA;
        
			//Inicializacion de los paneles
		pnlPrimario= new JPanel(new GridLayout(1,1));
		pnlSecundario= new JPanel(new GridLayout(2,0));
		pnlBotones= new JPanel(new FlowLayout());
		pnlGeneral= new JPanel(new GridLayout(2,1));
			
			//Inicializacion de los JTextField
		txtBuscar=new JTextField("");
		txtPorPagar= new JTextField("");
			txtPorPagar.setEditable(false);
			
			//Inicializacion de los Icon
		icnBuscar= new ImageIcon("Images/search.png");
		icnPagar= new ImageIcon("Images/pagar.png");
		icnLimpiar= new ImageIcon("Images/refresh.png");
		icnSalir= new ImageIcon("Images/exit.png");
		icnCancelar= new ImageIcon("Images/caja.png");
		
		icnBuscar02= new ImageIcon("Images/search02.png");
		icnPagar02= new ImageIcon("Images/pagar02.png");
		icnLimpiar02= new ImageIcon("Images/refresh02.png");
		icnSalir02= new ImageIcon("Images/exit02.png");
			
			//Inicializacion de los JLabel
		lblImagen= new JLabel(icnCancelar);
		lblBuscar= new JLabel("Buscar Mesa: ");
        lblPagar= new JLabel("Total Por Pagar: ");
        lblVacio01= new JLabel("       ");
        lblOrdenMesa= new JLabel("Desglose de cuenta: ");
        lblVacio02= new JLabel("       ");
        lblVacio03= new JLabel("       ");
        lblVacio04= new JLabel("                                  \u20A1");
        lblVacio05= new JLabel("       ");
        lblVacio06= new JLabel("                                                 ");
        lblVacio07= new JLabel("                                                 ");
        	
			//Inicializacion de los JButton
		btnBuscar= new JButton(buscarMesa, icnBuscar);
			btnBuscar.setRolloverIcon(icnBuscar02);
		btnLimpiar= new JButton(limpiar, icnLimpiar);
			btnLimpiar.setRolloverIcon(icnLimpiar02);
		btnSalir= new JButton(salir, icnSalir);
			btnSalir.setRolloverIcon(icnSalir02);
				
			//Inicializacion del JTextArea
		infoMesa= new JTextArea("\n\n\n\n\n\n\n\n\n--- Desglose de Cuenta ---\n\n\n\n\n\n\n\n\n");
        
			infoMesa.setEditable(false);
			
			//Inicializacion del JScrollPane
		barraInfo= new JScrollPane(infoMesa);
        
			
			//INCORPORACION DE LOS COMPONENTES A LOS PANELES
		pnlPrimario.add(lblImagen);
		add(pnlPrimario);
        
		pnlTitulos = new JPanel(new GridLayout(1,5));
            pnlTitulos.add(lblBuscar);
            pnlTitulos.add(lblVacio01);
            pnlTitulos.add(lblOrdenMesa);
            pnlTitulos.add(lblVacio02);
            pnlTitulos.add(lblPagar);
        
        pnlInfo = new JPanel(new GridLayout(1,5));
            pnlInfo.add(txtBuscar);
            pnlInfo.add(lblVacio03);
            pnlInfo.add(lblVacio05);
            pnlInfo.add(lblVacio04);
            pnlInfo.add(txtPorPagar);
            
        pnlGeneral.add(pnlTitulos);
		pnlGeneral.add(pnlInfo);
		add(pnlGeneral);
		
        pnlJScroll = new JPanel(new GridLayout(1,1));
            pnlJScroll.add(barraInfo);
        add(pnlJScroll);
		
        pnlBotones.add(lblVacio06);
		pnlBotones.add(btnBuscar);
		pnlBotones.add(btnLimpiar);
		pnlBotones.add(btnSalir);
        pnlBotones.add(lblVacio07);
		add(pnlBotones);
    
		manejadorPanelPagarMesa = new ManejadorPanelPagarMesa(registroA, guiPagarMesa, this);
			btnBuscar.addActionListener(manejadorPanelPagarMesa);
			btnLimpiar.addActionListener(manejadorPanelPagarMesa);
			btnSalir.addActionListener(manejadorPanelPagarMesa);
        
     }//Fin del Método Constructor PanelPagarMesa
     
/**
 * Proposito: asignar a componente el texto
 * Nombre del metodo: setTextBuscar
 * @since: 1/11/2014
*/
     public void setTextBuscar(String buscar){
		 txtBuscar.setText(buscar);
	 }//fin del metodo
     
     
	 public String getTextBuscar(){
		 return txtBuscar.getText();
	 }//fin del metodo
     
/**
 * Proposito: asignar a componente el texto
 * Nombre del metodo: setTextPagar
 * @param: cadena string con la informacion asignar
 * @since: 1/11/2014
*/
	 public void setTextPagar(String pagar){
		 txtPorPagar.setText(pagar);
	 }//fin del metodo

/**
 * Proposito: limpiar componentes a inicializarlos de forma vacia
 * Nombre del metodo: cleanJTextField
 * @since: 1/11/2014
*/
	 public void cleanJTextField(){
		txtBuscar.setText("");
		txtPorPagar.setText(""); 
		infoMesa.setText("");
	 }//fin del metodo

/**
 * Proposito: asignar a componente el texto
 * Nombre del metodo: setTextArea
 * @param: cadena string con la informacion para asignar
 * @since: 1/11/2014
*/
	 public void setTextArea(String info){
		 infoMesa.setText(info);
	 }//fin del metodo
	 
}//Fin del la clase PanelPagarMesa
