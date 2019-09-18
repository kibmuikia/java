package com.dentech;

class SecondThread extends Thread {
    int s,e,sum;
    int[] a;
    public SecondThread(int s,int e, int[] a){
        this.s = s;
        this.e =e;
        this.a=a;

    }
    public void run(){
        for(int i=s;s<=e;i++){
            sum=+a[i];

        }
    }
}
