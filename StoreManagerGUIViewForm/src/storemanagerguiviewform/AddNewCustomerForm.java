//package storemanagerguiview;
package storemanagerguiviewform;
import controller.Backend_DAO_List;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.Customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class AddNewCustomerForm extends JFrame {

    private JButton jButtonOK;
    private JLabel jLabelID;
    private JLabel jLabelName;
    private JLabel jLabelAddress;
    private JTextField jTextFieldID;
    private JTextField jTextFieldName;
    private JTextField jTextFieldAddress;

    public AddNewCustomerForm() throws HeadlessException {

        jButtonOK = new JButton("OK");
        jLabelID = new JLabel("ID:");
        jLabelName = new JLabel("Name:");
        jLabelAddress = new JLabel("Address:");
        jTextFieldID = new JTextField();
        jTextFieldName = new JTextField();
        jTextFieldAddress = new JTextField();

        getContentPane().add(jLabelID);
        getContentPane().add(jTextFieldID);

        
        jTextFieldID.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e){
            String xw = jTextFieldID.getText(); //should retrieve my input 
        }
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar(); 
            if((!(Character.isDigit(c)) && (c!='.'))){ 
                e.consume(); 
            }
             if (jTextFieldID.getText().length() > 8) {
                    e.consume();
                }
        } 
        });
       /* jTextFieldID.addKeyListener(new KeyAdapter() {
            public void KeyTyped(KeyEvent e) {
                 char c = e.getKeyChar(); 
                if (!(Character.isDigit(c))) {
                    e.consume();
                }

                if (jTextFieldID.getText().length() > 8) {
                    e.consume();
                }

                //super.keyTyped(e);
            }
        });*/
        getContentPane().add(jLabelName);
        getContentPane().add(jTextFieldName);

        getContentPane().add(jLabelAddress);
        getContentPane().add(jTextFieldAddress);
        getContentPane().add(jButtonOK);

        this.setPreferredSize(new Dimension(400, 200));
        getContentPane().setLayout(new GridLayout(0, 2, 10, 10));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();  // סידור הרכבים באופן פורפציונלי

        jButtonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (jTextFieldName.getText().isEmpty() || jTextFieldAddress.getText().isEmpty()) {
                        throw new Exception("כל השדות חייבים להיות מלאים");
                    }
                    Customer c = new Customer();
                    c.setId(Integer.parseInt(jTextFieldID.getText()));
                    c.setName(jTextFieldName.getText());
                    c.setAddress(jTextFieldAddress.getText());
                    JOptionPane.showMessageDialog(AddNewCustomerForm.this, "הלקוח הוכנס בהצלחה");
                    Backend_DAO_List.get_bdl_singleton().AddCustomer(c);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AddNewCustomerForm.this, ex);
                }
            }
        });
    }

}
