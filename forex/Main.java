public class Main {

  public static void main( String [] args ) {
    System.out.println( "\t Forex [main-thread] running" );

    Thread t1 = new Thread( new History() );
    t1.start();
    Warning t2 = new Warning();
    t2.start();

    System.out.println("\t Forex [main-thread] Exiting");
  }

}