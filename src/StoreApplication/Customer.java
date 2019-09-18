package StoreApplication;

public class Customer implements java.io.Serializable{
    String customerName;


    public Customer(String customerName) {
        this.customerName = customerName;

    }

    public String getCustomerName() {
        return customerName;
    }
}
