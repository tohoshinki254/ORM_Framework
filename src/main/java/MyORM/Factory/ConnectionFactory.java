package MyORM.Factory;

import MyORM.Common.Connection;
import MyORM.MySQL.MySQLConnection;

public class ConnectionFactory {

    private ConnectionFactory() {

    }

    public static final Connection createConnection(DatabaseType databaseType, String conString) {
        switch (databaseType) {
            case MYSQL:
                return new MySQLConnection(conString);
            case MSSQL:
                return null;
            default:
                throw new IllegalArgumentException("This database type is unsupported");
        }
    }
}
