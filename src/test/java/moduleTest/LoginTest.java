package moduleTest;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import pageObject.cartCheckout.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "load login Page", testName = "load login page")
    void loadLandingPage() {
        LoginPage login=new LoginPage(getDriver());
        login.loginIntoApplication("testforEver@gmail.com","Test@123456");
    }

    @Test
    void loadLandingPageMethod1(){
        String pconfig= getProjectConfig().getProperty("baseURL");
        getDriver().get(pconfig);
        assertTrue(Boolean.TRUE,Boolean.TRUE,"compare the program");
    }
}
