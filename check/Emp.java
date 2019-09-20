public class Emp {

  String name; int age;

  public Emp( String name, int age ) {
    this.name = name; this.age = age;
  }

  public void details() {
    System.out.println( "Name[ " + this.name + " ], age[ "+ this.age +" ]" );
  }

}