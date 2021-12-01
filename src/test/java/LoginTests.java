import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTests extends TestBase {
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void beforeTest() {
        loginPage = new LoginPage();
    }

    @Test
    public void invalidData() {
        loginPage.enterUserName("Shimaa");
        loginPage.enterPassword("shimaa");
        loginPage.clickBtn();
        Assert.assertEquals(loginPage.getErrMsg(), "Username and password do not match any user in this service.");
    }
}
