package baseManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseClass {
    WebDriver driver;
    WebDriverWait wait;

    Actions actions;
    JavascriptExecutor jsExecutor;

    public BaseClass(WebDriver driver,int waitTime){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        actions=new Actions(driver);
        jsExecutor=(JavascriptExecutor) driver;
    }

    WebElement waitStrategy(String waitType, By element){
        WebElement waitCompleted;
        switch (waitType) {
            case "VISIBLE" :  waitCompleted=wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
                              break;

            case "CLICKABE" : waitCompleted=wait.until(ExpectedConditions.elementToBeClickable(element));
                                break;

            case "PRESNCEOFELEMENTLOCATED" : waitCompleted=wait.until((ExpectedConditions.presenceOfElementLocated(element)));
                                    break;

            default:       waitCompleted= driver.findElement(element);
                            break;
        }
        return waitCompleted;
    }








}
