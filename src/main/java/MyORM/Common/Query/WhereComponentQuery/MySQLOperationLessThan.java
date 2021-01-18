package MyORM.Common.Query.WhereComponentQuery;

public class MySQLOperationLessThan implements MySQLWhereComponent {
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
