package Vista;
import Controlador.*;
import Modelo.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;

public class BusquedaHeuristica extends javax.swing.JFrame {

    private ControladorPrincipal miControladorPrincipal;
    private int xx, yy;
    private boolean inicio = false, fin = false;
    
    public BusquedaHeuristica(ControladorPrincipal miControladorPrincipal) {
        initComponents();
        setLocationRelativeTo(null);
        this.miControladorPrincipal = miControladorPrincipal;
        this.cargarComboBox();
    }

    public void cargarComboBox() {
        for (Nodo miNodo : miControladorPrincipal.getMisNodos()) {
            if (miNodo.isInicio()) {
                origenComboBox.addItem(miNodo.getNombreNodo());
                inicio = true;
            }
            if (miNodo.isFin()) {
                destinoComboBox.addItem(miNodo.getNombreNodo());
                fin = true;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        volver = new javax.swing.JButton();
        empezarBusqueda = new javax.swing.JButton();
        origen = new javax.swing.JLabel();
        destino = new javax.swing.JLabel();
        origenComboBox = new javax.swing.JComboBox<>();
        destinoComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        empezarBusqueda.setText("Empezar");
        empezarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empezarBusquedaActionPerformed(evt);
            }
        });

        origen.setText("Origen");

        destino.setText("Destino");

        destinoComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                destinoComboBoxKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(origen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(destino)
                .addGap(67, 67, 67))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(empezarBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(origenComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(origen)
                    .addComponent(destino))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(origenComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volver)
                    .addComponent(empezarBusqueda))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void empezarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empezarBusquedaActionPerformed
        boolean flag = true;
        
        if (inicio && fin) {
            for (Nodo nodo : miControladorPrincipal.getMisNodos()) {
                if (nodo.getAristas().size() == 0) {
                    flag = false;
                }
            }

            if (flag) {
                VentanaGrafoSolucion miVentana = new VentanaGrafoSolucion(miControladorPrincipal,
                        origenComboBox.getSelectedItem().toString(),
                        destinoComboBox.getSelectedItem().toString());
                miVentana.inicializarVentana();
                miVentana.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, verifique que no haya nodos desconectados.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, verifique que se hayan insertado los nodos de inicio y fin");
        }
    }//GEN-LAST:event_empezarBusquedaActionPerformed

    private void destinoComboBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_destinoComboBoxKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            empezarBusqueda.doClick();
        }
        if (cTeclaPresionada == KeyEvent.VK_ESCAPE) {
            volver.doClick();
        }
    }//GEN-LAST:event_destinoComboBoxKeyTyped

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x, y;
        x = evt.getXOnScreen();
        y = evt.getYOnScreen();
        
        setLocation(x - xx, y - yy);
    }//GEN-LAST:event_jPanel1MouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel destino;
    private javax.swing.JComboBox<String> destinoComboBox;
    private javax.swing.JButton empezarBusqueda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel origen;
    private javax.swing.JComboBox<String> origenComboBox;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
