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

public class PanelAdminPostres extends JPanel{
   
    private JPanel pnlI, pnlImagen, pnlIdentificadores, pnlLabels, pnlII, pnlIII, pnlBotonBuscar;
    private JButton btnIncluirPostre, btnEliminarPostre, btnSalir, btnBuscar, btnRefresh;
    public static final String incluir="Incluir Postre", eliminar="Eliminar Postre", salir="Salir", buscar="buscar", refresh="Actualizar";
    private JLabel lblTitulo, lblIdentPostre, lblNombrePostre, lblPrecioPostre, lblImagen, lblVacio1, lblVacio2;
    private JTextField txtNombrePostre, txtIDPostre, txtPrecioPostre;
    private Icon icnIncluir, icnEliminar, icnSalir, icnBuscar,icnRefresh;
    private Icon icnIncluir02, icnEliminar02, icnSalir02,icntresLeches, icnBuscar02, icnRefresh02;
    private ManejadorAdminPostres manejadorAdminPostres;
    private RegistroA registroA;
    private GUIAdminPostres guiAdminPostres;

/**
 * Proposito: Metodo constructor por defecto sin parametros para inicializar variables
 * Nomre del metodo: PanelAdminPostres
 * @since: 10/11/2014
 */
    public PanelAdminPostres(RegistroA registroA, GUIAdminPostres guiAdminPostres){
        this.guiAdminPostres = guiAdminPostres;
        this.manejadorAdminPostres = manejadorAdminPostres;
        this.registroA = registroA;
        
           //PANELES
        pnlI = new JPanel();
        pnlII = new JPanel();
        pnlImagen = new JPanel(new GridLayout(0,1));
        pnlIdentificadores = new JPanel(new GridLayout(3,1));
        pnlLabels = new JPanel(new GridLayout(3,1));
        pnlIII = new JPanel();
        pnlBotonBuscar = new JPanel(new GridLayout(3,1));
        
        //JTextFields
        txtNombrePostre = new JTextField("",15);
        txtIDPostre = new JTextField("",15);
        txtPrecioPostre = new JTextField("",15);
        
        //ICONOS
        icnIncluir = new ImageIcon("Images/add.png");
        icnEliminar = new ImageIcon("Images/delete.png");
        icnSalir = new ImageIcon("Images/exit.png");
        icnBuscar = new ImageIcon("Images/search.png");
        icnRefresh = new ImageIcon("Images/refresh.png");
        
        icnIncluir02 = new ImageIcon("Images/add02.png");
        icnEliminar02 = new ImageIcon("Images/delete02.png");
        icnSalir02 = new ImageIcon("Images/exit02.png");
        icntresLeches = new ImageIcon("Images/queque.png");
        icnBuscar02 = new ImageIcon("Images/search02.png");
        icnRefresh02 = new ImageIcon("Images/refresh02.png");
        
        //LABELS
        lblTitulo = new JLabel("Sub Menú | \"Administrar Postres\"");
        lblIdentPostre = new JLabel("N° de identificación: ");
        lblNombrePostre = new JLabel("Nombre: ");
        lblPrecioPostre = new JLabel("Precio ¢: ");
        lblImagen = new JLabel(icntresLeches);
        lblVacio1 = new JLabel();
        lblVacio2 = new JLabel();
        
        //BOTONES
        btnIncluirPostre = new JButton(incluir, icnIncluir);
        btnIncluirPostre.setRolloverIcon(icnIncluir02);
        btnEliminarPostre = new JButton(eliminar, icnEliminar);
        btnEliminarPostre.setRolloverIcon(icnEliminar02);
        btnEliminarPostre.setEnabled(false);
        btnSalir = new JButton(salir,icnSalir);
        btnSalir.setRolloverIcon(icnSalir02);
        btnBuscar = new JButton(buscar, icnBuscar);
        btnBuscar.setRolloverIcon(icnBuscar02);
        btnRefresh = new JButton(refresh, icnRefresh);
        btnRefresh.setRolloverIcon(icnRefresh02);
         
        //INCORPORACION DE LOS COMPONENTES A LOS PANELES
        pnlI.add(lblTitulo);
        add(pnlI);
        
        pnlImagen.add(lblImagen);
        add(pnlImagen);
        
        pnlIdentificadores.add(lblIdentPostre);
        pnlIdentificadores.add(lblNombrePostre);
        pnlIdentificadores.add(lblPrecioPostre);
      
        pnlLabels.add(txtIDPostre);
        pnlLabels.add(txtNombrePostre);
        pnlLabels.add(txtPrecioPostre);
        
        pnlBotonBuscar.add(btnBuscar);
        pnlBotonBuscar.add(lblVacio1);
        pnlBotonBuscar.add(lblVacio2);
    
        pnlII.add(pnlIdentificadores);
        pnlII.add(pnlLabels);
        pnlII.add(pnlBotonBuscar);
        add(pnlII);
        
        pnlIII.add(btnIncluirPostre);
        pnlIII.add(btnEliminarPostre);
        pnlIII.add(btnRefresh);
        pnlIII.add(btnSalir);
        add(pnlIII);
        
        //Agregar ActionListeners a los Botones
        manejadorAdminPostres = new ManejadorAdminPostres(registroA, guiAdminPostres, this);
            btnIncluirPostre.addActionListener(manejadorAdminPostres);
            btnEliminarPostre.addActionListener(manejadorAdminPostres);
            btnSalir.addActionListener(manejadorAdminPostres);
            btnBuscar.addActionListener(manejadorAdminPostres);
            btnRefresh.addActionListener(manejadorAdminPostres);
        
    }//Fin del Método Constructor PanelAdminEntradas
    
/**METODOS SETTERS Y GETTERS ENCARGADOS DE OBTENER LA INFORMACION DEL LOS COMPONENTES**/

/**
 * Proposito: Metodos setter y getters encargados de asignar(set) y obtener los valores de los componentes JTextField del panel
 * Nomre del metodo: setters y getters 
 * @since: 10/11/2014
 */
    public String getNombrePostre(){
            return txtNombrePostre.getText();
    }//Fin del metodo getNombreEntrada
    
