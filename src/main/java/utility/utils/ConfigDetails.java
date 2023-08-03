package utility.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigDetails {

    static private Properties projectConfig;
    static private Properties setConfig() throws IOException {
        projectConfig=new Properties();
        String env=System.getProperty("ENV");
        if(env==null || env.equals(""))
        {
            projectConfig.load(new FileReader(System.getProperty("user.dir")+"/src/main/resources/properties/ProjectConfigQA.properties"));

        }
        else {
            projectConfig.load(new FileReader(System.getProperty("user.dir") + "/src/main/resources/properties/ProjectConfig"+env+".properties"));

        }
        return projectConfig;
    }
     static public Properties getInstance() throws IOException {
        if(projectConfig==null){
            projectConfig=setConfig();
        }
        return projectConfig;
     }
}
