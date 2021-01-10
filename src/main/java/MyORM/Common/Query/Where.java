package MyORM.Common.Query;

public interface Where {
    <T> HavingOrRun where(String condition);
    <T> HavingOrRun all();
}
