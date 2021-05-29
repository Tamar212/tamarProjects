/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class PurchaseOrder implements Serializable {

    private Customer orderingCustomer;
    private ArrayList<Product> productList;
    private LocalDate orderDate;

    public PurchaseOrder(Customer orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
        this.orderDate = LocalDate.now();
    }

    public PurchaseOrder() {
        this.orderDate = LocalDate.now();
        productList = new ArrayList<>();
        productList.add(new SoftwareProduct(432, 3456726,"rut","bb", 200));

    }

    public Customer getOrderingCustomer() {
        return orderingCustomer;
    }

    public void setOrderingCustomer(Customer orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" + "orderingCustomer=" + orderingCustomer + ", productList=" + productList + ", orderDate=" + orderDate + '}';
    }

}
