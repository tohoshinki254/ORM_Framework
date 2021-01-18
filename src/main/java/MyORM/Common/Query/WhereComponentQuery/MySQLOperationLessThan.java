package MyORM.Common.Query.WhereComponentQuery;

import MyORM.Common.Query.WhereComponent;

public class MySQLOperationLessThan implements WhereComponent {
    String objName;
    Object obj;


    
    @Override
    public String getComponentString() {
        return objName + " < " + obj;
    }

    public MySQLOperationLessThan(String objName, Object obj) {
        this.objName = objName;
        this.obj = obj;
    }


}
