package View;

import Controller.PlaceOrderController;
import static Controller.PlaceOrderController.BURGERPRICE;
import static Controller.PlaceOrderController.CANCEL;
import static Controller.PlaceOrderController.DELIVERED;
import static Controller.PlaceOrderController.PREPARING;
import static Controller.PlaceOrderController.customer;
import Controller.searchOrderController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class searchOrder extends JFrame{
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
    private JButton searchBtn;
    private JButton backBtn;
    
    
    public searchOrder(){
        setTitle("Place an Order");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720, 600);
        setLocationRelativeTo(null);
        setLayout(null);
       
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/logo.png")));
        
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
       txtStatus = new JTextField(10);
       txtStatus.setFont(new Font("",1,18));
       txtStatus.setBounds(200, 405, 150, 30);
       txtStatus.setEditable(false);
       add(txtStatus);
       
       
       backBtn = new JButton("Back");
       backBtn.setFont(new Font("", 1, 15));
       backBtn.setBounds(450, 305, 150, 45);
       backBtn.setFocusable(false);
       backBtn.addActionListener(evt ->{
            new homePage().setVisible(true);
        });
       add(backBtn);
       
       searchBtn = new JButton("Search");
       searchBtn.setFont(new Font("", 1, 15));
       searchBtn.setBounds(450, 255, 150, 45);
       searchBtn.setFocusable(false);
       searchBtn.addActionListener(evt ->{
           
           String orderId = txtOrderId.getText();
            for (int i = 0; i < customer.length; i++) {
                if (orderId.equals(customer[i].getOrderId())) {
                    String status = "";
                    switch (customer[i].getStatus()) {
                        case CANCEL:
                            status = "Cancel";
                            break;
                        case PREPARING:
                            status = "Preparing";
                            break;
                        case DELIVERED:
                            status = "Delivered";
                            break;
                    }
                    txtCustomerId.setText(customer[i].getPhoneNumber());
                    txtName.setText(customer[i].getName());
                    txtTotal.setText(Integer.toString((int) customer[i].getValue()));
                    txtQTY.setText(Integer.toString(customer[i].getQty()));
                    txtStatus.setText(status); 
                }
            }
           
           
        });
       add(searchBtn);
       
    }
}
