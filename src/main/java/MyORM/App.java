package MyORM;

import MyORM.MySQL.MySQLMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MySQLMapper test = new MySQLMapper();
        test.getTableName(Student.class);
    }
}
