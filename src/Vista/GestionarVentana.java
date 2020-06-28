package Vista;
import Controlador.*;
import Modelo.*;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class GestionarVentana extends javax.swing.JFrame {

    private ControladorPrincipal miControlador;
    private int xx,yy;
    
    public GestionarVentana(ControladorPrincipal miControlador) {
        initComponents();
        setLocationRelativeTo(null);
        this.miControlador = miControlador;
        cargarComboBox();
    }
    
    public void cargarComboBox() {
        opcionComboBox.addItem("Limpiar Ventana");
        opcionComboBox.addItem("Ejercicio de la Guía");
        opcionComboBox.addItem("Ejercicio de la Guía 2");
        opcionComboBox.addItem("Ejercicio Clase 1");
        opcionComboBox.addItem("Ejercicio de Prueba");
        opcionComboBox.addItem("Ejercicio Para Pruebas");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        opcionComboBox = new javax.swing.JComboBox<>();
        aceptarButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        opcionComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                opcionComboBoxKeyPressed(evt);
            }
        });

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("¿Qué desea realizar?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(aceptarButton))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(opcionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(opcionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverButton)
                    .addComponent(aceptarButton))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        dispose();
    }//GEN-LAST:event_volverButtonActionPerformed

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

    private void opcionComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_opcionComboBoxKeyPressed
        char cTeclaPresionada = evt.getKeyChar();
        
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            aceptarButton.doClick();
        }
        if (cTeclaPresionada == KeyEvent.VK_ESCAPE) {
            volverButton.doClick();
        }
    }//GEN-LAST:event_opcionComboBoxKeyPressed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        String textoComboBox = opcionComboBox.getSelectedItem().toString();
        boolean flag = false;
        
        switch(textoComboBox){
            case "Limpiar Ventana": 
                miControlador.limpiarVentanaGrafo();
                flag = true;
                break;
            case "Ejercicio de la Guía":
                miControlador.ejercicioDeGuia();
                flag = true;
                break;
            case "Ejercicio Clase 1":
                miControlador.ejercicioClase1();
                flag = true;
                break;
            case "Ejercicio de la Guía 2":
                miControlador.ejercicioDeGuia2();
                flag = true;
                break;
            case "Ejercicio de Prueba":
                miControlador.ejercicioDePrueba();
                flag = true;
                break;
            case "Ejercicio Para Pruebas":
                miControlador.ejercicioParaPruebas();
                flag = true;
                break;
        }
        if (flag) {
            JOptionPane.showMessageDialog(null, "Finalizado con éxito.");
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Se ha producido un error.");
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> opcionComboBox;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
