package MyORM.Common;

import java.util.List;

import MyORM.Common.Query.Where;

public abstract class Connection {
    protected String connectionString;

    public abstract void open();
    public abstract void close();
    public abstract Where<Object> select();
    public abstract int insert(Object obj);
    public abstract int update(Object obj);
    public abstract int delete(Object obj);
    public abstract List<Object> executeQuery(String query);
    public abstract List<Object> executeQueryWithoutRelationship(String query);
    public abstract int executeNonQuery(String query);
}
