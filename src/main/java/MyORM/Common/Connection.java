package MyORM.Common;

import java.util.List;

import MyORM.Common.Query.Where;

public abstract class Connection {
    protected String connectionString;

    public abstract void open();
    public abstract void close();
    public abstract <T> Where select(Class<T> entityClass);
    public abstract <T> int insert(T obj);
    public abstract <T> int update(T obj);
    public abstract <T> int delete(T obj);
    public abstract <T> List<T> executeQuery(String strQuery, Class<T> entityClass);
    public abstract <T> List<T> executeQueryWithoutRelationship(String strQuery, Class<T> entityClass);
    public abstract <T> int executeNonQuery(String strQuery, Class<T> entityClass);
}
