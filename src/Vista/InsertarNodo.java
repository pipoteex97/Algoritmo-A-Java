package Vista;

import javax.swing.*;
import Controlador.*;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class InsertarNodo extends javax.swing.JFrame {

    private ControladorPrincipal miControlador;
    private int xx, yy;

    public InsertarNodo(ControladorPrincipal miControlador) {
        initComponents();
        setLocationRelativeTo(null);
        this.miControlador = miControlador;
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
        nodosMultiplesCheckBox = new javax.swing.JCheckBox();
        cantNodosComboBox = new javax.swing.JComboBox<>();
        nombreNodoTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        añadirNodoButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        heuristicaTextField = new javax.swing.JTextField();
        inicioCheckBox = new javax.swing.JCheckBox();
        finCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        nodosMultiplesCheckBox.setText("Añadir múltiples nodos");
        nodosMultiplesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nodosMultiplesCheckBoxActionPerformed(evt);
            }
        });

        cantNodosComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "15", "20" }));
        cantNodosComboBox.setEnabled(false);
        cantNodosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantNodosComboBoxActionPerformed(evt);
            }
        });

        nombreNodoTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreNodoTextFieldKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombe de Nodo");

        añadirNodoButton.setText("Añadir Nodo/s");
        añadirNodoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirNodoButtonActionPerformed(evt);
            }
        });

        volverButton.setText("Volver");
        volverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Heurística");

        heuristicaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                heuristicaTextFieldKeyTyped(evt);
            }
        });

        inicioCheckBox.setText("Es el nodo de inicio");
        inicioCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioCheckBoxActionPerformed(evt);
            }
        });

        finCheckBox.setText("Es el nodo destino");
        finCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(añadirNodoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(heuristicaTextField)
                                    .addComponent(nombreNodoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inicioCheckBox, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(finCheckBox, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(nodosMultiplesCheckBox)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cantNodosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nodosMultiplesCheckBox)
                            .addComponent(nombreNodoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inicioCheckBox))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(heuristicaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(volverButton)
                            .addComponent(añadirNodoButton))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(cantNodosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void añadirNodoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirNodoButtonActionPerformed
        boolean resultado = false;
        boolean resultado2 = false;
        
        resultado2 = validarNumero(heuristicaTextField.getText());

        /*Observamos si el CheckBox está activado, de ser así el usuario desea ingresar más de 1 un nodo
        y todo esto de manera automática*/
        if (nodosMultiplesCheckBox.isSelected()) {
            int cantidadNodos = Integer.parseInt(cantNodosComboBox.getSelectedItem().toString());
            int posicionX = 50, posicionY = 50;

            /*Creamos un vector de tipo "char" que va sirve para determinar todas las letras que se asignan
            a los nodos de manera automática*/
            char[] alfabeto = new char[26];
            alfabeto[0] = 'A';
            
            /*
            Valor de la heurística aleatorio.
            */
            int numero = (int) (Math.random() * 50) + 1;
            
            resultado = miControlador.añadirNodo(String.valueOf(alfabeto[0]), numero, posicionX, posicionY, false, false);
            for (int i = 1; i < cantidadNodos; i++) {
                /*Se ingresa el nodo nuevo, el primer nodo se llamará "A", el seguno "B", y así
                sucesivamente*/
                alfabeto[i] = (char) ('A' + i);
                posicionX = posicionX + 120;
                if (posicionX > 599) {
                    posicionX = 50;
                    posicionY = posicionY + 120;
                }
                numero = (int) (Math.random() * 50) + 1;
                resultado = miControlador.añadirNodo(String.valueOf(alfabeto[i]), numero, posicionX, posicionY, false, false);
            }
        } else {
            if (heuristicaTextField.getText().equals("") || !resultado2) {
                JOptionPane.showMessageDialog(null, "Por favor, verifique todos los valores ingresados.");
            }else{
                boolean esInicio = inicioCheckBox.isSelected();
                boolean esFin = finCheckBox.isSelected();
                
                resultado = miControlador.añadirNodo(nombreNodoTextField.getText(), Integer.parseInt(heuristicaTextField.getText()), 
                                          miControlador.getPosX(), miControlador.getPosY(), esInicio, esFin);
                
            }
            
        }

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Nodo añadido con éxito");
            if (miControlador.getPosX() > 599) {
                    miControlador.setPosX(0);
                    miControlador.setPosY(miControlador.getPosY() + 120);
                }
                if (miControlador.getPosY() > 599) {
                    miControlador.setPosY(0);
                    miControlador.setPosX(0);
                }
                miControlador.setPosX(miControlador.getPosX() + 120);
        } else {
            JOptionPane.showMessageDialog(null, "Error en el añadido del nodo");
        }

    }//GEN-LAST:event_añadirNodoButtonActionPerformed

    private void volverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverButtonActionPerformed
        dispose();
    }//GEN-LAST:event_volverButtonActionPerformed

    private void cantNodosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantNodosComboBoxActionPerformed

    }//GEN-LAST:event_cantNodosComboBoxActionPerformed

    private void nodosMultiplesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nodosMultiplesCheckBoxActionPerformed
        if (nodosMultiplesCheckBox.isSelected()) {
            inicioCheckBox.setEnabled(false);
            finCheckBox.setEnabled(false);
            nombreNodoTextField.setEnabled(false);
            heuristicaTextField.setEnabled(false);
            cantNodosComboBox.setEnabled(true);
        } else {
            inicioCheckBox.setEnabled(true);
            finCheckBox.setEnabled(true);
            nombreNodoTextField.setEnabled(true);
            heuristicaTextField.setEnabled(true);
            cantNodosComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_nodosMultiplesCheckBoxActionPerformed

    private void nombreNodoTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreNodoTextFieldKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            añadirNodoButton.doClick();
        }
        if (cTeclaPresionada == KeyEvent.VK_ESCAPE) {
            volverButton.doClick();
        }
    }//GEN-LAST:event_nombreNodoTextFieldKeyTyped

    private void heuristicaTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_heuristicaTextFieldKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            añadirNodoButton.doClick();
        }
        if (cTeclaPresionada == KeyEvent.VK_ESCAPE) {
            volverButton.doClick();
        }
    }//GEN-LAST:event_heuristicaTextFieldKeyTyped

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

    private void inicioCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioCheckBoxActionPerformed
        if (inicioCheckBox.isSelected()) {
            finCheckBox.setEnabled(false);
        }else{
            finCheckBox.setEnabled(true);
        }
    }//GEN-LAST:event_inicioCheckBoxActionPerformed

    private void finCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finCheckBoxActionPerformed
        if (finCheckBox.isSelected()) {
            inicioCheckBox.setEnabled(false);
        }else{
            inicioCheckBox.setEnabled(true);
        }
    }//GEN-LAST:event_finCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirNodoButton;
    private javax.swing.JComboBox<String> cantNodosComboBox;
    private javax.swing.JCheckBox finCheckBox;
    private javax.swing.JTextField heuristicaTextField;
    private javax.swing.JCheckBox inicioCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox nodosMultiplesCheckBox;
    private javax.swing.JTextField nombreNodoTextField;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables
}
