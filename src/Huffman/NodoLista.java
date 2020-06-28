//@author Dabs
package Huffman;
public class NodoLista {
    private NodoLista Siguiente;
    private NodoArbol Arbol;
    
    public NodoLista(char Caracter){
        this.Arbol = new NodoArbol();
        this.Arbol.setValor(new Letra(Caracter));
        Siguiente = null;
    }
    
    public NodoLista(NodoArbol Arbol){
        this.Arbol = Arbol;
        Siguiente = null;
    }

    public NodoLista getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoLista Siguiente) {
        this.Siguiente = Siguiente;
    }

    public NodoArbol getArbol() {
        return Arbol;
    }

    public void setArbol(NodoArbol Arbol) {
        this.Arbol = Arbol;
    }
}
