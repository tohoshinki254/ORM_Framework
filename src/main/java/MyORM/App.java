package MyORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import MyORM.Common.Mapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            String conn = "jdbc:mysql://localhost:3306/mydb?user=root&password=qwerty@12";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(conn);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
