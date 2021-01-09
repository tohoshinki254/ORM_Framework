package MyORM.Common.Query;

import java.util.*;

public interface Query<T> {
    List<T> executeQuery();
    List<T> executeQueryWithoutRelationship();
    int executeNonQuery();
}