//@author Dabs
package Rutas;

public class Grafo {
    
    private Lista Nodos;

    public Grafo() {
        Nodos = new Lista();
    }
    
    public void InsertarNodo(Nodo Nuevo){
        Nodos.Insertar(Nuevo);
    }
    
    public boolean InsertarCamino(String First, String Second, int Tiempo){
        Nodo Primero = Nodos.Buscar(First);
        Nodo Segundo = Nodos.Buscar(Second);
        if(Primero == null){
            InsertarNodo(new Nodo(First));
            Primero = Nodos.Buscar(First);
        }
        if(Segundo == null){
            InsertarNodo(new Nodo(Second));
            Segundo = Nodos.Buscar(Second);
        }
        if(Primero != null && Segundo != null){
            Primero.getCaminos().Insertar(new Nodo(Second, Tiempo));
            return true;
        }
        return false;
    }
    
    public void Mostrar(){
        Nodo AuxN = Nodos.getCabeza();
        while(AuxN != null){
            System.out.println("Nodo: " + AuxN.getNombre());
            Nodo AuxC = AuxN.getCaminos().getCabeza();
            while(AuxC != null){
                System.out.println("\tCamino a: " + AuxC.getNombre() + ", tardando: " + AuxC.getTiempo());
                AuxC = AuxC.getSiguiente();
            }
            AuxN = AuxN.getSiguiente();
        }
    }
    
    public Lista CaminoMinimo(String Init, String End){
        Nodo Inicio = Nodos.Buscar(Init);
        Nodo Fin = Nodos.Buscar(End);
        if(Inicio != null && Fin != null){
            Nodos.ResetearTiempo();
            return ListaCamino(new Lista(), Inicio, Fin);
        }
        return null;
    }
    
    public Lista ListaCamino(Lista Recorrido, Nodo Actual, Nodo Final){
        Recorrido.Insertar(new Nodo(Actual.getNombre(), Actual.getTiempo()));
        if(!Actual.getNombre().equalsIgnoreCase(Final.getNombre())){
            Nodo Aux = Nodos.Buscar(Actual.getNombre()).getCaminos().getCabeza();
            Lista Minima = null;
            while(Aux!=null){
                Nodo Original = Nodos.Buscar(Aux.getNombre());
                if(Recorrido.Buscar(Aux.getNombre()) == null){
                    if(Original.getTiempo() == 0 || Original.getTiempo() > (Recorrido.TiempoTotal() + Aux.getTiempo())){
                        Original.setTiempo(Recorrido.TiempoTotal() + Aux.getTiempo());
                        Lista Auxiliar = ListaCamino(Recorrido.Clonar(), Aux, Final);
                        if(Minima == null || (Auxiliar != null && (Recorrido.TiempoTotal() + Aux.getTiempo()) < Minima.TiempoTotal())){
                            Minima = Auxiliar;
                        }
                    }   
                }
                Aux = Aux.getSiguiente();
            }
            return Minima;
        }else{
            return Recorrido;
        }
    }
    
    public String GenerarDot(){
        String Dot = "digraph D {\n\n";
        Nodo AuxN = Nodos.getCabeza();
        while(AuxN != null){
            Dot += "\t" + AuxN.getNombre() + "[label=\"" + AuxN.getNombre() + "\"]\n";
            AuxN = AuxN.getSiguiente();
        }
        Dot+="\n";
        AuxN = Nodos.getCabeza();
        while(AuxN != null){
            Nodo AuxC = AuxN.getCaminos().getCabeza();
            while(AuxC != null){
                Dot += "\t" + AuxN.getNombre() + " -> " + AuxC.getNombre() + " [label=\"" + AuxC.getTiempo() + "\"]\n";
                AuxC = AuxC.getSiguiente();
            }
            AuxN = AuxN.getSiguiente();
        }
        Dot += "\n}";
        return Dot;
    }
    
    public String SubGrafo(){
        String Dot = "subgraph cluster_Mapa {\n\n";
        Nodo AuxN = Nodos.getCabeza();
        while(AuxN != null){
            Dot += "\t" + AuxN.getNombre() + "[label=\"" + AuxN.getNombre() + "\"]\n";
            AuxN = AuxN.getSiguiente();
        }
        Dot+="\n}\n";
        AuxN = Nodos.getCabeza();
        while(AuxN != null){
            Nodo AuxC = AuxN.getCaminos().getCabeza();
            while(AuxC != null){
                Dot += "\t" + AuxN.getNombre() + " -> " + AuxC.getNombre() + " [label=\"" + AuxC.getTiempo() + "\"]\n";
                AuxC = AuxC.getSiguiente();
            }
            AuxN = AuxN.getSiguiente();
        }
        Dot += "\n";
        return Dot;
    }

    public Lista getNodos() {
        return Nodos;
    }

    public void setNodos(Lista Nodos) {
        this.Nodos = Nodos;
    }
}
