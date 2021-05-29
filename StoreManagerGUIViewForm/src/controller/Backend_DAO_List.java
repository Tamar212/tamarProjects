/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.Customer;
import model.HardwareProduct;
import model.Product;
import model.PurchaseOrder;

/**
 *
 * @author student
 */
public class Backend_DAO_List implements Backend {

    private Map<Long, Customer> _Customers;
    private Set<Product> _Products;
    private List<PurchaseOrder> _PurchaseOrders;

    private static Backend_DAO_List bdl_singleton;

    private Backend_DAO_List() {
        this._Customers = new HashMap<>();
        this._Products = new HashSet<>();
        this._PurchaseOrders = new ArrayList<>();
    }

    public static Backend_DAO_List get_bdl_singleton() {
        if (bdl_singleton == null) {
            bdl_singleton = new Backend_DAO_List();
        }
        return bdl_singleton;
    }

    public Map<Long, Customer> getCustomers() {
        return _Customers;
    }

    public void setCustomers(Map<Long, Customer> _Customers) {
        this._Customers = _Customers;
    }

    public Set<Product> getProducts() {
        return _Products;
    }

    public void setProducts(Set<Product> _Products) {
        this._Products = _Products;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return _PurchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> _PurchaseOrders) {
        this._PurchaseOrders = _PurchaseOrders;
    }

    @Override
    public void AddCustomer(Customer c) throws Exception {
        _Customers.put(c.getId(), c);
    }

    @Override
    public void AddProduct(Product c) throws Exception {
        _Products.add(c);
    }

    @Override
    public HashMap<Long, Customer> getAllCustomers() {
        return (HashMap<Long, Customer>) _Customers;
    }

    @Override
    public HashSet<Product> getAllProducts() {
        return (HashSet<Product>) _Products;
    }

    @Override
    public void PlaceOrder(PurchaseOrder po) throws Exception {

        _PurchaseOrders.add(po);
    }

    @Override
    public void RemoveProduct(Product c) {
        _Products.remove(c);
    }

    @Override
    public ArrayList<Product> getCustomersOrders(Customer c) {
        ArrayList<Product> ret = new ArrayList<Product>();
        for (PurchaseOrder po : _PurchaseOrders) {
            if (po.getOrderingCustomer().equals(c)) {
                ret.addAll(po.getProductList());
            }
        }
        return ret;
    }

    @Override
    public Float CalcProductsTotalCost(Product[] products) throws Exception {
        float sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }
    /*
    public Float CalcProductsTotalCost(HashSet<Product> products) throws Exception {
        float sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }*/

    public ArrayList<Customer> GetAllCustomers() throws Exception {
        return (ArrayList<Customer>) _Customers;
    }

    public HashSet<Product> GetAllProducts() throws Exception {
        return (HashSet<Product>) _Products;
    }

    public void savaDataToFile() throws FileNotFoundException, IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"));
        oos.writeObject(this._Customers);
        oos.writeObject(this._Products);
        oos.writeObject(this._PurchaseOrders);
        // סגירה  
        oos.close();

    }
    
     public void loadDataFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
          
          ObjectInputStream ois=new ObjectInputStream(new FileInputStream("data.txt"));
        _Customers=(Map<Long, Customer>)ois.readObject();
        _Products=(Set<Product>) ois.readObject();
        _PurchaseOrders=(List<PurchaseOrder>) ois.readObject();
         ois.close();

     }

    /* public ArrayList<Product> GetCustomersOrders(Customer c) throws Exception {
        ArrayList<Product> ret = new ArrayList<Product>();

        for (int i = 0; i < _PurchaseOrders.size(); i++) {
            if (_PurchaseOrders.get(i).getOrderingCustomer().getId() == c.getId()) {
                ret.addAll(this.GetAllProducts());
            }
        }
        return ret;
    }*/

   public float sumOfPrice() {
        float sum = 0;
        for (int i = 0; i < this._Products.size(); i++) {
            Iterator<Product> a = this._Products.iterator();
            sum = a.next().getPrice();
        }
        return sum;
    }
}
