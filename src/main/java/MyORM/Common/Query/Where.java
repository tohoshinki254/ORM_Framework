package MyORM.Common.Query;

public interface Where {
    <T> GroupByOrRun where(String condition);
    <T> GroupByOrRun all();
}
