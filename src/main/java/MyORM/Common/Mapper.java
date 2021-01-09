package MyORM.Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import MyORM.Annotations.Column;

import java.lang.Class;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;


public abstract class Mapper<T> {
    private Class<T> entityClass;
    public Mapper(Class<T> entityClass){
        this.entityClass = entityClass;
    }
    public List<String> GetColumns(){
        List<String> listColumn = new ArrayList<String>();
        Field[] fields = entityClass.getDeclaredFields();
        
        
        for(int i = 0;i<fields.length;i++)
        {
            Annotation[] annotations = fields[i].getAnnotations();
            for(int j = 0;j<annotations.length;j++)
            {
                if(annotations[i].annotationType() == Column.class);
                {
                    listColumn.add(fields[i].getName());
                }
            }            
        }
        return listColumn;
    }
    
    public boolean FindColumn(String name, HashMap<String, Object> listColumnValue)
    {
        return listColumnValue.containsKey(name);
    }
}
