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
    public static final PdfPTable tabla = new PdfPTable(new float[]{7,20,20,20,20,20,20,20});
    public static PdfPCell  titleCell;
    public static Paragraph column1,column2,column3,column4,column5,column6,column7,column8,
                                  data1,data2,data3,data4,data5,data6,data7,data8;
    private DoublyLinkedList[] tablaHash; 
    public static int k =1;
    private float numOfItems;
    private int capacity; //it is the maximum number of items that can be inserted  in the table: numOfItems <= capacity
    private double load_factor;
    private final double sparce = 0.75;
    public HashTable() {
        this.tablaHash = new DoublyLinkedList[Constants.TABLE_SIZE];
        this.capacity = Constants.TABLE_SIZE;
        this.numOfItems = 0;
        this.load_factor = 0;
    }
    public HashTable(int capacity){
        this.tablaHash = new DoublyLinkedList[capacity];       
        this.capacity = capacity;   
        this.numOfItems = 0;
        this.load_factor = 0;
    }
    
    public int hashFuntion(String key){
        try {
               BigInteger dpi = new BigInteger(key);
               return dpi.mod(BigInteger.valueOf(this.capacity)).intValue();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Clientes",JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
    public void InsertNode(Customers _customers){       
        int index = hashFuntion(_customers.getDPI());
         if(tablaHash[index] == null)
             tablaHash[index] = new DoublyLinkedList();         
        tablaHash[index].InsertLast(_customers);    
        numOfItems++;
        load_factor = (1.0*numOfItems)/(capacity);
        if(load_factor > sparce){
            Resize(this.capacity);
        }
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
    
    public void Resize(int newCapacity){       
        HashTable hashCopy = new HashTable(newCapacity*2);
        capacity = newCapacity*2;
        for(int j = 0;j<newCapacity;++j){
            if(tablaHash[j] != null){
                 DoublyLinkedList.NodeCustomers temp = tablaHash[j].head;
                 while(temp != null){
                    hashCopy.InsertNode(temp.customers);
                     temp = temp.next;
                 }
            }
            
        } 
         numOfItems = hashCopy.numOfItems;
         load_factor = hashCopy.load_factor;
         tablaHash = hashCopy.tablaHash;
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
    
    
    public void generatePDF(){
        String RutaEDD = System.getProperty("user.dir") + "\\" + "TablaClientes" + ".pdf";
        try {
            k = 1;
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
                column1 = new Paragraph( "ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column2 = new Paragraph( "DPI",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column3 = new Paragraph("Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column4 = new Paragraph("Last Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column5 = new Paragraph("Gender",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column6 = new Paragraph("Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column7 = new Paragraph("Phone",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                column8 = new Paragraph("Direction",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN));
                tabla.addCell(column1);
                tabla.addCell(column2);
                tabla.addCell(column3);
                tabla.addCell(column4);
                tabla.addCell(column5);
                tabla.addCell(column6);
                tabla.addCell(column7);
                tabla.addCell(column8);
                try {              
                    for (DoublyLinkedList tablaHash1 : this.tablaHash) {
                        if (tablaHash1 != null) {
                            tablaHash1.generatePDF1();
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
               graph += "graph[label=\"CLIENTES\"];\n parent[label=<\n<table border='1' cellborder='1'>\n";
               
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
        String graph = "subgraph cluster_TablaHash{\nrankdir=\"LR\";\n node[style=filled, fillcolor=lightskyblue,shape=rect];\n";
               graph += "graph[label=\"CLIENTES\"];\n parent[label=<\n<table border='1' cellborder='1'>\n";
               
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
                    graph += "parent:port_" + i + " -> " + tn.head.customers.getDPI()+ " [lhead=cluster_Clientes" + i + "];\n";
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
