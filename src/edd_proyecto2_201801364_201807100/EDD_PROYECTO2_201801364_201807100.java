/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto2_201801364_201807100;
import Customers.HashTable;
import Vehicle.*;
import Driver.*;

/**
 *
 * @author dani3l8200 and Dabs
 */
public class EDD_PROYECTO2_201801364_201807100 {
public static HashTable hashtTable = new HashTable();
public static BTree<Vehicle> tree = new BTree<Vehicle>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       DoublyLinkedListCircular circular = new DoublyLinkedListCircular();
        Drivers driver1 = new Drivers("932011312321","Juan","Daniel",'A',"Masculino",456498,"4ta calle A 14-78");
        Drivers driver2 = new Drivers("599931","Juan","Daniel",'A',"Masculino",456498,"4ta calle A 14-78");
       circular.insertLast(driver1);
       circular.insertLast(driver2);
       circular.print();
    
    }
    
}
