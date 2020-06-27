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
public class node_Driver {
    private node_Driver prev, next;
    private Drivers driver;
    public node_Driver(Drivers driver) {
       this.driver = driver;
       this.prev = null;
       this.next = null;
    }

    public node_Driver getPrev() {
        return prev;
    }

    public void setPrev(node_Driver prev) {
        this.prev = prev;
    }

    public node_Driver getNext() {
        return next;
    }

    public void setNext(node_Driver next) {
        this.next = next;
    }

    public Drivers getDriver() {
        return driver;
    }

    public void setDriver(Drivers driver) {
        this.driver = driver;
    }
    
    
}
