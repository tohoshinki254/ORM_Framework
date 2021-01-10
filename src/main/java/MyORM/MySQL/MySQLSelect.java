package MyORM.MySQL;

import java.util.List;

import MyORM.Common.Query.GroupBy;
import MyORM.Common.Query.HavingOrRun;
import MyORM.Common.Query.Run;
import MyORM.Common.Query.Where;

public class MySQLSelect extends MySQLQuery implements Where, HavingOrRun, GroupBy, Run {
    private <T> MySQLSelect(java.sql.Connection cnt, String connectionString, Class<T> entityClass) {
        super(cnt, connectionString);
        MySQLMapper mapper = new MySQLMapper();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT");
        for (String column : mapper.GetColumns(entityClass)) {
            sb.append(String.format(" %s,", column));
        }
        sb.substring(0, sb.length() - 1);
        sb.append(String.format(" FROM %s", mapper.getTableName(entityClass)));
        query = sb.toString();
    }

    public static <T> Where create(java.sql.Connection cnt, String connectionString, Class<T> entityClass) {
        return new MySQLSelect(cnt, connectionString, entityClass);
    }

    @Override
    public <T> GroupBy having(String condition) {
        query = String.format("%s HAVING %s", query, condition);
        return this;
    }

    @Override
    public <T> List<T> run(Class<T> entityClass) {
        return executeQuery(entityClass);
    }

    @Override
    public <T> HavingOrRun where(String condition) {
        query = String.format("%s WHERE %s", query, condition);
        return this;
    }

    @Override
    public <T> HavingOrRun all() {
        return this;
    }

    @Override
    public <T> Run groupBy(String columnName) {
        query = String.format("%s GROUP BY %s", query, columnName);
        return this;
    }
}
