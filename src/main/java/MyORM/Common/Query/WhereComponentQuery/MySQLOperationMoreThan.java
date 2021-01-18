package MyORM.Common.Query.WhereComponentQuery;

import MyORM.Common.Query.WhereComponent;

public class MySQLOperationMoreThan implements WhereComponent {
    String objName;
    Object obj;

    @Override
    public String getComponentString() {
        return objName + " > " + obj.toString();
    }

    public MySQLOperationMoreThan(String objName, Object obj) {
        this.objName = objName;
        this.obj = obj;
    }

    
    
}
