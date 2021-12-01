import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class InteractWithApp {
    public AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator1");
        caps.setCapability("platformVersion", "7.1.1");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("unicodeKeyboard", true);
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("unlockType", "pin");
        caps.setCapability("unlockKey", "1111");

        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void testm() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement one = (MobileElement) driver.findElement(By.id("digit_1"));
        MobileElement plus = (MobileElement) driver.findElement(By.id("op_add"));
        MobileElement two = (MobileElement) driver.findElement(By.id("digit_2"));
        MobileElement equal = (MobileElement) driver.findElement(By.id("eq"));
        MobileElement result = (MobileElement) driver.findElement(By.id("result"));
        one.click();
        plus.click();
        two.click();
        equal.click();
        String res = result.getText();
        Assert.assertEquals(res, "3");

        ((AndroidDriver) driver).lockDevice();
        ((AndroidDriver) driver).unlockDevice();

    }
}
