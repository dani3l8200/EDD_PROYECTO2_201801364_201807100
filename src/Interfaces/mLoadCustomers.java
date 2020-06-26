/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import Customers.Customers;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.hashtTable;
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
public class mLoadCustomers extends javax.swing.JFrame {

    /**
     * Creates new form mLoadCustomers
     */
    public mLoadCustomers() {
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
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jButton1)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
       String comando = evt.getActionCommand();
       if(comando.equals(JFileChooser.APPROVE_SELECTION)){
           File ar = jFileChooser1.getSelectedFile();
           try {
               BufferedReader leer = new BufferedReader(new FileReader(ar.getAbsolutePath()));
               
               String linea = leer.readLine();
               while(linea != null){
                   String[] partes = linea.split("[,]+|;");
                   
                   String dpi = partes[0], name = partes[1], last_name = partes[2], gender = partes[3],
                           date = partes[4], phone = partes[5],direcction = partes[6];
                   
                   Customers s = new Customers(dpi,name,last_name,gender,date,Integer.parseInt(phone),direcction);
                   hashtTable.InsertNode(s);
                   linea = leer.readLine();
               }
               JOptionPane.showMessageDialog(null, "Llenado de Clientes Exitoso", "Clientes",JOptionPane.INFORMATION_MESSAGE);
           } catch (Exception e) {
                System.out.println(e.getMessage());
           } 
       }else if(comando.equals(JFileChooser.CANCEL_SELECTION)){
            dispose();
            
        }
       
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ImpresoraDot graphviz = new ImpresoraDot();
        graphviz.Imprimir("tablaHash",hashtTable.GenerateReportTablaHash());
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}