package utility.Reporting;

import baseManager.PropertiesManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utility.utils.ConfigDetails;
import utility.utils.DateUtils;

import java.io.IOException;

public class ExtentReporting {


    public static ExtentReports getReport() throws IOException {
        ExtentSparkReporter reporter;
        String reportLocation= ConfigDetails.getInstance().getProperty("reportPath");
        if(reportLocation==null ||reportLocation.equals("")){
            reportLocation=System.getProperty("user.dir")+"src/test/reports";
        }
        else {
          reportLocation=System.getProperty("user.dir")+reportLocation;
        }
        String Finalpath=reportLocation+"_"+ DateUtils.getCurrentDate()+".html";
        reporter=new ExtentSparkReporter(reportLocation+"/"+ DateUtils.getCurrentDate()+".html");
        String reportName=ConfigDetails.getInstance().getProperty("reportName");
        reporter.config().setReportName(reportName);
        reporter.config().setDocumentTitle("Test Result");

        ExtentReports extent= new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }


}
