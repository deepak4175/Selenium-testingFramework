package baseManager;

import java.util.Properties;

public class PropertiesManager {


    private static ThreadLocal<Properties> propertiesThreadLocal=new ThreadLocal<>();
    public static Properties getPropertyInstance(){
        return propertiesThreadLocal.get();
    }
    public static void setProperty(Properties property){
        propertiesThreadLocal.set(property);
    }


}
