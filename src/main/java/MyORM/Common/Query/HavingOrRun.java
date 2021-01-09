package MyORM.Common.Query;

import java.util.*;

public interface HavingOrRun<T> {
    GroupBy<T> having(String condition);
    List<T> run();
}
