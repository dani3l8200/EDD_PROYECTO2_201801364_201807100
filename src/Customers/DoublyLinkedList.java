/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers;
import Customers.Customers;
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
           
        }
        
    }
    public NodeCustomers head;
    private int size;
    public DoublyLinkedList() {
        this.size = 0;
        this.head = null;
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
        }else{
            n.next = head;
            head = n;
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
        NodeCustomers temp = head;
        NodeCustomers p = null;
     
        while(temp != null && !temp.customers.getDPI().equals(_id)){
            p = temp;
            temp = temp.next;
        } 
        
        if(temp == null)
            return;
        if(p == null){
            head = temp.next;
        }else{
            p.next = temp.next;
        }
        size--;
    }
    
     
     public void print() {
        NodeCustomers next = head;
        while (next != null) {
            System.out.print(next.customers + " ");
            next = next.next; 
        }
        System.out.println();
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
