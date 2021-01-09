package MyORM.Sample;

import java.sql.Connection;
import java.util.HashMap;

import MyORM.Annotations.PrimaryKey;
import MyORM.MySQL.MySQLQuery;

public class SQLInsert<T> extends MySQLQuery {
    public SQLInsert(Connection connection, String connectionString, T object) {
        super(connection, connectionString);

        SqlMapper<T> mapper = new SqlMapper<>();
        String tableName = mapper.getTableName<T>();  

        ArrayList<PrimaryKey> primaryKeys = mapper.getPrimaryKeys<T>();
        HashMap<String, Object> listColumnValues = mapper.getColumnValues<T>(object);
        if (listColumnValues.size() >= 0) {
            
            for(String columnName: listColumnValues.keySet()) {
               
            }
        }

    }

    
}
