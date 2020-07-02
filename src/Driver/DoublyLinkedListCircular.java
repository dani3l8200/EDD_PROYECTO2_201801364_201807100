/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author dani3l8200
 */
public class DoublyLinkedListCircular {
    private node_Driver start;
    private node_Driver last;
    private static final PdfPTable tabla = new PdfPTable(new float[]{20,20,20,20,20,20,20,20});
        private static PdfPCell  titleCell;
        private static Paragraph column1,column2,column3,column4,column5,column6,column7,column8,
                                  data1,data2,data3,data4,data5,data6,data7,data8;
    public int size;
    public DoublyLinkedListCircular(){
        start = null;
        last = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return start == null;
    }
    
    public int getSize(){
        return size;
    }
    
    public void insertBegin(Drivers drivers){
        node_Driver n = Search(drivers.getDPI());
        if(n != null)
            return;
        n = new node_Driver(drivers);
        if(start == null){
         
            start = n;
            last = start;
        }else{
            n.next = start;
            start.prev = n;
            start = n;
        }
        size++;
        sortList(true);
    }
    
    public void insertLast(Drivers drivers){
        node_Driver n = Search(drivers.getDPI());
        if(n != null)
            return;
        n = new node_Driver(drivers);
        if(start == null){          
            start = n;
            last = start;
        }else{
            last.next = n;
            n.prev = last;
            last = n;           
        }
       size++;
       sortList(true);
    }
    
    public void delete(String DPI){
       
        node_Driver p = Search(DPI);
        node_Driver q = start; 
        if(q.getDriver().getDPI().equals(DPI)){
            last = q.getPrev();
            node_Driver temp = p.getNext();
            start = temp;
            size--;
            return;
        }
        q = q.getNext();
        while(!q.getDriver().getDPI().equals(DPI) && q != start){
            q = q.getNext();
        }
        if(q.getDriver().getDPI().equals(DPI)){
            last = q.getPrev();
            last.next = q.next;
            size--;
            
        }else{
            System.out.println("Elemento no encontrado");
        }
       
    }
    
    public void EditDrivers(String _dpi,String _newDPI,String _name, String _last_name,Character type_Of_License ,String _gender,String _date,int _phone,String _direction){
        Drivers driver = SearchForUpdate(_dpi);
        if(driver == null)
            return;
        driver.setDPI(_newDPI);
        driver.setName(_name);
        driver.setLast_Name(_last_name);
        driver.setType_Of_License(type_Of_License);
        driver.setGender(_gender);
        driver.setDate(_date);
        driver.setPhone(_phone);
        driver.setDirection(_direction);
    }
    
    public node_Driver Search(String DPI){
        node_Driver temp = start;
        while(temp != null && (temp.getDriver().getDPI() == null ? DPI != null : !temp.getDriver().getDPI().equals(DPI))){
            temp = temp.getNext();
        }
        if(temp != null)
            return temp;
        return null;
    }
    
    public Drivers SearchForUpdate(String DPI){
        node_Driver temp = Search(DPI);
        if(temp == null)
            return null;
        return temp.getDriver();
    }
    
     public void print() {
          node_Driver next = start;
        if(size==0){
            System.out.println("Lista vacia");
            return;
        }
        while (next != null) {
            System.out.print(next.getDriver() + " ");
            System.out.println();
            next = next.next; 
        }
        System.out.println();
   
    }
     
