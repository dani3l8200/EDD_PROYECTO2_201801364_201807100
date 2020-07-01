/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers;

import com.itextpdf.text.BaseColor;
import java.math.BigInteger;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/** 
 *
 * @author dani3l8200
 */
@SuppressWarnings("unchecked")

public class HashTable{
    private static final PdfPTable tabla = new PdfPTable(new float[]{20,20,20,20,20,20,20});
    private static PdfPCell  titleCell;
    private static Paragraph column1,column2,column3,column4,column5,column6,column7,
                                  data1,data2,data3,data4,data5,data6,data7;
    private DoublyLinkedList[] tablaHash; 
    private float numOfItems;
    private int capacity; //it is the maximum number of items that can be inserted  in the table: numOfItems <= capacity

    public HashTable() {
        this.tablaHash = new DoublyLinkedList[Constants.TABLE_SIZE];
        this.capacity = Constants.TABLE_SIZE;
        this.numOfItems = 0;
    }
    
    public int hashFuntion(String key){
        BigInteger dpi = new BigInteger(key);
        return dpi.mod(BigInteger.valueOf(this.capacity)).intValue();
    }
    
    public void InsertNode(Customers _customers){
        
        if(Check(tablaHash, this.capacity)){
           tablaHash = createCopyTable(tablaHash, capacity);
           this.capacity = this.capacity*2;
        }
        
         int index = hashFuntion(_customers.getDPI());
         if(tablaHash[index] == null){
             DoublyLinkedList nuevoNodo = new DoublyLinkedList();
             tablaHash[index] = nuevoNodo;
             tablaHash[index].InsertLast(_customers);
         }else{
            tablaHash[index].InsertLast(_customers);
         }   
         numOfItems++;
    }
    
    public void DeleteNode(String id){
        int index = hashFuntion(id);
        if(tablaHash[index] == null)
            return;
       
        tablaHash[index].Delete(id);
        if(tablaHash[index].getSize() == 0){
            tablaHash[index] = null;
        }
        numOfItems--;
    }
    
    public DoublyLinkedList[] createCopyTable(DoublyLinkedList[] s, int size){
        DoublyLinkedList[] newTable = new DoublyLinkedList[size*2];
        for(int i = 0; i<size; ++i){
            newTable[i] = s[i];
        }
        return newTable;
    }
    
    public void EditNode(String _dpi,String _name, String _last_name,String _gender,String _date,int _phone,String _direction){
        Customers editCustomer = search(_dpi);
        if(editCustomer == null)
            return;
        editCustomer.setName(_name);
        editCustomer.setLast_name(_last_name);
        editCustomer.setGender(_gender);
        editCustomer.setDate(_date);
        editCustomer.setPhone(_phone);
        editCustomer.setDirection(_direction);
    }
    
    
    public Customers search(String _dpi){
        int index = hashFuntion(_dpi);
        if(tablaHash[index] == null)
            return null;
        DoublyLinkedList.NodeCustomers temp = tablaHash[index].Search(_dpi);
        if(temp == null)
           return null;
        return temp.customers;
    }
    
    public  boolean Check(DoublyLinkedList[] tabla, int size){
        float ele = 0;
        for(int i = 0; i<size;++i){
            if(tabla[i] != null)
              ele += 1; 
        }
        return (ele/size)>0.75;
    }
    
