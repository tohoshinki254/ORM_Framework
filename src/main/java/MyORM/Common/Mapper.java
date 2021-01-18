package MyORM.Common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import MyORM.Annotations.Column;
import MyORM.Annotations.ManyToOne;
import MyORM.Annotations.PrimaryKey;
import MyORM.Annotations.Table;
import MyORM.Exceptions.MapDataException;

public abstract class Mapper {
    public <T> T mapWithoutRelationship(ResultSet rs, Class<T> entityClass) {
        try {
            T object = entityClass.getDeclaredConstructor().newInstance();
            Field[] fields = entityClass.getDeclaredFields();

            for (Field field : fields) {
                Column column = field.getAnnotation(Column.class);
                PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);

                if (column != null) {
                    field.setAccessible(true);
                    field.set(object, rs.getObject(column.name()));
                }

                if (primaryKey != null) {
                    field.setAccessible(true);
                    field.set(object, rs.getObject(primaryKey.name()));
                }
            }

            return object;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MapDataException(e.getMessage());
        }
    }

    public <T> T mapWithRelationship(Connection con, ResultSet rs, Class<T> entityClass) {

        // Map all column annotation
        T obj = mapWithoutRelationship(rs, entityClass);
        mapManyToOne(con, rs, obj);
        mapOneToMany(con, rs, obj);
        return obj;
    }

    protected abstract <T> void mapOneToMany(Connection con, ResultSet rs, T obj);

    protected abstract <T> void mapManyToOne(Connection con, ResultSet rs, T obj);

    public <T> String getTableName(Class<T> entityClass) {
        try {
            Table anno = entityClass.getAnnotation(Table.class);
            if (anno != null) {
                String className = anno.name();
                return className;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public <T> HashMap<String, Object> getColumnValues(T obj) throws Exception {
        HashMap<String, Object> listColumnValues = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] attributes = field.getAnnotations();
            for (Annotation annotation : attributes) {
                if (annotation.annotationType() == Column.class || annotation.annotationType() == PrimaryKey.class) {
                    if (annotation.annotationType() == Column.class) {
                        listColumnValues.put(field.getAnnotation(Column.class).name(), field.get(obj));
                    } else {
                        listColumnValues.put(field.getAnnotation(PrimaryKey.class).name(), field.get(obj));
                    }
                }

                if (annotation.annotationType() == ManyToOne.class) {
                    Object foreignKeyObj = field.get(obj);
                    Field[] foreignKeyObjFields = foreignKeyObj.getClass().getDeclaredFields();

                    // List through all foreign key column, get primary key name
                    // Then add the column values if they have the same name
                    for (Field foreignKeyField : foreignKeyObjFields) {
                        PrimaryKey primaryKey = foreignKeyField.getAnnotation(PrimaryKey.class);
                        if (primaryKey != null) {
                            String refColumn = ((ManyToOne) annotation).refColumn();
                            if (primaryKey.name().equals(refColumn)) {
                                listColumnValues.put(field.getAnnotation(ManyToOne.class).columnName(),
                                        foreignKeyField.get(foreignKeyObj));
                            }
                        }
                    }
                }
            }
        }

        if (listColumnValues.size() > 0) {
            return listColumnValues;
        }
        return null;
    }

    public <T> List<String> getPrimaryKey(Class<T> entityClass) {
        List<String> primaryKey = new ArrayList<>();

        Field[] attributes = entityClass.getDeclaredFields();
        for (Field attribute : attributes) {
            Annotation[] annotations = attribute.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == PrimaryKey.class) {
                    primaryKey.add(attribute.getName());
                    break;
                }
            }
        }

        return primaryKey;
    }

    public <T> List<String> GetColumns(Class<T> entityClass) {
        List<String> listColumn = new ArrayList<String>();
        Field[] fields = entityClass.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] attributes = field.getAnnotations();
            for (Annotation annotation : attributes) {
                if (annotation.annotationType() == Column.class) {
                    listColumn.add(field.getAnnotation(Column.class).name());
                } else if (annotation.annotationType() == PrimaryKey.class) {
                    listColumn.add(field.getAnnotation(PrimaryKey.class).name());
                } else if (annotation.annotationType() == ManyToOne.class) {
                    listColumn.add(field.getAnnotation(ManyToOne.class).columnName());
                }
            }
        }
        return listColumn;
    }

    public boolean FindColumn(String name, HashMap<String, Object> listColumnValue) {
        return listColumnValue.containsKey(name);
    }

    public <T> HashMap<String, String> getAttributeMappingToTableColumn(Class<T> entityClass) {
        HashMap<String, String> result = new HashMap<>();
        Field[] fields = entityClass.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] attributes = field.getAnnotations();
            for (Annotation annotation : attributes) {
                if (annotation.annotationType() == Column.class || annotation.annotationType() == PrimaryKey.class) {
                    if (annotation.annotationType() == Column.class) {
                        result.put(field.getName(), field.getAnnotation(Column.class).name());
                    } else {
                        result.put(field.getName(), field.getAnnotation(PrimaryKey.class).name());
                    }
                }
                else if (annotation.annotationType() == ManyToOne.class) {
                    result.put(field.getName(), field.getAnnotation(ManyToOne.class).columnName());
                }
            }
        }
        return result;
    }
}
