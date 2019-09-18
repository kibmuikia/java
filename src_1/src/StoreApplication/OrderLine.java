package StoreApplication;

public class OrderLine implements java.io.Serializable {
    Products p;
    int quantity;

    public OrderLine(Products p) {
        this.p = p;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
