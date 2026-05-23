import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class Conn {

    Connection c;
    Statement s;

    Conn() {

        try {

            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Load database config from file
            Properties p = new Properties();
            p.load(new FileInputStream("db.properties"));

            String url = p.getProperty("url");
            String username = p.getProperty("username");
            String password = p.getProperty("password");

            // Create connection
            c = DriverManager.getConnection(url, username, password);

            // Create statement object
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}