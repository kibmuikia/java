public class Coder extends Person {
  String level;

  public String getDetails() {
    // System.out.printf( "Name: %s, Role: %s, idno: %d", name, role, idno );
    String details = "Name[ " + name + " ], Role[ " + role + " ], idno[ " + idno + " ], level[ "+ level +" ].";
    return details;
  }


}