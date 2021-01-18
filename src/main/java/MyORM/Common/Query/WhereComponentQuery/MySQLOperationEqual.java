package MyORM.Common.Query.WhereComponentQuery;

import MyORM.Common.Query.WhereComponent;

public class MySQLOperationEqual implements WhereComponent {
    String objName;
    Object obj;
    
    @Override
    public String getComponentString() {
        return objName + " = " + obj.toString();
    }

    public MySQLOperationEqual(String objName, Object obj) {
        this.objName = objName;
        this.obj = obj;
    }
}
