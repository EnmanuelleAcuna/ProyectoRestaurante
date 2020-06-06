/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase GUIPrincipal encargada de mostrar la interfaz gráfica del menu principal
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 27/10/2014
 */

package AppRestaurante;
 
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;  

public class GUIPrincipal extends JFrame{
    private RegistroA registroA;
    private JMenuBar barraMenu;
    private JMenu menuSalon, menuAdmin, menuSalir, menuAdminPlatillos;
    private JMenuItem miAgregar, miPagar, miAdminEntradas, miAdminBebidas, 
                      miAdminPostres, miAdminMesas, miAdminOrdenes, miAdminPlatillo, miSalirDelSistema;
    public static final String txI="Agregar orden a la mesa", txII="Pagar mesa", txIII="Administrar Entradas", 
                               txIV="Administrar Platillos", txV="Administrar Bebidas", txVI="Administrar Postres", 
                               txVII="Administrar Mesas", txVIII="Administrar Órdenes", txIX="Administrar Platillo", txX="Salir del Sistema";
    private JLabel labelImagen;
    private ImageIcon imagen;
    private ManejadorMenu manejadorMenu;
      
    public GUIPrincipal(){
        super("RESTAURANTE \"LA MESA DEL REY\"");
        
        //::::::::::::MENU SALON:::::::::::://
        menuSalon = new JMenu("Salón");
            miAgregar = new JMenuItem(txI);
            miAgregar.setBackground(new java.awt.Color(255,255,255));
            miPagar = new JMenuItem(txII);
            miPagar.setBackground(new java.awt.Color(255,255,255));
        menuSalon.add(miAgregar);
        menuSalon.add(miPagar);
          
        //::::::::::::MENU ADMINISTRACION:::::::::::://
        menuAdmin = new JMenu("Administración");
            miAdminEntradas = new JMenuItem(txIII);
            miAdminEntradas.setBackground(new java.awt.Color(255,255,255));
            miAdminBebidas = new JMenuItem(txV);
            miAdminBebidas.setBackground(new java.awt.Color(255,255,255));
            miAdminPostres = new JMenuItem(txVI);
            miAdminPostres.setBackground(new java.awt.Color(255,255,255));
            miAdminMesas = new JMenuItem(txVII);
            miAdminMesas.setBackground(new java.awt.Color(255,255,255));
            miAdminOrdenes = new JMenuItem(txVIII);
            miAdminOrdenes.setBackground(new java.awt.Color(255,255,255));
            miAdminPlatillo = new JMenuItem(txIX);
            miAdminPlatillo.setBackground(new java.awt.Color(255,255,255));
         
        //SubMenu "Platillos"    
        menuAdminPlatillos = new JMenu(txIV);
            menuAdminPlatillos.add(miAdminOrdenes);
            menuAdminPlatillos.add(miAdminPlatillo);
        menuAdminPlatillos.setBackground(new java.awt.Color(255,255,255));
        
        //Agregar Items al Menu "Administracion"
            menuAdmin.add(miAdminEntradas);
            menuAdmin.add(menuAdminPlatillos);
            menuAdmin.add(miAdminBebidas);
            menuAdmin.add(miAdminPostres);
            menuAdmin.add(miAdminMesas);
         
        //::::::::::::MENU SALIR:::::::::::://
        menuSalir = new JMenu("Salir");
            miSalirDelSistema = new JMenuItem(txX);
            miSalirDelSistema.setBackground(new java.awt.Color(255,255,255));
        menuSalir.add(miSalirDelSistema);
        
          
        //Asignacion del los JMenu al JMenuBar
        barraMenu = new JMenuBar();
            barraMenu.add(menuSalon);
            barraMenu.add(menuAdmin);
            barraMenu.add(menuSalir);
        barraMenu.setBackground(new java.awt.Color(255,255,255));
        setJMenuBar(barraMenu);//Se asigna el JMenuBar al la ventana
          
        //Carga la Imagen de Fondo
        imagen = new ImageIcon(getClass().getResource("Images/logoRey.jpg"));
        labelImagen = new JLabel(imagen);
        add(labelImagen);
        
        //Creacion de la Ventana
        setSize(900,700);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//COLOCA LA VENTANA EN EL CENTRO
        setResizable(false);//INABILITA EDITAR EL TAMAÑO DE LA VENTANA
        setIconImage(new ImageIcon(getClass().getResource("Images/restaurant.png")).getImage());//ICONO PARA LA APLICACION
        setVisible(true);
        
        /**************************************/
        registroA = new RegistroA();
        
        //Asignación de eventos a los JMenuItems
        manejadorMenu = new ManejadorMenu(registroA);
            miAgregar.addActionListener(manejadorMenu);
            miPagar.addActionListener(manejadorMenu);
            miAdminEntradas.addActionListener(manejadorMenu);
            miAdminBebidas.addActionListener(manejadorMenu);
            miAdminPostres.addActionListener(manejadorMenu);
            miAdminMesas.addActionListener(manejadorMenu);
            miAdminOrdenes.addActionListener(manejadorMenu);
            miAdminPlatillo.addActionListener(manejadorMenu);
            miSalirDelSistema.addActionListener(manejadorMenu);
      }//Fin del constructor
}//Fin de la clase GUIPrincipal
