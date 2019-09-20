public class Dog {

  String name; int age;

  public Dog( String name, int age ) {
    this.name = name;
    this.age = age;
  }

  public String getDetails() {
    return "Dog's name[ "+ this.name +" ] & age[ "+ age +" ].";
  }

  public void bark() {
    System.out.println( "woof" );
  }

  public void bark( int num ) {
    for( int i = 0; i < num; i++ ) {
      System.out.println( "woof!!" );
    }
  }

}
