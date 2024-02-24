package Controller;

import static Controller.PlaceOrderController.BURGERPRICE;
import static Controller.PlaceOrderController.CANCEL;
import static Controller.PlaceOrderController.DELIVERED;
import static Controller.PlaceOrderController.PREPARING;
import static Controller.PlaceOrderController.customer;


public class searchOrderController {
    public static void searchOrder(String id) {
        L1: do {
            String orderId = id;
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
                    String line = String.format(
                            customer[i].getOrderId(),
                            customer[i].getPhoneNumber(), 
                            customer[i].getName(), 
                            customer[i].getQty(), 
                            customer[i].getQty()*BURGERPRICE, status
                    );
                    break L1;
                }
            }
        } while (true);     
    }
}
