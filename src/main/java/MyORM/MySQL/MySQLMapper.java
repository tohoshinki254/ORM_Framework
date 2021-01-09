package MyORM.MySQL;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.util.List;

import MyORM.Annotations.Column;
import MyORM.Annotations.ManyToOne;
import MyORM.Annotations.OneToMany;
import MyORM.Annotations.PrimaryKey;
import MyORM.Common.Connection;
import MyORM.Common.Mapper;
import MyORM.Exceptions.MapDataException;

public class MySQLMapper extends Mapper {

    @Override
    protected <T> void mapOneToMany(Connection con, ResultSet rs, T obj) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field f : fields) {
                OneToMany oneToMany = f.getAnnotation(OneToMany.class);
                if (oneToMany != null) {
                    String refTableName = oneToMany.tableName();
                    String joinColumn = oneToMany.joinColumn();
                    List<String> pKeyNames = getPrimaryKey(obj.getClass());
                    //trigger
                    String pkName = pKeyNames.size() > 0 ? pKeyNames.get(0) : "";
                    Field fPkName = obj.getClass().getDeclaredField(pkName);
                    fPkName.setAccessible(true);
                    String pkValue = fPkName.get(obj).toString();
                    //
                    String whereStr = String.format("%s.%s = %s", refTableName, joinColumn, pkValue);
                    String query = String.format("SELECT * FROM %s WHERE %s", refTableName, whereStr);
                    
                    ParameterizedType listType = (ParameterizedType) f.getGenericType();
                    Class<?> listTypeClass = (Class<?>) listType.getActualTypeArguments()[0];


                    con.open();
                    List<Object> list = (List<Object>) con.executeQueryWithoutRelationship(query, listTypeClass);
                    f.setAccessible(true);
                    f.set(obj, list);
                    con.close();
                }
            }
        } catch (Exception e) {
            throw new MapDataException(e.getMessage());
        }

    }

    @Override
    protected <T> void mapManyToOne(Connection con, ResultSet rs, T obj) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();

            for (Field f : fields) {
                ManyToOne manyToOne = f.getAnnotation(ManyToOne.class);
                if (manyToOne != null) {
                    String refTableName = manyToOne.tableName();
                    String refColumn = manyToOne.refColumn();
                    String columnName = manyToOne.columnName();

                    String fkValue = rs.getObject(columnName).toString();

                    String whereStr = String.format("%s.%s = %s", refTableName, refColumn, fkValue);
                    String query = String.format("SELECT * FROM %s WHERE %s", refTableName, whereStr);

                    con.open();
                    List<Object> list = (List<Object>) con.executeQueryWithoutRelationship(query, f.getType());
                    f.setAccessible(true);
                    f.set(obj, list.size() > 0 ? list.get(0) : null);
                    con.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
