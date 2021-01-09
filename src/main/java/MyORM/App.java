package MyORM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import MyORM.Sample.SqlMapper;
import MyORM.Sample.Student;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "abc"));
        students.add(new Student(2, "def"));
        SqlMapper<Student> mapper = new SqlMapper<>();
        try {
            HashMap<String, Object> a = mapper.getColumnValues(students.get(0));
            for(Entry<String,Object> p: a.entrySet() ){
                System.out.println(p.getKey() + ", " + p.getValue());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
