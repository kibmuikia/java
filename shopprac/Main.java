public class Main {

  public static void main( String[] args ) {
    Item bread = new Item( "Eraser", 20 );
    System.out.printf( bread.getDetails() );
    bread.saveItem();
    System.out.println( bread.viewItems() );
  }
}