package MyORM.Common.Query;

public interface GroupBy {
    <T> Run groupBy(String columnName);
}
