package MyORM.Common.Query.WhereComponentQuery;

import MyORM.Common.Query.WhereComponent;
import MyORM.Common.Query.WhereOperation;

public class MySQLWhereOperation implements WhereOperation {
    @Override
    public WhereComponent moreThan(String objName, Object value) {
        return new MySQLOperationMoreThan(objName, value);
    }

    @Override
    public WhereComponent lessThan(String objName, Object value) {
        return new MySQLOperationLessThan(objName, value);
    }

    @Override
    public WhereComponent equalsTo(String objName, Object value) {
        return new MySQLOperationEqual(objName, value);
    }

    @Override
    public WhereComponent and(WhereComponent component1, WhereComponent component2) {
        return new MySQLOperationAnd(component1, component2);
    }

    @Override
    public WhereComponent or(WhereComponent component1, WhereComponent component2) {
        return new MySQLOperationOr(component1, component2);
    }
}
