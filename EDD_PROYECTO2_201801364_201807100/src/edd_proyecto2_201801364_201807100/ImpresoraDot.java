//@author Dabs
package edd_proyecto2_201801364_201807100;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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
            pbuilder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
