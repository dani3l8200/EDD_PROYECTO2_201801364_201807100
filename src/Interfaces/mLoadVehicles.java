/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import Vehicle.Vehicle;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.AVehiculos;
//import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.tree;
import edd_proyecto2_201801364_201807100.ImpresoraDot;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author dani3l8200
 */
public class mLoadVehicles extends javax.swing.JFrame {

    /**
     * Creates new form mLoadVehicles
     */
    public mLoadVehicles() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.blue);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".txt","txt");
        jFileChooser1.setFileFilter(filtro);
        jFileChooser1.setAcceptAllFileFilterUsed(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("GRAFICA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(188, 188, 188))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        String comando = evt.getActionCommand();
       if(comando.equals(JFileChooser.APPROVE_SELECTION)){
           File ar = jFileChooser1.getSelectedFile();
           try {
               BufferedReader leer = new BufferedReader(new FileReader(ar.getAbsolutePath()));
               
               String linea = "";
               while((linea = leer.readLine()) != null){
                   String[] datos = linea.split(";");
                   String[] partes = datos[0].split(":");
                   
             
                   
                
                   AVehiculos.insert(new Vehicle(partes[0], partes[1], partes[2],Integer.parseInt(partes[3]) , partes[4], partes[5], partes[6]));
                   
               }
               JOptionPane.showMessageDialog(null, "Llenado de Clientes Exitoso", "Clientes",JOptionPane.INFORMATION_MESSAGE);
           } catch (Exception e) {
                System.out.println(e.getMessage());
           } 
       }else if(comando.equals(JFileChooser.CANCEL_SELECTION)){
            dispose();
            MenuVehiculos menuv = new MenuVehiculos();
            menuv.setVisible(true);
        }
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
        // graphviz.Imprimir("Btree", tree.GenerateReportTreeB());
        System.out.println(AVehiculos);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
