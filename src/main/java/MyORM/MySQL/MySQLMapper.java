package MyORM.MySQL;

import java.sql.ResultSet;

import MyORM.Common.Connection;
import MyORM.Common.Mapper;

public class MySQLMapper extends Mapper {

    @Override
    protected <T> void mapOneToMany(Connection con, ResultSet rs, Class<T> entityClass) {
        // TODO Auto-generated method stub

    }

    @Override
    protected <T> void mapManyToOne(Connection con, ResultSet rs, Class<T> entityClass) {
        // TODO Auto-generated method stub

    }
    
}
