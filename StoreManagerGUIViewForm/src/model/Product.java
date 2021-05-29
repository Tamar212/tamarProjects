/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author User
 */
public abstract class Product implements Serializable {

    private long id;
    private String name;
    private String Description;
    private float PricePeUnit;

    public Product(long id, String name, String Description, float PricePeUnit) {
        this.id = id;
        this.name = name;
        this.Description = Description;
        this.PricePeUnit = PricePeUnit;
    }

    public Product(){
        
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPricePeUnit(float PricePeUnit) {
        this.PricePeUnit = PricePeUnit;
    }

    
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public float getPricePeUnit() {
        return PricePeUnit;
    }

     public abstract float getPrice();
   
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", Description=" + Description + ", PricePeUnit=" + PricePeUnit + '}';
    }
    
    


}
