package utility.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;

public class DriverSetUp {

    public static WebDriver setDriver() throws IOException {
        WebDriver driver;
        String browserName= ConfigDetails.getInstance().getProperty("browser");
        switch (browserName){
            case "chrome" :     ChromeOptions chromeOptions = new ChromeOptions();
                                //chromeOptions.addArguments("--remote-allow-origins=*");
                                chromeOptions.setBinary(System.getProperty("user.dir")+"/src/main/resources/driver/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing");
                                System.setProperty("webDriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/driver/chromedriver");
                                driver =new ChromeDriver(chromeOptions);
                                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            case "firefox" :driver=WebDriverManager.firefoxdriver().create();
                break;
            case "edge" : driver=WebDriverManager.edgedriver().create();
                break;

            default: driver=WebDriverManager.chromedriver().create();
                break;
        }
        return driver;
    }
}
