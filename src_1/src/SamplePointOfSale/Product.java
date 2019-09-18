package SamplePointOfSale;

import java.io.Serializable;

public class Product implements Serializable {
    String productId,productName,productDescription;
    double productBuyingPrice,ProductUnitPrice;
    int productQuantity;
    Category productCategory;

    public Product(String productId, String productName, String productDescription, double productBuyingPrice, double productUnitPrice, int productQuantity, Category productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productBuyingPrice = productBuyingPrice;
        ProductUnitPrice = productUnitPrice;
        this.productQuantity = productQuantity;
        this.productCategory = productCategory;
    }

    public String getProductId() {
        return productId;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }


    public void setProductId(String productId) {
        productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductBuyingPrice() {
        return productBuyingPrice;
    }

    public void setProductBuyingPrice(float productBuyingPrice) {
        this.productBuyingPrice = productBuyingPrice;
    }

    public double getProductUnitPrice() {
        return ProductUnitPrice;
    }

    public void setProductUnitPrice(float productUnitPrice) {
        ProductUnitPrice = productUnitPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
