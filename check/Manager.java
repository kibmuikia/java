public class Manager extends Emp {

  int salary;

  public Manager( int salary ) {
    super( "Hi", 89 );
    // this.name = name; this.age = age; 
    this.salary = salary;
  }

  public void details() {
    System.out.println("Name[ " + this.name + " ], age[ " + this.age + " ], salary[ "+ this.salary +" ]");
  }

}