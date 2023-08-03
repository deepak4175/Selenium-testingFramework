package utility.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerSet {

    public static Logger log;

    public static void setLogger(Class classname){
        log=LogManager.getLogger(classname);
    }
}