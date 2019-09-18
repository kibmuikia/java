package com.threads;

import java.util.Random;

public class Main {
    public static int maximumValue = 0;
    public static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[100];
        Random random = new Random();
        for(int z =0; z<a.length; z++){
            a[z]=random.nextInt(1000);
        }
       // int[] nums = {2, 3, 5, 9, 8, 11, 23, 6, 19, 17, 12};
        MaxValue thread1 = new MaxValue(0, 25, a,maximumValue);
        MaxValue thread2 = new MaxValue(25, 50, a,maximumValue);
        MaxValue thread3 = new MaxValue(50, 75, a,maximumValue);
        MaxValue thread4 = new MaxValue(75, 100, a,maximumValue);



        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println("######################################  Maximum Value in an array using four threads #####################");
        System.out.println("From Main "+maximumValue);


        SharedCounter thred[]=new SharedCounter [10];
        for(int i=0;i<10;i++) {
            thred[i] = new SharedCounter();
            thred[i].start();
            thred[i].join();
        }
        System.out.println("######################################  SharedCounter Problem #####################");
        System.out.println( "Counter "+counter);
        System.out.println("######################################  ReverseHello Problem #####################");
        ReverseHello reverseHello = new ReverseHello(1);
        reverseHello.start();

    }

}