    public void setNombre(String nombre){
        txtNombrePostre.setText(nombre);
    }//Fin del metodo setNombre
    
    public String getIDPostre(){
        return this.txtIDPostre.getText();
    }//Fin del metodo getIDEntrada
    
    public void setIDPostre(String id){
        txtIDPostre.setText(id);
    }//Fin del metodo setIDEntrada
    
    public String getPrecioPostre(){
        return txtPrecioPostre.getText();
    }//Fin del metodo getPrecioEntrada
    
    public void setPrecio(String precio){
        txtPrecioPostre.setText(precio);
    }//Fin del metodo setPrecio

/**
 * Proposito: limpiar los componentes del panel
 * Nomre del metodo: cleanJTextField
 * @since: 10/11/2014
 */
    public void cleanJTextField(){
        txtNombrePostre.setText("");
        txtIDPostre.setText("");
        txtPrecioPostre.setText("");
    }//Fin del metodo cleanTextField

/**
 * Proposito: habilitar/inhabilitar componentes del panel
 * Nomre del metodo: enabledBtnEliminar
 * @param: int yes= indice para controlar las acciones del metodo
 * @since: 10/11/2014
 */
    public void enabledBtnEliminar(int yes){
        if(yes==1)
            btnEliminarPostre.setEnabled(true);
        else
            btnEliminarPostre.setEnabled(false);
    }//Fin metodo enabledBtnEliminar

/**
 * Proposito: habilitar/inhabilitar componentes del panel
 * Nomre del metodo: enabledBtnIncluir
 * @param: int yes= indice para controlar las acciones del metodo
 * @since: 10/11/2014
 */
    public void enabledBtnIncluir(int yes){
        if(yes==1)
            btnIncluirPostre.setEnabled(true);
        else
            btnIncluirPostre.setEnabled(false);
    }//Fin metodo enabledBtnIncluir

/**
 * Proposito: habilitar/inhabilitar componentes del panel
 * Nomre del metodo: enabledJTextField
 * @param: int yes= indice para controlar las acciones del metodo
 * @since: 10/11/2014
 */
    public void enabledJTextField(int yes){
         if(yes==1){
            txtNombrePostre.setEditable(true);
            txtIDPostre.setEditable(true);
            txtPrecioPostre.setEditable(true);
        }//Fin if
        else{
            txtNombrePostre.setEditable(false);
            txtIDPostre.setEditable(false);
            txtPrecioPostre.setEditable(false);
        }//Fin else
    }//Fin metodo enabledJTextField
    
}//Fin del la clase PanelAdminEntradas
