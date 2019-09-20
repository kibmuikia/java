public class Main {

  public static void main( String[] args) {
    System.out.println( "\tkibschool Main running!" );
    // Person john = new Person(); john.setDetails(); System.out.println( john.getDetails() );
    Coder who = new Coder(); who.level = "intermediate"; who.setDetails(); 
    System.out.println(who.getDetails());
    // Person people[] = new Person[1];
    // for( int i = 0; i < people.length; i++ ) {
    //   // people[i] = new Person();
    //   // people[i].setDetails();
    //   // System.out.println( people[i].getDetails() );
    // }

    Dog dogone = new Dog( "bobby", 3 );
    System.out.println( dogone.getDetails() );
    dogone.bark();
    dogone.bark( 2 );
    Rott r = new Rott();
    System.out.println( r.getDetails() );
    r.bark();
    r.bark( 3 );

  }

}
