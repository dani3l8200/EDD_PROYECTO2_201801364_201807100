//@author Dabs
package Viajes;
import Customers.Customers;
import Driver.Drivers;
import Rutas.Lista;
import Vehicle.Vehicle;
public class Viaje {
    private String Origen;
    private String Destino;
    private int Dia;
    private int Mes;
    private int Año;
    private int Hora;
    private int Minuto;
    private Customers Cliente;
    private Drivers Conductor;
    private Vehicle Vehiculo;
    private Lista Ruta;
    private Viaje Siguiente;
    
    public Viaje(String Origen, String Destino, int Dia, int Mes, int Año, int Hora, int Minuto, Customers Cliente, 
                 Drivers Conductor, Vehicle Vehiculo, Lista Ruta){
        this.Origen = Origen;
        this.Destino = Destino;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Año = Año;
        this.Hora = Hora;
        this.Minuto = Minuto;
        this.Cliente = Cliente;
        this.Conductor = Conductor;
        this.Vehiculo = Vehiculo;
        this.Ruta = Ruta;
        Siguiente = null;
    }
    
    public String OptenerClave(){
        return (Vehiculo.getLicensePlate() + DobleNum(Dia) + DobleNum(Mes) + DobleNum(Año) + DobleNum(Hora) + ":" +  DobleNum(Minuto));
    }
    
    public String DobleNum(int Numero){
        if(Numero == 0){
            return "00";
        }else if(Numero < 10){
            return ("0" + Numero);
        }else{
            return Numero + "";
        }
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int Hora) {
        this.Hora = Hora;
    }

    public int getMinuto() {
        return Minuto;
    }

    public void setMinuto(int Minuto) {
        this.Minuto = Minuto;
    }

    public Customers getCliente() {
        return Cliente;
    }

    public void setCliente(Customers Cliente) {
        this.Cliente = Cliente;
    }

    public Drivers getConductor() {
        return Conductor;
    }

    public void setConductor(Drivers Conductor) {
        this.Conductor = Conductor;
    }

    public Vehicle getVehiculo() {
        return Vehiculo;
    }

    public void setVehiculo(Vehicle Vehiculo) {
        this.Vehiculo = Vehiculo;
    }

    public Lista getRuta() {
        return Ruta;
    }

    public void setRuta(Lista Ruta) {
        this.Ruta = Ruta;
    }

    public Viaje getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Viaje Siguiente) {
        this.Siguiente = Siguiente;
    }
}
