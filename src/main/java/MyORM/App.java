package MyORM;

import java.util.List;

import MyORM.Common.Connection;
import MyORM.Common.Mapper;
import MyORM.MySQL.MySQLConnection;
import MyORM.Sample.Order;
import MyORM.Sample.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection connection = new MySQLConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=qwerty@12");
        connection.open();
        String query = "SELECT * FROM products";
        List<Product> list = connection.executeQuery(query, Product.class);
        connection.close();

        for (Product product : list) {
            System.out.println(product.toString());
        }
    }
}
