package MyORM.Common.Query;



public interface WhereOperation {
    WhereComponent and(WhereComponent component1, WhereComponent component2);
    WhereComponent or(WhereComponent component1, WhereComponent component2);
    WhereComponent moreThan(String objName, Object value);
    WhereComponent lessThan(String objName, Object value);
    WhereComponent equalsTo(String objName, Object value);
}
