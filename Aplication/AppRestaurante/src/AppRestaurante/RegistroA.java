/**
 * Universidad de Costa Rica
 * Programación I, II CICLO 2014
 * Proyecto Final
 * Proposito: Clase RegistroA encargada de agregar la informacion a los array
 * @author: Bryan Marín Quesada (B23907)
            Kevin Bermúdez Alvarado (B30957)
            Aharon Darcia Ramírez (B22170)
 * @version: v.1  
 * @since: 06/11/2014
 */

package AppRestaurante;

import java.util.ArrayList;

public class RegistroA{
    
    private ArrayList <Entrada> arrayEntrada;
    private ArrayList <Bebida> arrayBebida;
    private ArrayList <Postre> arrayPostre;
    private ArrayList <Mesa> arrayMesa;
    private ArrayList <Porcion> arrayPorcion;
    private ArrayList <Platillo> arrayPlatillo;
    private ArrayList <Platillo> temp;
    private ArrayList <Orden> arrayOrden;

/**
 * Proposito: Metodo constructor por defecto sin parametros encargado de inicualizar los arrayList
 * Nomre del metodo: RegistroA
 * @since: 6/11/2014
 */
    public RegistroA(){
        arrayEntrada = new ArrayList <Entrada>();
        arrayBebida = new ArrayList <Bebida>();
        arrayPostre = new ArrayList <Postre>();
        arrayMesa = new ArrayList <Mesa>();
        arrayPorcion = new ArrayList <Porcion>();
        arrayPlatillo = new ArrayList <Platillo>();
        arrayOrden = new ArrayList <Orden>();
        temp = new ArrayList <Platillo>();
    }//Fin del metodo constructor RegistroA
 
/**
 * Proposito: agregar un objeto de tipo Entrada al arrayEntrada
 * Nombre del metodo: agregarEntrada
 * @since: 6/11/2014
 * @param: Entrada entrada: Objeto de tipo Entrada
*/
    public void agregarEntrada(Entrada entrada){
        arrayEntrada.add(entrada);
    }//Fin del metod agregarEntrada
    
/**
 * Proposito: devolver un objeto de tipo Entrada al buscarlo por medio del parametro identificacion en el arrayList
 * Nombre del metodo: buscarEntradaPorID
 * @since: 8/11/2014
 * @param: String id: variable String con la informacion de la identificacion a buscar
 * @return: arrayEntrada.get(e)= Objeto de tipo entrada en la posicion especifica
 * @return: null= si no encuentra el objeto devuelve un null
*/
    public Entrada buscarEntradaPorID(String id){
        int e=-1;
            for(int i=0; i<arrayEntrada.size(); i++){
                if(arrayEntrada.get(i).getIdentificacion().equalsIgnoreCase(id))
                    e=i;
            }//fin for
            if(e<0)
                return
                    null;
            else
                return
                    arrayEntrada.get(e);
    }//Fin del Método buscarEntradaPorID
    
/**
 * Proposito: eliminar un objeto de tipo entrada en el arrayList
 * Nombre del metodo: eliminarEntrada
 * @since: 8/11/2014
 * @param: String id: variable String con la informacion de la identificacion a buscar
*/
    public void eliminarEntrada(String id){
        Entrada entradaNull = null;
            for(int i=0; i<arrayEntrada.size(); i++){
                if(arrayEntrada.get(i).getIdentificacion().equalsIgnoreCase(id)){
                    entradaNull = arrayEntrada.get(i);
                    arrayEntrada.remove(entradaNull);
                }//fin if
            }//fin for
    }//fin del metodo eliminarEntrada
        
/**
 * Proposito: agregar un objeto de tipo Bebida al arrayBebida
 * Nombre del metodo: agregarBebida
 * @since: 6/11/2014
 * @param: Bebida bebida: Objeto de tipo Bebida
*/
    public void agregarBebida(Bebida bebida){
        arrayBebida.add(bebida);
    }//fin del metodo agregar bebida
    
/**
 * Proposito: devolver un objeto de tipo Bebida al buscarlo por medio del parametro identificacion en el arrayList
 * Nombre del metodo: buscarBebidaPorID
 * @since: 8/11/2014
 * @param: String id: variable String con la informacion de la identificacion a buscar
 * @return: arrayBebida.get(e)= Objeto de tipo bebida en la posicion especifica
 * @return: null= si no encuentra el objeto devuelve un null
*/
    public Bebida buscarBebidaPorID(String id){
        int e=-1;
            for(int i=0; i<arrayBebida.size(); i++){
                if(arrayBebida.get(i).getIdentificacion().equalsIgnoreCase(id)){
                    e=i;
                }//Fin if  
            }//fin del for
            
            if(e<0)
                return 
                    null;
            else
                return
                    arrayBebida.get(e);
    }//fin buscar Bebida por id
 
/**
 * Proposito: eliminar un objeto de tipo bebida en el arrayList
 * Nombre del metodo: eliminarBebida
 * @since: 8/11/2014
 * @param: String id: variable String con la informacion de la identificacion a buscar
*/
    public void eliminarBebida(String id){
        Bebida bebidaNull = null;
            for(int i=0; i<arrayBebida.size(); i++){
                if(arrayBebida.get(i).getIdentificacion().equalsIgnoreCase(id)){
                    bebidaNull = arrayBebida.get(i);
                    arrayBebida.remove(bebidaNull);
                }//fin if
            }//fin for
    }//fin del metodo eliminar bebida
 
