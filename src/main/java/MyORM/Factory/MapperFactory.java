package MyORM.Factory;

import MyORM.Common.Mapper;
import MyORM.MySQL.MySQLMapper;

public class MapperFactory {
    private MapperFactory() {

    }

    public static final Mapper createMapper(DatabaseType databaseType) {
        switch (databaseType) {
            case MYSQL:
                return new MySQLMapper();
            case MSSQL:
                return null;
            default:
                throw new IllegalArgumentException("This database type is unsupported");
        }
    }
}
