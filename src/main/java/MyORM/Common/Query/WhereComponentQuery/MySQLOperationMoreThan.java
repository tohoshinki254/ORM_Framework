package MyORM.Common.Query.WhereComponentQuery;

public class MySQLOperationMoreThan implements MySQLWhereComponent{
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
