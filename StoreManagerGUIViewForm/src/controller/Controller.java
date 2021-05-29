/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Customer;
import model.HardwareProduct;
import model.Product;
import model.PurchaseOrder;

/**
 *
 * @author student
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        Customer c=new Customer(456856,"meir","hashomer");
        HardwareProduct h=new HardwareProduct(0, 456856, "meir", "aa", 5);
        HardwareProduct h1=new HardwareProduct(0, 456856, "meir", "aa", 10);
        
        PurchaseOrder p=new PurchaseOrder(c);
       
        //System.out.println(b.GetAllProducts());
      //  System.out.println(b.GetCustomersOrders(c));
       // System.out.println(b.sumOfPrice());
       // System.out.println(b.getProducts());
    }

     
    
}
