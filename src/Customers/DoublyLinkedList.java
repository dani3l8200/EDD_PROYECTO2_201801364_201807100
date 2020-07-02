/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers;
import static  Customers.HashTable.*;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Font;
import java.math.BigInteger;

/**
 *
 * @author dani3l8200
 *
 */
public class DoublyLinkedList {
    
    class NodeCustomers{
        public NodeCustomers next;
        public NodeCustomers prev;
        public Customers customers;
        
        
        public NodeCustomers(Customers customers){
            this.customers = customers;
            this.next = null;
            this.prev = null;
        }
        
    }
    public NodeCustomers head;
    public NodeCustomers last;
    private int size;
    public DoublyLinkedList() {
        this.size = 0;
        this.head = null;
        this.last = null;
    }
    
    public int getSize(){
        return size;
    }
    
    
    public void InsertLast(Customers customers){
        
        NodeCustomers n = Search(customers.getDPI());
        
        if(n != null)
            return;
        
        n = new NodeCustomers(customers);
        if(head == null){
            head = n;
            last = head;
        }else{
            last.next = n;
            n.prev = last;
            last = n;
        }
        size++;
    }
    
    public NodeCustomers Search(String _id){
        NodeCustomers temp = head;
        
        while(temp != null && (temp.customers.getDPI() == null ? _id != null : !temp.customers.getDPI().equals(_id))){
            temp = temp.next;
        }
        if(temp != null)
            return temp;
        return null;
    }
    
    public void Delete(String _id){
        NodeCustomers p = Search(_id);
        NodeCustomers q = head; 
        if(q.customers.getDPI().equals(_id)){
            last = q.prev;
            NodeCustomers temp = p.next;
            head = temp;
            size--;
            return;
        }
        q = q.next;
        while(!q.customers.getDPI().equals(_id) && q != head){
            q = q.next;
        }
        if(q.customers.getDPI().equals(_id)){
            last = q.prev;
            last.next = q.next;
            size--;
            
        }else{
            System.out.println("Elemento no encontrado");
        }
    }
    
     
     public void print() {
        NodeCustomers next = head;
        while (next != null) {
            System.out.print(next.customers + " ");
            next = next.next; 
        }
        System.out.println();
    }
     
     public void generatePDF1(){
         NodeCustomers aux = head;    
         while(aux != null){
             data1 = new Paragraph(Integer.toString(k),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data2 = new Paragraph(aux.customers.getDPI(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data3 = new Paragraph(aux.customers.getName(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data4 = new Paragraph(aux.customers.getLast_name(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data5 = new Paragraph(aux.customers.getGender(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data6 = new Paragraph(aux.customers.getDate(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data7 = new Paragraph(Integer.toString(aux.customers.getPhone()),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data8 = new Paragraph(aux.customers.getDirection(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       tabla.addCell(data1);
                       tabla.addCell(data2);
                       tabla.addCell(data3);
                       tabla.addCell(data4);
                       tabla.addCell(data5);
                       tabla.addCell(data6);
                       tabla.addCell(data7);
                       tabla.addCell(data8);
                       k++;
                       aux = aux.next;
         }
     }
     
     public String generateNode(int cell){
         String graph  = "";
         NodeCustomers aux = head;
         graph += "\nsubgraph Clientes"+cell+"{\n rankdir=\"LR\";\n node[style=filled, fillcolor=lemonchiffon1, shape=record];\n";
         while(aux != null){
             graph += aux.customers.getDPI()+ "[label=\"DPI: "+aux.customers.getDPI()+ "\\nNombre: "+ aux.customers.getName() + "\\nApellidos: "+aux.customers.getLast_name() 
                     +"\\nGenerod: "+ aux.customers.getGender() + "\\nTelefono: "+ aux.customers.getPhone() + "\\nDireccion: " + aux.customers.getDirection() +"\"];\n\t";
           
             if(aux.next != null){
                 graph  += aux.customers.getDPI() + "->" + aux.next.customers.getDPI()+";\n";
             }
         
             aux = aux.next;
         }
         graph += "}\n";
         return graph;
     }
     
     @Override
	public String toString() {
		return head.toString();
	}
}
