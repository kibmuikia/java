package SamplePointOfSale;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    ArrayList<OrderLine> orderProducts = new ArrayList<OrderLine>();
    float profit;
    Customer orderCustomer;
    User orderAttendant;

    public Order(ArrayList<OrderLine> orderProducts,  Customer orderCustomer, User orderAttendant) {
        this.orderProducts = orderProducts;

        this.orderCustomer = orderCustomer;
        this.orderAttendant = orderAttendant;
    }

    public ArrayList<OrderLine> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(ArrayList<OrderLine> orderProducts) {
        this.orderProducts = orderProducts;
    }


    public Customer getOrderCustomer() {
        return orderCustomer;
    }

    public void setOrderCustomer(Customer orderCustomer) {
        this.orderCustomer = orderCustomer;
    }

    public User getOrderAttendant() {
        return orderAttendant;
    }

    public void setOrderAttendant(User orderAttendant) {
        this.orderAttendant = orderAttendant;
    }
    public double getTotal(){
        double total = 0;
        double subtotal=0;
        for (OrderLine product : orderProducts) {
            subtotal=product.getOrderItemQuantity() *product.getOrderItem().ProductUnitPrice;

            total =total+subtotal;
        }


        return total;
    }
    public double getProfit(){
        double total = 0;
        double subtotal=0;
        for (OrderLine product : orderProducts) {

            subtotal=product.getOrderItemQuantity()*product.getOrderItem().productBuyingPrice;

            total =total+subtotal;
        }

        return getTotal()-total;
    }
}
