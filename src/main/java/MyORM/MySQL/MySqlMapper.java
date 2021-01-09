package MyORM.MySQL;

import java.lang.reflect.Field;
import java.sql.ResultSet;

import MyORM.Annotations.OneToMany;
import MyORM.Common.Connection;
import MyORM.Common.Mapper;

public class MySqlMapper extends Mapper {

    @Override
    protected <T> void mapOneToMany(Connection con, ResultSet rs, Class<T> entityClass) {
        // TODO Auto-generated method stub

    }

    @Override
    protected <T> void mapManyToMany(Connection con, ResultSet rs, Class<T> entityClass) {
        // TODO Auto-generated method stub

    }


}
