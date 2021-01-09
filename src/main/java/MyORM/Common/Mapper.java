package MyORM.Common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;

import MyORM.Annotations.Column;

public abstract class Mapper<T> {
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




    // protected Object firstOrDefault(Object[] attributes, Class p) {
    //     for(Object attribute: attributes) {
    //         if (attribute.getClass() == p) {
    //             return attributes;

    //         }
    //     }
    //     return null;
    // }

}
