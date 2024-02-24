
package View;

import static Controller.PlaceOrderController.BURGERPRICE;
import static Controller.PlaceOrderController.CANCEL;
import static Controller.PlaceOrderController.customer;
import Model.Customer;
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


public class searchBestCustomer extends JFrame{
    private JButton backBtn;
    private JButton searchBtn;
    private JTable customerDetailsTbl;
    private DefaultTableModel dtm;
    private JTextField idInput;
    private JTextField nameInput;
    private JLabel titlelbl;
    
    public searchBestCustomer(){
        setTitle("Best Customer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/logo.png")));
        
        titlelbl=new JLabel("Best Customer");
        titlelbl.setFont(new Font("",1,30));
        titlelbl.setBounds(220, 70, 300, 40);
        titlelbl.setBackground(Color.red);
        add(titlelbl);

        //table support Session
        String[] columnNames = {"Customer Id", "Name", "Total"};
        dtm = new DefaultTableModel(columnNames, 0);
        customerDetailsTbl = new JTable(dtm);
        JScrollPane tablePane = new JScrollPane(customerDetailsTbl);
        tablePane.setBounds(90, 200, 500 ,250);
        this.add(tablePane);
        
        Customer[] sortedCustomers = new Customer[0];
        double[] customerTotalBuyingArray = new double[0];

        for (int i = 0; i < customer.length; i++) {
            boolean isExist = false;
            for (int j = 0; j < sortedCustomers.length; j++) {
                if (sortedCustomers[j].getPhoneNumber().equals(customer[i].getPhoneNumber())) {
                    if (customer[i].getStatus()!=CANCEL){
			customerTotalBuyingArray[j] += customer[i].getQty()*BURGERPRICE;
                    }
                    isExist = true;
                }
            }
            if (!isExist) {
                Customer[] tempSortedCustomers = new Customer[sortedCustomers.length +1];
                double[] tempCustomerTotalBuyingArray = new double[customerTotalBuyingArray.length + 1];

                for (int j = 0; j < sortedCustomers.length; j++) {
                    tempSortedCustomers[j] = sortedCustomers[j];
                    tempCustomerTotalBuyingArray[j] = customerTotalBuyingArray[j];
                }
                sortedCustomers = tempSortedCustomers;
                customerTotalBuyingArray = tempCustomerTotalBuyingArray;

                sortedCustomers[sortedCustomers.length - 1] = customer[i];
                customerTotalBuyingArray[customerTotalBuyingArray.length - 1] = customer[i].getQty()*BURGERPRICE;
            }
        }
        
        // sort
        for (int i = 1; i < sortedCustomers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (customerTotalBuyingArray[j] < customerTotalBuyingArray[i]) {
                    String temp = sortedCustomers[j].getPhoneNumber();
                    sortedCustomers[j].setPhoneNumber(sortedCustomers[i].getPhoneNumber());
                    sortedCustomers[i].setPhoneNumber(temp);
                    temp = sortedCustomers[j].getName();
                    sortedCustomers[j].setName(sortedCustomers[i].getName());
                    sortedCustomers[i].setName(temp);
                    double tempd = customerTotalBuyingArray[j];
                    customerTotalBuyingArray[j] = customerTotalBuyingArray[i];
                    customerTotalBuyingArray[i] = tempd;
                }
            }
        }
        
        //print data
        for (int i = 0; i < sortedCustomers.length; i++) {
            Object data[] = {sortedCustomers[i].getPhoneNumber(), sortedCustomers[i].getName(), customerTotalBuyingArray[i]};
            dtm.addRow(data);
        }
        
        backBtn = new JButton("Back");
        backBtn.setFont(new Font("", 1, 15));
        backBtn.setBounds(550, 490, 100, 30);
        backBtn.setFocusable(false);
        backBtn.addActionListener(evt ->{
            new homePage().setVisible(true);
        });
        add(backBtn);
    }
}
