//@author Dabs
package Huffman;
public class NodoArbol {
    
    private Letra Valor;
    private NodoArbol Izquierda;
    private NodoArbol Derecha;
    public static String intento = "";
    
    public NodoArbol(){
        Valor = null;
        Izquierda = null;
        Derecha = null;
        
    }
    
    public NodoArbol(Letra Valor){
        this.Valor = Valor;
        Izquierda = null;
        Derecha = null;
    }
    
    public void Mostrar(String Continuidad){
        if(Valor == null){
            if(Izquierda != null){
                Izquierda.Mostrar(Continuidad + "0");
            }
            if(Derecha != null){
                Derecha.Mostrar(Continuidad + "1");
            }
        }else{
           intento += Valor.getCaracter() + " = " + Continuidad + "\n";
        }
    }
    
    
    public String Buscar(char Letra, String Continuidad){
        if(Valor==null){
            String Retorno = null;
            if(Izquierda != null){
                Retorno = Izquierda.Buscar(Letra, Continuidad + "0");
                if(Retorno != null){
                    return Retorno;
                }
            }
            if(Derecha != null){
                Retorno = Derecha.Buscar(Letra, Continuidad + "1");
                if(Retorno != null){
                    return Retorno;
                }
            }
        }else{
            if(Valor.getCaracter() == Letra){
                return Continuidad;
            }
        }
        return null;
    }
    
    public void MostrarOrden(){
        if(Valor == null){
            if(Izquierda != null){
                Izquierda.MostrarOrden();
            }
            if(Derecha != null){
                Derecha.MostrarOrden();
            }
        }else{
            System.out.print(Valor.getCaracter());
        }
    }

    public Letra getValor() {
        return Valor;
    }

    public void setValor(Letra Valor) {
        this.Valor = Valor;
    }

    public NodoArbol getIzquierda() {
        return Izquierda;
    }

    public void setIzquierda(NodoArbol Izquierda) {
        this.Izquierda = Izquierda;
    }

    public NodoArbol getDerecha() {
        return Derecha;
    }

    public void setDerecha(NodoArbol Derecha) {
        this.Derecha = Derecha;
    }
}