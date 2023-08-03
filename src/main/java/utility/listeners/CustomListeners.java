package utility.listeners;

import baseManager.DriverManager;
import baseManager.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.Reporting.ExtentReporting;
import utility.utils.ScreenShot;
import java.io.IOException;
import java.lang.reflect.Method;



public class CustomListeners  implements ITestListener , WebDriverListener {

    ExtentReports extent =ExtentReporting.getReport();

    public CustomListeners() throws IOException {
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.setExtentTest(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getExtentTest().pass("test is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        try {
            ExtentManager.getExtentTest().fail("test failed",MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.takeScreenShot(result.getMethod().getMethodName(), DriverManager.getDriver())).build());
           } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void beforeAnyCall(Object target, Method method, Object[] args) {

    }

    @Override
    public void afterAnyCall(Object target, Method method, Object[] args, Object result) {

    }

    @Override
    public void beforeClick(WebElement element) {
        ExtentManager.getExtentTest().info("going to click on WebElement" +element);

    }

    @Override
    public void afterClick(WebElement element) {

    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        StringBuffer stringBuffer=new StringBuffer(keysToSend.toString());
        ExtentManager.getExtentTest().info("going to search WebElement : <b>"+element+"</b> and input value is <b>"+stringBuffer+"</b>");
    }


}
