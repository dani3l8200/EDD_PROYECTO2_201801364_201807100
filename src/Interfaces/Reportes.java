/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.BCViajes;

/**
 *
 * @author Barillas
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    public Reportes() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelReporte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JComboBoxReporte = new javax.swing.JComboBox<>();
        JButtonHuffman = new javax.swing.JButton();
        JButtonRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        JButtonCompleta = new javax.swing.JButton();
        JVerifyAction = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout JPanelReporteLayout = new javax.swing.GroupLayout(JPanelReporte);
        JPanelReporte.setLayout(JPanelReporteLayout);
        JPanelReporteLayout.setHorizontalGroup(
            JPanelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        JPanelReporteLayout.setVerticalGroup(
            JPanelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("-------Reportes-------");

        JComboBoxReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Top 10 Viajes Mas Largos", "Top 10 Clientes Con Mas Viajes", "Top 10 Conductores Con Mas Ingresos", "Top 10 Vehiculos", "Ruta De Viaje" }));
        JComboBoxReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBoxReporteActionPerformed(evt);
            }
        });

        JButtonHuffman.setText("Encriptar / Desencriptar");
        JButtonHuffman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonHuffmanActionPerformed(evt);
            }
        });

        JButtonRegresar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JButtonRegresar.setText("Regresar");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        JButtonCompleta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JButtonCompleta.setText("Ver Estructura Completa");
        JButtonCompleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCompletaActionPerformed(evt);
            }
        });

        JVerifyAction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Encode", "Decoder" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JComboBoxReporte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JButtonHuffman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 21, Short.MAX_VALUE))
                            .addComponent(JVerifyAction, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JPanelReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JButtonRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JButtonCompleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JComboBoxReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JVerifyAction, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JButtonHuffman, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JPanelReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JButtonCompleta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JButtonRegresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonCompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCompletaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JButtonCompletaActionPerformed

    private void JButtonHuffmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonHuffmanActionPerformed
       switch(JComboBoxReporte.getSelectedIndex()){
           case 0:{
               try {  
                    if(BCViajes != null){
                        if(JVerifyAction.getSelectedIndex() == 0){
                            BCViajes.GenerateReportTopViajes(true);
                    }else if(JVerifyAction.getSelectedIndex() == 1){
                       BCViajes.GenerateReportTopViajes(false);
                    }
               }
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }
               break;
           }
           case 1:{
               try {  
                    if(BCViajes != null){
                        if(JVerifyAction.getSelectedIndex() == 0){
                            BCViajes.GenerateReportTopCustomers(true);
                    }else if(JVerifyAction.getSelectedIndex() == 1){
                       BCViajes.GenerateReportTopCustomers(false);
                    }
               }
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }
               break;
           }
           case 2:{
               try {  
                    if(BCViajes != null){
                        if(JVerifyAction.getSelectedIndex() == 0){
                            BCViajes.GenerateReportTopDrivers(true);
                    }else if(JVerifyAction.getSelectedIndex() == 1){
                       BCViajes.GenerateReportTopDrivers(false);
                    }
               }
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }
               break;
           }
           case 3:{
               try {  
                    if(BCViajes != null){
                        if(JVerifyAction.getSelectedIndex() == 0){
                            BCViajes.GenerateReportTopVehicles(true);
                    }else if(JVerifyAction.getSelectedIndex() == 1){
                       BCViajes.GenerateReportTopVehicles(false);
                    }
               }
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }
               break;
           }
           default:
               break;
       }
    }//GEN-LAST:event_JButtonHuffmanActionPerformed

    private void JComboBoxReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboBoxReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboBoxReporteActionPerformed

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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonCompleta;
    private javax.swing.JButton JButtonHuffman;
    private javax.swing.JButton JButtonRegresar;
    private javax.swing.JComboBox<String> JComboBoxReporte;
    private javax.swing.JPanel JPanelReporte;
    private javax.swing.JComboBox<String> JVerifyAction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
