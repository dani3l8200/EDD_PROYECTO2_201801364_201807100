/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto2_201801364_201807100;
import Customers.HashTable;
import Vehicle.*;
import Viajes.*;

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
        BlockChain Prueba = new BlockChain();
        Prueba.Insertar(new Viaje(3, 6, 20, 15, 7, "ABC"));
        Prueba.Insertar(new Viaje(7, 8, 15, 12, 17, "CTE"));
        Prueba.Insertar(new Viaje(30, 2, 8, 7, 20, "YFS"));
        Prueba.Insertar(new Viaje(25, 8, 12, 7, 20, "BFR"));
        Prueba.Insertar(new Viaje(12, 1, 12, 7, 20, "JES"));
        ImpresoraDot Impresora = new ImpresoraDot();
        Impresora.Imprimir("BlockChain", Prueba.GenerarDot());
    }
    
}
