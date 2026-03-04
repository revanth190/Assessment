import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static final String URL  = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";
    static final String PASS = "root123"; 

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to database.");
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return con;
    }
}