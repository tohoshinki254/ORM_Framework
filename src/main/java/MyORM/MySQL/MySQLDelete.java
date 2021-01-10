package MyORM.MySQL;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import MyORM.Common.Mapper;

public class MySQLDelete<T> extends MySQLQuery{
    public <T> MySQLDelete(Connection cnn,String connectionString, Class<T> entityClass, T obj) throws Exception {
        super(cnn, connectionString);
        //Class<T> entityClass;
        MySQLMapper mapper = new MySQLMapper();
        String tableName = mapper.getTableName(entityClass);
        List<String> primaryKey = mapper.getPrimaryKey(entityClass);
        HashMap<String,Object> listColumnValue = mapper.getColumnValues(obj);
        StringBuilder whereStr = new StringBuilder("");
        for(String column:primaryKey)
        {
            {
                if(mapper.FindColumn(column, listColumnValue))
                {
                    String format = "%s = '%s', ";
                    whereStr.append(String.format(format, column, listColumnValue.get(column)));
                }
            }
        }
        String valueWhereStr = "";
        if(whereStr.length()!=0)
        {
            valueWhereStr = whereStr.substring(0, whereStr.length()-2);
            query = String.format("Delete From %s Where %s", tableName,valueWhereStr);
        }
    }
}