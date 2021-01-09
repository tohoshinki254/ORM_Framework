package MyORM;

import MyORM.Annotations.PrimaryKey;
import MyORM.Annotations.Table;

@Table(name = "STUDENT")
public class Student {
    @PrimaryKey(name = "abc", autoId = true)
    int a;

    @PrimaryKey(name="123", autoId = false)
    int b;
}
