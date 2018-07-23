import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

    public static void main(String[] args) {
        Statement stmt = null;
        //String url="jdbc:mysql://192.168.99.100:3306/sakila?user=root&password=root&useUnicode=true&characterEncoding=gb2312";
        Connection conn= null;

        String url = "jdbc:mysql://192.168.99.100:3306/sakila?useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String pass = "123456";
        String sql1 = "";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("Connected database successfully...");
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = (Statement) conn.createStatement();
            String sql = "SELECT city_id,city FROM city WHERE country_id ="+args;
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int city_id = rs.getInt("city_id");
                String city = rs.getString("city");
                //Display values
                System.out.print(city_id);
                System.out.println(" | " + city);
            }
            rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main

}
