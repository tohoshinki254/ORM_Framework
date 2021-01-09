package MyORM.Common;

import java.lang.reflect.Field;
import java.sql.ResultSet;

import MyORM.Annotations.Column;
import MyORM.Annotations.PrimaryKey;
import MyORM.Exceptions.MapDataException;

public abstract class Mapper {

    public <T> T mapWithoutRelationship(ResultSet rs, Class<T> entityClass) {
        try {
            T object = entityClass.getDeclaredConstructor().newInstance();
            Field[] fields = entityClass.getDeclaredFields();

            for (Field field : fields) {
                Column column = field.getAnnotation(Column.class);
                PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);

                if (column != null) {
                    field.setAccessible(true);
                    field.set(object, rs.getObject(column.name()));
                }

                if (primaryKey != null) {
                    field.setAccessible(true);
                    field.set(object, rs.getObject(primaryKey.name()));
                }
            }

            return object;
        } catch (Exception e) {
            throw new MapDataException(e.getMessage());
        }
    }

    public <T> T mapWithRelationship(Connection con, ResultSet rs, Class<T> entityClass) {

        //Map all column annotation
        T obj = mapWithoutRelationship(rs, entityClass);

        return obj;
    }

    protected abstract <T> void mapOneToMany(Connection con, ResultSet rs, Class<T> entityClass);
    protected abstract <T> void mapManyToMany(Connection con, ResultSet rs, Class<T> entityClass);
}
