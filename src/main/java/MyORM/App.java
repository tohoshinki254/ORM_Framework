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
        MySQLMapper<Student> test = new MySQLMapper<Student>(Student.class);
        for (String s : test.getPrimaryKey()) {
            System.out.println(s);
        }
    }
}
