
package Model;


public class Customer{
	private String orderId;
	private String phoneNumber;
	private String name;
	private int qty = -1;
	int status = -1;
        double price = 0;
	
    public Customer(String orderId, String phoneNumber, String name, int qty, int status, double price){
        this.orderId = orderId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        if (qty>=0){
			this.qty = qty;
		}
        this.status = status;
        this.price = price;
    }

    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    public String getOrderId(){
        return orderId;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
 
	public boolean setQty(int qty){
		if (qty>=0){
			this.qty = qty;
			return true;
		}
		
		return false;
	}
	
	public int getQty(){
		return qty;
	}

    public void setStatus(int status){
        this.status =status;
    }

    public int getStatus(){
        return status;
    }

    public void setValue(double price){
        this.price = price;
    }
    public double getValue(){
        return price;
    }
}
