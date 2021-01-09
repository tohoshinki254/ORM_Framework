package MyORM.MySQL;

import java.util.List;

import MyORM.Common.Connection;
import MyORM.Common.Query.Where;

public class MySQLConnection extends Connection {
    private String connectionString;

    public MySQLConnection(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public void open() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public <T> Where<T> select() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> int insert(T obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <T> int update(T obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <T> int delete(T obj) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <T> List<T> executeQuery(String query) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> List<T> executeQueryWithoutRelationship(String query) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int executeNonQuery(String query) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
