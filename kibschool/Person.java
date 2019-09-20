import java.util.Scanner; // Import Scanner class

public class Person {

  String name, role;
  int idno;

  public String getDetails() {
    // System.out.printf( "Name: %s, Role: %s, idno: %d", name, role, idno );
    String details = "Name[ "+ name +" ], Role[ "+ role +" ], idno[ "+ idno +" ].";
    return details;
  }

  public void setDetails() {
    Scanner userinput = new Scanner(System.in);  // Create a Scanner object
    System.out.println( "Enter name: " );
    // String userName = myObj.nextLine(); // Read user input
    name = userinput.nextLine();
    System.out.println( "Enter role: " );
    role = userinput.nextLine();
    System.out.println( "Enter id number: " );
    idno = userinput.nextInt();
    userinput.close();
  }

}
