package MyORM.Common;

import java.util.HashMap;
import java.util.List;

import MyORM.Common.Query.Where;

public abstract class Connection {
    protected String connectionString;

    public abstract void open();
    public abstract void close();
    public abstract <T> Where select(Class<T> entityClass);
    public abstract <T> int insert(T obj, Class<T> entityClass) throws Exception;
    public abstract <T> int update(HashMap<String, Object> prototype, Class<T> entityClass, String whereQuery) throws Exception;
    public abstract <T> int delete(Class<T> entityClass, String whereQuery) throws Exception;
    public abstract <T> List<T> executeQuery(String strQuery, Class<T> entityClass);
    public abstract <T> List<T> executeQueryWithoutRelationship(String strQuery, Class<T> entityClass);
    public abstract <T> int executeNonQuery(String strQuery, Class<T> entityClass);
}
