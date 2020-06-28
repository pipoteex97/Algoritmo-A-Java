package Controlador;

import java.awt.*;
import java.util.*;
import Modelo.*;
import Vista.*;
import com.mxgraph.model.*;
import com.mxgraph.util.mxConstants;

public class ControladorPrincipal {

    private ArrayList<Nodo> misNodos;
    private ArrayList<Aristas> misAristas;
    private VentanaGrafo miVentanaGrafo;
    private VentanaGrafoSolucion miVentanaGrafoSolucion;
    private int posX = 0, posY = 0;
    
    public ControladorPrincipal() {
        misNodos = new ArrayList<>();
        misAristas = new ArrayList<>();
    }

    public void hacerClickEnPruebas(){
        //miVentanaGrafo.boton5.doClick();
    }
    
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    
    
    //Devuele la lista de todos los nodos que se agregar al gráfico.
    public ArrayList<Nodo> getMisNodos() {
        return misNodos;
    }
    
    //Devuele la lista de todas las aristas que se agregar a los nodos del gráfico.
    public ArrayList<Aristas> getMisAristas() {
        return misAristas;
    }

    /*Método necesario para añadir un nuevo nodo*/
    public boolean añadirNodo(String nombreNodo, int heuristica, int posX, int posY, boolean inicio, boolean fin) {
        try {
            /*Esta bandera se utiliza para indicar si ya existe un nodo con el mismo nombre*/
            boolean bandera = true;
            
            
            /*Utilizamos "nombreVisible" debido a que se muestra en ventana tanto el nombre del nodo
            como su costo hacia el nodo solución.*/
            String nombreVisible = nombreNodo + ": " + heuristica;
            Nodo nodoNuevo = new Nodo(nombreNodo, heuristica, inicio, fin);

            /*Se verifica si el nodo ya existe*/
            for (Nodo miNodo : this.getMisNodos()) {
                if (miNodo.getNombreNodo().equals(nombreNodo)) {
                    bandera = false;
                }
                if (inicio) {
                    if (miNodo.isInicio()) {
                        bandera = false;
                    }
                }
                if (fin) {
                    if (miNodo.isFin()) {
                        bandera = false;
                    }
                }
            }

            /*Si no existe un nodo con el mismo nombre, entonces se añade el nuevo nodo a la lista de los mismos
            y se añade también al gráfico correspondiente.*/
            if (bandera) {
                this.getMisNodos().add(nodoNuevo);
                miVentanaGrafo.getGrafo().getModel().beginUpdate();
                Object parent = miVentanaGrafo.getGrafo().getDefaultParent();
                if (inicio || fin) {
                    if (inicio) {
                        miVentanaGrafo.getGrafo().insertVertex(parent, nombreNodo, nombreVisible, posX, posY, 100, 50,
                                                      "shape=ellipse;fillColor=pink;fontColor=black,fontStyle=bold;");
                    }else{
                        miVentanaGrafo.getGrafo().insertVertex(parent, nombreNodo, nombreVisible, posX, posY, 100, 50,
                                                       "shape=ellipse;fillColor=pink;fontColor=black,fontStyle=bold;");
                    }
                }else{
                    //Este nombreVisible muestra tanto el nombre del nodo como su heurística...
                    miVentanaGrafo.getGrafo().insertVertex(parent, nombreNodo, nombreVisible, posX, posY, 100, 50);
                }
                miVentanaGrafo.getGrafo().getModel().endUpdate();
            }
            return bandera;
        } catch (Exception e) {
            System.out.println("No se pudo añadir el nodo " + e.getMessage());
            return false;
        }
    }

    
    /*Método utilizado para añadir una arista entre dos nodos*/
    public boolean añadirArista(String costo, String nombreNodoA, String nombreNodoB) {
        try {
            miVentanaGrafo.getGrafo().getModel().beginUpdate();
            Object parent = miVentanaGrafo.getGrafo().getDefaultParent();
            /*Se obtienen todos los objetos dentro del gráfico, y se los añade a un vector*/
            Object[] cells = miVentanaGrafo.getGrafo().getChildVertices(miVentanaGrafo.getGrafo().getDefaultParent());
            
            /*Se crean dos Objects: Para indicar los dos nodos entre los que se crea la arista*/
            Object nodoA = null, nodoB = null;

            /*Buscamos los dos nodos: Como no hay posibilidad de error, se realiza una búsqueda y se obtienen
            los nodos elegidos*/
            for (Object c : cells) {
                mxCell cell = (mxCell) c;
                /*getId() obtiene el nombre que le dimos en la funcion "insertVertex".*/
                if (cell.getId().equals(nombreNodoA)) {
                    nodoA = cell;
                }
                if (cell.getId().equals(nombreNodoB)) {
                    nodoB = cell;
                }
            }
            
            /*Se comprueba de que la arista entre esos dos nodos no exista.*/
            for (Aristas miAristaC : this.getMisAristas()) {
                boolean comprobar = (miAristaC.getNodoA().getNombreNodo().equals(nombreNodoA) &&
                        miAristaC.getNodoB().getNombreNodo().equals(nombreNodoB)) || 
                        (miAristaC.getNodoA().getNombreNodo().equals(nombreNodoB) &&
                        miAristaC.getNodoB().getNombreNodo().equals(nombreNodoA));
                if (comprobar) {
                    miVentanaGrafo.getGrafo().getModel().endUpdate();
                    throw new RuntimeException("Esa arista ya existe");
                }
            }
            
            /*Se inserta la arista entre los dos nodos*/
            Object aristaNueva = miVentanaGrafo.getGrafo().insertEdge(parent, "arista", costo, nodoA, nodoB);
            miVentanaGrafo.getGrafo().getModel().endUpdate();
            
            /*Para poder determinar de manera correcta el ID, se castea para poder obtener el id que otorga
            el grafo de manera automática*/
            mxCell aristaNueva2 = (mxCell) aristaNueva;
            
            /*A continuación, creamos dos objetos de tipo Nodo, para poder crear la arista correspondiente  
            y agregarla a la lista que manejamos a nivel modelo.
            Nuevamente, no hay posibilidad de error, unicamente se realiza la busqueda y la obtención.*/
            Nodo nodoX = null, nodoY = null;
            for (Nodo miNodo : this.getMisNodos()) {
                if (miNodo.getNombreNodo().equals(nombreNodoA)) {
                    nodoX = miNodo;
                }
                if (miNodo.getNombreNodo().equals(nombreNodoB)) {
                    nodoY = miNodo;
                }
            }
            
            /*Se instancia una nueva arista, luego procedemos a agregarla a la lista.*/
            Aristas miArista = new Aristas(aristaNueva2.getId(), Integer.parseInt(costo), nodoX, nodoY);
            this.getMisAristas().add(miArista);
            
            //Cada nodo tiene una lista de sus aristas, por ello se agrega la nueva arista al nodo correspondiente.
            for (Nodo miNodo : this.getMisNodos()) {
                if (miNodo.getNombreNodo().equals(nombreNodoA)) {
                    this.getMisNodos().get(this.getMisNodos().indexOf(miNodo)).getAristas().add(miArista);
                }
                if (miNodo.getNombreNodo().equals(nombreNodoB)) {
                    this.getMisNodos().get(this.getMisNodos().indexOf(miNodo)).getAristas().add(miArista);
                }
            }
            
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo añadir la arista " + e.getMessage());
            return false;
        }
    }
    
