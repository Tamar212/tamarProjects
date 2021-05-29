/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanagerguiviewform;

import controller.Backend_DAO_List;

/**
 *
 * @author User
 */
public class StoreManagerGUIViewForm {

    /**
     * @param args the command line arguments
     */
    public  static Backend_DAO_List controller = Backend_DAO_List.get_bdl_singleton();

    public static void main(String[] args) {
        StoreManagerGUIView frm=new StoreManagerGUIView();
        frm.setSize(300,400);
        frm.setVisible(true);
    }
    
}
