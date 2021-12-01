import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstAndroidTest {

    public AppiumDriver driver;
    public AndroidTouchAction touchAction;
    private TouchAction action;
    private By editText = MobileBy.id("edit");
    private By views = MobileBy.AccessibilityId("Views");
    private By grid = MobileBy.AccessibilityId("Grid");
    private By animation = MobileBy.AccessibilityId("Animation");
    private By textField = MobileBy.AccessibilityId("TextFields");
  //  private By webView2 = MobileBy.AccessibilityId("WebView2");
    private By title = MobileBy.xpath("//android.webkit.WebView/android.view.View[1]");


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator1");
        caps.setCapability("platformVersion", "7.1.1");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
        caps.setCapability("udid", "emulator-5554");
//        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");


        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void clickButtonTest() {
        MobileElement editTextName = (MobileElement) driver.findElementByAccessibilityId("test-Username");
        MobileElement editTextPaswd = (MobileElement) driver.findElementByAccessibilityId("test-Password");
        MobileElement btnLogin = (MobileElement) driver.findElementByAccessibilityId("test-LOGIN");

        editTextName.sendKeys("shimma");
        editTextPaswd.sendKeys("dhjssa");
        btnLogin.click();

        MobileElement errMsg = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");

        Assert.assertEquals(errMsg.getAttribute("text"), "Username and password do not match any user in this service.");
    }

    @Test
    public void clickViewsTest() throws InterruptedException {

        action = new TouchAction(driver);
        action.tap(ElementOption.element(driver.findElement(views))).perform();

        MobileElement webVi = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"WebView2\"))"));

        webVi.click();

    }


//    @AfterTest
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
