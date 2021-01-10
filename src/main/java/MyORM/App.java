package MyORM;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import MyORM.Common.Connection;
import MyORM.Common.Mapper;
import MyORM.MySQL.MySQLConnection;
import MyORM.MySQL.MySQLMapper;
import MyORM.MySQL.MySQLUpdate;
import MyORM.Sample.Order;
import MyORM.Sample.Product;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        
        Date date = new Date(1610275737);
        
        Connection connection = new MySQLConnection(
                "jdbc:mysql://localhost:800/mydb?user=root&password=quangthinh123321");
        connection.open();
        Long i = (long) 15;
        Order order = new Order(i, date, 36, "aaa");
        int result;
        result = connection.delete(order, Order.class);
        
    }
}
