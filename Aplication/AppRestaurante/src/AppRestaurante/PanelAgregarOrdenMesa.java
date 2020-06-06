/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito:  Clase PanelAgregarOrdenMesa encargada de diseño que contiene todos los componentes de la Interfaz Gráfica de usuario
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1		
 * @since: 28/10/2014
 */

package AppRestaurante;

import javax.swing.JPanel;     
import javax.swing.JComboBox;  
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
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class PanelAgregarOrdenMesa extends JPanel{
    
    private GUIAgregarOrdenMesa guiAgregarOrdenMesa;
    private RegistroA registroA;
    private ManejadorAgregarOrdenMesa manejadorAgregarMesa;
    private JPanel pnlBotones, pnlJList, pnlJTextArea, pnlJComboBox, pnlII, pnlPersonalizar, pnlJListII, pnlJTextAreaII, pnlBotonesII, pnlGeneral, pnlFinalPersonalizar;
    private JButton btnAgregarOtraOrden, btnSalir, btnAddPostre, btnAddBebida, btnAddPlatillo, btnAddEntrada, btnEliminar, btnAgregar, btnPersonalizar;
    private Icon icnPlatillo, icnEntrada, icnBebida, icnPostre;
    public static final String salir="Salir";
    private JList listaPostres, listaEntradas, listaBebidas, listaPlatillos, listaPorciones;
    private JLabel lblPostres, lblEntradas, lblBebidas, lblMesas, lblPlatillos, lblOrdenes, lblPrecio, lblPlatillo, lblOrden, lblMesa, lblVacioI, lblVacioII, lblVacioIII, lblVacioIV, lblVacioV, lblVacioVI, lblVacioVII, lblVacioVIII, lblVacioIX;
    private Icon icnAgregarMesa, icnSalir;
    private String platillos[], entradas[], bebidas[], postres[], mesas[], ordenes[];
    private Platillo platilloSearch;
    private Platillo platilloPersonalizado;
    private Platillo platillo[];
    private Entrada entrada[];
    private Bebida bebida[];
    private Postre postre[];
    private JCheckBox personalizar;
    private JScrollPane barI, barII, barIII, barIV, barJTextArea, barraOrdenes, barraPlatillo;
    private JTextArea txtOrdenMesa, txtPlatillo;
    private JComboBox cbxMesa;
    private JTextField txtPrecio;
    
    public PanelAgregarOrdenMesa(GUIAgregarOrdenMesa guiAgregarOrdenMesa, RegistroA registroA){
        this.guiAgregarOrdenMesa = guiAgregarOrdenMesa;
        this.registroA = registroA;
        
        setLayout(new FlowLayout());
            
            ordenes = new String[registroA.getSizeOfArrayPorciones()];
            platillo = new Platillo[70];
            postre= new Postre[70];
            entrada= new Entrada[70];
            bebida= new Bebida[70];
            
            txtPrecio = new JTextField("",10);

            icnPlatillo = new ImageIcon("Images/platillo.png");
            icnPostre = new ImageIcon("Images/sweet.png");
            icnEntrada = new ImageIcon("Images/hot.png");
            icnBebida = new ImageIcon("Images/drink.png");
            
            txtOrdenMesa = new JTextArea("\n\n--- Seleccione alguna de las opciones ---\n\n");
            txtOrdenMesa.setEditable(false);
            txtPlatillo = new JTextArea("\n\n\n<-------->\n\n\n");
            txtPlatillo.setEditable(false);
            
            lblPostres = new JLabel("                      POSTRES");
            lblEntradas = new JLabel("                      ENTRADAS");
            lblBebidas = new JLabel("                     BEBIDAS");
            lblPlatillos = new JLabel("                      PLATILLOS");
            lblOrden = new JLabel("                            ORDEN FINAL:");
            lblMesa = new JLabel("Seleccione una mesa:");
            lblVacioI = new JLabel("");
            lblVacioII = new JLabel("");
            lblVacioIII = new JLabel("");
            lblVacioIV = new JLabel("");
            lblVacioV = new JLabel("");
            lblVacioVI = new JLabel("");
            lblVacioVII = new JLabel("");
            lblVacioVIII = new JLabel("                        ");
            lblVacioIX = new JLabel("                          ");
            lblPlatillo = new JLabel("Platillo: ");
            lblOrdenes = new JLabel("Ordenes");
            lblPrecio = new JLabel("Precio:");
            
            personalizar = new JCheckBox("Personalizar");
            personalizar.setActionCommand("P");
            
            bebidas = new String[registroA.getSizeOfArrayBebidas()];
            platillos = new String[registroA.getSizeOfArrayPlatillos()];
            entradas = new String[registroA.getSizeOfArrayEntradas()];
            postres = new String[registroA.getSizeOfArrayPostres()];
            mesas = new String[registroA.getSizeOfArrayMesas()];
            
            loadBebidas();
            loadPlatillos();
            loadPostres();
            loadEntradas();
            
            listaBebidas = new JList(bebidas);
            listaBebidas.setVisibleRowCount(3);
            listaBebidas .setPreferredSize(new java.awt.Dimension(100,100)); 
            listaPlatillos = new JList(platillos);
            listaPlatillos .setPreferredSize(new java.awt.Dimension(100,100)); 
            listaPlatillos.setVisibleRowCount(3);
            listaPostres = new JList(postres);
            listaPostres .setPreferredSize(new java.awt.Dimension(100,100)); 
            listaPostres.setVisibleRowCount(3);
            listaEntradas = new JList(entradas);
            listaEntradas.setVisibleRowCount(3);
            listaEntradas .setPreferredSize(new java.awt.Dimension(100,100)); 
            loadJList();// Ejecuta el metodo que cargara el vector;
            listaPorciones = new JList(ordenes);
            listaPorciones.setVisibleRowCount(3);
            
            barraOrdenes = new JScrollPane(listaPorciones); 
            barI = new JScrollPane(listaBebidas);
            barII = new JScrollPane(listaPlatillos);
            barIII = new JScrollPane(listaPostres);
            barIV = new JScrollPane(listaEntradas);
            barJTextArea = new JScrollPane(txtOrdenMesa);
            barraPlatillo = new JScrollPane(txtPlatillo);
          
            icnAgregarMesa = new ImageIcon("Images/business.png");
            icnSalir = new ImageIcon("Images/exit.png");

            btnAgregarOtraOrden = new JButton("Agregar Orden a Mesa", icnAgregarMesa);
            btnSalir = new JButton(salir, icnSalir);
            btnAddBebida = new JButton("Bebidas", icnBebida);
            btnAddPlatillo = new JButton("Platillos", icnPlatillo);
            btnAddEntrada = new JButton("Entradas", icnEntrada);
            btnAddPostre = new JButton("Postres", icnPostre);
            btnAgregar = new JButton("Agregar Orden");
            btnEliminar = new JButton("Eliminar Orden");
            btnPersonalizar = new JButton("Personalizar");
            
            loadMesas();
            cbxMesa = new JComboBox(mesas);
            cbxMesa.setMaximumRowCount(2);
            
            pnlJList = new JPanel(new GridLayout(5,3));
                pnlJList.add(btnAddBebida);
                pnlJList.add(lblVacioI);
                pnlJList.add(btnAddPlatillo);
                
                pnlJList.add(barI);
                pnlJList.add(lblVacioII);
                pnlJList.add(barII);
                
                pnlJList.add(lblVacioIII);
                pnlJList.add(lblVacioIV);
                pnlJList.add(lblVacioV);
                
                pnlJList.add(btnAddPostre);
                pnlJList.add(lblVacioVI);
                pnlJList.add(btnAddEntrada);
                
                pnlJList.add(barIII);
                pnlJList.add(lblVacioVII);
                pnlJList.add(barIV);
                
            pnlBotonesII = new JPanel(new GridLayout(2,1));
                pnlBotonesII.add(btnAgregar);
                pnlBotonesII.add(btnEliminar);
            
            pnlJListII = new JPanel(new GridLayout(2,1));
                pnlJListII.add(lblOrdenes);
                pnlJListII.add(barraOrdenes);
            
            pnlJTextAreaII = new JPanel(new GridLayout(2,1));
                pnlJTextAreaII.add(lblPlatillo);
                pnlJTextAreaII.add(barraPlatillo);
                
            pnlPersonalizar = new JPanel(new FlowLayout());
                pnlPersonalizar.add(personalizar);
                pnlPersonalizar.add(lblVacioIX);
                pnlPersonalizar.add(pnlJListII);
                pnlPersonalizar.add(pnlBotonesII);
                pnlPersonalizar.add(lblVacioVIII);
                pnlPersonalizar.add(pnlJTextAreaII);
                pnlPersonalizar.add(lblPrecio);
                pnlPersonalizar.add(txtPrecio);
                
            pnlFinalPersonalizar = new JPanel(new FlowLayout());
                pnlFinalPersonalizar.add(pnlPersonalizar);
                pnlFinalPersonalizar.add(btnPersonalizar);
                
            pnlGeneral = new JPanel(new FlowLayout());
                pnlGeneral.add(pnlJList);
                pnlGeneral.add(pnlFinalPersonalizar);
            add(pnlGeneral);
            pnlJTextArea = new JPanel(new GridLayout(2,1));
                pnlJTextArea.add(lblOrden);
                pnlJTextArea.add(barJTextArea);
            
            pnlJComboBox = new JPanel(new GridLayout(2,1));
                pnlJComboBox.add(lblMesa);
                pnlJComboBox.add(cbxMesa);
                
            pnlII = new JPanel(new FlowLayout());
                pnlII.add(pnlJTextArea);
                pnlII.add(pnlJComboBox);
            add(pnlII);
            
            pnlBotones = new JPanel(new FlowLayout());
                pnlBotones.add(btnAgregarOtraOrden);
                pnlBotones.add(btnSalir);
            add(pnlBotones);

            manejadorAgregarMesa = new ManejadorAgregarOrdenMesa(this.registroA, this.guiAgregarOrdenMesa, this);
                
                btnAgregarOtraOrden.addActionListener(manejadorAgregarMesa);
                btnSalir.addActionListener(manejadorAgregarMesa);
                btnAddPostre.addActionListener(manejadorAgregarMesa);
                btnAddBebida.addActionListener(manejadorAgregarMesa);
                btnAddEntrada.addActionListener(manejadorAgregarMesa);
                btnAddPlatillo.addActionListener(manejadorAgregarMesa);
                personalizar.addActionListener(manejadorAgregarMesa);
                btnAgregar.addActionListener(manejadorAgregarMesa);
                btnEliminar.addActionListener(manejadorAgregarMesa);
                btnPersonalizar.addActionListener(manejadorAgregarMesa);
            enabledPersonalizar(2);
    }//Fin del Método ConstructorPanelAgregarOrdenMesa

//26//11//2014
    
    public void loadMesas(){
        for(int i=0; i<mesas.length; i++){
            mesas[i]=registroA.cargarMesas(i).getNumMesa();
        }//fin for
    }//fin metodo
    
    public void loadPlatillos(){
        for(int i=0; i<platillos.length; i++){
            platillos[i]=registroA.cargarPlatillos(i).getNombre();
        }//Fin for
    }//Fin metodo
    
    public void loadEntradas(){
        for(int i=0; i<entradas.length; i++){
            entradas[i]=registroA.cargarEntradas(i).getNombre();
        }//Fin for
    }//fin metodo
    
    public void loadBebidas(){
        for(int i=0; i<bebidas.length; i++){
            bebidas[i]=registroA.cargarBebidas(i).getNombre();
        }//Fin for
    }//fin metodo
    
    public void loadPostres(){
        for(int i=0; i<postres.length; i++){
            postres[i]=registroA.cargarPostres(i).getNombre();
        }//Fin for
    }//fin metodo
    
//28//11//2014
    public void agregarPlatillo(){
        for(int i=0; i<platillo.length; i++){
            if(platillo[i]==null){
                platillo[i] = registroA.getPlatillo((String)listaPlatillos.getSelectedValue());
                setJTextArea();
                break;
            }//fin if
        }//fin for
    }//Fin metodo
    
    public Platillo [] platillosSeleccionados(){
        return platillo; 
    }//Fin metodo
    
    public void agregarPostre(){
        for(int i=0; i<postre.length; i++){
            if(postre[i]==null){
                postre[i] = registroA.getPostre((String)listaPostres.getSelectedValue());
                setJTextArea();
                break;
            }//fin if
        }//Fin for
    }//fin metodo
    
    public Postre [] postresSeleccionados(){
        return postre; 
    }//fin metodo
    
    public void agregarBebida(){
        for(int i=0; i<bebida.length; i++){
            if(bebida[i]==null){
                bebida[i] = registroA.getBebida((String)listaBebidas.getSelectedValue());
                setJTextArea();
                break;
            }//Fin if
        }//Fin for
    }//fin metodo
    
    public Bebida [] bebidasSeleccionadas(){
        return bebida; 
    }//Fin metodo
    
    public void agregarEntrada(){
        for(int i=0; i<entrada.length; i++){
            if(entrada[i]==null){
                entrada[i] = registroA.getEntrada((String)listaEntradas.getSelectedValue());
                setJTextArea();
                break;
            }//fin if
        }//fin for
    }//fin metodo
    
    public Entrada [] entradasSeleccionadas(){
        return entrada; 
    }//fin metodo
    
    public String verOrden(){
        String lista="";
        for(int i=0; i<platillo.length; i++){
            if(platillo[i]!=null)
                lista+=" + "+platillo[i].getNombre()+"\n";
        }//fin for
        
        for(int i=0; i<bebida.length; i++){
            if(bebida[i]!=null)
                lista+=" + "+bebida[i].getNombre()+"\n";
        }//fin for
        
        for(int i=0; i<postre.length; i++){
            if(postre[i]!=null)
                lista+=" + "+postre[i].getNombre()+"\n";
        }//fin for
        
        for(int i=0; i<entrada.length; i++){
            if(entrada[i]!=null)
                lista+=" + "+entrada[i].getNombre()+"\n";
        }//fin for
    return lista;
    }//fin del metodo
    
    public void setJTextArea(){
        txtOrdenMesa.setText(verOrden());
    }//fin metodo
    
    public String getSelectedItem(){
        return (String)cbxMesa.getSelectedItem();
    }//fin metodo
    
     public void loadJList(){
        for(int i=0; i<ordenes.length; i++){
            ordenes[i]=registroA.cargarJList(i).getNombre();
        }//fin for
    }//fin metodo
    
    public void actionPersonalizar(){
        if(personalizar.isSelected()==true){
            platilloPersonalizado=registroA.getPlatillo((String)listaPlatillos.getSelectedValue());
            txtPlatillo.setText(platilloPersonalizado.getPlatillo());
            txtPrecio.setText(Double.toString(platilloPersonalizado.getPrecio()));
        }//fin if
    }//fin metodo
    
    public String getSelectedValueJListPlatillos(){
        return (String)listaPlatillos.getSelectedValue();
    }//Fin metodo
    
    public void setTxtPrecio(String precio){
       txtPrecio.setText(precio);
    }//Fin metodo
    
    public String getSelectedValueOfPorciones(){
        return (String)listaPorciones.getSelectedValue();
    }//fin metodo
    
    public void setTextJTextField(String lista){
        txtPlatillo.setText(lista);
    }//fin metodo
    
    public void enabledPersonalizar(int i){
        if(i==1){
            listaBebidas.setEnabled(false);
            listaPlatillos.setEnabled(false);
            listaEntradas.setEnabled(false);
            listaPostres.setEnabled(false);
            btnAddBebida.setEnabled(false);
            btnAddEntrada.setEnabled(false);
            btnAddPlatillo.setEnabled(false);
            btnAddPostre.setEnabled(false);
            btnAgregar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnAgregarOtraOrden.setEnabled(false);
            listaPorciones.setEnabled(true);
            txtPrecio.setEnabled(true);
            txtPlatillo.setEnabled(true);
            btnPersonalizar.setEnabled(true);
            
        }else{
            listaBebidas.setEnabled(true);
            listaPlatillos.setEnabled(true);
            listaEntradas.setEnabled(true);
            listaPostres.setEnabled(true);
            btnAddBebida.setEnabled(true);
            btnAddEntrada.setEnabled(true);
            btnAddPlatillo.setEnabled(true);
            btnAddPostre.setEnabled(true);
            btnAgregarOtraOrden.setEnabled(true);
            btnAgregar.setEnabled(false);
            btnEliminar.setEnabled(false);
            listaPorciones.setEnabled(false);
            txtPrecio.setEnabled(false);
            txtPlatillo.setEnabled(false);
            personalizar.setSelected(false);
            btnPersonalizar.setEnabled(false);
            }//Fin else
    }//Fin metodo
    
    public void agregarPlatilloPersonalizado(){
        for(int i=0; i<platillo.length; i++){
            if(platillo[i]==null){
                platillo[i] = registroA.consultarPlatilloTemp(getSelectedValueJListPlatillos());
                setJTextArea();
                break;
            }//fin if
        }//fin for
    }//fin metodo
    
}//Fin del la clase PanelAgregarOrdenMesa
