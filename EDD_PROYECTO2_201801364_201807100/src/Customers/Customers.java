/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers;

/**
 *
 * @author dani3l8200
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dani3l8200
 */
public class Customers{
    
    private String DPI;
    private String name;
    private String last_name;
    private String gender;
    private int phone;
    private String direction;
    
    public Customers(){}

    public Customers(String DPI, String name, String last_name, String gender, int phone, String direction) {
        this.DPI = DPI;
        this.name = name;
        this.last_name = last_name;
        this.gender = gender;
        this.phone = phone;
        this.direction = direction;
    }
    
    
    
    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    @Override
    public String toString(){
        return DPI + " " + name + " " + last_name + " " + gender + " " + phone;
    }
  
    
}

