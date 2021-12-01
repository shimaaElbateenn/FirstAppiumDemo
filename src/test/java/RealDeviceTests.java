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
import java.util.concurrent.TimeUnit;

public class RealDeviceTests {

    public AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator1");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("udid", "746235a");
          caps.setCapability("deviceName", "Redmi Note 7");
        caps.setCapability("appPackage", "com.miui.calculator");
        caps.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");

        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void testm() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MobileElement one = (MobileElement) driver.findElement(By.id("com.miui.calculator:id/btn_1_s"));
        MobileElement plus = (MobileElement) driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
        MobileElement two = (MobileElement) driver.findElement(By.id("com.miui.calculator:id/btn_2_s"));
        MobileElement equal = (MobileElement) driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
        MobileElement result = (MobileElement) driver.findElement(By.id("com.miui.calculator:id/expression"));
//        driver.findElement(By.id("btn_plus_s")).click();
//        driver.findElement(By.id("btn_2_s")).click();
        one.click();
        plus.click();
        two.click();
        equal.click();
        String res = result.getText();
        Assert.assertEquals(res, "4");
    }
}
