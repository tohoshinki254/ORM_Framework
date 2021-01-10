package MyORM.MySQL;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MyORM.Common.Query.Query;

public class MySQLQuery implements Query {
    protected String connectString;
    protected String query;
    protected java.sql.Connection cnt;

    public <T> MySQLQuery(java.sql.Connection cnt, String connectionString) {
        this.cnt = cnt;
        this.connectString = connectionString;
    }

    public <T> MySQLQuery(java.sql.Connection cnt, String connectionString, String query) {
        this.query = query;
        this.connectString = connectionString;
        this.cnt = cnt;
    }

    public <T> List<T> executeQuery(Class<T> entityClass) {
        List<T> res = new ArrayList<T>();
        try {
            MySQLMapper mapper = new MySQLMapper();
            MySQLConnection con = new MySQLConnection(connectString);
            Statement statement = cnt.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                res.add(mapper.mapWithRelationship(con, rs, entityClass));
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public <T> List<T> executeQueryWithoutRelationship(Class<T> entityClass) {
        List<T> res = new ArrayList<T>();
        try {
            MySQLMapper mapper = new MySQLMapper();
            Statement statement = cnt.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                res.add(mapper.mapWithoutRelationship(rs, entityClass));
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public <T> int executeNonQuery(Class<T> entityClass) {
        try {
            Statement statement = cnt.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}   
