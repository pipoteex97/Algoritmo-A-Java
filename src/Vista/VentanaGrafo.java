package Vista;

import Controlador.*;
import Modelo.Nodo;
import com.mxgraph.model.*;
import com.mxgraph.swing.*;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import javax.swing.*;

public class VentanaGrafo extends javax.swing.JFrame {

    private static mxGraph graph = new mxGraph();
    private mxGraphComponent graphComponent = new mxGraphComponent(graph);
    private ControladorPrincipal miControlador;
    public JButton boton, boton1, boton2, boton3, boton4, boton5;
    private boolean isSobrestimacion = false, isSubestimacion = false;

    public VentanaGrafo(ControladorPrincipal miControladorPrincipal) {
        setTitle("Trabajo Final - Inteligencia Artificial I");
        setSize(730, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setLocation(0, 0);
        this.miControlador = miControladorPrincipal;
    }

    /*Metodo que devuelve el grafo en el que estamos trabajando.*/
    public static mxGraph getGrafo() {
        return graph;
    }

    public void inicializarVentana() {
        /*
        Para poder juntar tanto la ventana de grafos como los botones de interacción lo que hacemos es
        crear dos JPanel, en uno albergamos la ventana del grafo, y en otro los botones.
        Finalmente agregamos los dos paneles al Pane del JFrame y conseguimos unir las dos cosas.
         */
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        graphComponent.setPreferredSize(new Dimension(700, 550));
        panel1.add(graphComponent);
        getContentPane().add(panel1, BorderLayout.WEST);
        getContentPane().add(panel2, BorderLayout.SOUTH);

        /*Todos los botones fueron creados de la misma manera:
        Se los inicializa, se los agrega al segundo Panel, y se modifica su método cuando son presionados
        para que realicen la tarea que les pertenece a cada uno.*/
        boton = new JButton("Anadir Nodo");
        panel2.add(boton);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertarNodo miVentana = new InsertarNodo(miControlador);
                miVentana.setVisible(true);
            }
        });

        boton1 = new JButton("Anadir Arista");
        panel2.add(boton1);
        boton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                InsertarArista miVentana = new InsertarArista(miControlador);
                miVentana.setVisible(true);

            }
        });

        boton2 = new JButton("Eliminar Elemento");
        panel2.add(boton2);
        boton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean resultado = miControlador.eliminarElemento(getCellSeleccionado());
                if (resultado) {
                    JOptionPane.showMessageDialog(null, "Elemento eliminado con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un elemento para borrar");
                }
            }
        });

        boton3 = new JButton("Gestionar Ventana");
        panel2.add(boton3);
        boton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GestionarVentana miVentana = new GestionarVentana(miControlador);
                miVentana.setVisible(true);

            }
        });

        boton4 = new JButton("Búsqueda");
        panel2.add(boton4);
        boton4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                restablecerFdeNodos();
                BusquedaHeuristica miVentana = new BusquedaHeuristica(miControlador);
                miVentana.setVisible(true);
                /*
                Restablecemos en 0 los valores obtenidos, en caso que se desee hacer una busqueda diferente
                en la próxima ocasión.
                 */
                for (Nodo miNodo : miControlador.getMisNodos()) {
                    miNodo.setCostoAcumulado(0);
                    miNodo.setFuncionHeuristica(0);
                    miNodo.setPadre(null);
                    miNodo.setNivel(0);
                    miNodo.setCerrado(false);
                    miNodo.setTiempo(100);
                }
            }
        });

        boton5 = new JButton("Pruebas");
        panel2.add(boton5);
        boton5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                comenzarPruebas();
            }

        });

        graph.getModel().beginUpdate();
        Object parent = graph.getDefaultParent();

        //A partir de acá se le da forma y opciones a los componentes de la ventana.
        //Estilo a los nodos del gráfico.
        Map<String, Object> style = graph.getStylesheet().getDefaultVertexStyle();
        style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        style.put(mxConstants.STYLE_ROUNDED, true);
        style.put(mxConstants.STYLE_FILLCOLOR, "#99ff99");
        style.put(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_BOLD);
        style.put(mxConstants.STYLE_FONTCOLOR, "black");
        style.put(mxConstants.STYLE_FONTSIZE, 12);

        //Estilo a las aristas del gráfico
        Map<String, Object> edgeStyle = graph.getStylesheet().getDefaultEdgeStyle();
        edgeStyle.put(mxConstants.STYLE_ENDARROW, "none");
        edgeStyle.put(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_BOLD);
        edgeStyle.put(mxConstants.STYLE_FONTCOLOR, "black");
        edgeStyle.put(mxConstants.STYLE_FONTSIZE, 12);

        //No permite que los nodos puedan modificarse su nombre/contenido.
        graph.setCellsEditable(false);
        //No permite que los nodos puedan modificarse en cuanto a tamaño.
        graph.setCellsResizable(false);
        //No permite que los nodos puedan conectarse manualmente.
        graphComponent.setConnectable(false);
        //No permite que las aristas puedan desconectarse manualmente.
        graph.setAllowDanglingEdges(false);

        graph.getModel().endUpdate();
    }

    //Obtiene el objeto que estamos seleccionando en pantalla, y devuelve el mismo.
    public Object getCellSeleccionado() {
        Object cell = null;
        cell = getGrafo().getSelectionCell();
        return cell;
    }

    /*Método utilizado para restablecer F' de nodos luego de una sobre o subestimación.*/
    public void restablecerFdeNodos() {
        if (isSobrestimacion) {
            for (Nodo nodo : miControlador.getMisNodos()) {
                System.out.println("El nodo " + nodo.getNombreNodo() + " tiene una f' = " + nodo.getDlr());
                nodo.setDlr(nodo.getDlr() - nodo.getVariacionParaPruebas());
                System.out.println("Y tiene una f' original = " + nodo.getDlr());
                isSobrestimacion = false;
            }
        }
        if (isSubestimacion) {
            for (Nodo nodo : miControlador.getMisNodos()) {
                System.out.println("El nodo " + nodo.getNombreNodo() + " tiene una f' = " + nodo.getDlr());
                nodo.setDlr(nodo.getDlr() + nodo.getVariacionParaPruebas());
                System.out.println("Y tiene una f' original = " + nodo.getDlr());
                isSobrestimacion = false;
            }
        }
    }

    /*Método utilizado para comenzar con las pruebas deseadas*/
    public void comenzarPruebas() {
        restablecerFdeNodos();

        /*Cargamos el grafo de prueba.*/
        miControlador.ejercicioDePrueba();

        /*Definimos las diferentes opciones a considerar.*/
        int valor = JOptionPane.showOptionDialog(null, "Elija una opción.", "Pruebas.",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Sobrestimar", "Subestimar", "Volver"}, "opcion 1");

        int valorAleatorio = 0;
        String textoMostrado = "Los nuevos f' de cada nodo son: \n";

        switch (valor) {
            case 0:
                isSobrestimacion = true;
                for (Nodo miNodo : miControlador.getMisNodos()) {
                    if (!miNodo.isFin()) {
                        valorAleatorio = (int) (50 * Math.random() + 1);
                        miNodo.setVariacionParaPruebas(valorAleatorio);
                        miNodo.setDlr(valorAleatorio + miNodo.getDlr());
                    }
                    textoMostrado = textoMostrado + "El nodo " + miNodo.getNombreNodo() + " tiene ahora un F': "
                                + miNodo.getDlr() + "\n";
                }
                break;
            case 1:
                isSubestimacion = true;
                for (Nodo miNodo : miControlador.getMisNodos()) {
                    if (!miNodo.isFin()) {
                        valorAleatorio = (int) (miNodo.getDlr() * Math.random());
                        miNodo.setVariacionParaPruebas(valorAleatorio);
                        miNodo.setDlr(miNodo.getDlr() - valorAleatorio);
                    }
                    textoMostrado = textoMostrado + "El nodo " + miNodo.getNombreNodo() + " tiene ahora un F': "
                                + miNodo.getDlr() + "\n";
                }
                break;
            case 2:
        }
        if (valor == 0 || valor == 1) {
            llamarVentanaGrafoSolucion();
            MostrarTextoEnPantalla miVentana2 = new MostrarTextoEnPantalla(textoMostrado);
            miVentana2.setLocation(10, 50);
            miVentana2.setVisible(true);
        }
    }
    
    
    public void llamarVentanaGrafoSolucion(){
        boolean flag = true;
        String nodoInicio = "error", nodoFin = "error";
        boolean inicio = false, fin = false;
        
        for (Nodo miNodo : miControlador.getMisNodos()) {
            if (miNodo.isInicio()) {
                inicio = true;
                nodoInicio = miNodo.getNombreNodo();
            }
            if (miNodo.isFin()) {
                fin = true;
                nodoFin = miNodo.getNombreNodo();
            }
        }
        
        if (inicio && fin) {
            for (Nodo nodo : miControlador.getMisNodos()) {
                if (nodo.getAristas().size() == 0) {
                    flag = false;
                }
            }

            if (flag && !nodoInicio.equals("error") && !nodoFin.equals("error")) {
                VentanaGrafoSolucion miVentana = new VentanaGrafoSolucion(miControlador, nodoInicio, nodoFin);
                miVentana.inicializarVentana();
                miVentana.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, verifique que no haya nodos desconectados.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, verifique que se hayan insertado los nodos de inicio y fin");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
