package MyORM.Common.Query.WhereComponentQuery;

public class MySQLOperationMoreThan implements MySQLWhereComponent{
    String objName;
    Double number;

    @Override
    public String getComponentString() {
        return objName + " > " + number;
    }
    
}
