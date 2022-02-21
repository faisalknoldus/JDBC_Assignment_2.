
import java.sql.*;
public class Shopping {
    static Connection con = null;
    static PreparedStatement stmt = null;
  //  static ResultSet rs;

    public void dbCon() throws Exception{
        con = DatabaseConnection.getDatabaseConnection();
    }

    //*******************************  Question-1 *******************************************************

    public void putDataToProductTable(int pid, double price, String name) throws Exception{
        String query = "INSERT INTO products VALUES (?,?,?)";
        stmt = con.prepareStatement(query);
        stmt.setInt(1,pid);
        stmt.setDouble(2,price);
        stmt.setString(3,name);
        int count = stmt.executeUpdate();
        System.out.println(count + " rows Effected");

    }
    public void putDataToCartTable(int pid, int qty) throws Exception{
        String query = "INSERT INTO cart VALUES (?,?)";
        stmt =con.prepareStatement(query);
        stmt.setInt(1,pid);
        stmt.setInt(2,qty);

        int count = stmt.executeUpdate();
        System.out.println(count + " rows Effected");
    }
    //.....

    //********************************** Question-2 *****************************************************

    public void printData(int pid) throws Exception{
        String query = "SELECT * FROM products WHERE products.pid =" +pid;
        stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            System.out.println(rs.getDouble(2) + " " + rs.getString(3));
        }
        else{
            System.out.println("Empty");
        }

    }

    //********************************** Question-3 ******************************************************

    public void findAveragePrice() throws Exception{
        String query = "SELECT pid ,AVG(price) AS 'Avg Price' FROM products GROUP BY pid";
        stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1) + "  " + rs.getDouble(2));
        }
    }


    public static void main(String[] args) throws Exception{
        Shopping mainObj = new Shopping();
        mainObj.dbCon();
        mainObj.putDataToProductTable(1,8,"Reynolds 405_Faisal");
        mainObj.putDataToCartTable(12,1);
        mainObj.printData(4);
        mainObj.findAveragePrice();
        stmt.close();
        con.close();
    }
}