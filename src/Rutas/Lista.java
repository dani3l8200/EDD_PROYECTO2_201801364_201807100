//@author Dabs
package Rutas;
public class Lista {
    
    private Nodo Cabeza;
    
    public Lista(){
        Cabeza = null;
    }
    
    public void Insertar(Nodo Nuevo){
        if(Cabeza == null){
            Cabeza = Nuevo;
        }else{
            Nodo Aux = Cabeza;
            while(Aux.getSiguiente() != null){
                Aux = Aux.getSiguiente();
            }
            Aux.setSiguiente(Nuevo);
        }
    }
    
    public void ResetearTiempo(){
        Nodo Aux = Cabeza;
        while(Aux != null){
            Aux.setTiempo(0);
            Aux = Aux.getSiguiente();
        }
    }
    
    public Nodo Buscar(String Nombre){
        Nodo Aux = Cabeza;
        while(Aux != null && !Aux.getNombre().equalsIgnoreCase(Nombre)){
            Aux = Aux.getSiguiente();
        }
        return Aux;
    }
    
    public boolean Eliminar(String Eliminar){
        Nodo Eliminado = Buscar(Eliminar);
        if(Eliminado != null){
            if(Eliminado == Cabeza){
                Cabeza = Cabeza.getSiguiente();
            }else{
                Nodo Aux = Cabeza;
                while(Aux.getSiguiente() != Eliminado){
                    Aux = Aux.getSiguiente();
                }
                Aux.setSiguiente(Eliminado.getSiguiente());
            }
        }
        return false;
    }
    
    public Lista Clonar(){
        Lista Clon = new Lista();
        Nodo Aux = Cabeza;
        while(Aux != null){
            Clon.Insertar(new Nodo(Aux.getNombre(), Aux.getTiempo()));
            Aux = Aux.getSiguiente();
        }
        return Clon;
    }
    
    public int TiempoTotal(){
        Nodo Aux = Cabeza;
        int Contador = 0;
        while(Aux != null){
            Contador += Aux.getTiempo();
            Aux = Aux.getSiguiente();
        }
        return Contador;
    }
    
    public void Mostrar(){
        Nodo Aux = Cabeza;
        System.out.println("--Lista--");
        while(Aux != null){
            
            System.out.println(Aux.getNombre() + ", " + Aux.getTiempo());
            Aux = Aux.getSiguiente();
        }
    }
    
    public String GenerarDot(){
        String Dot = "digraph D {\n\n";
        if(Cabeza!=null){
            Dot += "\t" + Cabeza.getNombre() + "[label=\"" + Cabeza.getNombre() + "\"]\n";
            Nodo Aux = Cabeza;
            while(Aux.getSiguiente() != null){
                Dot += "\t" + Aux.getSiguiente().getNombre() + "[label=\"" + Aux.getSiguiente().getNombre() + "\"]\n";
                Dot += "\t" + Aux.getNombre() + " -> " + Aux.getSiguiente().getNombre() + " [label=\"" + Aux.getSiguiente().getTiempo() + "\"]\n";
                Aux = Aux.getSiguiente();
            }
        }
        Dot += "\n}";
        return Dot;
    }
    
    public String SubGrafo(String Prefijo) {
        String Dot = "subgraph cluster_Rutas" + Prefijo + " {\n\n";
        if(Cabeza!=null){
            Dot += "\tRuta" + Prefijo + Cabeza.getNombre() + "[label=\"" + Cabeza.getNombre() + "\"]\n";
            Nodo Aux = Cabeza;
            while(Aux.getSiguiente() != null){
                Dot += "\tRuta" + Prefijo + Aux.getSiguiente().getNombre() + "[label=\"" + Aux.getSiguiente().getNombre() + "\"]\n";
                Dot += "\tRuta" + Prefijo + Aux.getNombre() + " -> Ruta" + Prefijo + Aux.getSiguiente().getNombre() + " [label=\"" + Aux.getSiguiente().getTiempo() + "\"]\n";
                Aux = Aux.getSiguiente();
            }
        }
        Dot += "\n}";
        return Dot;
    }
    
    public int CantidadNodos(){
        int Cont = 0;
        Nodo Aux = Cabeza;
        while(Aux != null){
            Cont++;
            Aux = Aux.getSiguiente();
        }
        return Cont;
    }

    public Nodo getCabeza() {
        return Cabeza;
    }

    public void setCabeza(Nodo Cabeza) {
        this.Cabeza = Cabeza;
    }
}