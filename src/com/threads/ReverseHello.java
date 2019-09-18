package com.threads;

public class ReverseHello extends Thread {
    int count;
    public ReverseHello(int count){
        this.count = count;

    }
        /*
        * The method instantiates class thread
        * @param int counter
        *starts a new thread
        *
        *
        * */
    public void createThread(int thredCounter){

            ReverseHello thread = new ReverseHello(count+1);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Printing from the number "+count +" Thread ");

    }
    /*
    * calls method create thread 50 times
    * */
    public void run()
    {
        if(count<51){
            createThread(count+1);
        }


    }


}
