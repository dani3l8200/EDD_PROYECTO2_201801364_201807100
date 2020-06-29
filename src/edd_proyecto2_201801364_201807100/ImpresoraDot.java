//@author Dabs
package edd_proyecto2_201801364_201807100;

import Viajes.Viaje;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.AVehiculos;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.BCViajes;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.LConductores;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.Mapa;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.TClientes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.Desktop;
import java.io.IOException;
import javax.swing.JOptionPane;
public class ImpresoraDot {
    
    public ImpresoraDot(){
    }
    
    public void Imprimir(String Nombre, String Contenido){
        try {
            String RutaDot = System.getProperty("user.dir") + "\\" + Nombre + ".dot";
            String RutaPNG = System.getProperty("user.dir") + "\\" + Nombre + ".png";
            File Archivo = new File(RutaDot);
            if (!Archivo.exists()) {
                Archivo.createNewFile();
            }
            FileWriter FW = new FileWriter(Archivo);
            BufferedWriter BW = new BufferedWriter(FW);
            BW.write(Contenido);
            BW.close();
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", RutaPNG, RutaDot );
	    pbuilder.redirectErrorStream( true );
            pbuilder.start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ImprimirTxT(String Nombre, String Contenido){
        try {
            String RutaEDD = System.getProperty("user.dir") + "\\" + Nombre + ".edd";
             File Archivo = new File(RutaEDD);
            if (!Archivo.exists()) {
                Archivo.createNewFile();
            }
            FileWriter FW = new FileWriter(Archivo);
            BufferedWriter BW = new BufferedWriter(FW);
            BW.write(Contenido);
            BW.close();
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
            e.printStackTrace();
        }
    }
    
    public String DotGeneral(){
        String Dot = "digraph D {\n\n";
        if(BCViajes!=null && TClientes!=null && LConductores != null && Mapa!=null && AVehiculos!=null){
            Dot += BCViajes.SubGrafo() + "\n";
            Dot += TClientes.SubGrafo() + "\n";
            Dot += LConductores.SubGrafo() + "\n";
            Dot += Mapa.SubGrafo() + "\n";
            Dot += AVehiculos.SubGrafo() + "\n";
            if(BCViajes.getCabeza() != null){
                Viaje Aux = BCViajes.getCabeza();
                while(Aux.getSiguiente() != null){
                    Dot += Aux.getRuta().SubGrafo(Aux.OptenerClave()) + "\n";
                    Dot += "\tBC" + Aux.OptenerClave() + " -> Cliente" + Aux.getCliente().getDPI() + "\n";
                    Dot += "\tBC" + Aux.OptenerClave() + " -> Conductor" + Aux.getConductor().getDPI() + "\n";
                    Dot += "\tBC" + Aux.OptenerClave() + " -> nodeArbol" + Aux.getVehiculo().getLicensePlate() + "\n";
                    Dot += "\tBC" + Aux.OptenerClave() + " -> Ruta" + Aux.OptenerClave() + Aux.getRuta().getCabeza().getNombre() + "\n";
                    Aux = Aux.getSiguiente();
                }
            }
        }
        Dot += "\n}";
        return Dot;
    }
}
