package MyORM.MySQL;

import java.util.List;

import MyORM.Common.Query.GroupByOrRun;
import MyORM.Common.Query.HavingOrRun;
import MyORM.Common.Query.Run;
import MyORM.Common.Query.Where;

public class MySQLSelect extends MySQLQuery implements Where, Run, GroupByOrRun, HavingOrRun {
    private static MySQLSelect instance = null;
    private static Class<?> mEntityClass = null;
    private <T> MySQLSelect(java.sql.Connection cnt, String connectionString, Class<T> entityClass) {
        super(cnt, connectionString);
        MySQLMapper mapper = new MySQLMapper();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(String.format(" * FROM %s", mapper.getTableName(entityClass)));
        query = sb.toString();
    }

    public static <T> Where create(java.sql.Connection cnt, String connectionString, Class<T> entityClass) {
        if(instance == null || mEntityClass != entityClass)
        {
            instance = new MySQLSelect(cnt, connectionString, entityClass);
            mEntityClass = entityClass;
        }

        return instance;
    }

    @Override
    public <T> GroupByOrRun where(String condition) {
        if (!condition.equals("")) {
            query = String.format("%s WHERE %s", query, condition);
        }
        return this;
    }

    @Override
    public <T> HavingOrRun groupBy(String columnName) {
        query = String.format("%s GROUP BY %s", query, columnName);
        return this;
    }

    @Override
    public <T> Run having(String condition) {
        if (!condition.equals("")) {
            query = String.format("%s HAVING %s", query, condition);
        }
        return this;
    }

    @Override
    public <T> List<T> run(Class<T> entityClass) {
        return executeQuery(entityClass);
    }

    @Override
    public <T> GroupByOrRun all() {
        return this;
    }

    
}
