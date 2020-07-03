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
import Viajes.*;
import javax.swing.UIManager;

/**
 *
 * @author dani3l8200 and Dabs
 */
public class EDD_PROYECTO2_201801364_201807100 {

    public static HashTable TClientes;
    public static DoublyLinkedListCircular AConductores;
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
    public static BTree<Vehicle> AVehiculos;
    public static BlockChain BCViajes;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TClientes = null;
        AConductores = null;
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
        BCViajes = null;
        Mapa = null;
        Impresora = new ImpresoraDot();
        CRutas = new CargaRutas();
        
                try {
                    // Plastic3DLookAndFeel.setPlasticTheme(new DarkStar());
                    UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
                } catch (Exception e) {
                }
                CRutas.setVisible(true);
            
      
        
    }
    
}
