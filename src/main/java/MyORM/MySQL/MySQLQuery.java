package MyORM.MySQL;

import java.util.*;
import java.sql.Statement;

import MyORM.Common.Query.Query;

public class MySQLQuery implements Query {
    protected String connectionString;
    protected Statement statement;
    protected String query;

    public <T> MySQLQuery(MySQLConnection cnt, String connectionString, Class<T> entityClass) {
        this.connectionString = connectionString;
    }

    public <T> MySQLQuery(MySQLConnection cnt, String connectionString, String query, Class<T> entityClass) {
        this.connectionString = connectionString;
        this.query = query;
    }

    public <T> List<T> executeQuery(Class<T> entityClass) {
        return null;
    }

    @Override
    public <T> List<T> executeQueryWithoutRelationship(Class<T> entityClass) {
        return null;
    }

    @Override
    public <T> int executeNonQuery(Class<T> entityClass) {
        return 0;
    }
}   
