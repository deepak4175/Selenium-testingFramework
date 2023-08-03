package pageObject.cartCheckout;

import baseManager.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver,10);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@id='userEmail']")
    private WebElement username;

    @FindBy(xpath="//input[@id=\"userPassword\"]")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login']")
    private WebElement submit;

    public void loginIntoApplication(String emailID,String Password){
        username.sendKeys(emailID);
        password.sendKeys(Password);
        submit.click();
    }
}
