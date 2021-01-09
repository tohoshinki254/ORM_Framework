package MyORM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import MyORM.Sample.SqlMapper;
import MyORM.Sample.Student;
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
