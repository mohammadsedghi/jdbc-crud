package ir.maktab.personreposiitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class JdbcConnection {
    public static final String DB_URL = "jdbc:postgresql://localhost/irmaktab";
    public static final String USER = "postgres";
    public static final String PASS = "12345";
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (Exception e) {
            System.out.println(e);
        }
      return null;
    }
}
