package MyORM;

import java.util.List;

import MyORM.Common.Connection;
import MyORM.MySQL.MySQLConnection;
import MyORM.Sample.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection connection = new MySQLConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=Thanhtien250499");
        connection.open();
        List<Product> list = connection.select(Product.class).where("").groupBy("order_id").run(Product.class);
        connection.close();

        for (Product product : list) {
            System.out.println(product.toString());
        }
        
    }
}
