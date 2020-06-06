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

public class PanelAdminEntradas extends JPanel{
    
    private RegistroA registroA;
    private GUIAdminEntradas guiAdminEntradas;
    private JPanel pnlI, pnlImagen, pnlIdentificadores, pnlLabels, pnlII, pnlIII, pnlBotonBuscar;
    private JButton btnIncluirEntrada, btnEliminarEntrada, btnSalir, btnBuscar, btnRefresh;
    public static final String incluir="Incluir Entrada", eliminar="Eliminar Entrada", salir="Salir", buscar="Buscar", refresh="Actualizar";
    private JLabel lblTitulo, lblIdentEntrada, lblNombreEntrada, lblPrecioEntrada, lblImagen, lblVacio1, lblVacio2;
    private JTextField txtNombreEntrada, txtIDEntrada, txtPrecioEntrada;
    private Icon icnIncluir, icnEliminar, icnSalir, icnBuscar, icnRefresh;
    private Icon icnIncluir02, icnEliminar02, icnSalir02, icnDedos, icnBuscar02, icnRefresh02;
    private ManejadorAdminEntradas manejadorAdminEntradas;
/**
 * Proposito: Metodo constructor por defecto sin parametros para inicializar variables
 * Nomre del metodo: PanelAdminEntradas
 * @since: 31/10/2014
 */
    public PanelAdminEntradas(RegistroA registroA, GUIAdminEntradas guiAdminEntradas){
        this.guiAdminEntradas = guiAdminEntradas;
        this.manejadorAdminEntradas = manejadorAdminEntradas;
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
        txtNombreEntrada = new JTextField("",15);
        txtIDEntrada = new JTextField("",15);
        txtPrecioEntrada = new JTextField("",15);
        
        //ICONOS
        icnIncluir = new ImageIcon("Images/add.png");
        icnEliminar = new ImageIcon("Images/delete.png");
        icnSalir = new ImageIcon("Images/exit.png");
        icnBuscar = new ImageIcon("Images/search.png");
        icnRefresh = new ImageIcon("Images/refresh.png");
        
        icnIncluir02 = new ImageIcon("Images/add02.png");
        icnEliminar02 = new ImageIcon("Images/delete02.png");
        icnSalir02 = new ImageIcon("Images/exit02.png");
        icnDedos = new ImageIcon("Images/ceviche.png");
        icnBuscar02 = new ImageIcon("Images/search02.png");
        icnRefresh02 = new ImageIcon("Images/refresh02.png");
        
        //LABELS
        lblTitulo = new JLabel("Sub Men\u00fa | \"Administrar Entradas\"");
        lblIdentEntrada = new JLabel("N\u00B0 de identificaci\u00f3n: ");
        lblNombreEntrada = new JLabel("Nombre: ");
        lblPrecioEntrada = new JLabel("Precio \u20A1: ");
        lblImagen = new JLabel(icnDedos);
        lblVacio1 = new JLabel();
        lblVacio2 = new JLabel();
        
        //BOTONES
        btnIncluirEntrada = new JButton(incluir, icnIncluir);
        btnIncluirEntrada.setRolloverIcon(icnIncluir02);
        btnEliminarEntrada = new JButton(eliminar, icnEliminar);
        btnEliminarEntrada.setRolloverIcon(icnEliminar02);
        btnEliminarEntrada.setEnabled(false);
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
        
        pnlIdentificadores.add(lblIdentEntrada);
        pnlIdentificadores.add(lblNombreEntrada);
        pnlIdentificadores.add(lblPrecioEntrada);
      
        pnlLabels.add(txtIDEntrada);
        pnlLabels.add(txtNombreEntrada);
        pnlLabels.add(txtPrecioEntrada);
        
        pnlBotonBuscar.add(btnBuscar);
        pnlBotonBuscar.add(lblVacio1);
        pnlBotonBuscar.add(lblVacio2);
        

        pnlII.add(pnlIdentificadores);
        pnlII.add(pnlLabels);
        pnlII.add(pnlBotonBuscar);
        add(pnlII);
        
        pnlIII.add(btnIncluirEntrada);
        pnlIII.add(btnEliminarEntrada);
        pnlIII.add(btnRefresh);
        pnlIII.add(btnSalir);
        add(pnlIII);
        
        //Agregar ActionListeners a los Botones
        manejadorAdminEntradas = new ManejadorAdminEntradas(this.registroA, guiAdminEntradas, this);
            btnIncluirEntrada.addActionListener(manejadorAdminEntradas);
            btnEliminarEntrada.addActionListener(manejadorAdminEntradas);
            btnSalir.addActionListener(manejadorAdminEntradas);
            btnBuscar.addActionListener(manejadorAdminEntradas);
            btnRefresh.addActionListener(manejadorAdminEntradas);
        
    }//Fin del Método Constructor PanelAdminEntradas
    
/**METODOS SETTERS Y GETTERS ENCARGADOS DE OBTENER LA INFORMACION DEL LOS COMPONENTES**/

/**
 * Proposito: obtener la iformacion ingresada por el usuario en el componente JTextField
 * Nomre del metodo: getNombreEntrada
 * @return: informacion del componente
 * @since: 06/11/2014
 */
    public String getNombreEntrada(){
            return txtNombreEntrada.getText();
    }//Fin del metodo getNombreEntrada
    
