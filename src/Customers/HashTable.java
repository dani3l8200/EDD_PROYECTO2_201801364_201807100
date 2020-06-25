/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers;

import java.math.BigInteger;
/** 
 *
 * @author dani3l8200
 */
@SuppressWarnings("unchecked")

public class HashTable{
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
    
    public void EditNode(String _dpi,String _name, String _last_name,String _gender, int _phone,String _direction){
        Customers editCustomer = search(_dpi);
        if(editCustomer == null)
            return;
        editCustomer.setName(_name);
        editCustomer.setLast_name(_last_name);
        editCustomer.setGender(_gender);
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
    
    public int size(){
        return 0;  
    }
    
}
