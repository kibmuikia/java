import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.io.InputStreamReader;



public class DbList {
   LinkedList<Scholar> stude = new LinkedList<>();
   String name,RegNo,course;


   public void populate(){
       for( int i =1; i<=10; i++) {
           System.out.println("Enter the Details of "+i+" Student");
           System.out.println("Name: ");
           name = reader();
           System.out.print("Date of Birth : ");
           Date dateBirth = new Date(reader());
           System.out.print("Registration Number: ");
           RegNo = reader();
           System.out.print("Course : ");
           course = reader();
           stude.add(new Scholar(name, dateBirth,RegNo, course));
       }


   }
   public void display(){
       for(Scholar x : stude){

           System.out.println(x.getName()+" "+x.getCourse()+" "+x.getDateBirth()+" "+x.getRegNo());
       }
   }


   public String reader(){
       InputStreamReader in = null;
       BufferedReader bufferedReader = null;
       String info ="";
       try{
           in = new InputStreamReader(System.in);
           bufferedReader = new BufferedReader(in);
           info = bufferedReader.readLine();

       } catch (IOException e) {
           e.printStackTrace();
       }
       return info;
   }


}
