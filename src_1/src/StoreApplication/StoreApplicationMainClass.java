package StoreApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class StoreApplicationMainClass implements java.io.Serializable {
    public static void main(String[] args) {
        List<Products> objectsList = new ArrayList<Products>();
        int choice = 0;
        int number = 0;
        int quantity = 0;
        double sellingprice = 0.0;
        double buyprice = 0.0;
        double money = 0.0;
        double change = 0.0;
        Products orderdproduct = null;
        ArrayList<Order> orderplaced= new ArrayList<Order>();
        //OrderLine line=null;
        ArrayList<Products> orders = new ArrayList<Products>();
        ArrayList<Order> orderlines = new ArrayList<Order>();
        ArrayList<Products> productlist = new ArrayList<Products>();
        ArrayList<Order> placed = new ArrayList<Order>();
       // productlist.add(new Products("1", "Maziwa", "lala", 80, 10, 65, new Category("Food")));
        //productlist.add(new Products("12", "Maziwa F", "Fresh", 80, 10, 65, new Category("Food")));
        //productlist.add(new Products("13", "Pembe", "maize", 100, 90, 90, new Category("Food")));
       // productlist.add(new Products("14", "Gaza", "lala", 80, 10, 70, new Category("Food")));
        Scanner reader = new Scanner(System.in);


        do {

            System.out.println("############## MENU ###############");
            System.out.println("1. Add Products");
            System.out.println("2 View Products");
            System.out.println("3 Do Shopping/Help a shopper");
            System.out.println("4 What/when to Reorder");
            System.out.println("5 View orders placed");
            System.out.println("6 Quit");
            try {
                choice = Integer.parseInt(reader.next());
                // choice = reader.nextInt();
            } catch (Exception e) {
                //reader.reset();
                System.out.println("Invalid option numbers only");
                //e.printStackTrace();
                continue;
            }

            switch (choice) {
                case 1:
                    choice = 1;
                    System.out.println("How many products do want to input");
                    try {
                        number = reader.nextInt();
                    } catch (Exception e) {
                        System.out.println("Enter numbers only");
                    }
                    for (int i = 0; i < number; i++) {
                        System.out.println("Product id: ");
                        String id = reader.next();
                        System.out.println("Name: ");
                        String name = reader.next();
                        System.out.println("Description: ");
                        String description = reader.next();
                        System.out.print("sellingprice: ");
                        try {
                            sellingprice = reader.nextInt();
                        } catch (Exception e) {
                            System.out.println("Selling price must be a number or decimal number");
                        }
                        System.out.print("quantity: ");
                        try {
                            quantity = reader.nextInt();
                        } catch (Exception e) {
                            System.out.println("Quantity must be a number or decimal number");
                        }
                        System.out.print("buyingprice: ");
                        try {
                            buyprice = reader.nextInt();
                        } catch (Exception e) {
                            System.out.println("Buying price must be a number or decimal number");
                        }
                        System.out.println("Category: ");
                        String category = reader.next();
                        Products p = new Products(id, name, description, sellingprice, quantity, buyprice, new Category(category));
                        String filename = "product.txt";
                        try {
                            //Saving of object in a file
                            FileOutputStream file = new FileOutputStream(filename);
                            ObjectOutputStream out = new ObjectOutputStream(file);

                            //Method for serialization of object
                            productlist.add(p);
                            out.writeObject(productlist);

                            out.close();
                            file.close();

                            System.out.println("Object has been serialized");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        // productlist.add(p);
                    }
                    break;
                case 2:
                    choice = 2;
                    System.out.println("Name " + "\t" + "Description " + "\t" + "Selling Price" + "\t" + "Quantity" + "\t");
                   // for (Products product : productlist) {
                        //System.out.println(product.name + "\t \t " + product.description + "\t\t  " + product.sellingPrice + "\t\t  " + product.quantity);

                   // }
                    //2Products decen = null;
                    String filename = "product.txt";
                    try {
                        // Reading the object from a file
                        FileInputStream file = new FileInputStream(filename);
                        ObjectInputStream in = new ObjectInputStream(file);
                        boolean cont = true;
                        //while (in.available() != 0) {
                             productlist = (ArrayList<Products>) in.readObject();

                            for (Products product : productlist) {
                                System.out.println(product.name + "\t \t " + product.description + "\t\t  " + product.sellingPrice + "\t\t  " + product.quantity);

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

                    break;
                case 3:
                    choice = 3;
                    int index = 0;
                    System.out.println("Enter the Name of the Customer");
                    String custname = reader.next();
                    Customer customer = new Customer(custname);
                    System.out.println("Enter your  Id");
                    int id = reader.nextInt();
                    System.out.println("Enter your  Username");
                    String username = reader.next();
                    User user = new User(username, id);
                    System.out.println("########### PRODUCTS ########");
                    System.out.println("Index \t\t Product-Id\t\t ProductName\t\tProduct Description\t\t ProductPrice");
                    for (Products product : productlist) {
                        System.out.println("Index " + index + "\t\t " + product.id + "\t\t  " + product.name + " \t\t " + product.description + "\t\t  " + product.sellingPrice);
                        index++;
                    }

                    System.out.println("Enter 30 to exit the cart ");
                    int productchoice = 0;

                    do {
                        System.out.println("Enter the index of the item you want to purchase ");
                        try {
                            productchoice = reader.nextInt();
                        } catch (Exception e) {
                            System.out.println("The item index does not exist");
                            continue;
                        }
                        if (productchoice == 30) {
                            continue;
                        }
                        try {
                            orderdproduct = productlist.get(productchoice);
                        } catch (Exception e) {
                            System.out.println("The item index does not exist");
                            continue;
                        }


                        System.out.println("Enter the quantity of the item you want to purchase ");
                        try {
                            quantity = reader.nextInt();
                        } catch (Exception e) {
                            System.out.println("Quantity must be in number format");
                            break;
                        }
                        //ArrayList<OrderLine> placed = new ArrayList<OrderLine>();
                        //OrderLine line = new OrderLine(new Products(orderdproduct.getId(), orderdproduct.getName(), orderdproduct.getDescription(), orderdproduct.getSellingPrice(), quantity, orderdproduct.getBuyingPrice(), orderdproduct.getCategory()));
                        //line.setQuantity(quantity);
                       // placed.add(new OrderLine(new Products(orderdproduct.getId(), orderdproduct.getName(), orderdproduct.getDescription(), orderdproduct.getSellingPrice(), quantity, orderdproduct.getBuyingPrice(), orderdproduct.category)));


                        Products oditem = new Products(orderdproduct.getId(), orderdproduct.getName(), orderdproduct.getDescription(), orderdproduct.getSellingPrice(), quantity, orderdproduct.getBuyingPrice(), orderdproduct.category);
                        orderdproduct.setQuantity(orderdproduct.getQuantity() - quantity);
                        orders.add(oditem);


                        System.out.println("Name " + "\t" + "Description " + "\t" + "Selling Price" + "\t" + "Quantity" + "\t");
                        for (Products prod : orders) {
                            // prod.quantity = quantity;


                            System.out.println(" " + prod.name + "\t\t  " + prod.description + "\t\t  " + prod.sellingPrice + " \t\t " + prod.getQuantity());

                        }

                    } while (productchoice != 30);
                    System.out.println("Name " + "\t" + "Description " + "\t" + "Selling Price" + "\t" + "Quantity" + "\t");
                    for (Products prods : orders) {
                        System.out.println(prods.name + "\t \t " + prods.description + "\t \t " + prods.sellingPrice + "\t\t  " + prods.quantity);
                    }
                    Order order = new Order(customer, user, orders);
                    System.out.println("Enter The money you want to pay");
                    try {
                        money = reader.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Money must be number or decimal number");
                        continue;
                    }
                    if (money >= order.getTotal()) {
                        change = (money - order.getTotal());
                    } else {
                        System.out.println("Indequate money");
                        continue;
                    }
                    System.out.println("You were Served by :" + order.getUser().name);
                    System.out.println("Customer:  " + order.getCustomer().customerName);
                    System.out.println("The Total of the order is " + order.getTotal());
                    System.out.println("The Total change is  " + change);
                    System.out.println("####### Admin side #### of the order");
                    System.out.println("The Profit accrued is " + order.getProfit());
                    //String fileorder = "order.txt";
                    String fileorder = "orderlist.txt";

                    try {
                        //Saving of object in a file
                        FileInputStream filew = new FileInputStream(fileorder);
                        ObjectInputStream in = new ObjectInputStream(filew);


                        FileOutputStream file = new FileOutputStream(fileorder);
                        ObjectOutputStream out = new ObjectOutputStream(file);


//                       if(in.available()==0) {
//                           // Method for serialization of object
//                           System.out.println("Nmepitia");
//                       }
                        while (in.available()!=0) {
                            orderplaced = (ArrayList<Order>) in.readObject();
                        }
//                        System.out.println("Tumepitia");

                        orderplaced.add(order);

                        out.writeObject(orderplaced);

                        out.close();
                        file.close();

                        System.out.println("Object has been serialized");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {

                    }


                    break;
                case 4:
                    choice = 4;
                    System.out.println("Enter your reorder quantity to know  items to add");
                    int reorder = 0;
                    try {
                        reorder = reader.nextInt();
                    } catch (Exception e) {
                        System.out.println("Reoder level must be a number");
                    }
                    System.out.println("Name " + "\t" + "Description " + "\t" + "Selling Price" + "\t" + "Quantity" + "\t");
                    for (Products prods : productlist) {
                        if (prods.quantity <= reorder) {
                            System.out.println(prods.name + "\t \t " + prods.description + "\t \t " + prods.sellingPrice + "\t\t  " + prods.quantity);
                        }
                    }

                    break;
                case 5:
                    choice = 5;
                    //String fileorders = "order.txt";
                    String fileorders = "orderlist.txt";

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
                        for (Order ordrs : orderplaced ) {
                            System.out.println("Attendant Name \t"+ordrs.getUser().getName());
                            System.out.println("Customer Name \t"+ordrs.getCustomer().getCustomerName());
                            for (Products w : ordrs.getOrders()) {
                                System.out.println(w.getName() + "\t\t\t\t" + w.getDescription() + "\t\t\t\t" + w.getBuyingPrice() + "\t\t\t\t" + w.getSellingPrice() + "\t\t\t\t" + w.getQuantity() + "\t\t\t\t" );
                            }
                            System.out.print("Order Total \t"+ordrs.getTotal());
                            System.out.println();
                        }

                    } catch (IOException ex) {
                        System.out.println("IOException is caught");
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        System.out.println("ClassNotFoundException is caught");
                    }
                    break;
                case 6:
                    choice = 6;
                    System.out.println("Thanks for Visiting. Goodbye");
                    choice = 10;
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;

            }
        } while (choice != 10);

    }
}