    public void generatePDF(){
        String RutaEDD = System.getProperty("user.dir") + "\\" + "TablaClientes" + ".pdf";
        try {
            FileOutputStream archivo = new FileOutputStream(RutaEDD);
                File Archivo = new File(RutaEDD);
                Document doc = new Document();
                PdfWriter.getInstance(doc, archivo);
                doc.open();
                doc.add(new Paragraph("Customers",FontFactory.getFont(FontFactory.HELVETICA,20,BaseColor.CYAN)));
                doc.add(new Paragraph(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date())));
                doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                tabla.setWidthPercentage(100);
                titleCell = new PdfPCell(new Paragraph("Table Customers"));
                titleCell.setColspan(8);
                titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                titleCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.deleteBodyRows();
                tabla.addCell(titleCell);
                column1 = new Paragraph( "DPI",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column2 = new Paragraph("Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column3 = new Paragraph("Last Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column4 = new Paragraph("Gender",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column5 = new Paragraph("Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column6 = new Paragraph("Phone",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column7 = new Paragraph("Direction",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                tabla.addCell(column1);
                tabla.addCell(column2);
                tabla.addCell(column3);
                tabla.addCell(column4);
                tabla.addCell(column5);
                tabla.addCell(column6);
                tabla.addCell(column7);
                try {
                    
                    for (DoublyLinkedList tn : tablaHash) {
                       
                       if(tn != null){       
                       data1 = new Paragraph(tn.head.customers.getDPI(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data2 = new Paragraph(tn.head.customers.getName(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data3 = new Paragraph(tn.head.customers.getLast_name(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data4 = new Paragraph(tn.head.customers.getGender(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data5 = new Paragraph(tn.head.customers.getDate(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data6 = new Paragraph(Integer.toString(tn.head.customers.getPhone()),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data7 = new Paragraph(tn.head.customers.getDirection(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       tabla.addCell(data1);
                       tabla.addCell(data2);
                       tabla.addCell(data3);
                       tabla.addCell(data4);
                       tabla.addCell(data5);
                       tabla.addCell(data6);
                       tabla.addCell(data7);
                       }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                doc.add(tabla);
                doc.close();
                JOptionPane.showMessageDialog(null, "Tabla con todos los clientes generada");
                try {
                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supported");
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();
                    if(Archivo.exists()) desktop.open(Archivo);
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null,a.getCause());
                }
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
   
    
    public String GenerateReportTablaHash(){
        String graph = "digraph TablaHash{\nrankdir=\"LR\";\n node[style=filled, fillcolor=lightskyblue,shape=rect];\n";
               graph += "graph[label=\"CLIENTES\",fontcolor=black, bgcolor=greenyellow, color=black];\n parent[label=<\n<table border='1' cellborder='1'>\n";
               
        int i = 0;
        for (DoublyLinkedList tn : tablaHash) {
            graph += "<tr><td port='port_" + i + "' HEIGHT=\"100\">" + i + "</td></tr>";
            i++;
        }      
        i = 0;
        graph += "</table>\n>];";   
        
        for (DoublyLinkedList tn : tablaHash) {
            if (tn != null) {
                
                    graph += tn.generateNode(i);
                    graph += "parent:port_" + i + " -> " + tn.head.customers.getDPI()+ " [lhead=Clientes" + i + "];\n";
                

            }
            i++;
        }
         graph += "}";
        return graph;
    }
    
    public String SubGrafo(){
        String graph = "subgraph Clientes{\nrankdir=\"LR\";\n node[style=filled, fillcolor=lightskyblue,shape=rect];\n";
               graph += "graph[label=\"CLIENTES\",fontcolor=black, bgcolor=greenyellow, color=black];\n parent[label=<\n<table border='1' cellborder='1'>\n";
               
        int i = 0;
        for (DoublyLinkedList tn : tablaHash) {
            graph += "<tr><td port='port_" + i + "' HEIGHT=\"100\">" + i + "</td></tr>";
            i++;
        }      
        i = 0;
        graph += "</table>\n>];";   
        
        for (DoublyLinkedList tn : tablaHash) {
            if (tn != null) {
                
                    graph += tn.generateNode(i);
                    graph += "parent:port_" + i + " -> Cliente" + tn.head.customers.getDPI()+ " [lhead=Clientes" + i + "];\n";
                

            }
            i++;
        }
         graph += "}";
        return graph;
    }
    
    public int size(){
        return 0;  
    }
    
}
