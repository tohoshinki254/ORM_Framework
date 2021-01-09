package MyORM.Sample;

import MyORM.Annotations.Column;
import MyORM.Annotations.Table;

@Table(name="student")
public class Student {
    @Column(name="mssv")
    public int mssv;

    @Column(name="className")
    public String className;

    public Student(int mssv, String className) {
        this.mssv = mssv;
        this.className = className;
    }
}
