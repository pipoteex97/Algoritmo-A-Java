package Controlador;

import java.awt.*;
import java.util.*;
import Modelo.*;
import Vista.*;
import com.mxgraph.model.*;
import com.mxgraph.util.mxConstants;

public class ControladorAlgoritmo {
    private VentanaGrafoSolucion miVentana;
    private ArrayList<Nodo> misNodos;
    private ArrayList<Aristas> misAristas;
    /*Lista utilizada para manejar todos los nodos que se encuentran abiertos, y que están disponibles para
    ser expandidos.*/
    private ArrayList<Nodo> nodosAbiertos = new ArrayList<Nodo>();
    /*Lista utilizada para almacenar todos los nodos que ya se recorrieron y no tienen una heurística mejor por ahora.*/
    private ArrayList<Nodo> nodosRecorridos = new ArrayList<Nodo>();
    /*Lista que contiene los nodos que conforman el camino solución.*/
    private ArrayList<Nodo> caminoSolucion = new ArrayList<Nodo>();
    private Nodo origen, destino;
    private int tiempo = 0;
    private int tiemporParaArbol = 0;
    /*Valores utilizados para determinar la cantidad de nodos que se encuentran en el mismo nivel
    y luego graficarlos de manera correspondiente.*/
    private int nivel1 = 1, nivel2 = 1, nivel3 = 1, nivel4 = 1, nivel5 = 1;
    //En este texto se almacena todo lo que se muestra luego en la ventana correspondiente.
    //En este texto se almacena todo lo que se muestra luego en pantalla
    private String texto = "";
    /*Es una lista que contiene todos los nodos que se expanden mediante el algoritmo, 
    para demostrarlo de manera gráfica.*/
    private ArrayList<Nodo> nodosParaArbol = new ArrayList<Nodo>();
    /*Es una lista que contiene todas las uniones entre los nodos que se expanden mediante el algoritmo.*/
    private ArrayList<Aristas> aristasParaArbol = new ArrayList<Aristas>();
    
    /*Cuando se lo instancia recibe 3 parámetros:
    Todos los nodos que están creados en la VentanaGrafo;
    todas las aristas en el mismo;
    y una instancia de VentanaGrafoSolución para poder graficar los nodos y aristas en el mismo.*/
    public ControladorAlgoritmo(ArrayList<Nodo> misNodos, ArrayList<Aristas> misAristas, VentanaGrafoSolucion miVentana) {
        this.miVentana = miVentana;
        this.misNodos = misNodos;
        this.misAristas = misAristas;
    }
    
    /*Como su nombre lo indica, es el método encargado de generar la lógica para dibujar el
    árbol generado en la búsqueda realizada.*/
    public void dibujarArbol(ArrayList<Nodo> caminoSolucion){
        /*Primero limpia la ventana para que no se superponga el árbol y el camino solución*/
        limpiarVentanaGrafoSolucion();
        System.out.println("----------------------------------------------");
        /*se recorre esta lista y se los envía al método añadirNodo para que los dibuje en pantalla uno a uno.*/
        for (Nodo nodo : nodosParaArbol) {
            System.out.println("agrego ahora " + nodo.getNombreNodo() + " con nivel : " + nodo.getNivel());
            añadirNodo(nodo, caminoSolucion);
        }
        /*Se recorre esta lista para unir todos los nodos dibujados anteriormente.*/
        for (Aristas aristas : aristasParaArbol) {
            añadirArista(aristas.getNodoA(), aristas.getNodoB(), aristas.getCostoArista());
        }
        /*se setean los niveles en 1 para que los nodos se dibujen en posiciones correlativas y sin pisarse 
        en las próximas llamadas a éste método.*/
        nivel1 = 1;
        nivel2 = 1;
        nivel3 = 1;
        nivel4 = 1;
        nivel5 = 1;
    }
    
    /*Método utilizado para encontrar el nodo al que hace referencia el nombre que fue pasado como parámetro.*/
    public Nodo buscarNodo(String nombreNodo){
        Nodo nodoEncontrado = null;
        for (Nodo miNodo : misNodos) {
            if (miNodo.getNombreNodo().equals(nombreNodo)) {
                nodoEncontrado = miNodo;
            }
        }
        return nodoEncontrado;
    }
    
    /*Devuelve todo el texto generado para luego presentarlo en la ventana correspondiente.*/
    public String devolverTexto(){
        return this.texto;
    }
    
