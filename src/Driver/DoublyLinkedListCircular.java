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
            n.setPrev(last);
            last.setNext(n);
            start.setPrev(n);
            n.setNext(start);
            start = n;
        }
        size++;
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
            n.setPrev(last);
            last.setNext(n);
            start.setPrev(n);
            n.setNext(start);
            last = start;
        }
       size++;
    }
    
    public void delete(String DPI){
       
        node_Driver p = Search(DPI);
        node_Driver q = start; 
        if(q.getDriver().getDPI().equals(DPI)){
            node_Driver last1 = q.getPrev();
            node_Driver temp = p.getNext();
            last1.setNext(q.getNext());
            temp.setPrev(last1);
            start = temp;
            size--;
            return;
        }
        q = q.getNext();
        while(!q.getDriver().getDPI().equals(DPI) && q != start){
            q = q.getNext();
        }
        if(q.getDriver().getDPI().equals(DPI)){
            node_Driver prev1 = q.getPrev();
            node_Driver next1 = q.getNext();
            prev1.setNext(q.getNext());
            next1.getNext().setPrev(prev1);
            size--;
            return;
        }else{
            System.out.println("Elemento no encontrado");
        }
       /* if(p != null){
            node_Driver temp = start; 
            while(temp.getNext() != start && temp.getNext() != p){
                temp = temp.getNext();
            } 
            if(temp.getNext() != start){
                temp.setNext(p.getNext());
                if(p.getNext() != start){
                    p.getNext().setPrev(temp);
                }
                size--;
            }
        }*/
        
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
     public void print() {
        System.out.print("\nCircular Doubly Linked List = ");
        node_Driver ptr = start;
        if (size == 0)
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getNext()== start)
        {
            System.out.print(start.getDriver()+ " <-> "+ptr.getDriver()+ "\n");
            return;
        }
        System.out.print(start.getDriver()+ " <-> ");
        ptr = start.getNext();
        while (ptr.getNext()!= start)
        {
            System.out.print(ptr.getDriver()+ " <-> ");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getDriver());
       
       

    }
}
