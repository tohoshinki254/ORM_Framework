package MyORM.MySQL;

import java.util.List;

import MyORM.Common.Query.GroupBy;
import MyORM.Common.Query.HavingOrRun;
import MyORM.Common.Query.Run;
import MyORM.Common.Query.Where;

public class MySQLSelect<T> extends MySQLQuery implements Where<T>, HavingOrRun<T>, GroupBy<T>, Run<T> {
    public MySQLSelect(MySQLConnection cnt, String connectionString, Class<T> entityClass) {
        super(cnt, connectionString, entityClass);
    }

    public MySQLSelect(MySQLConnection cnt, String connectionString, String query, Class<T> entityClass) {
        super(cnt, connectionString, query, entityClass);
    }

    @Override
    public Run<T> groupBy(String columnName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GroupBy<T> having(String condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> run() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HavingOrRun<T> where(String condition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HavingOrRun<T> all() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
