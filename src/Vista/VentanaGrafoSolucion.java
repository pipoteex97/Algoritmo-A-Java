package Vista;

import Controlador.*;
import Modelo.*;
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

public class VentanaGrafoSolucion extends javax.swing.JFrame {
    
    private static mxGraph graph2 = new mxGraph();
    private mxGraphComponent graphComponent2 = new mxGraphComponent(graph2);
    private ControladorPrincipal miControlador;
    private ControladorAlgoritmo miControladorAlgoritmo;
    private JButton boton1, boton2, boton3, boton4, boton5;
    private ArrayList<Nodo> caminoSolucion;
    private String texto;
    private int tiempo = 0;
    private boolean flag = true, flagParaPruebas = false;
    
    public VentanaGrafoSolucion(ControladorPrincipal miControladorPrincipal, String origen, String destino) {
        setTitle("Solución Búsqueda Heurística A*");
        setSize(700, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setLocation(670, 0);
        this.miControlador = miControladorPrincipal;
        this.miControladorAlgoritmo = new ControladorAlgoritmo(miControladorPrincipal.getMisNodos(), 
                                                          miControladorPrincipal.getMisAristas(), this);
        /*Cuando se inicializa la ventanaGrafoSolución también se inicializa la búsqueda del camino solución.*/
        miControladorAlgoritmo.comienzoBusqueda(origen,destino);
        this.caminoSolucion = miControladorAlgoritmo.getCaminoSolucion();
        this.texto = miControladorAlgoritmo.devolverTexto();
    }

    public boolean isFlagParaPruebas() {
        return flagParaPruebas;
    }
    
    public void setFlagParaPruebas(boolean resultado){
        flagParaPruebas = resultado;
    }
    /*Metodo que devuelve el grafo en el que estamos trabajando.*/
    public static mxGraph getGrafo() {
        return graph2;
    }
    
    private JFrame getFrame(){
            return this;
    }
    
    public void inicializarVentana() {
        /*
        Para poder juntar tanto la ventana de grafos como los botones de interacción lo que hacemos es
        crear dos JPanel, en uno albergamos la ventana del grafo, y en otro los botones.
        Finalmente agregamos los dos paneles al Pane del JFrame y conseguimos unir las dos cosas.
        */
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        graphComponent2.setPreferredSize(new Dimension(670, 550));
        panel1.add(graphComponent2);
        getContentPane().add(panel1, BorderLayout.WEST);
        getContentPane().add(panel2, BorderLayout.SOUTH);
        
        /*Todos los botones fueron creados de la misma manera:
        Se los inicializa, se los agrega al segundo Panel, y se modifica su método cuando son presionados
        para que realicen la tarea que les pertenece a cada uno.*/
        boton1 = new JButton("Camino Solución");
        panel2.add(boton1);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
                tiempo = 0;
                miControladorAlgoritmo.añadirNodoSolucion(caminoSolucion);
            }
        });
        
        boton2 = new JButton("Árbol generado");
        panel2.add(boton2);
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
                tiempo = 0;
                miControladorAlgoritmo.setearNivelesInicio();
                miControladorAlgoritmo.dibujarArbol(caminoSolucion);
            }
        });
        
        
        boton3 = new JButton("Árbol generado por Tiempo");
        panel2.add(boton3);
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    miControladorAlgoritmo.limpiarVentanaGrafoSolucion();
                    flag = false;
                }
                int valor;
                /*Esto se usa para mostrar correctamente los tiempos, y solamente para eso*/
                if (tiempo == 0) {
                    valor = JOptionPane.showConfirmDialog(null, "¿Comenzar a mostrar tiempos?"
                                                          , "Tiempos en árbol generado",
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                } else{
                    valor = JOptionPane.showConfirmDialog(null, "¿Seguir mostrando tiempos? Tiempo actual " + (tiempo - 1)
                                                          , "Tiempos en árbol generado",
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                }
                
                if (valor == JOptionPane.YES_OPTION) {
                    miControladorAlgoritmo.dibujarArbolPorTiempo(tiempo);
                    tiempo ++;
                    System.out.println(tiempo + " este es el tiempo de ahora");
                    System.out.println(miControladorAlgoritmo.getTiempo() + " este es el tiempo del controlador");
                    if ( (tiempo - 2) == miControladorAlgoritmo.getTiempo()) {
                        miControladorAlgoritmo.setearNivelesInicio();
                        //miControladorAlgoritmo.limpiarVentanaGrafoSolucion();
                        tiempo = 0;
                        flag = true;
                        JOptionPane.showMessageDialog(null, "¡Finalizó el recorrido por tiempos!");
                    }else{
                        boton3.doClick();
                    }
                }
            }
        });
        
        
        boton4 = new JButton("Mostrar Tiempos");
        panel2.add(boton4);
        boton4.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarTextoEnPantalla miVentana = new MostrarTextoEnPantalla(texto);
                miVentana.setVisible(true);
            }
        });
        
        boton5 = new JButton("Volver");
        panel2.add(boton5);
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miControladorAlgoritmo.limpiarVentanaGrafoSolucion();
                dispose();
                if (flagParaPruebas) {
                    miControlador.hacerClickEnPruebas();
                    setFlagParaPruebas(false);
                }
            }
        });

        graph2.getModel().beginUpdate();

        Object parent = graph2.getDefaultParent();
        
        //A partir de acá se le da forma y opciones a los componentes de la ventana.
        
        //Estilo a los nodos del gráfico.
        Map<String, Object> style = graph2.getStylesheet().getDefaultVertexStyle();
        style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
        style.put(mxConstants.STYLE_ROUNDED, true);
        style.put(mxConstants.STYLE_FILLCOLOR, "#bba9bb");
        style.put(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_BOLD);
        style.put(mxConstants.STYLE_FONTCOLOR, "black");
        style.put(mxConstants.STYLE_FONTSIZE, 12);
        
        
        //Estilo a las aristas del gráfico
        Map<String, Object> edgeStyle = graph2.getStylesheet().getDefaultEdgeStyle();
        edgeStyle.put(mxConstants.STYLE_ENDARROW, "none");
        edgeStyle.put(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_BOLD);
        edgeStyle.put(mxConstants.STYLE_FONTCOLOR, "black");
        edgeStyle.put(mxConstants.STYLE_FONTSIZE, 12);
        
        //No permite que los nodos puedan modificarse su nombre/contenido.
        graph2.setCellsEditable(false);
        //No permite que los nodos puedan modificarse en cuanto a tamaño.
        graph2.setCellsResizable(false);
        //No permite que los nodos puedan conectarse manualmente.
        graphComponent2.setConnectable(false);
        //No permite que las aristas puedan desconectarse manualmente.
        graph2.setAllowDanglingEdges(false);
        //Los nodos no se pueden mover
        graph2.setCellsMovable(false);
        
        graph2.getModel().endUpdate();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}