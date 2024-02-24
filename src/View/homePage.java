package View;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class homePage extends JFrame{
    private JButton placeOrderBtn;
    private JButton searchBestCustomerBtn;
    private JButton searchOrderBtn;
    private JButton searchCustomerBtn;
    private JButton viewOrdersBtn;
    private JButton updateOrdersBtn;
    private JButton exitBtn;
    private ImageIcon img;
    private JLabel imgLabel;

    public homePage(){
        setTitle("Welcome");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        img = new ImageIcon(getClass().getResource("../img/logo.png"));
        imgLabel = new JLabel(img);
        add(imgLabel);
        imgLabel.setBounds(200, 5, 300, 300);
        
        placeOrderBtn = new JButton("Place Order");
        placeOrderBtn.setFont(new Font("", 1, 15));
        placeOrderBtn.setBounds(130, 300, 200, 40);
        placeOrderBtn.setFocusable(false);
        placeOrderBtn.addActionListener((ActionEvent evt) ->{
            new placeOrder().setVisible(true);
            
        });
        
        searchBestCustomerBtn = new JButton("Search Best Customer");
        searchBestCustomerBtn.setFont(new Font("", 1, 15));
        searchBestCustomerBtn.setBounds(130, 350, 200, 40);
        searchBestCustomerBtn.setFocusable(false);
        searchBestCustomerBtn.addActionListener(evt ->{
            new searchBestCustomer().setVisible(true);
        });
        
        searchOrderBtn = new JButton("Search Order");
        searchOrderBtn.setFont(new Font("", 1, 15));
        searchOrderBtn.setBounds(130, 400, 200, 40);
        searchOrderBtn.setFocusable(false);
        searchOrderBtn.addActionListener(evt ->{
            new searchOrder().setVisible(true);
        });
        
        searchCustomerBtn = new JButton("Search Customer");
        searchCustomerBtn.setFont(new Font("", 1, 15));
        searchCustomerBtn.setBounds(370, 300, 200, 40);
        searchCustomerBtn.setFocusable(false);
        searchCustomerBtn.addActionListener(evt ->{
            new searchCustomer().setVisible(true);
        });
        
        viewOrdersBtn = new JButton("View Orders");
        viewOrdersBtn.setFont(new Font("", 1, 15));
        viewOrdersBtn.setBounds(370, 350, 200, 40);
        viewOrdersBtn.setFocusable(false);
        viewOrdersBtn.addActionListener(evt ->{
            new viewOrders().setVisible(true);
        });
        
        updateOrdersBtn = new JButton("Update Orders");
        updateOrdersBtn.setFont(new Font("", 1, 15));
        updateOrdersBtn.setBounds(370, 400, 200, 40);
        updateOrdersBtn.setFocusable(false);
        updateOrdersBtn.addActionListener(evt ->{
            new updateOrder().setVisible(true);
        });
        
        add(placeOrderBtn);
        add(searchBestCustomerBtn);
        add(searchOrderBtn);
        add(searchCustomerBtn);
        add(viewOrdersBtn);
        add(updateOrdersBtn);
        
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/logo.png")));
    }
}
