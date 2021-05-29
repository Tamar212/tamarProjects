/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author User
 */
public class Model {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HardwareProduct h1 = new HardwareProduct(3, 34567  , "computer", "aa", 2000);
        SoftwareProduct s1 = new SoftwareProduct(5, 98589, "word", "aa", 300);
        Customer c1 = new Customer(57576798, "dan", "dakar 8");
        PurchaseOrder p1 = new PurchaseOrder();
        System.out.println("p1: "+p1.toString());

        System.out.println(h1.getPrice());
        System.out.println(h1.toString());
        
        System.out.println(s1.getPrice());
        System.out.println(s1.toString());
        
         System.out.println(c1.toString());
         System.out.println(p1.toString());

    }

}
