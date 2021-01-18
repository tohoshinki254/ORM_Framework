package MyORM.Common.Query.WhereComponentQuery;

import MyORM.Common.Query.WhereComponent;

public class MySQLOperationOr implements WhereComponent {

    WhereComponent component1;
    WhereComponent component2;

    @Override
    public String getComponentString() {
        return "(" + component1.getComponentString() + " OR " + component2.getComponentString() + ")"; 
    }

    public MySQLOperationOr(WhereComponent component1, WhereComponent component2) {
        this.component1 = component1;
        this.component2 = component2;
    }
    
}
