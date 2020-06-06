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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class PanelAdminMesas extends JPanel{
    
    private GUIAdminMesas guiAdminMesas;
    private ManejadorAdminMesas manejadorAdminMesas;
    private RegistroA registroA;
    private JPanel pnl1, pnl2, pnl3, pnl4, pnl5, pnlInformacion, pnlImagen, pnlVacio01;
    private JTextField txtNumMesa;
    private JLabel lblNumMesa, lblTitulo, lblImagen, lblEstado, lblVacio01, lblVacio02;
    private JButton btnIncluirMesa, btnBuscar, btnEliminarMesa, btnRefresh, btnSalir;
    public static final String incluir="Incluir Mesa", buscar="Buscar", refresh="Actualizar", eliminar="Eliminar Mesa", salir="Salir";
    private Icon icnIncluir, icnBuscar, icnEliminar, icnRefresh, icnSalir, icnMesa;
    private Icon icnIncluir02, icnBuscar02, icnEliminar02, icnRefresh02, icnSalir02;
    private JRadioButton radioDisponible, radioOcupado;
    private ButtonGroup grupoDisponibilidad;
    
/**
 * Proposito: Metodo constructor por defecto sin parametros para inicializar variables
 * Nomre del metodo: PanelAdminMesas
 * @since: 14/11/2014
 */
    public PanelAdminMesas(GUIAdminMesas guiAdminMesas, RegistroA registroA){//FALTA PARAMETROS DEL REGISTRO
        this.guiAdminMesas = guiAdminMesas;
        this.manejadorAdminMesas = manejadorAdminMesas;
        this.registroA = registroA;
        
            setLayout(new FlowLayout());
					//Paneles
            pnl1 = new JPanel(new GridLayout(1,1));
            pnl2 = new JPanel(new GridLayout(1,1));
            pnl3= new JPanel(new GridLayout(2,2));
            pnl4= new JPanel(new FlowLayout());
            pnl5= new JPanel(new GridLayout(2,2));
			pnlInformacion= new JPanel(new FlowLayout());
			pnlVacio01= new JPanel(new GridLayout(1,1));
					//Grupo de botones
			grupoDisponibilidad= new ButtonGroup();
            
					//Radio Button
			radioDisponible= new JRadioButton("Disponible");
			radioDisponible.setActionCommand("Disponible");
			radioOcupado= new JRadioButton("Ocupada");
			radioOcupado.setActionCommand("Ocupado");
            
            grupoDisponibilidad.add(radioDisponible);
            grupoDisponibilidad.add(radioOcupado);

            
					//JTextField
			txtNumMesa= new JTextField("",15);
					
					//Iconos
            icnIncluir = new ImageIcon("Images/add.png");
            icnBuscar= new ImageIcon("Images/search.png");
            icnEliminar = new ImageIcon("Images/delete.png");
            icnRefresh = new ImageIcon("Images/refresh.png");
            icnSalir = new ImageIcon("Images/exit.png");
            
            icnIncluir02 = new ImageIcon("Images/add02.png");
            icnBuscar02= new ImageIcon("Images/search02.png");
			icnEliminar02 = new ImageIcon("Images/delete02.png");
			icnRefresh02 = new ImageIcon("Images/refresh02.png");
            icnSalir02 = new ImageIcon("Images/exit02.png");
            
            icnMesa= new ImageIcon("Images/adminMesas.jpg");
					
					//Labels
			lblTitulo= new JLabel("Sub Men\u00fa | \"Administrar Mesas\"");
			lblNumMesa= new JLabel("N\u00famero de Mesa:");
			lblImagen= new JLabel(icnMesa);
			lblEstado= new JLabel("Estado:");
			lblVacio01= new JLabel();
			lblVacio02= new JLabel();
		
		    		//Botones
            btnIncluirMesa = new JButton(incluir, icnIncluir);
            btnIncluirMesa.setRolloverIcon(icnIncluir02);
            btnEliminarMesa = new JButton(eliminar, icnEliminar);
            btnEliminarMesa.setRolloverIcon(icnEliminar02);
            btnEliminarMesa.setEnabled(false);
            btnRefresh=new JButton(refresh, icnRefresh);
            btnRefresh.setRolloverIcon(icnRefresh02);
            btnSalir = new JButton(salir,icnSalir);
            btnSalir.setRolloverIcon(icnSalir02);
            btnBuscar= new JButton(buscar,icnBuscar);
            btnBuscar.setRolloverIcon(icnBuscar02);
            
					//Incorporacion de los componentes a los paneles
			pnl1.add(lblTitulo);
			add(pnl1);
			
			pnl2.add(lblImagen);
			add(pnl2);
                     
            pnl3.add(lblNumMesa);
            pnl3.add(lblVacio01);
            pnl3.add(txtNumMesa);
            pnl3.add(btnBuscar);
           
            pnl5.add(lblEstado);
            pnl5.add(radioDisponible);
            pnl5.add(lblVacio02);
            pnl5.add(radioOcupado);
            
            pnlInformacion.add(pnl3);
            pnlInformacion.add(pnlVacio01);
            pnlInformacion.add(pnl5);
            add(pnlInformacion);
            
            pnl4.add(btnIncluirMesa);
            pnl4.add(btnEliminarMesa);
            pnl4.add(btnRefresh);
            pnl4.add(btnSalir);
            add(pnl4);
           
           //Agregar ActionListeners a los Botones
        manejadorAdminMesas = new ManejadorAdminMesas(registroA, guiAdminMesas, this);
        btnIncluirMesa.addActionListener(manejadorAdminMesas);
        btnBuscar.addActionListener(manejadorAdminMesas);
        btnEliminarMesa.addActionListener(manejadorAdminMesas);
        btnRefresh.addActionListener(manejadorAdminMesas);
        btnSalir.addActionListener(manejadorAdminMesas);
		radioDisponible.addActionListener(manejadorAdminMesas);
		radioOcupado.addActionListener(manejadorAdminMesas);
     
     }//Fin del Método Constructor PanelAdminMesas
     
/**
 * Proposito: Cargar el Jlist con las porciones almacenadas previamente
 * Nombre del metodo: setNumMesa
 * @param: string con la informacion del numero de mesa
 * @since: 14/11/2014
*/
	public void setNumMesa(String numMesa){
		txtNumMesa.setText(numMesa);
	}//fin del metodo set

/**
 * Proposito: obtener el numero de mesa ingresado por el usuario
 * Nombre del metodo: getNumMesa
 * @return: retorna la inforamcion ingresada por el usuario en el componente
 * @since: 14/11/2014
*/
	public String getNumMesa(){
		return txtNumMesa.getText().trim();
	}//fin del metodo get

/**
 * Proposito: habilitar o inhabilitar los componentes del panel
 * Nombre del metodo: setEnabled
 * @since: 14/11/2014
*/
	public void setEnabled(int yes){
		if(yes==1){
			btnEliminarMesa.setEnabled(true);
			btnIncluirMesa.setEnabled(false);
			radioDisponible.setEnabled(false);
			radioOcupado.setEnabled(false);
			txtNumMesa.setEditable(false);
		}else{
			grupoDisponibilidad.clearSelection();//Deselecciona el JButtonGroup
			btnEliminarMesa.setEnabled(false);
			btnIncluirMesa.setEnabled(true);
			radioDisponible.setEnabled(true);
			radioOcupado.setEnabled(true);
			txtNumMesa.setEditable(true);
			txtNumMesa.setText("");
		}//Fin else
	}//fin del metodo
    
/**
 * Proposito: limpiar el componente
 * Nombre del metodo: cleanJTextField
 * @since: 14/11/2014
*/
	public void cleanJTextField(){
		txtNumMesa.setText("");
	}//fin del metodo

/**
 * Proposito: obtener el estado de los JRadioButtons, otener si esta seleccionados o el contrario
 * Nombre del metodo: stateOfJRadioButton
 * @return: retorna true si estan activados, false si estan desactivados
 * @since: 14/11/2014
*/
	public boolean stateOfJRadioButton(){
		if(radioDisponible.isSelected()==true || radioOcupado.isSelected()==true){
			return true;
		}//fin if
	return false;
	}

/**
 * Proposito: seleccionar un JRadioButton especifico
 * Nombre del metodo: setSelectedRadioButton
 * @param: int i=indice para asignar acciones
 * @since: 20/11/2014
*/
	public void setSelectedRadioButton(int yes){
		if(yes==1){
			radioDisponible.setSelected(true);
			radioOcupado.setSelected(false);
		}else{
			radioDisponible.setSelected(false);
			radioOcupado.setSelected(true);
		}//fin else
	}//fin metodo
    
}//Fin del la clase PanelAdminMesas
