package MyORM.Common.Query.WhereComponentQuery;

public class MySQLOperationAnd implements MySQLWhereComponent {

    MySQLWhereComponent component1;
    MySQLWhereComponent component2;


    @Override
    public String getComponentString() {
        return "(" + component1.getComponentString() + " AND " + component2.getComponentString() + ")"; 
    }
    
}
