package MyORM.Common.Query;

public interface Where<T> {
    HavingOrRun<T> where(String condition);
    HavingOrRun<T> all();
}
