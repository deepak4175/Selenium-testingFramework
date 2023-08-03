package baseTest;

import baseManager.DriverManager;
import baseManager.ExtentManager;
import baseManager.PropertiesManager;
import constant.ProjectConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import utility.listeners.CustomListeners;
import utility.utils.ConfigDetails;
import utility.utils.DriverSetUp;
import utility.utils.LoggerSet;

import java.io.IOException;
import java.util.Properties;


public class BaseTest {
public WebDriver driver;
WebDriver eventDriver;



    @BeforeTest
    void setup() throws IOException {
        LoggerSet.setLogger(BaseTest.class);
        LoggerSet.log.info("************************************TEST case start suite*********************************");
        setProperty();
        driver=DriverSetUp.setDriver();


       WebDriverListener webDriverListener=new CustomListeners();
       eventDriver=new EventFiringDecorator(webDriverListener).decorate(driver);
       DriverManager.setDriver(eventDriver);
       DriverManager.getDriver().get(ProjectConstant.BASEURL);
    }

    @AfterSuite
    void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

   public  WebDriver getDriver(){
        return DriverManager.getDriver();
    }

    public Properties getProjectConfig(){
        return PropertiesManager.getPropertyInstance();
    }

    void setProperty() throws IOException {
        PropertiesManager.setProperty(ConfigDetails.getInstance());
    }

    public  void assertTrue(String actual, String expected, String info){

        ExtentManager.getExtentTest().info("Actual value : <b>"+actual+" </b> "+"Expected Value : <b>"+expected+" </b> "+info);
        Assert.assertEquals(actual,expected,info);
    }

    public  void assertTrue(Boolean actual, Boolean expected, String info){

        ExtentManager.getExtentTest().info("Actual value : <b>"+actual+" </b> "+"Expected Value : <b>"+expected+" </b> "+info);
        Assert.assertEquals(actual,expected,info);
    }

}
