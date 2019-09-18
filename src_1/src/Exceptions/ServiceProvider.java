package Exceptions;

public class ServiceProvider {
    public int divide(int a, int b){
        int result=0;
        try {
            result= a/b;
        }
        catch (ArithmeticException e){
            System.out.println("You are dividing the number by zero");
        }
        return result;
    }
    public int sizeOfString(){
        String a = null;
        return a.length();
    }
    public double getDivision(int a, int b)throws ArithmeticException {
        return a/b;
    }
}
