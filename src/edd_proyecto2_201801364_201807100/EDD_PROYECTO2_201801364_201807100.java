/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto2_201801364_201807100;
import Customers.*;

import Driver.*;
import Vehicle.*;
import Viajes.*;
import Huffman.*;
import Rutas.*;

/**
 *
 * @author dani3l8200 and Dabs
 */
public class EDD_PROYECTO2_201801364_201807100 {
public static HashTable hashtTable = new HashTable();
public static BTree<Vehicle> tree = new BTree<Vehicle>();
public static DoublyLinkedListCircular circular = new DoublyLinkedListCircular();
public static Grafo Prueba = new Grafo();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        hashtTable.InsertNode(new Customers("20939184939212", "Juan Daniel", "Roman Barrientos", "Masculino", "06/28/2020", 46867112, "4ta calle A zona 56"));
        hashtTable.InsertNode(new Customers("30939184939213", "Marcos Gomez", "Roman Barrientos", "Masculino", "06/28/2020", 46867112, "5ta calle A zona 10"));
        hashtTable.InsertNode(new Customers("40939184939214", "Eunice Diaz", "Roman Barrientos", "Masculino", "06/28/2020", 46867112, "6ta calle A zona 7"));
        hashtTable.InsertNode(new Customers("50939184939215", "Juan Daniel", "Roman Barrientos", "Masculino", "06/28/2020", 46867112, "4ta calle A zpma 56"));
        hashtTable.InsertNode(new Customers("60939184939216", "Juan Daniel", "Roman Barrientos", "Masculino", "06/28/2020", 46867112, "4ta calle A zpma 56"));
        tree.insert(new Vehicle("A929B1","Toyota","Yaris x20", 2020, "White", "4569.16", "Mecanico"));
        tree.insert(new Vehicle("B929B1","Toyota","Yaris x20", 2020, "White", "4569.16", "Mecanico"));
        tree.insert(new Vehicle("C929B1","Toyota","Yaris x20", 2020, "White", "4569.16", "Mecanico"));
        tree.insert(new Vehicle("D929B1","Toyota","Yaris x20", 2020, "White", "4569.16", "Mecanico"));
        tree.insert(new Vehicle("A329B1","Toyota","Yaris x20", 2020, "White", "4569.16", "Mecanico"));
        circular.insertLast(new Drivers("2900192930192", "Karla Melissa", "Gomez Gonzales", 'A', "Femenino", 34689325, "7ma calle B zona 6"));
        circular.insertLast(new Drivers("3900192930193", "Samuel", "Fernandez", 'A', "Femenino", 34689325, "7ma calle B zona 6"));
        circular.insertLast(new Drivers("4900192930194", "Marcos", "Gomez", 'A', "Femenino", 34689325, "7ma calle B zona 6"));
        circular.insertLast(new Drivers("5900192930195", "Karla Melissa", "Gomez Gonzales", 'A', "Femenino", 34689325, "7ma calle B zona 6"));
        circular.insertLast(new Drivers("6900192930196", "Karla Melissa", "Gomez Gonzales", 'A', "Femenino", 34689325, "7ma calle B zona 6"));
         Prueba.InsertarNodo(new Nodo("A"));
        Prueba.InsertarNodo(new Nodo("B"));
        Prueba.InsertarNodo(new Nodo("C"));
        Prueba.InsertarNodo(new Nodo("D"));
        Prueba.InsertarNodo(new Nodo("E"));
        Prueba.InsertarNodo(new Nodo("F"));
        Prueba.InsertarNodo(new Nodo("G"));
        Prueba.InsertarNodo(new Nodo("H"));
        Prueba.InsertarNodo(new Nodo("I"));
        Prueba.InsertarNodo(new Nodo("J"));
        Prueba.InsertarNodo(new Nodo("K"));
        Prueba.InsertarNodo(new Nodo("L"));
        Prueba.InsertarNodo(new Nodo("M"));
        Prueba.InsertarNodo(new Nodo("N"));
        Prueba.InsertarCamino("A", "B", 7);
        Prueba.InsertarCamino("A", "D", 10);
        Prueba.InsertarCamino("B", "D", 8);
        Prueba.InsertarCamino("B", "C", 12);
        Prueba.InsertarCamino("C", "F", 9);
        Prueba.InsertarCamino("D", "E", 4);
        Prueba.InsertarCamino("E", "F", 5);
        Prueba.InsertarCamino("E", "G", 6);
        Prueba.InsertarCamino("E", "H", 8);
        Prueba.InsertarCamino("E", "J", 6);
        Prueba.InsertarCamino("F", "J", 6);
        Prueba.InsertarCamino("G", "K", 4);
        Prueba.InsertarCamino("H", "K", 1);
        Prueba.InsertarCamino("J", "I", 6);
        Prueba.InsertarCamino("J", "M", 10);
        Prueba.InsertarCamino("I", "M", 8);
        Prueba.InsertarCamino("K", "N", 3);
        Prueba.InsertarCamino("M", "L", 2);
        Prueba.InsertarCamino("L", "N", 5);
        Lista Aux = Prueba.CaminoMinimo("A", "N");
        BlockChain block = new BlockChain();
        
        
        
        
       
