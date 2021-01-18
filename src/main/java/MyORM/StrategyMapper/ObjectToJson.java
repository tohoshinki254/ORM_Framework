package MyORM.StrategyMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJson<T> implements StrategyMapper<T> {
    @Override
    public String convertString(T obj) {
        try {
            ObjectMapper object = new ObjectMapper();
            String jsonStr = object.writeValueAsString(obj);
            return jsonStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
