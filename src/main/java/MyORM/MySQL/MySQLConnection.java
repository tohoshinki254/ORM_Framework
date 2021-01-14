package MyORM.MySQL;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;

import MyORM.Common.Connection;
import MyORM.Common.Query.Where;

public class MySQLConnection extends Connection {
    java.sql.Connection cnt;

    public MySQLConnection(String strConnection) {
        connectionString = strConnection;
    }

    @Override
    public void open() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnt = DriverManager.getConnection(connectionString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> Where select(Class<T> entityClass) {
        return MySQLSelect.create(cnt, connectionString, entityClass);
    }

    @Override
    public <T> int insert(T obj, Class<T> entityClass) {
        try {
        MySQLInsert query = new MySQLInsert(cnt, connectionString, entityClass, obj);
        return query.executeNonQuery(entityClass);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public <T> int update(HashMap<String, Object> prototype, Class<T> entityClass, String whereQuery) throws Exception {
        MySQLUpdate myUpdate = new MySQLUpdate(cnt, connectionString, entityClass, prototype, whereQuery);
        return myUpdate.executeNonQuery(entityClass);
    }

    @Override
    public <T> int delete(Class<T> entityClass, String whereQuery){
        try{
            MySQLDelete myDelete = new MySQLDelete(cnt, connectionString, entityClass, whereQuery);
            return myDelete.executeNonQuery(entityClass);
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public <T> List<T> executeQuery(String strQuery, Class<T> entityClass) {
        MySQLQuery query = new MySQLQuery(cnt, connectionString, strQuery);
        return query.executeQuery(entityClass);
    }

    @Override
    public <T> List<T> executeQueryWithoutRelationship(String strQuery, Class<T> entityClass) {
        MySQLQuery query = new MySQLQuery(cnt, connectionString, strQuery);
        return query.executeQueryWithoutRelationship(entityClass);
    }

    @Override
    public <T> int executeNonQuery(String strQuery, Class<T> entityClass) {
        MySQLQuery query = new MySQLQuery(cnt, connectionString, strQuery);
        return query.executeNonQuery(entityClass);
    }
}
