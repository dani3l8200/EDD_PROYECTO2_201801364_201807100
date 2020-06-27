//@author Dabs
package Viajes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlockChain {
    
    private Viaje Cabeza;
    
    public BlockChain(){
        Cabeza = null;
    }
    
    public void Insertar(Viaje Nuevo){
        if(Cabeza == null){
            Cabeza = Nuevo;
        }else{
            Viaje Aux = Cabeza;
            while(Aux.getSiguiente()!=null){
                Aux = Aux.getSiguiente();
            }
            Aux.setSiguiente(Nuevo);
        }
    }
    
    public void Eliminar(String Clave){
        Viaje Eliminar = Buscar(Clave);
        if(Eliminar != null){
            if(Eliminar == Cabeza){
                Cabeza = Cabeza.getSiguiente();
            }else{
                Viaje Aux = Cabeza;
                while(Aux.getSiguiente() != Eliminar){
                    Aux = Aux.getSiguiente();
                }
                Aux.setSiguiente(Eliminar.getSiguiente());
            }
        }
    }
    
    public Viaje Buscar(String Clave){
        try {
            Clave = Encriptar(Clave);
            if(Cabeza == null){
                Viaje Aux = Cabeza;
                while(Aux != null && Clave.equals(Encriptar(Aux.OptenerClave()))){
                    Aux = Aux.getSiguiente();
                }
                return Aux;
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BlockChain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String Encriptar(String Clave) throws NoSuchAlgorithmException{
        MessageDigest MD = MessageDigest.getInstance("MD5");
        MD.update(Clave.getBytes());
        byte[] Bytes = MD.digest();
        StringBuffer SB = new StringBuffer();
        for(byte Bytes1: Bytes){
            SB.append(Integer.toHexString(Bytes1 & 0xff).toString());
        }
        return SB.toString();
    }
    
    public String GenerarDot(){
        try {
            String Dot = "digraph D {\n\n";
            if(Cabeza!=null){
                Dot += "\t BC" + Encriptar(Cabeza.OptenerClave()) + "[label=\"" + Encriptar(Cabeza.OptenerClave()) + "\"]\n";
                Viaje Aux = Cabeza;
                while(Aux.getSiguiente() != null){
                    Dot += "\tBC" + Encriptar(Aux.getSiguiente().OptenerClave()) + "[label=\"" + Encriptar(Aux.getSiguiente().OptenerClave()) + "\"]\n";
                    Dot += "\tBC" + Encriptar(Aux.OptenerClave()) + " -> BC" + Encriptar(Aux.getSiguiente().OptenerClave()) + "\n";
                    Aux = Aux.getSiguiente();
                }
            }
            Dot += "\n}";
            return Dot;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BlockChain.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public Viaje getCabeza() {
        return Cabeza;
    }

    public void setCabeza(Viaje Cabeza) {
        this.Cabeza = Cabeza;
    }
}
