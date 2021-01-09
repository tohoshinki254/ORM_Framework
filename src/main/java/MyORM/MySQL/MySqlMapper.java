package MyORM.MySQL;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;

import MyORM.Annotations.OneToMany;
import MyORM.Common.Connection;
import MyORM.Common.Mapper;

public class MySQLMapper extends Mapper {

    @Override
    protected <T> void mapManyToOne(Connection con, ResultSet rs, T obj) {

    }

    @Override
    protected <T> void mapOneToMany(Connection con, ResultSet rs, T obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            OneToMany oneToMany = f.getAnnotation(OneToMany.class);
            if (oneToMany != null) {
                String refTableName = oneToMany.tableName();
                List<String> pKeys = getPrimaryKey(obj.getClass());
            }
        }

    }
}
