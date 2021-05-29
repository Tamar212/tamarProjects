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
public class HardwareProduct extends Product implements Serializable{
 
    public enum ware{
        SOFTWARE,HARDWARE
    }
    private int WarrantyPeriod;

    public HardwareProduct(int WarrantyPeriod, long id, String name, String Description, float PricePeUnit) {
        super(id, name, Description, PricePeUnit);
        this.WarrantyPeriod = WarrantyPeriod;
    }

    public HardwareProduct() {
        
    }
    
     

    
    public int getWarrantyPeriod() {
        return WarrantyPeriod;
    }

    public void setWarrantyPeriod(int WarrantyPeriod) {
        this.WarrantyPeriod = WarrantyPeriod;
    }
    
    @Override
    public float getPrice() {
        return WarrantyPeriod+this.getPricePeUnit();
    }

    @Override
    public String toString() {
        return "HardwareProduct{" + "WarrantyPeriod=" + WarrantyPeriod + '}'+super.toString();
    }

    
    
    
    
}
