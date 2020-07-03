//@author Dabs
package Viajes;

import Huffman.Codificador;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.DefaultFontMapper;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import edd_proyecto2_201801364_201807100.ImpresoraDot;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class BlockChain {
    private static BlockChain Ldriver,Lvehicle,Lcustomers;
    public Viaje Cabeza;
    public int count_drivers, count_vehicles,count_customers;
    public static String report4 = "";
     public static JFreeChart charViajes; 
    public BlockChain(){
        Cabeza = null;
        count_drivers = 0;
        count_vehicles = 0;
        count_customers = 0;
    }
    
    public void Insertar(Viaje Nuevo){ 
        if(Cabeza == null){
            Cabeza = Nuevo;
        }else{
           
            
            Viaje n = Cabeza;
            while(n.getSiguiente()!=null){
                n = n.getSiguiente();
            }
            n.setSiguiente(Nuevo);
        }
    }
    
    public void InsertDriver(Viaje Nuevo){
        if(Cabeza == null){
            Cabeza = Nuevo;
            
        }else{    
            Viaje n = BuscarConductor(Nuevo.getConductor().getDPI());
            if(n != null)
                return;
            n = Cabeza;
            while(n.getSiguiente()!=null){
                n = n.getSiguiente();
            }
            n.setSiguiente(Nuevo);
            
        }
        OrderListDriver();
    }
    
    public void InsertVehicle(Viaje Nuevo){
        if(Cabeza == null){
            Cabeza = Nuevo;
            
        }else{    
            Viaje n = BuscarVehiculo(Nuevo.getVehiculo().getLicensePlate());
            if(n != null)
                return;
            n = Cabeza;
            while(n.getSiguiente()!=null){
                n = n.getSiguiente();
            }
            n.setSiguiente(Nuevo);
            
        }
        OrderListVehicle();
    }
    
    public void InsertCustomers(Viaje Nuevo){
        if(Cabeza == null){
            Cabeza = Nuevo;
            
        }else{    
            Viaje n = BuscarCliente(Nuevo.getCliente().getDPI());
            if(n != null)
                return;
            n = Cabeza;
            while(n.getSiguiente()!=null){
                n = n.getSiguiente();
            }
            n.setSiguiente(Nuevo);
            
        }
        OrderListCustomers();
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
    
    public Viaje BuscarConductor(String dpi){
        Viaje temp = Cabeza;
         while(temp != null && (temp.getConductor().getDPI() == null ? dpi != null : !temp.getConductor().getDPI().equals(dpi))){
            temp = temp.getSiguiente();
        }
        if(temp != null)
           return temp;
        return null;
    }
    
    public Viaje BuscarVehiculo(String Placa){
        Viaje temp = Cabeza;
         while(temp != null && (temp.getVehiculo().getLicensePlate()== null ? Placa != null : !temp.getVehiculo().getLicensePlate().equals(Placa))){
            temp = temp.getSiguiente();
        }
        if(temp != null)
           return temp;
        return null;
    }
    
    public Viaje BuscarCliente(String dpi){
        Viaje temp = Cabeza;
         while(temp != null && (temp.getCliente().getDPI()== null ? dpi != null : !temp.getCliente().getDPI().equals(dpi))){
            temp = temp.getSiguiente();
        }
        if(temp != null)
           return temp;
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
    
    public BlockChain CopyVehiclesOtherList(){
        Lvehicle = new BlockChain();
        Viaje aux = Cabeza;
        while(aux != null){
            Viaje in = new Viaje(aux.getOrigen(), aux.getDestino(), aux.getDia(),aux.getMes(), aux.getAño(), aux.getHora(), aux.getMinuto(), aux.getCliente(), aux.getConductor(), aux.getVehiculo(), aux.getRuta());
         if(Lvehicle.getCabeza() == null){
                Lvehicle.InsertVehicle(in);
            }else{
                Viaje auxi = Lvehicle.getCabeza();
                while(auxi != null){
                    if(auxi.getSiguiente() == null){
                        Lvehicle.InsertVehicle(in);
                        break;
                    }
                    auxi = auxi.getSiguiente();
                }
            }
            aux = aux.getSiguiente();
        }
        return Lvehicle;
    }
    
    public BlockChain CopyDriversOtherList(){
        Ldriver = new BlockChain();
        Viaje aux = Cabeza;
        while(aux != null){
            Viaje in = new Viaje(aux.getOrigen(), aux.getDestino(), aux.getDia(),aux.getMes(), aux.getAño(), aux.getHora(), aux.getMinuto(), aux.getCliente(), aux.getConductor(), aux.getVehiculo(), aux.getRuta());
            if(Ldriver.getCabeza() == null){
                Ldriver.InsertDriver(in);
            }else{
                Viaje auxi = Ldriver.getCabeza();
                while(auxi != null){
                    if(auxi.getSiguiente() == null){
                        Ldriver.InsertDriver(in);
                        break;
                    }
                    auxi = auxi.getSiguiente();
                }
            }
            aux = aux.getSiguiente();
        }
        return Ldriver;
 
    }
    
    public BlockChain CopyCustomersOtherList(){
        Lcustomers = new BlockChain();
        Viaje aux = Cabeza;
        while(aux != null){
            Viaje in = new Viaje(aux.getOrigen(), aux.getDestino(), aux.getDia(),aux.getMes(), aux.getAño(), aux.getHora(), aux.getMinuto(), aux.getCliente(), aux.getConductor(), aux.getVehiculo(), aux.getRuta());
            if(Lcustomers.getCabeza() == null){
                Lcustomers.InsertCustomers(in);
            }else{
                Viaje auxi = Lcustomers.getCabeza();
                while(auxi != null){
                    if(auxi.getSiguiente() == null){
                        Lcustomers.InsertCustomers(in);
                        break;
                    }
                    auxi = auxi.getSiguiente();
                }
            }
            aux = aux.getSiguiente();
        }
        return Lcustomers;
    }
    public void GenerateGraficaReportDrivers(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
       CopyDriversOtherList();     
       while(Ldriver.getCabeza() != null && count_drivers <= 10){
           dataSet.setValue(Ldriver.getCabeza().getConductor().getGenerate_income(), "No. Ingresos", Ldriver.getCabeza().getConductor().getName());
           count_drivers++;
          Ldriver.Cabeza = Ldriver.Cabeza.getSiguiente();
       }
       count_drivers = 0;
       JFreeChart chart = ChartFactory.createBarChart("Conductores Con Mas Ingresos","Conductores","No. Ingresos",dataSet,PlotOrientation.VERTICAL,false,true,false);
       String RutaEDD = System.getProperty("user.dir") + "\\" + "TopConductoresBarras" + ".pdf";
        try {
            FileOutputStream archivo = new FileOutputStream(RutaEDD);
            File Archivo = new File(RutaEDD);
            Document doc = new Document();
            PdfWriter writer = PdfWriter.getInstance(doc, archivo);
            doc.open();
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(500, 500);
            Graphics2D gra = template.createGraphics(500, 500, new DefaultFontMapper());
            Rectangle2D rec = new Rectangle2D.Double(0, 0, 500, 500);
            chart.draw(gra, rec);
            gra.dispose();
            contentByte.addTemplate(template, 0, 0);
            doc.close();
            JOptionPane.showMessageDialog(null, "Grafica de Tops Conductores Generada");
                try {
                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supported");
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();
                    if(Archivo.exists()) desktop.open(Archivo);
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null,a.getCause());
                }
        } catch (Exception e) {
        }
    }
    public void GenerateReportTopDrivers(boolean decOrcom){
        String report1 = "";
        int count = 1;
        Codificador Prueba = new Codificador();
        
            CopyDriversOtherList();
        
        while(Ldriver.getCabeza() != null && count_drivers <= 10){
            report1 += count + ". " + "Origen: " +Ldriver.getCabeza().getOrigen() +", "
                    + "Destino: " +Ldriver.getCabeza().getDestino() + ", " 
                    + "Nombre Conductor: "+ Ldriver.getCabeza().getConductor().getName() + ", " 
                    + "Apellidos: "+Ldriver.getCabeza().getConductor().getLast_Name()
                    + ", " + "Direccion: "+ Ldriver.getCabeza().getConductor().getDirection()
                    + ", " + "No. veces generado dinero: "+ Ldriver.getCabeza().getConductor().getGenerate_income() +"\n";
            count++;
            count_drivers++;
            Ldriver.Cabeza = Ldriver.Cabeza.getSiguiente();
        }
        count_drivers = 0;
        if(decOrcom == true){
         
            String total =  "TEXTO COMPRIMIDO\n";
            String aux = Prueba.Datos(report1);
            total += "\nTodo codificado\n" + Prueba.Generar(report1) + "\n\nFrecuencias y valores de cada caracter:\n";
            
            total += aux;
           
            
            ImpresoraDot Impresora = new ImpresoraDot();
            Impresora.ImprimirTxT("ReporteTopDrivers", total);
        }else{
            try {
                String aux  = "TEXTO DECODIFICADO\n\n";
                String decode =  Prueba.Generar(report1);
                aux += Prueba.Desencriptar(decode);
             
                 ImpresoraDot Impresora = new ImpresoraDot();
                Impresora.ImprimirTxT("ReporteTopDriversComprimido",aux );
            } catch (Exception e) {
                System.err.println("No hay texto para codificar");
            }
        }
    }
    
    public void GenerarGraficaReportVehicles(){
       DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
       CopyVehiclesOtherList();     
       while(Lvehicle.getCabeza() != null && count_vehicles <= 10){
           dataSet.setValue(Lvehicle.getCabeza().getVehiculo().getGenerate_trips(), "No. Viajes", Lvehicle.getCabeza().getVehiculo().getLicensePlate());
           count_vehicles++;
          Lvehicle.Cabeza = Lvehicle.Cabeza.getSiguiente();
       }
       count_vehicles = 0;
       JFreeChart chart = ChartFactory.createBarChart("Vehiculos Con Mas Viajes","Vehiculos","No. Viajes",dataSet,PlotOrientation.VERTICAL,false,true,false);
       String RutaEDD = System.getProperty("user.dir") + "\\" + "TopVehiculosBarras" + ".pdf";
        try {
            FileOutputStream archivo = new FileOutputStream(RutaEDD);
            File Archivo = new File(RutaEDD);
            Document doc = new Document();
            PdfWriter writer = PdfWriter.getInstance(doc, archivo);
            doc.open();
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(500, 500);
            Graphics2D gra = template.createGraphics(500, 500, new DefaultFontMapper());
            Rectangle2D rec = new Rectangle2D.Double(0, 0, 500, 500);
            chart.draw(gra, rec);
            gra.dispose();
            contentByte.addTemplate(template, 0, 0);
            doc.close();
            JOptionPane.showMessageDialog(null, "Grafica de Tops Vehiculos Generada");
                try {
                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supported");
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();
                    if(Archivo.exists()) desktop.open(Archivo);
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null,a.getCause());
                }
        } catch (Exception e) {
        }
    }
    
    public void GenerateReportTopVehicles(boolean decOrcom){
        String report2 = "";
        int count = 1;
        Codificador Prueba = new Codificador();
        
            CopyVehiclesOtherList();
        
        while(Lvehicle.getCabeza() != null && count_vehicles <= 10){
            report2 += count + ". " +"No. de viajes: " + Lvehicle.getCabeza().getVehiculo().getGenerate_trips()
                    +"Origen: "+Lvehicle.getCabeza().getOrigen()+","
                    +"Destino: "+Lvehicle.getCabeza().getDestino()+", "
                    +"Placa: " +Lvehicle.getCabeza().getVehiculo().getLicensePlate()+ ", "
                    +"Marca: " +Lvehicle.getCabeza().getVehiculo().getBrand()
                    + ", " +"Modelo: "+ Lvehicle.getCabeza().getVehiculo().getModel()
                    + ", " + "Year: "+Lvehicle.getCabeza().getVehiculo().getColor()
                    + ", "+ "Precio: "+Lvehicle.getCabeza().getVehiculo().getPrice()+ "\n";
            count++;
            count_vehicles++;
            Lvehicle.Cabeza = Lvehicle.Cabeza.getSiguiente();
        }
        count_vehicles = 0;
        if(decOrcom == true){
         
            String total =  "TEXTO COMPRIMIDO\n";
            String aux = Prueba.Datos(report2);
            total += "\nTodo codificado\n" + Prueba.Generar(report2) + "\n\nFrecuencias y valores de cada caracter:\n";
            
            total += aux;
           
            
            ImpresoraDot Impresora = new ImpresoraDot();
            Impresora.ImprimirTxT("ReporteTopVehicle", total);
        }else{
            try {
                String aux  = "TEXTO DECODIFICADO\n\n";
                String decode =  Prueba.Generar(report2);
                aux += Prueba.Desencriptar(decode);
             
                 ImpresoraDot Impresora = new ImpresoraDot();
                Impresora.ImprimirTxT("ReporteTopVehicleDescomprimido",aux );
            } catch (Exception e) {
                System.err.println("No hay texto para codificar");
            }
        }
    }
    
    public void GenerarGraficaReportCustomers(){
       DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
       CopyCustomersOtherList();
       
       while(Lcustomers.getCabeza() != null && count_customers <= 10){
           dataSet.setValue(Lcustomers.getCabeza().getCliente().getGenerate_trips(), "No. Viajes", Lcustomers.getCabeza().getCliente().getName());
           count_customers++;
          Lcustomers.Cabeza = Lcustomers.Cabeza.getSiguiente();
       }
       count_customers = 0;
       JFreeChart chart = ChartFactory.createBarChart("Clientes Con Mas Viajes","Clientes","No. Viajes",dataSet,PlotOrientation.VERTICAL,false,true,false);
       String RutaEDD = System.getProperty("user.dir") + "\\" + "TopClientesBarras" + ".pdf";
        try {
            FileOutputStream archivo = new FileOutputStream(RutaEDD);
            File Archivo = new File(RutaEDD);
            Document doc = new Document();
            PdfWriter writer = PdfWriter.getInstance(doc, archivo);
            doc.open();
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(500, 500);
            Graphics2D gra = template.createGraphics(500, 500, new DefaultFontMapper());
            Rectangle2D rec = new Rectangle2D.Double(0, 0, 500, 500);
            chart.draw(gra, rec);
            gra.dispose();
            contentByte.addTemplate(template, 0, 0);
            doc.close();
            JOptionPane.showMessageDialog(null, "Tabla con todos los vehiculos generada");
                try {
                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supported");
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();
                    if(Archivo.exists()) desktop.open(Archivo);
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null,a.getCause());
                }
        } catch (Exception e) {
        }
   }
    
    public void GenerateReportTopCustomers(boolean decOrcom){
        String report3 = "";
        int count = 1;
        Codificador Prueba = new Codificador();
        
            CopyCustomersOtherList();
        
        while(Lcustomers.getCabeza() != null && count_customers <= 10){
            report3 += count + ". "+"No. Pedidos de Viajes: "+Lcustomers.getCabeza().getCliente().getGenerate_trips()+", " +"Origen: " +Lcustomers.getCabeza().getOrigen() +", "
                    +"Destino: " + Lcustomers.getCabeza().getDestino() + ", "
                    +"DPI: "+Lcustomers.getCabeza().getCliente().getDPI()+ ", "
                    + "Nombre: "+  Lcustomers.getCabeza().getCliente().getName()
                    +  ", " + "Apellidos: "+ Lcustomers.getCabeza().getCliente().getLast_name()+ ", " 
                    + "Conductor: "+ Lcustomers.getCabeza().getConductor().getName() + ", "
                    + "DPI Conductor: " + Lcustomers.getCabeza().getConductor().getDPI()+ ", "
                    + "No. Placa de auto: "+Lcustomers.getCabeza().getVehiculo().getLicensePlate()+ "\n";
            count++;
            count_customers++;
            Lcustomers.Cabeza = Lcustomers.Cabeza.getSiguiente();
        }
        count_customers = 0;
        if(decOrcom == true){
         
            String total =  "TEXTO COMPRIMIDO\n";
            String aux = Prueba.Datos(report3);
            total += "\nTodo codificado\n" + Prueba.Generar(report3) + "\n\nFrecuencias y valores de cada caracter:\n";
            
            total += aux;
           
            
            ImpresoraDot Impresora = new ImpresoraDot();
            Impresora.ImprimirTxT("ReporteTopCustomers", total);
        }else{
            try {
                String aux  = "TEXTO DECODIFICADO\n\n";
                String decode =  Prueba.Generar(report3);
                aux += Prueba.Desencriptar(decode);
             
                 ImpresoraDot Impresora = new ImpresoraDot();
                Impresora.ImprimirTxT("ReporteTopCustomersDescomprimido",aux );
            } catch (Exception e) {
                System.err.println("No hay texto para codificar");
            }
        }
    }
    public void GenerarGraficaReportViajes(){      
       String RutaEDD = System.getProperty("user.dir") + "\\" + "TopViajesBarras" + ".pdf";
        try {
            FileOutputStream archivo = new FileOutputStream(RutaEDD);
            File Archivo = new File(RutaEDD);
            Document doc = new Document();
            PdfWriter writer = PdfWriter.getInstance(doc, archivo);
            doc.open();
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(500, 500);
            Graphics2D gra = template.createGraphics(500, 500, new DefaultFontMapper());
            Rectangle2D rec = new Rectangle2D.Double(0, 0, 500, 500);
            charViajes.draw(gra, rec);
            gra.dispose();
            contentByte.addTemplate(template, 0, 0);
            doc.close();
            JOptionPane.showMessageDialog(null, "Grafica de Barras de Viajes generada");
                try {
                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supported");
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();
                    if(Archivo.exists()) desktop.open(Archivo);
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null,a.getCause());
                }
        } catch (Exception e) {
        }
    }
    public void GenerateReportTopViajes(boolean decOrcom){
       report4 = "";
        Codificador Prueba = new Codificador();
        TopViajes();
        String report4Aux = report4;
        if(decOrcom == true){
            String total =  "TEXTO COMPRIMIDO\n";
            String aux = Prueba.Datos(report4Aux);
            total += "\nTodo codificado\n" + Prueba.Generar(report4Aux) + "\n\nFrecuencias y valores de cada caracter:\n";        
            total += aux;
            ImpresoraDot Impresora = new ImpresoraDot();
            Impresora.ImprimirTxT("ReporteTopCustomers", total);
        }else{
            try {
                String aux  = "TEXTO DECODIFICADO\n\n";
                String decode =  Prueba.Generar(report4Aux);
                aux += Prueba.Desencriptar(decode);
             
                ImpresoraDot Impresora = new ImpresoraDot();
                Impresora.ImprimirTxT("ReporteTopCustomersDescomprimido",aux );
            } catch (Exception e) {
                System.err.println("No hay texto para codificar");
            }
        }
        
    }
    
    public void OrderListDriver(){
        Viaje p, q;
        Driver.Drivers driver;
        if(Cabeza == null){
            return;
        }else{
            p = Cabeza;
            while(p != null){
               q = p.getSiguiente();
               while(q != null){
                   if(p.getConductor().getGenerate_income() < q.getConductor().getGenerate_income()){
                       driver = p.getConductor();
                       p.setConductor(q.getConductor());
                       q.setConductor(driver);
                   }
                   q = q.getSiguiente();
                   if(q == Cabeza){
                       break;
                   }
               }
               p = p.getSiguiente();
               
            }
        }
        
    }
    
    public void OrderListVehicle(){
         Viaje p, q;
        Vehicle.Vehicle vehicle;
        if(Cabeza == null){
            return;
        }else{
            p = Cabeza;
            while(p != null){
               q = p.getSiguiente();
               while(q != null){
                   if(p.getVehiculo().getGenerate_trips()< q.getVehiculo().getGenerate_trips()){
                       vehicle = p.getVehiculo();
                       p.setVehiculo(q.getVehiculo());
                       q.setVehiculo(vehicle);
                   }
                   q = q.getSiguiente();
                   if(q == Cabeza){
                       break;
                   }
               }
               p = p.getSiguiente();
               
            }
        }
    }
   
    public void OrderListCustomers(){
         Viaje p, q;
        Customers.Customers customers;
        if(Cabeza == null){
            return;
        }else{
            p = Cabeza;
            while(p != null){
               q = p.getSiguiente();
               while(q != null){
                   if(p.getCliente().getGenerate_trips()< q.getCliente().getGenerate_trips()){
                       customers = p.getCliente();
                       p.setCliente(q.getCliente());
                       q.setCliente(customers);
                   }
                   q = q.getSiguiente();
                   if(q == Cabeza){
                       break;
                   }
               }
               p = p.getSiguiente();
               
            }
        } 
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
    
    public String SubGrafo(){
        try {
            String Dot = "subgraph cluster_BlockChain {\n\n";
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
    
    public Viaje[] TopViajes(){
        Viaje TopViajes[] = new Viaje[10];
        for(int i=0; i<10; i++){
            TopViajes[i] = null;
        }
        Viaje Aux = Cabeza;
        while(Aux!=null){
            for(int i=0; i<10; i++){
                if(TopViajes[i] == null){
                    TopViajes[i] = Aux;
                    i=10;
                }else{
                    if(TopViajes[i].getRuta().CantidadNodos() < Aux.getRuta().CantidadNodos()){
                        for(int j=9; j>i; j--){
                            TopViajes[j] = TopViajes[j-1];
                        }
                        TopViajes[i] = Aux;
                        i=10;
                    }
                }
            }
            Aux = Aux.getSiguiente();
        }
        
        int count = 1;
         
            for(int i =0; i<10; i++){
                if(TopViajes[i] != null){
                report4 += count + ". "  +TopViajes[i].getDia() + " " + TopViajes[i].getOrigen() + " " + TopViajes[i].getDestino()+" "+ TopViajes[i].getRuta().TiempoTotal() +" "+ TopViajes[i].getConductor().getName()+ " " + TopViajes[i].getCliente().getName()
                    + " " + TopViajes[i].getVehiculo().getBrand()+ "\n";
                 count++;
                }
            }
         DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
         for(int i = 0; i<10; i++){
             if(TopViajes[i] != null){
                 dataSet.setValue(TopViajes[i].getRuta().TiempoTotal(), "Recorrido (KM)", TopViajes[i].getDestino());
             }
         }
         charViajes = ChartFactory.createBarChart("VIajes mas Largos","Viajes","Recorrido (KM)",dataSet,PlotOrientation.VERTICAL,false,true,false);
            
        return TopViajes;
    }
    
    
   

    public Viaje getCabeza() {
        return Cabeza;
    }

    public void setCabeza(Viaje Cabeza) {
        this.Cabeza = Cabeza;
    }
}