 /**
 * Proposito: eliminar un objeto de tipo postre en el arrayList
 * Nombre del metodo: eliminarPostre
 * @since: 8/11/2014
 * @param: String id: variable String con la informacion de la identificacion a buscar
*/
    public void eliminarPostre(String id){
        Postre postreNull = null;
            for(int i=0; i<arrayPostre.size(); i++){
                if(arrayPostre.get(i).getIdentificacion().equalsIgnoreCase(id)){
                    postreNull = arrayPostre.get(i);
                    arrayPostre.remove(postreNull);
                }//fin if
            }//fin for
    }//fin del metodo eliminarPostre
            
/**
 * Proposito: devolver un objeto de tipo Postre al buscarlo por medio del parametro identificacion en el arrayList
 * Nombre del metodo: buscarPostrePorID
 * @since: 8/11/2014
 * @param: String id: variable String con la informacion de la identificacion a buscar
 * @return: arrayPostre.get(e)= Objeto de tipo postre en la posicion especifica
 * @return: null= si no encuentra el objeto devuelve un null
*/
    public Postre buscarPostrePorID(String id){
        int e=-1;
            for(int i=0; i<arrayPostre.size(); i++){
                if(arrayPostre.get(i).getIdentificacion().equalsIgnoreCase(id))
                    e=i;
            }//fin for
            
            if(e<0)
                return  
                    null;
            else
                return 
                    arrayPostre.get(e);
    }//fin del metodo buscarPostrePorId
    
/**
 * Proposito: agregar un objeto de tipo Postre al arrayPostre
 * Nombre del metodo: agregarPostre
 * @since: 6/11/2014
 * @param: Postre postre: Objeto de tipo Postre
*/
    public void agregarPostre(Postre postre){
        arrayPostre.add(postre);
    }//fin del metodo agregarPostre

/**
 * Proposito: agregar un objeto de tipo Mesa al arrayMesa
 * Nombre del metodo: agregarMesa
 * @since: 6/11/2014
 * @param: Mesa mesa: Objeto de tipo Mesa
*/
    public void agregarMesa(Mesa mesa){
        arrayMesa.add(mesa);
    }//fin del metodo agregarMesa

/**
 * Proposito: eliminar un objeto de tipo mesa en el arrayList
 * Nombre del metodo: eliminarMesa
 * @since: 8/11/2014
 * @param: String id: variable String con la informacion de la identificacion a buscar
*/
    public void eliminarMesa(String numMesa){
        Mesa mesaNull = null;
            for(int i=0; i<arrayMesa.size(); i++){
                if(arrayMesa.get(i).getNumMesa().equalsIgnoreCase(numMesa)){
                    mesaNull = arrayMesa.get(i);
                    arrayMesa.remove(mesaNull);
                }//fin if
            }//fin for
    }//fin del metodo eliminar bebida

/**
 * Proposito: devolver un objeto de tipo Mesa al buscarlo por medio del parametro identificacion en el arrayList
 * Nombre del metodo: buscarMesaPorNum
 * @since: 8/11/2014
 * @param: String numMesa: variable String con la informacion de la identificacion a buscar
 * @return: arrayMesa.get(e)= Objeto de tipo mesa en la posicion especifica
 * @return: null= si no encuentra el objeto devuelve un null
*/
    public Mesa buscarMesaPorNum(String numMesa){
        int e=-1;
            for(int i=0; i<arrayMesa.size(); i++){
                if(arrayMesa.get(i).getNumMesa().equalsIgnoreCase(numMesa))
                    e=i;
            }//fin for
            
            if(e<0)
                return
                    null;
            else
                return
                    arrayMesa.get(e);
    }//fin del metodo buscarMesaPorNum
    
/**
 * Proposito: verificar un objeto de tipo mesa al buscarlo por medio del parametro identificacion en el arrayList
 * Nombre del metodo: verifMesa
 * @since: 8/11/2014
 * @param: String numMesa: variable String con la informacion de la identificacion a buscar
 * @return: arrayMesa.get(e)= Objeto de tipo mesa en la posicion especifica
 * @return: null= si no encuentra el objeto devuelve un null
*/
    public Boolean verifMesa(String numMesa){
        for(int i=0; i<arrayMesa.size(); i++){
            if(arrayMesa.get(i).getNumMesa().equalsIgnoreCase(numMesa))
                return
                    true;
        }//fin for
    return
        false;
    }//fin del metodo verifMesa

/**
 * Proposito: agregar un objeto de tipo Porcion al arrayPorcion
 * Nombre del metodo: addPorcion
 * @since: 6/11/2014
 * @param: Porcion porcion: Objeto de tipo Porcion
*/
    public void addPorcion(Porcion porcion){
        arrayPorcion.add(porcion);
    }//fin del metodo addPorcion

/**
 * Proposito: verificar un objeto de tipo porcion al buscarlo por medio del parametro identificacion en el arrayList
 * Nombre del metodo: verifPorcion
 * @since: 8/11/2014
 * @param: String id: variable String con la informacion de la identificacion a buscar
 * @return: arrayMesa.get(e)= Objeto de tipo porcion en la posicion especifica
 * @return: null= si no encuentra el objeto devuelve un null
*/
    public Boolean verifPorcion(String id){
        for(int i=0; i<arrayPorcion.size(); i++){
            if(arrayPorcion.get(i).getIdentificacion().equalsIgnoreCase(id))
                return 
                    true;
        }//fin for
    return
        false;
    }//fin del metodo verifPorcion
    
/**
 * Proposito: Busca un objeto de tipo porcion al buscarlo por medio del parametro identificacion en el arrayList
 * Nombre del metodo: verifPorcion
 * @since: 8/11/2014
 * @param: String id: variable String con la informacion de la identificacion a buscar
 * @return: arrayMesa.get(e)= Objeto de tipo porcion en la posicion especifica
 * @return: null= si no encuentra el objeto devuelve un null
*/
    public Porcion buscarPorcionPorID(String id){
        int a=-1;
            for(int i=0; i<arrayPorcion.size(); i++){
                if(arrayPorcion.get(i).getIdentificacion().equalsIgnoreCase(id))
                    a=i;
            }//fin for
                
            if(a<0)
                return
                    null;
            else
                return
                    arrayPorcion.get(a);
    }//fin del metodo buscarPostrePorId
    
/**
 * Proposito: eliminar un objeto de tipo porcion en el arrayList
 * Nombre del metodo: eliminarPorcion
 * @since: 8/11/2014
 * @param: String id: variable String con la informacion de la identificacion a buscar
*/
    public void eliminarPorcion(String id){
        Porcion porcionNull = null;
            for(int i=0; i<arrayPorcion.size(); i++){
                if(arrayPorcion.get(i).getIdentificacion().equalsIgnoreCase(id)){
                    porcionNull = arrayPorcion.get(i);
                    arrayPorcion.remove(porcionNull);
                }//fin if
            }//fin for
    }//fin del metodo eliminar porcion

/**
 * Proposito: modificar un objeto de tipo porcion en el arrayList
 * Nombre del metodo: modificarPorcion
 * @since: 8/11/2014
 * @param: String id, nombre: variables String con la informacion de la identificacion y nombre a modificar
 * @param: double precio: variables double con la informacion del precio a modificar
*/
    public void modificarPorcion(String id, String nombre, double precio){
        for(int i=0; i<arrayPorcion.size(); i++){
            if(arrayPorcion.get(i).getIdentificacion().equalsIgnoreCase(id)){
                arrayPorcion.get(i).setNombre(nombre);
                arrayPorcion.get(i).setPrecio(precio);
            }//Fin if
        }//Fin for
    }//Fin metodo modificarPorcion

/**
 * Proposito: obtiene un objeto de tipo porcion al buscarlo por medio del parametro nombre en el arrayList
 * Nombre del metodo: getPorcion
 * @since: 8/11/2014
 * @param: String nombre: variable String con la informacion del nombre
 * @return: arrayPorcion.get(e)= Objeto de tipo porcion en la posicion especifica
*/
    public Porcion getPorcion(String nombre){
        Porcion porcion=null;
            for(int i=0; i<arrayPorcion.size(); i++){
                if(arrayPorcion.get(i).getNombre().equalsIgnoreCase(nombre)){
                    porcion=arrayPorcion.get(i);
                }//fin if
            }//fin for
        return 
            porcion;
    }//Fin del metodo getPorcion

/**
 * Proposito: devuelve un Objeto de tipo Porcion deacuerdo al indice
 * Nombre del metodo: cargarJList
 * @since: 6/11/2014
 * @param: int i: variable int con el indice a buscar
 * @return: arrayPorcion.get(i)= objeto de tipo Porcion
*/
    public Porcion cargarJList(int i){
        return
            arrayPorcion.get(i);
    }//Fin del metodo cargarJList
    
/**
 * Proposito: verificar el estado del arrayPorciones
 * Nombre del metodo: stateOfArrayPorciones
 * @since: 6/11/2014
 * @return: true or false= si en el array Porciones existe algun objeto duevuelve un true de lo contrario devuelve un false
*/
    public Boolean stateOfArrayPorciones(){
        boolean state=false;
            for(int i=0; i<arrayPorcion.size(); i++){
                if(arrayPorcion.get(i)!=null)
                    state = true;
            }//Fin for
        return 
            state;
    }//fin del metodo stateOfArrayPorciones
    
