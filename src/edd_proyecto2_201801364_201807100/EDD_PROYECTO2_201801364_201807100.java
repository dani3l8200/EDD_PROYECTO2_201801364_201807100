/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto2_201801364_201807100;

import Customers.*;
import Driver.*;
import Vehicle.*;
import Rutas.*;
import Interfaces.*;
import Customers.HashTable;

/**
 *
 * @author dani3l8200 and Dabs
 */
public class EDD_PROYECTO2_201801364_201807100 {

    public static HashTable TClientes;
    public static BTree<Vehicle> AVehiculos = new BTree<>();;
    public static DoublyLinkedListCircular circular = new DoublyLinkedListCircular();
    public static CargaRutas CRutas;
    public static MenuClientes MClientes;
    public static MenuConductores MConductores;
    public static MenuEstructuras MEstructuras;
    public static MenuPrincipal Principal;
    public static MenuReportes MReportes;
    public static MenuRutas MRutas;
    public static MenuVehiculos MVehiculos;
    public static MenuViajes MViajes;
    public static NuevoViaje NViaje;
    public static ImpresoraDot Impresora;
    public static Grafo Mapa;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TClientes = null;
        AVehiculos = null;
        MClientes = null;
        MConductores = null;
        MEstructuras = null;
        Principal = null;
        MReportes = null;
        MRutas = null;
        MVehiculos = null;
        MViajes = null;
        NViaje = null;
        Mapa = null;
        Impresora = new ImpresoraDot();
        CRutas = new CargaRutas();
        CRutas.setVisible(true);
    }
    
}
