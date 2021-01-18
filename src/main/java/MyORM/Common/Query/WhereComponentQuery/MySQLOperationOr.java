package MyORM.Common.Query.WhereComponentQuery;

public class MySQLOperationOr implements MySQLWhereComponent{

    MySQLWhereComponent component1;
    MySQLWhereComponent component2;


    

    @Override
    public String getComponentString() {
        return "(" + component1.getComponentString() + " OR " + component2.getComponentString() + ")"; 

    }

    public MySQLOperationOr(MySQLWhereComponent component1, MySQLWhereComponent component2) {
        this.component1 = component1;
        this.component2 = component2;
    }
    
}
