/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito:  Clase PanelAdminBebidas encargada de diseño que contiene todos los componentes de la Interfaz Gráfica de usuario
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1  
 * @since: 28/10/2014
 */
 
 //IMPORTACION DE LIBRERIAS JAVA

package AppRestaurante;

import javax.swing.JTextField;
import javax.swing.JLabel; 
import javax.swing.JButton;     
import javax.swing.JPanel;      
import javax.swing.ImageIcon; 
import javax.swing.Icon;             
import java.awt.GridLayout;     
import java.awt.FlowLayout;

public class PanelAdminBebidas extends JPanel{
    
    private GUIAdminBebidas guiAdminBebidas;
    private RegistroA registroA;
    private JPanel pnl1, pnl2, pnl3, pnlFoto, pnlIdentificador, pnlLabel, pnlBtnBuscar;
    private JButton btnIncluirBebida, btnEliminarBebida, btnSalir, btnBuscar, btnRefresh;
    public static final String incluir="Incluir Bebida", eliminar="Eliminar Bebida", salir="Salir", buscar="Buscar", refresh="Actualizar";
    private Icon icnIncluir, icnEliminar, icnSalir, icnBusqueda, icnRefresh;
    private Icon icnIncluir02, icnEliminar02, icnSalir02, icnBusqueda02, icnBebida, icnRefresh02;
    private ManejadorAdminBebidas manejadorAdminBebidas;
    private JTextField txtNombreBebida, txtIDBebida, txtPrecioBebida;
    private JLabel lblTitulo, lblIdentBebida, lblNombreBebida, lblPrecioBebida, lblFoto, lblVacio1, lblVacio2;
	private String mesas[];
	private Postre agregarPostres;
	private Platillo agregarPlatillo;
	private Porcion agregarPorcion;
    

/**
 * Proposito: Metodo constructor por defecto sin parametros para inicializar variables
 * Nomre del metodo: PanelAdminBebidas
 * @since: 10/11/2014
 */
    public PanelAdminBebidas(RegistroA registroA, GUIAdminBebidas guiAdminBebidas){
        this.guiAdminBebidas = guiAdminBebidas;
        this.manejadorAdminBebidas = manejadorAdminBebidas;
        this.registroA = registroA;
        
        //PANELES
         pnl1 = new JPanel();
         pnl2 = new JPanel();
         pnlFoto = new JPanel(new GridLayout(0,1));
         pnlIdentificador = new JPanel(new GridLayout(3,1));
		 pnlLabel = new JPanel(new GridLayout(3,1));
         pnl3 = new JPanel();
         pnlBtnBuscar = new JPanel(new GridLayout(3,1));
		 
		 //JTextField
		 txtNombreBebida = new JTextField("",15);
		 txtIDBebida = new JTextField("",15);
		 txtPrecioBebida = new JTextField("",15);
		 
		 //ICONOS
		 icnIncluir = new ImageIcon("Images/add.png");
         icnEliminar = new ImageIcon("Images/delete.png");
         icnSalir = new ImageIcon("Images/exit.png");
         icnBusqueda = new ImageIcon("Images/search.png");
         icnRefresh = new ImageIcon("Images/refresh.png");
         
         icnIncluir02 = new ImageIcon("Images/add02.png");
         icnEliminar02 = new ImageIcon("Images/delete02.png");
         icnSalir02 = new ImageIcon("Images/exit02.png");
         icnBebida = new ImageIcon("Images/refresco.png");
         icnBusqueda02 = new ImageIcon("Images/search02.png");
         icnRefresh02 = new ImageIcon("Images/refresh02.png");
         
         //LABELS
         lblTitulo = new JLabel("Sub Men\u00fa | \"Administrar Bebidas\"");
         lblIdentBebida = new JLabel("N\u00B0 de identificaci\u00f3n: ");
         lblNombreBebida = new JLabel("Nombre: ");
         lblPrecioBebida = new JLabel("Precio \u20A1: ");
         lblFoto = new JLabel(icnBebida);
         lblVacio1 = new JLabel();
         lblVacio2 = new JLabel();
         
         //Botones
         btnIncluirBebida = new JButton(incluir, icnIncluir);
         btnIncluirBebida.setRolloverIcon(icnIncluir02);
         btnEliminarBebida = new JButton(eliminar, icnEliminar);
         btnEliminarBebida.setRolloverIcon(icnEliminar02);
         btnEliminarBebida.setEnabled(false);
         btnSalir = new JButton(salir, icnSalir);
         btnSalir.setRolloverIcon(icnSalir02);
	     btnBuscar = new JButton(buscar, icnBusqueda);
         btnBuscar.setRolloverIcon(icnBusqueda02);
		 btnRefresh = new JButton(refresh, icnRefresh);
		 btnRefresh.setRolloverIcon(icnRefresh02);
		 
		 //INCORPORACION DE LOS COMPONENTES A LOS PANELES
         pnl1.add(lblTitulo);
         add(pnl1);
         
         pnlFoto.add(lblFoto);
         add(pnlFoto);
         
         pnlIdentificador.add(lblIdentBebida);
         pnlIdentificador.add(lblNombreBebida);
         pnlIdentificador.add(lblPrecioBebida);
         
         pnlLabel.add(txtIDBebida);
         pnlLabel.add(txtNombreBebida);
         pnlLabel.add(txtPrecioBebida);
         
         pnlBtnBuscar.add(btnBuscar);
         pnlBtnBuscar.add(lblVacio1);
         pnlBtnBuscar.add(lblVacio2);
         
         pnl2.add(pnlIdentificador);
         pnl2.add(pnlLabel);
         pnl2.add(pnlBtnBuscar);
         add(pnl2);
        
         pnl3.add(btnIncluirBebida);
         pnl3.add(btnEliminarBebida);
         pnl3.add(btnRefresh);
         pnl3.add(btnSalir);
         add(pnl3);
                     
        //Agregar ActionListeners a los Botones
        manejadorAdminBebidas = new ManejadorAdminBebidas(registroA, guiAdminBebidas, this);
        btnIncluirBebida.addActionListener(manejadorAdminBebidas);
        btnEliminarBebida.addActionListener(manejadorAdminBebidas);
        btnSalir.addActionListener(manejadorAdminBebidas);
        btnBuscar.addActionListener(manejadorAdminBebidas);
		btnRefresh.addActionListener(manejadorAdminBebidas);
		
    }//Fin del Método Constructor PanelAdminBebidas
    
    
    
/**++++++++METODOS SETTERS Y GETTERS ENCARGADOS DE OBTENER LA INFORMACION DEL LOS COMPONENTES+++++++++++**/



/**
 * Proposito: obtener la iformacion ingresada por el usuario en el componente JTextField
 * Nomre del metodo: getNombreBebida
 * @return: informacion del componente
 * @since: 10/11/2014
 */
    public String getNombreBebida(){
            return txtNombreBebida.getText();
    }//Fin del metodo getNombreBebida

/**
 * Proposito: asignar la iformacion al componente JTextField
 * Nomre del metodo: setNombre
 * @param: cadena string con informacion asignar
 * @since: 10/11/2014
 */
    public void setNombre(String nombre){
        txtNombreBebida.setText(nombre);
    }//Fin del metodo setNombre

/**
 * Proposito: obtener la iformacion ingresada por el usuario en el componente JTextField
 * Nomre del metodo: IDBebida
 * @return: informacion del componente
 * @since: 10/11/2014
 */
    public String getIDBebida(){
        return this.txtIDBebida.getText();
    }//Fin del metodo getIDBebida

/**
 * Proposito: asignar la iformacion al componente JTextField
 * Nomre del metodo: setIDBebida
 * @param: cadena string con informacion asignar
 * @since: 10/11/2014
 */
    public void setIDBebida(String id){
        txtIDBebida.setText(id);
    }//Fin del metodo setIDBebida

/**
 * Proposito: obtener la iformacion ingresada por el usuario en el componente JTextField
 * Nomre del metodo: getPrecioBebida
 * @return: informacion del componente
 * @since: 10/11/2014
 */
    public String getPrecioBebida(){
        return txtPrecioBebida.getText();
    }//Fin del metodo getPrecioBebida

/**
 * Proposito: asignar la iformacion al componente JTextField
 * Nomre del metodo: setValor
 * @param: cadena string con informacion asignar
 * @since: 10/11/2014
 */
    public void setValor(String precio){
        txtPrecioBebida.setText(precio);
    }//Fin del metodo setValor

/**
 * Proposito: limmpiar lo componentes al inicializarlso por default vacios
 * Nomre del metodo: cleanJTextField
 * @since: 10/11/2014
 */
    public void cleanJTextField(){
        txtNombreBebida.setText("");
        txtIDBebida.setText("");
        txtPrecioBebida.setText("");
    }//Fin del metodo cleanTextField

/**
 * Proposito: habilitar/inhabilitar componentes del panel
 * Nomre del metodo: enabledBtnEliminarBebida
 * @param: int yes= indice para controlar acciones
 * @since: 18/11/2014
 */
    public void enabledBtnEliminarBebida(int yes){
        if(yes==1)
            btnEliminarBebida.setEnabled(true);
        else
            btnEliminarBebida.setEnabled(false);
    }//Fin metodo enabledBtnEliminarBebida

/**
 * Proposito: habilitar/inhabilitar componentes del panel
 * Nomre del metodo: enabledBtnIncluirBebida
 * @param: int yes= indice para controlar las acciones del metodo
 * @since: 18/11/2014
 */
    public void enabledBtnIncluirBebida(int yes){
        if(yes==1)
            btnIncluirBebida.setEnabled(true);
        else
            btnIncluirBebida.setEnabled(false);
    }//Fin metodo enabledBtnBebida

/**
 * Proposito: habilitar/inhabilitar componentes del panel
 * Nomre del metodo: enabledJTextField
 * @param: int yes= indice para controlar las acciones del metodo
 * @since: 18/11/2014
 */
    public void enabledJTextField(int yes){
         if(yes==1){
            txtNombreBebida.setEditable(true);
            txtIDBebida.setEditable(true);
            txtPrecioBebida.setEditable(true);
        }//Fin if
        else{
            txtNombreBebida.setEditable(false);
            txtIDBebida.setEditable(false);
            txtPrecioBebida.setEditable(false);
        }//Fin else
    }//Fin metodo enabledJTextField

}//Fin del la clase PanelAdminBebidas
