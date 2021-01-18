package MyORM.StrategyMapper;

import com.fasterxml.jackson.dataformat.xml.*;

public class ObjectToXml<T> implements StrategyMapper<T> {
    @Override
    public String convertString(T obj) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xmlStr = xmlMapper.writeValueAsString(obj);
            return xmlStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
