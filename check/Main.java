import java.util.*;
// import java.util.Map.Entry;

public class Main {

  public static void main( String [] args ) {
    System.out.println( "\tCheck[Main] running" );
    // Emp one = new Emp();
    // one.name = "John Doe";
    // one.age = 20;
    // one.details();
    // Manager two = new Manager();
    // two.name = "Thor";
    // two.age = 30;
    // two.salary = 40000;
    // two.details();
    Emp three = new Emp( "Jane Doe", 28 );
    three.details();
    Manager four = new Manager( 500000 );
    four.details();

    HashSet<Integer> kib = new HashSet<Integer>();
    kib.add(1);
    kib.add(2);
    kib.add(3);
    for( Integer i: kib ) {
      System.out.println(i);
    }
  }

}