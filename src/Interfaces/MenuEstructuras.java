/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Customers.HashTable;
import Rutas.Lista;
import Viajes.BlockChain;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.BCViajes;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.Impresora;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.MReportes;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.TClientes;
import java.awt.Image;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Barillas
 */
public class MenuEstructuras extends javax.swing.JFrame {

    /**
     * Creates new form MenuEstructuras
     */
    public MenuEstructuras() {
        initComponents();
        try {
            GenerarImagen();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MenuEstructuras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void GenerarImagen() throws NoSuchAlgorithmException{
        if(BCViajes == null){
            BCViajes = new BlockChain();
        }
        Impresora.Imprimir("General", Impresora.DotGeneral());
        Pintar();
    }
    
    public void Pintar(){
        Image ImagenGrafo = new ImageIcon("General").getImage();
        ImagenGrafo.flush();
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

        JButtonRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JLabelReporte = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JButtonRegresar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JButtonRegresar.setText("Regresar");
        JButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonRegresarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(JLabelReporte);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JButtonRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JButtonRegresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonRegresarActionPerformed
        if(MReportes==null){
            MReportes = new MenuReportes();
        }
        MReportes.setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(MenuEstructuras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuEstructuras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuEstructuras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuEstructuras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuEstructuras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonRegresar;
    private javax.swing.JLabel JLabelReporte;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
