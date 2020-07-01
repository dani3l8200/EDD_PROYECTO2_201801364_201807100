//@author Dabs
package edd_proyecto2_201801364_201807100;

import Viajes.Viaje;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.AVehiculos;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.BCViajes;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.AConductores;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.Mapa;
import static edd_proyecto2_201801364_201807100.EDD_PROYECTO2_201801364_201807100.TClientes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.Desktop;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
    
    public String DotGeneral() throws NoSuchAlgorithmException{
        String Dot = "digraph D {\n compound=true;\n\n";
        if(BCViajes!=null && TClientes!=null && AConductores != null && Mapa!=null && AVehiculos!=null){
            Dot += BCViajes.SubGrafo() + "\n";
            //Dot += TClientes.SubGrafo() + "\n";
            //Dot += AConductores.SubGrafo() + "\n";
            //Dot += Mapa.SubGrafo() + "\n";
            //Dot += AVehiculos.SubGrafo() + "\n";
            if(BCViajes.getCabeza() != null){
                Viaje Aux = BCViajes.getCabeza();
                while(Aux.getSiguiente() != null){
                    //Dot += Aux.getRuta().SubGrafo(BCViajes.Encriptar(Aux.OptenerClave())) + "\n";
                    //Dot += "\tBC" + BCViajes.Encriptar(Aux.OptenerClave()) + " -> Cliente" + Aux.getCliente().getDPI() + "\n";
                    //Dot += "\tBC" + BCViajes.Encriptar(Aux.OptenerClave()) + " -> Conductor" + Aux.getConductor().getDPI() + "\n";
                    //Dot += "\tBC" + BCViajes.Encriptar(Aux.OptenerClave()) + " -> nodeArbol" + AVehiculos.search(Aux.getVehiculo()).hashCode() + "\n";
                    //Dot += "\tBC" + BCViajes.Encriptar(Aux.OptenerClave()) + " -> Ruta" + BCViajes.Encriptar(Aux.OptenerClave()) + Aux.getRuta().getCabeza().getNombre() + "\n";
                    Aux = Aux.getSiguiente();
                }
            }
        }
        Dot += "\n}";
        return Dot;
    }
}
