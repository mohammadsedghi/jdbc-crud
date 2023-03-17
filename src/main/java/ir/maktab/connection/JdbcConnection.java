package ir.maktab.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class JdbcConnection {
//    public static final String DB_URL = "jdbc:postgresql://localhost/irmaktab";
//    public static final String USER = "postgres";
//    public static final String PASS = "1374";
public static final String DB_URL = "jdbc:postgresql://localhost/irmaktab";
       public static final String USER = "postgres";
   public static final String PASS = "mn0652183141";
//    public static final String DB_URL = "jdbc:postgresql://localhost/irmaktab";
//    public static final String USER = "postgres";
//    public static final String PASS = "12345";
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
