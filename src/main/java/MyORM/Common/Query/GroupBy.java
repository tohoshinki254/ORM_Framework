package MyORM.Common.Query;

public interface GroupBy<T> {
    Run<T> groupBy(String columnName);
}
