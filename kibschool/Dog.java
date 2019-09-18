public class Dog {

  String name; int age;

  public Dog( String name, int age ) {
    this.name = name;
    this.age = age;
  }

  public String getDetails() {
    return "Dog's name[ "+ this.name +" ] & age[ "+ age +" ].";
  }

}
