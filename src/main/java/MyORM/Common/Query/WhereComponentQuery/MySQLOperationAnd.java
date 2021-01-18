package MyORM.Common.Query.WhereComponentQuery;

import MyORM.Common.Query.WhereComponent;

public class MySQLOperationAnd implements WhereComponent {

    WhereComponent component1;
    WhereComponent component2;

	@Override
    public String getComponentString() {
        return "(" + component1.getComponentString() + " AND " + component2.getComponentString() + ")"; 
    }

    public MySQLOperationAnd(WhereComponent component1, WhereComponent component2) {
        this.component1 = component1;
        this.component2 = component2;
    }
}