    /*Como su nombre lo indica, en este método se inicializa el algoritmo.*/
    public ArrayList<Nodo> comienzoBusqueda(String orig, String dest){
        //Como los parámetros obtenidos son String, se deben buscar los nodos correspondientes con este llamado.
        this.origen = buscarNodo(orig);
        this.destino = buscarNodo(dest);
        
        /*Como no existe costo acumulado en el origen, su función heurística es igual a su DLR.*/
        origen.setFuncionHeuristica(origen.getDlr());
        nodosAbiertos.add(origen);
        
        System.out.println("////////////////////////// NUEVA BUSQUEDA ////////////////////////// \n");
        /*Cada vez que se vea una línea como la de abajo, es porque estamos agregando texto a la variable 
        que luego se muestra en pantalla.*/
        this.texto = texto + "\n////////////////////////// NUEVA BUSQUEDA ////////////////////////// \n \n"; 
        System.out.println("En tiempo t = " + tiempo);
        this.texto = texto + "Tiempo T = " + tiempo + "\n \n"; 
        for (Nodo nodoBusqueda : nodosAbiertos) {
            System.out.println("Los nodos Abiertos son : " + nodoBusqueda.getNombreNodo());
            this.texto = texto + "Los nodos Abiertos son :" + nodoBusqueda.getNombreNodo() + "\n";
        }
        
        /*Si el orígen y el destino son iguales entonces se termina acá el algoritmo*/
        if (origen.getNombreNodo().equals(destino.getNombreNodo())) {
            System.out.println(".................. SE ENCONTRÓ UNA SOLUCIÓN ..................");
            this.texto = texto + "\n .................. SE ENCONTRÓ UNA SOLUCIÓN ..................\n \n" ;
            System.out.println("El destino es: " + origen.getNombreNodo());
            this.texto = texto + "El destino es: " + origen.getNombreNodo();
            caminoSolucion.add(origen);
            return caminoSolucion;
        }
        
        /*Se añade el origen al árbol para graficar.*/
        origen.setTiempo(tiemporParaArbol);
        nodosParaArbol.add(origen);
        tiemporParaArbol = tiemporParaArbol + 1;
        /*Se envía el orígen al método expandir nodo para hallar sus nodos vecinos.*/
        expandirNodo(origen);
        
        ArrayList<Nodo> caminoBusqueda = caminoSolucion;
        /*Se envía el camino solución (por ahora, no contiene elementos) al método que realiza la búsqueda de
        manera recursiva.
        Luego, este mismo método devuelve todo el camino solución por lo que lo almacenamos en esa lista de 
        "camino solución."*/
        caminoSolucion = busquedaRecursiva(caminoBusqueda);
        System.out.println("................... SOLUCIÓN ...................\n");
        this.texto = texto + "................... SOLUCIÓN ...................\n" ;
        
        System.out.println("El camino solución es: ");
        this.texto = texto + "El camino solución es: \n";
        /*Se recorre la lista caminoSolución y se lo agrega al texto.*/
        for (Nodo nodo : caminoSolucion) {
            System.out.println(nodo.getNombreNodo() + " con f = " + nodo.getFuncionHeuristica());
            this.texto = texto + nodo.getNombreNodo() + " con f = " + nodo.getFuncionHeuristica()+ " \n";
        }
        
        return caminoSolucion;
    }
    
    
    /*Método necesario para realizar el algoritmo, y lo que hace es una búsqueda recursiva para hallar el caminoSolución.*/
    public ArrayList<Nodo> busquedaRecursiva(ArrayList<Nodo> caminoSolucion){
        /*Se analiza en cada llamada a éste método cuál es el mejor nodo de todos los que tenemos en la lista
        de nodosAbiertos.*/
        Nodo mejorNodo = null;
        
        for (Nodo nodosAbierto : nodosAbiertos) {
            mejorNodo = nodosAbierto;
        }
        
        /*Se busca cuál es el mejor nodo de todos los que tenemos abiertos mediante una comparación.*/
        for (Nodo nodoBusqueda : nodosAbiertos) {
            if (mejorNodo.getFuncionHeuristica() > nodoBusqueda.getFuncionHeuristica()) {
                mejorNodo = nodoBusqueda;
            }
        }
        
        tiempo = tiempo +1;
        tiemporParaArbol = tiemporParaArbol +1;
        System.out.println("En tiempo t = " + tiempo);
        this.texto = texto + "Tiempo T = " + tiempo +"\n" ;
        /*For each utilizado para mostrar en el texto cuáles son los nodos abiertos en el T correspondiente al que se 
        maneja en esta iteración.*/
        for (Nodo nodoBusqueda : nodosAbiertos) {
            System.out.println("Los nodos Abiertos son : " + nodoBusqueda.getNombreNodo()  + " con f = " + 
                                nodoBusqueda.getCostoAcumulado() + " + " + nodoBusqueda.getDlr() + " = " + 
                                nodoBusqueda.getFuncionHeuristica());
            this.texto = texto + "\n Los nodos Abiertos son :" + nodoBusqueda.getNombreNodo()+  " con f = " + 
                                nodoBusqueda.getCostoAcumulado() + " + " + nodoBusqueda.getDlr() + " = " + 
                                nodoBusqueda.getFuncionHeuristica() + "\n y con nivel: " +
                                nodoBusqueda.getNivel();
        }
        
        /*Como ya teníamos cuál era el mejor nodo en esta iteración, simplemente lo mostramos en el texto.*/
        System.out.println("El siguiente nodo a expandir es : " + mejorNodo.getNombreNodo());
        this.texto = texto + "\n El siguiente nodo a expandir es : " + mejorNodo.getNombreNodo() + "\n" ;
        
        /*Estructura condicional donde se determina si el mejor nodo de los abiertos es el destino.*/
        if (destino.getNombreNodo().equals(mejorNodo.getNombreNodo())) {
            System.out.println("..............SE ENCONTRÓ UNA SOLUCIÓN.......................");
            this.texto = texto + "\n .................. SE ENCONTRÓ UNA SOLUCIÓN ..................\n \n" ;
            System.out.println("El destino es: " + mejorNodo.getNombreNodo());
            this.texto = texto + "El destino es: " + mejorNodo.getNombreNodo();
            System.out.println(" con f = " + mejorNodo.getCostoAcumulado() + " + " + 
                                mejorNodo.getDlr() + " = " + mejorNodo.getFuncionHeuristica());
            this.texto = texto + " con f = " + mejorNodo.getCostoAcumulado() + " + " + 
                                mejorNodo.getDlr() + " = " + mejorNodo.getFuncionHeuristica() + "\n "
                                + " \n y con nivel: " + mejorNodo.getNivel() + "\n" ;
            System.out.println("Y proviene de : " + mejorNodo.getPadre().getNombreNodo());
            this.texto = texto + " Proviene de : " + mejorNodo.getPadre().getNombreNodo() + "\n \n" ;
            /*Si el mejor nodo es el destino, entonces se agrega todo el texto correspondiente a las líneas superiores,
            y luego se llama al método backtrackingCamino para que nos devuelva el caminoSolución.
            */
            caminoSolucion = backtrackingCamino(mejorNodo, caminoSolucion);
        }else{
            /*Si el mejor nodo no es el destino entonces realizamos una expansión de este mejor nodo y luego 
            realizamos una llamada recursiva a este mismo método para continuar con la búsqueda del siguiente mejor
            nodo de todos los abiertos.*/
            expandirNodo(mejorNodo);
            busquedaRecursiva(caminoSolucion);
        }
        /*En el momento que se llega aquí es porque se encontró la solución y se devuelve el caminoSolución encontrado*/
        return caminoSolucion;
    }

    
    /*Método utilizado para "expandir" el mejor nodo que teníamos en esta iteración. Recibe como parámetro
    justamente el mejor nodo que obtuvimos del método búsquedaRecursiva.
    En pocas palabras, este método es el encargado de determinar cuáles son los siguientes nodos a expandir
    y los añade a la lista nodosAbiertos para ser posteriormente analizados.*/
    public void expandirNodo(Nodo nodoParaExpandir){
        System.out.println("----------------APERTURA DE NODOS-------------------");
        this.texto = texto + "\n--------------------------APERTURA DE NODOS--------------------------\n \n";
        
        /*Recorro todas las aristas que tiene el nodo a expandir , y los nodos que se encuentran conectados a él
        se agregan a la lista de nodosAbiertos.*/
        for (Aristas aristaDelNodo : nodoParaExpandir.getAristas()) {
            
            Nodo nodoNuevoAbierto;
            /*
            Como la arista relaciona 2 nodos, obtengo cuál es el nodo que me interesa expandir y lo guardo 
            en nodoNuevoAbierto. El otro nodo que almacena en la arista es el mismo que nodoParaExpandir.
            */
            if (aristaDelNodo.getNodoA().getNombreNodo().equals(nodoParaExpandir.getNombreNodo())) {
                nodoNuevoAbierto = aristaDelNodo.getNodoB();
            }else{
                nodoNuevoAbierto = aristaDelNodo.getNodoA();
            }
            
            /*
            Bandera necesaria para la decision si agrego o no el nuevo nodo.
            */
            boolean flag = true;
            
            /*Si el nodo para agregar está dentro de los nodos recorridos, tengo que observar
            si la Función Heurística(nodoNuevoAbierto) es menor o mayor que el que ya habiamos recorrido.
            Si es menor, entonces tengo que expandir este nuevo nodo porque es un camino mas prometedor
            que el anterior.*/
            if (nodosRecorridos.contains(nodoNuevoAbierto)) {
                /*Bandera utilizada para determinar si es mas prometedor o no este camino. Si lo es entonces
                flag2 = true.*/
                boolean flag2 = false;
                for (Nodo nodoRecorrido : nodosRecorridos) {
                    /*Se calcula cuál sería la función heurística del nodo en este nuevo camino encontrado.*/
                    int nuevoF = nodoNuevoAbierto.getDlr() + nodoParaExpandir.getCostoAcumulado() + aristaDelNodo.getCostoArista();
                    if (nodoNuevoAbierto.getNombreNodo().equals(nodoRecorrido.getNombreNodo())
                            && nuevoF < nodoRecorrido.getFuncionHeuristica()) {
                        flag2 = true;
                    }else{
                        /*Aca se filtran todos los nodos ya recorridos con un F mayor al que ya expandimos*/
                        flag = false;
                    }
                }
                if (flag2) {
                    flag = true;
                    nodosRecorridos.remove(nodoNuevoAbierto);
                }
            }
            
            /*Observo si este nodo ya fue abierto, y me quedó con aquel que tenga menor función heurística.
            Si el que tenía guardado tiene un costo de F mayor, entonces descarto ese camino eliminando al nodo.*/
            if (nodosAbiertos.contains(nodoNuevoAbierto)) {
                boolean flag2 = false;
                Nodo nodoAeliminar = null;
                for (Nodo nodoAbierto : nodosAbiertos) {
                    if (nodoAbierto.getNombreNodo().equals(nodoNuevoAbierto.getNombreNodo())) {
                        System.out.println("encontro el nodo "+ nodoAbierto.getNombreNodo() + " y su f es : " 
                                            + nodoAbierto.getFuncionHeuristica());
                        int nuevoF = nodoParaExpandir.getCostoAcumulado() + aristaDelNodo.getCostoArista()
                                     + nodoNuevoAbierto.getDlr();
                        System.out.println("el nuevo F es " + nuevoF);
                        if (nodoAbierto.getFuncionHeuristica() > nuevoF) {
                            nodoAeliminar = nodoAbierto;
                            flag2 = true;
                        }else{
                            //Si el nodo que ya teniamos abierto tiene mejor heuristica entonces no se
                            //debe de añadir el ultimo nodo abierto.
                            flag = false;
                            /*Las siguientes líneas son utilizadas para agregar este camino al árbol que se muestra
                            en pantalla: Por más que no sea un nodo abierto mejor que el que ya teníamos por otro camino
                            igualmente se debe mostrar en pantalla que se expandió este nodo.*/
                            Nodo nodo = new Nodo(nodoNuevoAbierto.getNombreNodo(), nodoNuevoAbierto.getDlr(), false, false);
                            nodo.setNivel(nodoParaExpandir.getNivel() + 1 );
                            nodo.setFuncionHeuristica(nuevoF);
                            
                            /*Para evitar que se equivoque a la hora de determinar desde donde viene el camino, se crea
                            una nueva instancia de Nodo para asignarlo con el F correspondiente en este caso.*/
                            Nodo nodito = new Nodo("", 0, false, false);
                            for (Nodo miNodo : nodosParaArbol) {
                                if (miNodo.getNombreNodo().equals(nodoParaExpandir.getNombreNodo())
                                        && miNodo.getFuncionHeuristica() == nodoParaExpandir.getFuncionHeuristica()) {
                                    nodito = miNodo;
                                }
                            }
                            
                            Aristas arista = new Aristas("arista", aristaDelNodo.getCostoArista(), nodo, nodito);
                            nodo.setCerrado(true);
                            nodo.setTiempo(tiemporParaArbol);
                            nodosParaArbol.add(nodo);
                            aristasParaArbol.add(arista);
                        }
                    }
                }
                if (flag2) {
                    /*Si por este nuevo camino el nodo tiene mejor Función heurística que por otro camino entonces
                    se elimina el otro camino de los nodos a analizarse en el futuro.*/
                    nodosAbiertos.remove(nodoAeliminar);
                    System.out.println("entro en este flag y elimino el nodo");
                    /*Tengo que encontrar el nodo que ahora está cerrado para colocarlo con un color
                    diferente en el árbol generado*/
                    for (Nodo nodo : nodosParaArbol) {
                        if (nodo.getNombreNodo().equals(nodoAeliminar.getNombreNodo())) {
                            nodo.setCerrado(true);
                        }
                    }
                }
            }
            
            /*En esta estructura condicional se entra únicamente si el actual nodo que estamos analizando es
            viable de ser analizado en el futuro, es decir que: No fue recorrido en el pasado con una F.H. menor,
            ni está expandido en otra rama del árbol con una F.H. menor.*/
            if (flag) {
                //Actualizamos el costo de g(A). El costo acumulado
                nodoNuevoAbierto.setCostoAcumulado(nodoParaExpandir.getCostoAcumulado()
                        + aristaDelNodo.getCostoArista());
                //Actualizamos el costo de f(A). Recordar que f(A) = g(A) + h(A)
                nodoNuevoAbierto.setFuncionHeuristica(nodoNuevoAbierto.getDlr()
                        + nodoNuevoAbierto.getCostoAcumulado());
                
                /*Se setea el "padre" del nodo, es decir por cuál nodo fue expandido. Es necesario
                para posteriormente hacer el backtracking.*/
                nodoNuevoAbierto.setPadre(nodoParaExpandir);
                /*Se setea el nivel en el que se encuentra en el árbol generado.*/
                nodoNuevoAbierto.setNivel(nodoParaExpandir.getNivel() + 1);
                nodoNuevoAbierto.setTiempo(tiemporParaArbol);
                
                /*Las siguientes líneas son utilizadas para agregar este camino al árbol que se muestra
                en pantalla: Por más que no sea un nodo abierto mejor que el que ya teníamos por otro camino
                igualmente se debe mostrar en pantalla que se expandió este nodo.*/
                Nodo nodo = new Nodo(nodoNuevoAbierto.getNombreNodo(), nodoNuevoAbierto.getDlr(), false, false);
                nodo.setNivel(nodoNuevoAbierto.getNivel());
                nodo.setPadre(nodoNuevoAbierto.getPadre());
                nodo.setFuncionHeuristica(nodoNuevoAbierto.getFuncionHeuristica());
                
                Nodo nodito = new Nodo("", 0, false, false);
                for (Nodo miNodo : nodosParaArbol) {
                    if (miNodo.getNombreNodo().equals(nodoParaExpandir.getNombreNodo()) && 
                            miNodo.getFuncionHeuristica() == nodoParaExpandir.getFuncionHeuristica()) {
                        nodito = miNodo;
                    }
                }
                
                Aristas arista = new Aristas("arista", aristaDelNodo.getCostoArista(), nodo, nodito);
                nodo.setTiempo(nodoNuevoAbierto.getTiempo());
                nodosParaArbol.add(nodo);
                aristasParaArbol.add(arista);
                /*Se añade el nodo analizado a la lista nodosAbiertos.*/
                getNodosAbiertos().add(nodoNuevoAbierto);
            }
        }
        /*Luego que se recorrieron todos los nodos conectados al nodoParaExpandir se procede a eliminarlo 
        de la lista nodosAbiertos y se lo añade a la lista nodosRecorridos.*/
        getNodosAbiertos().remove(nodoParaExpandir);
        getNodosRecorridos().add(nodoParaExpandir);
    }
    
    
    /*Se realiza la búsqueda hacia atrás para encontrar el camino solución desde el destino al orígen.
    Posteriormente, se devuelve el camino en cuestión.*/
    public ArrayList<Nodo> backtrackingCamino(Nodo nodo, ArrayList<Nodo> caminoSolucion){
        if (!(nodo.getNombreNodo().equals(origen.getNombreNodo()))) {
            caminoSolucion = backtrackingCamino(nodo.getPadre(), caminoSolucion);
        }
        caminoSolucion.add(nodo);
        return caminoSolucion;
    }
    
