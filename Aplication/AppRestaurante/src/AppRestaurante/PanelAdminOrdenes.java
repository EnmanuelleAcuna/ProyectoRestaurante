/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito:  Clase PanelAdminOrdenes encargada de diseño que contiene todos los componentes de la Interfaz Gráfica de usuario
 * @author: Bryan Marín Quesada (B23907)
 *			Kevin Bermúdez Alvarado (B30957)
 *          Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 10/11/2014
 */

package AppRestaurante;

//IMPORTACION DE LIBRERIAS JAVA
import javax.swing.JTextField;
import javax.swing.JLabel; 
import javax.swing.JButton;     
import javax.swing.JPanel;      
import javax.swing.ImageIcon; 
import javax.swing.Icon;             
import java.awt.GridLayout; 
import java.awt.FlowLayout;     
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class PanelAdminOrdenes extends JPanel{
    private int state;
    private GUIAdminOrdenes guiAdminOrdenes;
    private ManejadorAdminOrdenes manejadorAdminOrdenes;
    private RegistroA registroA;
    private JPanel pnlBotones,pnlLabels, pnlJTextField, pnlBtnBuscar, pnlInformacion, pnlRadio, pnlImagen, pnlTitulo, pnlVacioI, pnlVacioII, pnlJRadioButton;
    private JButton btnIncluirOrden, btnModiOrden, btnEliminarOrden, btnSalir, btnBuscar, btnRefresh;
    public static final String incluir="Incluir \u00d3rden", modificar="Modificar \u00d3rden", eliminar="Eliminar \u00d3rden", salir="Salir", buscar="Buscar", refresh="Actualizar";
    private Icon icnIncluir, icnModificar, icnEliminar, icnSalir, icnBuscar, icnRefresh;
    private Icon icnIncluir02, icnModificar02, icnEliminar02, icnSalir02, icnImagen, icnBuscar02, icnRefresh02;
    private ButtonGroup groupSelec;
    private JRadioButton rbtnFuerte, rbtnAcomp;
    private JLabel lblTitulo, lblNombre, lblID, lblPrecio, lblImagen, lblTipoPorcion, lblVacioI, lblVacioII, lblVacioIII, lblVacioIV, lblVacioV, lblVacioVI;
    
    private JTextField txtNombre, txtID, txtPrecio;
    
/**
 * Proposito: Metodo constructor por defecto sin parametros para inicializar variables
 * Nomre del metodo: PanelAdminOrdenes
 * @since: 14/11/2014
 */  
    public PanelAdminOrdenes(GUIAdminOrdenes guiAdminOrdenes, RegistroA registroA){
        this.guiAdminOrdenes = guiAdminOrdenes;
        this.registroA = registroA;
        /****************************************************************/
        setLayout(new FlowLayout());
        /****************************************************************/
        txtNombre = new JTextField("",7);
        txtID = new JTextField("",7);
        txtPrecio = new JTextField("",7);
        /****************************ICONS************************************/
        icnIncluir = new ImageIcon("Images/add.png");
        icnModificar = new ImageIcon("Images/edit.png"); 
        icnEliminar = new ImageIcon("Images/delete.png");
        icnSalir = new ImageIcon("Images/exit.png");
        icnBuscar = new ImageIcon("Images/search.png");
        icnRefresh = new ImageIcon("Images/refresh.png");
        
        icnIncluir02 = new ImageIcon("Images/add02.png");
        icnModificar02 = new ImageIcon("Images/edit02.png"); 
        icnEliminar02 = new ImageIcon("Images/delete02.png");
        icnSalir02 = new ImageIcon("Images/exit02.png"); 
        icnBuscar02 = new ImageIcon("Images/search02.png");
        icnRefresh02 = new ImageIcon("Images/refresh02.png");
        
        icnImagen = new ImageIcon("Images/porciones.png");
        /******************************LABELS**********************************/
        lblTitulo = new JLabel("    Sub Men\u00fa| \"Administrar \u00d3rdenes\"    ");
        lblNombre = new JLabel("Nombre de la \u00f3rden: ");
        lblID = new JLabel("N\u00famero de identificaci\u00f3n: ");
        lblPrecio = new JLabel("Precio:                                          \u20A1 ");
        lblImagen = new JLabel(icnImagen);
        lblTipoPorcion = new JLabel("Tipo de \u00f3rden:");
        lblVacioI = new JLabel("");
        lblVacioII = new JLabel("");
        lblVacioIII = new JLabel("");
        lblVacioIV = new JLabel("");
        lblVacioV = new JLabel("");
        lblVacioVI = new JLabel("");
        /******************************JRADIOBUTTONS**********************************/
        rbtnFuerte = new JRadioButton("Fuerte");
        rbtnFuerte.setBackground(new java.awt.Color(255,255,255));
        rbtnFuerte.setActionCommand("1");
        
        rbtnAcomp = new JRadioButton("Acompa\u00f1amiento");
        rbtnAcomp.setBackground(new java.awt.Color(255,255,255));
        rbtnAcomp.setActionCommand("2");
        /***************************JBUTTONS*************************************/
		btnIncluirOrden = new JButton(incluir, icnIncluir);
        btnIncluirOrden.setBackground(new java.awt.Color(238 ,238 ,209));
        btnIncluirOrden.setRolloverIcon(icnIncluir02);
        
		btnModiOrden = new JButton(modificar, icnModificar);
        btnModiOrden.setRolloverIcon(icnModificar02);
        btnModiOrden.setBackground(new java.awt.Color(238 ,238 ,209));
        btnModiOrden.setEnabled(false);
        
		btnEliminarOrden = new JButton(eliminar, icnEliminar);
        btnEliminarOrden.setRolloverIcon(icnEliminar02);
        btnEliminarOrden.setBackground(new java.awt.Color(238 ,238 ,209));
        btnEliminarOrden.setEnabled(false);
        
        btnSalir = new JButton(salir, icnSalir);
        btnSalir.setRolloverIcon(icnSalir02);
        btnSalir.setBackground(new java.awt.Color(238 ,238 ,209));
        
        btnBuscar = new JButton(buscar, icnBuscar);
        btnBuscar.setRolloverIcon(icnBuscar02);
        btnBuscar.setBackground(new java.awt.Color(238 ,238 ,209));
        
        btnRefresh = new JButton(refresh, icnRefresh);
        btnRefresh.setRolloverIcon(icnRefresh02);
        btnRefresh.setBackground(new java.awt.Color(238 ,238 ,209));
        /*************************BUTTONGROUPS***************************************/
        groupSelec = new ButtonGroup();
            groupSelec.add(rbtnAcomp);
            groupSelec.add(rbtnFuerte);
        /*************************FORAMTO DE PANELES***************************************/
        pnlTitulo = new JPanel();
            pnlTitulo.add(lblTitulo);
        add(pnlTitulo);
        pnlTitulo.setBackground(new java.awt.Color(255,255,255));
        
        pnlImagen = new JPanel(new GridLayout(1,0));
            pnlImagen.add(lblImagen);
            pnlImagen.setBackground(new java.awt.Color(255,255,255));
        add(pnlImagen);
        
        pnlRadio  = new JPanel(new GridLayout(2,2));
            pnlRadio.add(lblTipoPorcion);
            pnlRadio.add(rbtnFuerte);
            pnlRadio.add(lblVacioI);
            pnlRadio.add(rbtnAcomp);
        pnlRadio.setBackground(new java.awt.Color(255,255,255));    
        pnlVacioI = new JPanel();
        pnlVacioI.setBackground(new java.awt.Color(255,255,255)); 
       
            
        pnlBtnBuscar = new JPanel(new GridLayout(3,1));
            pnlBtnBuscar.add(btnBuscar);
            pnlBtnBuscar.add(lblVacioIII);
            pnlBtnBuscar.add(lblVacioIV);
        pnlBtnBuscar.setBackground(new java.awt.Color(255,255,255));
            
        pnlLabels = new JPanel(new GridLayout(3,1));
            pnlLabels.add(lblID);
            pnlLabels.add(lblNombre);
            pnlLabels.add(lblPrecio);
        pnlLabels.setBackground(new java.awt.Color(255,255,255));
        
        pnlJTextField = new JPanel(new GridLayout(3,1));
            pnlJTextField.add(txtID);
            pnlJTextField.add(txtNombre);
            pnlJTextField.add(txtPrecio);
        pnlJTextField.setBackground(new java.awt.Color(255,255,255));
        
        pnlInformacion = new JPanel(new GridLayout(1,3));
            pnlInformacion.add(pnlLabels);
            pnlInformacion.add(pnlJTextField);
            pnlInformacion.add(pnlBtnBuscar);
            pnlInformacion.setBackground(new java.awt.Color(255,255,255));
        add(pnlInformacion);
        
        pnlJRadioButton = new JPanel(new GridLayout(1,2));
            pnlJRadioButton.add(pnlRadio);
            pnlJRadioButton.add(pnlVacioI);
        add(pnlJRadioButton);
        
        pnlBotones = new JPanel();
			pnlBotones.setLayout(new GridLayout(2,3));
        pnlBotones.add(btnIncluirOrden);
        pnlBotones.add(btnModiOrden);
        pnlBotones.add(btnEliminarOrden);
        pnlBotones.add(btnRefresh);
        pnlBotones.add(lblVacioII);
        pnlBotones.add(btnSalir);
        pnlBotones.setBackground(new java.awt.Color(255,255,255));
		add(pnlBotones);
        /********************************ACTIONLISTENERS*********************************/
        manejadorAdminOrdenes = new ManejadorAdminOrdenes(this.guiAdminOrdenes, this.registroA, this);
            btnIncluirOrden.addActionListener(manejadorAdminOrdenes);
            btnModiOrden.addActionListener(manejadorAdminOrdenes);
            btnEliminarOrden.addActionListener(manejadorAdminOrdenes);
            btnSalir.addActionListener(manejadorAdminOrdenes);
            btnBuscar.addActionListener(manejadorAdminOrdenes);
            btnRefresh.addActionListener(manejadorAdminOrdenes);
            
            rbtnAcomp.addActionListener(manejadorAdminOrdenes);
            rbtnFuerte.addActionListener(manejadorAdminOrdenes);
    }//Fin del Método Constructor PanelAdminOrdenes

/**
 * Proposito: obtener la iformacion ingresada por el usuario en el componente JTextField
 * Nomre del metodo: getTxtID
 * @return: informacion del componente
 * @since: 14/11/2014
 */
    public String getTxtID(){
        return txtID.getText().toString().trim();
    }//fin metodo
    
/**
 * Proposito: obtener la iformacion ingresada por el usuario en el componente JTextField
 * Nomre del metodo: getTxtNombre
 * @return: informacion del componente
 * @since: 14/11/2014
 */
    public String getTxtNombre(){
        return txtNombre.getText().toString().trim();
    }//fin metodo
    
/**
 * Proposito: obtener la iformacion ingresada por el usuario en el componente JTextField
 * Nomre del metodo: getTxtPrecio
 * @return: informacion del componente
 * @since: 14/11/2014
 */
    public String getTxtPrecio(){
        if(!txtPrecio.getText().equals("")){
            return txtPrecio.getText().trim();
        }//fin if
    return null;
    }//fin metodo

/**
 * Proposito: asignar la iformacion al componente JTextField
 * Nomre del metodo: setTxtID
 * @param: cadena string con informacion asignar
 * @since: 14/11/2014
 */
    public void setTxtID(String id){
        txtID.setText(id);
    }//fin metodo

/**
 * Proposito: asignar la iformacion al componente JTextField
 * Nomre del metodo: setTxtNombre
 * @param: cadena string con informacion asignar
 * @since: 14/11/2014
 */
    public void setTxtNombre(String nombre){
        txtNombre.setText(nombre);
    }//Fin metodo

/**
 * Proposito: asignar la iformacion al componente JTextField
 * Nomre del metodo: setTxtPrecio
 * @param: cadena string con informacion asignar
 * @since: 14/11/2014
 */
    public void setTxtPrecio(double precio){
        String strPrecio="";
        strPrecio=Double.toString(precio);
        txtPrecio.setText(strPrecio);
    }//fin metodo

/**
 * Proposito: obtener el estado de los JRadioButtons seleccionados
 * Nomre del metodo: getStateOfJRadioButtons
 * @return: true o false= si se encuentran activados alguno de los dos componentes true sino false
 * @since: 14/11/2014
 */
    public Boolean getStateOfJRadioButtons(){
        if(rbtnAcomp.isSelected()==true || rbtnFuerte.isSelected()==true){
            return true;
        }//fin if
    return false;
    }//Fin metodo

/**
 * Proposito: habilitar o inhabilitar los componentes del panel
 * Nomre del metodo: enabledOfSearch
 * @param: int i= indice para controlar acciones
 * @since: 14/11/2014
 */
    public void enabledOfSearch(int i){
        if(i==1){
            rbtnAcomp.setEnabled(false);
            rbtnFuerte.setEnabled(false);
            btnIncluirOrden.setEnabled(false);
            txtNombre.setEditable(true);
            txtID.setEditable(false);
            txtPrecio.setEditable(true);
            btnEliminarOrden.setEnabled(true);
            btnModiOrden.setEnabled(true);
        }else{
            rbtnAcomp.setEnabled(true);
            rbtnFuerte.setEnabled(true);
            btnIncluirOrden.setEnabled(true);
            txtNombre.setEditable(true);
            txtID.setEditable(true);
            txtPrecio.setEditable(true);
            btnEliminarOrden.setEnabled(false);
            btnModiOrden.setEnabled(false);
        }//fin else
    }//Fin metodo

/**
 * Proposito: seleccionar un JRadioButton especifico
 * Nomre del metodo: setStateOfJRadioButton
 * @param: int i= indice para controlar acciones
 * @since: 14/11/2014
 */
    public void setStateOfJRadioButton(int i){
        if(i==1)
            rbtnFuerte.setSelected(true);
        else
            rbtnAcomp.setSelected(true);
    }//fin metodo

/**
 * Proposito: limpiar los componentes
 * Nomre del metodo: cleanComponents
 * @since: 14/11/2014
 */
    public void cleanComponets(){
        txtNombre.setText("");
        txtID.setText("");
        txtPrecio.setText("");
        groupSelec.clearSelection();
    }//fin metodo
    
}//fin de la clase
