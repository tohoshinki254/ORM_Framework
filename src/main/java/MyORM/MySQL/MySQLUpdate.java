package MyORM.MySQL;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public class MySQLUpdate extends MySQLQuery{
    public <T> MySQLUpdate(Connection cnn,String connectionString, Class<T> entityClass, T obj) throws Exception {
        super(cnn, connectionString);
        MySQLMapper mapper = new MySQLMapper();
        String tableName = mapper.getTableName(entityClass);
        
        List<String> primaryKey = mapper.getPrimaryKey(entityClass);
        HashMap<String,Object> listColumnValue = mapper.getColumnValues(obj);
        if(primaryKey != null && listColumnValue != null)
        {
            
            StringBuilder whereStr = new StringBuilder("");;
            StringBuilder setStr = new StringBuilder("");
            for (String column : listColumnValue.keySet()) {
                String format = "%s = '%s', ";
                setStr.append(String.format(format, column, listColumnValue.get(column)));
            }
            String valueSetStr = "";
            if(setStr.length()!=0)
            {
                valueSetStr = setStr.substring(0, setStr.length()-2);
            }
            String valueWhereStr = "";
            for(String column:primaryKey)
            {
                if(mapper.FindColumn(column, listColumnValue))
                {
                    String format = "%s = '%s', ";
                    whereStr.append(String.format(format, column, listColumnValue.get(column)));
                }
            }
            if(whereStr.length()!=0)
            {
                valueWhereStr = whereStr.substring(0, whereStr.length()-2);
                query = String.format("Update %s Set %s Where %s", tableName,valueSetStr,valueWhereStr);
            }
        }
    }
}