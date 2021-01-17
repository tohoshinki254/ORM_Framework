package MyORM.Common.Query.WhereComponentQuery;

public class MySQLOperationLessThan implements MySQLWhereComponent {
    String objName;
    Double number;

    @Override
    public String getComponentString() {
        return objName + " < " + number;
    }


}
