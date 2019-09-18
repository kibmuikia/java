package SamplePointOfSale;


import StoreApplication.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PointofSaleHelperMethodsClass {
    ArrayList<Order> orderplaced = new ArrayList<Order>();
    Scanner input = new Scanner(System.in);
    ArrayList<Category> productCategory = new ArrayList<Category>();
    ArrayList<Product> products = new ArrayList<Product>();
    String id, name, description;
    int numberOfProducts;
    double buyprice, sellingprice, money, change;
    int quantity, categoryindex, orderedQuantity;
    Product orderedProduct = null;
    ArrayList<OrderLine> placed = new ArrayList<OrderLine>();

    public void addingProductCategory() {
        System.out.println("Add new Product Category");
        System.out.println("Enter category id");
        String categoryId = input.next();
        System.out.println("Enter Category name");
        String categoryName = input.next();
        Category category = new Category(categoryId, categoryName);
        productCategory.add(category);
        System.out.println("_____________________category added successfully_______________________");
        String filename = "category.txt";
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(productCategory);
            out.close();
            file.close();
            System.out.println("Object has been serialized");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Product> addingProduct() {

        System.out.println("How many products do want to input");
        try {
            numberOfProducts = input.nextInt();
        } catch (Exception e) {
            System.out.println("Enter numbers only");
        }
        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println("Product id: ");
            id = input.next();
            System.out.println("Name: ");
            name = input.next();
            System.out.println("Description: ");
            description = input.next();
            System.out.print("sellingprice: ");
            try {
                sellingprice = input.nextDouble();
            } catch (Exception e) {
                System.out.println("Selling price must be a number or decimal number");
            }
            System.out.print("quantity: ");
            try {
                quantity = input.nextInt();
            } catch (Exception e) {
                System.out.println("Quantity must be a number or decimal number");
            }
            System.out.print("buyingprice: ");
            try {
                buyprice = input.nextDouble();
            } catch (Exception e) {
                System.out.println("Buying price must be a number or decimal number");
            }
            System.out.println("Category: ");
            //String category = reader.next();
            int index = 0;
            System.out.println("Choose the index of the Product Category");
            try {
                FileInputStream file = new FileInputStream("category.txt");
                ObjectInputStream in = new ObjectInputStream(file);
                productCategory = (ArrayList<Category>) in.readObject();
                for (Category categoryproduct : productCategory) {
                    System.out.println(" Index: " + index + " " + categoryproduct.getCategoryId() + "  " + categoryproduct.getCategoryName());
                    index++;
                }
            } catch (Exception e) {

            }

            try {
                categoryindex = input.nextInt();
            } catch (Exception e) {
                System.out.println("Buying price must be a number or decimal number");
            }

            Category itemCategory = productCategory.get(categoryindex);

            Product product = new Product(id, name, description, buyprice, sellingprice, quantity, itemCategory);
            String filename = "product.ser";
            try {
                //Saving of object in a file
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);

                //Method for serialization of object
                products.add(product);
                out.writeObject(products);

                out.close();
                file.close();

                System.out.println("Object has been serialized");
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        return products;
    }

    public void displayProduct() {

        System.out.println("Name " + "\t" + "Description " + "\t" + "Selling Price" + "\t" + "Quantity" + "\t");

        String filename = "product.ser";
        try {

            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            products = (ArrayList<Product>) in.readObject();

            for (Product product : products) {
                System.out.println(product.productName + "\t \t " + product.productDescription + "\t\t  " + product.ProductUnitPrice + "\t\t  " + product.productQuantity);

            }
            //}

            in.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

    }

    public void placeOrder() {
        int index = 0;
        System.out.println("Enter the Name of the Customer");
        String custname = input.next();
        Customer customer = new Customer(custname);

        System.out.println("########### PRODUCTS ########");
        System.out.println("Index \t\t Product-Id\t\t ProductName\t\tProduct Description\t\t ProductPrice");
        for (Product product : products) {
            System.out.println("Index " + index + "\t\t " + product.productId + "\t\t  " + product.productName + " \t\t " + product.productDescription + "\t\t  " + product.ProductUnitPrice);
            index++;
        }

        System.out.println("Enter 30 to exit the cart ");
        int productchoice = 0;

        do {
            System.out.println("Enter the index of the item you want to purchase ");
            try {
                productchoice = input.nextInt();
            } catch (Exception e) {
                System.out.println("The item index does not exist");
                continue;
            }
            if (productchoice == 30) {
                continue;
            }
            try {
                orderedProduct = products.get(productchoice);
            } catch (Exception e) {
                System.out.println("The item index does not exist");
                continue;
            }


            System.out.println("Enter the quantity of the item you want to purchase ");
            try {
                orderedQuantity = input.nextInt();
            } catch (Exception e) {
                System.out.println("Quantity must be in number format");
                break;
            }

            OrderLine productsOrdered = new OrderLine(orderedProduct, orderedQuantity);
            placed.add(productsOrdered);

            orderedProduct.setProductQuantity(orderedProduct.getProductQuantity() - quantity);
            //updating
            String filename = "product.ser";
            try {
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);
                out.writeObject(products);

                out.close();
                file.close();

                System.out.println("Object has been serialized");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Name " + "\t" + "Description " + "\t" + "Selling Price" + "\t" + "Quantity" + "\t");
            for (OrderLine productOrder : placed) {
                // prod.quantity = quantity;


                System.out.println(" " + productOrder.getOrderItem().productName + "\t\t  " + productOrder.getOrderItem().productDescription + "\t\t  " + productOrder.getOrderItem().ProductUnitPrice + " \t\t " + productOrder.OrderItemQuantity);

            }

        } while (productchoice != 30);
        System.out.println("Name " + "\t" + "Description " + "\t" + "Selling Price" + "\t" + "Quantity" + "\t");
        for (OrderLine productOrder : placed) {

            System.out.println(" " + productOrder.getOrderItem().productName + "\t\t  " + productOrder.getOrderItem().productDescription + "\t\t  " + productOrder.getOrderItem().ProductUnitPrice + " \t\t " + productOrder.OrderItemQuantity);
        }
        Order order = new Order(placed, customer, PointOfSaleMain.user);
        System.out.println("Enter The money you want to pay");
        try {
            Double money = input.nextDouble();
        } catch (Exception e) {
            System.out.println("Money must be number or decimal number");
            //continue;
        }
        if (money >= order.getTotal()) {
            change = (money - order.getTotal());
            System.out.println(change);
        } else {
            System.out.println("Indequate money");
            //continue;
        }
        System.out.println("You were Served by :" + order.getOrderAttendant().userName);
        System.out.println("Customer:  " + order.getOrderCustomer().customerName);
        System.out.println("The Total of the order is " + order.getTotal());
        System.out.println("The Total change is  " + change);
        System.out.println("####### Admin side #### of the order");
        System.out.println("The Profit accrued is " + order.getProfit());
        //String fileorder = "order.txt";
        String fileorder = "order.txt";

        try {
            //Saving of object in a file
            FileInputStream filew = new FileInputStream(fileorder);
            ObjectInputStream in = new ObjectInputStream(filew);


            FileOutputStream file = new FileOutputStream(fileorder);
            ObjectOutputStream out = new ObjectOutputStream(file);


            while (in.available() != 0) {
                orderplaced = (ArrayList<Order>) in.readObject();
            }


            orderplaced.add(order);

            out.writeObject(orderplaced);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }


    }

    public ArrayList<Order> displayOrders() {
        String fileorders = "order.txt";
        //String fileorders = "orderlist.txt";

        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(fileorders);
            ObjectInputStream in = new ObjectInputStream(file);
            do {
                orderplaced = (ArrayList<Order>) in.readObject();

                // }
            } while (in.available() != 0);
            in.close();
            file.close();
            System.out.println("product \t description \t buyingprice \t sellingPrice \t quantity \t\t\t Order Total");
            double accumulatedProfit = 0.0;
            double accumulatedSales = 0.0;
            for (Order orders : orderplaced) {
                System.out.println("Attendant Name \t" + orders.getOrderAttendant().getUserName());
                System.out.println("Customer Name \t" + orders.getOrderCustomer().getCustomerName());
                for (OrderLine orderline : orders.orderProducts) {
                    System.out.println(orderline.getOrderItem().getProductName() + "\t\t\t\t" + orderline.getOrderItem().getProductDescription() + "\t\t\t\t" + orderline.getOrderItem().getProductBuyingPrice() + "\t\t\t\t" + orderline.getOrderItem().getProductUnitPrice() + "\t\t\t\t" + orderline.OrderItemQuantity + "\t\t\t\t");

                }
                System.out.print("Order Total \t" + orders.getTotal());
                System.out.println();
                System.out.println("Order Profit \t" + orders.getProfit());
                accumulatedProfit = accumulatedProfit + orders.getProfit();
                accumulatedSales = accumulatedSales + orders.getTotal();
                System.out.println("_____________________________________________________________________________________________________");

            }
            System.out.println("Accumulated Profit " + accumulatedProfit);
            System.out.println("Accumulated Sales " + accumulatedSales);

        } catch (IOException ex) {
            System.out.println("IOException is caught");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        System.out.println("_____________________________________________________________________________________________________");
        return orderplaced;
    }

    public void displayReorderProducts() {
        System.out.println("Enter your reorder quantity to know  items to add");
        int reorder = 0;
        try {
            reorder = input.nextInt();
        } catch (Exception e) {
            System.out.println("Reoder level must be a number");
        }
        String filename = "product.ser";
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            products = (ArrayList<Product>) in.readObject();

            for (Product product : products) {
                System.out.println(product.productName + "\t \t " + product.productDescription + "\t\t  " + product.ProductUnitPrice + "\t\t  " + product.productQuantity);

            }
            in.close();
            file.close();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

        System.out.println("Name " + "\t" + "Description " + "\t" + "Selling Price" + "\t" + "Quantity" + "\t");
        for (Product product : products) {
            System.out.println(product.getProductQuantity());
            if (product.getProductQuantity() <= reorder) {
                System.out.println(product.productName + "\t \t " + product.productDescription + "\t \t " + product.ProductUnitPrice + "\t\t  " + product.productQuantity);
            }

        }

    }

    public void displaySales() {
        System.out.println("Enter the name of the User");
        String userName = input.nextLine();


        String fileorders = "order.txt";
        try {
            FileInputStream file = new FileInputStream(fileorders);
            ObjectInputStream in = new ObjectInputStream(file);
            do {
                orderplaced = (ArrayList<Order>) in.readObject();
            } while (in.available() != 0);
            in.close();
            file.close();
            System.out.println("product \t description \t buyingprice \t sellingPrice \t quantity \t\t\t Order Total");
            double accumulatedProfit = 0.0;
            double accumulatedSales = 0.0;
            for (Order orders : orderplaced) {
                if (orders.getOrderAttendant().getUserName().equalsIgnoreCase(userName)) {
                    System.out.println("Attendant Name \t" + orders.getOrderAttendant().getUserName());
                    System.out.println("Customer Name \t" + orders.getOrderCustomer().getCustomerName());
                    for (OrderLine orderline : orders.orderProducts) {
                        System.out.println(orderline.getOrderItem().getProductName() + "\t\t\t\t" + orderline.getOrderItem().getProductDescription() + "\t\t\t\t" + orderline.getOrderItem().getProductBuyingPrice() + "\t\t\t\t" + orderline.getOrderItem().getProductUnitPrice() + "\t\t\t\t" + orderline.OrderItemQuantity + "\t\t\t\t");

                    }
                    System.out.print("Order Total \t" + orders.getTotal());
                    System.out.println();
                    System.out.println("Order Profit \t" + orders.getProfit());
                    accumulatedProfit = accumulatedProfit + orders.getProfit();
                    accumulatedSales = accumulatedSales + orders.getTotal();

                System.out.println("_____________________________________________________________________________________________________");
                }
            }
                System.out.println("Accumulated Profit " + accumulatedProfit);
                System.out.println("Accumulated Sales " + accumulatedSales);
                System.out.println("_____________________________________________________________________________________________________");
            } catch(Exception e){

            }
        }
    }
