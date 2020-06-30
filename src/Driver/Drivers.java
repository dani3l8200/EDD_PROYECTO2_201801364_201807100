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
public class Drivers {
    private String DPI;
    private String Name;
    private String Last_Name;
    private Character type_Of_License;
    private String Gender;
    private String Date;
    private int Phone;
    private String Direction;
    private int generate_income;

    public Drivers(String DPI, String Name, String Last_Name, Character type_Of_License, String Gender, int Phone, String Direction) {
        this.DPI = DPI;
        this.Name = Name;
        this.Last_Name = Last_Name;
        this.type_Of_License = type_Of_License;
        this.Gender = Gender;
        this.Phone = Phone;
        this.Direction = Direction;
    }

    public Drivers(String DPI, String Name, String Last_Name, Character type_Of_License, String Gender, String Date, int Phone, String Direction) {
        this.DPI = DPI;
        this.Name = Name;
        this.Last_Name = Last_Name;
        this.type_Of_License = type_Of_License;
        this.Gender = Gender;
        this.Date = Date;
        this.Phone = Phone;
        this.Direction = Direction;
    }
    
    
    
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public Drivers(String DPI) {
        this.DPI = DPI;
    }

    public int getGenerate_income() {
        return generate_income;
    }

    public void setGenerate_income() {
        generate_income += 1;
    }
    

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public Character getType_Of_License() {
        return type_Of_License;
    }

    public void setType_Of_License(Character type_Of_License) {
        this.type_Of_License = type_Of_License;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String Direction) {
        this.Direction = Direction;
    }

    @Override
    public String toString() {
        return "Drivers{" + "DPI=" + DPI + '}';
    }
    
    
    
    
}
