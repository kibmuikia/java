package StoreApplication;

import java.util.Scanner;


public class Products implements java.io.Serializable {
    String name,description,id;
    int quantity;
    double sellingPrice,buyingPrice;
    Category category;



    public int getQuantity() {
        return quantity;
    }

    public String getId() {
        return id;
    }

    public Products(String id, String name, String description, double sellingPrice, int quantity, double buyingPrice, Category category) {
        this.id =id;
        this.name = name;
        this.description = description;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        this.buyingPrice = buyingPrice;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
