package MyORM.Common.Query;

import java.util.*;

public interface GroupByOrRun {
    <T> HavingOrRun groupBy(String columnName);
    <T> List<T> run(Class<T> entityClass);
}
