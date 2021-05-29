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
public class SoftwareProduct extends Product implements Serializable{

      private int NumberOfUsers;

    public SoftwareProduct(int NumberOfUsers, long id, String name, String Description, float PricePeUnit) {
        super(id, name, Description, PricePeUnit);
        this.NumberOfUsers = NumberOfUsers;
    }

    public SoftwareProduct() {
          
    }

      
    public int getNumberOfUsers() {
        return NumberOfUsers;
    }

    public void setNumberOfUsers(int NumberOfUsers) {
        this.NumberOfUsers = NumberOfUsers;
    }
       
    @Override
    public float getPrice() {
        return this.getPricePeUnit()+NumberOfUsers;
    }

    @Override
    public String toString() {
        return "SoftwareProduct{" + "NumberOfUsers=" + NumberOfUsers + '}'+super.toString();
    }
   
    
    
}
