/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanagerguiviewform;

import controller.Backend_DAO_List;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author User
 */
public class StoreManagerGUIView extends JFrame {

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;

    private Backend_DAO_List controller = Backend_DAO_List.get_bdl_singleton();
    
    public StoreManagerGUIView() {

        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();

        this.setLayout(new GridLayout(5, 5, 1, 1));

        this.add(jButton1);
        this.add(jButton2);
        this.add(jButton3);
        this.add(jButton4);

        jButton1.setText("הוספת לקוח");
        jButton2.setText("מוצרים");
        jButton3.setText("בצוע הזמנה");
        jButton4.setText("צפיה בהזמנות");

        jButton1.setBackground(Color.CYAN);
        jButton1.setForeground(Color.black);

        jButton2.setBackground(Color.CYAN);
        jButton2.setForeground(Color.black);

        jButton3.setBackground(Color.CYAN);
        jButton3.setForeground(Color.black);
        
        jButton4.setBackground(Color.CYAN);
        jButton4.setForeground(Color.black);

        try {
            controller.loadDataFromFile();
        } catch (Exception ex) {
            Logger.getLogger(StoreManagerGUIViewForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        jButton1.addActionListener((e) -> {
            AddNewCustomerForm a = new AddNewCustomerForm();
            a.setVisible(true);
        });
        jButton2.addActionListener((e) -> {
            ManageCatalogForm m = new ManageCatalogForm();
            m.setVisible(true);
        });
        jButton3.addActionListener((e) -> {
            PlaceOrderForm p = new PlaceOrderForm();
            p.setVisible(true);
        });
        jButton4.addActionListener((e) -> {
            ViewPurchasesForm v = new ViewPurchasesForm();
            v.setVisible(true);
        });

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    controller.savaDataToFile();
                    System.exit(0);
                } catch (IOException ex) {
                    Logger.getLogger(StoreManagerGUIViewForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        pack();
    }

}
