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
 * 
 */

package AppRestaurante;
 
import javax.swing.JPanel;     
import javax.swing.JTextField;
import javax.swing.JLabel; 
import javax.swing.JButton;     
import javax.swing.JPanel;      
import javax.swing.ImageIcon; 
import javax.swing.Icon;             
import javax.swing.JList;
import java.awt.GridLayout;     
import java.awt.FlowLayout;
import javax.swing.JScrollPane;  
import javax.swing.JTextArea;

public class PanelAdminPlatillos extends JPanel{
    
    private RegistroA registroA;
    private GUIAdminPlatillos guiAdminPlatillos;
    private JPanel pnlTitulo, pnlBotones, pnlPlatillo, pnlInformacion, pnlImagen, pnlSelec, pnlJList, pnlNombre, pnlID, pnlPrecio, pnlVacio1, pnlVacio2, pnlJTextArea, pnlBotonesPorciones;
    private JButton btnIncluirPlatillo, btnModificarPlatillo, btnEliminarPlatillo, btnSalir, btnRefresh, btnEliminarPorcion, btnAgregarPorcion;
    private ManejadorAdminPlatillos manejadorAdminPlatillos;
    private Icon icnIncluir, icnModificar, icnEliminar, icnSalir, icnPlatillo, icnRefresh;
    private Icon icnIncluir02, icnModificar02, icnEliminar02, icnSalir02, icnRefresh02;;
    private JLabel lblTitulo, lblID, lblPrecio, lblNombre, lblImagen, lblSeleccion,lblVacio1, lblVacio2, lblVacio3, lblVacio4, lblVacio5, lblVacio6, lblVacio7, lblPlatillo;
    public static final String incluir="Incluir Platilllo", modificar="Modificar Platillo", eliminar="Eliminar Platillo", salir="Salir", refresh="Refresh", eliminarPorcion="Eliminar porcion", agregarPorcion="Agregar porcion";
    private JTextField txtNombre, txtID, txtPrecio;
    private JScrollPane barraDesplazamiento, barraDesplazamiento2;
    public JList lista;
    private Porcion ordenJList;
    private String ordenes[];
    private Porcion porciones [];
    private JTextArea platilloFinal;

/**
 * Proposito: Metodo constructor por defecto sin parametros para inicializar variables
 * Nomre del metodo: PanelAdminPlatillos
 * @since: 30/10/2014
 */
    public PanelAdminPlatillos(GUIAdminPlatillos guiAdminPlatillos, RegistroA registroA){
        this.guiAdminPlatillos = guiAdminPlatillos;
        this.manejadorAdminPlatillos = manejadorAdminPlatillos;
        this.registroA = registroA;
        porciones = new Porcion[50];
            
            setLayout(new FlowLayout());
            
            platilloFinal = new JTextArea();
            platilloFinal.setEditable(false);
            
            platilloFinal.setText("\nSeleccione una \"porci\u00f3n\"\n");
            lblTitulo = new JLabel("\"Sub Menu | Administrar Platillos\"");
            lblID = new JLabel("N\u00b0 Identificaci\u00f3n: ");
            lblPrecio = new JLabel("Precio: ");
            lblNombre = new JLabel("Nombre del platillo: ");
            lblSeleccion = new JLabel("Seleccione las \"porciones\" del platillo:");
            lblVacio1 = new JLabel("                           ");
            lblVacio2 = new JLabel("                           ");
            lblVacio3 = new JLabel("                           ");
            lblVacio4 = new JLabel("                           ");
            lblVacio5 = new JLabel(" ");
            lblVacio6 = new JLabel("");
            lblVacio7 = new JLabel("");
            lblPlatillo = new JLabel("Platillo: ");
            
            txtNombre = new JTextField("",15);
            txtID = new JTextField("",15);
            txtID.setActionCommand("Enter");
            txtPrecio = new JTextField("",15);
            txtPrecio.setEditable(false);
            
            ordenes = new String[registroA.getSizeOfArrayPorciones()];
            loadJList();// Ejecuta el metodo que cargara el vector;
            lista = new JList(ordenes);
            lista.setVisibleRowCount(3);
            barraDesplazamiento = new JScrollPane(lista); 
            barraDesplazamiento2 = new JScrollPane(platilloFinal);

            icnIncluir = new ImageIcon("Images/add.png");
            icnIncluir02 = new ImageIcon("Images/add02.png");
            icnModificar = new ImageIcon("Images/edit.png"); 
            icnModificar02 = new ImageIcon("Images/edit02.png");
            icnEliminar = new ImageIcon("Images/delete.png");
            icnEliminar02 = new ImageIcon("Images/delete02.png");
            icnSalir = new ImageIcon("Images/exit.png");
            icnSalir02 = new ImageIcon("Images/exit02.png");
			icnPlatillo = new ImageIcon("Images/platillo1.png");
            lblImagen = new JLabel(icnPlatillo);
            icnRefresh = new ImageIcon("Images/refresh.png");
            icnRefresh02 = new ImageIcon("Images/refresh02.png");
            
			btnIncluirPlatillo = new JButton(incluir, icnIncluir);
            btnIncluirPlatillo.setRolloverIcon(icnIncluir02);
			btnModificarPlatillo = new JButton(modificar, icnModificar);
            btnModificarPlatillo.setRolloverIcon(icnModificar02);
            btnModificarPlatillo.setEnabled(false);
			btnEliminarPlatillo = new JButton(eliminar, icnEliminar);
            btnEliminarPlatillo.setRolloverIcon(icnEliminar02);
            btnEliminarPlatillo.setEnabled(false);
            btnSalir = new JButton(salir, icnSalir);
            btnSalir.setRolloverIcon(icnSalir02);
            btnRefresh = new JButton(refresh, icnRefresh);
            btnRefresh.setRolloverIcon(icnRefresh02);
            btnEliminarPorcion = new JButton(eliminarPorcion);
            btnAgregarPorcion = new JButton(agregarPorcion);
            btnAgregarPorcion.setBackground(new java.awt.Color(0, 238, 0));
            btnEliminarPorcion.setBackground(new java.awt.Color(255, 69, 0));
            
            pnlTitulo = new JPanel(new GridLayout(1,1));
                pnlTitulo.add(lblTitulo);
            add(pnlTitulo);
            
            pnlImagen = new JPanel(new GridLayout(1,1));
                pnlImagen.add(lblImagen);
            add(pnlImagen);
            
            
            pnlJList = new JPanel(new GridLayout(2,0));
                pnlJList.add(lblSeleccion);
                pnlJList.add(barraDesplazamiento);
                
            pnlJTextArea = new JPanel(new GridLayout(2,0));
                pnlJTextArea.add(lblPlatillo);
                pnlJTextArea.add(barraDesplazamiento2);
                
            pnlVacio1 = new JPanel();
            pnlVacio2 = new JPanel();
            
            pnlBotonesPorciones = new JPanel(new GridLayout(3,0));
                pnlBotonesPorciones.add(lblVacio7);
                pnlBotonesPorciones.add(btnAgregarPorcion);
                pnlBotonesPorciones.add(btnEliminarPorcion);
                
            pnlPlatillo = new JPanel(new FlowLayout());
                pnlPlatillo.add(pnlVacio1);
                pnlPlatillo.add(pnlJList);
                pnlPlatillo.add(pnlBotonesPorciones);
                pnlPlatillo.add(lblVacio1);
                pnlPlatillo.add(pnlJTextArea);
            add(pnlPlatillo);
            
            pnlNombre = new JPanel(new GridLayout(2,0));
                pnlNombre.add(lblNombre);
                pnlNombre.add(txtNombre);
            
            pnlID = new JPanel(new GridLayout(2,0));
                pnlID.add(lblID);
                pnlID.add(txtID);
            
            pnlPrecio = new JPanel(new GridLayout(2,0));
                pnlPrecio.add(lblPrecio);
                pnlPrecio.add(txtPrecio);
            
            pnlInformacion = new JPanel(new FlowLayout());
                pnlInformacion.add(pnlID);
                pnlInformacion.add(lblVacio5);
                pnlInformacion.add(pnlNombre);
                pnlInformacion.add(lblVacio6);
                pnlInformacion.add(pnlPrecio);
            add(pnlInformacion);
            
			pnlBotones = new JPanel(new FlowLayout());
                pnlBotones.add(btnIncluirPlatillo);
                pnlBotones.add(btnModificarPlatillo);
                pnlBotones.add(btnEliminarPlatillo);
                pnlBotones.add(btnRefresh);
                pnlBotones.add(btnSalir);
			add(pnlBotones);
            
            //Agregar ActionListeners a los Botones
            manejadorAdminPlatillos = new ManejadorAdminPlatillos(guiAdminPlatillos, this, this.registroA);
                btnIncluirPlatillo.addActionListener(manejadorAdminPlatillos);
                btnModificarPlatillo.addActionListener(manejadorAdminPlatillos);
                btnEliminarPlatillo.addActionListener(manejadorAdminPlatillos);
                btnSalir.addActionListener(manejadorAdminPlatillos);
                btnEliminarPorcion.addActionListener(manejadorAdminPlatillos);
                btnRefresh.addActionListener(manejadorAdminPlatillos);
                btnAgregarPorcion.addActionListener(manejadorAdminPlatillos);
                txtID.addActionListener(manejadorAdminPlatillos);
    }//Fin del Método Constructor PanelAdminPlatillos

/**
 * Proposito: Lama al metodo del registro y le ingresa un parametro; este parametro se obtiene al 
              seleccionar una opcion de la lista la cual es convertida a String, la misma se envia por
              parametros al registro, el cual comparara mediante el metodo y devolvera un objeto de Tipo 
              Porcion del ArayList de la clase RegistroA para guargalo en el array de tipo Porciones de este panel.
 * Nombre del metodo: porcionesSeleccionadas
 * @since: 20/11/2014
 * @return: Retorna un array de tipo Porciones
*/
     public void agregarPorcion(){
        for(int i=0; i<porciones.length; i++){
            if(porciones[i]==null){
                porciones[i] = registroA.getPorcion((String)lista.getSelectedValue());
                setJTextField();
                setTxtPrecio(Double.toString(calcularPrecio()));
            break;
            }//fin if
        }//fin for
    }//fin metodo

/**
 * Proposito: Devuelve un array de tipo porcion
 * Nombre del metodo: porcionesSeleccionadas
 * @since: 20/11/2014
 * @return: porciones= Devuelve el array de Tipo Porcion
*/
    public Porcion [] porcionesSeleccionadas(){
        return porciones; 
    }//fin metodo

/**
 * Proposito: Cargar el Jlist con las porciones almacenadas previamente
 * Nombre del metodo: loadJList
 * @since: 20/11/2014
*/
    public void loadJList(){
        for(int i=0; i<ordenes.length; i++){
            ordenes[i]=registroA.cargarJList(i).getNombre();
        }//fin for
    }//fin del metodo

/**
 * Proposito: Elimina una porcion del array temporal antes de ser almacenada en tiempo de ejecucion
 * Nombre del metodo: eliminarPorcion
 * @since: 20/11/2014
*/
     public void eliminarPorcion(){
        for(int i=0; i<porciones.length; i++){
            if(porciones[i]!=null){
                if(porciones[i].getNombre().equals((String)lista.getSelectedValue())){
                    porciones[i]=null;
                    refreshJList();
                    break;
                }//fin if
            }//fin if
        }//Fin for
    }//fin metodo
    

/**
 * Proposito: Calcular el precio de las porciones almacenadas en tiempo de ejecucion antes de ser almacenado en el array para la visualizacion del usuario
 * Nombre del metodo: calcularPrecio
 * @since: 20/11/2014
 * @return: double precio final= variable de tipo double con el precio final de las porciones agregadas temporalmente
*/
    public double calcularPrecio(){
        double precioFinal=0.0;
        for(int i=0; i<porciones.length; i++){
            if(porciones[i]!=null){
                precioFinal+=porciones[i].getPrecio();
            }//Fin if
        }//fin for
    return precioFinal;
    }//fin del metodo

/**
 * Proposito: Devuelve una cadena string con la informacion de los platillos agreados temporalmente
 * Nombre del metodo: verPlatillo
 * @since: 20/11/2014
 * @return: String lista= String que almacenada la concatenacion de los nombres de las distintas porciones
*/
    public String verPlatilllo(){
        String lista="";
        for(int i=0; i<porciones.length; i++){
            if(porciones[i]!=null)
            lista+=(i+1)+". "+porciones[i].getNombre()+"\n";
        }//fin for
        return lista;
    }//fin metodo
    
/**
 * Proposito: Devuelve la informacion contenida en el JTextField precio y lo parsea a Double para ser almacenado
 * Nombre del metodo: getTxtPrecio
 * @since: 20/11/2014
 * @return: porciones= el precio del JTextField Precio, si el espacio precio se encuetra vacio se 
                       retorna un 0.0 que significa que no existen porciones seleccionadas
*/
    public double getTxtPrecio(){
        if(!txtPrecio.equals("")){
            return Double.parseDouble(txtPrecio.getText());
        }//fin if
        return 0.0;
    }//fin metodo
    
/**
 * Proposito: asigna al componente JTextField precio una variable de tipo estring para ser visualizada por el usuario
 * Nombre del metodo: setTxtPrecio
 * @since: 20/11/2014
 * @param: String precio= variable de tipo String con el valor del precio
*/
    public void setTxtPrecio(String precio){
        txtPrecio.setText(precio);
    }//fin metodo

/**
 * Proposito: Devolver el texto que ingresa el usuario al JtextField txtNombre
 * Nombre del metodo: getTxtNombre
 * @since: 20/11/2014
 * @return: retorna el texto del componente 
*/
    public String getTxtNombre(){
        return txtNombre.getText();
    }//fin metodo
    
/**
 * Proposito: asigna informacion al componente txtNombre
 * Nombre del metodo: setTxtPrecio
 * @since: 20/11/2014
*/
    public void setTxtNombre(String nombre){
        txtNombre.setText(nombre);
    }//fin metodo
    
/**
 * Proposito: Devuelve la informacion contenida en el JTextField identificacion
 * Nombre del metodo: getTxtID
 * @since: 20/11/2014
 * @return: retorna la iformacion ingresada en el JTextField ID
*/
    public String getTxtID(){
        return txtID.getText();
    }//Fin metodo

/**
 * Proposito: asigna la informacion al componente txtID
 * Nombre del metodo: ID
 * @since: 20/11/2014
*/
    public void setTxtID(String ID){
        txtID.setText(ID);
    }//fin del metodo

/**
 * Proposito: asigna la informacion al componente platilloFinal que es un JTextArea ingresandole la informacion proveneinte del metodo verPlatillo
 * Nombre del metodo: setJTextField
 * @since: 20/11/2014
*/
    public void setJTextField(){
        platilloFinal.setText(verPlatilllo());
    }//fin del metodo

/**
 * Proposito: asigna la informacion al JList
 * @param: String con la inforamcion concatenada par ser asignada al componente
 * Nombre del metodo: setTextField
 * @since: 20/11/2014
*/
    public void setTextJTextField(String lista){
        platilloFinal.setText(lista);
    }//fin del metodo

/**
 * Proposito: actualiza el componete al realizar cambios
 * Nombre del metodo: refreshJList
 * @since: 20/11/2014
*/
    public void refreshJList(){
        setJTextField();
        setTxtPrecio(Double.toString(calcularPrecio()));
    }//fin del metodo

/**
 * Proposito: habilitar o inhabilitar los componentes del panel de acuerdo al infice que determinara la activacion de los mismos acorde con el manejador
 * Nombre del metodo: stateOfJButtons
 * @param: int i= indice que manejara la disponibilidad de los componetes
 * @since: 20/11/2014
*/
    public void stateOfJButtons(int i){
        if(i==1){
            btnIncluirPlatillo.setEnabled(true);
            btnModificarPlatillo.setEnabled(false);
            btnEliminarPlatillo.setEnabled(false);
            txtNombre.setEditable(true);
            txtID.setEditable(true);
            platilloFinal.setText("");
        }else{
            btnIncluirPlatillo.setEnabled(false);
            btnModificarPlatillo.setEnabled(true);
            btnEliminarPlatillo.setEnabled(true);
            txtNombre.setEditable(true);
            txtID.setEditable(false);
        }//fin else
    }//fin del metodo

/**
 * Proposito: devuelve el estado del btnEliminar, un true si esta activo o false de lo contrario
 * Nombre del metodo: stateOfSearch
 * @return: false o true de acuerdo si el boton se encuentra habilitado en el panel
 * @since: 20/11/2014
*/
    public boolean stateOfSearch(){
        if(btnEliminarPlatillo.isEnabled()==true){
            return true;
        }//Fin if
        return false;
    }//fin del metodo

/**
 * Proposito: devuelve el valor del item seleccionado en la lista, le aplica un casting para transformalo a String
 * Nombre del metodo: getSelectedValue
 * @return: String con el item seleccionado en la lista
 * @since: 20/11/2014
*/
    public String getSelectedValue(){
        return (String)lista.getSelectedValue();
    }//fin del metodo
    
}//Fin del la clase PanelAdminPlatillos
