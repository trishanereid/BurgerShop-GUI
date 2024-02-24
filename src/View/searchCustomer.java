package View;

import static Controller.PlaceOrderController.customer;
import Controller.searchCustomerController;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class searchCustomer extends JFrame{
    
    private JLabel title;
    private JLabel customerId;
    private JLabel name;
    private JTextField nameInput;
    private JTextField idInput;
    private JButton backBtn;
    private JButton searchBtn;
    
    private DefaultTableModel dtm;
    private JTable customerDetailsTbl;

    public searchCustomer(){
       setTitle("Search Customer");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(720, 600);
       setLocationRelativeTo(null);
       setLayout(null);
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/logo.png")));
       
       title = new JLabel("Search Customer");
       title.setFont(new Font("", 1, 30));
       title.setBounds(220, 40, 300, 30);
       add(this.title);
       title = new JLabel("Order Details");
       title.setFont(new Font("", 1, 18));
       title.setBounds(250, 210, 300, 30);
       add(this.title);
       
       customerId = new JLabel("Enter Customer ID :");
       customerId.setFont(new Font("", 1, 15));
       customerId.setBounds(50, 110, 150, 40);
       add(this.customerId);
       idInput = new JTextField(10);
       idInput.setFont(new Font("", 1, 15));
       idInput.setBounds(200, 115, 150, 30);
       add(this.idInput);
       
       name = new JLabel("Name :");
       name.setFont(new Font("", 1, 15));
       name.setBounds(50, 160, 150, 40);
       add(this.name);
       nameInput = new JTextField(10);
       nameInput.setFont(new Font("", 1, 15));
       nameInput.setBounds(150, 160, 150, 40);
       nameInput.setEditable(false);
       add(this.nameInput);
       
       
       
       backBtn = new JButton("Back");
       backBtn.setFont(new Font("", 1, 15));
       backBtn.setBounds(550, 490, 100, 30);
       backBtn.setFocusable(false);
       backBtn.addActionListener(evt ->{
            new homePage().setVisible(true);
        });
       add(backBtn);
       
       //table support Session
       String[] columnNames = {"Order ID", "Quantity", "Total"};
       dtm = new DefaultTableModel(columnNames, 0);
       customerDetailsTbl = new JTable(dtm);
       JScrollPane tablePane = new JScrollPane(customerDetailsTbl);
       tablePane.setBounds(80, 250, 500 ,200);
       this.add(tablePane);
       
       searchBtn = new JButton("Search");
       searchBtn.setFont(new Font("", 1, 15));
       searchBtn.setBounds(350, 115, 90, 29);
       searchBtn.setFocusable(false);
       searchBtn.addActionListener(evt ->{
           
           for (int i = 0; i < customer.length; i++) {
                if (idInput.getText().equals(customer[i].getPhoneNumber())) {
                    nameInput.setText(customer[i].getName());
                    System.out.println("Name       - " + customer[0].getName());
                    Object data[] = {customer[i].getOrderId(), customer[i].getQty(), customer[i].getValue()};
                    dtm.addRow(data);
               }
           }
           
        });
       add(searchBtn);
       
    } 
}