package View;

import Controller.PlaceOrderController;
import static Controller.PlaceOrderController.PREPARING;
import static Controller.PlaceOrderController.addCustomer;
import static Controller.PlaceOrderController.customer;
import Model.Customer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class placeOrder extends JFrame{
    private JLabel orderIdLabel;
    private JLabel customerIdLabel;
    private JLabel nameLabel;
    private JLabel qtyLabel;
    private JLabel totalLabel;
    private JTextField txtCustomerId;
    private JTextField txtName;
    private JTextField txtQTY;
    private JTextField txtOrderId;
    private JTextField txtTotal;
    
    private JButton placeOrderBtn;
    private JButton homeBtn;
    private JButton cancelBtn;
    private JButton addingTotalBtn;
    
    private int qty = 0;
    
    public placeOrder(){
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
       txtOrderId.setEditable(false);
       txtOrderId.setText(PlaceOrderController.generateOrderId());
       add(txtOrderId);
       
       customerIdLabel=new JLabel("Customer ID :");
       customerIdLabel.setFont(new Font("",1,18));
       customerIdLabel.setBounds(50, 200, 150, 40);
       add(customerIdLabel);
       txtCustomerId = new JTextField(10);
       txtCustomerId.setFont(new Font("",1,18));
       txtCustomerId.setBounds(200, 205, 150, 30);
       add(txtCustomerId);
       
       nameLabel=new JLabel("Name :");
       nameLabel.setFont(new Font("",1,18));
       nameLabel.setBounds(50, 250, 150, 40);
       nameLabel.setBackground(Color.red);
       add(nameLabel);
       txtName=new JTextField(10);
       txtName.setFont(new Font("",1,18));
       txtName.setBounds(200, 255, 150, 30);
       add(txtName);
       
       qtyLabel=new JLabel("Burger QTY :");
       qtyLabel.setFont(new Font("",1,18));
       qtyLabel.setBounds(50, 300, 150, 40);
       qtyLabel.setBackground(Color.red);
       add(qtyLabel);
       txtQTY=new JTextField(10);
       txtQTY.setFont(new Font("",1,18));
       txtQTY.setBounds(200, 305, 150, 30);
       add(txtQTY);
       addingTotalBtn = new JButton("+");
       addingTotalBtn.setFont(new Font("", 1, 15));
       addingTotalBtn.setBounds(350, 305, 50, 30);
       addingTotalBtn.setFocusable(false);
       addingTotalBtn.addActionListener(evt ->{
           qty = Integer.parseInt(txtQTY.getText());
           txtTotal.setText(PlaceOrderController.BURGERPRICE*qty+".00");
        });
       add(addingTotalBtn);
       
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
       
       //Buttons
       placeOrderBtn = new JButton("Place Order");
       placeOrderBtn.setFont(new Font("", 1, 15));
       placeOrderBtn.setBounds(100, 400, 150, 40);
       placeOrderBtn.setFocusable(false);
       placeOrderBtn.addActionListener(evt ->{
//            Customer orderObject = new Customer(
//                    txtOrderId.getText(),
//                    txtCustomerId.getText(),
//                    txtName.getText(),
//                    Integer.parseInt(txtQTY.getText()),
//                    1
//            );
//            System.out.println(orderObject);
              addCustomer(new Customer(txtOrderId.getText(), txtCustomerId.getText(), txtName.getText(), qty, PREPARING, Double.parseDouble(txtTotal.getText())));
              clear();
              txtOrderId.setText(PlaceOrderController.generateOrderId());
              
              for (Customer customer : customer) {
                    System.out.println("Order ID: " + customer.getOrderId());
                    System.out.println("Phone Number: " + customer.getPhoneNumber());
                    System.out.println("Name: " + customer.getName());
                    System.out.println("Quantity: " + customer.getQty());
                    System.out.println("Status: " + customer.getStatus());
                    System.out.println("Value: " + customer.getValue());
                    System.out.println("---------------------------");
              }
              
        });
       add(placeOrderBtn);
       
       homeBtn = new JButton("Back to Home");
       homeBtn.setFont(new Font("", 1, 15));
       homeBtn.setBounds(500, 480, 150, 40);
       homeBtn.setFocusable(false);
       homeBtn.addActionListener(evt ->{
            new homePage().setVisible(true);
        });
       add(homeBtn);
       
       cancelBtn = new JButton("Cancel");
       cancelBtn.setFont(new Font("", 1, 15));
       cancelBtn.setBounds(270, 400, 150, 40);
       cancelBtn.setFocusable(false);
       cancelBtn.addActionListener(evt ->{
            clear();
        });
       add(cancelBtn);
       
       
    }
    
    private void clear(){
        txtCustomerId.setText(null);
        txtName.setText(null);
        txtQTY.setText(null);
        txtTotal.setText(null);
    }
    
    
}
