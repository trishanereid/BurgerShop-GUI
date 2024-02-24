
package View;

import static Controller.PlaceOrderController.CANCEL;
import static Controller.PlaceOrderController.DELIVERED;
import static Controller.PlaceOrderController.PREPARING;
import static Controller.PlaceOrderController.customer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class updateOrder extends JFrame{

    private JLabel title;
    private JLabel orderIdLabel;
    private JLabel customerIdLabel;
    private JLabel nameLabel;
    private JLabel qtyLabel;
    private JLabel totalLabel;
    private JLabel statusLabel;
    private JTextField txtCustomerId;
    private JTextField txtName;
    private JTextField txtQTY;
    private JTextField txtOrderId;
    private JTextField txtTotal;
    private JTextField txtStatus;
    private JButton backBtn;
    private JButton updateBtn;
    private JButton searchBtn;
    
    public updateOrder(){
       setTitle("Update Order");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(720, 600);
       setLocationRelativeTo(null);
       setLayout(null);
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/logo.png")));
       
       title = new JLabel("Update Order");
       title.setFont(new Font("", 1, 30));
       title.setBounds(220, 40, 300, 30);
       add(this.title);
       
       orderIdLabel=new JLabel("Order ID :");
       orderIdLabel.setFont(new Font("",1,18));
       orderIdLabel.setBounds(50, 150, 100, 40);
       orderIdLabel.setBackground(Color.red);
       add(orderIdLabel);
       txtOrderId = new JTextField(10);
       txtOrderId.setFont(new Font("",1,18));
       txtOrderId.setBounds(200, 155, 150, 30);
       add(txtOrderId);
       
       customerIdLabel=new JLabel("Customer ID :");
       customerIdLabel.setFont(new Font("",1,18));
       customerIdLabel.setBounds(50, 200, 150, 40);
       customerIdLabel.setBackground(Color.red);
       add(customerIdLabel);
       txtCustomerId = new JTextField(10);
       txtCustomerId.setFont(new Font("",1,18));
       txtCustomerId.setBounds(200, 205, 150, 30);
       txtCustomerId.setEditable(false);
       add(txtCustomerId);
       
       nameLabel=new JLabel("Name :");
       nameLabel.setFont(new Font("",1,18));
       nameLabel.setBounds(50, 250, 150, 40);
       nameLabel.setBackground(Color.red);
       add(nameLabel);
       txtName=new JTextField(10);
       txtName.setFont(new Font("",1,18));
       txtName.setBounds(200, 255, 150, 30);
       txtName.setEditable(false);
       add(txtName);
       
       qtyLabel=new JLabel("Burger QTY :");
       qtyLabel.setFont(new Font("",1,18));
       qtyLabel.setBounds(50, 300, 150, 40);
       qtyLabel.setBackground(Color.red);
       add(qtyLabel);
       txtQTY=new JTextField(10);
       txtQTY.setFont(new Font("",1,18));
       txtQTY.setBounds(200, 305, 150, 30);
       txtQTY.setEditable(false);
       add(txtQTY);
       
       totalLabel=new JLabel("Total :");
       totalLabel.setFont(new Font("",1,18));
       totalLabel.setBounds(50, 350, 150, 40);
       totalLabel.setBackground(Color.red);
       add(totalLabel);
       txtTotal = new JTextField(10);
       txtTotal.setFont(new Font("",1,18));
       txtTotal.setBounds(200, 355, 150, 30);
       txtTotal.setEditable(false);
       add(txtTotal);
       
       statusLabel=new JLabel("Order Status :");
       statusLabel.setFont(new Font("",1,18));
       statusLabel.setBounds(50, 400, 150, 40);
       statusLabel.setBackground(Color.red);
       add(statusLabel);
       String[] status = {"Cancel", "Preparing", "Delivered", ""};
       JComboBox statusDropdown = new JComboBox(status);
       statusDropdown.setBounds(200, 405, 150, 30);
       this.add(statusDropdown);
       
       searchBtn = new JButton("Search");
       searchBtn.setFont(new Font("", 1, 15));
       searchBtn.setBounds(355, 155, 90, 29);
       searchBtn.setFocusable(false);
       searchBtn.addActionListener(evt ->{
           String orderId = txtOrderId.getText();
            for (int i = 0; i < customer.length; i++) {
                if (orderId.equals(customer[i].getOrderId())) {
                    txtCustomerId.setText(customer[i].getPhoneNumber());
                    txtName.setText(customer[i].getName());
                    txtTotal.setText(Integer.toString((int) customer[i].getValue()));
                    txtQTY.setText(Integer.toString(customer[i].getQty()));
                    statusDropdown.setSelectedIndex(customer[i].getStatus());
                }
            } 
        });
       add(searchBtn);
       
       backBtn = new JButton("Back");
       backBtn.setFont(new Font("", 1, 15));
       backBtn.setBounds(550, 490, 100, 30);
       backBtn.setFocusable(false);
       backBtn.addActionListener(evt ->{
            new homePage().setVisible(true);
        });
       add(backBtn);
       updateBtn = new JButton("Update Order");
       updateBtn.setFont(new Font("", 1, 15));
       updateBtn.setBounds(380, 490, 150, 30);
       updateBtn.setFocusable(false);
       updateBtn.addActionListener(evt ->{
            int s = statusDropdown.getSelectedIndex();
            String orderId = txtOrderId.getText();
            for (int i = 0; i < customer.length; i++) {
                if (orderId.equals(customer[i].getOrderId())) {
                    customer[i].setStatus(s);
                }
            }
            clear();
            statusDropdown.setSelectedIndex(3);
        });
       add(updateBtn);
    }
    
    private void clear(){
        txtOrderId.setText(null);
        txtCustomerId.setText(null);
        txtName.setText(null);
        txtQTY.setText(null);
        txtTotal.setText(null);
    }
}
