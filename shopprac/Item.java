import java.sql.*;

public class Item {
  String name; int price;

  public Item( String name, int price ) {
    this.name = name;
    this.price = price;    
  }

  public String getDetails() {
    return "Item[ name: "+ this.name +", price: "+ this.price +" ]";
  }

  public boolean saveItem() {
    try {

      Class.forName( "com.mysql.jdbc.Driver" );
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaprac", "root", "admin");
      Statement stmt = con.createStatement();
      String sql = "insert into items( name, price ) values( '"+ this.name +"','"+ this.price +"' )";
      // ResultSet rs = stmt.executeUpdate( sql );
      // insert data
      stmt.executeUpdate( sql );
      // rs.close(); 
      stmt.close(); con.close();
      return true;

      // .
    } catch( Exception e ) {
      System.out.println( e.getMessage() );
      System.out.println( e );
      e.printStackTrace();
      return false;
    }
  }

  public boolean viewItems() {
    try {
      Class.forName( "com.mysql.jdbc.Driver" );
      Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/javaprac", "root", "admin");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery( "select * from items" );
      while( rs.next() ) {
        System.out.println( "\t" + rs.getInt(1) + " :> " + rs.getString(2) + " : " +rs.getInt(3) );
      }
      rs.close();
      stmt.close();
      con.close();
      return true;
    } catch( Exception e ) {
      System.out.println( "\n" + e );
      System.out.println( "\n" + e.getMessage() );
      // System.out.println( "\n" + e.getSQLState() );
      e.printStackTrace();
      return false;
    }
  }
}