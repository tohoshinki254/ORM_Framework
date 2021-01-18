package MyORM.MySQL;

import java.sql.Connection;

public class MySQLDelete extends MySQLQuery {
    public <T> MySQLDelete(Connection cnn, String connectionString, Class<T> entityClass, String whereQuery) throws Exception {
        super(cnn, connectionString);
        // Class<T> entityClass;
        MySQLMapper mapper = new MySQLMapper();
        String tableName = mapper.getTableName(entityClass);
    
        if (whereQuery != null && whereQuery.equals("") == false) {
            query = String.format("Delete From %s Where %s", tableName, whereQuery);
        }
        else {
            query = String.format("Delete From %s", tableName);
        }
    }
}