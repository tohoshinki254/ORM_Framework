package MyORM.MySQL;

import MyORM.Common.Mapper;

public class MySQLMapper<T> extends Mapper<T> {
    public MySQLMapper(Class<T> entityClass) {
        super(entityClass);
    }
}