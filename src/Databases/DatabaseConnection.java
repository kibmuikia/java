package Databases;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DatabaseConnection {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/JavaDatabases";

    //Connection credentials
    static final String USER = "root";
    static final String PASS = "";

    //setup
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultset =null;

    public void sqlOperator(){
        try {
            Class.forName(JDBC_DRIVER);

            //setup connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // create statemembt
            stmt = conn.createStatement();

            //Declaire a query
            String query = "CREATE TABLE IF NOT EXISTS student( " +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(30) NOT NULL,"+
                    "date_of_birth DATE,"+
                    "course VARCHAR(30)"+
                    ");";

            stmt.executeUpdate(query);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = format.format(new Date("09/08/1995"));


            //INSERTION
            String insertQuery="INSERT INTO student(" +
                    "name,"+
                    "date_of_birth,"+
                    "course)"+
                    "VALUES("+
                    "'Dennis Adan','"+
                     dateString+
                    "','Computer Science');";
            System.out.println(insertQuery);
            //stmt.executeUpdate(insertQuery);
            String result ="SELECT * FROM student;";
           resultset= stmt.executeQuery(result);
            System.out.println(resultset);
            System.out.println("Name"+"\t\t"+  "Date of Birth"+"\t\t"+" Course " );
            preparedStatement =conn.prepareStatement("insert into student (name,date_of_birth,course)VALUES (?,?,?)");
            preparedStatement.setString(1,"Kelvin");
            preparedStatement.setDate(2,java.sql.Date.valueOf("2013-09-04"));
            preparedStatement.setString(3,"Electrical engineering");

            int row = preparedStatement.executeUpdate();
            //System.out.println(row);

            while(resultset.next()){
                System.out.println(resultset.getString("name")+"\t\t"+resultset.getDate("date_of_birth")+""+"\t\t"+resultset.getString("course"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(stmt !=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
            if(resultset !=null){
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        }
    }


}