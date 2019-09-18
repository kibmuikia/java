package SamplePointOfSale;

import java.util.ArrayList;
import java.util.Scanner;

public class PointOfSaleMain

{
     static Scanner input = new Scanner(System.in);
     static User user;
    public static void main(String[] args) {
        String userId, userName;
        ArrayList<User> users =new ArrayList<User>();
        int menuSelector=0;
        ArrayList<Category> productCategory = new ArrayList<Category>();
        PointofSaleHelperMethodsClass helperMehods =new PointofSaleHelperMethodsClass();
        System.out.println("_______________________________________________________________________________");
        System.out.println("################## POINT OF SALE PROTOTYPE #####################################");
        System.out.println("Enter your User ID to continue");
        userId=input.nextLine();
        System.out.println("Enter your User Name ");
        userName=input.nextLine();
        user = new User(userId,userName);
        users.add(user);



        do {

            System.out.println("############## MENU ###############");
            System.out.println("1. Add Product Categories");
            System.out.println("2. Add Products");
            System.out.println("3 View Products");
            System.out.println("4 Do Shopping/Help a shopper");
            System.out.println("5 What/when to Reorder");
            System.out.println("6 View orders placed");
            System.out.println("7 View sales per User");
            System.out.println("8 Quit");

            try {
                menuSelector = Integer.parseInt(input.next());

            } catch (Exception e) {

                System.out.println("Invalid option numbers only");
                //e.printStackTrace();
                continue;
            }
            switch (menuSelector){
                case 1:
                    menuSelector= 1;
                    helperMehods.addingProductCategory();
                    break;
                case 2:
                    menuSelector= 2;
                    helperMehods.addingProduct();

                    break;
                case 3:
                    menuSelector= 3;
                    helperMehods.displayProduct();

                    break;
                case 4:
                    menuSelector= 4;
                    helperMehods.placeOrder();
                    break;
                case 5:
                    menuSelector= 5;
                    helperMehods.displayReorderProducts();
                    break;
                case 6:
                    menuSelector= 6;
                    helperMehods.displayOrders();

                    break;
                case 7:
                    menuSelector= 7;
                    helperMehods.displaySales();

                    break;
                case 8:
                    menuSelector= 8;

                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }

        }while(menuSelector !=8);

    }
}
