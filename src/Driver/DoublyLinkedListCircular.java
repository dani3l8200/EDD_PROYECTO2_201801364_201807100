/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

/**
 *
 * @author dani3l8200
 */
public class DoublyLinkedListCircular {
    protected node_Driver start;
    protected node_Driver last;
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
        String myreport1 = "";
        
        if(start != null){
            myreport1 += "subgraph Conductores {\n";
            myreport1 += "\t  rankdir=LR;\n\t graph[bgcolor = orange]\n\t node [shape=record,width=0.25,height =0.25,style=filled, fillcolor=lemonchiffon1];\n\t\t";
            myreport1 += "edge [color=black,tailclip=false];\n\tnodesep=1.5;\n\tranksep = 0.4; \n\t splines=true; \n\t"; 
            node_Driver p = start;
            for(int i = 0;i<size;i++){
                myreport1 += "Conductor" + p.getDriver().getDPI();
		myreport1 += "[fillcolor=yellow,label = ";
		myreport1 += "\"{<ref1>|<data> ";
		myreport1 += "DPI " + p.getDriver().getDPI() + "\\n" + "Name " + p.getDriver().getName() + "\\n" +"Last Name : " +p.getDriver().getLast_Name() + "\\n"+  "Type License : " + p.getDriver().getType_Of_License() + "\\n"+ "Gender: " + p.getDriver().getGender() + "\\n"+ "Phone: " + p.getDriver().getPhone() + "\\n"+ "Direction: " + p.getDriver().getDirection()+ " | <ref> }\"];\n\t";          
                p = p.next;
            }
            p = start;
            for(int i = 0; i<size-1;i++){
		myreport1 += "Conductor" + p.getDriver().getDPI() + ":ref:c -> Conductor" + p.getNext().getDriver().getDPI() +":ref1:c"+ "[arrowhead=vee, arrowtail=dot, dir=both];\n\t";
                myreport1 += "Conductor" + p.getNext().getDriver().getDPI() + ":ref1:n -> Conductor" + p.getDriver().getDPI() +":ref:n"+ "[arrowhead=vee, arrowtail=dot, dir=both];\n\t";
                p = p.next;
            }
            p = start;
            for(int i = 0; i<= size-1;i++){
		if(i == size-1){
                    myreport1 += "Conductor" + start.getDriver().getDPI() + ":ref1:n ->  Conductor" + p.getDriver().getDPI() + ":ref:n[dir=forward,arrowhead=vee];\n\t";
                    myreport1 += "Conductor" + start.getDriver().getDPI() + ":ref1:s ->  Conductor" + p.getDriver().getDPI() + ":ref:s[splines=\"false\",dir=back,arrowhead=vee];\n\t";
                }
                p = p.next;
            }
            myreport1 += "}";
        }
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
