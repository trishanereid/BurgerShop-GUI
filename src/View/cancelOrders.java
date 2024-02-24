package View;

import static Controller.PlaceOrderController.BURGERPRICE;
import static Controller.PlaceOrderController.CANCEL;
import static Controller.PlaceOrderController.customer;
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


public class cancelOrders extends JFrame{
    
    private JButton backBtn;
    private JButton searchBtn;
    private JTable customerDetailsTbl;
    private DefaultTableModel dtm;
    private JTextField idInput;
    private JTextField nameInput;
    private JLabel titlelbl;
    
    public cancelOrders(){
        setTitle("Canceled Orders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/logo.png")));
        
        titlelbl=new JLabel("Canceled Orders");
        titlelbl.setFont(new Font("",1,30));
        titlelbl.setBounds(220, 70, 300, 40);
        titlelbl.setBackground(Color.red);
        add(titlelbl);

        //table support Session
        String[] columnNames = {"Order ID", "Customer Id", "Name", "QTY", "Total"};
        dtm = new DefaultTableModel(columnNames, 0);
        customerDetailsTbl = new JTable(dtm);
        JScrollPane tablePane = new JScrollPane(customerDetailsTbl);
        tablePane.setBounds(90, 200, 500 ,250);
        this.add(tablePane);
        
        //data
        for (int i = 0; i < customer.length; i++) {
            if (customer[i].getStatus() == CANCEL) {
                Object data[] = {customer[i].getOrderId(), customer[i].getPhoneNumber(), customer[i].getName(), customer[i].getQty(), customer[i].getQty()*BURGERPRICE};
                dtm.addRow(data);
            }
        }
        
        backBtn = new JButton("Back");
        backBtn.setFont(new Font("", 1, 15));
        backBtn.setBounds(550, 490, 100, 30);
        backBtn.setFocusable(false);
        backBtn.addActionListener(evt ->{
            new viewOrders().setVisible(true);
        });
        add(backBtn);
    }
}
