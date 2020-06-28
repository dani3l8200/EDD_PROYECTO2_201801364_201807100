//@author Barillas
package Huffman;
public class Codificador {
    
    private NodoLista Cabeza;
    private int Cont;
    
    public Codificador(){
        Cabeza = null;
        Cont = 0;
    }
    
    public void Insertar(NodoLista Nuevo){
        if(getCabeza() == null){
            setCabeza(Nuevo);
        }else{
            NodoLista Aux = getCabeza();
            while(Aux.getSiguiente() != null){
                Aux = Aux.getSiguiente();
            }
            Aux.setSiguiente(Nuevo);
        }
        setCont(getCont() + 1);
    }
    
    public NodoLista Buscar(char Caracter, boolean Aumentar){
        if(getCabeza()!=null){
            NodoLista Aux = getCabeza();
            while(Aux != null && Aux.getArbol().getValor().getCaracter() != Caracter){
                Aux = Aux.getSiguiente();
            }
            if(Aux != null && Aumentar){
                Aux.getArbol().getValor().setFrecuencia(Aux.getArbol().getValor().getFrecuencia() + 1);
            }
            return Aux;
        }
        return null;
    }
    
    public void Ordenar(){
        if(getCabeza()!=null){
            NodoLista Actual = getCabeza().getSiguiente();
            while(Actual != null){
                NodoLista Aux = Actual.getSiguiente();
                while(Aux!=null){
                    if(Actual.getArbol().getValor().getFrecuencia() > Aux.getArbol().getValor().getFrecuencia()){
                        Letra Intercambio = Actual.getArbol().getValor();
                        Actual.getArbol().setValor(Aux.getArbol().getValor());
                        Aux.getArbol().setValor(Intercambio);
                    }
                    Aux = Aux.getSiguiente();
                }
                Actual = Actual.getSiguiente();
            }
        }
    }
    
    public NodoArbol Sacar(){
        NodoLista Aux = getCabeza();
        if(getCabeza() != null){
            setCabeza(getCabeza().getSiguiente());
            setCont(getCont() - 1);
            return Aux.getArbol();
        }else{
            return null;
        }
    }
    
    public void Mostrar(){
        if(getCabeza()!=null){
            NodoLista Aux = getCabeza();
            while(Aux!=null){
                System.out.println(Aux.getArbol().getValor().getCaracter() + ", " + Aux.getArbol().getValor().getFrecuencia());
                Aux = Aux.getSiguiente();
            }
        }
    }
    
    public String Generar(String Texto){
        Cabeza = null;
        Cont = 0;
        for(int i=0; i<Texto.length(); i++){
            if(Buscar(Texto.toCharArray()[i], true) == null){
                Insertar(new NodoLista(Texto.toCharArray()[i]));
            }
        }
        if(Cabeza != null){
            Ordenar();
            Mostrar();
            while(getCont()!=1){
                NodoArbol Nuevo = new NodoArbol();
                Nuevo.setIzquierda(Sacar());
                Nuevo.setDerecha(Sacar());
                Insertar(new NodoLista(Nuevo));
            }
            Cabeza.getArbol().Mostrar("");
            String Codigo = "";
            for(int i=0; i<Texto.length(); i++){
                Codigo += Cabeza.getArbol().Buscar(Texto.toCharArray()[i], "");
            }
            return Codigo;
        }
        return null;
    }
    
    public String Desencriptar(String Codigo){
        String Texto = "";
        char Huffman[] = Codigo.toCharArray();
        if(Cabeza != null){
            int Cont=0;
            while(Cont < Codigo.length()){
                NodoArbol Aux = Cabeza.getArbol();
                while(Aux.getValor() == null){
                    if(Huffman[Cont] == '0'){
                        Aux = Aux.getIzquierda();
                    }else{
                        Aux = Aux.getDerecha();
                    }
                    Cont++;
                }
                Texto += Aux.getValor().getCaracter();
            }
        }
        return Texto;
    }

    public NodoLista getCabeza() {
        return Cabeza;
    }

    public void setCabeza(NodoLista Cabeza) {
        this.Cabeza = Cabeza;
    }

    public int getCont() {
        return Cont;
    }

    public void setCont(int Cont) {
        this.Cont = Cont;
    }
}