        block.Insertar(new Viaje("A", "B", 10, 11, 18, 15, 20, hashtTable.search("30939184939213"), circular.SearchForUpdate("3900192930193"), tree.search(new Vehicle("B929B1")), Aux));
        
       block.Insertar(new Viaje("A", "B", 9, 10, 17, 14, 19, hashtTable.search("40939184939214"), circular.SearchForUpdate("4900192930194"), tree.search(new Vehicle("A929B1")), Aux));
       
        block.Insertar(new Viaje("A", "B", 7, 8, 15, 12, 17, hashtTable.search("20939184939212"), circular.SearchForUpdate("2900192930192"), tree.search(new Vehicle("C929B1")), Aux));
       block.Insertar(new Viaje("A", "B", 8, 9, 16, 13, 18, hashtTable.search("20939184939212"), circular.SearchForUpdate("2900192930192"), tree.search(new Vehicle("C929B1")), Aux)); 
        block.Insertar(new Viaje("A", "B", 11, 12, 19, 16, 21, hashtTable.search("40939184939214"), circular.SearchForUpdate("3900192930193"), tree.search(new Vehicle("B929B1")), Aux));
       
       block.Insertar(new Viaje("A", "B", 9, 10, 17, 14, 19, hashtTable.search("20939184939212"), circular.SearchForUpdate("2900192930192"), tree.search(new Vehicle("C929B1")), Aux));
       
        block.BuscarConductor("2900192930192").getConductor().setGenerate_income();
        block.BuscarConductor("2900192930192").getConductor().setGenerate_income();
        block.BuscarConductor("2900192930192").getConductor().setGenerate_income();
        block.BuscarConductor("4900192930194").getConductor().setGenerate_income();
        block.BuscarConductor("3900192930193").getConductor().setGenerate_income();
        block.BuscarConductor("3900192930193").getConductor().setGenerate_income();
        block.BuscarVehiculo("C929B1").getVehiculo().setGenerate_trips();
        block.BuscarVehiculo("C929B1").getVehiculo().setGenerate_trips();
        block.BuscarVehiculo("C929B1").getVehiculo().setGenerate_trips();
        block.BuscarVehiculo("B929B1").getVehiculo().setGenerate_trips();
        block.BuscarVehiculo("B929B1").getVehiculo().setGenerate_trips();
        block.BuscarVehiculo("A929B1").getVehiculo().setGenerate_trips();
        block.BuscarCliente("20939184939212").getCliente().setGenerate_trips();
        block.BuscarCliente("20939184939212").getCliente().setGenerate_trips();
        block.BuscarCliente("20939184939212").getCliente().setGenerate_trips();
        block.BuscarCliente("40939184939214").getCliente().setGenerate_trips();
        block.BuscarCliente("40939184939214").getCliente().setGenerate_trips();
        block.BuscarCliente("30939184939213").getCliente().setGenerate_trips();
       block.GenerateReportTopDrivers(true);
       block.GenerateReportTopDrivers(false);
       block.GenerateReportTopVehicles(true);
         block.GenerateReportTopVehicles(false); 
         block.GenerateReportTopCustomers(true);
         block.GenerateReportTopCustomers(false);
         
       ImpresoraDot Impresora = new ImpresoraDot();
        Impresora.Imprimir("BlockChain", block.GenerarDot());
        
       /* String Texto = "Texto de relleno solo para probar el funcionamiento del codigo en la desincriptacion";
        Codificador Prueba = new Codificador();
        String Encriptado = Prueba.Generar(Texto);
        System.out.println(Prueba.Desencriptar(Encriptado));
        Texto = "Texto de encriptado No.2 para ver si se resetea";
        Encriptado = Prueba.Generar(Texto);
        System.out.println(Prueba.Desencriptar(Encriptado));*/
    }
    
}
