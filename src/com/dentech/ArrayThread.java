package com.dentech;

public class ArrayThread extends Thread {
    int s,e;
    int[] a;
    public ArrayThread(int s,int e, int[] a){
        this.s = s;
        this.e =e;
        this.a=a;

    }
    public void run(){
        int max = a[s];
        for(int i=(s+1);i<e;i++){
            if(a[i]>max){
                max=a[i];
                //maximumValue=max;
            }

        }

    }
}

