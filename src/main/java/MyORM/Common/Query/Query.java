package MyORM.Common.Query;

import java.util.*;

public interface Query<T> {
    List<T> ExecuteQuery();
    List<T> ExecuteQueryWithoutRelationship();
    int ExecuteNonQuery();
}