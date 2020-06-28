package Vista;

import javax.swing.*;
import Controlador.*;
import java.util.*;
import Modelo.*;
import java.awt.event.KeyEvent;

public class InsertarArista extends javax.swing.JFrame {

    private ControladorPrincipal miControlador;
    private int xx, yy;
    
    public InsertarArista(ControladorPrincipal miControlador) {
        initComponents();
        setLocationRelativeTo(null);
        this.miControlador = miControlador;
        this.cargarComboBox();
    }
    
    
    public void cargarComboBox() {
        origenComboBox.addItem("");
        destinoComboBox.addItem("");
        for (Nodo miNodo : miControlador.getMisNodos()) {
            origenComboBox.addItem(miNodo.getNombreNodo());
            destinoComboBox.addItem(miNodo.getNombreNodo());
        }
    }
    
    
    public boolean validarNumero(String textoIngresado){
        try{
            int numero;
            numero = Integer.parseInt(textoIngresado);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        costoLabel = new javax.swing.JLabel();
        costoAristaTextField = new javax.swing.JTextField();
        nodoOrigenLabel = new javax.swing.JLabel();
        nodoDestinoLabel = new javax.swing.JLabel();
        volverButton = new javax.swing.JButton();
        origenComboBox = new javax.swing.JComboBox<>();
        destinoComboBox = new javax.swing.JComboBox<>();
        añadirAristaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

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
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel1KeyTyped(evt);
            }
        });

        costoLabel.setText("Costo");

        nodoOrigenLabel.setText("Nodo Origen");

        nodoDestinoLabel.setText("Nodo Destino");

        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        destinoComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                destinoComboBoxKeyTyped(evt);
            }
        });

        añadirAristaButton.setText("Añadir Arista");
        añadirAristaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirAristaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(origenComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(costoLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(costoAristaTextField)
                    .addComponent(nodoOrigenLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nodoDestinoLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(destinoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(añadirAristaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(costoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(costoAristaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(nodoOrigenLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(origenComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(nodoDestinoLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(añadirAristaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(destinoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void añadirAristaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirAristaButtonActionPerformed
        boolean resultado;
        boolean resultado2;
        
        resultado2 = validarNumero(costoAristaTextField.getText());
        if (resultado2) {
            if (origenComboBox.getSelectedItem().toString().equals("") || destinoComboBox.getSelectedItem().toString().equals("")
                    || origenComboBox.getSelectedItem().toString().equals(destinoComboBox.getSelectedItem().toString())) {
                resultado = false;
            } else {
                resultado = miControlador.añadirArista(costoAristaTextField.getText(),
                        origenComboBox.getSelectedItem().toString(),
                        destinoComboBox.getSelectedItem().toString());
            }
        }else{
            resultado = false;
        }
        
                                               
        if (resultado && resultado2) {
            JOptionPane.showMessageDialog(null, "Arista añadida con éxito");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo añadir la arista");
        }
    }//GEN-LAST:event_añadirAristaButtonActionPerformed

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        dispose();
    }//GEN-LAST:event_volverButtonActionPerformed

    private void jPanel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyTyped
        
    }//GEN-LAST:event_jPanel1KeyTyped

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        
    }//GEN-LAST:event_formKeyTyped

    private void destinoComboBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_destinoComboBoxKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            añadirAristaButton.doClick();
        }
        if (cTeclaPresionada == KeyEvent.VK_ESCAPE) {
            volverButton.doClick();
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
        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_jPanel1MouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirAristaButton;
    private javax.swing.JTextField costoAristaTextField;
    private javax.swing.JLabel costoLabel;
    private javax.swing.JComboBox<String> destinoComboBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nodoDestinoLabel;
    private javax.swing.JLabel nodoOrigenLabel;
    private javax.swing.JComboBox<String> origenComboBox;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
