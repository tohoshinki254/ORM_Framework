package MyORM.MySQL;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import MyORM.Annotations.Column;
import MyORM.Annotations.ManyToOne;
import MyORM.Annotations.PrimaryKey;

public class MySQLUpdate extends MySQLQuery {
    public <T> MySQLUpdate(Connection cnn, String connectionString, Class<T> entityClass,
            HashMap<String, Object> listColumnValue, String whereQuery) throws Exception {
        super(cnn, connectionString);
        MySQLMapper mapper = new MySQLMapper();
        String tableName = mapper.getTableName(entityClass);

        String format = "%s = '%s', ";

        if (listColumnValue != null) {
            StringBuilder setStr = new StringBuilder("");
            Field[] fields = entityClass.getDeclaredFields();

            for (Field field : fields) {
                PrimaryKey primaryKeyAnno = field.getAnnotation(PrimaryKey.class);
                ManyToOne manyToOneAnno = field.getAnnotation(ManyToOne.class);
                Column columnAnno = field.getAnnotation(Column.class);

                if (primaryKeyAnno != null) {
                    String name = primaryKeyAnno.name();
                    if (listColumnValue.containsKey(name)) {
                        setStr.append(String.format(format, name, listColumnValue.get(name)));
                    }
                } 
                else if (columnAnno != null) {
                    String name = columnAnno.name();
                    if (listColumnValue.containsKey(name)) {
                        setStr.append(String.format(format, name, listColumnValue.get(name)));
                    }
                } 
                else if (manyToOneAnno != null) {
                    String columnName = manyToOneAnno.columnName();
                    String refColumn = manyToOneAnno.refColumn();
                    if (!listColumnValue.containsKey(columnName)) {
                        continue;
                    }

                    Object foreignKeyObj = listColumnValue.get(columnName);
                    Class foreignKeyClass = foreignKeyObj.getClass();
                    Field[] foreignKeyFields = foreignKeyClass.getDeclaredFields();

                    HashMap<String, Object> foreignColumnValues = mapper.getColumnValues(foreignKeyObj);

                    // * Get the primary key of the foreign object
                    for (Field field2 : foreignKeyFields) {
                        PrimaryKey primaryKey1 = field2.getAnnotation(PrimaryKey.class);
                        if (primaryKey1 != null) {
                            String name = primaryKey1.name();
                            if (refColumn.equals(name)) {
                                setStr.append(String.format(format, columnName, foreignColumnValues.get(name)));
                            }
                        }
                    }
                }
            }

            String valueSetStr = "";
            if (setStr.length() != 0) {
                valueSetStr = setStr.substring(0, setStr.length() - 2);
            }

            if (whereQuery != null && !whereQuery.equals("")) {
                query = String.format("Update %s Set %s Where %s", tableName, valueSetStr, whereQuery);
            } else {
                query = String.format("Update %s Set %s", tableName, valueSetStr);
            }
        }
    }
}