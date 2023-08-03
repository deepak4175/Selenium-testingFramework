package utility.utils;

import baseManager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    public static String takeScreenShot(String methodName, WebDriver driver) throws IOException {
        TakesScreenshot getScreenshot= (TakesScreenshot) driver;
        File fileSrc=getScreenshot.getScreenshotAs(OutputType.FILE);
        File targetFile= new File(System.getProperty("user.dir")+"/src/test/reports/screenshot/"+methodName+ DateUtils.getCurrentDate()+".png");
        FileUtils.copyFile(fileSrc,targetFile);
        return targetFile.getAbsolutePath();
    }


}
