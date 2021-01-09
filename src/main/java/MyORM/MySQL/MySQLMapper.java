package MyORM.MySQL;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;

import MyORM.Annotations.ManyToOne;
import MyORM.Annotations.OneToMany;
import MyORM.Annotations.PrimaryKey;
import MyORM.Common.Connection;
import MyORM.Common.Mapper;

public class MySQLMapper extends Mapper {

    @Override
    protected <T> void mapOneToMany(Connection con, ResultSet rs, T obj) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field f : fields) {
                OneToMany oneToMany = f.getAnnotation(OneToMany.class);
                if (oneToMany != null) {
                    String refTableName = oneToMany.tableName();
                    List<String> pKeys = getPrimaryKey(obj.getClass());
                    String pkName = pKeys.size() > 0 ? pKeys.get(0) : "";

                    String whereString = "";
                    


                    String query = String.format("SELECT * FROM %s WHERE %s", refTableName, whereString);

                    con.open();
                    List<Object> list = (List<Object>) con.executeQueryWithoutRelationship(query, obj.getClass());
                    f.set(obj, list);
                    con.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
                    String columnName = manyToOne.columnName();
                    List<String> pKeys = getPrimaryKey(obj.getClass());
                    String whereStr = "";
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
