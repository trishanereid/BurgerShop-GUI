package View;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class viewOrders extends JFrame{
    
    private JButton deliveredOrderBtn;
    private JButton preparingOrderBtn;
    private JButton cancelOrderBtn;
    private JButton backBtn;
    private ImageIcon img;
    private JLabel imgLabel;
    
    public viewOrders(){
        setTitle("View Orders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../img/logo.png")));
        
        img = new ImageIcon(getClass().getResource("../img/logo.png"));
        imgLabel = new JLabel(img);
        add(imgLabel);
        imgLabel.setBounds(200, 5, 300, 300);
        
        deliveredOrderBtn = new JButton("Delivered Orders");
        deliveredOrderBtn.setFont(new Font("", 1, 15));
        deliveredOrderBtn.setBounds(250, 245, 200, 45);
        deliveredOrderBtn.setFocusable(false);
        deliveredOrderBtn.addActionListener(evt ->{
            new deliveredOrders().setVisible(true);
        });
        add(deliveredOrderBtn);
        
        preparingOrderBtn = new JButton("Preparing Orders");
        preparingOrderBtn.setFont(new Font("", 1, 15));
        preparingOrderBtn.setBounds(250, 300, 200, 45);
        preparingOrderBtn.setFocusable(false);
        preparingOrderBtn.addActionListener(evt ->{
            new preparingOrders().setVisible(true);
        });
        add(preparingOrderBtn);
        
        cancelOrderBtn = new JButton("Canceled Orders");
        cancelOrderBtn.setFont(new Font("", 1, 15));
        cancelOrderBtn.setBounds(250, 355, 200, 45);
        cancelOrderBtn.setFocusable(false);
        cancelOrderBtn.addActionListener(evt ->{
            new cancelOrders().setVisible(true);
        });
        add(cancelOrderBtn);
        
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
