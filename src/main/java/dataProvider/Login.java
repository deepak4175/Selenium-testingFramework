package dataProvider;
import org.testng.annotations.DataProvider;
public class Login {


    @DataProvider(name = "LoginCredentials")
    Object[][] loginCredential(){
        return new Object[][]{{"test1","password1"},{"test2","pass2"}};
    }
}
