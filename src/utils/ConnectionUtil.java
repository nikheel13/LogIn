package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
    Connection con = null;
    public static Connection conDB()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clients", "root", "Manchester13!");
            return con;

        } catch (Exception ex) {

            System.err.println("ConnectionUtil : "+ex.getMessage());
            return null;
        }
        //Remember to add the Library!!! (jdbc Driver)
    }
}