package MyORM.Common.Query.WhereComponentQuery;

import MyORM.Common.Query.WhereOperation;

public class MySQLWhereOperation implements WhereOperation {

    @Override
    public MySQLWhereComponent and(MySQLWhereComponent component1, MySQLWhereComponent component2) {
        return new MySQLOperationAnd(component1, component2);
    }

    @Override
    public MySQLWhereComponent or(MySQLWhereComponent component1, MySQLWhereComponent component2) {
        return new MySQLOperationOr(component1, component2);
    }

    @Override
    public MySQLWhereComponent moreThan(String objName, Object value) {
    
        return new MySQLOperationMoreThan(objName, value);
    }

    @Override
    public MySQLWhereComponent lessThan(String objName, Object value) {
        return new MySQLOperationLessThan(objName, value);
    }

    @Override
    public MySQLWhereComponent equalsTo(String objName, Object value) {

        return new MySQLOperationEqual(objName, value);
    }
    
}