    public void setNombre(String nombre){
        txtNombreEntrada.setText(nombre);
    }//Fin del metodo setNombre
    
/**
 * Proposito: obtener la iformacion ingresada por el usuario en el componente JTextField
 * Nomre del metodo: getNombreEntrada
 * @return: informacion del componente
 * @since: 06/11/2014
 */
    public String getIDEntrada(){
        return this.txtIDEntrada.getText();
    }//Fin del metodo getIDEntrada
    
    public void setIDEntrada(String id){
        txtIDEntrada.setText(id);
    }//Fin del metodo setIDEntrada

/**
 * Proposito: obtener la iformacion ingresada por el usuario en el componente JTextField
 * Nomre del metodo: getNombreEntrada
 * @return: informacion del componente
 * @since: 06/11/2014
 */
    public String getPrecioEntrada(){
        return txtPrecioEntrada.getText();
    }//Fin del metodo getPrecioEntrada

/**
 * Proposito: asignar la iformacion al componente JTextField
 * Nomre del metodo: setPrecio
 * @param: cadena string con informacion asignar
 * @since: 06/11/2014
 */
    public void setPrecio(String precio){
        txtPrecioEntrada.setText(precio);
    }//Fin del metodo setPrecio

/**
 * Proposito: limpiar lso componentes
 * Nomre del metodo: claenJTextField
 * @since: 06/11/2014
 */
    public void cleanJTextField(){
        txtNombreEntrada.setText("");
        txtIDEntrada.setText("");
        txtPrecioEntrada.setText("");
    }//Fin del metodo cleanTextField
    
/**
 * Proposito: habilitar/inhabilitar componentes del panel
 * Nomre del metodo: enabledBtnEliminar
 * @param: int yes= indice para controlar las acciones del metodo
 * @since: 08/11/2014
 */
    public void enabledBtnEliminar(int yes){
        if(yes==1)
            btnEliminarEntrada.setEnabled(true);
        else
            btnEliminarEntrada.setEnabled(false);
    }//Fin metodo enabledBtnEliminar

/**
 * Proposito: habilitar/inhabilitar componentes del panel
 * Nomre del metodo: enabledBtnIncluir
 * @param: int yes= indice para controlar las acciones del metodo
 * @since: 08/11/2014
 */
    public void enabledBtnIncluir(int yes){
        if(yes==1)
            btnIncluirEntrada.setEnabled(true);
        else
            btnIncluirEntrada.setEnabled(false);
    }//Fin metodo enabledBtnIncluir
    
/**
 * Proposito: habilitar/inhabilitar componentes del panel
 * Nomre del metodo: enabledJTextField
 * @param: int yes= indice para controlar las acciones del metodo
 * @since: 08/11/2014
 */
    public void enabledJTextField(int yes){
         if(yes==1){
            txtNombreEntrada.setEditable(true);
            txtIDEntrada.setEditable(true);
            txtPrecioEntrada.setEditable(true);
        }//Fin if
        else{
            txtNombreEntrada.setEditable(false);
            txtIDEntrada.setEditable(false);
            txtPrecioEntrada.setEditable(false);
        }//Fin else
    }//Fin metodo enabledJTextField
    
}//Fin del la clase PanelAdminEntradas
