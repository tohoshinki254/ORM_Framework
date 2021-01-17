package MyORM.FlexibleObject;

import java.util.HashMap;

public class FlexibleObject {
    private HashMap<String, Object> attrList = new HashMap<>();

    public void put(String name, Object obj) {
        attrList.put(name, obj);
    }

    public void putIfAbsent(String name, Object obj) {
        attrList.putIfAbsent(name, obj);
    }

    public Object get(String name) {
        return attrList.get(name);
    }



}
