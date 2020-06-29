//@author Dabs
package Interfaces;

import Customers.HashTable;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.TClientes;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.Impresora;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.Principal;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MenuClientes extends javax.swing.JFrame {

    /**
     * Creates new form MenuClientes
     */
    public MenuClientes() {
        initComponents();
        GenerarImagen();
        Pintar();
    }
    
    public void GenerarImagen(){
        if(TClientes == null){
            TClientes = new HashTable();
        }
        Impresora.Imprimir("Clientes", TClientes.GenerateReportTablaHash());
    }
    
    public void Pintar(){
        Image ImagenGrafo = new ImageIcon("Clientes.png").getImage();
        Icon Icono = new ImageIcon(ImagenGrafo);
        JLabelReporte.setIcon(Icono);
        JLabelReporte.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JComboBoxAccion = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTextFieldDPI = new javax.swing.JTextField();
        JTextFieldNombres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JTextFieldApellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JTextFieldGenero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JTextFieldTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JTextFieldTelefono1 = new javax.swing.JTextField();
        JButtonAccion = new javax.swing.JButton();
        JButtonRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JLabelReporte = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JComboBoxAccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agregar", "Modificar", "Eliminar", "Mostrar", "Carga Masiva" }));
        JComboBoxAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxAccionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("------Clientes------");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Accion:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("DPI:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nombres:");

        JTextFieldDPI.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        JTextFieldNombres.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Apellidos:");

        JTextFieldApellidos.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Genero:");

        JTextFieldGenero.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        JTextFieldGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextFieldGeneroActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Telefono:");

        JTextFieldTelefono.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        JTextFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextFieldTelefonoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Direccion:");

        JTextFieldTelefono1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        JTextFieldTelefono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextFieldTelefono1ActionPerformed(evt);
            }
        });

        JButtonAccion.setText("Realizar");

        JButtonRegresar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JButtonRegresar.setText("Regresar");
        JButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonRegresarActionPerformed(evt);
            }
        });

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setViewportView(JLabelReporte);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JButtonRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(3, 3, 3)
                                .addComponent(JTextFieldTelefono1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTextFieldApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTextFieldGenero))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTextFieldTelefono))
                            .addComponent(JButtonAccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTextFieldNombres)
                                    .addComponent(JTextFieldDPI)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JComboBoxAccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JComboBoxAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JButtonAccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(JTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(JTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(JTextFieldTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JButtonRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JComboBoxAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxAccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboBoxAccionActionPerformed

    private void JTextFieldGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextFieldGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextFieldGeneroActionPerformed

    private void JTextFieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextFieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextFieldTelefonoActionPerformed

    private void JTextFieldTelefono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextFieldTelefono1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextFieldTelefono1ActionPerformed

    private void JButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonRegresarActionPerformed
        Principal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JButtonRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonAccion;
    private javax.swing.JButton JButtonRegresar;
    private javax.swing.JComboBox<String> JComboBoxAccion;
    private javax.swing.JLabel JLabelReporte;
    private javax.swing.JTextField JTextFieldApellidos;
    private javax.swing.JTextField JTextFieldDPI;
    private javax.swing.JTextField JTextFieldGenero;
    private javax.swing.JTextField JTextFieldNombres;
    private javax.swing.JTextField JTextFieldTelefono;
    private javax.swing.JTextField JTextFieldTelefono1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
