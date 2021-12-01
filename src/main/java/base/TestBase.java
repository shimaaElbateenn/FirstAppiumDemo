package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.TestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static AppiumDriver driver;
    protected static Properties props;
    InputStream inputStream;

    public TestBase() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Parameters({"platformName", "platformVersion", "deviceName"})
    @BeforeTest
    public void beforeTest(String platformName, String platformVersion, String deviceName) throws IOException {
        props = new Properties();
        String propFileName = "config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        props.load(inputStream);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", platformName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("automationName", props.getProperty("androidAutomationName"));
        caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
        caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
     //   caps.setCapability("udid", "emulator-5556");
//        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");
        URL appUrl = getClass().getClassLoader().getResource(props.getProperty("androidApplication"));
        caps.setCapability("app", appUrl);

        driver = new AndroidDriver(new URL(props.getProperty("appiumURL")), caps);
     //   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void waitForVisibility(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(MobileElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void sendKeys(MobileElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public String getAttribute(MobileElement element, String attribute) {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
