import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Conn {

    Connection c;
    Statement s;

    Conn() {

        try {

            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Load database config - try classpath first (inside JAR), then fall back to file
            Properties p = new Properties();
            InputStream is = Conn.class.getResourceAsStream("/db.properties");
            if (is != null) {
                p.load(is);
                is.close();
            } else {
                // Fallback for development: load from file system
                p.load(new FileInputStream("db.properties"));
            }

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