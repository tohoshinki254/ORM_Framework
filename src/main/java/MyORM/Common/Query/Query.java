package MyORM.Common.Query;

import java.util.*;

public interface Query {
    <T> List<T> executeQuery(Class<T> entityClass);
    <T> List<T> executeQueryWithoutRelationship(Class<T> entityClass);
    <T> int executeNonQuery(Class<T> entityClass);
}