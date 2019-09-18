package Exceptions;

public class ExceptionsMain {
    public static void main(String[] args) {
                    ServiceProvider service = new ServiceProvider();
                    System.out.println("good");
                    service.divide(5,0);
                    try {
                        service.getDivision(5,0);
                    }
                    catch (Exception e){
                        System.out.println(e.getLocalizedMessage());
                    }
                    service.sizeOfString();
    }
}
