//@author Dabs
package Rutas;
public class Nodo {
    private String Nombre;
    private int Tiempo;
    private Nodo Siguiente;
    private Lista Caminos;
    
    public Nodo(String Nombre){
        this.Nombre = Nombre;
        Tiempo = 0;
        Siguiente = null;
        Caminos = new Lista();
    }
    
    public Nodo(String Nombre, int Tiempo){
        this.Nombre = Nombre;
        this.Tiempo = Tiempo;
        Siguiente = null;
        Caminos = new Lista();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getTiempo() {
        return Tiempo;
    }

    public void setTiempo(int Tiempo) {
        this.Tiempo = Tiempo;
    }

    public Nodo getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo Siguiente) {
        this.Siguiente = Siguiente;
    }

    public Lista getCaminos() {
        return Caminos;
    }

    public void setCaminos(Lista Caminos) {
        this.Caminos = Caminos;
    }
}