    /*Método necesario para eliminar cualquier elemento del gráfico, ya sea arista o nodo.*/
    public boolean eliminarElemento(Object elementoABorrar) {
        try {
            /*Esta bandera se utiliza para identificar si se seleccionó o no un elemento.*/
            boolean bandera = false;
            /*Esta bandera se utiliza para saber si el elemento es un nodo o una arista.*/
            boolean bandera2 = false;

            Object parent = miVentanaGrafo.getGrafo().getDefaultParent();
            /*Se obtienen todos los objetos dentro del gráfico, y se los añade a un vector*/
            Object[] cells = miVentanaGrafo.getGrafo().getChildVertices(miVentanaGrafo.getGrafo().getDefaultParent());

            /*Se castea el tipo Object que recibimos como parámetro al tipo mxCell, para así comparar
            los Id de manera correcta.*/
            mxCell elementoABorrar2 = (mxCell) elementoABorrar;
            
            /*Se obtiene el elemento a eliminar, identificando si se ha seleccionado o no un elemento*/
            for (Object c : cells) {
                mxCell cell = (mxCell) c;
                if (cell.getId().equals(elementoABorrar2.getId())) {
                    bandera = true;
                }
            }

            /*Se realiza la creacion de este vector debido a que el método "removeCells" solicita
            el pasaje de un vector.*/
            Object[] cells2 = new Object[5];
            cells2[1] = elementoABorrar;

            /*Se elmina el elemento del grafo.*/
            miVentanaGrafo.getGrafo().removeCells(cells2);
            miVentanaGrafo.getGrafo().getModel().endUpdate();

            /*Creamos una instancia de Nodo para poder determinar si el elemento seleccionado es una arista o
            un nodo.*/
            Nodo miNode = null;
            
            /*Recorremos todos los nodos, si al comparar no encontramos el nodo, entonces "bandera2" sigue
            en FALSE, por lo que sirve como entrada a las estructuras condicionales que vienen a continuación*/
            for (Nodo miNodo : this.getMisNodos()) {
                if (miNodo.getNombreNodo().equals(elementoABorrar2.getId())) {
                    bandera2 = true;
                    miNode = miNodo;
                }
            }
            
            /*Ingresa a la estructura condicional únicamente si existe el elemento a borrar, y si además el mismo
            es un nodo.*/
            if (bandera && bandera2) {
                /*No solo se debe de eliminar el nodo, sino tambien la/s aristas que tenía. Para ello, 
                se crea una nueva lista que va a tener a todas las aristas para eliminar*/
                ArrayList<Aristas> aristasAEliminar = new ArrayList<>();
                for (Aristas miAristaB : this.getMisAristas()) {
                    if (miAristaB.getNodoA().getNombreNodo().equals(miNode.getNombreNodo())
                            || miAristaB.getNodoB().getNombreNodo().equals(miNode.getNombreNodo())) {
                        aristasAEliminar.add(miAristaB);
                    }
                }
                
                /*Puede tambien que el nodo a eliminar no tenga ninguna arista, por eso se debe de chequear*/
                if (aristasAEliminar.size() > 0) {
                    for (Aristas aristaAEliminar : aristasAEliminar) {
                        this.getMisAristas().remove(aristaAEliminar);
                    }
                }
                
                /*Se eliminan las aristas de los diferentes nodos también */
                for (Nodo miNodo : this.getMisNodos()) {
                    for (Aristas unaArista : aristasAEliminar) {
                        if (miNodo.getAristas().contains(unaArista)) {
                            miNodo.getAristas().remove(unaArista);
                        }
                    }
                }
                /*Por último, se elimina el nodo*/
                this.getMisNodos().remove(miNode);
                return true;
            }
            
            
            /*Ingresa a la estructura condicional en caso de que exista el elemento, y además no sea un nodo
            (Esto implica indirectamente que es una arista).*/
            if (/*bandera &&*/ (bandera2 == false)) {
                Aristas miArista = null;
                for (Aristas miArist : this.getMisAristas()) {
                    if (miArist.getNombreArista().equals(elementoABorrar2.getId())) {
                        miArista = miArist;
                    }
                }
                this.getMisAristas().remove(miArista);
                
                /*Se eliminan las aristas de los diferentes nodos también */
                for (Nodo miNodoA : this.getMisNodos()) {
                    if (miNodoA.getAristas().contains(miArista)) {
                        miNodoA.getAristas().remove(miArista);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    //Uno de los ejercicios dados en clase.
    public void ejercicioClase1(){
        limpiarVentanaGrafo();
        añadirNodo("E", 43, 0, 450, false, false);
        añadirNodo("K", 21, 150, 480, false , false);
        añadirNodo("D", 40, 100, 250, true , false);
        añadirNodo("J", 18, 250, 400, false, false);
        añadirNodo("I", 20, 200, 150, false, false);
        añadirNodo("M", 30, 300, 0, false, false);
        añadirNodo("L", 10, 400, 150, false, false);
        añadirNodo("P", 5, 500, 400, false, false);
        añadirNodo("Q", 0, 350, 480, false, true);
        añadirArista("10", "E", "D");
        añadirArista("44", "D", "I");
        añadirArista("90", "M", "I");
        añadirArista("70", "M", "L");
        añadirArista("2", "P", "L");
        añadirArista("16", "I", "L");
        añadirArista("30", "P", "Q");
        añadirArista("7", "J", "Q");
        añadirArista("23", "J", "L");
        añadirArista("50", "J", "K");
        añadirArista("48", "D", "K");
        añadirArista("59", "E", "J");
    }
    
    
    //Uno de los ejercicios dados en clase.
    public void ejercicioDeGuia(){
        limpiarVentanaGrafo();
        añadirNodo("R", 15, 0, 0, false, false);
        añadirNodo("Z", 80, 300, 0, false, false);
        añadirNodo("C", 55, 550, 0, false, false);
        añadirNodo("L", 50, 200, 200, true, false);
        añadirNodo("B", 0, 550, 230, false, true);
        añadirNodo("A", 30, 0, 400, false, false);
        añadirNodo("X", 10, 260, 360, false, false);
        añadirNodo("P", 70, 550, 400, false, false);
        añadirNodo("W", 90, 320, 480, false, false);
        añadirArista("35", "R", "Z");
        añadirArista("10", "C", "Z");
        añadirArista("35", "R", "A");
        añadirArista("11", "L", "Z");
        añadirArista("70", "P", "Z");
        añadirArista("80", "C", "B");
        añadirArista("60", "X", "L");
        añadirArista("45", "A", "X");
        añadirArista("75", "P", "X");
        añadirArista("60", "B", "W");
        añadirArista("45", "A", "W");
        añadirArista("80", "P", "W");
    }
    
    
    //Uno de los ejercicios dados en clase.
    public void ejercicioDeGuia2(){
        limpiarVentanaGrafo();
        añadirNodo("A", 60, 0, 0, true, false);
        añadirNodo("I", 44, 0, 450, false, false);
        añadirNodo("E", 25, 300, 0, false, false);
        añadirNodo("C", 33, 100, 150, false, false);
        añadirNodo("B", 40, 300, 150, false, false);
        añadirNodo("D", 12, 70, 290, false, false);
        añadirNodo("F", 15, 400, 250, false, false);
        añadirNodo("H", 22, 550, 180, false, false);
        añadirNodo("J", 11, 150, 450, false, false);
        añadirNodo("Z", 0, 300, 450, false, true);
        añadirNodo("K", 44, 500, 450, false, false);
        añadirArista("20", "A", "I");
        añadirArista("10", "A", "E");
        añadirArista("30", "A", "D");
        añadirArista("25", "E", "H");
        añadirArista("40", "E", "C");
        añadirArista("12", "E", "F");
        añadirArista("20", "B", "C");
        añadirArista("15", "I", "J");
        añadirArista("15", "D", "J");
        añadirArista("15", "Z", "J");
        añadirArista("15", "Z", "K");
        añadirArista("15", "H", "K");
        añadirArista("15", "H", "Z");
        añadirArista("10", "F", "Z");
        añadirArista("10", "F", "B");
        añadirArista("90", "F", "H");
        añadirArista("30", "C", "Z");
        añadirArista("10", "D", "F");
    }
    
    
    //Uno de los ejercicios dado para practicar ejemplos.
    public void ejercicioDePrueba(){
        limpiarVentanaGrafo();
        añadirNodo("A", 40, 350, 0, true, false);
        añadirNodo("C", 2, 200, 200, false, false);
        añadirNodo("B", 98, 400, 200, false, false);
        añadirNodo("E", 20, 200, 350, false, false);
        añadirNodo("D", 20, 400, 350, false, false);
        añadirNodo("F", 0, 350, 500, false, true);
        añadirArista("80", "A", "C");
        añadirArista("2", "A", "B");
        añadirArista("5", "C", "B");
        añadirArista("3", "C", "E");
        añadirArista("1", "C", "D");
        añadirArista("4", "E", "D");
        añadirArista("1", "E", "F");
        añadirArista("1", "D", "F");
    }
    
    //Ejercicio para sobre y sub estimar.
    public void ejercicioParaPruebas(){
        limpiarVentanaGrafo();
        añadirNodo("A", 2, 300, 0, true, false);
        añadirNodo("B", 2, 100, 200, false, false);
        añadirNodo("C", 2, 300, 200, false, false);
        añadirNodo("D", 1, 500, 200, false, false);
        añadirNodo("E", 1, 150, 350, false, false);
        añadirNodo("F", 0, 350, 450, false, true);
        añadirArista("1", "A", "B");
        añadirArista("1", "A", "C");
        añadirArista("1", "C", "E");
        añadirArista("1", "A", "D");
        añadirArista("1", "B", "E");
        añadirArista("1", "E", "F");
        añadirArista("1", "D", "F");
    }
    
    
    /*Este metodo utilizamos para eliminar todos los objetos dentro de la ventana grafo.
    Además se eliminan todos lo nodos y aristas de las listas correspondientes.*/
    public void limpiarVentanaGrafo(){
        try {
            miVentanaGrafo.getGrafo().getModel().beginUpdate();
            Object parent = miVentanaGrafo.getGrafo().getDefaultParent();
            /*Se obtienen todos los objetos dentro del gráfico, y se los añade a un vector*/
            Object[] cells = miVentanaGrafo.getGrafo().getChildVertices(miVentanaGrafo.getGrafo().getDefaultParent());
            /*Se elmina el elemento del grafo.*/
            miVentanaGrafo.getGrafo().removeCells(cells);
            miVentanaGrafo.getGrafo().getModel().endUpdate();
            getMisNodos().removeAll(misNodos);
            getMisAristas().removeAll(misAristas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
