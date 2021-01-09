package MyORM.Common;

import java.util.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import MyORM.Annotations.Column;


import MyORM.Annotations.PrimaryKey;
import MyORM.Annotations.Table;

public abstract class Mapper<T> {
    public Class<T> entityClass;

    public Mapper(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public HashMap<String, Object> getColumnValues (T obj) throws Exception {
        HashMap<String, Object> listColumnValues = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field: fields) {
            Annotation[] attributes = field.getAnnotations();
            for(Annotation annotation: attributes) {
                if (annotation.annotationType() == Column.class) {
                    listColumnValues.put(field.getName(), field.get(obj));
                }
            }
        } 

        if (listColumnValues.size() > 0) {
            return listColumnValues;
        }
        return null;
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
