package SamplePointOfSale;

import java.io.Serializable;

public class OrderLine implements Serializable {
        Product orderItem;
        int OrderItemQuantity;

    public OrderLine(Product orderItem, int orderItemQuantity) {
        this.orderItem = orderItem;
        OrderItemQuantity = orderItemQuantity;
    }

    public Product getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Product orderItem) {
        this.orderItem = orderItem;
    }

    public int getOrderItemQuantity() {
        return OrderItemQuantity;
    }

    public void setOrderItemQuantity(int orderItemQuantity) {
        OrderItemQuantity = orderItemQuantity;
    }
}