    /*Método utilizado para añadir un nodo al grafo Solución. Añade los nodos referentes al árbol generado.
    Por ello, recibe como parámetro el camino solución y el nodo para agregar.
    El camino solución que recibe es únicamente para poder darles un formato diferente en el árbol
    y que se pueda distinguir con facilidad.*/
    public void añadirNodo(Nodo nodo, ArrayList<Nodo> caminoSolucion){
        /*Esta bandera se utiliza para indicar si ya existe un nodo con el mismo nombre*/
        boolean bandera = true;
        
        /*Se verifica si el nodo ya existe*/
        miVentana.getGrafo().getModel().beginUpdate();
        Object parent = miVentana.getGrafo().getDefaultParent();
        //Este nombreVisible muestra tanto el nombre del nodo como su heurística...
        String nombreVisible = nodo.getNombreNodo() + ": " + nodo.getFuncionHeuristica();
        
        /*La posición tanto en X como en Y donde se ubican va a estar determinada por el 
        nivel en el que se encuentren.*/
        int posX = 0;
        int posY = nodo.getNivel() * 100;
        
        
        boolean flag = true;
        /*Si el nodo para añadir es parte del camino solución se lo coloca en el márgen izquierdo y se
        le da una forma diferente que al resto de los nodos.*/
        for (Nodo nodo1 : caminoSolucion) {
            if (nodo.getNombreNodo().equals(nodo1.getNombreNodo()) && nodo.getFuncionHeuristica() == nodo1.getFuncionHeuristica()) {
                miVentana.getGrafo().insertVertex(parent, nombreVisible, nombreVisible,
                                              0, posY, 100, 50, 
                                              "shape=ellipse;fillColor=green;fontColor=black,fontStyle=bold;");
                flag = false;
            }   
        }
        /*Si el nodo no es parte del camino solución entonces se lo añade con una posición en X que depende
        del nivel que esté y de la cantidad de nodos que se encuentren en el mismo nivel.*/
        if (flag) {
            switch (nodo.getNivel()) {
                case 1:
                    posX = nivel1 * 150;
                    nivel1++;
                    break;
                case 2:
                    posX = nivel2 * 150;
                    nivel2++;
                    break;
                case 3:
                    posX = nivel3 * 150;
                    nivel3++;
                    break;
                case 4:
                    posX = nivel4 * 150;
                    nivel4++;
                    break;
                case 5:
                    posX = nivel5 * 150;
                    nivel5++;
                    break;
            }
            if (nodo.isCerrado()) {
                miVentana.getGrafo().insertVertex(parent, nombreVisible, nombreVisible, posX, posY, 100, 50,
                                                   "shape=ellipse;fillColor=red;fontColor=black,fontStyle=bold;");
            }else{
                miVentana.getGrafo().insertVertex(parent, nombreVisible, nombreVisible, posX, posY, 100, 50);
            }
        }
        
        
        miVentana.getGrafo().getModel().endUpdate();
    }
    
    
    /*Método necesario para añadir una arista entre dos nodos del árbol generado.*/
    public void añadirArista(Nodo noditoA, Nodo noditoB, int costo){
        miVentana.getGrafo().getModel().beginUpdate();
        Object parent = miVentana.getGrafo().getDefaultParent();
        /*Se obtienen todos los objetos dentro del gráfico, y se los añade a un vector*/
        Object[] cells = miVentana.getGrafo().getChildVertices(miVentana.getGrafo().getDefaultParent());
        
        String nombreVisibleA = noditoA.getNombreNodo() + ": " + noditoA.getFuncionHeuristica();
        String nombreVisibleB = noditoB.getNombreNodo() + ": " + noditoB.getFuncionHeuristica();;
        
        /*Se crean dos Objects: Para indicar los dos nodos entre los que se crea la arista*/
        Object nodoA = null, nodoB = null;

        /*Buscamos los dos nodos: Como no hay posibilidad de error, se realiza una búsqueda y se obtienen
            los nodos elegidos*/
        for (Object c : cells) {
            mxCell cell = (mxCell) c;
            if (cell.getId().equals(nombreVisibleA)) {
                nodoA = cell;
            }
            if (cell.getId().equals(nombreVisibleB)) {
                nodoB = cell;
            }
        }
        /*Se inserta la arista entre los dos nodos*/
        miVentana.getGrafo().insertEdge(parent, "arista", costo, nodoA, nodoB);
        miVentana.getGrafo().getModel().endUpdate();
    }
    
        
    /*Método necesario para añadir un nuevo nodo. Esto al grafo solucion!!!!*/
    public boolean añadirNodoSolucion(ArrayList<Nodo> caminoSolucion) {
        try {
            limpiarVentanaGrafoSolucion();
            float vueltas = 1;
            int cantidadNodos = caminoSolucion.size();
            
            for (int i = 0; i < cantidadNodos; i++) {
                miVentana.getGrafo().getModel().beginUpdate();
                Object parent = miVentana.getGrafo().getDefaultParent();
                //Este nombreVisible muestra tanto el nombre del nodo como su heurística...
                String nombreVisible = caminoSolucion.get(i).getNombreNodo() + ": " + caminoSolucion.get(i).getFuncionHeuristica();
                miVentana.getGrafo().insertVertex(parent, caminoSolucion.get(i).getNombreNodo(), nombreVisible, 
                        300, 100 * vueltas, 100, 50);
                miVentana.getGrafo().getModel().endUpdate();
                vueltas = vueltas + (6/4);
                if (i > 0) {
                    System.out.println(caminoSolucion.get(i - 1).getNombreNodo());
                    System.out.println(caminoSolucion.get(i).getNombreNodo());
                    añadirAristaSolucion(caminoSolucion.get(i - 1), caminoSolucion.get(i));
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo añadir el nodo " + e.getMessage());
            return false;
        }
    }
    
    /*Método utilizado para añadir una arista entre dos nodos. Esto al grafo solucion!!!!*/
    public boolean añadirAristaSolucion(Nodo nodoA, Nodo nodoB) {
        try {
            System.out.println("Aca entraron los dos nodos arriba");
            miVentana.getGrafo().getModel().beginUpdate();
            Object parent = miVentana.getGrafo().getDefaultParent();
            /*Se obtienen todos los objetos dentro del gráfico, y se los añade a un vector*/
            Object[] cells = miVentana.getGrafo().getChildVertices(miVentana.getGrafo().getDefaultParent());
            /*Se crean dos Objects: Para indicar los dos nodos entre los que se crea la arista*/
            Object objectA = null, objectB = null;
            /*Buscamos los dos nodos: Como no hay posibilidad de error, se realiza una búsqueda y se obtienen
            los nodos elegidos*/
            for (Object c : cells) {
                mxCell cell = (mxCell) c;
                if (cell.getId().equals(nodoA.getNombreNodo())) {
                    System.out.println("Se añadio el nodo " + nodoA.getNombreNodo());
                    objectA = cell;
                }
                if (cell.getId().equals(nodoB.getNombreNodo())) {
                    System.out.println("Se añadio el nodo " + nodoB.getNombreNodo());
                    objectB = cell;
                }
            }
            /*Se inserta la arista entre los dos nodos*/
            Object aristaNueva = miVentana.getGrafo().insertEdge(parent, "arista", "", objectA, objectB);
            miVentana.getGrafo().getModel().endUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo añadir la arista " + e.getMessage());
            return false;
        }
    }
    
    
    /*Método utilizado para añadir un nodo al grafo Solución. Añade los nodos referentes al árbol generado.
    Por ello, recibe como parámetro el camino solución y el nodo para agregar.
    El camino solución que recibe es únicamente para poder darles un formato diferente en el árbol
    y que se pueda distinguir con facilidad.*/
    public void añadirNodoPorTiempo(Nodo nodo){
        /*Esta bandera se utiliza para indicar si ya existe un nodo con el mismo nombre*/
        boolean bandera = true;
        
        /*Se verifica si el nodo ya existe*/
        miVentana.getGrafo().getModel().beginUpdate();
        Object parent = miVentana.getGrafo().getDefaultParent();
        //Este nombreVisible muestra tanto el nombre del nodo como su heurística...
        String nombreVisible = nodo.getNombreNodo() + ": " + nodo.getFuncionHeuristica();
        
        /*La posición tanto en X como en Y donde se ubican va a estar determinada por el 
        nivel en el que se encuentren.*/
        int posX = 0;
        int posY = nodo.getNivel() * 100;
        
        
        boolean flag = true;
        /*Si el nodo para añadir es parte del camino solución se lo coloca en el márgen izquierdo y se
        le da una forma diferente que al resto de los nodos.*/
        for (Nodo nodo1 : caminoSolucion) {
            if (nodo.getNombreNodo().equals(nodo1.getNombreNodo()) && nodo.getFuncionHeuristica() == nodo1.getFuncionHeuristica()) {
                miVentana.getGrafo().insertVertex(parent, nombreVisible, nombreVisible,
                                              0, posY, 100, 50, 
                                              "shape=ellipse;fillColor=green;fontColor=black,fontStyle=bold;");
                flag = false;
            }   
        }
        /*Si el nodo no es parte del camino solución entonces se lo añade con una posición en X que depende
        del nivel que esté y de la cantidad de nodos que se encuentren en el mismo nivel.*/
        if (flag) {
            switch (nodo.getNivel()) {
                case 1:
                    posX = nivel1 * 150;
                    nivel1++;
                    break;
                case 2:
                    posX = nivel2 * 150;
                    nivel2++;
                    break;
                case 3:
                    posX = nivel3 * 150;
                    nivel3++;
                    break;
                case 4:
                    posX = nivel4 * 150;
                    nivel4++;
                    break;
                case 5:
                    posX = nivel5 * 150;
                    nivel5++;
                    break;
            }
            if (nodo.isCerrado()) {
                miVentana.getGrafo().insertVertex(parent, nombreVisible, nombreVisible, posX, posY, 100, 50,
                                                   "shape=ellipse;fillColor=red;fontColor=black,fontStyle=bold;");
            }else{
                miVentana.getGrafo().insertVertex(parent, nombreVisible, nombreVisible, posX, posY, 100, 50);
            }
        }
        
        
        miVentana.getGrafo().getModel().endUpdate();
    }
    
    
    /*Método necesario para añadir una arista entre dos nodos del árbol generado.*/
    public void añadirAristaPorTiempo(Nodo noditoA, Nodo noditoB, int costo, int tiempo){
        if (noditoA.getTiempo() == tiempo || noditoB.getTiempo() == tiempo) {
            
            miVentana.getGrafo().getModel().beginUpdate();
            Object parent = miVentana.getGrafo().getDefaultParent();
            /*Se obtienen todos los objetos dentro del gráfico, y se los añade a un vector*/
            Object[] cells = miVentana.getGrafo().getChildVertices(miVentana.getGrafo().getDefaultParent());

            String nombreVisibleA = noditoA.getNombreNodo() + ": " + noditoA.getFuncionHeuristica();
            String nombreVisibleB = noditoB.getNombreNodo() + ": " + noditoB.getFuncionHeuristica();;

            /*Se crean dos Objects: Para indicar los dos nodos entre los que se crea la arista*/
            Object nodoA = null, nodoB = null;

            /*Buscamos los dos nodos: Como no hay posibilidad de error, se realiza una búsqueda y se obtienen
            los nodos elegidos*/
            for (Object c : cells) {
                mxCell cell = (mxCell) c;
                if (cell.getId().equals(nombreVisibleA)) {
                    nodoA = cell;
                }
                if (cell.getId().equals(nombreVisibleB)) {
                    nodoB = cell;
                }
            }
            /*Se inserta la arista entre los dos nodos*/
            miVentana.getGrafo().insertEdge(parent, "arista", costo, nodoA, nodoB);
            miVentana.getGrafo().getModel().endUpdate();
            
        }
    }
    
    
    /*Como su nombre lo indica, es el método encargado de generar la lógica para dibujar el
    árbol generado en la búsqueda realizada.*/
    public void dibujarArbolPorTiempo(int tiempo){
        System.out.println("----------------------------------------------");
        for (Nodo nodo : nodosParaArbol) {
            System.out.println(nodo.getTiempo());
        }
        /*se recorre esta lista y se los envía al método añadirNodo para que los dibuje en pantalla uno a uno.*/
        for (Nodo nodo : nodosParaArbol) {
            if (tiempo == nodo.getTiempo()) {
                System.out.println("agrego ahora " + nodo.getNombreNodo() + " con nivel : " + nodo.getNivel());
                añadirNodoPorTiempo(nodo);
            }
        }
        /*Se recorre esta lista para unir todos los nodos dibujados anteriormente.*/
        for (Aristas aristas : aristasParaArbol) {
            añadirAristaPorTiempo(aristas.getNodoA(), aristas.getNodoB(), aristas.getCostoArista(), tiempo);
        }

    }
    
    
    /*este metodo utilizamos para eliminar todos los objetos dentro de la ventana grafo solución.*/
    public void limpiarVentanaGrafoSolucion(){
        try {
            miVentana.getGrafo().getModel().beginUpdate();
            Object parent = miVentana.getGrafo().getDefaultParent();
            /*Se obtienen todos los objetos dentro del gráfico, y se los añade a un vector*/
            Object[] cells = miVentana.getGrafo().getChildVertices(miVentana.getGrafo().getDefaultParent());
            /*Se elmina el elemento del grafo.*/
            miVentana.getGrafo().removeCells(cells);
            miVentana.getGrafo().getModel().endUpdate();
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    //Getters y Setters.
    public void setearNivelesInicio(){
        nivel1 = 1;
        nivel2 = 1;
        nivel3 = 1;
        nivel4 = 1;
        nivel5 = 1;
    }

    public int getTiempo() {
        return tiempo;
    }
    
    public ArrayList<Nodo> getMisNodos() {
        return misNodos;
    }

    public ArrayList<Nodo> getNodosAbiertos() {
        return nodosAbiertos;
    }

    public ArrayList<Nodo> getNodosRecorridos() {
        return nodosRecorridos;
    }

    public ArrayList<Nodo> getCaminoSolucion() {
        return caminoSolucion;
    }

    public ArrayList<Aristas> getMisAristas() {
        return misAristas;
    }
        
}
