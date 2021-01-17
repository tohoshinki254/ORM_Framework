package MyORM.Common.Query.WhereComponentQuery;

public class MySQLOperationOr implements MySQLWhereComponent{

    MySQLWhereComponent component1;
    MySQLWhereComponent component2;

    @Override
    public String getComponentString() {
        return "(" + component1.getComponentString() + " OR " + component2.getComponentString() + ")"; 

    }
    
}
