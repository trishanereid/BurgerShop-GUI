package Controller;

import Model.Customer;


public class PlaceOrderController {
    public static final int BURGERPRICE = 500;

    //Object Array
    public static Customer[] customer= new Customer[0];
    
    // Order status
    public static final int CANCEL = 0;
    public static final int PREPARING = 1;
    public static final int DELIVERED = 2;
    
    
    // validation Customer ID
    public static boolean validationcustomerId(String customerId) {
        if (customerId.length() == 10) {
            if (customerId.startsWith("0")) {
                try {
                    int i = Integer.parseInt(customerId);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return false;
    }

    // generate order Id
    public static String generateOrderId() {
        if (customer.length==0){
			return "B0001";
		}
		String lastOrderId = customer[customer.length - 1].getOrderId();
		int number = Integer.parseInt(lastOrderId.split("B")[1]); //1
		number++;//2
		return String.format("B%04d",number); //printf("",) //B0002
    }

    // Add Customer
    public static void addCustomer(Customer newCustomer) {
        Customer[] newArray = new Customer[customer.length + 1];
        System.arraycopy(customer, 0, newArray, 0, customer.length);
        newArray[customer.length] = newCustomer;
        customer = newArray;
    }
}
