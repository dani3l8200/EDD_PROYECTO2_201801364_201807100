/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicle;

/**
 *
 * @author dani3l8200
 */
public class Vehicle implements Comparable<Vehicle> {
    private String licensePlate;
    private String brand;
    private String model;
    private int year;
    private String color;
    private String price;
    private String type;
    private int generate_trips;
    
     public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getGenerate_trips() {
        return generate_trips;
    }

    public void setGenerate_trips() {
       generate_trips += 1;
    }
    
    
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
 
    public Vehicle(String licensePlate, String brand, String model, int year, String color, String price, String type) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.type = type;
    }

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    @Override
    public String toString() {
        return  licensePlate;
     
    }
    @Override
	public int compareTo(Vehicle o) {
            return this.licensePlate.compareToIgnoreCase(o.licensePlate)  > 0 ? 1 : this.licensePlate.compareToIgnoreCase(o.getLicensePlate()) < 0 ? -1 : 0;
	}
}

