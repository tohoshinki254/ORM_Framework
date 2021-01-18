package MyORM.MySQL;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.HashMap;

import MyORM.Annotations.Column;
import MyORM.Annotations.ManyToOne;
import MyORM.Annotations.PrimaryKey;

public class MySQLInsert extends MySQLQuery {

    public <T> MySQLInsert(Connection cnt, String connectionString, Class<T> entityClass, T obj) throws Exception {
        super(cnt, connectionString);

        MySQLMapper mySQLMapper = new MySQLMapper();

        String tableName = mySQLMapper.getTableName(entityClass);

        HashMap<String, Object> listColumnValues = mySQLMapper.getColumnValues(obj);

        StringBuilder columnStringbuilder = new StringBuilder("");
        StringBuilder valueStringBuilder = new StringBuilder("");

        Field[] fields = entityClass.getDeclaredFields();

        for (Field field : fields) {
            boolean isAutoID = false;
            Column column = field.getAnnotation(Column.class);
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
            ManyToOne foreignKey = field.getAnnotation(ManyToOne.class);

            if (primaryKey != null) {
                // * If primary key is autoID, no need to add the key + value
                if (primaryKey.autoId()) {
                    isAutoID = true;
                    continue;
                }
            }

            // * In each column (including primaryKey & foreignKey), add key (column name) and its value
            if (!isAutoID) {
                String name;
                if (primaryKey != null) {
                    name = primaryKey.name();
                } else if (column != null) {
                    name = column.name();
                } else if (foreignKey != null) {
                    name = foreignKey.columnName();
                } else {
                    continue;
                }

                columnStringbuilder.append(String.format("%s, ", name));
                valueStringBuilder.append(String.format("'%s', ", listColumnValues.get(name)));
            }
        }

        if (!columnStringbuilder.toString().equals("") && !valueStringBuilder.toString().equals("")) {
            // Remove the last 2 letters ", "
            String columnStr = columnStringbuilder.substring(0, columnStringbuilder.length() - 2);
            String valueStr = valueStringBuilder.substring(0, valueStringBuilder.length() - 2);

            query = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columnStr, valueStr);
        }
    }
}
