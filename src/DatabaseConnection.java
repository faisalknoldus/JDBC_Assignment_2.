
import java.sql.*;
public class DatabaseConnection {
    final static String className = "com.mysql.cj.jdbc.Driver";
    final static String url = "jdbc:mysql://localhost:3306/shopping";
    final static String uname = "root";
    final static String pass= "";

    public static Connection getDatabaseConnection() throws Exception{
        PreparedStatement stmt = null;
        Class.forName(className);
        Connection con = DriverManager.getConnection(url,uname,pass);
        return con;
    }
}