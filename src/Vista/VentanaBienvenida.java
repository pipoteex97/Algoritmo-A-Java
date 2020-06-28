package Vista;

import java.awt.Font;
import javax.swing.*;
import Main.*;

public class VentanaBienvenida extends javax.swing.JFrame {
    
    private Main miMain = new Main();
    private int numeroPanel = 0;
    
    public VentanaBienvenida() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Trabajo final Inteligencia Artificial I - Grupo 4.");
        setLayout(null);
        inicializarVentana();
    }
    
    public void inicializarVentana(){
        anteriorJButton.setEnabled(false);
        miPanel1.setVisible(false);
        miPanel2.setVisible(false);
        miPanel3.setVisible(false);
        miPanel4.setVisible(false);
        miPanel5.setVisible(false);
        miPanel6.setVisible(false);
        miPanelFinal.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bienvenidoJLabel = new javax.swing.JLabel();
        siguienteJButton = new javax.swing.JButton();
        anteriorJButton = new javax.swing.JButton();
        saltarIntroJButton = new javax.swing.JButton();
        miPanelFinal = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        miPanel6 = new javax.swing.JPanel();
        sinDestinoJLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        miPanel5 = new javax.swing.JPanel();
        nodoSinConexionJLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        miPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaPanel0 = new javax.swing.JTextArea();
        miPanel4 = new javax.swing.JPanel();
        botones3JLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        miPanel2 = new javax.swing.JPanel();
        botones1JLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        miPanel3 = new javax.swing.JPanel();
        botones2JLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        imagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bienvenidoJLabel.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        bienvenidoJLabel.setForeground(new java.awt.Color(240, 240, 240));
        bienvenidoJLabel.setText("Bienvenido");
        getContentPane().add(bienvenidoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        siguienteJButton.setText("Siguiente");
        siguienteJButton.setPreferredSize(new java.awt.Dimension(87, 23));
        siguienteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(siguienteJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 87, -1));

        anteriorJButton.setText("Anterior");
        anteriorJButton.setPreferredSize(new java.awt.Dimension(87, 23));
        anteriorJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(anteriorJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 87, -1));

        saltarIntroJButton.setText("Saltar Intro");
        saltarIntroJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saltarIntroJButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saltarIntroJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jTextArea5.setEditable(false);
        jTextArea5.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextArea5.setRows(5);
        jTextArea5.setText("                   ¡Comenzamos!\n\nSin más que agregar, gracias por ver\nlas instrucciones. \n\n                   ¿Consultas?\nrodriguezrodrigo127@gmail.com\nfernandoegondallierdt@gmail.com\ngoofy_2009@hotmail.com");
        jScrollPane6.setViewportView(jTextArea5);

        javax.swing.GroupLayout miPanelFinalLayout = new javax.swing.GroupLayout(miPanelFinal);
        miPanelFinal.setLayout(miPanelFinalLayout);
        miPanelFinalLayout.setHorizontalGroup(
            miPanelFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        miPanelFinalLayout.setVerticalGroup(
            miPanelFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        getContentPane().add(miPanelFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 250, 150));

        sinDestinoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sinDestino (1).jpg"))); // NOI18N

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextArea4.setRows(5);
        jTextArea4.setText("No se permite iniciar la búsqueda sin\nun nodo de inicio o de destino.\nTampoco se permite elegir otros nodos\nfuera de los establecidos anteriormente.");
        jScrollPane5.setViewportView(jTextArea4);

        javax.swing.GroupLayout miPanel6Layout = new javax.swing.GroupLayout(miPanel6);
        miPanel6.setLayout(miPanel6Layout);
        miPanel6Layout.setHorizontalGroup(
            miPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sinDestinoJLabel)
                .addGap(68, 68, 68))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, miPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
        miPanel6Layout.setVerticalGroup(
            miPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sinDestinoJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        getContentPane().add(miPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 290, 200));

        nodoSinConexionJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nodoSinConexion.PNG"))); // NOI18N

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 255));
        jTextField1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextField1.setText("No se permiten nodos sin conexiones.");

        javax.swing.GroupLayout miPanel5Layout = new javax.swing.GroupLayout(miPanel5);
        miPanel5.setLayout(miPanel5Layout);
        miPanel5Layout.setHorizontalGroup(
            miPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(miPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addGroup(miPanel5Layout.createSequentialGroup()
                        .addComponent(nodoSinConexionJLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        miPanel5Layout.setVerticalGroup(
            miPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanel5Layout.createSequentialGroup()
                .addComponent(nodoSinConexionJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        getContentPane().add(miPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 290, 200));

        miPanel1.setBackground(new java.awt.Color(204, 204, 255));

        textAreaPanel0.setEditable(false);
        textAreaPanel0.setBackground(new java.awt.Color(204, 204, 255));
        textAreaPanel0.setColumns(20);
        textAreaPanel0.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        textAreaPanel0.setRows(5);
        textAreaPanel0.setText("        Bienvenido a nuestra aplicación. \n\nSomos el Grupo 4 dentro de la cátedra de \nInteligencia Artificial I. \n\nNuestro Grupo se encuentra conformado \npor Gondallier  Fernando, Martínez Martín, \ny Rodríguez Rodrigo. \n\nA continuación daremos una explicación \ndel modo de uso  de nuestra aplicación.");
        textAreaPanel0.setFocusCycleRoot(true);
        jScrollPane1.setViewportView(textAreaPanel0);

        javax.swing.GroupLayout miPanel1Layout = new javax.swing.GroupLayout(miPanel1);
        miPanel1.setLayout(miPanel1Layout);
        miPanel1Layout.setHorizontalGroup(
            miPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );
        miPanel1Layout.setVerticalGroup(
            miPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        getContentPane().add(miPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 290, 200));

        botones3JLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botones3.PNG"))); // NOI18N

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText("El botón Búsqueda permite inicializar\nel Algoritmo A*. Se toman los nodos de\ninicio y destino creados con anterioridad.\n\nEl botón pruebas permite al usuario\nrealizar pruebas de subestimación y \nsobrestimación sobre diferentes\nejercicios.\nSin embargo, existen ciertos casos que\nno permiten ejecucar estas funciones:");
        jScrollPane4.setViewportView(jTextArea3);

        javax.swing.GroupLayout miPanel4Layout = new javax.swing.GroupLayout(miPanel4);
        miPanel4.setLayout(miPanel4Layout);
        miPanel4Layout.setHorizontalGroup(
            miPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(botones3JLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );
        miPanel4Layout.setVerticalGroup(
            miPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botones3JLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
        );

        getContentPane().add(miPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 290, 210));

        botones1JLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botones1.PNG"))); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Estos dos botones son los utilizados para\ncargar el grafo inicial.\n\nConsideraciones: Puede existir un único \nnodo tanto de inicio como de destino. \nAdemás, no se permiten agregar nodos\ncon nombres repetidos.\nLas aristas, por su parte, permiten \nsolamente valores numéricos enteros.");
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout miPanel2Layout = new javax.swing.GroupLayout(miPanel2);
        miPanel2.setLayout(miPanel2Layout);
        miPanel2Layout.setHorizontalGroup(
            miPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(botones1JLabel)
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        miPanel2Layout.setVerticalGroup(
            miPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botones1JLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        );

        getContentPane().add(miPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 290, 200));

        miPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        botones2JLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/botones2.PNG"))); // NOI18N

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("Con respecto a Eliminar Elemento, permite\nborrar del grafo tanto un nodo como una\narista. Para ello, el elemento en cuestión\ndebe ser seleccionada primeramente.\n\nGestionar Ventana da la posibilidad de\ncargar en la ventana algunos ejercicios\nprecargadaos, como así también eliminar\ntodos los elementos en pantalla de una\nmanera rápida y sencilla.");
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout miPanel3Layout = new javax.swing.GroupLayout(miPanel3);
        miPanel3.setLayout(miPanel3Layout);
        miPanel3Layout.setHorizontalGroup(
            miPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanel3Layout.createSequentialGroup()
                .addComponent(botones2JLabel)
                .addGap(0, 1, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        miPanel3Layout.setVerticalGroup(
            miPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanel3Layout.createSequentialGroup()
                .addComponent(botones2JLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
        );

        getContentPane().add(miPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 290, 210));

        imagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inteligencia-artificial 2.jpg"))); // NOI18N
        getContentPane().add(imagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteJButtonActionPerformed
        numeroPanel ++;
        anteriorJButton.setEnabled(true);
        switch(numeroPanel){
            case 1:
                miPanel1.setVisible(true);
                break;
            case 2:
                miPanel1.setVisible(false);
                miPanel2.setVisible(true);
                break;
            case 3:
                miPanel2.setVisible(false);
                miPanel3.setVisible(true);
                break;
            case 4:
                miPanel3.setVisible(false);
                miPanel4.setVisible(true);
                break;
            case 5:
                miPanel4.setVisible(false);
                miPanel5.setVisible(true);
                break;
            case 6:
                miPanel5.setVisible(false);
                miPanel6.setVisible(true);
                break;
            case 7:
                siguienteJButton.setEnabled(false);
                miPanel6.setVisible(false);
                miPanelFinal.setVisible(true);
                break;
        }
    }//GEN-LAST:event_siguienteJButtonActionPerformed

    private void saltarIntroJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saltarIntroJButtonActionPerformed
        miMain.empezarAplicacion();
        dispose();
    }//GEN-LAST:event_saltarIntroJButtonActionPerformed

    private void anteriorJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorJButtonActionPerformed
        numeroPanel --;
        siguienteJButton.setEnabled(true);
        if (numeroPanel == 0) {
            miPanel1.setVisible(false);
            anteriorJButton.setEnabled(false);
        }
        else{
            anteriorJButton.setEnabled(true);
        }
        switch(numeroPanel){
            case 1:
                miPanel1.setVisible(true);
                miPanel2.setVisible(false);
                break;
            case 2:
                miPanel2.setVisible(true);
                miPanel3.setVisible(false);
                break;
            case 3:
                miPanel3.setVisible(true);
                miPanel4.setVisible(false);
                break;
            case 4:
                miPanel4.setVisible(true);
                miPanel5.setVisible(false);
                break;
            case 5:
                miPanel5.setVisible(true);
                miPanel6.setVisible(false);
                break;
            case 6:
                miPanel6.setVisible(true);
                miPanelFinal.setVisible(false);
                break;
        }
    }//GEN-LAST:event_anteriorJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anteriorJButton;
    private javax.swing.JLabel bienvenidoJLabel;
    private javax.swing.JLabel botones1JLabel;
    private javax.swing.JLabel botones2JLabel;
    private javax.swing.JLabel botones3JLabel;
    private javax.swing.JLabel imagenFondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel miPanel1;
    private javax.swing.JPanel miPanel2;
    private javax.swing.JPanel miPanel3;
    private javax.swing.JPanel miPanel4;
    private javax.swing.JPanel miPanel5;
    private javax.swing.JPanel miPanel6;
    private javax.swing.JPanel miPanelFinal;
    private javax.swing.JLabel nodoSinConexionJLabel;
    private javax.swing.JButton saltarIntroJButton;
    private javax.swing.JButton siguienteJButton;
    private javax.swing.JLabel sinDestinoJLabel;
    private javax.swing.JTextArea textAreaPanel0;
    // End of variables declaration//GEN-END:variables
}
