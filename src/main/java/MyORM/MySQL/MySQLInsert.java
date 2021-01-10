package MyORM.MySQL;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import MyORM.Annotations.PrimaryKey;

public class MySQLInsert<T> extends MySQLQuery {

    public <T> MySQLInsert(Connection cnt, String connectionString, Class<T> entityClass) throws Exception {
        super(cnt, connectionString);

        MySQLMapper mySQLMapper = new MySQLMapper();

        String tableName = mySQLMapper.getTableName(entityClass);
        ArrayList<PrimaryKey> primaryKeys = new ArrayList<>();
        HashMap<String, Object> listColumnValues = new HashMap<>();

        StringBuilder columnStringbuilder = new StringBuilder("");
        StringBuilder valueStringBuilder = new StringBuilder("");

        for (String column : listColumnValues.keySet()) {
            boolean isAutoID = false;

            // Check primary key --> if true & id is auto --> no need to add key-value
            for (PrimaryKey primaryKey : primaryKeys) {
                if (column == primaryKey.name() && primaryKey.autoId()) {
                    isAutoID = true;
                    break;
                }
            }

            if (!isAutoID) {
                columnStringbuilder.append(String.format("%s, ", column));
                valueStringBuilder.append(String.format("%s, ", listColumnValues.get(column)));
            }
        }

        if (!columnStringbuilder.toString().equals("") && valueStringBuilder.toString().equals("")) {
            // Remove the last 2 letters ", "
            columnStringbuilder.substring(0, columnStringbuilder.length() - 2);
            valueStringBuilder.substring(0, valueStringBuilder.length() - 2);

            query = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columnStringbuilder.toString(), valueStringBuilder.toString());
        }
    }
}
