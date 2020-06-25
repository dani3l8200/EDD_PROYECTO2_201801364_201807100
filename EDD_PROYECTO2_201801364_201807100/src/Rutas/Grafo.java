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
        if(Primero != null && Segundo != null){
            Primero.getCaminos().Insertar(new Nodo(Second, Tiempo));
            Segundo.getCaminos().Insertar(new Nodo(First, Tiempo));
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
        Lista Hecho = new Lista();
        Nodo AuxN = Nodos.getCabeza();
        while(AuxN != null){
            Dot += "\t" + AuxN.getNombre() + "[label=\"" + AuxN.getNombre() + "\"]\n";
            AuxN = AuxN.getSiguiente();
        }
        Dot+="\n";
        AuxN = Nodos.getCabeza();
        while(AuxN != null){
            Hecho.Insertar(new Nodo(AuxN.getNombre()));
            Nodo AuxC = AuxN.getCaminos().getCabeza();
            while(AuxC != null){
                if(Hecho.Buscar(AuxC.getNombre()) == null){
                    Dot += "\t" + AuxN.getNombre() + " -> " + AuxC.getNombre() + " [arrowhead=none, label=\"" + AuxC.getTiempo() + "\"]\n";
                }
                AuxC = AuxC.getSiguiente();
            }
            AuxN = AuxN.getSiguiente();
        }
        Dot += "\n}";
        return Dot;
    }

    public Lista getNodos() {
        return Nodos;
    }

    public void setNodos(Lista Nodos) {
        this.Nodos = Nodos;
    }
}
