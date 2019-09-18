package com.threads;


public class MaxValue extends Thread {
    int c, b;
    int[] a;
    int maximum;

    public MaxValue(int c, int b, int[] a, int maximum) {
        this.c = c;
        this.b = b;
        this.a = a;
        this.maximum = maximum;
    }

    public void run() {
        if (a.length >= 4) {
            int max = a[c];
            for (int i = c; i < b; i++) {
                if (a[i] > Main.maximumValue) {
                    max = a[i];
                    Main.maximumValue = max;
                    System.out.println("Maximum "+max);

                }

            }
        }
    }



}
