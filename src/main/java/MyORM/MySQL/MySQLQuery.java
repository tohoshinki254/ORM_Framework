package MyORM.MySQL;

import java.util.*;
import java.sql.Statement;

import MyORM.Common.Query.Query;

public class MySQLQuery<T> implements Query {
    protected String connectionString;
    protected Statement statement;
    protected String query;
    protected Class<T> entityClass;

    public MySQLQuery(MySQLConnection cnt, String connectionString, Class<T> entityClass) {
        this.connectionString = connectionString;
        this.entityClass = entityClass;
    }

    public MySQLQuery(MySQLConnection cnt, String connectionString, String query, Class<T> entityClass) {
        this.connectionString = connectionString;
        this.query = query;
        this.entityClass = entityClass;
    }

    public List<T> executeQuery() {
        return null;
    }

    @Override
    public List<T> executeQueryWithoutRelationship() {
        return null;
    }

    @Override
    public int executeNonQuery() {
        return 0;
    }
}   