    public void generatePDF(){
        String RutaEDD = System.getProperty("user.dir") + "\\" + "TablaVehiculos" + ".pdf";
        try {
            FileOutputStream archivo = new FileOutputStream(RutaEDD);
                File Archivo = new File(RutaEDD);
                Document doc = new Document();
                PdfWriter.getInstance(doc, archivo);
                doc.open();
                doc.add(new Paragraph("Drivers",FontFactory.getFont(FontFactory.HELVETICA,20,BaseColor.ORANGE)));
                doc.add(new Paragraph(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date())));
                doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                tabla.setWidthPercentage(100);
                titleCell = new PdfPCell(new Paragraph("Table Drivers"));
                titleCell.setColspan(8);
                titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                titleCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.deleteBodyRows();
                tabla.addCell(titleCell);
                column1 = new Paragraph("DPI",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.YELLOW));
                column2 = new Paragraph("Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.YELLOW));
                column3 = new Paragraph("Last Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.YELLOW));
                column4 = new Paragraph("Type of License",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.YELLOW));
                column5 = new Paragraph("Gender",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.YELLOW));
                column6 = new Paragraph("Date",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.YELLOW));
                column7 = new Paragraph("Phone",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.YELLOW));
                column8 = new Paragraph("Direction",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.YELLOW));
                tabla.addCell(column1);
                tabla.addCell(column2);
                tabla.addCell(column3);
                tabla.addCell(column4);
                tabla.addCell(column5);
                tabla.addCell(column6);
                tabla.addCell(column7);
                tabla.addCell(column8);
                try {
                    node_Driver next = start;
                    while (next != null) {
                       data1 = new Paragraph(next.getDriver().getDPI(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data2 = new Paragraph(next.getDriver().getName(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data3 = new Paragraph(next.getDriver().getLast_Name(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data4 = new Paragraph(String.valueOf(next.getDriver().getType_Of_License()),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data5 = new Paragraph(next.getDriver().getGender(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data6 = new Paragraph(next.getDriver().getDate(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data7 = new Paragraph(Integer.toString(next.getDriver().getPhone()),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data8 = new Paragraph(next.getDriver().getDirection(),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       tabla.addCell(data1);
                       tabla.addCell(data2);
                       tabla.addCell(data3);
                       tabla.addCell(data4);
                       tabla.addCell(data5);
                       tabla.addCell(data6);
                       tabla.addCell(data7);
                       tabla.addCell(data8);
                       next = next.next; 
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                  }
                 doc.add(tabla);
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
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
   }
     
    public String generateDot(){
        String myreport1 = "digraph report1 {\n";
        if(start != null){
            myreport1 += "\t  rankdir=LR;\n\t graph[bgcolor = orange]\n\t node [shape=record,width=0.25,height =0.25,style=filled, fillcolor=lemonchiffon1];\n\t\t";
            myreport1 += "edge [color=black,tailclip=false];\n\tnodesep=1.5;\n\tranksep = 0.4; \n\t splines=true; \n\t"; 
            node_Driver p = start;
            
            for(int i = 0;i<size;i++){
                myreport1 += "pos" + i;
		myreport1 += "[fillcolor=yellow,label = ";
		myreport1 += "\"{<ref1>|<data> ";
		myreport1 += "DPI " + p.getDriver().getDPI() + "\\n" + "Name " + p.getDriver().getName() + "\\n" +"Last Name : " +p.getDriver().getLast_Name() + "\\n"+  "Type License : " + p.getDriver().getType_Of_License() + "\\n"+ "Gender: " + p.getDriver().getGender() + "\\n"+ "Phone: " + p.getDriver().getPhone() + "\\n"+ "Direction: " + p.getDriver().getDirection()+ " | <ref> }\"];\n\t";          
                p = p.next;
            }
            
            for(int i = 0; i<size-1;i++){
		myreport1 += "pos" + i + ":ref:c -> pos" + (i+1) +":ref1:c"+ "[arrowhead=vee, arrowtail=dot, dir=both];\n\t";

                myreport1 += "pos" + (i+1) + ":ref1:n -> pos" + (i) +":ref:n"+ "[arrowhead=vee, arrowtail=dot, dir=both];\n\t";

            }
            for(int i = 0; i<= size-1;i++){
			if(i == size-1){
                            myreport1 += "pos0:ref1:n ->  pos" + (i) + ":ref:n[dir=forward,arrowhead=vee];\n\t";
                            myreport1 += "pos0:ref1:s ->  pos" + (i) + ":ref:s[splines=\"false\",dir=back,arrowhead=vee];\n\t";
                        }
            }
        }
        myreport1 += "}";
        return myreport1;
    }
    
    public String SubGrafo(){
        String myreport1 = "subgraph cluster_LConductores {\n";
        if(start != null){
            myreport1 += "\t  rankdir=LR;\n\t graph[bgcolor = orange]\n\t node [shape=record,width=0.25,height =0.25,style=filled, fillcolor=lemonchiffon1];\n\t\t";
            myreport1 += "edge [color=black,tailclip=false];\n\tnodesep=1.5;\n\tranksep = 0.4; \n\t"; 
            node_Driver p = start;
            
            for(int i = 0;i<size;i++){
                myreport1 += "pos" + i;
		myreport1 += "[fillcolor=yellow,label = ";
		myreport1 += "\"{<ref1>|<data> ";
		myreport1 += "DPI " + p.getDriver().getDPI() + "\\n" + "Name " + p.getDriver().getName() + "\\n" +"Last Name : " +p.getDriver().getLast_Name() + "\\n"+  "Type License : " + p.getDriver().getType_Of_License() + "\\n"+ "Gender: " + p.getDriver().getGender() + "\\n"+ "Phone: " + p.getDriver().getPhone() + "\\n"+ "Direction: " + p.getDriver().getDirection()+ " | <ref> }\"];\n\t";          
                p = p.next;
            }
            
            for(int i = 0; i<size-1;i++){
		myreport1 += "pos" + i + ":ref:c -> pos" + (i+1) +":ref1:c"+ "[arrowhead=vee, arrowtail=dot, dir=both];\n\t";

                myreport1 += "pos" + (i+1) + ":ref1:n -> pos" + (i) +":ref:n"+ "[arrowhead=vee, arrowtail=dot, dir=both];\n\t";

            }
            for(int i = 0; i<= size-1;i++){
			if(i == size-1){
                            myreport1 += "pos0:ref1:n ->  pos" + (i) + ":ref:n[dir=forward,arrowhead=vee];\n\t";
                            myreport1 += "pos0:ref1:s ->  pos" + (i) + ":ref:s[splines=\"false\",dir=back,arrowhead=vee];\n\t";
                        }
            }
        }
        myreport1 += "}";
        return myreport1;
    }
    
    public void sortList(boolean asc){
        node_Driver p, q;
        Drivers drivers;
        if(start == last && start == null){
            return;
        }else{
            if(asc == true){
                p = start;
                while(p != null){
                    for(q = p.next; q != null; q = q.next){
                        if(q == start){
                            break;
                        }
                        if(p.getDriver().getDPI().compareTo(q.getDriver().getDPI())> 0){
                            drivers = p.getDriver();
                            p.setDriver(q.getDriver());
                            q.setDriver(drivers);
                        }
                    }
                    p = p.getNext();
                    if(p == last){
                        break;
                    }
                }
            }
        }
        
    }
}
