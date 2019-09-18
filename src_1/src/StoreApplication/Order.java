package StoreApplication;

import java.util.ArrayList;

public class Order implements java.io.Serializable  {
    Customer customer;
    User user;
    ArrayList<Products> orders = new ArrayList<Products>();

    public Order(Customer customer, User user, ArrayList<Products> orders) {
        this.customer = customer;
        this.user = user;
        this.orders = orders;
    }
    public double getTotal(){
        double total = 0;
        double subtotal=0;
        for (Products product : orders) {
            subtotal=product.quantity*product.sellingPrice;

            total =total+subtotal;
        }


        return total;
    }
    public double getProfit(){
        double total = 0;
        double subtotal=0;
        for (Products product : orders) {

            subtotal=product.quantity*product.buyingPrice;

            total =total+subtotal;
        }

        return getTotal()-total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Products> getOrders() {
        return orders;
    }
}
