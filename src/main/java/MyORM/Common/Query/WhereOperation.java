package MyORM.Common.Query;

import MyORM.Common.Query.WhereComponentQuery.MySQLWhereComponent;

public interface WhereOperation {
    MySQLWhereComponent and(MySQLWhereComponent component1, MySQLWhereComponent component2);
    MySQLWhereComponent or(MySQLWhereComponent component1, MySQLWhereComponent component2);
    MySQLWhereComponent moreThan(String objName, Object value);
    MySQLWhereComponent lessThan(String objName, Object value);
    MySQLWhereComponent equalsTo(String objName, Object value);
}