    public int getSizeOfArrayPorciones(){
        return
            arrayPorcion.size();
    }//Fin del metodo getSizeOfArrayPorciones
    
 /**
 * Proposito: agregar un objeto de tipo Platillo al arrayPlatillo
 * Nombre del metodo: agregarPlatillo
 * @since: 6/11/2014
 * @param: Platillo platillo: Objeto de tipo Platillo
 */
    public void agregarPlatillo(Platillo platillo){
        arrayPlatillo.add(platillo);
    }//Fin del metodo agregarPlatillo
    
    
 /**
 * Proposito: verificar un objeto de tipo Platillo al arrayPlatillo
 * Nombre del metodo: verifPlatillo
 * @since: 6/11/2014
 * @param: Platillo platillo: Objeto de tipo Platillo
 */
    public Boolean verifPlatillo(String id){
        for(int i=0; i<arrayPlatillo.size(); i++){
            if(arrayPlatillo.get(i).getIdentificacion().equalsIgnoreCase(id))
                return
                    true;
        }//Fin for
    return
        false;
    }//Fin del metodo verifPlatillo
    
    
 /**
 * Proposito: Elimina un objeto de tipo Platillo del arrayPlatillo
 * Nombre del metodo: eliminarPlatillo
 * @since: 6/11/2014
 * @param: Platillo platillo: Objeto de tipo Platillo
 */
    public void eliminarPlatillo(String id){
        Platillo platilloNull = null;
            for(int i=0; i<arrayPlatillo.size(); i++){
                if(arrayPlatillo.get(i).getIdentificacion().equalsIgnoreCase(id)){
                    platilloNull = arrayPlatillo.get(i);
                    arrayPlatillo.remove(platilloNull);
                }//fin if
            }//fin for
    }//fin del metodo eliminar platillo
    
    
 /**
 * Proposito: agregar un objeto de tipo Platillo al arrayPlatillo
 * Nombre del metodo: agregarPlatillo
 * @since: 6/11/2014
 * @param: Platillo platillo: Objeto de tipo Platillo
 */
    public Platillo consultarPlatillo(String id){
        for(int i=0; i<arrayPlatillo.size(); i++){
            if(arrayPlatillo.get(i).getIdentificacion().equalsIgnoreCase(id))
                return 
                    arrayPlatillo.get(i);
        }//fin for
    return  
        null;
    }//fin del metodo consultarPlatillo
   
/**
 * Proposito: modificar un objeto de tipo platillo en el arrayList
 * Nombre del metodo: modificarPorcionesPlatillo
 * @since: 8/11/2014
 * @param: String id, nombre: variables String con la informacion de la identificacion y nombre a modificar
*/
    public void modificarPorcionesPlatillo(String id, String nombrePorcion){
        for(int i=0; i<arrayPlatillo.size(); i++){
            if(arrayPlatillo.get(i).getIdentificacion().equalsIgnoreCase(id)){
                arrayPlatillo.get(i).eliminar(nombrePorcion);
            }//fin if
        }//fin for
    }//fin del metodo modificarPorcionesPlatillo

/**
 * Proposito: modificar las porciones de un paltillo
 * Nombre del metodo: modificarPorcionesPlatilloII
 * @since: 8/11/2014
 * @param: String id, nombre: variables String con la informacion de la identificacion y nombre a modificar
*/
    public void modificarPorcionesPlatilloII(String id, String nombrePorcion){
        for(int i=0; i<arrayPlatillo.size(); i++){
            if(arrayPlatillo.get(i).getIdentificacion().equalsIgnoreCase(id)){
                arrayPlatillo.get(i).agregarPorcion(getPorcion(nombrePorcion));
            }//fin if
        }//fin for
    }//fin del metodo modificarPorcionesPlatilloII

/**
 * Proposito: modificar el nombre de platillo
 * Nombre del metodo: modificarNombrePlatillo
 * @since: 8/11/2014
 * @param: String id, nombre: variables String con la informacion de la identificacion y nombre a modificar
*/
    public void modificarNombrePlatillo(String id, String nombrePlatillo){
        for(int i=0; i<arrayPlatillo.size(); i++){
            if(arrayPlatillo.get(i).getIdentificacion().equalsIgnoreCase(id)){
                arrayPlatillo.get(i).setNombre(nombrePlatillo);
            }//fin if
        }//fin for
    }//fin del metodo modificarNombrePlatillo
    
/**
 * Proposito: devuelve un Objeto de tipo Postre
 * Nombre del metodo: cargarPostres
 * @since: 26/11/2014
 * @param: int i= indice del postre a consultar
*/
    public Postre cargarPostres(int i){
        return
            arrayPostre.get(i);
    }//fin del metodo cargarPostres

/**
 * Proposito: devuelve un Objeto de tipo Platillo
 * Nombre del metodo: cargarPlatillos
 * @since: 26/11/2014
 * @param: int i= indice a modificar
*/
    public Platillo cargarPlatillos(int i){
        return
            arrayPlatillo.get(i);
    }//fin del metodo cargarPlatillos

/**
 * Proposito: devuelve un Objeto de tipo Entrada
 * Nombre del metodo: cargarEntradas
 * @since: 26/11/2014
 * @param: int i= indice a modificar
*/
    public Entrada cargarEntradas(int i){
        return
            arrayEntrada.get(i);
    }//fin del metodo cargarEntradas

/**
 * Proposito: devuelve un Objeto de tipo Bebida
 * Nombre del metodo: cargarBebidas
 * @since: 26/11/2014
 * @param: int i= indice a modificar
*/
    public Bebida cargarBebidas(int i){
        return
            arrayBebida.get(i);
    }//fin del metodo cargarBebidas

/**
 * Proposito: devuelve un Objeto de tipo Mesa
 * Nombre del metodo: cargarMesas
 * @since: 26/11/2014
 * @param: int i= indice a modificar
*/
    public Mesa cargarMesas(int i){
        return 
            arrayMesa.get(i);
    }//fin del metodo cargarMesas

/**
 * Proposito: devuelve el tamanno del arrayPlatillos
 * Nombre del metodo: getSizeOfArrayPlatillos
 * @since: 26/11/2014
 * @return: tamanno del array
*/
     public int getSizeOfArrayPlatillos(){
        return
            arrayPlatillo.size();
    }//fin del metodo getSizeOfArrayPlatillos

/**
 * Proposito: devuelve el tamanno del arrayPostres
 * Nombre del metodo: getSizeOfArrayPostres
 * @since: 26/11/2014
 * @return: tamanno del array
*/
    public int getSizeOfArrayPostres(){
        return
            arrayPostre.size();
    }//fin del metodo getSizeOfArrayPostres

/**
 * Proposito: devuelve el tamanno del arrayEntradas
 * Nombre del metodo: getSizeOfArrayEntradas
 * @since: 26/11/2014
 * @return: tamanno del array
*/
    public int getSizeOfArrayEntradas(){
        return
            arrayEntrada.size();
    }//fin del metodo getSizeOfArrayEntradas

/**
 * Proposito: devuelve el tamanno del arrayMesas
 * Nombre del metodo: getSizeOfArrayMesas
 * @since: 26/11/2014
 * @return: tamanno del array
*/
    public int getSizeOfArrayMesas(){
        return
            arrayMesa.size();
    }//fin del metodo getSizeOfArrayMesas

/**
 * Proposito: devuelve el tamanno del arrayBebidas
 * Nombre del metodo: getSizeOfArrayBebidas
 * @since: 26/11/2014
 * @return: tamanno del array
*/
    public int getSizeOfArrayBebidas(){
        return
            arrayBebida.size();
    }//fin del metodo getSizeOfArrayBebidas

/**
 * Proposito: obtiene un objeto de tipo Postre al buscarlo por medio del parametro nombre en el arrayList
 * Nombre del metodo: getPostre
 * @since: 8/11/2014
 * @param: String nombre: variable String con la informacion del nombre
 * @return: arrayPostre.get(e)= Objeto de tipo postre en la posicion especifica
*/
    public Postre getPostre(String nombre){
        Postre postre=null;
            for(int i=0; i<arrayPostre.size(); i++){
                if(arrayPostre.get(i).getNombre().equalsIgnoreCase(nombre)){
                    postre=arrayPostre.get(i);
                }//Fin if
            }//Fin for
        return
            postre;
    }//fin del metodo getPostre
    
