package pages;

import base.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class LoginPage extends TestBase {

    @AndroidFindBy (accessibility = "test-Username") private MobileElement editTextName;
    @AndroidFindBy (accessibility = "test-Password") private MobileElement editTextPaswd;
    @AndroidFindBy (accessibility = "test-LOGIN") private MobileElement btnLogin;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") private MobileElement errMsg;

    public LoginPage enterUserName(String name) {
        sendKeys(editTextName, name);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(editTextPaswd, password);
        return this;
    }

    public ProductPage clickBtn() {
        click(btnLogin);
        return new ProductPage();
    }

    public String getErrMsg() {
        return getAttribute(errMsg, "text");
    }
}
