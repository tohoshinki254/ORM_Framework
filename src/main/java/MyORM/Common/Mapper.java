package MyORM.Common;

import java.util.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import MyORM.Annotations.PrimaryKey;
import MyORM.Annotations.Table;

public abstract class Mapper<T> {
    public Class<T> entityClass;

    public Mapper(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public String getTableName() {
        try {
            Table anno = entityClass.getAnnotation(Table.class);
            if (anno != null) {
                String className = anno.name();
                System.out.println(anno);
                return className;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public List<String> getPrimaryKey() {
        List<String> primaryKey = new ArrayList<String>();

        Field[] attributes = entityClass.getDeclaredFields();
        for (Field attribute : attributes) {
            Annotation[] annotations = attribute.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == PrimaryKey.class) {
                    primaryKey.add(attribute.getName());
                    break;
                }
            }
        }

        return primaryKey;
    }
}