    /**
 * Proposito: obtiene un objeto de tipo Bebida al buscarlo por medio del parametro nombre en el arrayList
 * Nombre del metodo: getBebida
 * @since: 8/11/2014
 * @param: String nombre: variable String con la informacion del nombre
 * @return: arrayBebida.get(e)= Objeto de tipo bebida en la posicion especifica
*/
    public Bebida getBebida(String nombre){
        Bebida bebida=null;
            for(int i=0; i<arrayBebida.size(); i++){
                if(arrayBebida.get(i).getNombre().equalsIgnoreCase(nombre)){
                    bebida=arrayBebida.get(i);
                }//fin if
            }//fin for
        return
            bebida;
    }//fin del metodo getBebida
    
    /**
 * Proposito: obtiene un objeto de tipo Entrada al buscarlo por medio del parametro nombre en el arrayList
 * Nombre del metodo: getEntrada
 * @since: 8/11/2014
 * @param: String nombre: variable String con la informacion del nombre
 * @return: arrayEntrada.get(e)= Objeto de tipo entrada en la posicion especifica
*/
    public Entrada getEntrada(String nombre){
        Entrada entrada=null;
            for(int i=0; i<arrayEntrada.size(); i++){
                if(arrayEntrada.get(i).getNombre().equalsIgnoreCase(nombre)){
                    entrada=arrayEntrada.get(i);
                }//fin if
            }//fin for
        return
            entrada;
    }//fin del metodo getEntrada
    
/**
 * Proposito: obtiene un objeto de tipo Platillo al buscarlo por medio del parametro nombre en el arrayList
 * Nombre del metodo: getPlatillo
 * @since: 8/11/2014
 * @param: String nombre: variable String con la informacion del nombre
 * @return: arrayPlatillo.get(e)= Objeto de tipo platillo en la posicion especifica
*/
    public Platillo getPlatillo(String nombre){
        Platillo platillo=null;
            for(int i=0; i<arrayPlatillo.size(); i++){
                if(arrayPlatillo.get(i).getNombre().equalsIgnoreCase(nombre)){
                    platillo=arrayPlatillo.get(i);
                }//fin if
            }//fin for
        return
            platillo;
    }//fin del metodo getPlatillo
    
/**
 * Proposito: agrega un objeto de tipo Orden en el arrayList
 * Nombre del metodo: agregarOrden
 * @since: 8/11/2014
*/
    public void agregarOrden(Orden orden){
        arrayOrden.add(orden);
    }//fin del metodo agregarOrden

/**
 * Proposito: se obtiene el estado del todos los arrayList
 * Nombre del metodo: stateOfArrays
 * @since: 8/11/2014
 * @param: int i= indice a consultar
 * @return: true o false= si hay elementos en en array consultado duevuelve un true de lo contrario false
*/
    public Boolean stateOfArrays(int i){
        boolean state=false;
            switch(i){
                case 1:
                    for(int a=0; a<arrayPlatillo.size(); a++){
                        if(arrayPlatillo.get(a)!=null)
                            state = true;
                    }//fin for
                break;
                
                case 2:
                    for(int b=0; b<arrayPostre.size(); b++){
                        if(arrayPostre.get(b)!=null)
                            state = true;
                    }//fin for
                break;
                
                case 3:
                    for(int c=0; c<arrayBebida.size(); c++){
                        if(arrayBebida.get(c)!=null)
                            state = true;
                    }//fin for
                break;
                    
                case 4:
                    for(int d=0; d<arrayEntrada.size(); d++){
                        if(arrayEntrada.get(d)!=null)
                            state = true;
                    }//fin for
                break;
                
                case 5:
                    for(int e=0; e<arrayMesa.size(); e++){
                        if(arrayMesa.get(e)!=null)
                            state = true;
                    }//fin for
                break;
            }//fin switch
        return
            state;
    }//fin del metodo stateOfArrays

/**
 * Proposito:Muestra el monto a pagar en el arrayList
 * Nombre del metodo: pagarMesa
 * @since: 8/11/2014
 * @param: String numMesa: variable String con la informacion del numero de mesa a consultar el total a pagar
*/    
    public double pagarMesa(String numMesa){
        double total= 0.0;
            for(int i=0; i<arrayOrden.size(); i++){
                if(arrayOrden.get(i).getNumMesa().equalsIgnoreCase(numMesa)){
                    total+=arrayOrden.get(i).getPrecio();
                }//fin if
            }//fin for 
        return
            total;
    }//fin del metodo pagarMesa

/**
 * Proposito: muestra una cadena String con los datos de la mesa
 * Nombre del metodo: infoMesaPagar
 * @since: 8/11/2014
 * @param: String numMesa: variable String con la informacion del numero de mesa a consultar
 * @return: info= contiene la concatenacion de variables string con la iformacion final de la mesa
*/  
    public String infoMesaPagar(String numMesa){
        String entradas=">> ENTRADAS:\n";
        String platillos=">> PLATILLOS:\n";
        String bebidas=">> BEBIDAS:\n";
        String postres=">> POSTRES:\n";
        String info="";
            for(int i=0; i<arrayOrden.size(); i++){
                if(arrayOrden.get(i).getNumMesa().equalsIgnoreCase(numMesa)){
                    entradas+= arrayOrden.get(i).getEntradas();
                    platillos+= arrayOrden.get(i).getPlatillos();
                    bebidas+= arrayOrden.get(i).getBebidas();
                    postres+= arrayOrden.get(i).getPostres();
                }//fin if
            }//Fin for
        info=entradas+"\n"+platillos+"\n"+bebidas+"\n"+postres;
        return info;
    }//Fin del metodo infoMesaPagar

/**
 * Proposito: agregar un clon del Objeto Platillo al array temporal
 * Nombre del metodo: agregarPlatilloTemp
 * @since: 1/12/2014
 * @param: String nombre= nombre de la mesa a buscar
*/  
    public void agregarPlatilloTemp(String nombre){
        Platillo platilloPersonalizadoTemp=null;
            platilloPersonalizadoTemp=(Platillo)getPlatillo(nombre).clone();//Clona el objeto para tener dos objetos distintos y poder modificar sus atributos sin perjudicar a objeto original
            temp.add(platilloPersonalizadoTemp);
    }//fin del metodo agregarPlatilloTemp

/**
 * Proposito: agregar porciones al platillo temporal
 * Nombre del metodo: agregarPorcionesPlatilloTemp
 * @since: 1/12/2014
 * @param: String nombre, String nombrePorcion = nombre del platillo a buscar y de la porcion que se agregara
*/  
    public void agregarPorcionesPlatilloTemp(String nombre, String nombrePorcion){
        for(int i=0; i<temp.size(); i++){
            if(temp.get(i).getNombre().equalsIgnoreCase(nombre)){
                temp.get(i).agregarPorcion(getPorcion(nombrePorcion));
            }//fin if
        }//fin for
    }//fin del metodo agregarPorcionesPlatilloTemp


/**
 * Proposito: eliminar porciones del platillo temporal clonado
 * Nombre del metodo: eliminarPorcionesPlatilloTemp
 * @since: 1/12/2014
 * @param: String nombre, String nombrePorcion = nombre de la mesa a buscar y de la porcion que se eliminara
*/
    public void eliminarPorcionesPlatilloTemp(String nombre, String nombrePorcion){
        for(int i=0; i<temp.size(); i++){
            if(temp.get(i).getNombre().equalsIgnoreCase(nombre)){
                temp.get(i).eliminar(nombrePorcion);
            }//fin if
        }//fin for
    }//fin del metodo eliminarPorcionesPlatilloTemp

/**
 * Proposito: buscar un platillo en el array temporal y devolver su objeto
 * Nombre del metodo: consultarPlatilloTemp
 * @since: 1/12/2014
 * @param: String nombre, String nombrePorcion = nombre del platillo a buscar
 * @return: objeto de tipo Platillo
*/
    public Platillo consultarPlatilloTemp(String nombre){
        for(int i=0; i<temp.size(); i++){
            if(temp.get(i).getNombre().equalsIgnoreCase(nombre))
                return 
                    temp.get(i);
        }//fin for
    return  
        null;
    }//fin del metodo consultarPlatillo

/**
 * Proposito: limpia el array Temporal
 * Nombre del metodo: cleanTemp
 * @since: 1/12/2014
*/
    public void cleanTemp(){
        temp.clear();
    }//fin del metodo cleanTemp

/**
 * Proposito: Devuelve el estado de la mesa
 * Nombre del metodo:  getStateOfMesa
 * @since: 1/12/2014
 * @param: String numero= numero de la mesa a buscar
 * @return: si existe la mesa y esta disponible devuelve un true de  lo contrario false
*/
    public boolean getStateOfMesa(String numero){
        for(int i=0; i<arrayMesa.size(); i++){
            if(arrayMesa.get(i).getNumMesa().equals(numero)){
                if(arrayMesa.get(i).getDisponibilidad()==true){
                    return true;
                }//Fin if
            }//fin if
        }//fin for
        return false;
    }//fin del metodo getStateOfMesa
    
}//Fin de la clase RegistroA
