package Controller;

import static Controller.PlaceOrderController.customer;
import java.util.Scanner;

public class searchCustomerController {
    public static void searchCustomer(String customerId) {
    for (int i = 0; i < customer.length; i++) {
            if (customerId.equals(customer[i].getPhoneNumber())) {
                System.out.println("CustomerID - " + customer[i].getPhoneNumber());
                System.out.println("Name       - " + customer[i].getName());
                
                
                
                System.out.println("\nCustomer Order Details");
                System.out.println("========================\n");
                System.out.println("----------------------------------------------");
                String line = String.format("%-12s%-18s%-14s", " Order_ID", "Order_Quantity", "Total_Value  ");
                System.out.println(line);
                System.out.println("----------------------------------------------");
                for (int j = 0; j < customer.length; j++) {
                    if (customer[j].getPhoneNumber().equals(customerId)) {
                        String line2 = String.format("%1s%-12s%-18d%-14.2f", " ", customer[j].getOrderId(), customer[j].getQty(),
                                customer[j].getValue());
                        System.out.println(line2);
                    }
                }
                System.out.println("----------------------------------------------");
            }
        }
    }
}
