package com.threads;

public class SharedCounter extends Thread {
    public void run(){
        for(int i = 0; i<10; i++){
            Main.counter+=1;
        }
    }
}
